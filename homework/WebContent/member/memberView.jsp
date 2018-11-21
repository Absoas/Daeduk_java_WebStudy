<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="kr.or.ddit.member.service.MemberServiceImpl"%>
<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String mem_id = request.getParameter("who");
	MemberVO member = null;
	if(mem_id!=null){
		IMemberService service = new MemberServiceImpl();
		member = service.retrieveMember(mem_id);
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<%
		if(member!=null){
		%>
			<tr>
				<td><%=member.getMem_id()%></td>
				<td><%=member.getMem_pass()%></td>
				<td><%=member.getMem_name()%></td>
				<td><%=member.getMem_regno1()%></td>
				<td><%=member.getMem_regno2()%></td>
				<td><%=member.getMem_bir()%></td>
				<td><%=member.getMem_zip()%></td>
				<td><%=member.getMem_add1()%></td>
				<td><%=member.getMem_add2()%></td>
				<td><%=member.getMem_hometel()%></td>
				<td><%=member.getMem_comtel()%></td>
				<td><%=member.getMem_hp()%></td>
				<td><%=member.getMem_mail()%></td>
				<td><%=member.getMem_job()%></td>
				<td><%=member.getMem_like()%></td>
				<td><%=member.getMem_memorial()%></td>
				<td><%=member.getMem_memorialday()%></td>
				<td><%=member.getMem_mileage()%></td>
				<td><%=member.getMem_delete()%></td>
			</tr>
		<%
		}else{
		%>
			
			<tr>
				<td>정보를 찾을 수 없습니다.</td>
			</tr>
		<%
			}
		%>
	</table>
</body>
</html>