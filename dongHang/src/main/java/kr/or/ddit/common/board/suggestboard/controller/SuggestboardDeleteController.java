package kr.or.ddit.common.board.suggestboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//건의 게시판 삭제 기능
//건의게시판의 게시글을 삭제하는 로직

@Controller
public class SuggestboardDeleteController {
	@RequestMapping("/suggestboard/suggestboardDelete.do")
	public String getProcess(){
		return "";
	}
}
