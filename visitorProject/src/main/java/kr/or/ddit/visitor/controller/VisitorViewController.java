package kr.or.ddit.visitor.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.mvc.annotation.CommandHandler;
import kr.or.ddit.mvc.annotation.URIMapping;
import kr.or.ddit.visitor.service.IVisitorService;
import kr.or.ddit.visitor.service.VisitorServiceImpl;
import kr.or.ddit.vo.PagingInfoVO;
import kr.or.ddit.vo.VisitorVO;

@CommandHandler
public class VisitorViewController {
	IVisitorService service = new VisitorServiceImpl();
	
	@URIMapping("/visitor/visitorView.do")
	public String process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String page = req.getParameter("page");
		
		VisitorVO visitorVO = new VisitorVO();
		
		long currentPage = 1;
		if(StringUtils.isNumeric(page)) {
			currentPage = Long.parseLong(page);
		}
		
		PagingInfoVO<VisitorVO> pagingVO = new PagingInfoVO<>(5,2);
		pagingVO.setCurrentPage(currentPage);
		
		long totalRecord = service.retriveVisitorCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord);

		List<VisitorVO> visitorList = service.retriveVisitorList(pagingVO);
		req.setAttribute("visitorList", visitorList);
		
		pagingVO.setDataList(visitorList);
		
		resp.setContentType("application/json;charset=UTF-8"); 
		ObjectMapper mapper = new ObjectMapper();
		try(
			PrintWriter out = resp.getWriter();
		){
			mapper.writeValue(out, pagingVO);				
			return null;
		}
	}
}
