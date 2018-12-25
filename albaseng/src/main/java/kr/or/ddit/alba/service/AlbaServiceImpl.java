package kr.or.ddit.alba.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.alba.dao.IAlbaDAO;
import kr.or.ddit.vo.AlbaVO;
import kr.or.ddit.vo.LicenseVO;
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

	@Transactional
	@Override
	public ServiceResult createAlba(AlbaVO alba) {
		ServiceResult result = ServiceResult.FAILED;
		
		int cnt = albadao.insertAlba(alba);
		int check = 1;
				
		if(alba.getLicense()!= null && alba.getLicense().size()>0){
			check = alba.getLicense().size();
					
			for(LicenseVO lic : alba.getLicense()){
				lic.setAlba_code(alba.getAlba_code());
				cnt += albadao.licanseInsert(lic);
			}
		}
		
		if(cnt >= check){
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
