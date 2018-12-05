package kr.or.ddit.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.board.service.IReplyService;
import kr.or.ddit.board.service.ReplyServiceImpl;
import kr.or.ddit.mvc.ICommandHandler;
import kr.or.ddit.vo.PagingInfoVO;
import kr.or.ddit.vo.ReplyVO;

public class ReplyListController implements ICommandHandler{
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String bo_noStr = req.getParameter("bo_no");
		String page = req.getParameter("page");
		
		if(!StringUtils.isNumeric(bo_noStr)) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		
		long currentPage = 1;
		
		if(StringUtils.isNumeric(page)) {
			currentPage = Long.parseLong(page);
		}
		
		
		ReplyVO searchVO = new ReplyVO();
		
		PagingInfoVO<ReplyVO> pagingVO = new PagingInfoVO<>(5,2);
		pagingVO.setCurrentPage(currentPage);
		searchVO.setBo_no(Long.parseLong(bo_noStr));
		pagingVO.setSearchVO(searchVO);
		IReplyService replyService = new ReplyServiceImpl();
		long totalRecord = replyService.retriveReplyCount(pagingVO);
		pagingVO.setTotalPage(totalRecord);
		List<ReplyVO> replyList = replyService.retriveReplyList(pagingVO);
		pagingVO.setDataList(replyList);
		
		resp.setContentType("application/json;charset=UTF-8");
		ObjectMapper mapper = new ObjectMapper();
		
		try(
			PrintWriter out = resp.getWriter();
		)
		{
			mapper.writeValue(out, pagingVO);
		}
		return null;
	}
}
