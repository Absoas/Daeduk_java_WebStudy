package kr.or.ddit.admin.corManage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//승인/미승인 여부 결정 기능
//관리자가 기업의 업체등록을 결정하는 프로그램

@Controller
public class CorApplyUpdateController {
	@RequestMapping("/admin/applyUpdate.do")
	public String getProcess(){
		return "";
	}
}
