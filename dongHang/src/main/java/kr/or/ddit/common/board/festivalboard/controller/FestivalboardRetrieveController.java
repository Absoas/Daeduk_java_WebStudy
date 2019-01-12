package kr.or.ddit.common.board.festivalboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//지역축제 게시판 조회
//지역축제 게시글을 조회하기 위한 로직

@Controller
public class FestivalboardRetrieveController {
	@RequestMapping("/festival/festivalRetrieve.do")
	public String getProcess(){
		return "common/board/festivalboard/festivalboardList";
	}
}
