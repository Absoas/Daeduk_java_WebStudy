package kr.or.home.addr.service;

import java.util.ArrayList;
import java.util.List;

import kr.or.home.addr.vo.AddrBean;

public class AddrManager {
	
	List<AddrBean> addrlist = new ArrayList<AddrBean>();
	
	public void add(AddrBean ab) {
		addrlist.add(ab);
	}
	
	public List<AddrBean> getAddrList(){
		return addrlist;
	}
}
