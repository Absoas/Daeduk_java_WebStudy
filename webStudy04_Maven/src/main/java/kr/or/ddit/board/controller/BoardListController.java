package kr.or.ddit.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.mvc.ICommandHandler;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.PagingInfoVO;
import kr.or.ddit.vo.ProdVO;

public class BoardListController implements ICommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// 페이징 처리
		// 검색 기능 ( 작성자  , 제목 , 내용AAR , 전체 )
		String searchWord = req.getParameter("searchWord");
		String searchType = req.getParameter("searchType");
		int currentPage = 1;
		
		String page = req.getParameter("page");
		if(StringUtils.isNumeric(page)) {
			currentPage = Integer.parseInt(page);
		}
		PagingInfoVO<BoardVO> pagingVO = new PagingInfoVO<>(5, 5);
		pagingVO.setCurrentPage(currentPage);
		pagingVO.setSearchWord(searchWord);
		pagingVO.setSearchType(searchType);
		
//		의존 객체 형성
		IBoardService service = new BoardServiceImpl();
		
		long totalRecord = service.retriveBoardCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		
		List<BoardVO> boardList =  service.retriveBoardList(pagingVO);
		pagingVO.setDataList(boardList);
		
		String accept = req.getHeader("Accept");
		if(StringUtils.containsIgnoreCase(accept, "json")) {
			// JSON
			resp.setContentType("application/json;charset=UTF-8");
			ObjectMapper mapper = new ObjectMapper();
			try(
				PrintWriter out = resp.getWriter();
			){
				mapper.writeValue(out, pagingVO);				
			}
			return null;
		}else {
			// HTML
			req.setAttribute("pagingVO", pagingVO);
			return "board/boardList";
		}
	}
}
