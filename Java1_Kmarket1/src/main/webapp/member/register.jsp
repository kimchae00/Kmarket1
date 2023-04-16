<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/member/_header.jsp"/>
<script src="http://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/Java1_Kmarket1/js/postcode.js"></script>
<script src="/Java1_Kmarket1/js/registerValidation.js"></script>


<main id="member">
<div class="register">
    <nav>
        <h1>일반 회원가입</h1>
    </nav>
    <form action="/Java1_Kmarket1/member/register.do" method="post">
  
        <section>
            <table>
                <caption>필수 정보입력</caption>
                <tbody>
                    <tr>
                        <th>
                            <span class="essential">*</span>아이디
                        </th>
                        <td><input type="text" name="uid" placeholder="아이디를 입력" required>
                        	<button type="button" id="btnUidCheck">중복확인</button>
                        	<span class="resultUid">영문, 숫자로 4~12자까지 설정해 주세요.</span>
                              <input type="hidden" name="type" value="1">
    						  <input type="hidden" name="level" value="1">
    						  <input type="hidden" name="locationTerms" value="${locationTerms}">
                       </td>
                   </tr>
                   <tr>
                       <th>
                           <span class="essential">*</span>비밀번호
                       </th>
                       <td><input type="password" name="pass1" placeholder="비밀번호를 입력" required>
                       <span class="resultPass1">영문, 숫자, 특수문자를 조합하여 8~12자까지 설정해 주세요.</span>
                       </td>
                   </tr>
                   <tr>
                       <th>
                           <span class="essential">*</span>비밀번호확인
                       </th>
                       <td><input type="password" name="pass2" placeholder="비밀번호를 확인" required>
                       <span class="resultPass"> 비밀번호 재입력</span>
                       </td>
                   </tr>
               </tbody>
           </table>
       </section>
       <section>
           <table>
               <caption>기본 정보입력</caption>
               <tbody>
                   <tr>
                       <th>
                           <span class="essential">*</span>이름
                       </th>
                       <td>
                           <input type="text" name="name" placeholder="이름을 입력" required>
                           <span class="resultName"></span>
                       </td>
                   </tr>
                   <tr>
                       <th>
                       <span class="essential">*</span>성별
                       </th>
                       <td>
                           <label><input type="radio" name="gender" value="1" checked>&nbsp남</label>
                           <label><input type="radio" name="gender" value="2">&nbsp여</label>
                       </td>
                   </tr>
                   <tr>
                       <th>
                           <span class="essential">*</span>EMAIL
                       </th>
                       <td>
                           <input type="email" name="email" placeholder="이메일 입력" required>
                           <span class="resultEmail"></span>
                       </td>
                   </tr>
                   <tr>
                       <th>
                           <span class="essential">*</span>휴대폰
                       </th>
                       <td>
                           <input type="text" name="hp" maxlength="13" placeholder="휴대폰번호 입력" required>
                           <span class="resultHp"> - 포함 13자리를 입력하세요.</span>   
                       </td>
                   </tr>
                   <tr class="addr">
                       <th>주소</th>
                       <td>
                           <div>
                               <input type="text" name="zip" id="zip" placeholder="우편번호를 검색하세요." readonly/>
               				<button type="button" id="btnZip" onclick="postcode()">우편번호 찾기</button>
                            </div>
                            <div>
                               <input type="text" name="addr1" id="addr1" size="50" placeholder="주소를 검색하세요." readonly/>
                            </div>
                            <div>
                                <input type="text" name="addr2" id="addr2" size="50" placeholder="상세주소를 입력하세요.">
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
        </section>
        <div>
            <input type="submit" class="join" value="회원가입">
        </div>
    </form>
</div>
</main>
 <jsp:include page="/member/_footer.jsp"/>