<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../_header.jsp"/>
<script type="text/javascript">
$(function() {
	// 더보기 클릭 시 더보거나 닫기
	$('.more').click(function(e) {
		e.preventDefault();
		let isblock = $(this).prev().is(':visible');
		if(isblock){
			// 더보기 닫기
			$(this).parent().children('li:nth-child(n+4)').css("display","none");
			$('.more > a').text("더보기");
		}else{
			// 더보기 열기
			$(this).parent().children().css("display","block");
			$(this).children().text("간단히 보기");
		}
	});
});
</script>
    <section id="cs">
        <div class="faq">
            <nav>
                <div>
                    <p>
                        홈<span>></span>자주묻는 질문
                    </p>
                </div>
            </nav>
            <section class="list">
                <aside>
                    <h2>자주묻는 질문</h2>
                    <ul>
                        <li class="${cate==null || cate.equals('member') ?'on':'off'}"><a href="/Java1_Kmarket1/cs/faq/list.do?cate=member">회원</a></li>
                        <li class="${cate.equals('event') ?'on':'off'}"><a href="/Java1_Kmarket1/cs/faq/list.do?cate=event">쿠폰/이벤트</a></li>
                        <li class="${cate.equals('order') ?'on':'off'}"><a href="/Java1_Kmarket1/cs/faq/list.do?cate=order">주문/결제</a></li>
                        <li class="${cate.equals('deli') ?'on':'off'}"><a href="/Java1_Kmarket1/cs/faq/list.do?cate=deli">배송</a></li>
                        <li class="${cate.equals('cancle') ?'on':'off'}"><a href="/Java1_Kmarket1/cs/faq/list.do?cate=cancle">취소/반품/교환</a></li>
                        <li class="${cate.equals('trip') ?'on':'off'}"><a href="/Java1_Kmarket1/cs/faq/list.do?cate=trip">여행/숙박/항공</a></li>
                        <li class="${cate.equals('safe') ?'on':'off'}"><a href="/Java1_Kmarket1/cs/faq/list.do?cate=safe">안전거래</a></li>
                    </ul>
                </aside>
                <article>
                    <nav>
                        <c:choose>
                    	<c:when test="${cate==null || cate.equals('member')}">
                        <h1>회원</h1>
                        <h2>회원 내용입니다.</h2>
                        </c:when>
                    	<c:when test="${cate.equals('event')}">
                        <h1>쿠폰/이벤트</h1>
                        <h2>쿠폰/이벤트 내용입니다.</h2>
                        </c:when>
                    	<c:when test="${cate.equals('order')}">
                        <h1>주문/결제</h1>
                        <h2>주문/결제 내용입니다.</h2>
                        </c:when>
                    	<c:when test="${cate.equals('deli')}">
                        <h1>배송</h1>
                        <h2>배송 내용입니다.</h2>
                        </c:when>
                    	<c:when test="${cate.equals('cancle')}">
                        <h1>취소/반품/교환</h1>
                        <h2>취소/반품/교환 내용입니다.</h2>
                        </c:when>
                    	<c:when test="${cate.equals('trip')}">
                        <h1>여행/항공/숙박</h1>
                        <h2>여행/항공/숙박 내용입니다.</h2>
                        </c:when>
                    	<c:when test="${cate.equals('safe')}">
                        <h1>안전거래</h1>
                        <h2>안전거래 내용입니다.</h2>
                        </c:when>
                        </c:choose>
                    </nav>
                    <c:forEach var="articles" items="${articlesList}" varStatus="i">
                    <div>
                        <h3>${artiCate2s.get(i.index).c2Name}</h3>
                        <ul class="articles">
                        	<c:forEach var="arti" items="${articles}">
                            <li>
                                <a href="/Java1_Kmarket1/cs/faq/view.do?no=${arti.no}&cate=${arti.cate}">
                                    <span>Q.</span>${arti.title}
                                </a>
                            </li>
                            </c:forEach>
                            <li class="more">
                                <a href="#">더보기</a>
                            </li>
                        </ul>
                    </div>
                    </c:forEach>
                </article>
            </section>
        </div>
    </section>
<jsp:include page="../_footer.jsp"/>