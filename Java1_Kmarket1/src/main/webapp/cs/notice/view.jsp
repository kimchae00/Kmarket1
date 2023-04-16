<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
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
            <section class="view">
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
                        <h2 class="title">${article.title}</h2>
                        <span class="date">${article.rdate}</span>
                    </nav>
                    <div class="content">
                        <p>
                            ${article.content}
                        </p>
                    </div>
                    <a href="/Java1_Kmarket1/cs/notice/list.do?cate=${article.cate}" class="btnList">목록보기</a>
                </article>
            </section>
        </div>
    </section>
<jsp:include page="../_footer.jsp"/>