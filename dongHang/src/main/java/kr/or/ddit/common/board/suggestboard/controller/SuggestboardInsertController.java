package kr.or.ddit.common.board.suggestboard.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.common.board.suggestboard.service.ISuggestBoardService;
import kr.or.ddit.vo.SuggestBoardVO;

//건의 게시판 등록 기능
//건의게시판에 게시글을 등록하는 로직

@Controller
@RequestMapping("/suggestboard/suggestboardInsert.do")
public class SuggestboardInsertController {
	@Inject
	ISuggestBoardService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getProcess(){
		return "common/board/suggestboard/suggestboardForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String postProcess(SuggestBoardVO sbVO){
		
		service.createSuggest(sbVO);
		
		return "common/board/suggestboard/suggestboardForm";
	}
	
	
}
