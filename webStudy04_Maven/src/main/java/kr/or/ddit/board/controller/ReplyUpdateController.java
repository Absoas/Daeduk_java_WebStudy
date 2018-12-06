package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.board.service.IReplyService;
import kr.or.ddit.board.service.ReplyServiceImpl;
import kr.or.ddit.mvc.ICommandHandler;
import kr.or.ddit.vo.ReplyVO;
import kr.or.ddit.web.calculate.Mime;

public class ReplyUpdateController implements ICommandHandler{
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String rep_writerStr = req.getParameter("rep_writer");
		String rep_contentStr =  req.getParameter("rep_content");
		String rep_noStr =  req.getParameter("rep_no");
		
		if(!StringUtils.isNumeric(rep_noStr) || StringUtils.isBlank(rep_contentStr) || StringUtils.isBlank(rep_writerStr)) {
			resp.sendError(400);
			return null;
		}
		
		ReplyVO reply = new ReplyVO();
		reply.setRep_writer(rep_writerStr);
		reply.setRep_content(rep_contentStr);
		reply.setRep_no(Long.parseLong(rep_noStr));
		
		
		ServiceResult result = null;
		IReplyService service = new ReplyServiceImpl();
		Map<String, String> errors = new LinkedHashMap<>();
		result =  service.modifyReply(reply);
		boolean valid = false;
		String view = null;
		switch (result) {
		case OK:
			view = "redirect:/reply/replyList.do?bo_no=" + reply.getBo_no();
			break;
		
		case INVALIDPASSWORD:
			valid = true;
			errors.put("error", "true");	
			errors.put("message", "패스워드가 틀립니다.");	
			break;


		default:
			valid = true;
			errors.put("error", "true");	
			errors.put("message", "서버 오류");	
			break;
		}
		
		if(valid) {
			resp.setContentType(Mime.JSON.getContentType());
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(resp.getWriter(), errors);
		}
		
		return view;
	}
}
