package kr.or.ddit.buyer.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.db.ibatis.CustomSqlMapClientBuilder;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.PagingInfoVO;

public class BuyerDAOImpl implements IBuyerDAO {

	SqlMapClient sqlMapClient = CustomSqlMapClientBuilder.getSqlMapClient();

	@Override
	public BuyerVO selectBuyer(String Buyer_id) {
		try {
			BuyerVO Buyer = (BuyerVO) sqlMapClient.queryForObject("Buyer.selectBuyer", Buyer_id);
			return Buyer;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int insertBuyer(BuyerVO Buyer) {
		try {
			return sqlMapClient.update("Buyer.insertBuyer", Buyer);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<BuyerVO> selectBuyerList(PagingInfoVO paging) {
		try {
			List<BuyerVO> BuyerList = sqlMapClient.queryForList("Buyer.selectBuyerList",paging);
			return BuyerList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int updateBuyer(BuyerVO Buyer) {
		try {
			int cnt = sqlMapClient.update("Buyer.updateBuyer", Buyer);
			return cnt;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int deleteBuyer(String Buyer_id) {
		try {
			int a = sqlMapClient.update("Buyer.deleteBuyer", Buyer_id);
			return a;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public long selectTotalRecord(PagingInfoVO pagingVO) {
		try {
			long a = (Long)sqlMapClient.queryForObject("Buyer.selectTotalRecord", pagingVO);
			return a;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
