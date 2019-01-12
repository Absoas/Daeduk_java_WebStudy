package kr.or.ddit.common.customerVoice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//개선의 소리글 조회 기능
//개선게시판의 신고글을 조회하는 로직

@Controller
public class ImproveVoiceRetrieveController {
	@RequestMapping("/customer/improveVoiceRetrieve.do")
	public String getProcess(){
		return "";
	}
}
