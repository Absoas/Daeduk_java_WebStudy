package kr.or.ddit.visitor.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.visitor.dao.IVisitorDAO;
import kr.or.ddit.visitor.dao.VisitorDaoImpl;
import kr.or.ddit.vo.PagingInfoVO;
import kr.or.ddit.vo.VisitorVO;

public class VisitorServiceImpl implements IVisitorService {

	IVisitorDAO visitorDAO = new VisitorDaoImpl();
	
	@Override
	public ServiceResult createVisitor(VisitorVO visitor) {
		try(
			SqlSession session = 
			CustomSqlSessionFactoryBuilder.getSqlSessionFactory()
			.openSession(false);
		){		
			ServiceResult result = ServiceResult.FAILED;
			int rowCnt = visitorDAO.insertVisitor(visitor, session);
//			int check = 1;
			if(rowCnt>0) {
//				if(board.getPdsList()!=null)
//						check += board.getPdsList().size();
//					rowCnt += processFiles(board, session);
//				}
//				ServiceResult result = ServiceResult.FAILED;
//				if(rowCnt>=check) {
				result = ServiceResult.OK;
				session.commit();
			}
			return result;
		}
	}

	@Override
	public long retriveVisitorCount(PagingInfoVO<VisitorVO> pagingVO) {
		return visitorDAO.selectTotalRecord(pagingVO);
	}

	@Override
	public List<VisitorVO> retriveVisitorList(PagingInfoVO<VisitorVO> pagingVO) {
		return visitorDAO.selectVisitorList(pagingVO);
	}

	@Override
	public VisitorVO retriveVisitor(long vt_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResult modifyVisitor(VisitorVO visitor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResult removeVisitor(VisitorVO visitor) {
		// TODO Auto-generated method stub
		return null;
	}

}
