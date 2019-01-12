package kr.or.ddit.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//지역별 미세먼지 농도 제공
//전 지역의 미세먼지 농도 정보를 가져오는 프로그램

@Controller
public class GetAirController {
	@RequestMapping("/weather/air.do")
	public String getProcess(){
		return "";
	}
}
