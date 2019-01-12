package kr.or.ddit.common.board.suggestboard.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.SuggestBoardVO;

@Repository
public interface ISuggestBoardDao {
	
	public int suggestInsert(SuggestBoardVO sbVO);

	public List<SuggestBoardVO> suggestList();
	
	public SuggestBoardVO suggestSelect(long bo_no);
}
