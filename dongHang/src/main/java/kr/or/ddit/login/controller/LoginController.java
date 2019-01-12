package kr.or.ddit.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//로그인
//일반회원 또는 기업회원 선택 후 로그인할 수 있는 로직

@Controller
public class LoginController {
	
	@RequestMapping("/login/loginCheck.do")
	public String getProcess(){
		return "";
	}
}
