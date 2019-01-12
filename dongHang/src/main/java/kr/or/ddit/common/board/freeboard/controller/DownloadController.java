package kr.or.ddit.common.board.freeboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DownloadController {
	@RequestMapping("/freeboard/download.do")
	public String getProcess(){
		return "";
	}
}
