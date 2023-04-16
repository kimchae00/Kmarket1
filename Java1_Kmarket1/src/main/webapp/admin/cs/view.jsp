<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"/>
<script>
$(function() {
	$('.replySub').click(function(e) {
		let reply = $('.reply').val();
		let no = $('input[name=no]').val();
		let uid = $('input[name=uid]').val();
		let group = $('input[name=group]').val();
		let cate = $('input[name=cate]').val();
		let cate2 = $('input[name=cate2]').val();
		let jsonData = {
				"reply":reply,
				"no":no,
				"uid":uid
				};
		$.ajax({
			url:"/Java1_Kmarket1/admin/cs/view.do",
			method:"post",
			data:jsonData,
			dateType:"json",
			success:function(data){
				if(data.result != 0){
					location.href = "/Java1_Kmarket1/admin/cs/list.do?group="+group+"&cate="+cate+"&cate2"+cate2;
				}
			}
		});
		return false;
	});
});
</script>
<section id="csView">
	<c:choose>
	<c:when test="${group.equals('notice')}">
		<nav>
	        <h3>공지사항 보기</h3>
	        <p>HOME > 고객센터 ><strong>공지사항</strong></p>
	    </nav>
    </c:when>
	<c:when test="${group.equals('faq')}">
		<nav>
	        <h3>자주묻는질문 보기</h3>
	        <p>HOME > 고객센터 ><strong>자주묻는질문</strong></p>
	    </nav>
    </c:when>
	<c:when test="${group.equals('qna')}">
		<nav>
	        <h3>문의하기 보기</h3>
	        <p>HOME > 고객센터 ><strong>문의하기</strong></p>
	    </nav>
    </c:when>
    </c:choose>
    <table>
    	<tr>
    		<td>유형1</td>
    		<c:choose>
   			<c:when test="${article.cate.equals('service')}">
   				<td>고객서비스</td>
   			</c:when>
   			<c:when test="${article.cate.equals('deal')}">
   				<td>안전거래</td>
   			</c:when>
   			<c:when test="${article.cate.equals('danger')}">
   				<td>위해상품</td>
   			</c:when>
   			<c:when test="${article.cate.equals('lucky')}">
   				<td>이벤트당첨</td>
   			</c:when>
   			<c:when test="${article.cate.equals('member')}">
   				<td>회원</td>
   			</c:when>
   			<c:when test="${article.cate.equals('event')}">
   				<td>쿠폰/이벤트</td>
   			</c:when>
   			<c:when test="${article.cate.equals('order')}">
   				<td>주문/결제</td>
   			</c:when>
   			<c:when test="${article.cate.equals('deli')}">
   				<td>배송</td>
   			</c:when>
   			<c:when test="${article.cate.equals('cancle')}">
   				<td>취소/반품/교환</td>
   			</c:when>
   			<c:when test="${article.cate.equals('trip')}">
   				<td>여행/항공/숙박</td>
   			</c:when>
   			<c:when test="${article.cate.equals('safe')}">
   				<td>안전거래</td>
   			</c:when>
    		</c:choose>
    	</tr>
    	<c:if test="${group.equals('faq') || group.equals('qna')}">
    	<tr>
    	<td>유형2</td>
    	<c:forEach var="ca2" items="${artiCate2s}">
    			<c:if test="${article.cate.equals(ca2.artiCate) && article.cate2.equals(ca2.artiCate2)}">
    				<td colspan="1">${ca2.c2Name}</td>
    			</c:if>
    	</c:forEach>
    	</tr>
    	</c:if>
    	<tr>
    		<td>제목</td>
    		<td>${article.title}</td>
    	</tr>
    	<tr>
    		<td>내용</td>
    		<td class="content">${article.content}</td>
    	</tr>
    	<c:choose>
    		<c:when test="${group.equals('qna') && article.comment == 0}">
    			<tr>
    				<td>답변</td>
    				<td><textarea class="reply"></textarea></td>
    			</tr>
    		</c:when>
    		<c:when test="${group.equals('qna') && article.comment != 0}">
    			<tr>
    				<td>답변</td>
    				<td>${reply.content}</td>
    			</tr>
    		</c:when>
    	</c:choose>
    </table>
    <div>
    	<a href="/Java1_Kmarket1/admin/cs/list.do?group=${group}" class="btn btnList">목록</a>
    	<c:choose>
	    	<c:when test="${group.equals('notice') || group.equals('faq')}">
	    		<a href="/Java1_Kmarket1/admin/cs/modify.do?group=${group}&no=${article.no}" class="btn btnMod">수정</a>
	    	</c:when>
	    	<c:when test="${group.equals('qna') && article.comment == 0}">
	    		<a href="#" class="btn btnList replySub">답변등록</a>
	    	</c:when>
    	</c:choose>
    	<a href="/Java1_Kmarket1/admin/cs/delete.do?group=${group}&no=${article.no}" class="btn btnDel2">삭제</a>
    </div>
    <input type="hidden" name="no" value="${article.no}">
    <input type="hidden" name="uid" value="uid">
    <input type="hidden" name="group" value="${group}">
    <input type="hidden" name="cate" value="${article.cate}">
    <input type="hidden" name="cate2" value="${article.cate2}">
</section>
</main>
<jsp:include page="../_footer.jsp"/>