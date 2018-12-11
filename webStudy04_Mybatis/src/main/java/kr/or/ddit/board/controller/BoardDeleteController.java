package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.mvc.annotation.CommandHandler;
import kr.or.ddit.mvc.annotation.URIMapping;
import kr.or.ddit.mvc.annotation.URIMapping.HttpMethod;
import kr.or.ddit.vo.BoardVO;

@CommandHandler
public class BoardDeleteController{

	@URIMapping(value="/board/boardDelete.do" ,method=HttpMethod.POST)
	public String process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String bo_noStr = req.getParameter("bo_no");
		String bo_passStr = req.getParameter("bo_pass");
		
		if(!StringUtils.isNumeric(bo_noStr) || StringUtils.isBlank(bo_passStr)) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		
		BoardVO board = new BoardVO(Long.parseLong(bo_noStr),bo_passStr);
		
		IBoardService service = new BoardServiceImpl();
		ServiceResult result =  service.removeBoard(board);
		
		String view = null;
		HttpSession session = req.getSession();
		
		switch (result) {
		case OK:
			view = "redirect:/board/boardList.do";
			break;
			
		case INVALIDPASSWORD:
			view = "redirect:/board/boardView.do?what="+bo_noStr;
			session.setAttribute("message", "비번 오류");
			break;

		default:
			view = "board/boardView.do?what="+bo_noStr;
			session.setAttribute("message", "서버 오류");
			break;
		}
		
		return view;
	}

}
