package kr.or.ddit.common.board.noticeboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//공지게시판 삭제 기능
//공지사항을 삭제하기 위한 프로그램

@Controller
public class NoticeDeleteController {
	@RequestMapping("/noticeboard/noticeboardDelete.do")
	public String getProcess(){
		return "";
	}
}
