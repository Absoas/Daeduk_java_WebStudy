package kr.or.ddit.visitor.dao;

import java.util.List;

import kr.or.ddit.vo.PagingInfoVO;
import kr.or.ddit.vo.VisitReplyVO;

public interface IReplyDAO {
	/**
	 * 덧글 작성
	 * @param reply
	 * @return row count
	 */
	public int insertReply(VisitReplyVO reply);
	
	/**
	 * 특정 게시글의 전체 덧글 수
	 * @param pagingVO
	 * @return
	 */
	public long selectTotalRecord(PagingInfoVO<VisitReplyVO> pagingVO);
	
	/**
	 *  특정 게시글의 덧글 목록 조회
	 * @param pagingVO
	 * @return
	 */
	public List<VisitReplyVO> selectReplyList(PagingInfoVO<VisitReplyVO> pagingVO);
	
	/**
	 * 덧글 상세 조회
	 * @param rep_no
	 * @return 존재하지 않는다면, null 반환
	 */
	public VisitReplyVO selectReply(long rep_no);
	
	/**
	 * 덧글 수정
	 * @param reply
	 * @return row count
	 */
	public int updateReply(VisitReplyVO reply);
	
	/**
	 * 덧글 삭제
	 * @param rep_no
	 * @return row count
	 */
	public int deleteReply(long rep_no);
}





















