package kr.or.ddit.common.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.member.service.AuthenticateServiceImpl;
import kr.or.ddit.member.service.IAuthenticateService;
import kr.or.ddit.mvc.annotation.CommandHandler;
import kr.or.ddit.mvc.annotation.URIMapping;
import kr.or.ddit.mvc.annotation.URIMapping.HttpMethod;
import kr.or.ddit.utils.CookieUtil;
import kr.or.ddit.utils.CookieUtil.TextType;
import kr.or.ddit.vo.MemberVO;

@CommandHandler
public class LoginController {
	IAuthenticateService service = new AuthenticateServiceImpl();
	
	@URIMapping(value="/login/loginCheck.do", method=HttpMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response) {
		String mem_id = request.getParameter("mem_id");
		String mem_pass = request.getParameter("mem_pass");
		String idChecked = request.getParameter("idChecked");
		String goPage = null;
		HttpSession session = request.getSession();
		if(mem_id == null || mem_id.trim().length()==0 ||
				mem_pass == null || mem_pass.trim().length()==0){
			goPage = "redirect:/login/loginForm.jsp";
			session.setAttribute("message", "아이디나 비번 누락");
		}else{
			
			Object result = service.authenticate(new MemberVO(mem_id, mem_pass));
			if(result instanceof MemberVO){
				goPage = "redirect:/";
				session.setAttribute("authMember", result);
				int maxAge = 0;
				if("idSaved".equals(idChecked)){
					maxAge = 60*60*24*7;
				}
				Cookie idCookie = CookieUtil.createCookie("idCookie", mem_id, request.getContextPath(), TextType.PATH, maxAge);
				response.addCookie(idCookie);
			}else if(result == ServiceResult.PKNOTFOUND){
				goPage = "redirect:/login/loginForm.jsp";
				session.setAttribute("message", "존재하지 않는 회원");
			}else{
				goPage = "redirect:/login/loginForm.jsp";
				session.setAttribute("message", "비번 오류로 인증 실패");
			}
		}
		return goPage;
	}
	
	@URIMapping("/login/logout.do")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();	
		// 이동(index.jsp, redirect)
		return "redirect:/";
	}
}




























