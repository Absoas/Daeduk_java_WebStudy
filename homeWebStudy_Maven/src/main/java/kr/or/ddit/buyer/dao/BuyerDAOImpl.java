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
	public BuyerVO selectBuyer(String Buyer_id) {
		try (
			SqlSession session = sqlSessionFactory.openSession();
		){
			IBuyerDAO mapper = session.getMapper(IBuyerDAO.class);
			return mapper.selectBuyer(Buyer_id);
		}
	}

	@Override
	public int insertBuyer(BuyerVO Buyer) {
		try (
			SqlSession session = sqlSessionFactory.openSession();
		){
			IBuyerDAO mapper = session.getMapper(IBuyerDAO.class);
			return mapper.insertBuyer(Buyer);
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
	public int updateBuyer(BuyerVO Buyer) {
		try (
			SqlSession session = sqlSessionFactory.openSession();
		){
			IBuyerDAO mapper = session.getMapper(IBuyerDAO.class);
			int rowCnt = mapper.updateBuyer(Buyer);
			session.commit();
			return rowCnt;
		}
	}

	@Override
	public int deleteBuyer(String Buyer_id) {
		try (
			SqlSession session = sqlSessionFactory.openSession();
		){
			IBuyerDAO mapper = session.getMapper(IBuyerDAO.class);
			int rowCnt = mapper.deleteBuyer(Buyer_id);
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
