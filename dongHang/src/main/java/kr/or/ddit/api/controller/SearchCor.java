package kr.or.ddit.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//제휴업체 위치 검색
//제휴업체를 검색하기 위한 프로그램

@Controller
public class SearchCor {
	@RequestMapping("/map/searchCorpor.do")
	public String getProcess(){
		return "";
	}
}
