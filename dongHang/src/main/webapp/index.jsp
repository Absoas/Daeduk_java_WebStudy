<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <!--- basic page needs
    ================================================== -->
    <meta charset="utf-8">
    <title>동행</title>
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- mobile specific metas
    ================================================== -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <!-- CSS
    ================================================== -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/vendor.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">

    <!-- script
    ================================================== -->
    <script src="${pageContext.request.contextPath}/js/modernizr.js"></script>
    <script src="${pageContext.request.contextPath}/js/pace.min.js"></script>

    <!-- favicons
    ================================================== -->
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="icon" href="favicon.ico" type="image/x-icon">
</head>

<body>

    <div id="header">
		<jsp:include page="/includee/header.jsp" />
	</div>	
	
	<br>
	<br>

    <div id="body" >
    	 <section class="s-content">
	        <div class="row masonry-wrap">
	            <div class="masonry">
	
	                <div class="grid-sizer"></div>
	
	                <article class="masonry__brick entry format-standard" data-aos="fade-up">
	                        
	                    <div class="entry__thumb">
	                        <a href="single-standard.html" class="entry__thumb-link">
	                            <img src="images/thumbs/masonry/lamp-400.jpg" 
	                 				srcset="images/thumbs/masonry/lamp-400.jpg 1x, images/thumbs/masonry/lamp-800.jpg 2x" alt="">
	                        </a>
	                    </div>
	    
	                    <div class="entry__text">
	                        <div class="entry__header">
	                            <div class="entry__date">
	                                <a href="single-standard.html">December 15, 2017</a>
	                            </div>
	                            <h1 class="entry__title"><a href="single-standard.html">Just a Standard Format Post.</a></h1>
	                        </div>
	                        <div class="entry__excerpt">
	                            <p>
	                                Lorem ipsum Sed eiusmod esse aliqua sed incididunt aliqua incididunt mollit id et sit proident dolor nulla sed commodo est ad minim elit reprehenderit nisi officia aute incididunt velit sint in aliqua...
	                            </p>
	                        </div>
	                        <div class="entry__meta">
	                            <span class="entry__meta-links">
	                                <a href="category.html">Design</a> 
	                                <a href="category.html">Photography</a>
	                            </span>
	                        </div>
	                    </div>
	    
	                </article> <!-- end article -->
	
	             	<article class="masonry__brick entry format-standard" data-aos="fade-up">
	             	
	                    <div class="entry__thumb">
	                        <a href="single-standard.html" class="entry__thumb-link">
	                            <img src="images/thumbs/masonry/lamp-400.jpg" 
	                                    srcset="images/thumbs/masonry/lamp-400.jpg 1x, images/thumbs/masonry/lamp-800.jpg 2x" alt="">
	                        </a>
	                    </div>
	    
	                    <div class="entry__text">
	                        <div class="entry__header">
	                            
	                            <div class="entry__date">
	                                <a href="single-standard.html">December 15, 2017</a>
	                            </div>
	                            <h1 class="entry__title"><a href="single-standard.html">Just a Standard Format Post.</a></h1>
	                            
	                        </div>
	                        <div class="entry__excerpt">
	                            <p>
	                                Lorem ipsum Sed eiusmod esse aliqua sed incididunt aliqua incididunt mollit id et sit proident dolor nulla sed commodo est ad minim elit reprehenderit nisi officia aute incididunt velit sint in aliqua...
	                            </p>
	                        </div>
	                        
	                        <div class="entry__meta">
	                            <span class="entry__meta-links">
	                                <a href="category.html">Design</a> 
	                                <a href="category.html">Photography</a>
	                            </span>
	                        </div>
	                    </div>
	    
	                </article> <!-- end article -->
	             	
	             	                <article class="masonry__brick entry format-standard" data-aos="fade-up">
	                        
	                    <div class="entry__thumb">
	                        <a href="single-standard.html" class="entry__thumb-link">
	                            <img src="images/thumbs/masonry/lamp-400.jpg" 
	                                    srcset="images/thumbs/masonry/lamp-400.jpg 1x, images/thumbs/masonry/lamp-800.jpg 2x" alt="">
	                        </a>
	                    </div>
	    
	                    <div class="entry__text">
	                        <div class="entry__header">
	                            
	                            <div class="entry__date">
	                                <a href="single-standard.html">December 15, 2017</a>
	                            </div>
	                            <h1 class="entry__title"><a href="single-standard.html">Just a Standard Format Post.</a></h1>
	                            
	                        </div>
	                        <div class="entry__excerpt">
	                            <p>
	                                Lorem ipsum Sed eiusmod esse aliqua sed incididunt aliqua incididunt mollit id et sit proident dolor nulla sed commodo est ad minim elit reprehenderit nisi officia aute incididunt velit sint in aliqua...
	                            </p>
	                        </div>
	                        <div class="entry__meta">
	                            <span class="entry__meta-links">
	                                <a href="category.html">Design</a> 
	                                <a href="category.html">Photography</a>
	                            </span>
	                        </div>
	                    </div>
	                </article> <!-- end article -->
	
	            </div> <!-- end masonry -->
	        </div> <!-- end masonry-wrap -->
	
	        <div class="row">
	            <div class="col-full">
	                <nav class="pgn">
	                    <ul>
	                        <li><a class="pgn__prev" href="#0">Prev</a></li>
	                        <li><a class="pgn__num" href="#0">1</a></li>
	                        <li><span class="pgn__num current">2</span></li>
	                        <li><a class="pgn__num" href="#0">3</a></li>
	                        <li><a class="pgn__num" href="#0">4</a></li>
	                        <li><a class="pgn__num" href="#0">5</a></li>
	                        <li><span class="pgn__num dots">…</span></li>
	                        <li><a class="pgn__num" href="#0">8</a></li>
	                        <li><a class="pgn__next" href="#0">Next</a></li>
	                    </ul>
	                </nav>
	            </div>
	        </div>
	
	    </section> <!-- s-content -->
	
	
	    <!-- s-extra
	    ================================================== -->
	    <section class="s-extra">
	
	        <div class="row top">
	
	            <div class="col-eight md-six tab-full popular">
	                <h3>Popular Posts</h3>
	
	                <div class="block-1-2 block-m-full popular__posts">
	                    <article class="col-block popular__post">
	                        <a href="#0" class="popular__thumb">
	                            <img src="images/thumbs/small/wheel-150.jpg" alt="">
	                        </a>
	                        <h5><a href="#0">Visiting Theme Parks Improves Your Health.</a></h5>
	                        <section class="popular__meta">
	                                <span class="popular__author"><span>By</span> <a href="#0"> John Doe</a></span>
	                            <span class="popular__date"><span>on</span> <time datetime="2017-12-19">Dec 19, 2017</time></span>
	                        </section>
	                    </article>
	                    <article class="col-block popular__post">
	                        <a href="#0" class="popular__thumb">
	                            <img src="images/thumbs/small/shutterbug-150.jpg" alt="">
	                        </a>
	                        <h5><a href="#0">Key Benefits Of Family Photography.</a></h5>
	                        <section class="popular__meta">
	                            <span class="popular__author"><span>By</span> <a href="#0"> John Doe</a></span>
	                            <span class="popular__date"><span>on</span> <time datetime="2017-12-18">Dec 18, 2017</time></span>
	                        </section>
	                    </article>
	                    <article class="col-block popular__post">
	                        <a href="#0" class="popular__thumb">
	                            <img src="images/thumbs/small/cookies-150.jpg" alt="">
	                        </a>
	                        <h5><a href="#0">Absolutely No Sugar Oatmeal Cookies.</a></h5>
	                        <section class="popular__meta">
	                                <span class="popular__author"><span>By</span> <a href="#0"> John Doe</a></span>
	                            <span class="popular__date"><span>on</span> <time datetime="2017-12-16">Dec 16, 2017</time></span>
	                        </section>
	                    </article>
	                    <article class="col-block popular__post">
	                        <a href="#0" class="popular__thumb">
	                            <img src="images/thumbs/small/beetle-150.jpg" alt="">
	                        </a>
	                        <h5><a href="#0">Throwback To The Good Old Days.</a></h5>
	                        <section class="popular__meta">
	                            <span class="popular__author"><span>By</span> <a href="#0"> John Doe</a></span>
	                            <span class="popular__date"><span>on</span> <time datetime="2017-12-16">Dec 16, 2017</time></span>
	                        </section>
	                    </article>
	                    <article class="col-block popular__post">
	                        <a href="#0" class="popular__thumb">
	                            <img src="images/thumbs/small/tulips-150.jpg" alt="">
	                        </a>
	                        <h5><a href="#0">10 Interesting Facts About Caffeine.</a></h5>
	                        <section class="popular__meta">
	                            <span class="popular__author"><span>By</span> <a href="#0"> John Doe</a></span>
	                            <span class="popular__date"><span>on</span> <time datetime="2017-12-14">Dec 14, 2017</time></span>
	                        </section>
	                    </article>
	                    <article class="col-block popular__post">
	                        <a href="#0" class="popular__thumb">
	                            <img src="images/thumbs/small/salad-150.jpg" alt="">
	                        </a>
	                        <h5><a href="#0">Healthy Mediterranean Salad Recipes</a></h5>
	                        <section class="popular__meta">
	                            <span class="popular__author"><span>By</span> <a href="#0"> John Doe</a></span>
	                            <span class="popular__date"><span>on</span> <time datetime="2017-12-12">Dec 12, 2017</time></span>
	                        </section>
	                    </article>
	                </div> <!-- end popular_posts -->
	            </div> <!-- end popular -->
	            
	            <div class="col-four md-six tab-full about">
	                <h3>About Philosophy</h3>
	
	                <p>
	                	Donec sollicitudin molestie malesuada. Nulla quis lorem ut libero malesuada feugiat. Pellentesque in ipsum id orci porta dapibus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec velit neque, auctor sit amet aliquam vel, ullamcorper sit amet ligula. Quisque velit nisi, pretium ut lacinia in, elementum id enim. Donec sollicitudin molestie malesuada.
	                </p>
	
	                <ul class="about__social">
	                    <li>
	                        <a href="#0"><i class="fa fa-facebook" aria-hidden="true"></i></a>
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
	            </div> <!-- end about -->
	
	        </div> <!-- end row -->
	
	        <div class="row bottom tags-wrap">
	            <div class="col-full tags">
	                <h3>Tags</h3>
	
	                <div class="tagcloud">
	                    <a href="#0">Salad</a>
	                    <a href="#0">Recipe</a>
	                    <a href="#0">Places</a>
	                    <a href="#0">Tips</a>
	                    <a href="#0">Friends</a>
	                    <a href="#0">Travel</a>
	                    <a href="#0">Exercise</a>
	                    <a href="#0">Reading</a>
	                    <a href="#0">Running</a>
	                    <a href="#0">Self-Help</a>
	                    <a href="#0">Vacation</a>
	                </div> <!-- end tagcloud -->
	            </div> <!-- end tags -->
	        </div> <!-- end tags-wrap -->
	
	    </section> <!-- end s-extra -->
	
	
	    <!-- s-footer
	    ================================================== -->
	  
	
	    <!-- preloader
	    ================================================== -->
	    <div id="preloader">
	        <div id="loader">
	            <div class="line-scale">
	                <div></div>
	                <div></div>
	                <div></div>
	                <div></div>
	                <div></div>
	            </div>
	        </div>
	    </div>
    
    </div>
   
	<div id="footer">
		<jsp:include page="/includee/footer.jsp" />
	</div>
	
    <!-- Java Script
    ================================================== -->
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/plugins.js"></script>
    <script src="${pageContext.request.contextPath}/js/main.js"></script>

</body>

</html>