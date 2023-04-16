<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"/>
<c:if test="${sessUser == null}">
<script>
$(function() {
	$('.btnWrite').click(function() {
		alert('로그인 하셔야 작성가능 합니다.');
		return false;
	});
});
</script>
</c:if>
    <section id="cs">
        <div class="qna">
            <nav>
                <div>
                    <p>
                        홈<span>></span>문의하기
                    </p>
                </div>
            </nav>
            <section class="list">
                <aside>
                    <h2>문의하기</h2>
                    <ul>
                        <li class="${cate==null || cate.equals('member') ?'on':'off'}"><a href="/Java1_Kmarket1/cs/qna/list.do?cate=member">회원</a></li>
                        <li class="${cate.equals('event') ?'on':'off'}"><a href="/Java1_Kmarket1/cs/qna/list.do?cate=event">쿠폰/이벤트</a></li>
                        <li class="${cate.equals('order') ?'on':'off'}"><a href="/Java1_Kmarket1/cs/qna/list.do?cate=order">주문/결제</a></li>
                        <li class="${cate.equals('deli') ?'on':'off'}"><a href="/Java1_Kmarket1/cs/qna/list.do?cate=deli">배송</a></li>
                        <li class="${cate.equals('cancle') ?'on':'off'}"><a href="/Java1_Kmarket1/cs/qna/list.do?cate=cancle">취소/반품/교환</a></li>
                        <li class="${cate.equals('trip') ?'on':'off'}"><a href="/Java1_Kmarket1/cs/qna/list.do?cate=trip">여행/숙박/항공</a></li>
                        <li class="${cate.equals('safe') ?'on':'off'}"><a href="/Java1_Kmarket1/cs/qna/list.do?cate=safe">안전거래</a></li>
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
                    <table>
                    	<c:forEach var="article" items="${articles}">
                        <tr>
                            <td>
                                <a href="/Java1_Kmarket1/cs/qna/view.do?no=${article.no}&cate=${article.cate}">
                                [${article.c2Name}]
                                ${article.title}
                                </a>
                            </td>
                            <c:choose>
                            	<c:when test="${article.comment == 0}">
                            		<td><span style="color:#777;">검토중</span></td>
                            	</c:when>
                            	<c:when test="${article.comment != 0}">
                            		<td><span style="color:#0078ff;font-weight: bold;">답변완료</span></td>
                            	</c:when>
                            </c:choose>
                            <td>${article.uid}***</td>
                            <td>${article.rdate}</td>
                        </tr>
                        </c:forEach>
                    </table>
                    <div class="page">
			            <c:if test="${pageGroupStart gt 1}">
			            <a href="/Java1_Kmarket1/cs/qna/list.do?pg=${pageGroupStart-1}&cate=${cate}" class="prev">이전</a>
			            </c:if>
			            <c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd }">
			            <a href="/Java1_Kmarket1/cs/qna/list.do?pg=${i}&cate=${cate}" class="num ${i==currentPage?'current':'off'} ${i==currentPage?'on':'off'}">${i}</a>
			            </c:forEach>
			            <c:if test="${pageGroupEnd lt lastPageNum}">
			            <a href="/Java1_Kmarket1/cs/qna/list.do?pg=${pageGroupStart+1}&cate=${cate}" class="next">다음</a>
			            </c:if>
	        		</div>
                    <a href="/Java1_Kmarket1/cs/qna/write.do?cate=${cate}" class="btnWrite">문의하기</a>
                </article>
            </section>
        </div>
    </section>
<jsp:include page="../_footer.jsp"/>