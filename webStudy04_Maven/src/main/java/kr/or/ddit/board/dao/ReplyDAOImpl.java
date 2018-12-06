package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.PagingInfoVO;
import kr.or.ddit.vo.ReplyVO;

public class ReplyDAOImpl implements IReplyDAO {

	SqlSessionFactory sqlSessionFactory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Override
	public int insertReply(ReplyVO reply) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			IReplyDAO mapper = sqlSession.getMapper(IReplyDAO.class);
			int rowcnt = mapper.insertReply(reply);
			sqlSession.commit();
			return rowcnt;
		}
	}

	@Override
	public long selectTotalRecord(PagingInfoVO<ReplyVO> pagingVO) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			IReplyDAO mapper = sqlSession.getMapper(IReplyDAO.class);
			return mapper.selectTotalRecord(pagingVO);
		}
	}

	@Override
	public List<ReplyVO> selectReplyList(PagingInfoVO<ReplyVO> pagingVO) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			IReplyDAO mapper = sqlSession.getMapper(IReplyDAO.class);
			return mapper.selectReplyList(pagingVO);
		}
	}

	@Override
	public ReplyVO selectReply(long rep_no) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			IReplyDAO mapper = sqlSession.getMapper(IReplyDAO.class);
			return mapper.selectReply(rep_no);
		}
	}

	@Override
	public int updateReply(ReplyVO reply) {
		try(
				SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			IReplyDAO mapper = sqlSession.getMapper(IReplyDAO.class);
			int rowcnt = mapper.updateReply(reply);
			if(rowcnt>0) sqlSession.commit();
			return rowcnt;
		}
	}

	@Override
	public int deleteReply(long req_no) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			IReplyDAO mapper = sqlSession.getMapper(IReplyDAO.class);
			int rowcnt = mapper.deleteReply(req_no);
			if(rowcnt>0) sqlSession.commit();
			return rowcnt;
		}
	}

}
