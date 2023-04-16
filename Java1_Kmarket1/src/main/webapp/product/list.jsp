<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="./_header.jsp" />
   <section class="list">
       <!-- 제목, 페이지 네비게이션 -->
       <nav>
           <h1>상품목록</h1>
           <p>
               HOME >
               <c:forEach var="ca1" items="${cate1s}">
               		<c:if test="${prodCate1 eq ca1.cate1}"><span>${ca1.c1Name}</span></c:if>
               </c:forEach>
                > 
                <c:forEach var="ca2" items="${cate2s}">
                	<c:if test="${prodCate1 == ca2.cate1 && prodCate2 == ca2.cate2}"><strong>${ca2.c2Name}</strong></c:if>
                </c:forEach>
           </p>
       </nav>
       <!-- 정렬 메뉴 -->
       <ul class="sort">
           <li class="${type eq 'sold'?'on':'off'}"><a href="/Java1_Kmarket1/product/list.do?prodCate1=${prodCate1}&prodCate2=${prodCate2}&pg=${currentPage}&type=sold">판매많은순</a></li>
           <li class="${type eq 'lowPrice'?'on':'off'}"><a href="/Java1_Kmarket1/product/list.do?prodCate1=${prodCate1}&prodCate2=${prodCate2}&pg=${currentPage}&type=lowPrice">낮은가격순</a></li>
           <li class="${type eq 'highPrice'?'on':'off'}"><a href="/Java1_Kmarket1/product/list.do?prodCate1=${prodCate1}&prodCate2=${prodCate2}&pg=${currentPage}&type=highPrice">높은가격순</a></li>
           <li class="${type eq 'score'?'on':'off'}"><a href="/Java1_Kmarket1/product/list.do?prodCate1=${prodCate1}&prodCate2=${prodCate2}&pg=${currentPage}&type=score">평점높은순</a></li>
           <li class="${type eq 'review'?'on':'off'}"><a href="/Java1_Kmarket1/product/list.do?prodCate1=${prodCate1}&prodCate2=${prodCate2}&pg=${currentPage}&type=review">후기많은순</a></li>
           <li class="${type eq 'new'?'on':'off'}"><a href="/Java1_Kmarket1/product/list.do?prodCate1=${prodCate1}&prodCate2=${prodCate2}&pg=${currentPage}&type=new">최근등록순</a></li>
       </ul>

       <!-- 상품목록 -->
       <table border="0">
       <c:forEach var="product" items="${products}">
           <tr>
               <td>
                   <a href="/Java1_Kmarket1/product/view.do?prodCate1=${prodCate1}&prodCate2=${prodCate2}&prodNo=${product.prodNo}" class="thumb">
                       <img src="${product.thumb1}" alt="상품이미지">
                   </a>
               </td>
               <td>
	          		<a href="/Java1_Kmarket1/product/view.do?prodCate1=${prodCate1}&prodCate2=${prodCate2}&prodNo=${product.prodNo}">
	          			<h3 class="name">${product.prodName}</h3>
	          		</a>
                    <a href="/Java1_Kmarket1/product/view.do?prodCate1=${prodCate1}&prodCate2=${prodCate2}&prodNo=${product.prodNo}" class="desc">${product.descript}</a>
               </td>
              
               <td>
                   <ul>
                       <li>
                       <c:choose>
                       	<c:when test="${product.discount == '0'}">
                           <ins class="dis-price"><fmt:formatNumber value="${product.price}" pattern="#,###"/></ins>
                        </c:when>
                       	<c:when test="${product.discount != '0'}">
                           <ins class="dis-price"><fmt:formatNumber value="${Math.round(product.price*(100-product.discount)/100)}" pattern="#,###"/></ins>
                        </c:when>
                       </c:choose>
                       </li>
                       <li>
                       <c:if test="${product.discount != '0'}">
                           <del class="org-price"><fmt:formatNumber value="${product.price}" pattern="#,###"/></del>
                           <span class="discount">${product.discount}%</span>
                       </li>
                       </c:if>
                       <li>
	                       <c:choose>
	                       	<c:when test="${product.delivery == '0' }">
	                       		<span class="free-delivery">무료배송</span>
	                       	</c:when>
	                       	<c:when test="${product.delivery != '0' }">
	                       		<span class="delivery">배송비 : <fmt:formatNumber value="${product.delivery}" pattern="#,###"/>원</span>
	                       	</c:when>
	                       </c:choose>
                       </li>
                   </ul>
               </td>
               <td>
                   <h4 class="seller"><i class="fas fa-home" aria-hidden="true"></i>&nbsp;${product.seller}</h4>
                   <h5 class="badge power">판매자등급</h5>
                   <h6 class="rating star${product.score}">상품평 </h6>
               </td>
           </tr>
           </c:forEach>
       </table>
       <!-- 상품목록 페이지 번호 -->
        <div class="paging">
            <span class="prev">
            <c:if test="${pageGroupStart > 1}">
                <a href="/Java1_Kmarket1/product/list.do?prodCate1=${prodCate1}&prodCate2=${prodCate2}&pg=${pageGroupStart - 1}"><&nbsp;이전</a>
            </c:if>
            </span>
            <span class="num">
            <c:forEach var="num" begin="${pageGroupStart}" end="${pageGroupEnd}">
                <a href="/Java1_Kmarket1/product/list.do?prodCate1=${prodCate1}&prodCate2=${prodCate2}&pg=${num}" class="num ${num == currentPage ? 'current':'off'}">${num}</a>
            </c:forEach>
            </span>
            <span class="next">
            <c:if test="${pageGroupEnd < lastPageNum}">
                <a href="/Java1_Kmarket1/product/list.do?prodCate1=${prodCate1}&prodCate2=${prodCate2}&pg=${pageGroupEnd + 1}">다음&nbsp;></a>
            </c:if>
            </span>
        </div>
    </section>
</main>
<jsp:include page="./_footer.jsp" />