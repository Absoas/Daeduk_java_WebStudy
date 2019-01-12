package kr.or.ddit.common.board.freeboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//자유게시판 수정
//게시글을 수정하기 위한 로직

@Controller
public class FreeboardUpdateController {
	@RequestMapping("/freeboard/freeboardUpdate.do")
	public String getProcess(){
		return "";
	}
}
