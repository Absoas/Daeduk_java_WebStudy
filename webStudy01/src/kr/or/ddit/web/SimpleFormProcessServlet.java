package kr.or.ddit.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
@WebServlet("/albamon")


public class SimpleFormProcessServlet extends HttpServlet {
	public static Map<String, String> gradeMap;
	public static Map<String, String> licenseMap;
	static {
		gradeMap = new HashMap<>();
		licenseMap = new LinkedHashMap<>();
		
		gradeMap.put("G001", "고졸");
		gradeMap.put("G002", "대졸");
		gradeMap.put("G003", "석사");
		gradeMap.put("G004", "박사");
		
		licenseMap.put("L001", "정보처리산업기사");
		licenseMap.put("L002", "정보처리기사");
		licenseMap.put("L003", "정보보안산업기사");
		licenseMap.put("L004", "정보처리기사");
		licenseMap.put("L005", "SQLD");
		licenseMap.put("L006", "SQLP");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8"
				+ ""
				+ ""
				+ "");
		
		resp.setContentType("text/plain;charset=UTF-8");
//		String name = req.getParameter("name");
//		System.out.printf("%s : %s\n", "name", name);
//		String age = req.getParameter("age");
//		System.out.printf("%s : %s\n", "age", age);
//		String tel = req.getParameter("tel");
//		System.out.printf("%s : %s\n", "tel", tel);
//		String address = req.getParameter("address");
//		System.out.printf("%s : %s\n", "address", address);
//		String gender = req.getParameter("gender");
//		System.out.printf("%s : %s\n", "gender", gender);
//		String grade = req.getParameter("grade");
//		System.out.printf("%s : %s\n", "grade", grade);
//		String carrer = req.getParameter("carrer");
//		System.out.printf("%s : %s\n", "carrer", carrer);
//		
//		String license[] = req.getParameterValues("license");
//		System.out.printf("%s : %s\n", "license", Arrays.toString(license));
		
		Enumeration<String> names = req.getParameterNames();
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			String[] values = req.getParameterValues(name);
			System.out.printf("%s : %s\n", name, Arrays.toString(values));
		}
		
		Map<String,String[]> parameterMap = req.getParameterMap();
		for (Entry<String, String[]> entry : parameterMap.entrySet()) {
			String name = entry.getKey();
			String[] value = entry.getValue();
			System.out.printf("%s : %s\n", name, Arrays.toString(value));
		}
//		StringBuffer sb = new StringBuffer();
//		sb.append(name +"\n");
//		sb.append(age + "\n");
//		sb.append(tel + "\n");
//		sb.append(address + "\n");
//		sb.append(gender + "\n");
//		switch(grade) {
//		case "g001":
//			sb.append("고졸\n");
//			break;
//		case "g002":
//			sb.append("대졸\n");
//			break;
//		case "g003":
//			sb.append("석사\n");
//			break;
//		case "g004":
//			sb.append("박사\n");
//			break;	
//		}
//		sb.append(carrer + "\n");
//		for (int i = 0; i < license.length; i++) {
//			switch (license[i]) {
//			case "L001":
//				sb.append(license);
//				break;
//
//			default:
//				break;
//			}
//		}
//		sb.append(license);
//
//		PrintWriter out = resp.getWriter();
//		out.println(sb.toString());
//		out.close();
//		
		
		
	}
}
