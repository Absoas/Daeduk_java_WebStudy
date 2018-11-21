package kr.or.ddit;

/**
 * @author yb
 * @since 2018. 11. 21.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일                          수정자               수정내용
 * --------     --------    ----------------------
 * 2018. 11. 21.      작성자명       전역적으로 사용할 Exceptiorn
 * Copyright (c) 2018 by DDIT All right reserved
 * </pre>
 */
public class CommonException extends RuntimeException {

	public CommonException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CommonException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CommonException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CommonException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
