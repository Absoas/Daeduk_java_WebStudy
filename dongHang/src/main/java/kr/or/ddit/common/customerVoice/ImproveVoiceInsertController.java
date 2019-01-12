package kr.or.ddit.common.customerVoice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//개선의 소리글 등록 기능
//개선게시판에 신고글을 등록하는 로직

@Controller
public class ImproveVoiceInsertController {
	@RequestMapping("/customer/improveVoiceInsert.do")
	public String getProcess(){
		return "";
	}
}
