package kr.or.ddit.common.board.festivalboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//지역축제 게시판 작성
//지역축제 게시판 입력을 위한 로직

@Controller
public class FestivalboardInsertController {
	@RequestMapping("/festivalboard/festivalboardInsert.do")
	public String getProcess(){
		return "";
	}
}
