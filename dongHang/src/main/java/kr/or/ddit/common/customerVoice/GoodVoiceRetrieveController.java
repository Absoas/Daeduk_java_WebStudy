package kr.or.ddit.common.customerVoice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//칭찬 소리글 조회 기능
//칭찬게시판의 칭찬글을 조회하기 위한 로직

@Controller
public class GoodVoiceRetrieveController {
	@RequestMapping("/customer/goodVoiceRetrieve.do")
	public String getProcess(){
		return "";
	}
}
