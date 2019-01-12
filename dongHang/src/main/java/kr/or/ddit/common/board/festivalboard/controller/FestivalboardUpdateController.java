package kr.or.ddit.common.board.festivalboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//지역축제 게시판 수정
//지역축제 게시글 수정을 위한 로직

@Controller
public class FestivalboardUpdateController {
	@RequestMapping("/festivalboard/festivalboardUpdate.do")
	public String getProcess(){
		return "";
	}
}
