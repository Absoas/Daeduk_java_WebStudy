package kr.or.ddit.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//축제 정보 검색
//해당 지역의 축제 정보를 가져오는 메서드

@Controller
public class SearchFestival {
	@RequestMapping("/map/searchFestival.do")
	public String getProcess(){
		return "";
	}
}
