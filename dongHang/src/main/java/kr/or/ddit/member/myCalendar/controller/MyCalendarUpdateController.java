package kr.or.ddit.member.myCalendar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//일정수정
//등록한 일정을 수정하기 위한 로직

@Controller
public class MyCalendarUpdateController {
	@RequestMapping("/member/mypage/calendarUpdate.do")
	public String getProcess(){
		return "";
	}
}
