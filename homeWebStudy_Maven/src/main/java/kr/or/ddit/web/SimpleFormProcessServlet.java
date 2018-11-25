package kr.or.ddit.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.vo.AlbasengVO;


@WebServlet("/albamons")
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
	public static Map<String, AlbasengVO> albasengs  = new LinkedHashMap<>();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		resp.setContentType("text/plain;charset=UTF-8");
		String name = req.getParameter("name");
		String ageStr = req.getParameter("age");
		String tel = req.getParameter("tel");
		String address = req.getParameter("address");
		String gender = req.getParameter("gender");
		String grade = req.getParameter("grade");
		String career = req.getParameter("career");
		String license[] = req.getParameterValues("license");
		
		String goPage = null;
		
		if(name == null || name.trim().length() ==0 || 
		address == null|| address.trim().length() == 0 ||
		tel ==null || tel.trim().length() == 0){
			goPage = "/01/simpleForm.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(goPage);
			rd.forward(req, resp);
			
			return;
		}
		
		int age = Integer.parseInt(ageStr);
		
		AlbasengVO alba = new AlbasengVO();
		alba.setName(name);
		alba.setAge(age);
		alba.setTel(tel);
		alba.setAddress(address);
		alba.setGender(gender);
		alba.setGrade(grade);
		alba.setCareer(career);
		alba.setLicense(license);
		alba.setCode("alba_"+albasengs.size()+1);
		
		
		albasengs.put(alba.getCode(), alba);
		
		goPage = "/05/albaList.jsp";
		
		resp.sendRedirect(req.getContextPath() + goPage);
		
		
//		vo 객체 생성	파라미터 할당.
//		VO를 대상으로 검증
//		(이름 , 주소, 전화번호)

//		1) 통과
//			code 생성("alba_001")
//			map.put(code,vo)
//			이동(/05/albaList.jsp , 요청 처리 완료 후 이동) //redirect
//		2) 불통
//			이동(/01/simpleForm.jsp , 기존 입력데이터를 전달한채 이동 //dispatcher)
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		값을 Map으로 동적으로 받아오는 방법
		
//		Enumeration<String> names = req.getParameterNames();
//		while (names.hasMoreElements()) {
//			String name = (String) names.nextElement();
//			String[] values = req.getParameterValues(name);
//			System.out.printf("%s : %s\n", name, Arrays.toString(values));
//		}
//		
//		Map<String,String[]> parameterMap = req.getParameterMap();
//		for (Entry<String, String[]> entry : parameterMap.entrySet()) {
//			String name = entry.getKey();
//			String[] value = entry.getValue();
//			System.out.printf("%s : %s\n", name, Arrays.toString(value));
//		}
		
		
	}
}
