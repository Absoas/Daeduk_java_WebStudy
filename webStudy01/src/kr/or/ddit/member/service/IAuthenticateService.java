package kr.or.ddit.member.service;

import kr.or.ddit.vo.MemberVO;
import sun.text.normalizer.ICUBinary.Authenticate;

/**
 * @author 작성자명
 * @since 2018. 11. 21.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일                          수정자               수정내용
 * --------     --------    ----------------------
 * 2018. 11. 21.      작성자명       로그인 인증
 * Copyright (c) 2018 by DDIT All right reserved
 * </pre>
 */
public interface IAuthenticateService {
	public Object authenticate(MemberVO member);
}
