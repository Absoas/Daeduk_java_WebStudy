package kr.or.ddit.alba.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.alba.service.IAlbaService;
import kr.or.ddit.vo.AlbaVO;
import kr.or.ddit.vo.PagingInfoVO;

@Controller
public class AlbaRetrieveController {

	@Inject
	IAlbaService service;
	
	@ResponseBody
	@RequestMapping(value = "/alba/albaList.do" , method=RequestMethod.GET, produces="application/json;charset=UTF-8")
	public PagingInfoVO<AlbaVO> getProcess(
			@RequestParam(required=false) String searchType,	
			@RequestParam(required=false) String searchWord,
			@RequestParam(name="page", required=false, defaultValue="1") int currentPage
		){
		
		PagingInfoVO<AlbaVO> pagingVO = new PagingInfoVO<>(5, 2);
		pagingVO.setCurrentPage(currentPage);
		pagingVO.setSearchWord(searchWord);
		pagingVO.setSearchType(searchType);
		
		long totalRecord = service.retrieveAlbaCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		
		List<AlbaVO> albaList =  service.retrieveAlbaList(pagingVO);
		pagingVO.setDataList(albaList);
		
		return pagingVO;
	}
	
	@RequestMapping(value="/alba/albaList.do")
	public String process(
			@RequestParam(required=false) String searchType,	
			@RequestParam(required=false) String searchWord,
			@RequestParam(name="page", required=false, defaultValue="1") int currentPage,
			Model model
		) {
		PagingInfoVO<AlbaVO> pagingVO =
				getProcess(searchType, searchWord, currentPage);
		model.addAttribute("pagingVO", pagingVO);
		return "alba/albaList";
	}
	
	
	@RequestMapping("/alba/albaView.do")
	public String process(
			@RequestParam(name="who", required=true) String alba_code,
			Model model ){
		
		AlbaVO alba = service.retrieveAlba(alba_code);
		model.addAttribute("alba", alba);
		return "alba/albaView";
	}
	
	
}
