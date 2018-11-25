package kr.or.ddit.lprod.service;

import java.util.List;

import kr.or.ddit.buyer.dao.BuyerDAOImpl;
import kr.or.ddit.buyer.dao.IBuyerDAO;
import kr.or.ddit.lprod.dao.ILprodDAO;
import kr.or.ddit.lprod.dao.LprodDaoImpl;
import kr.or.ddit.vo.LprodVO;

public class LprodServiceImpl implements ILprodService{
	 ILprodDAO lprodDAO =  new LprodDaoImpl();
	 
	@Override
	public List<LprodVO> retrieveLprod() {
		return lprodDAO.selectAllLprod();
	}
	
	
}
