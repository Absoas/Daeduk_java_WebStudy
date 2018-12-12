package kr.or.ddit.visitor.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.vo.PagingInfoVO;
import kr.or.ddit.vo.VisitorVO;

public interface IVisitorDAO {
	public int insertVisitor(VisitorVO visitor, SqlSession session);
	public long selectTotalRecord(PagingInfoVO<VisitorVO> pagingVO);
	public List<VisitorVO> selectVisitorList(PagingInfoVO<VisitorVO> pagingVO);
	public VisitorVO selectVisitor(@Param("vt_no") long vt_no);
	public int updateVisitor(VisitorVO visitor, SqlSession session);
	public int deleteVisitor(long vt_no, SqlSession session);
}
