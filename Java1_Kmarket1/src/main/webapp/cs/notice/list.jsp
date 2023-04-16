<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../_header.jsp"/>
    <section id="cs">
        <div class="notice">
            <nav>
                <div>
                    <p>
                        홈<span>></span>공지사항
                    </p>
                </div>
            </nav>
            <section class="list">
                <aside>
                    <h2>공지사항</h2>
                    <ul>
                        <li class="${cate == null ?'on':'off'}"><a href="/Java1_Kmarket1/cs/notice/list.do">전체</a></li>
                        <li class="${cate.equals('service') ?'on':'off'}"><a href="/Java1_Kmarket1/cs/notice/list.do?cate=service">고객서비스</a></li>
                        <li class="${cate.equals('deal') ?'on':'off'}"><a href="/Java1_Kmarket1/cs/notice/list.do?cate=deal">안전거래</a></li>
                        <li class="${cate.equals('danger') ?'on':'off'}"><a href="/Java1_Kmarket1/cs/notice/list.do?cate=danger">위해상품</a></li>
                        <li class="${cate.equals('lucky') ?'on':'off'}"><a href="/Java1_Kmarket1/cs/notice/list.do?cate=lucky">이벤트당첨</a></li>
                    </ul>
                </aside>
                <article>
                    <nav>
                    	<c:choose>
                    	<c:when test="${cate == null}">
                        <h1>전체</h1>
                        <h2>공지사항 전체 내용입니다.</h2>
                        </c:when>
                    	<c:when test="${cate.equals('service')}">
                        <h1>고객서비스</h1>
                        <h2>고객서비스 내용입니다.</h2>
                        </c:when>
                    	<c:when test="${cate.equals('deal')}">
                        <h1>안전거래</h1>
                        <h2>안전거래 내용입니다.</h2>
                        </c:when>
                    	<c:when test="${cate.equals('danger')}">
                        <h1>위해상품</h1>
                        <h2>위해상품 내용입니다.</h2>
                        </c:when>
                    	<c:when test="${cate.equals('lucky')}">
                        <h1>이벤트당첨</h1>
                        <h2>이벤트당첨 내용입니다.</h2>
                        </c:when>
                        </c:choose>
                    </nav>
                    <table>
                    	<c:forEach var="article" items="${articles}">
                        <tr>
                            <td>
                                <a href="/Java1_Kmarket1/cs/notice/view.do?no=${article.no}&cate=${article.cate}">${article.title}</a>
                            </td>
                            <td>${article.rdate}</td>
                        </tr>
                        </c:forEach>
                    </table>
                    <div class="page">
	                    <c:choose>
			            <c:when test="${pageGroupStart gt 1 && cate != null}">
			            <a href="/Java1_Kmarket1/cs/notice/list.do?pg=${pageGroupStart-1}&cate=${cate}" class="prev">이전</a>
			            </c:when>
			            <c:when test="${pageGroupStart gt 1 && cate == null}">
			            <a href="/Java1_Kmarket1/cs/notice/list.do?pg=${pageGroupStart-1}" class="prev">이전</a>
			            </c:when>
			            </c:choose>
			            <c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd }">
			            <c:choose>
			            <c:when test="${cate != null}">
			            <a href="/Java1_Kmarket1/cs/notice/list.do?pg=${i}&cate=${cate}" class="num ${i==currentPage?'current':'off'} ${i==currentPage?'on':'off'}">${i}</a>
			            </c:when>
			            <c:when test="${cate == null}">
			            <a href="/Java1_Kmarket1/cs/notice/list.do?pg=${i}" class="num ${i==currentPage?'current':'off'} ${i==currentPage?'on':'off'}">${i}</a>
			            </c:when>
			            </c:choose>
			            </c:forEach>
			            <c:choose>
			            <c:when test="${pageGroupEnd lt lastPageNum && cate != null}">
			            <a href="/Java1_Kmarket1/cs/notice/list.do?pg=${pageGroupStart+1}&cate=${cate}" class="next">다음</a>
			            </c:when>
			            <c:when test="${pageGroupEnd lt lastPageNum && cate == null}">
			            <a href="/Java1_Kmarket1/cs/notice/list.do?pg=${pageGroupStart+1}" class="next">다음</a>
			            </c:when>
			            </c:choose>
	        		</div>
                </article>
            </section>
        </div>
    </section>
<jsp:include page="../_footer.jsp"/>