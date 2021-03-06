package kr.or.ddit.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.board.service.IReplyService;
import kr.or.ddit.board.service.ReplyServiceImpl;
import kr.or.ddit.mvc.annotation.CommandHandler;
import kr.or.ddit.mvc.annotation.URIMapping;
import kr.or.ddit.mvc.annotation.URIMapping.HttpMethod;
import kr.or.ddit.vo.ReplyVO;

@CommandHandler
public class ReplyDeleteController{
	IReplyService service = new ReplyServiceImpl();
	
	@URIMapping(value="/reply/replyDelete.do", method=HttpMethod.POST)
	public String process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String rep_noStr = req.getParameter("rep_no");
		String rep_pass = req.getParameter("rep_pass");
		String bo_noStr = req.getParameter("bo_no");
		if(!StringUtils.isNumeric(rep_noStr) || 
				StringUtils.isBlank(rep_pass) || 
				! StringUtils.isNumeric(bo_noStr)) {
			resp.sendError(400);
			return null;
		}
		// 자바빈의 setter 를 통해 객체의 상태를 설정 - JavaBean Pattern -> Builder Pattern
		ReplyVO reply = new ReplyVO();
		reply.setRep_no(Long.parseLong(rep_noStr));
		reply.setBo_no(Long.parseLong(bo_noStr));
		reply.setRep_pass(rep_pass);
		
		
		ServiceResult result = service.removeReply(reply);
		String view = null;
		Map<String, String> errors = new HashMap<>();
		boolean requiredMarshalling = false;
		switch(result) {
			case OK:
				view = "redirect:/reply/replyList.do?bo_no="+reply.getBo_no();
				break;
			case INVALIDPASSWORD:
				errors.put("error", "true");
				errors.put("message", "비밀번호 오류");
				requiredMarshalling = true;
				break;
			default: // FAILED
				errors.put("error", "true");
				errors.put("message", " 서버 오류, 쫌따 다시 ");
				requiredMarshalling = true;
		}
		
		if(requiredMarshalling) {
			resp.setContentType("application/json;charset=UTF-8");
			ObjectMapper mapper= new ObjectMapper();
			try(
					PrintWriter out = resp.getWriter();
					){
				mapper.writeValue(out, errors);
			}
		}
		
		return view;
	}

}

















