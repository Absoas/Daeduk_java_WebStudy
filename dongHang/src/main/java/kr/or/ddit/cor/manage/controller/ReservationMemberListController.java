package kr.or.ddit.cor.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//여행 상품별 고객 리스트
//업체가 자신의 여행 상품의 고객 리스트를 보여주는 프로그램

@Controller
public class ReservationMemberListController {
	@RequestMapping("/cor/reservationMemberList.do")
	public String getProcess(){
		return "";
	}
}
