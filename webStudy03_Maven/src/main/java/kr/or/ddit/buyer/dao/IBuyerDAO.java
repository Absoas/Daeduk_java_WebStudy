package kr.or.ddit.buyer.dao;

import java.util.List;

import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.BuyerVO;


/**
 * @author yb
 * @since 2018. 11. 21.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일                          수정자               수정내용
 * --------     --------    ----------------------
 * 2018. 11. 21.      작성자명       buyer
 * Copyright (c) 2018 by DDIT All right reserved
 * </pre>
 */
public interface IBuyerDAO {
	/**
	 * 카트 정보 상세 조회
	 * @param mem_id 조회할 회원의 아이디
	 * @return	존재하지 않는다면, null 반환
	 */
	public BuyerVO selectBuyer(String buyer_id);
	
	/**
	 * 카트 신규 등록
	 * @param Buyer 등록하 회원의 정보를 가진 VO
	 * @return	성공(>0)  실패
	 */
	public int insertBuyer(BuyerVO buyer);
	
	/**
	 * 카트 목록 조회
	 * @return 존재하지 않는다면, .size()==0
	 */
	public List<BuyerVO> selectBuyerList();
	
	
	/**
	 * 카트 정보 수정
	 * @param Buyer 수정할 정보를 가진 VO
	 * @return	성공(>0) 실패
	 */
	public int updateBuyer(BuyerVO buyer);
	
	/**
	 * 카트 정보 삭제
	 * @param mem_id 삭제할 카트의 아이디
	 * @return	성공(>0) 실패
	 */
	public int deleteBuyer(String buyer_id);
}
