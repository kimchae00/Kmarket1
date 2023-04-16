<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/member/_header.jsp"/>
<script>
	$(function() {
		
		let type = "${type}";
		
		$('.agree').click(function() {
			console.log('here1');
			
			let isCheck1 = $('input[name=agree1]').is(':checked');
			let isCheck2 = $('input[name=agree2]').is(':checked');
			let isCheck3 = $('input[name=agree3]').is(':checked');
			let isCheck4 = $('input[name=agree4]').is(':checked');
			
			console.log('here2');
			
			if(isCheck1 && isCheck2 && isCheck3){
				
				if(isCheck4){
					if(type == 'normal'){
						console.log('here3');
						location.href='/Java1_Kmarket1/member/register.do?locationTerms=1';	
					}else{
						console.log('here4');
						location.href='/Java1_Kmarket1/member/registerSeller.do';
					}
				}else{
					if(type == 'normal'){
						console.log('here5');
						location.href='/Java1_Kmarket1/member/register.do?locationTerms=0';	
					}else{
						console.log('here6');
						location.href='/Java1_Kmarket1/member/registerSeller.do';
					}
				}
				
			}else{
				console.log('here8');
				alert('동의 체크를 하셔야 합니다.');
				
			}
		});
		
	});
</script>
<main id="member">
    <div class="signup">
        <nav>
            <h1>약관동의</h1>
        </nav>
        <section>
            <h3>
                <span class="essential">(필수)</span>케이마켓 이용약관
            </h3>
            <c:choose>
            <c:when test="${type == 'normal'}">
            <textarea class="terms" readonly>${vo.terms}</textarea>
            </c:when>
            <c:otherwise>
            <textarea class="terms" readonly>${vo.tax}</textarea>
            </c:otherwise>
            </c:choose>
            <label>
                <input type="checkbox" name="agree1">동의합니다.
            </label>
            <h3>
                <span class="essential">(필수)</span>전자금융거래 이용약관
            </h3>
            <textarea class="financial" readonly>${vo.finance}</textarea>
            <label>
                <input type="checkbox" name="agree2">동의합니다.
            </label>
            <h3>
                <span class="essential">(필수)</span>개인정보 수집동의
            </h3>
            <textarea class="privacy" readonly>${vo.privacy}</textarea>
            <label>
                <input type="checkbox" name="agree3">동의합니다.
            </label>
        </section>
        
        <c:choose>
            <c:when test="${type == 'normal'}">
            	<section>
		            <h3>
		                <span class="optional">(선택)</span>위치정보 이용약관
		            </h3>
		            <textarea class="location" readonly>${vo.location}</textarea>
		            <label>
		                <input type="checkbox" name="agree4">동의합니다.
		            </label>
        		</section>
            </c:when>
        <c:otherwise>
        
        
        </c:otherwise>    
            
        </c:choose>
        
        
        
        <div>
            <input type="button" class="agree" value="동의하기">
        </div>
    </div>
</main>
     <jsp:include page="/member/_footer.jsp"/>