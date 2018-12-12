package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.mvc.annotation.CommandHandler;
import kr.or.ddit.mvc.annotation.URIMapping;
import kr.or.ddit.mvc.annotation.URIMapping.HttpMethod;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.web.calculate.Mime;

@CommandHandler
public class BoardRcmdController {

	@URIMapping(value="/board/boardRcmd.do" ,method=HttpMethod.GET)
	public String process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		String bo_noStr = req.getParameter("bo_no");
		
		if(!StringUtils.isNumeric(bo_noStr)) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		
		IBoardService service= new BoardServiceImpl();
		BoardVO board =  service.incrementRCMD(Long.parseLong(bo_noStr));
		
		ObjectMapper mapper = new ObjectMapper();
		resp.setContentType(Mime.JSON.getContentType());
		mapper.writeValue(resp.getWriter(), board);
		
		return null;
	};
}
