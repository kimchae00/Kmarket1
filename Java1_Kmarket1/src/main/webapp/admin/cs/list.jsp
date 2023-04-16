<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"/>
<script>
$(function(){
	// 
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
				//console.log(ca2);
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
	$("select[name=cate]").on("click",function(){
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
	// 2차 유형별 게시물 불러오기
	$('select[name=cate2]').on("change",function() {
		let group = $('input[name=group]').val();
		let cate = $('select[name=cate]').val();
		let cate2 = $(this).val();
		
		location.href = "/Java1_Kmarket1/admin/cs/list.do?pg=1&group="+group+"&cate="+cate+"&cate2="+cate2;
		
	});
	
	

	// 전체 체크박스 클릭 이벤트
	$('input[name=selectAll]').on("click",function(){
		let isCheck = $(this).is(":checked");
		
		let val_arr = [];
		$("input[name=select]").each(function(){
			let chk = $(this).val();
			val_arr.push(chk);
		})
		$('input[name=select]').remove();
		for(let i=0;i<10;i++){
			let tag = "<input type='checkbox' name='select' value="+val_arr[i]+">"
			let sel = ".chk"+i;
			$(sel).append(tag);
		}
		
		if(isCheck){
			$('input[name=select]').attr("checked",true); 
		}else {
			$('input[name=select]').attr("checked",false);
		}
		
	});
	// 각 체크박스 클릭 이벤트
	$('input[name=select]').each(function(){
		$(this).click(function(){
			let isCheck = $(this).is(":checked");
			if(isCheck){
				$(this).attr("checked",true); 
			}else {
				$(this).attr("checked",false);
			}
		});
	});
	// 선택삭제 버튼 이벤트
	$('.btnDel').click(function(){
		// 체크가 없으면 실행 안함
		let isCheck = $('input[name=select]').is(":checked");
		if(!isCheck){
			alert("삭제할 게시물을 선택해주세요.");
			return false;
		}
		
		let group = $('input[name=group]').val();
		let cate = $('input[name=cate]').val();
		let cate2 = $('input[name=cate2]').val();
		
		
		let chk_arr = [];
		$("input[name=select]:checked").each(function(){
			let chk = $(this).val();
			chk_arr.push(chk);
		})
		//console.log(chk_arr);
		let chks = chk_arr.toString();
		let jsonData = {
				"chks":chks
		}
		$.ajax({
			url:"/Java1_Kmarket1/admin/cs/list.do",
			method:"post",
			data:jsonData,
			dataType:"json",
			success:function(data){
				if(data.result > 0){
					location.href = "/Java1_Kmarket1/admin/cs/list.do?group="+group;	
				}
			}
		});
	});
});
</script>
<c:if test="${group.equals('notice')}">
<script>
$(function(){
	$('select[name=cate]').on("change",function() {
		let group = $('input[name=group]').val();
		let cate = $(this).val();
		location.href = "/Java1_Kmarket1/admin/cs/list.do?pg=1&group="+group+"&cate="+cate;
		
	});
});
</script>
</c:if>
<section id="csList">
	<c:choose>
	<c:when test="${group.equals('notice')}">
		<nav>
	        <h3>공지사항 목록</h3>
	        <p>HOME > 고객센터 ><strong>공지사항</strong></p>
	    </nav>
    </c:when>
	<c:when test="${group.equals('faq')}">
		<nav>
	        <h3>자주묻는질문 목록</h3>
	        <p>HOME > 고객센터 ><strong>자주묻는질문</strong></p>
	    </nav>
    </c:when>
	<c:when test="${group.equals('qna')}">
		<nav>
	        <h3>문의하기 목록</h3>
	        <p>HOME > 고객센터 ><strong>문의하기</strong></p>
	    </nav>
    </c:when>
    </c:choose>
    <select name="cate" id="cate">
    	<c:choose>
    	<c:when test="${group.equals('notice')}">
    	<option value="0">유형선택</option>
    	<option value="service" ${cate == 'service'? 'selected' : '' }>고객서비스</option>
    	<option value="deal" ${cate == 'deal'? 'selected' : '' }>안전거래</option>
    	<option value="danger" ${cate == 'danger'? 'selected' : '' }>위해상품</option>
    	<option value="lucky" ${cate == 'danger'? 'selected' : '' }>이벤트당첨</option>
    	</c:when>
    	<c:when test="${group.equals('qna') || group.equals('faq') }">
    	<option value="0">1차유형</option>
    	<option value="member" ${cate == 'member'? 'selected' : '' }>회원</option>
    	<option value="event" ${cate == 'event'? 'selected' : '' }>쿠폰/이벤트</option>
    	<option value="order" ${cate == 'order'? 'selected' : '' }>주문/결제</option>
    	<option value="deli" ${cate == 'deli'? 'selected' : '' }>배송</option>
    	<option value="cancle" ${cate == 'cancle'? 'selected' : '' }>취소/반품/교환</option>
    	<option value="trip" ${cate == 'trip'? 'selected' : '' }>여행/항공/숙박</option>
    	<option value="safe" ${cate == 'safe'? 'selected' : '' }>안전거래</option>
    	</c:when>
    	</c:choose>
    </select>
    <c:if test="${group.equals('qna') || group.equals('faq') }">
    <select name="cate2" id="cate2">
    	<option value="0">2차유형</option>
    </select>
    </c:if>
    <table>
    	<tr>
    		<th><input type="checkbox" name="selectAll" c></th>
    		<th>번호</th>
    		<c:choose>
    			<c:when test="${group.equals('notice')}">
    			<th>유형</th>
    			</c:when>
    			<c:when test="${group.equals('faq') || group.equals('qna')}">
    			<th>1차유형</th>
    			<th>2차유형</th>
    			</c:when>
    		</c:choose>
    		<th>제목</th>
    		<c:choose>
	    		<c:when test="${group.equals('notice') || group.equals('faq')}">
	    			<th>조회</th>
	    			<th>날짜</th>
	    			<th>관리</th>
	    		</c:when>
	    		<c:when test="${group.equals('qna')}">
	    			<th>작성자</th>
	    			<th>작성일</th>
	    			<th>상태</th>
	    		</c:when>
    		</c:choose>
    	</tr>
    	<c:forEach var="arti" items="${articles}" varStatus="i">
    	<tr>
    		<td class="chk${i.index}"><input type="checkbox" name="select" value="${arti.no}"></td>
    		<c:choose>
    		<c:when test="${group.equals('notice')||group.equals('qna')}">
    		<td>${pageStartNum-i.index}</td>
    		</c:when>
    		<c:when test="${group.equals('faq')}">
    		<td>${10-i.index}</td>
    		</c:when>
    		</c:choose>
    		<c:choose>
    			<c:when test="${arti.cate.equals('service')}">
    				<td>고객서비스</td>
    			</c:when>
    			<c:when test="${arti.cate.equals('deal')}">
    				<td>안전거래</td>
    			</c:when>
    			<c:when test="${arti.cate.equals('danger')}">
    				<td>위해상품</td>
    			</c:when>
    			<c:when test="${arti.cate.equals('lucky')}">
    				<td>이벤트당첨</td>
    			</c:when>
    			<c:when test="${arti.cate.equals('member')}">
    				<td>회원</td>
    			</c:when>
    			<c:when test="${arti.cate.equals('event')}">
    				<td>쿠폰/이벤트</td>
    			</c:when>
    			<c:when test="${arti.cate.equals('order')}">
    				<td>주문/결제</td>
    			</c:when>
    			<c:when test="${arti.cate.equals('deli')}">
    				<td>배송</td>
    			</c:when>
    			<c:when test="${arti.cate.equals('cancle')}">
    				<td>취소/반품/교환</td>
    			</c:when>
    			<c:when test="${arti.cate.equals('trip')}">
    				<td>여행/항공/숙박</td>
    			</c:when>
    			<c:when test="${arti.cate.equals('safe')}">
    				<td>안전거래</td>
    			</c:when>
    		</c:choose>
    		<c:forEach var="ca2" items="${artiCate2s}">
    			<c:if test="${arti.cate.equals(ca2.artiCate) && arti.cate2.equals(ca2.artiCate2)}">
    				<td>${ca2.c2Name}</td>
    			</c:if>
    		</c:forEach>
    		<td><a href="/Java1_Kmarket1/admin/cs/view.do?no=${arti.no}&group=${group}">${arti.title}</a></td>
    		<c:choose>
    		<c:when test="${group.equals('notice') || group.equals('faq')}">
    		<td>${arti.hit}</td>
    		</c:when>
    		<c:when test="${group.equals('qna')}">
    		<td>${arti.uid}***</td>
    		</c:when>
    		</c:choose>
    		<td>${arti.rdate}</td>
    		<c:choose>
    		<c:when test="${group.equals('notice') || group.equals('faq')}">
    		<td>
    			<a href="/Java1_Kmarket1/admin/cs/modify.do?no=${arti.no}&group=${group}">수정</a>
    			<a href="/Java1_Kmarket1/admin/cs/delete.do?no=${arti.no}&group=${group}">삭제</a>
    		</td>
    		</c:when>
    		<c:when test="${group.equals('qna') && arti.comment == 0}">
    		<td>
    			검토중
    		</td>
    		</c:when>
    		<c:when test="${group.equals('qna') && arti.comment != 0}">
    		<td>
    			<span style="color: #067dfd; font-weight: bold;" >답변완료</span> 
    		</td>
    		</c:when>
    		</c:choose>
    	</tr>
    	</c:forEach>
    </table>
    
    <div class="page">
    <c:if test="${group.equals('notice') || group.equals('qna')}">
	    <c:choose>
	    <c:when test="${pageGroupStart gt 1 && cate != null}">
	    <a href="/Java1_Kmarket1/admin/cs/list.do?pg=${pageGroupStart-1}&cate=${cate}&group=${group}" class="prev">이전</a>
	    </c:when>
	    <c:when test="${pageGroupStart gt 1 && cate == null}">
	    <a href="/Java1_Kmarket1/admin/cs/list.do?pg=${pageGroupStart-1}&group=${group}" class="prev">이전</a>
	    </c:when>
	    </c:choose>
	    <c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd }">
	    <c:choose>
	    <c:when test="${cate != null}">
	    <a href="/Java1_Kmarket1/admin/cs/list.do?pg=${i}&cate=${cate}&group=${group}" class="num ${i==currentPage?'current':'off'} ${i==currentPage?'on':'off'}">${i}</a>
	    </c:when>
	    <c:when test="${cate == null}">
	    <a href="/Java1_Kmarket1/admin/cs/list.do?pg=${i}&group=${group}" class="num ${i==currentPage?'current':'off'} ${i==currentPage?'on':'off'}">${i}</a>
	    </c:when>
	    </c:choose>
	    </c:forEach>
	    <c:choose>
	    <c:when test="${pageGroupEnd lt lastPageNum && cate != null}">
	    <a href="/Java1_Kmarket1/admin/cs/list.do?pg=${pageGroupStart+1}&cate=${cate}&group=${group}" class="next">다음</a>
	    </c:when>
	    <c:when test="${pageGroupEnd lt lastPageNum && cate == null}">
	    <a href="/Java1_Kmarket1/admin/cs/list.do?pg=${pageGroupStart+1}&group=${group}" class="next">다음</a>
	    </c:when>
	    </c:choose>
	</c:if>
    </div>
    
    <a href="#" class="btn btnDel">선택삭제</a>
    <c:choose>
    	<c:when test="${group.equals('notice') || group.equals('faq')}">
    		<a href="/Java1_Kmarket1/admin/cs/write.do?group=${group}" class="btn btnWrite">작성하기</a>
    	</c:when>
    	<c:when test="${group.equals('qna')}">
    		<a href="/Java1_Kmarket1/cs/qna/list.do" class="btn btnWrite">문의하기</a>
    	</c:when>
    </c:choose>
    
    <input type="hidden" name="group" value="${group}">
    <input type="hidden" name="cate" value="${cate}">
    <input type="hidden" name="cate2" value="${cate2}">
</section>
</main>
<jsp:include page="../_footer.jsp"/>
