package kr.or.ddit.buyer.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import kr.or.ddit.CommonException;
import kr.or.ddit.ServiceResult;
import kr.or.ddit.buyer.service.BuyerServiceImpl;
import kr.or.ddit.buyer.service.IBuyerService;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mvc.ICommandHandler;
import kr.or.ddit.vo.MemberVO;

public class BuyerDeleteController implements ICommandHandler{
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String buyer_id = req.getParameter("buyer_id");

		if(StringUtils.isBlank(buyer_id)) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}

		IBuyerService service = new BuyerServiceImpl();
		ServiceResult result = service.removeBuyer(buyer_id);
		String goPage = null;
		String message = null;
		
		switch (result) {
		case FAILED:
			goPage = "redirect:/buyer/buyerView.do";
			message = "서버 오류";
			break;
			
		case OK:
			goPage = "redirect:/buyer.buyerList.do";
			break;
		}
		req.getSession().setAttribute("message", message);
		
		return goPage;
	}

}