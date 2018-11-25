package kr.or.ddit.lprod.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.db.ibatis.CustomSqlMapClientBuilder;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.LprodVO;

public class LprodDaoImpl implements ILprodDAO{
	SqlMapClient sqlMapClient = CustomSqlMapClientBuilder.getSqlMapClient();

	@Override
	public List<LprodVO> selectAllLprod() {
		try {
			List<LprodVO> lprodList = sqlMapClient.queryForList("Lprod.selectAllLprod");
			return lprodList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
