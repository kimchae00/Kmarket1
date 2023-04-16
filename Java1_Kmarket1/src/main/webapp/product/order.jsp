<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="./_header.jsp" />
<script>
$(function() {
	let isOnce = 0;
	
	
	$('.btnPoint').click(function() {
		let point = $(this).prev().val();
		let userPoint = ${sessUser.point};
		
		if(point < 5000){
			alert('5,000점 이상부터 사용 가능합니다.');
			return false;
		}else if(point >= 5000){
			if(point > userPoint){
				alert('현재 포인트보다 많이 사용할 수 없습니다.');
				return false;
			}
			
			if(isOnce == 0){
				$('.pointDC').text(Number(point).toLocaleString());
				const finTot = parseInt($('.finTot').text().replaceAll(',',''));
				let result = finTot-point;
				$('.pointDC').removeAttr("style");
				$('.finTot').text(result.toLocaleString());
				isOnce = 1;
			}else{
				alert('한 번 적용이 가능합니다.');
				return false;
			}
		}
	});
	$('.btOrd').click(function() {
		
		// 장바구니 번호 들고오기
		let cartNo_arr = [];
		$('input[name=CartNo]').each(function () {
			let cart = $(this).val();
			cartNo_arr.push(cart);
		});
		let cartNo = cartNo_arr.toString();
		console.log(cartNo);
		
		// 상품번호 들고오기
		let prodNo_arr = []; 
		$('input[name=prodNo]').each(function() {
			let prodNo = $(this).val();
			prodNo_arr.push(prodNo);
		});
		// 데이터 들고오기
		let ordNo = $('input[name=ordNo]').val();
		let recipName = $('input[name=orderer]').val();
		let recipHp = $('input[name=hp]').val();
		let recipZip = $('input[name=zip]').val();
		let recipAddr1 = $('input[name=addr1]').val();
		let recipAddr2 = $('input[name=addr2]').val();
		let ordUid = $('input[name=uid]').val();
		let ordCount = parseInt($('.ordCount').text());
		let ordPrice = parseInt($('.ordPrice').text().replaceAll(',',''));
		let ordDiscount = parseInt($('.ordDiscount').text().replaceAll(',',''));
		let ordDelivery = parseInt($('.ordDelivery').text().replaceAll(',',''));
		let savePoint = parseInt($('.savePoint').text().replaceAll(',',''));
		let usedPoint = parseInt($('.pointDC').text().replaceAll(',',''));
		let ordTotPrice = parseInt($('.finTot').text().replaceAll(',',''));
		let ordPayment = $('input[name=payment]:checked').val();
		
		// complete에 보낼 정보를 리스트에 넣기
		let thm_arr = [];
		let prdN_arr = [];
		let dsc_arr = [];
		let cnt_arr = [];
		let prc_arr = [];
		let dc_arr = [];
		let pt_arr = [];
		let deli_arr = [];
		let tot_arr = [];
		let cate1_arr = [];
		let cate2_arr = [];
		$('.thm').each(function(){
			let thm = $(this).attr("src");
			thm_arr.push(thm);
		});
		$('.prdN').each(function(){
			let prdN = $(this).text();
			prdN_arr.push(prdN);
		});
		$('.dsc').each(function(){
			let dsc = $(this).text();
			dsc_arr.push(dsc);
		});
		$('.cnt').each(function(){
			let cnt = $(this).text();
			cnt_arr.push(cnt);
		});
		$('.prc').each(function(){
			let prc = $(this).text().replaceAll(',','');
			prc_arr.push(prc);
		});
		$('.dc').each(function(){
			let dc = $(this).text();
			dc_arr.push(dc);
		});
		$('.pt').each(function(){
			let pt = $(this).text().replaceAll(',','');
			pt_arr.push(pt);
		});
		$('.deli').each(function(){
			let deli = $(this).text().replaceAll(',','');
			deli_arr.push(deli);
		});
		$('.tot').each(function(){
			let tot = $(this).text().replaceAll(',','');
			tot_arr.push(tot);
		});
		$('input[name=ca1]').each(function(){
			let ca1 = $(this).val();
			cate1_arr.push(ca1);
		});
		$('input[name=ca2]').each(function(){
			let ca2 = $(this).val();
			cate2_arr.push(ca2);
		});
		
		
		// 세션 스토리지에 저장
		myStorage = window.sessionStorage;
		myStorage.setItem("thm_arr",thm_arr);
		myStorage.setItem("prdN_arr",prdN_arr);
		myStorage.setItem("dsc_arr",dsc_arr);
		myStorage.setItem("cnt_arr",cnt_arr);
		myStorage.setItem("prc_arr",prc_arr);
		myStorage.setItem("dc_arr",dc_arr);
		myStorage.setItem("pt_arr",pt_arr);
		myStorage.setItem("deli_arr",deli_arr);
		myStorage.setItem("tot_arr",tot_arr);
		myStorage.setItem("prodNo_arr",prodNo_arr);
		myStorage.setItem("cate1_arr",cate1_arr);
		myStorage.setItem("cate2_arr",cate2_arr);
		
		if(ordPayment == null){
			alert('결제수단을 선택해주세요.');
			return false;
		}
		
		let jsonData ={
			"prodNo_arr":prodNo_arr,	
			"cartNo":cartNo,	
			"recipName":recipName,	
			"recipHp":recipHp,	
			"recipZip":recipZip,	
			"recipAddr1":recipAddr1,	
			"recipAddr2":recipAddr2,	
			"ordUid":ordUid,	
			"ordCount":ordCount,	
			"ordPrice":ordPrice,	
			"ordDiscount":ordDiscount,	
			"ordDelivery":ordDelivery,	
			"savePoint":savePoint,	
			"usedPoint":usedPoint,	
			"ordTotPrice":ordTotPrice,	
			"ordPayment":ordPayment,	
		};
		//console.log(jsonData);
		//console.log(ordDelivery);
		
		let isCheck = confirm('해당 상품을 주문하시겠습니까?');
		if(isCheck){
			$.ajax({
				url:"/Java1_Kmarket1/product/order.do",
				method:"post",
				async: false,
				data:jsonData,
				dataType:"json",
				success:function(data){
					if(data.result > 0){
								location.href = "/Java1_Kmarket1/product/complete.do?ordNo="+data.result;
					}else{
						alert('나중에 다시 시도해주세요.');
					}
				}	
			});
		}else{
			return;
		}
	});
});
</script>
    <section class="order">
        <!-- 제목, 페이지 네비게이션 -->
        <nav>
            <h1>주문하기</h1>
            <p>
                HOME >
                <span>장바구니</span>
                 > 
                 <strong>주문하기</strong>
            </p>
        </nav>
        <form action="#">
        <input type="hidden" name="uid" value="${sessUser.uid}">
            <table>
                <tr>
                    <th style="width: 70%">상품명</th>
                    <th>총수량</th>
                    <th>판매가</th>
                    <th>할인</th>
                    <th>포인트</th>
                    <th>배송비</th>
                    <th>총합</th>
                </tr>
                <c:choose>
                	<c:when test="${product == null && cartList == null}">
                		<tr class="empty"><td colspan="7">장바구니에 상품이 없습니다.</td></tr>
                	</c:when>
                	<c:when test="${cartList == null}">
                		<tr>
		                    <td>
		                        <article>
		                            <a href="/Java1_Kmarket1/product/view.do?prodCate1=${product.prodCate1}&prodCate2=${product.prodCate2}&prodNo=${product.prodNo}"><img class="thm" src="${product.thumb1}"></a>
		                            <div>

		                                <h2><a class="prdN" href="/Java1_Kmarket1/product/view.do?prodCate1=${product.prodCate1}&prodCate2=${product.prodCate2}&prodNo=${product.prodNo}">${product.prodName}</a></h2>
		                                <p class="dsc">${product.descript}</p>
		                            </div>
		                        </article>
		                    </td>
		                    <td class="cnt">${count}</td>
		                    <td class="prc"><fmt:formatNumber value="${product.price}" pattern="#,###"/></td>
		                    <td class="dc">${product.discount}%</td>
		                    <td class="pt"><fmt:formatNumber value="${product.point}" pattern="#,###"/></td>
		                    <c:choose>
		                    	<c:when test="${product.delivery==0}">
		                    		<td class="deli">무료배송</td>
		                    	</c:when>
		                    	<c:otherwise>
		                    		<td class="deli"><fmt:formatNumber value="${product.delivery}" pattern="#,###"/></td>
		                    	</c:otherwise>
		                    </c:choose>
		                    <td class="tot"><fmt:formatNumber value="${Math.round(product.price*(100-product.discount)/100)*count+product.delivery}" pattern="#,###"/></td>
		                </tr>
                	</c:when>
                	<c:when test="${product == null}">
                		<c:forEach var="cart" items="${cartList}">
                		<tr>
		                    <td>
		                        <article>
		                        	<input type="hidden" name="CartNo" value="${cart.cartNo}">
		                        	<input type="hidden" name="prodNo" value="${cart.prodNo}">
		                        	<input type="hidden" name="ca1" value="${cart.prodCate1}">
		                        	<input type="hidden" name="ca2" value="${cart.prodCate2}">
		                            <a href="/Java1_Kmarket1/product/view.do?prodCate1=${cart.prodCate1}&prodCate2=${cart.prodCate2}&prodNo=${cart.prodNo}"><img class="thm" src="${cart.thumb1}"></a>
		                            <div>
		                                <h2><a class="prdN" href="/Java1_Kmarket1/product/view.do?prodCate1=${cart.prodCate1}&prodCate2=${cart.prodCate2}&prodNo=${cart.prodNo}">${cart.prodName}</a></h2>
		                                <p class="dsc">${cart.descript}</p>
		                            </div>
		                        </article>
		                    </td>
		                    <td class="cnt">${cart.count}</td>
		                    <td class="prc"><fmt:formatNumber value="${cart.price}" pattern="#,###"/></td>
		                    <td class="dc">${cart.discount}%</td>
		                    <td class="pt"><fmt:formatNumber value="${cart.point}" pattern="#,###"/></td>
             		        <c:choose>
		                    	<c:when test="${cart.delivery==0}">
		                    		<td class="deli">무료배송</td>
		                    	</c:when>
		                    	<c:otherwise>
		                    		<td class="deli"><fmt:formatNumber value="${cart.delivery}" pattern="#,###"/></td>
		                    	</c:otherwise>
		                    </c:choose>
		                    <td class="tot"><fmt:formatNumber value="${cart.total}" pattern="#,###"/></td>
		                </tr>
		                </c:forEach>
                	</c:when>
                </c:choose>

            </table>
            <div class="final">
                <h2>최종결제 정보</h2>
                <table border="0">
                    <tr>
                        <td>총</td>
                        <td class="ordCount">${product==null?cartList.size():'1'}</td>
                    </tr>
                    <tr>
                        <td>상품금액</td>
                        <c:choose>
                        <c:when test="${product==null}">
                        <td class="ordPrice">
                        	<c:set var="sum" value="0"/>
                        	<c:forEach var="cart" items="${cartList}">
                        	<c:set var="sum" value="${sum+cart.price}"/>
                        	</c:forEach>
                        	<fmt:formatNumber value="${sum}" pattern="#,###"/>
                        </td>
                        </c:when>
                        <c:otherwise>
                        <td class="ordPrice">
                        	<fmt:formatNumber value="${product.price * count}" pattern="#,###"/>
                        </td>
                        </c:otherwise>
                        </c:choose>
                    </tr>
                    <tr>
                        <td>할인금액</td>
                        <c:choose>
                        <c:when test="${product==null}">
                       	<c:set var="sum" value="0"/>
                       	<c:forEach var="cart" items="${cartList}">
                       	<c:set var="sum" value="${sum+Math.round(cart.price*(cart.discount/100))}"/>
                       	</c:forEach>
                        <td class="ordDiscount">
                        	<fmt:formatNumber value="${sum}" pattern="#,###"/>
                        </td>
                        </c:when>
                        <c:otherwise>
                        <td class="ordDiscount">
                        	<fmt:formatNumber value="${Math.round(product.price*(product.discount/100)) * count}" pattern="#,###"/>
                        </td>
                        </c:otherwise>
                        </c:choose>
                    </tr>
                    <tr>
                        <td>배송비</td>
                        <c:choose>
                        <c:when test="${product==null}">
                        <td class="ordDelivery">
                        	<c:set var="sum" value="0"/>
                        	<c:forEach var="cart" items="${cartList}">
                        	<c:set var="sum" value="${sum+cart.delivery}"/>
                        	</c:forEach>
                        	<fmt:formatNumber value="${sum}" pattern="#,###"/>
                        </td>
                        </c:when>
                        <c:otherwise>
                        <td class="ordDelivery">
                        	<fmt:formatNumber value="${product.delivery}" pattern="#,###"/>
                        </td>
                        </c:otherwise>
                        </c:choose>
                    </tr>
                    <tr>
                        <td>포인트 할인</td>
                        <td class="pointDC" style="font-size: 0;">0</td>
                    </tr>
                    <tr>
                        <td>전체주문금액</td>
                        <c:choose>
                        <c:when test="${product==null}">
                        <td class="finTot">
                        	<c:set var="sum" value="0"/>
                        	<c:forEach var="cart" items="${cartList}">
                        	<c:set var="sum" value="${sum+cart.total}"/>
                        	</c:forEach>
                        	<fmt:formatNumber value="${sum}" pattern="#,###"/>
                        </td>
                        </c:when>
                        <c:otherwise>
                        <td class="finTot">
                        	<fmt:formatNumber value="${Math.round(product.price*(100-product.discount)/100)*count+product.delivery}" pattern="#,###"/>
                        </td>
                        </c:otherwise>
                        </c:choose>
                    </tr>
                    <tr>
                        <td>적립 포인트</td>
                        <c:choose>
                        <c:when test="${product==null}">
                        <td class="savePoint">
                        	<c:set var="sum" value="0"/>
                        	<c:forEach var="cart" items="${cartList}">
                        	<c:set var="sum" value="${sum+(cart.point*cart.count)}"/>
                        	</c:forEach>
                        	<fmt:formatNumber value="${sum}" pattern="#,###"/>
                        </td>
                        </c:when>
                        <c:otherwise>
                        <td class="savePoint">
                        	<fmt:formatNumber value="${product.point * count}" pattern="#,###"/>
                        </td>
                        </c:otherwise>
                        </c:choose>
                    </tr>
                </table>
                <input type="button" class="btOrd" value="결제하기">
            </div>
             <!-- 배송정보 -->
            <article class="delivery">
                <h1>배송정보</h1>                          
                <table>
                    <tr>
                        <td>주문자</td>
                        <td><input type="text" name="orderer" value="${sessUser.name}"/></td>
                    </tr>
                    <tr>
                        <td>휴대폰</td>
                        <td>
                            <input type="text" name="hp" value="${sessUser.hp}" />
                            <span>- 포함 입력</span>
                        </td>
                    </tr>
                    <tr>
                        <td>우편번호</td>
                        <td>
                            <input type="text" name="zip" value="${sessUser.zip}"/>
                            <input type="button" value="검색"/>
                        </td>
                    </tr>
                    <tr>
                        <td>기본주소</td>
                        <td><input type="text" name="addr1" value="${sessUser.addr1}"/></td>
                    </tr>
                    <tr>
                        <td>상세주소</td>
                        <td><input type="text" name="addr2" value="${sessUser.addr2}"/></td>
                    </tr>
                </table>
            </article>

            <!-- 할인정보 -->
            <article class="discount">
                <h1>할인정보</h1>
                <div>
                    <p>현재 포인트 : <span class="userPoint"><fmt:formatNumber value="${sessUser.point}" pattern="#,###"/></span>점</p>
                    <label>
                        <input type="number" name="point" />점
                        <input type="button" class="btnPoint" value="적용"/>
                    </label>
                    <span>포인트 5,000점 이상이면 현금처럼 사용 가능합니다.</span>
                </div>
            </article>

            <!-- 결제방법 -->
            <article class="payment">
                <h1>결제방법</h1>
                <div>
                    <span>신용카드</span>
                    <p>
                        <label><input type="radio" name="payment" value="1"/>신용카드 결제</label>
                        <label><input type="radio" name="payment" value="2"/>체크카드 결제</label>                                
                    </p>
                </div>
                <div>
                    <span>계좌이체</span>
                    <p>
                        <label><input type="radio" name="payment" value="3"/>실시간 계좌이체</label>
                        <label><input type="radio" name="payment" value="4"/>무통장 입금</label>                                
                    </p>
                </div>
                <div>
                    <span>기타</span>
                    <p>
                        <label><input type="radio" name="payment" value="5"/>휴대폰결제</label>
                        <label>
                            <input type="radio" name="payment" value="6"/>카카오페이
                            <img src="/Java1_Kmarket1/product/img/ico_kakaopay.gif" alt="카카오페이"/>
                        </label>                                
                    </p>
                </div>
            </article>

            <!-- 경고 -->
            <article class="alert">
                <ul>
                    <li><span>케이마켓의 모든 판매자는 안전거래를 위해 구매금액, 결제수단에 상관없이 모든거래에 대하여 케이마켓 유한책임회사의 구매안전서비스(에스크로)를 제공하고 있습니다.</span></li>
                    <li><span>케이마켓 유한책임회사의 전자금융거래법에 의해 결제대금예치업 등록번호는 02-006-00008 입니다.</span></li>
                    <li><span>등록여부는 금융감독원 홈페이지(www.fss.or.kr)의 업무자료>인허가업무안내>전자금융업등록현황에서 확인하실수 있습니다.</span></li>
                </ul>
            </article>
        </form>
    </section>
</main>
<jsp:include page="./_footer.jsp" />