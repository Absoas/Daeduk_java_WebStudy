package kr.or.ddit.admin.memberManage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 등급 부여
// 관리자가 모든 회원의 등급을 부여할 수 있는 프로그램

@Controller
public class MemberForceUpdateController {
	@RequestMapping("/admin/memberUpdate.do")
	public String getProcess(){
		return "";
	}
}
