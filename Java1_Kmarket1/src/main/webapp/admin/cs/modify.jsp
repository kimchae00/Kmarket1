<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"/>
<script type="text/javascript">
$(function(){
	let ca = $("select[name=cate]").val();
	let jsonData = {
			"cate":ca
	}
	$.ajax({
		url:'/Java1_Kmarket1/cs/qna/artiCate2list.do',
		method:'POST',
		data:jsonData,
		dataType:'json',
		success:function(data){
			//console.log(data)
			for(let vo of data){
				let ca2 = $('input[name=cate2]').val();
				let tag = null;
				if(ca2==vo.artiCate2){
					tag = "<option class='opt' value="+vo.artiCate2+" selected>"+vo.c2Name+"</option>";
				}else{
					tag = "<option class='opt' value="+vo.artiCate2+">"+vo.c2Name+"</option>";
				}
                $('select[name=cate2]').append(tag); // select에 option을 뒤에 붙임
            }
		}
	});
	
	
	// 1차 유형 선택 시 2차 유형 카테고리 불러오기
	$("select[name=cate]").on("change",function(){
		let cate = $(this).val(); // 선택된 option의 value = select의 value
		let jsonData = {
				"cate":cate
		}
		$('.opt').remove(); // cate1 다시 선택 시 이전 cate2를 지우기 위해
		$.ajax({
			url:'/Java1_Kmarket1/cs/qna/artiCate2list.do',
			method:'POST',
			data:jsonData,
			dataType:'json',
			success:function(data){
				//console.log(data)
				for(let vo of data){
                    let tag = "<option class='opt' value="+vo.artiCate2+">"+vo.c2Name+"</option>";
                    $('select[name=cate2]').append(tag); // select에 option을 뒤에 붙임
                }
			}
		});
	});
	// 글수정 유효성 검사
	$('.write form').submit(function() {
		let cate2 = $('select[name=cate2]').val(); // 카테고리 유효성
		let title = $('input[name=title]').val(); // 제목 유효성
		let content = $('textarea[name=content]').val(); // 내용 유효성
		
		if(cate2 == 0){
			alert('카테고리를 선택해주세요.');
			return false;
		}
		if(title == ''){
			alert('제목을 입력해주세요.')
			return false;
		}
		if(content == ''){
			alert('내용을 입력해주세요.')
			return false;
		}
	});
});
</script>
<section id="csModify">
	<c:choose>
	<c:when test="${group.equals('notice')}">
		<nav>
	        <h3>공지사항 수정</h3>
	        <p>HOME > 고객센터 ><strong>공지사항</strong></p>
	    </nav>
    </c:when>
	<c:when test="${group.equals('faq')}">
		<nav>
	        <h3>자주묻는질문 수정</h3>
	        <p>HOME > 고객센터 ><strong>자주묻는질문</strong></p>
	    </nav>
    </c:when>
	<c:when test="${group.equals('qna')}">
		<nav>
	        <h3>문의하기 수정</h3>
	        <p>HOME > 고객센터 ><strong>문의하기</strong></p>
	    </nav>
    </c:when>
    </c:choose>
    <article>
        <form action="/Java1_Kmarket1/admin/cs/modify.do" method="post">
       	<input type="hidden" name="group" value="${group}">
       	<input type="hidden" name="cate2" value="${article.cate2}">
       	<input type="hidden" name="uid" value="${sessUser.uid}">
       	<input type="hidden" name="no" value="${no}">
           <table>
               <tr>
                   <td>유형</td>
                   <td>
		               <select name="cate">
					    	<c:choose>
					    	<c:when test="${group.equals('notice')}">
					    	<option value="0">유형선택</option>
					    	<option value="service" ${article.cate=='service'?'selected':''}>고객서비스</option>
					    	<option value="deal" ${article.cate=='deal'?'selected':''}>안전거래</option>
					    	<option value="danger" ${article.cate=='danger'?'selected':''}>위해상품</option>
					    	<option value="lucky" ${article.cate=='lucky'?'selected':''}>이벤트당첨</option>
					    	</c:when>
					    	<c:when test="${group.equals('qna') || group.equals('faq') }">
					    	<option value="0">1차유형</option>
					    	<option value="member" ${article.cate=='member'?'selected':''}>회원</option>
					    	<option value="event" ${article.cate=='event'?'selected':''}>쿠폰/이벤트</option>
					    	<option value="order" ${article.cate=='order'?'selected':''}>주문/결제</option>
					    	<option value="deli" ${article.cate=='deli'?'selected':''}>배송</option>
					    	<option value="cancle" ${article.cate=='cancle'?'selected':''}>취소/반품/교환</option>
					    	<option value="trip" ${article.cate=='trip'?'selected':''}>여행/항공/숙박</option>
					    	<option value="safe" ${article.cate=='safe'?'selected':''}>안전거래</option>
					    	</c:when>
					    	</c:choose>
					   </select>
					   <c:if test="${group.equals('qna') || group.equals('faq') }">
					   <select name="cate2">
					   <option value="0">2차유형</option>
					   </select>
					   </c:if>
                   </td>
               </tr>
               <tr>
                   <td>제목</td>
                   <td>
                       <input type="text" name="title" value="${article.title}">
                   </td>
               </tr>
               <tr>
                   <td>내용</td>
                   <td>
                       <textarea name="content">${article.content}</textarea>
                   </td>
               </tr>
           </table>
           <div>
               <a href="/Java1_Kmarket1/admin/cs/view.do?group=${group}&no=${article.no}" class="btn btnList">취소하기</a>
               <input type="submit" class="btn btnSubmit" value="등록하기">
           </div>
       </form>
   </article>
</section>
</main>
<jsp:include page="../_footer.jsp"/>