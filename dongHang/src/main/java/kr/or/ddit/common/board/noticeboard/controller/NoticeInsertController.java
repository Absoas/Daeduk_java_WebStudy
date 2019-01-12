package kr.or.ddit.common.board.noticeboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//공지게시판 작성 기능
//공지사항을 작성하기 위한 프로그램

@Controller
public class NoticeInsertController {
	@RequestMapping("/noticeboard/noticeboardInsert.do")
	public String getProcess(){
		return "";
	}
}
