package kr.or.ddit.lprod.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.LprodVO;

public class LprodDaoImpl implements ILprodDAO{
	SqlSessionFactory sqlSessionFactory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();

	@Override
	public List<LprodVO> selectAllLprod() {
		try (
			SqlSession session = sqlSessionFactory.openSession();
		){
			ILprodDAO mapper = session.getMapper(ILprodDAO.class);
			return mapper.selectAllLprod();
		}
	}
}
