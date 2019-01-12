package kr.or.ddit.common.board.suggestboard.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.vo.SuggestBoardVO;

@Service
public interface ISuggestBoardService {
	
	/**
	 * @author 박지원
	 * @param sbVO
	 * @return 
	 * 건의사항게시판을 등록하는 메서드
	 */
	public ServiceResult createSuggest(SuggestBoardVO sbVO);
	
	// 여러개 가져오고 싶다 해당 타입의 리스트를 가져오는거야
	//	public List<SuggestBoardVO>
	
	public List<SuggestBoardVO> suggestList();
	
	//하나만 가져오고싶다 해당 타입의 VO 하나
	//	public SuggestBoardVO
	
	public SuggestBoardVO suggestSelect(long bo_no);
		
		
}
