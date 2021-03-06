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
import kr.or.ddit.visitor.service.IReplyService;
import kr.or.ddit.visitor.service.ReplyServiceImpl;
import kr.or.ddit.vo.PagingInfoVO;
import kr.or.ddit.vo.VisitReplyVO;

@CommandHandler
public class ReplyListController{
	IReplyService replyService = new ReplyServiceImpl();
	
	@URIMapping("/reply/replyList.do")
	public String process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String page = req.getParameter("page");
		
		long currentPage = 1;
		if(StringUtils.isNumeric(page)) {
			currentPage = Long.parseLong(page);
		}
		
		PagingInfoVO<VisitReplyVO> pagingVO = new PagingInfoVO<>();
		pagingVO.setCurrentPage(currentPage);
		
		long totalRecord = replyService.retriveReplyCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		List<VisitReplyVO> replyList = replyService.retriveReplyList(pagingVO);
		pagingVO.setDataList(replyList);
		
		resp.setContentType("application/json;charset=UTF-8");
		ObjectMapper mapper = new ObjectMapper();
		try(
			PrintWriter out = resp.getWriter();	
		){
			mapper.writeValue(out, pagingVO);
		}
		
		return null;
	}

}













