package kr.or.ddit.buyer.service;

import java.util.List;

import kr.or.ddit.CommonException;
import kr.or.ddit.ServiceResult;
import kr.or.ddit.buyer.dao.BuyerDAOImpl;
import kr.or.ddit.buyer.dao.IBuyerDAO;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.BuyerVO;

public class BuyerServiceImpl implements IBuyerService {

	 IBuyerDAO buyerDAO =  new BuyerDAOImpl();
	
	@Override
	public ServiceResult registBuyer(BuyerVO buyer) {
		  ServiceResult result = null;
	      if(buyerDAO.selectBuyer(buyer.getBuyer_id())==null) {
	         int rowCnt = buyerDAO.insertBuyer(buyer);
	         if(rowCnt>0) {
	            result = ServiceResult.OK;
	         }else {
	            result = ServiceResult.FAILED;
	         }
	      }else {
	         result = ServiceResult.PKDUPLICATED;
	      }
	      return result;
	}

	@Override
	public List<BuyerVO> retrieveBuyerList() {
		List<BuyerVO> buyerList = buyerDAO.selectBuyerList();
		return buyerList;
	}

	@Override
	public BuyerVO retrieveBuyer(String buyer_id) {
		BuyerVO buyer = buyerDAO.selectBuyer(buyer_id);
		   if(buyer == null) {
			   throw new CommonException();
		   }
		   return buyer;
	}

	@Override
	public ServiceResult modifyBuyer(BuyerVO buyer) {
		BuyerVO savedBuyer = retrieveBuyer(buyer.getBuyer_id());
		ServiceResult result = null;
		if(savedBuyer != null) {
			if(savedBuyer.getBuyer_id().equals(buyer.getBuyer_id())) {
				int cnt = buyerDAO.updateBuyer(buyer);
				if (cnt > 0) {
					result = ServiceResult.OK;
				} else {
					result = ServiceResult.FAILED;
				}
			}
		}
	   return result;
	}

	@Override
	public ServiceResult removeBuyer(BuyerVO buyer) {
		BuyerVO savedBuyer = retrieveBuyer(buyer.getBuyer_id());
		ServiceResult result = null;
		if (savedBuyer != null) {
			int cnt = buyerDAO.deleteBuyer(buyer.getBuyer_id());
			if (cnt > 0) {
				result = ServiceResult.OK;
			} else {
				result = ServiceResult.FAILED;
			}
		}
		return result;
	}
	
}
