package kr.or.ddit.web;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SimpleFormProcessServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		Enumeration<String> e = req.getParameterNames();
		
		while(e.hasMoreElements()) {
			String name = (String) e.nextElement();
			String[] values = req.getParameterValues(name);
			System.out.printf("%s : %s \n" , name , Arrays.toString(values));
		}
		
		//req.getParameterMap();
		System.out.println("----------------------------\n\n ---------------------------");
		
		Map<String, String[]> map = req.getParameterMap(); 
	
		for(Entry<String, String[]> entry : map.entrySet()) {
			String name = entry.getKey();
			String[] value = entry.getValue();
			System.out.printf("%s : %s \n" , name , Arrays.toString(value));
		}
		
	}
}
