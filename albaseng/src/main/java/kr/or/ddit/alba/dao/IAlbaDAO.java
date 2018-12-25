package kr.or.ddit.alba.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.vo.AlbaVO;
import kr.or.ddit.vo.LicenseVO;
import kr.or.ddit.vo.PagingInfoVO;

@Repository
public interface IAlbaDAO {
	public AlbaVO selectAlba(String alba_no);
	public List<AlbaVO> selectAlbaList(PagingInfoVO<AlbaVO> pagingVO);
	
	public int insertAlba(AlbaVO alba);
	public int deleteAlba(String alba_no);
	public int updateAlba(AlbaVO alba);
	
	public long selectTotalRecord(PagingInfoVO<AlbaVO> pagingVO);
	
	
	public Map<String, Object> selectLicense(String alba_code);
	public int licanseInsert(LicenseVO licVO);
}
