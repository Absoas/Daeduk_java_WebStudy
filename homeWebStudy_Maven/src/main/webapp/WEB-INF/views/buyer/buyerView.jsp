<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
</script>


<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>거래처관리 상세 조회 및 수정폼</h4>
		<table class = "table">
			<tr>
				<th>상품 ID</th>
				<td>${buyer.buyer_id}<span class="error">${errors.buyer_id}</span></td>
			</tr>
			<tr>
				<th>상품 이름</th>
				<td>${buyer.buyer_name}<span class="error">${errors.buyer_name}</span></td>
			</tr>
			<tr>
				<th>상품 분류</th>
				<td>${buyer.buyer_lgu}<span class="error">${errors.buyer_lgu}</span></td>
					
				<td>
					<table>
						<thead>
							<tr>
								<th>gu</th>
								<th>nm</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${ buyer.lprod.lprod_gu}</td>
								<td>${ buyer.lprod.lprod_nm}</td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
			<tr>
				<th>거래처 은행</th>
				<td>${buyer.buyer_bank}<span class="error">${errors.buyer_bank}</span></td>
			</tr>
			<tr>
				<th>거래처  계좌번호</th>
				<td>${buyer.buyer_bankno}<span class="error">${errors.buyer_bankno}</span></td>
			</tr>
			<tr>
				<th>거래처 계좌주</th>
				<td>${buyer.buyer_bankname}<span class="error">${errors.buyer_bankname}</span></td>
			</tr>
			<tr>
				<th>우편번호</th>
				<td>${buyer.buyer_zip}<span class="error">${errors.buyer_zip}</span></td>
			</tr>
			<tr>
				<th>주소1</th>
				<td>${buyer.buyer_add1}<span class="error">${errors.buyer_add1}</span></td>
			</tr>
			<tr>
				<th>주소2</th>
				<td>${buyer.buyer_add2}<span class="error">${errors.buyer_add2}</span></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>${buyer.buyer_comtel}<span class="error">${errors.buyer_comtel}</span></td>
			</tr>
			<tr>
				<th>팩스번호</th>
				<td>${buyer.buyer_fax}<span class="error">${errors.buyer_fax}</span></td>
			</tr>
			<tr>
				<th>메일</th>
				<td>${buyer.buyer_mail}<span class="error">${errors.buyer_mail }</span></td>
			</tr>
			<tr>
				<th>구매자</th>
				<td>
					${buyer.buyer_charger}
					<span class="error">${errors.buyer_charger }</span>
				</td>
			</tr>
		</table>
		
		<input type="button" value="뒤로 가기"
					onclick="history.go(-1)"
		 />
		<c:set var="authorized" value="${not empty sessionScope.authMember or 'ROLE_ADMIN' eq sessionScope.authMember.mem_auth }" />
		<c:if test="${authorized }">
		<input type="button" value="거래처수정" 
			onclick = "location.href='${pageContext.request.contextPath}/buyer/buyerUpdate.do?what=${requestScope.buyer.buyer_id}'"
		/>
		
		<h4>구매한 사람의 상품 목록</h4>
		<table class="table">
			<thead>
				<tr>
					<td>상품명</td>
					<td>상품가격</td>
				</tr>
			</thead>
			
			<c:set var="prod" value="${buyer.prod }"/>
			<c:if test="${not empty prod }">
				<c:forEach items="${prod }" var="tmp">
					<tr>
						<td>${tmp.prod_name }</td>
						<td>${tmp.prod_price }</td>
					</tr>
				</c:forEach>
			</c:if>
			
			<c:if test="${empty prod }">
				<td>상품 목록이 없음</td>
			</c:if>
			<tbody>
					
			</tbody>
		</table>
	</c:if>
</body>
</html>