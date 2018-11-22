package kr.or.ddit.buyer.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.CommonException;
import kr.or.ddit.ServiceResult;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

//@WebServlet("/member/memberUpdate.do")
public class BuyerUpdateServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 검증 
		// 불통 : memberView.jsp -> 기존 입력 데이터, 뭐때문에 통과하지 못했냐는 에러메시지
		// 수정 하기 위해서 의존 객체 형성
		// 로직선택
		// ServiceResult 형식으로 들어온다.
		// invalid ok faild
		// invalid -> 비번이 틀렸으면 memberView -> 기존 입력 데이터 , 에러 메시지
		// faild   -> 수정 버튼 	  memberView -> 기존 입력 데이터, 에러 메시지
		// OK 	   -> memberView -> redirect
		
		req.setCharacterEncoding("UTF-8");
		MemberVO member = new MemberVO();
		req.setAttribute("member", member);
		
		try {
			BeanUtils.populate(member,  req.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new CommonException(e);
		}
		
		String goPage = null;
		boolean redirect = false;
		String message = null;
		
		Map<String, String> errors = new LinkedHashMap<>();
		req.setAttribute("errors", errors);
		
		boolean valid = validate(member, errors);

		if (valid) {
			IMemberService service = new MemberServiceImpl();
			ServiceResult result = service.modifyMember(member);
			
			switch (result) {
			case INVALIDPASSWORD:
				goPage = "/WEB-INF/views/member/memberView.jsp";
				message = "패스워드가 틀렸습니다. ";
				break;
			case FAILED:
				goPage = "/WEB-INF/views/member/memberView.jsp";
				message = "서버 오류로 인한 실패, 잠시 후 다시 시도";
				break;
			case OK:
				goPage = "/member/mypage.do";
				redirect = true;
				break;
			}
			req.setAttribute("message", message);
		} else {
			goPage = "/WEB-INF/views/member/memberForm.jsp";
		}

		if (redirect) {
			resp.sendRedirect(req.getContextPath()+goPage);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher(goPage);
			rd.forward(req, resp);
		}
	}
	
	private boolean validate(MemberVO member, Map<String, String> errors){
	      boolean valid = true;
	    	if (StringUtils.isBlank(member.getMem_id())) {
				valid = false;
				errors.put("mem_id", "회원아이디 누락");
			}
			if (StringUtils.isBlank(member.getMem_pass())) {
				valid = false;
				errors.put("mem_pass", "비밀번호 누락");
			}
			if (StringUtils.isBlank(member.getMem_name())) {
				valid = false;
				errors.put("mem_name", "회원명 누락");
			}
			if (StringUtils.isBlank(member.getMem_zip())) {
				valid = false;
				errors.put("mem_zip", "우편번호 누락");
			}
			if (StringUtils.isBlank(member.getMem_add1())) {
				valid = false;
				errors.put("mem_add1", "주소1 누락");
			}
			if (StringUtils.isBlank(member.getMem_add2())) {
				valid = false;
				errors.put("mem_add2", "주소2 누락");
			}
			if (StringUtils.isBlank(member.getMem_mail())) {
				valid = false;
				errors.put("mem_mail", "이메일 누락");
			}
			
			if(StringUtils.isNotBlank(member.getMem_bir())){
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				// formatting	:	특정 타입의 데이터를 일정 형식의 문자열로 변환.
				// parsing : 일정한 형식의 문자열을 특정 타입의 데이터로 변환.
				try{
					formatter.parse(member.getMem_bir());
				}catch(ParseException e){
					valid = false;
					errors.put("mem_bir", "날짜 형식 확인");
				}
			}
			return valid;
	}
}
