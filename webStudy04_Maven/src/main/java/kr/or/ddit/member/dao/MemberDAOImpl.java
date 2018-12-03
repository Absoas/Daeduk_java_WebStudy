package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PagingInfoVO;

public class MemberDAOImpl implements IMemberDAO {

	SqlSessionFactory SqlSessionFactory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Override
	public int insertMember(MemberVO member) {
		try (
			SqlSession session = SqlSessionFactory.openSession();
		){
			IMemberDAO mapper = session.getMapper(IMemberDAO.class);
			int cnt = mapper.insertMember(member);
			if(cnt>0) session.commit();
			return cnt;
		}
	}

	@Override
	public long selectTotalRecord(PagingInfoVO pagingVO) {
		try (
			SqlSession session = SqlSessionFactory.openSession();
		){
			IMemberDAO mapper = session.getMapper(IMemberDAO.class);
			return mapper.selectTotalRecord(pagingVO);
		}
	}

	@Override
	public List<MemberVO> selectMemberList(PagingInfoVO pagingVO) {
		try (
				SqlSession session = SqlSessionFactory.openSession();
		){
//			return session.selectList("kr.or.ddit.member.dao.IMemberDAO.selectMemberList",pagingVO);
			IMemberDAO mapper =  session.getMapper(IMemberDAO.class);
			return mapper.selectMemberList(pagingVO);
		}
	}

	@Override
	public MemberVO selectMember(String mem_id) {
		try (
				SqlSession session = SqlSessionFactory.openSession();
		){
			IMemberDAO mapper = session.getMapper(IMemberDAO.class);
			return mapper.selectMember(mem_id);
		}
	}

	@Override
	public int updateMember(MemberVO member) {
		try (
				SqlSession session = SqlSessionFactory.openSession();
		){
			IMemberDAO mapper = session.getMapper(IMemberDAO.class);
			int cnt  = mapper.updateMember(member);
			if(cnt>0)session.commit();
			return cnt;
		}
	}

	@Override
	public int deleteMember(String mem_id) {
		try(
			SqlSession session = SqlSessionFactory.openSession();
		) {
			IMemberDAO mapper = session.getMapper(IMemberDAO.class);
			int cnt = mapper.deleteMember(mem_id);
			if(cnt>0)session.commit();
			return cnt;
		}
	}
}
