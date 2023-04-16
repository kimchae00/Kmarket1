<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>케이마켓::대한민국 1등 온라인 쇼핑</title>
    <link rel="shortcut icon" type="image/x-icon" href="/Java1_Kmarket1/img/favicon.ico">
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
    <link rel="stylesheet" href="/Java1_Kmarket1/css/main.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script src="https://kit.fontawesome.com/20962f3e4b.js" crossorigin="anonymous"></script>
    <script>
        $(document).ready(function(){
          $('.slider').bxSlider({
            easing:'linear'
          });
        
          // 스크롤 시 사이드 따라오기
          var best = $("aside > .best");

          $(window).scroll(function(){
            var t = $(this).scrollTop();

            if(t > 620){
                best.css({
                    position:"fixed",
                    top:"0",
                });
            }else{
                best.css({
                    position:"static",
                });
            }
          });
        });
    </script>
</head>
<script>
	$(function () {
		$('a[href^="#"]').on('click', function() {  
		    $('html, body').animate({scrollTop: $(this.hash).offset().top - 50}, 1000);
		    return false;
		});
	});
</script>
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
                        <img src="/Java1_Kmarket1/img/header_logo.png" alt="로고">
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
                        <li><a href="#hit">히트상품</a></li>
                        <li><a href="#recommend">추천상품</a></li>
                        <li><a href="#new">최신상품</a></li>
                        <li><a href="#hit">인기상품</a></li>
                        <li><a href="#discount">할인상품</a></li>
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