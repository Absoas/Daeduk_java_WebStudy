package kr.or.ddit.common.board.qnaboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//QnA게시판 조회
//QnA게시판을 조회하기 위한 프로그램이다.

@Controller
public class QnARetrieveController {
	@RequestMapping("/qnaboard/qnaboardList.do")
	public String getProcess(){
		return "";
	}
}
