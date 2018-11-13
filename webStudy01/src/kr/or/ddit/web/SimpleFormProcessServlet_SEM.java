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

public class SimpleFormProcessServlet_SEM extends HttpServlet {
   
   public static Map<String, String> gradeMap;
   public static Map<String, String> licenseMap;
   static {
      gradeMap = new HashMap<String,String>();
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
      licenseMap.put("L006", "SQLP");
   }
   public static Map<String, AlbasengVO> albasengs = new LinkedHashMap<>();
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      req.setCharacterEncoding("UTF-8");
      String name = req.getParameter("name");
      String age = req.getParameter("age");
      String tel = req.getParameter("tel");
      String addr = req.getParameter("address");
      String gender = req.getParameter("gender");
      String greade = req.getParameter("grade");
      String career = req.getParameter("career");
      String[] lincense = req.getParameterValues("license");
      AlbasengVO av = new AlbasengVO();
      av.setName(name);
      if(age != null && !age.matches("\\d{1,2}")) {
         av.setAge(new Integer(age));
      }
      av.setTel(tel);
      av.setAddress(addr);
      av.setGender(gender);
      av.setGrade(greade);
      av.setCareer(career);
      av.setLicense(lincense);
      
      String goPage = null;
      boolean valid = false;
      
      if(StringUtils.isBlank(av.getName()) || StringUtils.isBlank(av.getTel()) || StringUtils.isBlank(av.getAddress())) {
         valid = true;
      }
      
      boolean redirect = false;
      if(valid) {
         av.setCode(String.format("alba_%03d", albasengs.size()+1));
         albasengs.put(av.getCode(), av);
         goPage = "/05/albaList.jsp";
         redirect = true;
      }else {
         goPage = "01/simpleForm.jsp";
      }
      if(redirect) {
         resp.sendRedirect(req.getContextPath() + goPage);
      }else {
         RequestDispatcher rd = req.getRequestDispatcher(goPage);
         rd.forward(req, resp);
      }
      
   }
}