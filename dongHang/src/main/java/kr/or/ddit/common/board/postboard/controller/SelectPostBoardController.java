package kr.or.ddit.common.board.postboard.controller;


import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.common.board.postboard.service.IBoardService;
import kr.or.ddit.vo.ReviewVO;
import kr.or.ddit.vo.PagingInfoVO;


//후기게시판 조회
//후기 게시판의 모든 후기조회를 위한 로직

@Controller
@RequestMapping("/postboard")
public class SelectPostBoardController {
	@Inject
	IBoardService service;
	@ResponseBody
	@RequestMapping(value="postboardRetrieve.do", produces="application/json;charset=UTF-8")
	public PagingInfoVO<ReviewVO> processAsync(
			@RequestParam(required=false) String searchType,	
			@RequestParam(required=false) String searchWord,
			@RequestParam(name="page", required=false, defaultValue="1") int currentPage
	){
		ReviewVO searchVO = new ReviewVO();
		if(StringUtils.isNotBlank(searchWord)) {
			if(StringUtils.isBlank(searchType)) {
				searchVO.setMem_id(searchWord);
				searchVO.setReview_title(searchWord);
				searchVO.setReview_content(searchWord);
			}else {
				switch (searchType) {
				case "writer":
					searchVO.setMem_id(searchWord);
					break;
				case "title":
					searchVO.setReview_title(searchWord);
					break;
				case "content":
					searchVO.setReview_content(searchWord);	
					break;
				}
			}			
		}
		
		PagingInfoVO<ReviewVO> pagingVO = new PagingInfoVO<>();
		pagingVO.setCurrentPage(currentPage);
		/* 검색 정보 */
		pagingVO.setSearchVO(searchVO);
		long totalRecord = service.retriveBoardCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		
		List<ReviewVO> boardList = service.retriveBoardList(pagingVO);
		pagingVO.setDataList(boardList);
		return pagingVO;
	}
	
	@RequestMapping(value="postboardRetrieve.do")
	public String process(
			@RequestParam(required=false) String searchType,	
			@RequestParam(required=false) String searchWord,
			@RequestParam(name="page", required=false, defaultValue="1") int currentPage,
			Model model
		) {
		PagingInfoVO<ReviewVO> pagingVO =
				processAsync(searchType, searchWord, currentPage);
		model.addAttribute("pagingVO", pagingVO);
		return "common/board/postboard/postboardList";
	}
	
	
	@RequestMapping("postboardView.do")
	public String process(
			@RequestParam(name="what", required=true) long board_no,
			Model model ){
		
		ReviewVO board = service.retriveBoard(board_no);
		
		model.addAttribute("board", board);
		
		return "common/board/postboard/postboardView";
	}
	
}
