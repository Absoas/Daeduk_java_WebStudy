package kr.or.ddit.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.web.calculate.Mime;
import kr.or.ddit.web.calculate.Operator;

public class CalculateServlet extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		// 파라미터 확보 ( 입력태그의 name 속성값으로 이름 결정 )
		String leftOpStr  = req.getParameter("leftOp");
		String rightOpStr = req.getParameter("rightOp");
		String operatorStr = req.getParameter("operator");
		
		int leftOp;
		int rightOp;
		// 검증
		boolean valid = true;
		if (leftOpStr == null && !leftOpStr.matches("\\d+") || rightOpStr == null && !rightOpStr.matches("\\d{1,6}")) {
			valid = false;
		}
		
		Operator operator = null;
		try {
			operator = Operator.valueOf(operatorStr.toUpperCase());
		} catch (Exception e) {
			valid = false;
		}
		//----------------------------------
		if(!valid) {
			// 불통 400 에러 발생
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		// 	통과
		//  연산자에 따라 연산 수행
		// 		일반 텍스트의 형태로 연산 결과를 제공.
		//	연산결과 : 2 * 3 = 6 
		leftOp = Integer.parseInt(leftOpStr);
		rightOp = Integer.parseInt(rightOpStr);
		
		String pattern = "%d %s %d = %d";
		String result = String.format(pattern, leftOp,operator.getSign(),rightOp, operator.operate(leftOp, rightOp));
		
		String accept = req.getHeader("Accept");
		
		String sMime = accept.substring(accept.indexOf("/")+1, accept.indexOf(","));
		Mime mimes = null;
		mimes = mimes.valueOf(sMime.toUpperCase());
		String pattern1 = mimes.getResult();
		result = String.format(pattern1, result);
		
		resp.setContentType(mimes.getContentType()); 
		PrintWriter out =  resp.getWriter();
		out.println(result);
		out.close();
	}
}
