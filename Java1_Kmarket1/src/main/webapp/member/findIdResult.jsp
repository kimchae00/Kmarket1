<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/member/_header.jsp"/>
<main id="member">
    <div class="findIdResult">
        <nav>
            <h1>아이디 찾기 결과</h1>
            <p>
                HOME > 로그인 > 아이디 찾기 > 
                <strong>아이디 찾기 결과</strong>
            </p>
        </nav>

     <form action="/Java1_Kmarket1/member/findIdResult" method="post">
        <section>
            <table>
                <caption>고객님의 정보와 일치하는 아이디 입니다.</caption>
                <tbody>
                    <tr>
                        <th>이름</th>
                        <td></td>
                    </tr>
                    <tr>
                        <th>아이디</th>
                        <td></td>
                    </tr>
                    <tr>
                        <th>이메일</th>
                        <td></td>
                    </tr>
                    <tr>
                        <th>가입일</th>
                        <td></td>
                    </tr>
                </tbody>
            </table>
        </section>

        <div class="btns">
            <a href="/Java1_Kmarket1/member/login.do" class="btn btnCancel">로그인</a>
            <a href="/Java1_Kmarket1/member/findPw.do" class="btn btnNext">비밀번호 찾기</a>
        </div>

     </form>
    </div>
</main>
 <jsp:include page="/member/_footer.jsp"/>