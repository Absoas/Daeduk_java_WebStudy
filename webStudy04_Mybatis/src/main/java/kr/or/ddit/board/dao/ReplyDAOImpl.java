package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.PagingInfoVO;
import kr.or.ddit.vo.ReplyVO;

public class ReplyDAOImpl implements IReplyDAO {

	SqlSessionFactory sqlSessionFactory = 
			CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Override
	public int insertReply(ReplyVO reply) {
		try(
				SqlSession session = sqlSessionFactory.openSession(false);
			){
			IReplyDAO mapper = session.getMapper(IReplyDAO.class);
			int rowCnt = mapper.insertReply(reply);
			if (rowCnt > 0 ) session.commit();
			return rowCnt;
		}
	}

	@Override
	public long selectTotalRecord(PagingInfoVO<ReplyVO> pagingVO) {
		try(
			SqlSession session = sqlSessionFactory.openSession();
		){
			IReplyDAO mapper = session.getMapper(IReplyDAO.class);
			return mapper.selectTotalRecord(pagingVO);
		}
	}

	@Override
	public List<ReplyVO> selectReplyList(PagingInfoVO<ReplyVO> pagingVO) {
		try(
				SqlSession session = sqlSessionFactory.openSession();
		){
			IReplyDAO mapper = session.getMapper(IReplyDAO.class);
			return mapper.selectReplyList(pagingVO);
		}
	}

	@Override
	public ReplyVO selectReply(long rep_no) {
		try(
				SqlSession session = sqlSessionFactory.openSession();
		){
			IReplyDAO mapper = session.getMapper(IReplyDAO.class);
			return mapper.selectReply(rep_no);
		}
	}

	@Override
	public int updateReply(ReplyVO reply) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteReply(long rep_no) {
		try(
				SqlSession session = sqlSessionFactory.openSession(false);
			){
			IReplyDAO mapper = session.getMapper(IReplyDAO.class);
			int rowCnt = mapper.deleteReply(rep_no);
			if (rowCnt > 0 ) session.commit();
			return rowCnt;
		}
	}

}
