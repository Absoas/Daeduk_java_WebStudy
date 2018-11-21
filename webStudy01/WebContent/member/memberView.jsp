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
			<tr><td>회원아이디</td><td><%=member.getMem_id()%></td></tr>
			<tr><td>비밀번호</td><td><%=member.getMem_pass()%></td></tr>
			<tr><td>회원명</td><td><%=member.getMem_name()%></td></tr>
			<tr><td>주민번호1</td><td><%=member.getMem_regno1()%></td></tr>
			<tr><td>주민번호2</td><td><%=member.getMem_regno2()%></td></tr>
			<tr><td>생일</td><td><%=member.getMem_bir()%></td></tr>
			<tr><td>우편번호</td><td><%=member.getMem_zip()%></td></tr>
			<tr><td>주소1</td><td><%=member.getMem_add1()%></td></tr>
			<tr><td>주소2</td><td><%=member.getMem_add2()%></td></tr>
			<tr><td>집전화번호</td><td><%=member.getMem_hometel()%></td></tr>
			<tr><td>회사전화번호</td><td><%=member.getMem_comtel()%></td></tr>
			<tr><td>휴대폰</td><td><%=member.getMem_hp()%></td></tr>
			<tr><td>이메일</td><td><%=member.getMem_mail()%></td></tr>
			<tr><td>직업</td><td><%=member.getMem_job()%></td></tr>
			<tr><td>취미</td><td><%=member.getMem_like()%></td></tr>
			<tr><td>기념일</td><td><%=member.getMem_memorial()%></td></tr>
			<tr><td>기념일자</td><td><%=member.getMem_memorialday()%></td></tr>
			<tr><td>마일리지</td><td><%=member.getMem_mileage()%></td></tr>
		<%
			} else {
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