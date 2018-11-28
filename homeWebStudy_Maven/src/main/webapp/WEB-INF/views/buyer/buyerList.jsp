<%@page import="java.util.Objects"%>
<%@page import="kr.or.ddit.vo.PagingInfoVO"%>
<%@page import="kr.or.ddit.vo.BuyerVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.buyer.service.BuyerServiceImpl"%>
<%@page import="kr.or.ddit.buyer.service.IBuyerService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     
<%
 	PagingInfoVO<BuyerVO> pagingVO = (PagingInfoVO)request.getAttribute("pagingVO");
	List<BuyerVO> buyerList = pagingVO.getDataList();
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.3.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

<title>buyer/buyerList.jsp</title>
<script>
	function <%=pagingVO.getFuncName()%>(page){
		document.searchForm.page.value = page;
		document.searchForm.submit();
	}
</script>

</head>
<body>
<h4> 상품 목록 </h4>

<input  class="btn btn-danger" type="button" class="button" value="홈으로 가기"	
	onclick="location.href='<%=request.getContextPath()%>/';"
/>
<input  class="btn btn-primary" type="button" class="button" value="신규 등록"	
	onclick="location.href='<%=request.getContextPath()%>/buyer/buyerInsert.do';"
/>
<table class="table">
	<thead class="thead-dark">
		<tr>
			<th>상품 IT</th>
			<th>상품 이름</th>
			<th>상품 분류</th>
			<th>은행</th>
			<th>계좌번호</th>
			<th>계좌주</th>
		</tr>
	</thead>
	<tbody>
		<%
			if(buyerList.size()!=0){
				for(BuyerVO buyer:buyerList ){
		%>
					<tr>
						<td><a href="<%=request.getContextPath()%>/buyer/buyerView.do?who=<%=buyer.getBuyer_id()%>"><%=buyer.getBuyer_id()%></a></td>
						<td><%=buyer.getBuyer_name() %></td>
						<td><%=buyer.getBuyer_lgu() %></td>
						<td><%=buyer.getBuyer_bank() %></td>
						<td><%=buyer.getBuyer_bankno() %></td>
						<td><%=buyer.getBuyer_bankname() %></td>
					</tr>
		
		<%
				}
			}else{
				%>
					<tr>
						<td colspan="6">회원의 목록이 없음.</td>
					</tr>
				<%
				
			}
		%>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="6">
				<nav aria-label="Page navigation example">
					<%=pagingVO.getPagingHTML()%>
				</nav>
				
				<form action = "" name="searchForm">
					<input type = "hidden" name = "page"/>
					<select name="searchType">
						<option value="all">전체</option>
						<option value="name">거래처이름</option>
					</select>
					
						<script type="text/javascript">
							document.searchForm.searchType.value = "<%=Objects.toString(pagingVO.getSearchType(),"all")%>";							
						</script>
						
					<input type="text" name="searchWord" value="<%=Objects.toString(pagingVO.getSearchWord(),"")%>"/>
					<input type="submit" value="검색" />
				</form>
			</td>
		</tr>
	</tfoot>
</table>
</body>
</html>