package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.CommonException;
import kr.or.ddit.ServiceResult;
import kr.or.ddit.prod.dao.IProdDAO;
import kr.or.ddit.prod.dao.ProdDAOImpl;
import kr.or.ddit.vo.PagingInfoVO;
import kr.or.ddit.vo.ProdVO;

public class ProdServiceImpl implements IProdService {

	IProdDAO prodDAO = new ProdDAOImpl();
	
	@Override
	public ServiceResult createProd(ProdVO prod) {
		int cnt = prodDAO.insertProd(prod);
		ServiceResult result = null;
		if(cnt>0) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAILED;
		}
		return result;
	}

	@Override
	public ProdVO retrieveProd(String prod_id) {
		ProdVO prod = prodDAO.selectProd(prod_id);
		if(prod==null) {
			throw new CommonException(prod_id+"에 해당하는 상품이 없슴.");
		}
		return prod;
	}

	@Override
	public long retrieveProdCount(PagingInfoVO<ProdVO> pagingVO) {
		return prodDAO.selectTotalRecord(pagingVO);
	}

	@Override
	public List<ProdVO> retrieveProdList(PagingInfoVO<ProdVO> pagingVO) {
		return prodDAO.selectProdList(pagingVO);
	}

	@Override
	public ServiceResult modifyProd(ProdVO prod) {
		retrieveProd(prod.getProd_id());

		int cnt = prodDAO.updateProd(prod);
		ServiceResult result = null;
		if(cnt>0) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAILED;
		}
		return result;
	}

}



