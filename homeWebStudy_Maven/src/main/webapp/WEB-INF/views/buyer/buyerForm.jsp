<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" href="/resources/demos/style.css">

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
	
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


<script>
  $( function() {
	<c:set var="message" value="${message}"/>
	<c:if test="${not empty message}">
		alert("${message}");
	</c:if>
  });
</script>

</head>

<body>
	<h4>상품 등록</h4>
	<form method="post">
		<input type="hidden" name="buyer_id" value="${requestScope.buyer.buyer_id}"/>
		<table class = "table">
			<tr>
				<th>상품 이름</th>
				<td><input type="text" name="buyer_name"
					value="${buyer.buyer_name}" /><span class="error">${errors.buyer_name}</span></td>
			</tr>
			
			<tr>
				<th>상품 분류</th>
				<td>
				<select name="buyer_lgu">
					<c:set var="lprodList" value="${lprodList}" />
					<c:forEach items="${lprodList }" var="lprod">			
						<option value="${lprod.get('LPROD_GU')}">${lprod.get('lprod_nm')}</option>
					</c:forEach>
				</select>
				</td>
			</tr>
			
			<tr>
				<th>은행</th>
				<td><input type="text" name="buyer_bank"
					value="${buyer.buyer_bank}" /><span class="error">${errors.buyer_bank}</span></td>
			</tr>
			<tr>
				<th>계좌번호</th>
				<td><input type="text" name="buyer_bankno"
					value="${buyer.buyer_bankno}" /><span class="error">${errors.buyer_bankno}</span></td>
			</tr>
			<tr>
				<th>계좌주</th>
				<td><input type="text" name="buyer_bankname"
					value="${buyer.buyer_bankname}" /><span class="error">${errors.buyer_bankname}</span></td>
			</tr>
			<tr>
				<th>우편번호</th>
				<td><input type="text" name="buyer_zip"
					value="${buyer.buyer_zip}" /><span class="error">${errors.buyer_zip}</span></td>
			</tr>
			<tr>
				<th>주소1</th>
				<td><input type="text" name="buyer_add1"
					value="${buyer.buyer_add1}" /><span class="error">${errors.buyer_add1}</span></td>
			</tr>
			<tr>
				<th>주소2</th>
				<td><input type="text" name="buyer_add2"
					value="${buyer.buyer_add2}" /><span class="error">${errors.buyer_add2}</span></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="buyer_comtel"
					value="${buyer.buyer_comtel}" /><span class="error">${errors.buyer_comtel}</span></td>
			</tr>
			<tr>
				<th>팩스번호</th>
				<td><input type="text" name="buyer_fax"
					value="${buyer.buyer_fax}" /><span class="error">${errors.buyer_fax}</span></td>
			</tr>
			<tr>
				<th>메일</th>
				<td><input type="text" name="buyer_mail"
					value="${buyer.buyer_mail}" /><span class="error">${errors.buyer_mail}</span></td>
			</tr>
			<tr>
				<th>Charger</th>
				<td><input type="text" name="buyer_charger"
					value="${buyer.buyer_charger}" /><span class="error">${errors.buyer_charger}</span></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="등록" /> <input
					type="reset" value="취소" /></td>
			</tr>
		</table>
	</form>
</body>
</html>