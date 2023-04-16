<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/member/_header.jsp"/>

<script>

	$(function(){
		$('#eye').click(function() {
			
		$('input').toggleClass('active');
		
		  if($('input').hasClass('active')){
	            $(this).attr('class',"fa fa-eye-slash fa-lg")
	            .prev('input').attr('type',"text");
	        }else{
	            $(this).attr('class',"fa fa-eye fa-lg")
	            .prev('input').attr('type','password');
	        }
		});
		
		
	
	});
	
	function checkCapsLock(event)  {
		  if (event.getModifierState("CapsLock")) {
			  $('.bubble').show();
			  $('#capsLock').text("CapsLock 이 켜져있습니다.");
			  $('#capsLock').show();
		  }else {
			  $('.bubble').hide();
			  $('#capsLock').hide();
		  }
		}

</script>
        <main id="member">
            <div class="login">
                <nav>
                    <h1>로그인</h1>
                    <p>
                        HOME >
                        <strong>로그인</strong>
                    </p>
                </nav>
                <form action="/Java1_Kmarket1/member/login.do" method="post">
                    <table border="0">
                        <tbody>
                            <tr>
                                <td>아이디</td>
                                <td>
                                    <input type="text" name="uid" placeholder="아이디 입력">
                                </td>
                            </tr>
                            <tr>
                                <td>비밀번호</td>
                                <td>
                                    <input type="password" name="pass" id="password" placeholder="비밀번호 입력" onkeyup="checkCapsLock(event)">
                                    <i class="fa fa-eye fa-lg" id="eye"></i>
                                </td>
                            </tr>
                            <tr class="bubble">
                            	<td></td>
                            	<td><p id="capsLock"></p></td>
                            </tr>
                        </tbody>
                    </table>
                    <input type="submit" value="로그인">
                    <span>
                        <label><input type="checkbox" name="auto">자동 로그인</label>
                        <a href="/Java1_Kmarket1/member/findId.do">아이디찾기</a>
                        <a href="/Java1_Kmarket1/member/findPw.do">비밀번호찾기</a>
                        <a href="/Java1_Kmarket1/member/join.do">회원가입</a>
                    </span>
                    <a href="https://promotion.gmarket.co.kr/Event/CouponZone.asp" class="banner">
                        <img src="/Java1_Kmarket1/member/img/member_login_banner.jpg" alt="1만원 할인 쿠폰 받기">
                    </a>
                </form>
                <img src="/Java1_Kmarket1/member/img/member_certifi_logo.gif" alt="banner">                
            </div>
        </main>
<jsp:include page="/member/_footer.jsp"/>