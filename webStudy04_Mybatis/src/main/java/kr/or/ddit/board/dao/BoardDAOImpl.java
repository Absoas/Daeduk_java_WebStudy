package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.PagingInfoVO;

public class BoardDAOImpl implements IBoardDAO {
	SqlSessionFactory sqlSessionFactory = 
			CustomSqlSessionFactoryBuilder.getSqlSessionFactory();

	@Override
	public int insertBoard(BoardVO board, SqlSession session) {
		return session.insert("kr.or.ddit.board.dao.IBoardDAO.insertBoard", board);
		
	}

	@Override
	public long selectTotalRecord(PagingInfoVO<BoardVO> pagingVO) {
		try(
				SqlSession session = sqlSessionFactory.openSession();
		){
			IBoardDAO mapper = session.getMapper(IBoardDAO.class);
			return mapper.selectTotalRecord(pagingVO);
		}
	}

	@Override
	public List<BoardVO> selectBoardList(PagingInfoVO<BoardVO> pagingVO) {
		try(
				SqlSession session = sqlSessionFactory.openSession();
		){
			IBoardDAO mapper = session.getMapper(IBoardDAO.class);
			return mapper.selectBoardList(pagingVO);
		}
	}

	@Override
	public BoardVO selectBoard(long bo_no) {
		try(
				SqlSession session = sqlSessionFactory.openSession();
		){
			IBoardDAO mapper = session.getMapper(IBoardDAO.class);
			return mapper.selectBoard(bo_no);
		}
	}

	@Override
	public void incrementHit(long bo_no) {
		try(
				SqlSession session = sqlSessionFactory.openSession();
		){
			IBoardDAO mapper = session.getMapper(IBoardDAO.class);
			mapper.incrementHit(bo_no);
			session.commit();
		}
	}

	@Override
	public void incrementRcmd(long bo_no) {
		try(
			SqlSession session = sqlSessionFactory.openSession();
		){
			IBoardDAO mapper = session.getMapper(IBoardDAO.class);
			mapper.incrementRcmd(bo_no);
			session.commit();
		}
	}

	@Override
	public int updateBoard(BoardVO board, SqlSession session) {
		return session.insert("kr.or.ddit.board.dao.IBoardDAO.updateBoard", board);
	}

	@Override
	public int deleteBoard(long bo_no, SqlSession session) {
		return session.delete("kr.or.ddit.board.dao.IBoardDAO.deleteBoard",bo_no);
	}

}
