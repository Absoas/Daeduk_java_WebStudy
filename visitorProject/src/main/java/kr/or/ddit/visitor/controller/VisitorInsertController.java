package kr.or.ddit.visitor.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.security.Provider.Service;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.Mime;
import kr.or.ddit.ServiceResult;
import kr.or.ddit.mvc.annotation.CommandHandler;
import kr.or.ddit.mvc.annotation.URIMapping;
import kr.or.ddit.mvc.annotation.URIMapping.HttpMethod;
import kr.or.ddit.validator.GeneralValidator;
import kr.or.ddit.validator.InsertGroup;
import kr.or.ddit.visitor.service.IVisitorService;
import kr.or.ddit.visitor.service.VisitorServiceImpl;
import kr.or.ddit.vo.VisitorVO;

@CommandHandler
public class VisitorInsertController {
	
	IVisitorService service = new VisitorServiceImpl();
	
	@URIMapping(value="/visitor/visitorInsert.do", method=HttpMethod.GET)
	public String getProcess(HttpServletRequest req, HttpServletResponse resp) {
		return "visitor/visitorForm";
	}
	
	@URIMapping(value="/visitor/visitorInsert.do", method=HttpMethod.POST)
	public String postProcess(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		VisitorVO visitor = new VisitorVO();
		req.setAttribute("visitor", visitor);

		try {
			BeanUtils.populate(visitor, req.getParameterMap());
		}catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		
		GeneralValidator validator = new GeneralValidator();
		Map<String, List<CharSequence>> errors = new LinkedHashMap<>();
		Map<String, Object> message= new LinkedHashMap<>();
		
		req.setAttribute("errors", errors);
		boolean valid = validator.validate(visitor, errors, InsertGroup.class);
		
		String view = null;
		
		if(valid) {
			ServiceResult result = service.createVisitor(visitor);
			if(ServiceResult.OK.equals(result)) {
				view = "redirect:/visitor/visitorView.do";
				return view;
			}else {
				message.put("message", "실패");
			}
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
