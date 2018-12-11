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
import kr.or.ddit.mvc.annotation.CommandHandler;
import kr.or.ddit.mvc.annotation.URIMapping;
import kr.or.ddit.mvc.annotation.URIMapping.HttpMethod;
import kr.or.ddit.prod.dao.IOtherDAO;
import kr.or.ddit.prod.dao.OtherDAOImpl;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.MemberVO;

@CommandHandler
public class BuyerInsertController{
	IOtherDAO otherDAO = new OtherDAOImpl();
	
	public void makeLprodList(HttpServletRequest req){
		List<Map<String, Object>> lprodList = otherDAO.selectLprodList();
		req.setAttribute("lprodList", lprodList);
	}
	
	@URIMapping(value="/buyer/buyerInsert.do", method=HttpMethod.GET)
	public String getProcess(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		makeLprodList(req);
		String view = "buyer/buyerForm";
		return view;
	}
	
	@URIMapping(value="/buyer/buyerInsert.do", method=HttpMethod.POST)
	public String postProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		makeLprodList(req);
		BuyerVO buyer = new BuyerVO();
		req.setAttribute("buyer", buyer);

		try {
			BeanUtils.populate(buyer,  req.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new CommonException(e);
		}
		
		String goPage = null;
		String message = null;
		Map<String, String> errors = new LinkedHashMap<>();
		req.setAttribute("errors", errors);
		boolean valid = validate(buyer, errors);

		if (valid) {
			IBuyerService service = new BuyerServiceImpl();
			ServiceResult result = service.registBuyer(buyer);
			switch (result) {
			case PKDUPLICATED:
				goPage = "buyer/buyerForm";
				message = "아이디 중복, 바꾸셈";
				break;
			case FAILED:
				goPage = "buyer/buyerForm";
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
	}
	
	public boolean validate(BuyerVO buyer, Map<String, String> errors){
		boolean valid = true;
		if(StringUtils.isBlank(buyer.getBuyer_name())){valid = false;errors.put("buyer_name", " 누락");}
		if(StringUtils.isBlank(buyer.getBuyer_lgu())){valid = false;errors.put("buyer_lgu", " 누락");}
		if(StringUtils.isBlank(buyer.getBuyer_comtel())){valid = false;errors.put("buyer_comtel", " 누락");}
		if(StringUtils.isBlank(buyer.getBuyer_fax())){valid = false;errors.put("buyer_fax", " 누락");}
		if(StringUtils.isBlank(buyer.getBuyer_mail())){valid = false;errors.put("buyer_mail", " 누락");}
		return valid;
	}
}
