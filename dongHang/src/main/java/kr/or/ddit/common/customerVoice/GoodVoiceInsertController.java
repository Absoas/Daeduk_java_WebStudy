package kr.or.ddit.common.customerVoice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//칭찬 소리글 등록 기능
//칭찬게시판에 게시글을 등록하는 로직

@Controller
public class GoodVoiceInsertController {
	@RequestMapping("/customer/goodVoiceInsert.do")
	public String getProcess(){
		return "";
	}
}
