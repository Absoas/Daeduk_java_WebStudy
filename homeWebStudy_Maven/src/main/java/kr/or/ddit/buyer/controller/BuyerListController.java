package kr.or.ddit.buyer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.buyer.service.BuyerServiceImpl;
import kr.or.ddit.buyer.service.IBuyerService;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mvc.ICommandHandler;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PagingInfoVO;
import kr.or.ddit.vo.ProdVO;

public class BuyerListController implements ICommandHandler{
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int currentPage = 1;
		String page = req.getParameter("page");
		String searchType = req.getParameter("searchType");
		String searchWord = req.getParameter("searchWord");
		
		BuyerVO searchVO = new BuyerVO();
		searchVO.setBuyer_name(req.getParameter("buyer_name"));
		
		
		if(StringUtils.isNumeric(page)) {
			currentPage = Integer.parseInt(page);
		}
		PagingInfoVO<BuyerVO> pagingVO = new PagingInfoVO(5,2);
		pagingVO.setCurrentPage(currentPage);
		pagingVO.setSearchVO(searchVO);
		
		IBuyerService service =  new BuyerServiceImpl();
		// 4. 로직 선택
		// 5. 컨텐츠(Model) 확보 
		long totalRecord = service.retrieveBuyerCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		List<BuyerVO> buyerList =  service.retrieveBuyerList(pagingVO);
		
		pagingVO.setDataList(buyerList);
		req.setAttribute("pagingVO", pagingVO);
		
		String view = "buyer/buyerList";
		return view;
		
	}
}
