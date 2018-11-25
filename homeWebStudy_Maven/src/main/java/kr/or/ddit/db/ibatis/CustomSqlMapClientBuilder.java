package kr.or.ddit.db.ibatis;

import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class CustomSqlMapClientBuilder {
	private static SqlMapClient sqlMapClient;

	static {
		//sqlmapconfig xml을 통해서 객체 
		try (
			Reader reader =  Resources.getResourceAsReader("kr/or/ddit/db/ibatis/SqlMapConfig.xml");
		){
			sqlMapClient =  SqlMapClientBuilder.buildSqlMapClient(reader);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}
}
