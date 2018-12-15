<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/index.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bulma.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>

</head>
<body>
  <section class="hero is-medium is-primary">
      <div class="hero-body">
        <div class="container">
          <div class="columns">
            <div class="column is-8-desktop is-offset-2-desktop">
              <h1 class="title is-2 is-spaced">
                Hello, Everyone!!
              </h1>
              <h2 class="subtitle is-4">
                  	환영합니다. 연습으로 만든 방명록입니다. ! <strong>KYB</strong> project.
                  <br>
                  	Welcome.<strong>  Daeduk Pratice Project</strong>
              </h2>
            </div>
          </div>
        </div>
      </div>
    </section>
	<c:url var="insert" value="visitor/visitorInsert.do"/>
	<a href="${insert}">방명록 쓰러가기</a>
</body>
</html>









