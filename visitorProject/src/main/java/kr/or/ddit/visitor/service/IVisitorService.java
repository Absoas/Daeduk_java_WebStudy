package kr.or.ddit.visitor.service;

import java.util.List;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.vo.PagingInfoVO;
import kr.or.ddit.vo.VisitorVO;

public interface IVisitorService {
	
	public ServiceResult createVisitor(VisitorVO visitor);
	public long retriveVisitorCount(PagingInfoVO<VisitorVO> pagingVO);
	public List<VisitorVO> retriveVisitorList(PagingInfoVO<VisitorVO> pagingVO);
	public VisitorVO retriveVisitor(long vt_no);
	public ServiceResult modifyVisitor(VisitorVO visitor);
	public ServiceResult removeVisitor(VisitorVO visitor);
}
