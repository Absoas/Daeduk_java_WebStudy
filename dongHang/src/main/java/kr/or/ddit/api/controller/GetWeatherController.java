package kr.or.ddit.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//지역별 날씨 제공
//날씨 정보를 가져오는 메서드

@Controller
public class GetWeatherController {
	@RequestMapping("/weather/weather.do")
	public String getProcess(){
		return "";
	}
}
