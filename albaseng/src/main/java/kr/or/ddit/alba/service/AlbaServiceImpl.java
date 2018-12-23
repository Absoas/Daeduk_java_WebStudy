package kr.or.ddit.alba.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.alba.dao.IAlbaDAO;
import kr.or.ddit.vo.AlbaVO;
import kr.or.ddit.vo.PagingInfoVO;

@Service
public class AlbaServiceImpl implements IAlbaService{
	
	@Inject
	IAlbaDAO albadao;
	
	@Override
	public long retrieveAlbaCount(PagingInfoVO<AlbaVO> pagingVO) {
		return albadao.selectTotalRecord(pagingVO);
	}

	@Override
	public AlbaVO retrieveAlba(String alba_code) {
		return albadao.selectAlba(alba_code);
	}

	@Override
	public List<AlbaVO> retrieveAlbaList(PagingInfoVO<AlbaVO> pagingVO) {
		return albadao.selectAlbaList(pagingVO);
	}

	@Override
	public ServiceResult createAlba(AlbaVO alba) {
		ServiceResult result = ServiceResult.FAILED;
		
		int cnt = albadao.insertAlba(alba);
		
//		if(alba.getLicense()!=null || alba.getLicense().length>0){
//			albadao.licanseInsert(alba)
//		}
		
		if(cnt>0){
			result = ServiceResult.OK;
		}
		
		return result;
	}

	@Override
	public ServiceResult deleteAlba(String alba_code) {
		ServiceResult result = ServiceResult.FAILED;
		
		int cnt = albadao.deleteAlba(alba_code);
		if(cnt>0){
			result = ServiceResult.OK;
		}
		
		return result;
	}

	@Override
	public ServiceResult updateAlba(AlbaVO alba) {
		ServiceResult result = ServiceResult.FAILED;
		
		int cnt = albadao.updateAlba(alba);
		if(cnt>0){
			result = ServiceResult.OK;
		}
		
		return result;
	}

	
		
}
