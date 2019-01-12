package kr.or.ddit.admin.crewManage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//모든 크루 조회
//관리자가 모든 크루를 조회하는 프로그램

@Controller
public class CrewForceListController {
	@RequestMapping("/admin/crewList.do")
	public String getProcess(){
		return "";
	}
}
