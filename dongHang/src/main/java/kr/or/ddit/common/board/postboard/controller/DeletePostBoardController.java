package kr.or.ddit.common.board.postboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//후기게시판 삭제
//후기를 삭제하기 위한 로직

@Controller
public class DeletePostBoardController {
	@RequestMapping("/postboard/postboardDelete.do")
	public String getProcess(){
		return "";
	}
}
