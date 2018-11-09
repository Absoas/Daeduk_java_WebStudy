package kr.or.ddit.web;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SimpleFormProcessServlet extends HttpServlet {
	
	public static Map<String, String> gradeMap;
	public static Map<String, String> licenseMap;
	
	static {

		gradeMap = new HashMap<String, String>();
		licenseMap = new LinkedHashMap<>();
		
		gradeMap.put("G001", "고졸");
		gradeMap.put("G002", "대졸");
		gradeMap.put("G003", "석사");
		gradeMap.put("G004", "박사");
		
		licenseMap.put("L001", "정보처리산업기사");
		licenseMap.put("L002", "정보처리기사");
		licenseMap.put("L003", "정보보안산업기사");
		licenseMap.put("L004", "정보보안기사");
		licenseMap.put("L005", "SQLD");
		licenseMap.put("L005", "SQLP");
	}
	
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
	
		for (Entry<String, String[]> entry : map.entrySet()) {
			String name = entry.getKey();
			String[] value = entry.getValue();
			System.out.printf("%s : %s \n", name, Arrays.toString(value));
		}
		
	}
}
