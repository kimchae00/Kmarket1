<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/member/_header.jsp"/>
<main id="member">
    <div class="findId">
        <nav>
            <h1>아이디 찾기</h1>
            <p>
                HOME > 로그인 > 
                <strong>아이디찾기</strong>
            </p>
        </nav>
        <form action="/Java1_Kmarket1/member/findId.do" method="post">
            <section>
                <table>
                    <caption>이메일로 찾기</caption>
                    <tbody>
                        <tr>
                            <th>
                                <span class="essential">*</span>이름
                            </th>
                            <td><input type="text" name="name" placeholder="이름 입력"/></td>
                        </tr>
                        <tr class="email">
                            <th>
                                <span class="essential">*</span>이메일
                            </th>
                            <td>
                                <div>
                                    <input type="email" name="email" placeholder="이메일 입력"/>
                                    <span class="resultEmail"></span>
                                    <button type="button" class="btnAuth" id="btnEmail">인증번호 받기</button>
                                </div>
                                <div class="auth">
                                    <input type="text" name="auth" placeholder="인증번호 입력"/>
                                    <button type="button" class="btnConfirm" id="btnEmailConfirm">확인</button>
                                </div>
                            </td>
                        </tr>            
                    </tbody>
                </table>
            </section>

            <p class="explain">
                회원가입시 이메일 주소와 입력한 이메일 주소가 같아야, 인증번호를 받을 수 있습니다.<br>
                인증번호를 입력 후 <strong>아이디찾기</strong> 버튼을 누르세요.
            </p>

            <div class="findIdNext">
                <a href="/Java1_Kmarket1/member/findIdResult.do" class="btn btnNext">아이디 찾기</a>
            </div>
        </form>
    </div>
</main>
   <jsp:include page="/member/_footer.jsp"/>