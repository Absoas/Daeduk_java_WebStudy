package kr.or.ddit.common.board.suggestboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//건의 게시판 수정 기능
//건의게시판에 게시글을 수정하는 로직

@Controller
public class SuggestboardUpdateController {
	@RequestMapping("/suggestboard/suggestboardUpdate.do")
	public String getProcess(){
		return "";
	}
}