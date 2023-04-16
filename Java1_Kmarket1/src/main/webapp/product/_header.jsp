<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>케이마켓::대한민국 1등 온라인 쇼핑몰</title>
    <link rel="shortcut icon" type="image/x-icon" href="/Java1_Kmarket1/img/favicon.ico">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script src="https://kit.fontawesome.com/20962f3e4b.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
    <link rel="stylesheet" href="/Java1_Kmarket1/css/common.css">
    <link rel="stylesheet" href="/Java1_Kmarket1/css/product.css">
</head>
<body>
    <div id="wrapper">
        <header>
            <div class="top">
                 <div>
                	<c:choose>
                	<c:when test="${sessUser == null}">
	                    <a href="/Java1_Kmarket1/member/login.do">로그인</a>
	                    <a href="/Java1_Kmarket1/member/join.do">회원가입</a>
                    </c:when>
                    <c:when test="${sessUser.level == '5' || sessUser.level == '7'}">
                    	<a href="/Java1_Kmarket1/admin/index.do">관리자</a>
                    	<a href="/Java1_Kmarket1/member/logout.do">로그아웃</a>
	                    <a href="#">마이페이지</a>
	                    <a href="/Java1_Kmarket1/product/cart.do">
	                        <i class="fa fa-shopping-cart" aria-hidden="true"></i>
	                        장바구니
	                    </a>
                    </c:when>
                    <c:otherwise>
                    	<a href="/Java1_Kmarket1/member/logout.do">로그아웃</a>
	                    <a href="#">마이페이지</a>
	                    <a href="/Java1_Kmarket1/product/cart.do">
	                        <i class="fa fa-shopping-cart" aria-hidden="true"></i>
	                        장바구니
	                    </a>
                    </c:otherwise>
                    </c:choose>
                </div>
            </div>
            <div class="logo">
                <div>
                    <a href="/Java1_Kmarket1/index.do">
                        <img src="/Java1_Kmarket1/product/img/header_logo.png" alt="로고">
                    </a>
                    <div class="head-search">
                        <form action="#">
                            <input type="text" name="keyword">
                            <button>
                                <img src="/Java1_Kmarket1/img/image__header-search.png" alt="검색돋보기">
                            </button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="menu">
                <div>
                    <ul>
                        <li><a href="/Java1_Kmarket1/index.do#hit">히트상품</a></li>
                        <li><a href="/Java1_Kmarket1/index.do#recommend">추천상품</a></li>
                        <li><a href="/Java1_Kmarket1/index.do#new">최신상품</a></li>
                        <li><a href="/Java1_Kmarket1/index.do#hit">인기상품</a></li>
                        <li><a href="/Java1_Kmarket1/index.do#discount">할인상품</a></li>
                    </ul>
                    <ul>
                        <li><a href="/Java1_Kmarket1/cs/notice/list.do">공지사항</a></li>
                        <li><a href="/Java1_Kmarket1/cs/faq/list.do">자주묻는질문</a></li>
                        <li><a href="/Java1_Kmarket1/cs/qna/list.do">문의하기</a></li>
                        <li><a href="/Java1_Kmarket1/cs/index.do">고객센터</a></li>
                    </ul>
                </div>
            </div>
        </header>
        <main id="product">
            <aside>
                <ul class="category">
                    <li><i class="fa fa-bars" aria-hidden="true"></i>카테고리</li>
                    <c:forEach var="ca1" items="${cate1s}">
                    <li>
                    	
                        <a href="#">
                        	<c:choose>
                        	<c:when test="${ca1.cate1 == 10 }">
                        	<i class="fas fa-tag" aria-hidden="true"></i>${ca1.c1Name}<i class="fas fa-angle-right" aria-hidden="true"></i>
                        	</c:when>
                        	<c:when test="${ca1.cate1 == 11 }">
                        	<i class="fas fa-tshirt" aria-hidden="true"></i>${ca1.c1Name}<i class="fas fa-angle-right" aria-hidden="true"></i>
                        	</c:when>
                        	<c:when test="${ca1.cate1 == 12 }">
                        	<i class="fas fa-baby" aria-hidden="true"></i>${ca1.c1Name}<i class="fas fa-angle-right" aria-hidden="true"></i>
                        	</c:when>
                        	<c:when test="${ca1.cate1 == 13 }">
                        	<i class="fas fa-utensils" aria-hidden="true"></i>${ca1.c1Name}<i class="fas fa-angle-right" aria-hidden="true"></i>
                        	</c:when>
                        	<c:when test="${ca1.cate1 == 14 }">
                        	<i class="fas fa-home" aria-hidden="true"></i>${ca1.c1Name}<i class="fas fa-angle-right" aria-hidden="true"></i>
                        	</c:when>
                        	<c:when test="${ca1.cate1 == 15 }">
                        	<i class="fas fa-laptop" aria-hidden="true"></i>${ca1.c1Name}<i class="fas fa-angle-right" aria-hidden="true"></i>
                        	</c:when>
                        	<c:when test="${ca1.cate1 == 16 }">
                        	<i class="fas fa-heart" aria-hidden="true"></i>${ca1.c1Name}<i class="fas fa-angle-right" aria-hidden="true"></i>
                        	</c:when>
                        	<c:when test="${ca1.cate1 == 17 }">
                        	<i class="fas fa-car" aria-hidden="true"></i>${ca1.c1Name}<i class="fas fa-angle-right" aria-hidden="true"></i>
                        	</c:when>
                        	<c:when test="${ca1.cate1 == 18 }">
                        	<i class="fas fa-book" aria-hidden="true"></i>${ca1.c1Name}<i class="fas fa-angle-right" aria-hidden="true"></i>
                        	</c:when>
                        	</c:choose>
                        </a>
                        <ol>
                        	<c:forEach var="ca2" items="${cate2s}">
                        		<c:if test="${ca1.cate1==ca2.cate1}">
		                            <li><a href="/Java1_Kmarket1/product/list.do?prodCate1=${ca1.cate1}&prodCate2=${ca2.cate2}">${ca2.c2Name}</a></li>
	                            </c:if>
                            </c:forEach>
                        </ol>
                    </li>
                    </c:forEach>
                </ul>
            </aside>