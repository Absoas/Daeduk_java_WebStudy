package kr.or.ddit.member.service;

import kr.or.ddit.vo.MemberVO;
import sun.text.normalizer.ICUBinary.Authenticate;

public interface IAuthenticateService {
	public Object authenticate(MemberVO member);
}
