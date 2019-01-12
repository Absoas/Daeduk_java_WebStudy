package kr.or.ddit.common.board.freeboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//자유게시판 삭제 기능
//자유게시판의 게시글을 삭제하기 위한 로직

@Controller
public class FreeboardDeleteController {
	@RequestMapping("/freeboard/freeboardDelete.do")
	public String getProecess(){
		return "";
	}
}
