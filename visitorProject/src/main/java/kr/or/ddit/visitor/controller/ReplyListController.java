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
<<<<<<< HEAD
		String page = req.getParameter("page");
=======
		String bo_noStr = req.getParameter("bo_no");
		String page = req.getParameter("page");
		if(!StringUtils.isNumeric(bo_noStr)) {
			resp.sendError(400);
			return null;
		}
>>>>>>> 64313d8565fb6e23b59dccc790c86ae00d160013
		
		long currentPage = 1;
		if(StringUtils.isNumeric(page)) {
			currentPage = Long.parseLong(page);
		}
		
		PagingInfoVO<VisitReplyVO> pagingVO = new PagingInfoVO<>();
		pagingVO.setCurrentPage(currentPage);
		
<<<<<<< HEAD
=======
		VisitReplyVO searchVO = new VisitReplyVO();
		searchVO.setVt_no(Long.parseLong(bo_noStr));
		pagingVO.setSearchVO(searchVO);
>>>>>>> 64313d8565fb6e23b59dccc790c86ae00d160013
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













