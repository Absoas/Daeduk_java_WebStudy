package kr.or.ddit.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.board.BoardException;
import kr.or.ddit.board.service.IReplyService;
import kr.or.ddit.board.service.ReplyServiceImpl;
import kr.or.ddit.mvc.ICommandHandler;
import kr.or.ddit.vo.ReplyVO;
import kr.or.ddit.web.calculate.Mime;

public class ReplyDeleteController implements ICommandHandler {

   @Override
   public String process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
      
      String rep_noStr = req.getParameter("rep_no");
      String rep_pass = req.getParameter("rep_pass");
      String bo_noStr = req.getParameter("bo_no");
      
      if(!StringUtils.isNumeric(rep_noStr) || StringUtils.isBlank(rep_pass) || !StringUtils.isNumeric(bo_noStr)) {
         resp.sendError(400);
         return null;
      }
      // 자바 빈의 setter를 통해 객체의 상태를 설정 - JavaBean Pattern
      ReplyVO reply = new ReplyVO();
      reply.setRep_no(Long.parseLong(rep_noStr));
      reply.setBo_no(Long.parseLong(bo_noStr));
      reply.setRep_pass(rep_pass);
      
      IReplyService service = new ReplyServiceImpl();
      Map<String, String> errors = new LinkedHashMap<>();
      ServiceResult result =  service.removeReply(reply);
      String view = null;
      boolean requiredmarshalling = false;

      switch (result) {
		case OK:
			view="redirect:/reply/replyList.do?bo_no="+reply.getBo_no();
			return view;
	
		case INVALIDPASSWORD:
			errors.put("error", "true");
			errors.put("message", "비밀번호 오류");
			requiredmarshalling = true;
			break;

		default:
			errors.put("error", "true");
			errors.put("message", "서버 오류, 나중에 다시 ");
			requiredmarshalling = true;
			break;
		}
      
      	if(requiredmarshalling) {
			resp.setContentType("application/json;charset=UTF-8");
			ObjectMapper mapper = new ObjectMapper();
			try (
				PrintWriter out = resp.getWriter();
			) {
				mapper.writeValue(out, errors);
			}
      	}
      
      return view;
   }
}
      
//      ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
         
//      ReplyVO reply = new ReplyVO();
//      
//      req.setAttribute("reply", reply);
//      
//      try {
//         BeanUtils.populate(reply, req.getParameterMap());
//      } catch (IllegalAccessException | InvocationTargetException e) {
//         throw new BoardException(e);
//      }
//      
//      Map<String, String> errors = new LinkedHashMap<>();
//      boolean valid = validate(reply, errors);
//      
//      if(valid) {
//         IReplyService service = new ReplyServiceImpl();
//         ServiceResult result = service.removeReply(reply);
//         if(ServiceResult.OK.equals(result)) {
//            // 성공
//            return "redirect:/reply/replyList.do?bo_no=" + reply.getBo_no();
//         }else {
//            // 실패
//            errors.put("error", "server");
//         }
//      }else {
//         // 검증 실패
//         errors.put("error", "valid");
//      }
//      
//      ObjectMapper mapper = new ObjectMapper();
//      resp.setContentType(Mime.JSON.getContentType());
//      mapper.writeValue(resp.getWriter(), errors);
//      
//      return null;
//      
//   }
//
//   private boolean validate(ReplyVO reply, Map<String, String> errors) {
//      // TODO Auto-generated method stub
//      return false;
//   }

