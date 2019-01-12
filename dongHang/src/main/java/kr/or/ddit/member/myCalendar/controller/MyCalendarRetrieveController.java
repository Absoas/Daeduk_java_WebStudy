package kr.or.ddit.member.myCalendar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//일정조회
//등록한 일정을 조회하기 위한 로직

@Controller
public class MyCalendarRetrieveController {
	@RequestMapping("/member/mypage/calendarRetrieve.do")
	public String getProcess(){
		return "";
	}
}
