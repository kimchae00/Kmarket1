<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"/>
    <section id="cs">
        <div class="qna">
            <nav>
                <div>
                    <p>
                        홈<span>></span>문의하기
                    </p>
                </div>
            </nav>
            <section class="view">
                <aside>
                    <h2>문의하기</h2>
                    <ul>
                        <li class="${cate.equals('member') ?'on':'off'}"><a href="/Java1_Kmarket1/cs/qna/list.do?cate=member">회원</a></li>
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
                        <h2 class="title">
                            ${article.title }
                        </h2>
                        <p>
                            <span>${article.uid}***</span>
                            <span>${article.rdate}</span>
                        </p>
                    </nav>
                    <div class="content">
                        <p>
                            ${article.content}
                        </p>
                    </div>
                    <c:if test="${article.comment != 0}">
                    <nav style="border-top: 2px solid #e9e9e9">
                        <h2 class="title">
                            ☞[답변]${article.title }
                        </h2>
                    </nav>
                    <div class="content">
                        <p>
                            ${reply.content}
                        </p>
                    </div>
                    </c:if>
                    <a href="/Java1_Kmarket1/cs/qna/list.do?cate=${article.cate}" class="btnList">목록보기</a>
                </article>
            </section>
        </div>
    </section>
<jsp:include page="../_footer.jsp"/>