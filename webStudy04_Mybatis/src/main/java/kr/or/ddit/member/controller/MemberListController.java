package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mvc.annotation.CommandHandler;
import kr.or.ddit.mvc.annotation.URIMapping;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PagingInfoVO;

@CommandHandler
public class MemberListController{
//	3. B.L.L 와의 의존관계 형성
	IMemberService service = new MemberServiceImpl();
	
	@URIMapping("/member/memberList.do")
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		1. 요청과의 매핑 설정
//		2. 요청 분석(주소, 파라미터, 메소드, 헤더들...)
		String searchWord = req.getParameter("searchWord");
		String searchType = req.getParameter("searchType");
		int currentPage = 1;
		String page = req.getParameter("page");
		if(StringUtils.isNumeric(page)) {
			currentPage = Integer.parseInt(page);
		}
		PagingInfoVO<MemberVO> pagingVO = new PagingInfoVO<>(5, 2);
		pagingVO.setCurrentPage(currentPage);
		pagingVO.setSearchWord(searchWord);
		pagingVO.setSearchType(searchType);

//		4. 로직 선택
//		5. 컨텐츠(Model) 확보
		long totalRecord = service.retrieveMemberCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		
		List<MemberVO> memberList = service.retrieveMemberList(pagingVO);
		pagingVO.setDataList(memberList);
//		6. V.L 를 선택
		String view = "member/memberList";
//		7. Scope 를 통해 Model 공유
//		req.setAttribute("memberList", memberList);
		req.setAttribute("pagingVO", pagingVO);
		
		return view;
	}
}


















