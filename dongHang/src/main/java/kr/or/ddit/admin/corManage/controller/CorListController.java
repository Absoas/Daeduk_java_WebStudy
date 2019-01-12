package kr.or.ddit.admin.corManage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//모든 기업을 조회
//관리자가 모든 기업을 조회하는 프로그램

@Controller
public class CorListController {
	@RequestMapping("/admin/corList.do")
	public String getProcess(){
		return "";
	}
}
