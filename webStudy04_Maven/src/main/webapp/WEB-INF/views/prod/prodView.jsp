<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://jqueryui.com/resources/demos/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class= "table">
		<tr>
			<th>상품코드</th>
			<td>${requestScope.prod.prod_id}</td>
		</tr>
		<tr>
			<th>상품명</th>
			<td>${requestScope.prod.prod_name}</td>
		</tr>
		<tr>
			<th>분류명</th>
			<td>${requestScope.prod.lprod_nm}</td>
		</tr>
		<tr>
			<th>거래처정보</th>
			<td>
				<table>
					<thead>
						<tr>
							<th>거래처명</th>
							<th>소재지</th>
							<th>담당자명</th>
							<th>연락처</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${requestScope.prod.buyer.buyer_name}</td>
							<td>${requestScope.prod.buyer.buyer_add1}</td>
							<td>${requestScope.prod.buyer.buyer_charger}</td>
							<td>${requestScope.prod.buyer.buyer_comtel}</td>
						</tr>
					</tbody>
				</table>
			</td>
		</tr>
		<tr>
			<th>구매가</th>
			<td>${requestScope.prod.prod_cost}</td>
		</tr>
		<tr>
			<th>판매가</th>
			<td>${requestScope.prod.prod_price}</td>
		</tr>
		<tr>
			<th>특판가</th>
			<td>${requestScope.prod.prod_sale}</td>
		</tr>
		<tr>
			<th>상품개요</th>
			<td>${requestScope.prod.prod_outline}</td>
		</tr>
		<tr>
			<th>상세정보</th>
			<td>${requestScope.prod.prod_detail}</td>
		</tr>
		<tr>
			<th>이미지경로</th>
			<td>${requestScope.prod.prod_img}</td>
		</tr>
		<tr>
			<th>재고량</th>
			<td>${requestScope.prod.prod_totalstock}</td>
		</tr>
		<tr>
			<th>입고일</th>
			<td>${requestScope.prod.prod_insdate}</td>
		</tr>
		<tr>
			<th>적정재고</th>
			<td>${requestScope.prod.prod_properstock}</td>
		</tr>
		<tr>
			<th>상품크기</th>
			<td>${requestScope.prod.prod_size}</td>
		</tr>
		
		<tr>
			<th>상품색상</th>
			<td>${requestScope.prod.prod_color}</td>
		</tr>
		
		<tr>
			<th>배송방법</th>
			<td>${requestScope.prod.prod_delivery}</td>
		</tr>
		
		<tr>
			<th>단위</th>
			<td>${requestScope.prod.prod_unit}</td>
		</tr>
		<tr>
			<th>입고량</th>
			<td>${requestScope.prod.prod_qtyin}</td>
		</tr>
		<tr>
			<th>판매량</th>
			<td>${requestScope.prod.prod_qtysale}</td>
		</tr>
		<tr>
			<th>마일리지</th>
			<td>${requestScope.prod.prod_mileage}</td>
		</tr>
	</table>
	<c:set var="authorized" value="false"/>
	<c:set var="authMember" value="${sessionScope.authMember }"/>
	<c:set var="authorized" value="${not empty authMember and 'ROLE_ADMIN' eq authMember.mem_auth }" />
	<c:if test="authorized">
		<input type="button" value="상품수정" 
			onclick = "location.href='${pageContext.request.contextPath}/prod/prodUpdate.do?what=${requestScope.prod.prod_id}'"
		/>
		<h4>구매자 목록</h4>
		<table class="table">
			<thead>
				<tr>
					<th>회원아이디</th>
					<th>회원명</th>
					<th>주소</th>
					<th>연락처</th>
					<th>이메일</th>
				</tr>
			</thead>
			<tbody>
			<c:set var="customers" value="${prod.customers}" />
			<c:choose>
				<c:when test="${not empty customers }">
					<c:forEach var="tmp" items="${customers }">
						<tr>
							<td>${tmp.mem_id}</td>
							<td>${tmp.mem_name}</td>
							<td>${tmp.address}</td>
							<td>${tmp.mem_hp}</td>
							<td>${tmp.mem_mail}</td>
						</tr>
					</c:forEach>
				</c:when>
				
				<c:otherwise>
					<tr>
						<td colspan="5">구매자가 엄슴.</td>
					</tr>
				</c:otherwise>
			</c:choose>
		
			</tbody>
		</table>
	</c:if> 
</body>
</html>
















