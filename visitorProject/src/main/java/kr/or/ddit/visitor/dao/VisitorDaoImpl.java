package kr.or.ddit.visitor.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.PagingInfoVO;
import kr.or.ddit.vo.VisitorVO;

public class VisitorDaoImpl implements IVisitorDAO {

	SqlSessionFactory sqlSessionFactory = 
			CustomSqlSessionFactoryBuilder.getSqlSessionFactory();

	
	@Override
	public int insertVisitor(VisitorVO Visitor, SqlSession session) {
		return session.insert("kr.or.ddit.visitor.dao.IVisitorDAO.insertVisitor", Visitor);
	}

	@Override
	public long selectTotalRecord(PagingInfoVO<VisitorVO> pagingVO) {
		try(
			SqlSession session = sqlSessionFactory.openSession();
		){
			IVisitorDAO mapper = session.getMapper(IVisitorDAO.class);
			return mapper.selectTotalRecord(pagingVO);
		}
	}

	@Override
	public List<VisitorVO> selectVisitorList(PagingInfoVO<VisitorVO> pagingVO) {
		try(
			SqlSession session = sqlSessionFactory.openSession();
		){
			IVisitorDAO mapper = session.getMapper(IVisitorDAO.class);
			return mapper.selectVisitorList(pagingVO);
		}
	}

	@Override
	public VisitorVO selectVisitor(long vt_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateVisitor(VisitorVO Visitor, SqlSession session) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteVisitor(long bo_no, SqlSession session) {
		// TODO Auto-generated method stub
		return 0;
	}

}
