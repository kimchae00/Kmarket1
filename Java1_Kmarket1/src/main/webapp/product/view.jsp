<%@page import="java.util.Date"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="./_header.jsp" />
<script>

	// 수량 변경 + 자동 총 합계 계산
	$(function(){
		
		let price = parseInt($('input[name=price]').val());
		let discount = parseInt($('input[name=discount]').val());
		let delivery = parseInt($('input[name=delivery]').val());
		let totalPrice = 1 * Math.round(price*(100-discount)/100) + delivery;
		$('.total > span').text(totalPrice.toLocaleString());
		
		$('.increase').on('click', function(){
			let quantity = $(this).parent("div").find("input").val();
			$(this).parent("div").find("input").val(++quantity);
			let count = parseInt($('input[name=num]').val());
			let totalPrice = count * Math.round(price*(100-discount)/100) + delivery;
			$('.total > span').text(totalPrice.toLocaleString());
		});
		
		$(".decrease").on("click", function(){
			let quantity = $(this).parent("div").find("input").val();
			if(quantity > 1){
				$(this).parent("div").find("input").val(--quantity);		
			}
			let count = parseInt($('input[name=num]').val());
			let totalPrice = count * Math.round(price*(100-discount)/100) + delivery;
			$('.total > span').text(totalPrice.toLocaleString());
		});
		
		// 장바구니 클릭
		$('.cart').click(function(){
			
			let uid = $('input[name=uid]').val();
			let prodNo = $('input[name=prodNo]').val();
			let count = $('input[name=num]').val();
			let price = $('input[name=price]').val();
			let discount = $('input[name=discount]').val();
			let point = $('input[name=point]').val();
			let delivery = $('input[name=delivery]').val();
			let thumb1 = $('input[name=thumb1]').val();
			let total = $('.total > span').text().replaceAll(',','');
			
			let jsonData = {
					"uid": uid,
					"prodNo": prodNo,
					"count": count,
					"price": price,
					"discount": discount,
					"point": point,
					"delivery": delivery,
					"total": total,
			};
			
			$.ajax({
				url: '/Java1_Kmarket1/product/view.do',
				type: 'post',
				data: jsonData,
				dataType: 'json',
				success: function(data){
					if(${sessUser != null}){
						if(data.result == 1){
							// 장바구니에 이미 있는 경우
							if(confirm("이미 있는 상품입니다. 장바구니에 추가하시겠습니까?")){
								if(confirm("장바구니로 이동하시겠습니까?")){
									location.href = "/Java1_Kmarket1/product/cart.do";
								}else{
									return;
								}
							}else{
								return;
							}
						}else {
							if(confirm('장바구니에 추가되었습니다.\n장바구니로 이동하시겠습니까?')){
								location.href = "/Java1_Kmarket1/product/cart.do";
							}else{
								return;
							}
						}
					}else{
						alert('로그인 후 이용 가능합니다.');
					}
				}
			});
		});
		
		// 주문하기 클릭
		$('.order').click(function(){
			let count = $('input[name=num]').val();
			if(${sessUser != null}){
				location.href = "/Java1_Kmarket1/product/order.do?prodNo=${prodNo}&count="+count;
			}else{
				alert('로그인 후 이용 가능합니다.');				
				return;
			}
		});
	});
</script>
<script>
	$(function () {
		$('a[href^="#"]').on('click', function() {  
		    $('html, body').animate({scrollTop: $(this.hash).offset().top - 50}, 1000);
		    return false;
		});
	});
</script>
    <section class="view">
    <input type="hidden" name="uid" value="${sessUser.uid}">
    <input type="hidden" name="prodNo" value="${product.prodNo}">
    <input type="hidden" name="price" value="${product.price}">
    <input type="hidden" name="discount" value="${product.discount}">
    <input type="hidden" name="point" value="${product.point}">
    <input type="hidden" name="delivery" value="${product.delivery}">
        <!-- 제목, 페이지 네비게이션 -->
        <nav>
           <h1>상품보기</h1>
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

        <!-- 상품 전체 정보 내용 -->
        
        <article class="info">
            <div class="image">
                <img src="${product.thumb2}" alt="상품이미지"/>
            </div>
            <div class="summary">
                <nav>
                    <h1>${product.seller}</h1>
                    <h2>상품번호&nbsp;:&nbsp;<span>${product.prodNo}</span></h2>
                </nav>                        
                <nav>
                    <h3>${product.prodName}</h3>
                    <p>${product.descript}</p>
                    <h5 class="rating star${product.score}"><a href="#review">상품평보기</a></h5>
                </nav>
                <nav>
                    <div class="org_price">
                    <c:if test="${product.discount != '0'}">
                        <del><fmt:formatNumber value="${product.price}" pattern="#,###"/></del>
                        <span>${product.discount}%</span>
                    </c:if>
                    </div>
                    <div class="dis_price">
                       <c:choose>
                       	<c:when test="${product.discount == '0'}">
                           <ins class="dis-price"><fmt:formatNumber value="${product.price}" pattern="#,###"/></ins>
                        </c:when>
                       	<c:when test="${product.discount != '0'}">
                           <ins class="dis-price"><fmt:formatNumber value="${Math.round(product.price*(100-product.discount)/100)}" pattern="#,###"/></ins>
                        </c:when>
                       </c:choose>
                    </div>
                </nav>
                <nav>
                     <c:choose>
	                       	<c:when test="${product.delivery == '0' }">
	                       		<span class="delivery">무료배송</span>
	                       	</c:when>
	                       	<c:when test="${product.delivery != '0' }">
	                       		<span class="delivery">배송비 : <fmt:formatNumber value="${product.delivery}" pattern="#,###"/>원</span>
	                       	</c:when>
	                       </c:choose>
                    <c:set var="arrival" value="<%=new Date(new Date().getTime() + 60*60*24*1000*3)%>"/>
                    <fmt:formatDate value="${arrival}" pattern="yyyy-MM-dd" var="arrival" />
                    <span class="arrival">${arrival} 도착예정</span>
                    <span class="desc">${product.descript}</span>
                </nav>
                <nav>
                    <span class="card cardfree"><i>아이콘</i>무이자할부</span>&nbsp;&nbsp;
                    <span class="card cardadd"><i>아이콘</i>카드추가혜택</span>
                </nav>
                <nav>
                    <span class="origin">원산지-상세설명 참조</span>
                </nav>
                <img src="/Java1_Kmarket1/img/vip_plcc_banner.png" alt="100원만 결제해도 1만원 적립!" class="banner" />
                
                <div class="count">
                    <button class="decrease">-</button>
                    <input type="text" id="num" name="num" value="1" readonly/>
                    <button class="increase">+</button>
                </div>
                
                <div class="total">
                    <span></span>
                    <em>총 상품금액</em>
                </div>

                <div class="button">
                    <input type="button" class="cart"  value="장바구니" />
                    <input type="button" class="order" value="구매하기" />
                </div>
            </div>
        </article>

        <!-- 상품 정보 내용 -->
        <article class="detail">
            <nav>
                <h1>상품정보</h1>
            </nav>
            <!-- 상품상세페이지 이미지 -->
            <img src="${product.thumb3}" alt="상세페이지1">
            <img src="${product.detail}" alt="상세페이지2">
        </article>

        <!-- 상품 정보 제공 고시 내용 -->
        <article class="notice">
            <nav>
                <h1>상품 정보 제공 고시</h1>
                <p>[전자상거래에 관한 상품정보 제공에 관한 고시] 항목에 의거 등록된 정보입니다.</p>
            </nav>
            <table border="0">
                <tr>
                    <td>상품번호</td>
                    <td>${product.prodNo}</td>
                </tr>
                <tr>
                    <td>상품상태</td>
                    <td>${product.status}</td>
                </tr>
                <tr>
                    <td>부가세 면세여부</td>
                    <td>${product.duty}</td>
                </tr>
                <tr>
                    <td>영수증발행</td>
                    <td>${product.receipt}</td>
                </tr>
                <tr>
                    <td>사업자구분</td>
                    <td>${product.bizType}</td>
                </tr>
                <tr>
                    <td>브랜드</td>
                    <td>${product.company}</td>
                </tr>
                <tr>
                    <td>원산지</td>
                    <td>${product.origin}</td>
                </tr>
            </table>
            <table border="0">
                <tr>
                    <td>제품소재</td>
                    <td>상세정보 직접입력</td>
                </tr>
                <tr>
                    <td>색상</td>
                    <td>상세정보 직접입력</td>
                </tr>
                <tr>
                    <td>치수</td>
                    <td>상세정보 직접입력</td>
                </tr>
                <tr>
                    <td>제조자/수입국</td>
                    <td>상세정보 직접입력</td>
                </tr>
                <tr>
                    <td>제조국</td>
                    <td>상세정보 직접입력</td>
                </tr>
                <tr>
                    <td>취급시 주의사항</td>
                    <td>상세정보 직접입력</td>
                </tr>
                <tr>
                    <td>제조연월</td>
                    <td>상세정보 직접입력</td>
                </tr>
                <tr>
                    <td>품질보증기준</td>
                    <td>상세정보 직접입력</td>
                </tr>
                <tr>
                    <td>A/S 책임자와 전화번호</td>
                    <td>상세정보 직접입력</td>
                </tr>
                <tr>
                    <td>주문후 예상 배송기간</td>
                    <td>상세정보 직접입력</td>
                </tr>
                <tr>
                <td colspan="2">구매, 교환, 반품, 배송, 설치 등과 관련하여 추가비용, 제한조건 등의 특이사항이 있는 경우</td>
                </tr>
            </table>
            <p class="notice">
                소비자가 전자상거래등에서 소비자 보호에 관한 법률 제 17조 제1항 또는 제3항에 따라 청약철회를 하고
                동법 제 18조 제1항 에 따라 청약철회한 물품을 판매자에게 반환하였음에도 불구 하고 결제 대금의
                환급이 3영업일을 넘게 지연된 경우, 소비자 는 전자상거래등에서 소비자보호에 관한 법률 제18조
                제2항 및 동법 시행령 제21조 2에 따라 지연일수에 대하여 전상법 시행령으로 정하는 이율을 곱하여
                산정한 지연이자(“지연배상금”)를 신청할 수 있습니다. 아울러, 교환∙반품∙보증 및 결제대금의
                환급신청은 [나의쇼핑정보]에서 하실 수 있으며, 자세한 문의는 개별 판매자에게 연락하여 주시기 바랍니다.
            </p>
        </article>
        
        <!-- 상품 리뷰 내용 -->

        <article class="review" id="review">
            <nav>
                <h1>상품리뷰</h1>
            </nav>
            <ul>
            <c:forEach var="review" items="${reviews}">
                <li>
                    <div>
                        <h5 class="rating star${review.rating}">상품평</h5>
                        <span>${fn:substring(review.uid,0,3)}<c:forEach begin="4" end="${fn:length(review.uid)}">*</c:forEach>   ${review.rdate}</span>
                    </div>
                    <h3>${review.prodName}</h3>
                    <p>${review.content}</p>
                </li>
            </c:forEach>
            </ul>
            <!-- 리뷰 페이지 번호 -->
            <div class="paging">
	            <span class="prev">
		            <c:if test="${pageGroupStart > 1}">
		                <a href="/Java1_Kmarket1/product/view.do?prodCate1=${prodCate1}&prodCate2=${prodCate2}&prodNo=${prodNo}&pg=${pageGroupStart - 1}#review"><&nbsp;이전</a>
		            </c:if>
		        </span>
		        <span class="num">
		            <c:forEach var="num" begin="${pageGroupStart}" end="${pageGroupEnd}">
		                <a href="/Java1_Kmarket1/product/view.do?prodCate1=${prodCate1}&prodCate2=${prodCate2}&prodNo=${prodNo}&pg=${num}#review" class="num ${num == currentPage ? 'current':'off'}">${num}</a>
		            </c:forEach>
		        </span>
		        <span class="next">
		            <c:if test="${pageGroupEnd < lastPageNum}">
		                <a href="/Java1_Kmarket1/product/view.do?prodCate1=${prodCate1}&prodCate2=${prodCate2}&prodNo=${prodNo}&pg=${pageGroupEnd + 1}#review">다음&nbsp;></a>
		            </c:if>
	            </span>
        </div>
        </article>
    </section>
</main>
<jsp:include page="./_footer.jsp" />