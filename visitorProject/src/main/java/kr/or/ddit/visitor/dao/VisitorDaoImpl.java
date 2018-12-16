package kr.or.ddit.visitor.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.PagingInfoVO;
import kr.or.ddit.vo.VPdsVO;
import kr.or.ddit.vo.VisitorVO;

public class VisitorDaoImpl implements IVisitorDAO {

	SqlSessionFactory sqlSessionFactory = 
			CustomSqlSessionFactoryBuilder.getSqlSessionFactory();

	
	@Override
	public int insertVisitor(VisitorVO visitor, SqlSession session) {
		return session.insert("kr.or.ddit.visitor.dao.IVisitorDAO.insertVisitor", visitor);
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
		try(
			SqlSession session = sqlSessionFactory.openSession();
		){
			IVisitorDAO mapper = session.getMapper(IVisitorDAO.class);
			return mapper.selectVisitor(vt_no);
		}
	}

	@Override
	public int updateVisitor(VisitorVO visitor) {
		try(
				SqlSession session = sqlSessionFactory.openSession();
			){
				IVisitorDAO mapper = session.getMapper(IVisitorDAO.class);
				return mapper.updateVisitor(visitor);
			}
	}

	@Override
	public int deleteVisitor(long vt_no, SqlSession session) {
		return session.insert("kr.or.ddit.visitor.dao.IVisitorDAO.deleteVisitor", vt_no);
	}

	@Override
	public int insertFile(VPdsVO pdsVO, SqlSession session) {
		return  session.insert("kr.or.ddit.visitor.dao.IVisitorDAO.insertFile", pdsVO);
	}
}
