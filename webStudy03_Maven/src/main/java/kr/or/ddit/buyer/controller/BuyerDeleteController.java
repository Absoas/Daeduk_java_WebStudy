//package kr.or.ddit.buyer.controller;
//
//import java.io.IOException;
//import java.lang.reflect.InvocationTargetException;
//import java.text.SimpleDateFormat;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.beanutils.BeanUtils;
//import org.apache.commons.lang3.StringUtils;
//
//import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
//
//import kr.or.ddit.CommonException;
//import kr.or.ddit.ServiceResult;
//import kr.or.ddit.buyer.service.BuyerServiceImpl;
//import kr.or.ddit.buyer.service.IBuyerService;
//import kr.or.ddit.member.service.IMemberService;
//import kr.or.ddit.member.service.MemberServiceImpl;
//import kr.or.ddit.mvc.ICommandHandler;
//import kr.or.ddit.vo.MemberVO;
//
//public class BuyerDeleteController implements ICommandHandler{
//	
//	@Override
//	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
//		String mem_id = req.getParameter("mem_id");
//		String mem_pass = req.getParameter("mem_pass");
//
//		if(StringUtils.isBlank(mem_id)|| StringUtils.isBlank(mem_pass)) {
//			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
//			return null;
//		}
//
//		IBuyerService service = new BuyerServiceImpl();
//		ServiceResult result = service.removeBuyer();
//		String goPage = null;
//		String message = null;
//		
//		switch (result) {
//		case INVALIDPASSWORD:
////			goPage = "/member/memberView.do?who="+mem_id;
//			goPage = "redirect:/member/mypage.do";
//			message = "비밀번호 틀림";
//			break;
//		
//		case FAILED:
////			goPage = "/member/memberView.do?who="+mem_id;
//			goPage = "redirect:/member/mypage.do";
//			message = "서버 오류";
//			break;
//			
//		case OK:
////			goPage = "/member/memberList.do";
//			goPage = "redirect:/common/message.jsp";
//			message = "탈퇴 약관 : 일주일 이내에서 즐대!! 같은 아이디로 재가입 불가";
//			req.getSession().setAttribute("goLink", "/");
//			req.getSession().setAttribute("isRemoved", new Boolean(true));
//			break;
//		}
//		req.getSession().setAttribute("message", message);
//		
//		return goPage;
//	}
//
//}