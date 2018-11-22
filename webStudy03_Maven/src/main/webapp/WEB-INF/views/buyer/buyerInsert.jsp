<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="kr.or.ddit.vo.BuyerVO"%>
<%@page import="kr.or.ddit.buyer.service.BuyerServiceImpl"%>
<%@page import="kr.or.ddit.ServiceResult"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="kr.or.ddit.buyer.service.IBuyerService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!
	private boolean validate(BuyerVO buyer , Map<String,String> errors){
		boolean valid = false;	
		
		if(StringUtils.isBlank(buyer.getBuyer_id())){valid = false;errors.put("buyer_id", " 누락");}
		if(StringUtils.isBlank(buyer.getBuyer_name())){valid = false;errors.put("buyer_name", " 누락");}
		if(StringUtils.isBlank(buyer.getBuyer_lgu())){valid = false;errors.put("buyer_lgu", " 누락");}
		if(StringUtils.isBlank(buyer.getBuyer_comtel())){valid = false;errors.put("buyer_comtel", " 누락");}
		if(StringUtils.isBlank(buyer.getBuyer_fax())){valid = false;errors.put("buyer_fax", " 누락");}
		if(StringUtils.isBlank(buyer.getBuyer_mail())){valid = false;errors.put("buyer_mail", " 누락");}
		
		return valid;
	}
%>

<jsp:useBean id="buyer" scope="request" class="kr.or.ddit.vo.BuyerVO"></jsp:useBean>
<jsp:setProperty property="*" name="buyer"/>


<%
String goPage = null;
boolean redirect = false;
String message = null;
Map<String, String> errors = new LinkedHashMap<>();
request.setAttribute("errors", errors);
boolean valid = validate(buyer,errors);

if(valid){
   IBuyerService service = new BuyerServiceImpl();
   ServiceResult result = service.registBuyer(buyer);
   switch(result){
      case PKDUPLICATED :
         goPage = "/buyer/buyerForm.jsp";
         message = "아이디 중복, 바꾸셈";
         break;
      case FAILED : 
         goPage = "/buyer/buyerForm.jsp";
         message = "서버 오류로 인한 실패, 잠시 후 다시 시도";
         break;
      case OK :
     	goPage = "/buyer/buyerList.jsp";
      	redirect= true;
         break;
   }
   request.setAttribute("message", message);
} else {
   goPage = "/buyer/buyerForm.jsp";
}

if(redirect){
   response.sendRedirect(request.getContextPath() + goPage);
} else {
   RequestDispatcher rd = request.getRequestDispatcher(goPage);
   rd.forward(request, response);
}    
%>