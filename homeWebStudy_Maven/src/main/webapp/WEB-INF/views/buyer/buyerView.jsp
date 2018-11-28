<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="kr.or.ddit.member.service.MemberServiceImpl"%>
<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.3.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
$( function() {
	  <%
	  	String message= (String)request.getAttribute("message");
	 	if(StringUtils.isBlank(message)){
	 		message = (String)session.getAttribute("message");	
	 		session.removeAttribute("message");
	 	}
	 	
	  	if(StringUtils.isNotBlank(message)){
	  %>
	  		alert("<%=message%>");
	  <%
	  }
	  %>
	
	$("[type='date']").datepicker({
  		  dateFormat: "yy-mm-dd"
  	});
		
	$("#delBtn").on("click",function(){
		var chk = confirm(" 정말로 탈퇴? ");
		if(chk){
			var password = prompt("비밀번호 입력");		
			if(password){
				document.delForm.mem_pass.value = password;
				document.delForm.submit();
			}
		}
	});
});
</script>

<jsp:useBean id="buyer" class="kr.or.ddit.vo.BuyerVO" scope="request"></jsp:useBean>
<jsp:useBean id="errors" class="java.util.LinkedHashMap" scope="request"></jsp:useBean>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		
 		boolean mutable = false;
 		MemberVO authMember = (MemberVO) session.getAttribute("authMember");
 		
 		if (authMember != null && "ROLE_ADMIN".equals(authMember.getMem_auth())) {
 				mutable = true;
 		}
		
 		if(mutable){
			
	%>
	<form name="delForm" method="post" action="<%=request.getContextPath()%>/buyer/buyerDelete.do">
		<input type = "hidden" name = "mem_pass" value ="<%=authMember.getMem_pass()%>"/>
		<input type = "hidden" name = "buyer_id" value ="<%=buyer.getBuyer_id()%>"/>
	</form>
	<form action="<%=request.getContextPath()%>/buyer/buyerUpdate.do" method="post">
	<%
		}
	%>
	<h4>상품관리 상세 조회 및 수정폼</h4>
		<table class = "table">
			<tr>
				<th>상품 ID</th>
				<td><input type="text" name="buyer_id"
					value="<%=buyer.getBuyer_id()%>" /><span class="error"><%=errors.get("buyer_id")%></span></td>
			</tr>
			<tr>
				<th>상품 이름</th>
				<td><input type="text" name="buyer_name"
					value="<%=buyer.getBuyer_name()%>" /><span class="error"><%=errors.get("buyer_name")%></span></td>
			</tr>
			<tr>
				<th>상품 분류</th>
				<td><input type="text" name="buyer_lgu"
					value="<%=buyer.getBuyer_lgu()%>" /><span class="error"><%=errors.get("buyer_lgu")%></span></td>
					
				<td>
					<table>
						<thead>
							<tr>
								<th>id</th>
								<th>gu</th>
								<th>nm</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><%=buyer.getLprod().getLprod_id() %></td>
								<td><%=buyer.getLprod().getLprod_gu() %></td>
								<td><%=buyer.getLprod().getLprod_nm() %></td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
			<tr>
				<th>은행</th>
				<td><input type="text" name="buyer_bank"
					value="<%=buyer.getBuyer_bank()%>" /><span class="error"><%=errors.get("buyer_bank")%></span></td>
			</tr>
			<tr>
				<th>계좌번호</th>
				<td><input type="text" name="buyer_bankno"
					value="<%=buyer.getBuyer_bankno()%>" /><span class="error"><%=errors.get("buyer_bankno")%></span></td>
			</tr>
			<tr>
				<th>계좌주</th>
				<td><input type="text" name="buyer_bankname"
					value="<%=buyer.getBuyer_bankname()%>" /><span class="error"><%=errors.get("buyer_bankname")%></span></td>
			</tr>
			<tr>
				<th>우편번호</th>
				<td><input type="text" name="buyer_zip"
					value="<%=buyer.getBuyer_zip()%>" /><span class="error"><%=errors.get("buyer_zip")%></span></td>
			</tr>
			<tr>
				<th>주소1</th>
				<td><input type="text" name="buyer_add1"
					value="<%=buyer.getBuyer_add1()%>" /><span class="error"><%=errors.get("buyer_add1")%></span></td>
			</tr>
			<tr>
				<th>주소2</th>
				<td><input type="text" name="buyer_add2"
					value="<%=buyer.getBuyer_add2()%>" /><span class="error"><%=errors.get("buyer_add2")%></span></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="buyer_comtel"
					value="<%=buyer.getBuyer_comtel()%>" /><span class="error"><%=errors.get("buyer_comtel")%></span></td>
			</tr>
			<tr>
				<th>팩스번호</th>
				<td><input type="text" name="buyer_fax"
					value="<%=buyer.getBuyer_fax()%>" /><span class="error"><%=errors.get("buyer_fax")%></span></td>
			</tr>
			<tr>
				<th>메일</th>
				<td><input type="text" name="buyer_mail"
					value="<%=buyer.getBuyer_mail()%>" /><span class="error"><%=errors.get("buyer_mail") %></span></td>
			</tr>
			<tr>
				<th>Charger</th>
				<td><input type="text" name="buyer_charger"
					value="<%=buyer.getBuyer_charger() %>" /><span class="error"><%=errors.get("buyer_charger") %></span></td>
			</tr>

			<tr>
				<td colspan="2">
					<input type="button" value="뒤로 가기"
						onclick="history.go(-1)"
					 />
				<% 
					if(mutable){
				%>						
					<input type="submit" value="수정" />
					<input type="reset" value="취소" />
					<input type="button" value = "탈퇴" id="delBtn"/>
				<%
					}
				%>
				</td>
			</tr>
		</table>
<%
if(mutable){
%>	
	</form>
<%
}
%>
</body>
</html>