package kr.or.ddit.visitor.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.filter.wrapper.FileUploadRequestWrapper;
import kr.or.ddit.mvc.annotation.CommandHandler;
import kr.or.ddit.mvc.annotation.URIMapping;
import kr.or.ddit.mvc.annotation.URIMapping.HttpMethod;
import kr.or.ddit.visitor.service.IVisitorService;
import kr.or.ddit.visitor.service.VisitorServiceImpl;
import kr.or.ddit.vo.VisitorVO;

@CommandHandler
public class ImageUpdateController {

	IVisitorService service = new VisitorServiceImpl();
	
	@URIMapping(value="/visitor/visitorUpdate.do", method=HttpMethod.POST)
	public String postProcess(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		Map<String, Object> message= new LinkedHashMap<>();
		String view = null;
		
		VisitorVO visitor = new VisitorVO();
		
		String vt_noStr = req.getParameter("vt_no");
		String vt_noPass = req.getParameter("vt_pass");
		
		if(!StringUtils.isNumeric(vt_noStr) || StringUtils.isBlank(vt_noPass)) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		
		visitor.setVt_no(Long.parseLong(vt_noStr));
		visitor.setVt_pass(vt_noPass);
		
		ServiceResult result = null;
		
		if(req instanceof FileUploadRequestWrapper) {
			FileItem fileItem = ((FileUploadRequestWrapper) req).getFileItem("vt_file");
			if (fileItem != null) {
				if (!fileItem.getContentType().contains("image/")) {
					message.put("message", "이미지만 등록 가능합니다.");
				} else {
					visitor.setVt_img(fileItem.get());
					result = service.modifyVisitor(visitor);

					if (ServiceResult.OK.equals(result)) {
						view = "redirect:/visitor/visitorView.do";
						return view;
					} else if(ServiceResult.INVALIDPASSWORD.equals(result)) {
						message.put("message", "비밀번호 오류");
					}else {
						message.put("message", "실패");
					}
				}
			}else {
				message.put("message", "파일을 등록해주세요");
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
