package kr.or.ddit.common.board.suggestboard.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.common.board.suggestboard.dao.ISuggestBoardDao;
import kr.or.ddit.vo.SuggestBoardVO;

@Service
public class SuggestBoardServiceImpl implements ISuggestBoardService{

	@Inject
	ISuggestBoardDao dao;
	
	@Override
	public ServiceResult createSuggest(SuggestBoardVO sbVO) {
		ServiceResult result = ServiceResult.FAILED;
		int cnt = dao.suggestInsert(sbVO);
		if(cnt>0){
			result= ServiceResult.OK;
		}
		return result;
	}

	@Override
	public List<SuggestBoardVO> suggestList() {
		return dao.suggestList();
	}

	@Override
	public SuggestBoardVO suggestSelect(long bo_no) {
		return dao.suggestSelect(bo_no);
	}
	
}
