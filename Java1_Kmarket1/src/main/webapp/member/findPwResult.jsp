<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/member/_header.jsp"/>
 <main id="member">
     <div class="findPwResult">
         <nav>
             <h1>비밀번호 변경</h1>
             <p>
                 HOME > 로그인 > 비밀번호 찾기 > 
                 <strong>비밀번호 변경</strong>
             </p>
         </nav>
         <form action="#" method="post">
             <section>
                 <table>
                     <caption>
                         비밀번호를 변경해 주세요.<br/>
                         영문, 숫자, 특수문자를 사용하여 8자 이상 입력해 주세요.
                     </caption>                 
                         <tr>
                             <th>아이디</th>
                             <td class="uid">uid</td>
                         </tr>
                         <tr>
                             <th>새 비밀번호</th>
                             <td>
                                 <input type="password" name="pass1" placeholder="새 비밀번호 입력"/>
                             </td>
                         </tr>
                         <tr>
                             <th>새 비밀번호 확인</th>
                             <td>
                                 <input type="password" name="pass2" placeholder="새 비밀번호 확인"/>
                             </td>
                         </tr>
                 </table>

                 <div class="btns">
                     <a href="/Java1_Kmarket1/index.do" class="btn btnCancel">취소</a>
                     <a href="/Java1_Kmarket1/member/login.do" class="btn btnNext">다음</a>
                 </div>


             </section>
         </form>

     </div>
 </main>
 <jsp:include page="/member/_footer.jsp"/>