package kr.or.ddit.member.myCalendar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//일정등록
//회원의 일정을 추가하기 위한 로직

@Controller
public class MyCalendarInsertController {
	@RequestMapping("/member/mypage/calendarInsert.do")
	public String getProcess(){
		return "";
	}
}
