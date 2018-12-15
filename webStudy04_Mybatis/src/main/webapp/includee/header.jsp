<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<ul>
<li><a href="<%=request.getContextPath() %>/member/memberList.do">회원관리</a></li>
<li><a href="${pageContext.request.contextPath }/prod/prodList.do">상품관리</a></li>
<li>거래처관리</li>
<li>방명록</li>
<li><a href="<c:url value='/board/boardList.do'/>">자유게시판</a></li>
</ul>