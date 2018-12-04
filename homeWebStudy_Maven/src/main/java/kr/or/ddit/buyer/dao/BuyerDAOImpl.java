package kr.or.ddit.buyer.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.PagingInfoVO;

public class BuyerDAOImpl implements IBuyerDAO {

	SqlSessionFactory sqlSessionFactory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();

	@Override
	public BuyerVO selectBuyer(String buyer_id) {
		try (
			SqlSession session = sqlSessionFactory.openSession();
		){
			IBuyerDAO mapper = session.getMapper(IBuyerDAO.class);
			return mapper.selectBuyer(buyer_id);
		}
	}

	@Override
	public int insertBuyer(BuyerVO buyer) {
		try (
			SqlSession session = sqlSessionFactory.openSession();
		){
			IBuyerDAO mapper = session.getMapper(IBuyerDAO.class);
			return mapper.insertBuyer(buyer);
		}
	}

	@Override
	public List<BuyerVO> selectBuyerList(PagingInfoVO paging) {
		try (
			SqlSession session = sqlSessionFactory.openSession();
		){
			IBuyerDAO mapper = session.getMapper(IBuyerDAO.class);
			return mapper.selectBuyerList(paging);
		}
	}

	@Override
	public int updateBuyer(BuyerVO buyer) {
		try (
			SqlSession session = sqlSessionFactory.openSession();
		){
			IBuyerDAO mapper = session.getMapper(IBuyerDAO.class);
			int rowCnt = mapper.updateBuyer(buyer);
			session.commit();
			return rowCnt;
		}
	}

	@Override
	public int deleteBuyer(String buyer_id) {
		try (
			SqlSession session = sqlSessionFactory.openSession();
		){
			IBuyerDAO mapper = session.getMapper(IBuyerDAO.class);
			int rowCnt = mapper.deleteBuyer(buyer_id);
			session.commit();
			return rowCnt;
		}
	}
	
	@Override
	public long selectTotalRecord(PagingInfoVO pagingVO) {
		try (
			SqlSession session = sqlSessionFactory.openSession();
		){
			IBuyerDAO mapper = session.getMapper(IBuyerDAO.class);
			long rowCnt = mapper.selectTotalRecord(pagingVO);
			session.commit();
			return rowCnt;
		}
	}
}
