package kr.or.ddit.common.board.tipboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//여행 팁게시판 수정
//여행 팁게시글을 수정하기 위한 로직

@Controller
public class TipBoardUpdateController {
	@RequestMapping("/tipboard/tipboardUpdate.do")
	public String getProcess(){
		return "";
	}
}
