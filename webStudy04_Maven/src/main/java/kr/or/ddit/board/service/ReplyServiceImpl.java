package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.board.BoardException;
import kr.or.ddit.board.dao.IReplyDAO;
import kr.or.ddit.board.dao.ReplyDAOImpl;
import kr.or.ddit.vo.PagingInfoVO;
import kr.or.ddit.vo.ReplyVO;

public class ReplyServiceImpl implements IReplyService {
	
	IReplyDAO replyDAO = new ReplyDAOImpl();
	
	@Override
	public ServiceResult createReply(ReplyVO reply) {
		ServiceResult result = null;
		
		int row = replyDAO.insertReply(reply);
		
		if(row > 0) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAILED;
		}
		
		return result;
	}

	@Override
	public long retriveReplyCount(PagingInfoVO<ReplyVO> pagingVO) {
		return replyDAO.selectTotalRecord(pagingVO);
	}

	@Override
	public List<ReplyVO> retriveReplyList(PagingInfoVO<ReplyVO> pagingVO) {
		return replyDAO.selectReplyList(pagingVO);
	}

	@Override
	public ServiceResult modifyReply(ReplyVO reply) {
		ReplyVO rep =  replyDAO.selectReply(reply.getRep_no());
		ServiceResult result = null;
		if(rep!=null) {
			if(rep.getRep_pass().equals(reply.getRep_pass())){
				int cnt = replyDAO.updateReply(reply);
				
				if(cnt>0) {
					result = ServiceResult.OK;
				}else {
					result = ServiceResult.FAILED;
				}
			}else {
				result = ServiceResult.INVALIDPASSWORD;
			}
		}else {
			throw new BoardException();
		}
		return result;
	}

	@Override
	public ServiceResult removeReply(ReplyVO reply) {
		ReplyVO rep =  replyDAO.selectReply(reply.getRep_no());
		ServiceResult result = null;
		if(rep!=null) {
			if(rep.getRep_pass().equals(reply.getRep_pass())){
				int cnt = replyDAO.deleteReply(reply.getRep_no());
				
				if(cnt>0) {
					result = ServiceResult.OK;
				}else {
					result = ServiceResult.FAILED;
				}
			}else {
				result = ServiceResult.INVALIDPASSWORD;
			}
		}else {
			throw new BoardException();
		}
		return result;
	}

}
