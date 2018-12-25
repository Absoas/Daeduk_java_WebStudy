package kr.or.ddit.alba.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface IOtherDAO {
	public List<Map<String, Object>> selectGrade();
	public List<Map<String, Object>> selectLicense();
	
	
	public List<Map<String, Object>> selectLicenseList(String alba_code);
}
