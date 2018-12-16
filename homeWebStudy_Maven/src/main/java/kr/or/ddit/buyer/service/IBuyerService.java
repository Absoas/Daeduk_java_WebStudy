package kr.or.ddit.buyer.service;

import java.util.List;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.PagingInfoVO;

public interface IBuyerService {

	/**
	 * 상품신규 등록
	 * @param Buyer
	 * @return PKDUPLICATED,OK,FAILED
	 */
	public ServiceResult registBuyer(BuyerVO buyer);
	
	
	public long retrieveBuyerCount(PagingInfoVO pagingVO);
	
	
	/**
	 * 상품목록 조회
	 * @param paging TODO
	 * @return 존재하지 않을떄, size() == 0 
	 */
	public List<BuyerVO> retrieveBuyerList(PagingInfoVO paging);
	
	
	/**
	 * 상품정보 상세 조회
	 * @param mem_id 조회할 회원의 아이디
	 * @return 존재하지 않는다면, CommonException 발생
	 */
	public BuyerVO retrieveBuyer(String buyer_id);
	
	/**
	 * 상품정보 수정
	 * @param buyer
	 * @return CommonException, INVALIDPASSWORD , OK , FAILED
	 */
	public ServiceResult modifyBuyer(BuyerVO buyer);
	
	/**
	 * 상품정보 삭제
	 * @param buyer
	 * @return CommonException, INVALIDPASSWORD , OK , FAILED
	 */
	public ServiceResult removeBuyer(String buyer_id);

}
