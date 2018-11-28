package kr.or.ddit.prod.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.member.dao.IMemberDAO;
import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.BuyerVO;

public class OtherDAOImpl implements IOtherDAO {
	SqlSessionFactory SqlSessionFactory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();

	@Override
	public List<Map<String, Object>> selectLprodList() {
		try (
			SqlSession session = SqlSessionFactory.openSession();
		){
			IOtherDAO mapper = session.getMapper(IOtherDAO.class);
			return mapper.selectLprodList();
		}
	}

	@Override
	public List<BuyerVO> selectBuyerList(String buyer_lgu) {
		try (
			SqlSession session = SqlSessionFactory.openSession();
		){
			IOtherDAO mapper = session.getMapper(IOtherDAO.class);
			return mapper.selectBuyerList(buyer_lgu);
		}
	}

	

}





















