package kr.or.ddit.common.board.noticeboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//공지게시판 조회 기능
//공지사항을 조회하기 위한 프로그램

@Controller
public class NoticeRetrieveController {
	@RequestMapping("/noticeboard/noticeboardRetrieve.do")
	public String getProcess(){
		return "";
	}
}
