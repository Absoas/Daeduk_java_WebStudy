package kr.or.ddit.visitor.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.mvc.annotation.CommandHandler;
import kr.or.ddit.mvc.annotation.URIMapping;
import kr.or.ddit.mvc.annotation.URIMapping.HttpMethod;
import kr.or.ddit.visitor.service.IVisitorService;
import kr.or.ddit.visitor.service.VisitorServiceImpl;
import kr.or.ddit.vo.VisitorVO;

@CommandHandler
public class VisitorDeleteController {
	
	@URIMapping(value="/visitor/visitorDelete.do" ,method=HttpMethod.POST)
	public String postProcess(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String vt_noStr = req.getParameter("vt_no");
		String vt_passStr = req.getParameter("vt_pass");
		
		if(!StringUtils.isNumeric(vt_noStr) || StringUtils.isBlank(vt_passStr)) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		
		VisitorVO visitor = new VisitorVO();
		visitor.setVt_no(Long.parseLong(vt_noStr));
		visitor.setVt_pass(vt_passStr);
		
		IVisitorService service = new VisitorServiceImpl();
		
		String view = null;
		Map<String, Object> message= new LinkedHashMap<>();
		

		ServiceResult result =  service.removeVisitor(visitor);
		if (ServiceResult.OK.equals(result)) {
			view = "visitor/visitorForm";
			return view;
		}else if(ServiceResult.INVALIDPASSWORD.equals(result)){
			message.put("message", "비밀번호 실패");
		}else {
			message.put("message", "실패");
		}
		
		resp.setContentType("application/json;charset=UTF-8");
		ObjectMapper mapper = new ObjectMapper();
		try(
			PrintWriter out = resp.getWriter();
		){
			mapper.writeValue(out, message);				
		}
		
		return null;
	}
}
