package kr.or.ddit.visitor.service;

import java.util.List;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.visitor.dao.IReplyDAO;
import kr.or.ddit.visitor.dao.ReplyDAOImpl;
import kr.or.ddit.vo.PagingInfoVO;
import kr.or.ddit.vo.VisitReplyVO;

public class ReplyServiceImpl implements IReplyService {
	IReplyDAO replyDAO = new ReplyDAOImpl();
	
	@Override
	public ServiceResult createReply(VisitReplyVO reply) {
		int rowCnt = replyDAO.insertReply(reply);
		ServiceResult result = ServiceResult.FAILED;
		if(rowCnt > 0) result = ServiceResult.OK;
		return result;
	}

	@Override
	public long retriveReplyCount(PagingInfoVO<VisitReplyVO> pagingVO) {
		return replyDAO.selectTotalRecord(pagingVO);
	}

	@Override
	public List<VisitReplyVO> retriveReplyList(PagingInfoVO<VisitReplyVO> pagingVO) {
		return replyDAO.selectReplyList(pagingVO);
	}

	private VisitReplyVO retrieveReply(long rep_no) {
		VisitReplyVO reply = replyDAO.selectReply(rep_no);
		return reply;
	}
	
	@Override
	public ServiceResult modifyReply(VisitReplyVO reply) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResult removeReply(VisitReplyVO reply) {
		VisitReplyVO savedReply =  retrieveReply(reply.getRep_no());
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





