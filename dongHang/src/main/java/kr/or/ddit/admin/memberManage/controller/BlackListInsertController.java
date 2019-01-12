package kr.or.ddit.admin.memberManage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//블랙 리스트 추가
//관리자가 블랙리스트 회원을 추가하는 프로그램

@Controller
public class BlackListInsertController {
	@RequestMapping("/admin/blackListInsert.do")
	public String getProcess(){
		return "";
	}
}
