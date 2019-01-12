package kr.or.ddit.common.board.festivalboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//지역 축제 게시판 댓글 삭제
//지역 축제 게시글의 댓글을 삭제하기위한 로직

@Controller
public class FestivalDeleteReplyController {
	@RequestMapping("festival/reply/replyDelete.do")
	public String getProcess(){
		return "";
	}
}
