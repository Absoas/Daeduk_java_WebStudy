package kr.or.ddit.cor.myPage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//개인정보 수정
//로그인한 회원의 개인정보를 수정하기 위한 로직

@Controller
public class CorporationUpdateController {
	@RequestMapping("/common/mypage/updateInfo.do")
	public String getProcess(){
		return "";
	}
}
