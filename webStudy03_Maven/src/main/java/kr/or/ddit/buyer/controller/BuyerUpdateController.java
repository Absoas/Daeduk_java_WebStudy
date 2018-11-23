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
import kr.or.ddit.buyer.service.BuyerServiceImpl;
import kr.or.ddit.buyer.service.IBuyerService;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mvc.ICommandHandler;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.MemberVO;

//@WebServlet("/member/memberUpdate.do")
public class BuyerUpdateController implements ICommandHandler{
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BuyerVO buyer = new BuyerVO();
		req.setAttribute("member", buyer);
		
		try {
			BeanUtils.populate(buyer,  req.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new CommonException(e);
		}
		
		String goPage = null;
		String message = null;
		
		Map<String, String> errors = new LinkedHashMap<>();
		req.setAttribute("errors", errors);
		
		boolean valid = validate(buyer, errors);

		if (valid) {
			IBuyerService service = new BuyerServiceImpl();
			ServiceResult result = service.modifyBuyer(buyer);
			
			switch (result) {
			case INVALIDPASSWORD:
				goPage = "member/memberView";
				message = "패스워드가 틀렸습니다. ";
				break;
			case FAILED:
				goPage = "member/memberView";
				message = "서버 오류로 인한 실패, 잠시 후 다시 시도";
				break;
			case OK:
				goPage = "redirect:/member/mypage.do";
				break;
			}
			req.setAttribute("message", message);
		} else {
			goPage = "member/memberForm";
		}

		return goPage;
	}
	
	private boolean validate(BuyerVO buyer, Map<String, String> errors){
	     return false;
	}
}
