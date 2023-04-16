<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"/>
<script>
$(function(){
	$("select[name=cate]").click(function(){
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
				console.log(data)
				for(let vo of data){
                    let tag = "<option class='opt' value="+vo.artiCate2+">"+vo.c2Name+"</option>";
                    $('select[name=cate2]').append(tag); // select에 option을 뒤에 붙임
                }
			}
		});
	});
	// 글 수정 유효성 검사
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
    <section id="cs">
        <div class="qna">
            <nav>
                <div>
                    <p>
                        홈<span>></span>문의하기
                    </p>
                </div>
            </nav>
            <section class="write">
                <aside>
                    <h2>문의하기</h2>
                    <ul>
                        <li class="${cate.equals('member') ?'on':'off'}"><a href="/Java1_Kmarket1/cs/qna/list.do?cate=member">회원</a></li>
                        <li class="${cate.equals('event') ?'on':'off'}"><a href="/Java1_Kmarket1/cs/qna/list.do?cate=event">쿠폰/이벤트</a></li>
                        <li class="${cate.equals('order') ?'on':'off'}"><a href="/Java1_Kmarket1/cs/qna/list.do?cate=order">주문/결제</a></li>
                        <li class="${cate.equals('deli') ?'on':'off'}"><a href="/Java1_Kmarket1/cs/qna/list.do?cate=deli">배송</a></li>
                        <li class="${cate.equals('cancle') ?'on':'off'}"><a href="/Java1_Kmarket1/cs/qna/list.do?cate=cancle">취소/반품/교환</a></li>
                        <li class="${cate.equals('trip') ?'on':'off'}"><a href="/Java1_Kmarket1/cs/qna/list.do?cate=trip">여행/숙박/항공</a></li>
                        <li class="${cate.equals('safe') ?'on':'off'}"><a href="/Java1_Kmarket1/cs/qna/list.do?cate=safe">안전거래</a></li>
                    </ul>
                </aside>
                <article>
                    <form action="/Java1_Kmarket1/cs/qna/write.do" method="post">
                    	<input type="hidden" name="group" value="qna">
                    	<input type="hidden" name="uid" value="${sessUser.uid}">
                        <table>
                            <tr>
                                <td>문의유형</td>
                                <td>
                                	<select name="cate">
                                		<option value="0">1차 유형</option>
                                		<option value="member">회원</option>
                                		<option value="event">쿠폰/이벤트</option>
                                		<option value="order">주문/결제</option>
                                		<option value="deli">배송</option>
                                		<option value="cancle">취소/반품/교환</option>
                                		<option value="trip">여행/숙박/항공</option>
                                		<option value="safe">안전거래</option>
                                	</select>
                                    <select name="cate2">
                                        <option value="0">2차 유형</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>문의제목</td>
                                <td>
                                    <input type="text" name="title" placeholder="제목을 입력하세요.">
                                </td>
                            </tr>
                            <tr>
                                <td>문의내용</td>
                                <td>
                                    <textarea name="content" placeholder="내용을 입력하세요."></textarea>
                                </td>
                            </tr>
                        </table>
                        <div>
                            <a href="/Java1_Kmarket1/cs/qna/list.do?cate=member" class="btnList">취소하기</a>
                            <input type="submit" class="btnSubmit" value="등록하기">
                        </div>
                    </form>
                </article>
            </section>
        </div>
    </section>
<jsp:include page="../_footer.jsp"/>