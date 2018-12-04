package kr.or.ddit.filter;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import java.io.IOException;


/**
 * Filter 구현
 *  1. Javax.servlet.Filter 구현체 작성
 *  2. lifecycle 메서드 : init , destroy
 *  	요청 filtering 메서드 : doFilter - ** chain.doFilter 메서드 호출 전에 요청 필터링
 *  								 	** chain.diFilter 메서드 호출 후에 응답 필터링
 *  									요청이 필터링 되는 순서와 응답이 필터링 되는 순서는 역순이 됨
 *  
 *  3. W.A.S 에 해당 필터를 등록(web.xml -> filter) : WAS에 의해 FilterChain 이 형성됨.
 *  4. 필터링 할 수있는 요청과의 매핑 설정(web.xml -> filter-mapping)
 *	  
 */
//@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {
	private String encoding = "UTF-8";
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		encoding = filterConfig.getInitParameter("encoding");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		request.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}

}
