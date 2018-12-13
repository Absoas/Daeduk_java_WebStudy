package kr.or.ddit.visitor.service;

import java.util.List;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.vo.PagingInfoVO;
import kr.or.ddit.vo.VisitReplyVO;

public interface IReplyService {
	/**
	 * 덧글 작성
	 * @param reply
	 * @return OK, FAILED
	 */
	public ServiceResult createReply(VisitReplyVO reply); 
	/**
	 * 특정 게시글의 덧글 수
	 * @param pagingVO
	 * @return 없다면, 0
	 */
	public long retriveReplyCount(PagingInfoVO<VisitReplyVO> pagingVO);
	/**
	 * 특정 게시글의 덧글 목록
	 * @param pagingVO
	 * @return 없다면, .size()==0
	 */
	public List<VisitReplyVO> retriveReplyList(PagingInfoVO<VisitReplyVO> pagingVO);
	/**
	 * 덧글 수정
	 * @param reply
	 * @return BoardException, INVALIDPASSWORD, OK, FAILED
	 */
	public ServiceResult modifyReply(VisitReplyVO reply);
	/**
	 * 덧글 삭제
	 * @param reply
	 * @return BoardException, INVALIDPASSWORD, OK, FAILED
	 */
	public ServiceResult removeReply(VisitReplyVO reply);
}


















