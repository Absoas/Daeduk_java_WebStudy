package kr.or.ddit.buyer.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.CommonException;
import kr.or.ddit.ServiceResult;
import kr.or.ddit.buyer.service.BuyerServiceImpl;
import kr.or.ddit.buyer.service.IBuyerService;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mvc.ICommandHandler;
import kr.or.ddit.prod.dao.IOtherDAO;
import kr.or.ddit.prod.dao.OtherDAOImpl;
import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ProdVO;

public class BuyerUpdateController implements ICommandHandler{
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		
		IOtherDAO otherDAO = new OtherDAOImpl();
		List<Map<String, Object>> lprodList = otherDAO.selectLprodList();
		req.setAttribute("lprodList", lprodList);
		String goPage = null;
		
		if("get".equalsIgnoreCase(method)) {
			String buyer_id = req.getParameter("what");
			if(StringUtils.isBlank(buyer_id)) {
				resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
				return null;
			}
			IBuyerService service = new BuyerServiceImpl();
			BuyerVO buyer =  service.retrieveBuyer(buyer_id);
			req.setAttribute("buyer", buyer);
			
			return "buyer/buyerForm";
		
		}else if("post".equalsIgnoreCase(method)){
			BuyerVO buyer = new BuyerVO();
			req.setAttribute("buyer", buyer);
			
			try {
				BeanUtils.populate(buyer,  req.getParameterMap());
			} catch (IllegalAccessException | InvocationTargetException e) {
				throw new CommonException(e);
			}
			
			String message = null;
			
			Map<String, String> errors = new LinkedHashMap<>();
			req.setAttribute("errors", errors);
			
			boolean valid = validate(buyer, errors);
	
			if (valid) {
				IBuyerService service = new BuyerServiceImpl();
				ServiceResult result = service.modifyBuyer(buyer);
				System.err.println(result.toString());
				switch (result) {
				case FAILED:
					goPage = "buyer/buyerView";
					message = "서버 오류로 인한 실패, 잠시 후 다시 시도";
					break;
				case OK:
					goPage = "redirect:/buyer/buyerList.do";
					break;
				}
				req.setAttribute("message", message);
			} else {
				goPage = "buyer/buyerForm";
			}
	
			return goPage;
		}else {
			resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	
	private boolean validate(BuyerVO buyer, Map<String, String> errors){
		boolean valid = true;
		if(StringUtils.isBlank(buyer.getBuyer_id())){valid = false;errors.put("buyer_id", " 누락");}
		if(StringUtils.isBlank(buyer.getBuyer_name())){valid = false;errors.put("buyer_name", " 누락");}
		if(StringUtils.isBlank(buyer.getBuyer_lgu())){valid = false;errors.put("buyer_lgu", " 누락");}
		if(StringUtils.isBlank(buyer.getBuyer_comtel())){valid = false;errors.put("buyer_comtel", " 누락");}
		if(StringUtils.isBlank(buyer.getBuyer_fax())){valid = false;errors.put("buyer_fax", " 누락");}
		if(StringUtils.isBlank(buyer.getBuyer_mail())){valid = false;errors.put("buyer_mail", " 누락");}
		return valid;
	}
}
