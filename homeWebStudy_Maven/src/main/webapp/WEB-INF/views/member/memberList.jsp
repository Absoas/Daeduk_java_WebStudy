<%@page import="java.util.Objects"%>
<%@page import="kr.or.ddit.vo.PagingInfoVO"%>
<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.member.service.MemberServiceImpl"%>
<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
 	PagingInfoVO pagingVO = (PagingInfoVO)request.getAttribute("pagingVO");
	List<MemberVO> memberList = pagingVO.getDataList();

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
<script type="text/javascript">
	function <%=pagingVO.getFuncName()%>(page){
		document.searchForm.page.value = page;
		document.searchForm.submit();
	}
</script>
<title>member/memberList.jsp</title>
</head>
<body>
<h4> 회원 목록 </h4>

<input  class="btn btn-primary" type="button" class="button" value="신규 등록"	
	onclick="location.href='<%=request.getContextPath()%>/member/memberInsert.do';"
/>
<table class="table">
	<thead class="thead-dark">
		<tr>
			<th>회원아이디</th>
			<th>회원명</th>
			<th>주소</th>
			<th>회원휴대폰</th>
			<th>회원이메일</th>
			<th>마일리지</th>
		</tr>
	</thead>
	<tbody>
		<%
			if(memberList.size()!=0){
				for(MemberVO member:memberList ){
		%>
					<tr>
						<td><%=member.getMem_id()%></td>
						<td><a href="<%=request.getContextPath()%>/member/memberView.do?who=<%=member.getMem_id()%>"><%=member.getMem_name()%></a></td>
						<td><%=member.getAddress()%></td>
						<td><%=member.getMem_hp()%></td>
						<td><%=member.getMem_mail()%></td>
						<td><%=member.getMem_mileage()%></td>
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
						<option value="name">이름</option>
						<option value="address">지역</option>
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