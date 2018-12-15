package kr.or.ddit.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.mvc.annotation.CommandHandler;
import kr.or.ddit.mvc.annotation.URIMapping;
import kr.or.ddit.vo.BoardVO;

@CommandHandler
public class BoardViewController{
	IBoardService service = new BoardServiceImpl();

	@URIMapping("/board/boardView.do")
	public String process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String bo_no = req.getParameter("what");
		if(!StringUtils.isNumeric(bo_no)) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		long num = Long.parseLong(bo_no);
		
		BoardVO board = service.retriveBoard(num);
		
		req.setAttribute("board", board);
		
		return "board/boardView";
	}
}














