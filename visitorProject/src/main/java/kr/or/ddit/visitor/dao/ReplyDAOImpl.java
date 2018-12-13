package kr.or.ddit.visitor.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.PagingInfoVO;
import kr.or.ddit.vo.VisitReplyVO;

public class ReplyDAOImpl implements IReplyDAO {

	SqlSessionFactory sqlSessionFactory = 
			CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Override
	public int insertReply(VisitReplyVO reply) {
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
	public long selectTotalRecord(PagingInfoVO<VisitReplyVO> pagingVO) {
		try(
			SqlSession session = sqlSessionFactory.openSession();
		){
			IReplyDAO mapper = session.getMapper(IReplyDAO.class);
			return mapper.selectTotalRecord(pagingVO);
		}
	}

	@Override
	public List<VisitReplyVO> selectReplyList(PagingInfoVO<VisitReplyVO> pagingVO) {
		try(
				SqlSession session = sqlSessionFactory.openSession();
		){
			IReplyDAO mapper = session.getMapper(IReplyDAO.class);
			return mapper.selectReplyList(pagingVO);
		}
	}

	@Override
	public VisitReplyVO selectReply(long rep_no) {
		try(
				SqlSession session = sqlSessionFactory.openSession();
		){
			IReplyDAO mapper = session.getMapper(IReplyDAO.class);
			return mapper.selectReply(rep_no);
		}
	}

	@Override
	public int updateReply(VisitReplyVO reply) {
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
