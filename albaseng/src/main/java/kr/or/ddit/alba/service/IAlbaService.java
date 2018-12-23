package kr.or.ddit.alba.service;

import java.util.List;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.vo.AlbaVO;
import kr.or.ddit.vo.PagingInfoVO;

public interface IAlbaService {
	public AlbaVO retrieveAlba(String alba_code);
	public List<AlbaVO> retrieveAlbaList(PagingInfoVO<AlbaVO> pagingVO);
	public long retrieveAlbaCount(PagingInfoVO<AlbaVO> pagingVO);
	
	public ServiceResult createAlba(AlbaVO alba);
	public ServiceResult deleteAlba(String alba_code);
	public ServiceResult updateAlba(AlbaVO alba);
	
}
