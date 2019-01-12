package kr.or.ddit.signup.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//업체등록
//업체가 자신의 업체를 등록하는 프로그램

@Controller
public class CorSignUpController {
	@RequestMapping("/cor/corInsert.do")
	public String getProcess(){
		return "";
	}
}
