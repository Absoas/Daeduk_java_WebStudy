package kr.or.ddit.cor.myPage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//개인정보조회
//기업회원의 개인정보조회를 위한 로직

@Controller
public class CorporationRetrieveController {
	@RequestMapping("/cor/mypage/viewInfo.do")
	public String getProcess(){
		return "";
	}
}
