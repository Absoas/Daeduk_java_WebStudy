package kr.or.ddit.visitor.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.Mime;
import kr.or.ddit.ServiceResult;
import kr.or.ddit.mvc.annotation.CommandHandler;
import kr.or.ddit.mvc.annotation.URIMapping;
import kr.or.ddit.mvc.annotation.URIMapping.HttpMethod;
import kr.or.ddit.visitor.service.IReplyService;
import kr.or.ddit.visitor.service.ReplyServiceImpl;
import kr.or.ddit.vo.VisitReplyVO;

@CommandHandler
public class ReplyInsertController{
	IReplyService service = new ReplyServiceImpl();

	@URIMapping(value="/reply/replyInsert.do", method=HttpMethod.POST)
	public String process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		VisitReplyVO reply = new VisitReplyVO(); // command object
		try {
			BeanUtils.populate(reply, req.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		
		Map<String, String> errors = new LinkedHashMap<>();
		boolean valid = validate(reply, errors);
		if(valid) {
			ServiceResult result = service.createReply(reply);
			if(ServiceResult.OK.equals(result)) {
				// 성공  
//				return "redirect:/reply/replyList.do?bo_no=" + reply.getBo_no();
			}else {
				// 실패
				errors.put("error", "true");
				errors.put("message", "서버 오류, 쫌따 다시");
			}
		}else {
			// 검증 실패
			errors.put("error", "true");
			errors.put("message", "검증 실패, 데이터 오류 확인");
		}
		
		ObjectMapper mapper = new ObjectMapper();
		resp.setContentType(Mime.JSON.getContentType());
		mapper.writeValue(resp.getWriter(), errors);
		
		return null;
	}

	private boolean validate(VisitReplyVO reply, Map<String, String> errors) {
		boolean valid = true;

		if (StringUtils.isBlank(reply.getRep_writer())) {
			valid = false;
			errors.put("rep_writer", "덧글작성자 누락");
		}
		if (StringUtils.isBlank(reply.getRep_ip())) {
			valid = false;
			errors.put("rep_ip", "작성자IP 누락");
		}
		if (StringUtils.isBlank(reply.getRep_pass())) {
			valid = false;
			errors.put("rep_pass", "비밀번호 누락");
		}
		if(reply.getRep_content()!=null && reply.getRep_content().length()>100) {
			valid = false;
			errors.put("rep_content", "내용의 길이는 100글자 미만");
		}
		return valid;
	}

}

















