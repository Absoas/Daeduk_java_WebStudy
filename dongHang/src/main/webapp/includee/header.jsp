<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
  <!-- pageheader
    ================================================== -->
    <section class="s-pageheader s-pageheader--home">

        <header class="header">
            <div class="header__content row">

                <div class="header__logo">
                    <a class="logo" href="<c:url value="/"/>">
                        <img src="${pageContext.request.contextPath}/images/logo.svg" alt="Homepage">
                    </a>
                </div> <!-- end header__logo -->
                <ul class="header__social">
                    <li>
                        <a href="${pageContext.request.contextPath}/signup/member.do "><i class="fa fa-facebook" aria-hidden="true"></i></a>
                    </li>
                    
                    <li>
                        <a href="#0"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                    </li>
                    
                    <li>
                        <a href="#0"><i class="fa fa-instagram" aria-hidden="true"></i></a>
                    </li>
                    <li>
                        <a href="#0"><i class="fa fa-pinterest" aria-hidden="true"></i></a>
                    </li>
                </ul> <!-- end header__social -->

                <a class="header__search-trigger" href="#0"></a>

                <div class="header__search">

                    <form role="search" method="get" class="header__search-form" action="#">
                        <label>
                            <span class="hide-content">Search for:</span>
                            <input type="search" class="search-field" placeholder="Type Keywords" value="" name="s" title="Search for:" autocomplete="off">
                        </label>
                        <input type="submit" class="search-submit" value="Search">
                    </form>
        
                    <a href="#0" title="Close Search" class="header__overlay-close">Close</a>

                </div>  <!-- end header__search -->

                <a class="header__toggle-menu" href="#0" title="Menu"><span>Menu</span></a>

                <nav class="header__nav-wrap">

                    <h2 class="header__nav-heading h6">Site Navigation</h2>

                    <ul class="header__nav">
                        <li class="current"><a href="<c:url value="/"/>" title="">Home</a></li>
                        <li class="has-children">
                            <a href="#0" title="">여행상품</a>
                            <ul class="sub-menu">
                            <li><a href="<c:url value="/package/packageRetrieve.do"/>">패키지상품</a></li>
                            <li><a href="<c:url value="/free/freeRetrieve.do"/>">자유상품</a></li>
                            </ul>
                        </li>
                        
                        <li class="has-children">
                            <a href="#0" title="">크루</a>
                            <ul class="sub-menu">
	                            <li><a href="<c:url value = "/crew/introboardList.do"/>">크루 소개 게시판</a></li>
	                            <li><a href="single-audio.html">Audio Post</a></li>
                            </ul>
                        </li>
                    
                        <li class="has-children">
                        	<a href="style-guide.html" title="">커뮤니티</a>
                        	  <ul class="sub-menu">
                        	  	   <li><a href="<c:url value="/tipboard/tipboardRetrieve.do"/>">여행팁 게시판</a></li>
                        	  	   <li><a href="<c:url value="/festival/festivalRetrieve.do"/>">축제정보 게시판</a></li>
                        	  	   <li><a href=" <c:url value="/freeboard/freeboardRetrieve.do"/>">자유게시판</a></li>
                        	  	   <li><a href="<c:url value="/postboard/postboardRetrieve.do"/>">후기게시판</a></li>
                        	  </ul>
                        </li>
                        
                        <li><a href="<c:url value="/eventboard/eventboardRetrieve.do"/>" title="">Event</a></li>
                        <li><a href="<c:url value="/suggest/suggestList.do"/>" title="">고객센터</a></li>
                    </ul> <!-- end header__nav -->
                    
                    <a href="#0" title="Close Menu" class="header__overlay-close close-mobile-menu">Close</a>
                </nav> <!-- end header__nav-wrap -->
            </div> <!-- header-content -->
        </header> <!-- header -->


    </section> <!-- end s-pageheader -->
    
    
    	
	<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/plugins.js"></script>
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
    
