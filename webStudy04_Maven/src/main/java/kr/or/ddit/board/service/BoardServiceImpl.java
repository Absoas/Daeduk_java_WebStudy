package kr.or.ddit.board.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.CommonException;
import kr.or.ddit.ServiceResult;
import kr.or.ddit.board.dao.BoardDAOImpl;
import kr.or.ddit.board.dao.IBoardDAO;
import kr.or.ddit.board.dao.IPdsDAO;
import kr.or.ddit.board.dao.PdsDAOImpl;
import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.PagingInfoVO;
import kr.or.ddit.vo.PdsVO;

public class BoardServiceImpl implements IBoardService {
	
	IBoardDAO boardDAO = new BoardDAOImpl();
	IPdsDAO pdsDAO = new PdsDAOImpl();
	
	@Override
	public ServiceResult createBoard(BoardVO board) {
		try(
				SqlSession session = CustomSqlSessionFactoryBuilder.getSqlSessionFactory().openSession(false);
		){
			ServiceResult result = ServiceResult.FAILED;
			int cnt = boardDAO.insertBoard(board, session);
			int check = 1;
			
			File saveFolder = new File("d:/boardFiles");
			if(!saveFolder.exists()) saveFolder.mkdirs();
			
			if(cnt>0) {
				result = ServiceResult.OK;
				List<PdsVO> pdsList = board.getPdsList();
				if(pdsList!=null) {
//					if(1==1)
//					throw new RuntimeException("트랙잭션 관리 여부 확인을 위한 강제 예외");
					check += pdsList.size();
					cnt = cnt + pdsDAO.insertPdsList(board,session);
	
					for(PdsVO pds : pdsList) {
						try(
							InputStream in =  pds.getItem().getInputStream();
						)
						{
							FileUtils.copyInputStreamToFile(in, new File(saveFolder,pds.getPds_savename()));
						}catch(IOException e) {
							
						}
					}
				}
			}
			if(cnt>=check) {
				result = ServiceResult.OK;
				session.commit();
			}
			return result;
		}
	}

	@Override
	public long retriveBoardCount(PagingInfoVO<BoardVO> pagingVO) {
		return boardDAO.selectTotalRecord(pagingVO);
	}

	@Override
	public List<BoardVO> retriveBoardList(PagingInfoVO<BoardVO> pagingVO) {
		return  boardDAO.selectBoardList(pagingVO);
	}

	@Override
	public BoardVO retriveBoard(long bo_no) {
		BoardVO board = boardDAO.selectBoard(bo_no);
		if(board==null) {
			throw new CommonException(bo_no + "에 해당하는 게시글이 없습니다.");
		}
		boardDAO.incrementHit(bo_no);
		return board;
	}

	@Override
	public ServiceResult modifyBoard(BoardVO board) {
		return null;
	}

	@Override
	public ServiceResult removeBoard(BoardVO board) {
		return null;
	}

	@Override
	public PdsVO downloadPds(long pds_no) {
		return pdsDAO.selectPds(pds_no);
	}

}
