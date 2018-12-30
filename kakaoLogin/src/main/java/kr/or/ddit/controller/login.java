package kr.or.ddit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.JsonNode;

import kr.or.ddit.KakaoLogin;
import kr.or.ddit.vo.UserVO;

@Controller
public class login {
	
	@RequestMapping(value = "/login/oauth" , produces = "application/json", method = {RequestMethod.GET, RequestMethod.POST})
	public String kakaoLogin(@RequestParam("code") String code , HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{

	  JsonNode token = KakaoLogin.getAccessToken(code);
	  JsonNode profile = KakaoLogin.getKakaoUserInfo(token.path("access_token").toString());
	  System.out.println(profile);
	  UserVO vo = KakaoLogin.changeData(profile);
	  vo.setUser_id("k"+vo.getUser_id());

	  System.out.println(session);
	  session.setAttribute("login", vo);
	  System.out.println(vo.toString());

	  return "login/oauth";
	}
}
