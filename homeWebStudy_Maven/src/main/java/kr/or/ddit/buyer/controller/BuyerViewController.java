package kr.or.ddit.buyer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.apache.commons.lang3.StringUtils;

import com.sun.xml.internal.ws.client.ResponseContext;

import kr.or.ddit.buyer.service.BuyerServiceImpl;
import kr.or.ddit.buyer.service.IBuyerService;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mvc.annotation.CommandHandler;
import kr.or.ddit.mvc.annotation.URIMapping;
import kr.or.ddit.mvc.annotation.URIMapping.HttpMethod;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.MemberVO;

@CommandHandler
public class BuyerViewController{
	
	@URIMapping(value="/buyer/buyerView.do", method=HttpMethod.GET)
	public String getProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String buyer_id = req.getParameter("who");
		
		if(StringUtils.isBlank(buyer_id)) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		
		BuyerVO buyer = null;
		IBuyerService service = new BuyerServiceImpl();
		buyer = service.retrieveBuyer(buyer_id);
		req.setAttribute("buyer", buyer);
		String view = "buyer/buyerView";
		return view;
	}	
}
