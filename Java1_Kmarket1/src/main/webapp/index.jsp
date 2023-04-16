<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="./_header.jsp"/>
<script type="text/javascript">
	$(function(){
		// ori price 숫자 , 붙이기
		for(let i=1;i<6;i++){		
			let cls = ".best"+i.toString()+"Ori";
			let price = $(cls).text();
			$(cls).text(Number(price).toLocaleString());
		}
		for(let i=1;i<9;i++){		
			let cls = ".hit"+i.toString()+"Ori";
			let price = $(cls).text();
			$(cls).text(Number(price).toLocaleString());
		}
		for(let i=1;i<9;i++){		
			let cls = ".score"+i.toString()+"Ori";
			let price = $(cls).text();
			$(cls).text(Number(price).toLocaleString());
		}
		for(let i=1;i<9;i++){		
			let cls = ".late"+i.toString()+"Ori";
			let price = $(cls).text();
			$(cls).text(Number(price).toLocaleString());
		}
		for(let i=1;i<9;i++){		
			let cls = ".discount"+i.toString()+"Ori";
			let price = $(cls).text();
			$(cls).text(Number(price).toLocaleString());
		}
		// 최종 price 숫자 , 붙이기
		for(let i=1;i<6;i++){		
			let cls = ".best"+i.toString();
			let price = $(cls).text();
			$(cls).text(Number(price).toLocaleString());
		}
		for(let i=1;i<9;i++){		
			let cls = ".hit"+i.toString();
			let price = $(cls).text();
			$(cls).text(Number(price).toLocaleString());
		}
		for(let i=1;i<9;i++){		
			let cls = ".score"+i.toString();
			let price = $(cls).text();
			$(cls).text(Number(price).toLocaleString());
		}
		for(let i=1;i<9;i++){		
			let cls = ".late"+i.toString();
			let price = $(cls).text();
			$(cls).text(Number(price).toLocaleString());
		}
		for(let i=1;i<9;i++){		
			let cls = ".discount"+i.toString();
			let price = $(cls).text();
			$(cls).text(Number(price).toLocaleString());
		}
		// 배송비 숫자 , 붙이기
		for(let i=1;i<9;i++){		
			let cls = ".hit"+i.toString()+"d";
			let price = $(cls).text();
			$(cls).text(Number(price).toLocaleString());
		}
		for(let i=1;i<9;i++){		
			let cls = ".score"+i.toString()+"d";
			let price = $(cls).text();
			$(cls).text(Number(price).toLocaleString());
		}
		for(let i=1;i<9;i++){		
			let cls = ".late"+i.toString()+"d";
			let price = $(cls).text();
			$(cls).text(Number(price).toLocaleString());
		}
		for(let i=1;i<9;i++){		
			let cls = ".discount"+i.toString()+"d";
			let price = $(cls).text();
			$(cls).text(Number(price).toLocaleString());
		}
		$('#top').click(function(){
            $(window).scrollTop(0);
        });
	});
</script>
        <main>
            <!--사이드-->
            <aside>
                <!--카테고리-->
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
		                            <li><a href="/Java1_Kmarket1/product/list.do?prodCate1=${ca2.cate1}&prodCate2=${ca2.cate2}">${ca2.c2Name}</a></li>
	                            </c:if>
                            </c:forEach>
                        </ol>
                    </li>
                    </c:forEach>
                </ul>
                <!--베스트상품-->
                <article class="best">
                    <h1>
                        <i class="fas fa-crown" aria-hidden="true"></i>베스트상품
                    </h1>
                    <ol>
                    	<c:forEach var="best" items="${bests}" varStatus="b">
                        <li>
                            <a href="/Java1_Kmarket1/product/view.do?prodNo=${best.prodNo}&prodCate1=${best.prodCate1}&prodCate2=${best.prodCate2}">
                                <div class="thumb">
                                    <i>${b.count}</i>
                                    <img src="${best.thumb1}" alt="BestItem">
                                </div>
                                <h2>${best.prodName}</h2>
                                <c:if test="${best.discount != '0'}">
                                <div class="org_price">
                                    <del class="best${bcount}Ori">${best.price}</del>
                                    <span>${best.discount}%</span>
                                </div>
                                </c:if>
                                <div class="dis_price">
                                	<c:choose>
                                		<c:when test="${best.discount == '0'}">
	                                    	<ins class="best${b.count}">${best.price}</ins>
	                                    </c:when>
                                		<c:when test="${best.discount != '0'}">
	                                    	<ins class="best${b.count}">${Math.round(best.price*(100-best.discount)/100)}</ins>
	                                    </c:when>
                                    </c:choose>
                                </div>
                            </a>
                        </li>
                        </c:forEach>
                    </ol>
                </article>
            </aside>
            <section>
                <!--슬라이더-->
                <section class="Slider">
                    <div class="slider">
                        <div><a href="#"><img src="/Java1_Kmarket1/img/main_banner1.jpg" alt="item1"></a></div>
                        <div><a href="#"><img src="/Java1_Kmarket1/img/main_banner2.jpg" alt="item2"></a></div>
                        <div><a href="#"><img src="/Java1_Kmarket1/img/main_banner3.jpg" alt="item3"></a></div>
                        <div><a href="#"><img src="/Java1_Kmarket1/img/main_banner4.jpg" alt="item4"></a></div>
                        <div><a href="#"><img src="/Java1_Kmarket1/img/main_banner5.jpg" alt="item5"></a></div>
                    </div>
                </section>
                <!--히트상품-->
                <section class="hit" id="hit">
                    <h3>
                        <span>히트상품</span>
                    </h3>
                    <c:forEach var="hit" items="${hits}" varStatus="h">
                    <article>
                        <a href="/Java1_Kmarket1/product/view.do?prodNo=${hit.prodNo}&prodCate1=${hit.prodCate1}&prodCate2=${hit.prodCate2}">
                            <div class="thumb">
                                <img src="${hit.thumb1}" alt="HitItem">
                            </div>
                            <h2>${hit.prodName}</h2>
                            <c:if test="${hit.descript}">
                            <p>${hit.descript}</p>
                            </c:if>
                            <c:if test="${hit.discount != '0'}">
                            <div class="org_price">
                                <del class="hit${h.count}Ori">${hit.price}</del>
                                <span>${hit.discount}%</span>
                            </div>
                            </c:if>
                            <div class="dis_price">
                            	<c:choose>
	                            	<c:when test="${hit.discount == '0'}">
	                                <ins class="hit${h.count}">${hit.price}</ins>
	                                </c:when>
	                             	<c:when test="${hit.discount != '0'}">
	                                <ins class="hit${h.count}">${Math.round(hit.price*(100-hit.discount)/100)}</ins>
	                                </c:when>
                                </c:choose>
                                <c:choose>
                                	<c:when test="${hit.delivery == '0' }">
                                		<span class="free">무료배송</span>
                                	</c:when>
                                	<c:when test="${hit.delivery != '0' }">
                                		<span class="deli hit${h.count}d">${hit.delivery}</span>
                                	</c:when>
                                </c:choose>
                            </div>
                        </a>
                    </article>
                    </c:forEach>
                </section>
                <!--추천상품-->
                <section class="recommend" id="recommend">
                    <h3>
                        <span>추천상품</span>
                    </h3>
                    <c:forEach var="score" items="${scores}" varStatus="s">
                    <article>
                        <a href="/Java1_Kmarket1/product/view.do?prodNo=${score.prodNo}&prodCate1=${score.prodCate1}&prodCate2=${score.prodCate2}">
                            <div class="thumb">
                                <img src="${score.thumb1}" alt="ScoreItem">
                            </div>
                            <h2>${score.prodName}</h2>
                            <c:if test="${score.descript}">
                            <p>${score.descript}</p>
                            </c:if>
                            <c:if test="${score.discount != '0'}">
                            <div class="org_price">
                                <del class="score${s.count}Ori">${score.price}</del>
                                <span>${score.discount}%</span>
                            </div>
                            </c:if>
                            <div class="dis_price">
                            	<c:choose>
	                            	<c:when test="${score.discount == '0'}">
	                                <ins class="score${s.count}">${score.price}</ins>
	                                </c:when>
	                             	<c:when test="${score.discount != '0'}">
	                                <ins class="score${s.count}">${Math.round(score.price*(100-score.discount)/100)}</ins>
	                                </c:when>
                                </c:choose>
                                <c:choose>
                                	<c:when test="${score.delivery == '0' }">
                                		<span class="free">무료배송</span>
                                	</c:when>
                                	<c:when test="${score.delivery != '0' }">
                                		<span class="deli score${s.count}d">${score.delivery}</span>
                                	</c:when>
                                </c:choose>
                            </div>
                        </a>
                    </article>
                    </c:forEach>
                </section>
                <!--최신상품-->
                <section class="new" id="new">
                    <h3>
                        <span>최신상품</span>
                    </h3>
                    <c:forEach var="late" items="${lates}" varStatus="l">
                    <article>
                        <a href="/Java1_Kmarket1/product/view.do?prodNo=${late.prodNo}&prodCate1=${late.prodCate1}&prodCate2=${late.prodCate2}">
                            <div class="thumb">
                                <img src="${late.thumb1}" alt="LateItem">
                            </div>
                            <h2>${late.prodName}</h2>
                            <c:if test="${late.descript}">
                            <p>${late.descript}</p>
                            </c:if>
                            <c:if test="${late.discount != '0'}">
                            <div class="org_price">
                                <del class="late${l.count}Ori">${late.price}</del>
                                <span>${late.discount}%</span>
                            </div>
                            </c:if>
                            <div class="dis_price">
                            	<c:choose>
	                            	<c:when test="${late.discount == '0'}">
	                                <ins class="late${l.count}">${late.price}</ins>
	                                </c:when>
	                             	<c:when test="${late.discount != '0'}">
	                                <ins class="late${l.count}">${Math.round(late.price*(100-late.discount)/100)}</ins>
	                                </c:when>
                                </c:choose>
                                <c:choose>
                                	<c:when test="${late.delivery == '0' }">
                                		<span class="free">무료배송</span>
                                	</c:when>
                                	<c:when test="${late.delivery != '0' }">
                                		<span class="deli late${l.count}d">${late.delivery}</span>
                                	</c:when>
                                </c:choose>
                            </div>
                        </a>
                    </article>
                    </c:forEach>
                </section>
                <!--할인상품-->
                <section class="discount" id="discount">
                    <h3>
                        <span>할인상품</span>
                    </h3>
                    <c:forEach var="discount" items="${discounts}" varStatus="d">
                    <article>
                        <a href="/Java1_Kmarket1/product/view.do?prodNo=${discount.prodNo}&prodCate1=${discount.prodCate1}&prodCate2=${discount.prodCate2}">
                            <div class="thumb">
                                <img src="${discount.thumb1}" alt="DCItem">
                            </div>
                            <h2>${discount.prodName}</h2>
                            <c:if test="${discount.descript}">
                            <p>${discount.descript}</p>
                            </c:if>
                            <c:if test="${discount.discount != '0'}">
                            <div class="org_price">
                                <del class="discount${d.count}Ori">${discount.price}</del>
                                <span>${discount.discount}%</span>
                            </div>
                            </c:if>
                            <div class="dis_price">
                            	<c:choose>
	                            	<c:when test="${discount.discount == '0'}">
	                                <ins class="discount${d.count}">${discount.price}</ins>
	                                </c:when>
	                             	<c:when test="${discount.discount != '0'}">
	                                <ins class="discount${d.count}">${Math.round(discount.price*(100-discount.discount)/100)}</ins>
	                                </c:when>
                                </c:choose>
                                <c:choose>
                                	<c:when test="${discount.delivery == '0' }">
                                		<span class="free">무료배송</span>
                                	</c:when>
                                	<c:when test="${discount.delivery != '0' }">
                                		<span class="deli discount${d.count}d">${discount.delivery}</span>
                                	</c:when>
                                </c:choose>
                            </div>
                        </a>
                    </article>
                    </c:forEach>
                </section>
            </section>
        </main>
<jsp:include page="./_footer.jsp"/>