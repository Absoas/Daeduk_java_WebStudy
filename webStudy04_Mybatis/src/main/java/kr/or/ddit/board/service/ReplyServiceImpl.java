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
		int rowCnt = replyDAO.insertReply(reply);
		ServiceResult result = ServiceResult.FAILED;
		if(rowCnt > 0) result = ServiceResult.OK;
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

	private ReplyVO retrieveReply(long rep_no) {
		ReplyVO reply = replyDAO.selectReply(rep_no);
		if(reply==null) {
			throw new BoardException(rep_no+" 덧글 존재하지 않음. ");
		}
		return reply;
	}
	
	@Override
	public ServiceResult modifyReply(ReplyVO reply) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResult removeReply(ReplyVO reply) {
		ReplyVO savedReply =  retrieveReply(reply.getRep_no());
		ServiceResult result = null;
		if(savedReply.getRep_pass().equals(reply.getRep_pass())) {
			int rowCnt = replyDAO.deleteReply(reply.getRep_no());
			if(rowCnt > 0) {
				result = ServiceResult.OK;
			}else {
				result = ServiceResult.FAILED;
			}
		}else {
			result = ServiceResult.INVALIDPASSWORD;
		}
		return result;
	}

}





