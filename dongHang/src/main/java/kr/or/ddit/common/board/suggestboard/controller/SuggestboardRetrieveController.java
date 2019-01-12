package kr.or.ddit.common.board.suggestboard.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.common.board.suggestboard.service.ISuggestBoardService;
import kr.or.ddit.vo.SuggestBoardVO;

//건의 게시판 조회 기능
//건의게시판의 게시글을 조회하는 로직

@Controller
public class SuggestboardRetrieveController {
	
	@Inject
	ISuggestBoardService service;
	
	@RequestMapping("/suggest/suggestList.do")
	public String getProcess(Model model){
		
		List<SuggestBoardVO> suggestList =  service.suggestList();
		model.addAttribute("suggestList", suggestList);
		
		return "common/board/suggestboard/suggestboardList";
	}
	

	@RequestMapping("/suggest/suggestView.do")
	public String getProcess(Model model,long bo_no){
		
		SuggestBoardVO suggest =  service.suggestSelect(bo_no);
		model.addAttribute("suggest", suggest);
		
		return "common/board/suggestboard/suggestboardView";
	}
	
}
