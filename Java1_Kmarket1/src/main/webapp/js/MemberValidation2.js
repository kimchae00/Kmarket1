/**
 * 날짜 : 2022/12/14
 * 이름 : 장인화
 * 내용 : 회원가입 입력데이터 유효성 검증
 */
	// 데이터 검증에 사용할 정규표현식
	let regUid   = /^[a-z]+[a-z0-9]{3,12}$/g;
	let regName  = /^[가-힣]{2,4}$/;
	let regEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	let regHp	 = /^\d{3}-\d{3,4}-\d{4}$/;
	let regPass  = /^.*(?=^.{8,12}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
	
	// 폼 데이터 검증 결과 상태변수
	let isUidOk   = false;
	let isPassOk  = false;
	let isPassMatch  = false;
	let isNameOk  = false;
	let isNickOk  = false;
	let isEmailOk = false;
	let isHpOk    = false;
	let isEmailAuthOk = false;
	let isEmailAuthCodeOk = false;
	let receivedCode = 0;	
	
	$(function(){
		
		$('input[name=uid]').keydown(function(){
			isUidOk = false;
		});
		
		$('#btnUidCheck').click(function(){
			
			let uid = $('input[name=uid]').val();
			
			if(isUidOk){
				return;
			}	
			
			if(!uid.match(regUid)){
				$('.resultUid').css('color', 'red').text('아이디가 유효하지 않습니다.');
				return;
			}
			
			let jsonData = {"uid":uid};
			
			$('.resultUid').css('color', 'black').text('...');
			console.log('here5');
			
			setTimeout(()=>{
				console.log('here6');
				$.ajax({
					url: '/Java1_Kmarket1/member/checkUid.do',
					method: 'get',
					data: jsonData,
					dataType: 'json',
					success:function(data){
						//console.log(data);
						if(data.result == 0){
							console.log('here7');
							isUidOk = true;
							$('.resultUid').css('color', 'green').text('사용 가능한 아이디 입니다.');
						}else{
							console.log('here8');
							isUidOk = false;
							$('.resultUid').css('color', 'red').text('이미 사용중인 아이디 입니다.');
						}
					}
				});
				
			}, 500);
		});
	
	// 비밀번호 형식검사 일치여부 확인
	$('input[name=pass2]').focusout(function(){			
		let pass1 = $('input[name=pass1]').val();
		let pass2 = $(this).val();

		if(pass1 == pass2){
							
			if(pass2.match(regPass)){
				isPassOk = true;
				$('.resultPass').css('color', 'green').text('비밀번호가 일치합니다.');	
			}else{
				isPassOk = false;
				$('.resultPass').css('color', 'red').text('영문, 숫자, 특수문자 조합 8자~12자 설정해 주세요.');
			}				
			
		}else{
			isPassOk = false;
			$('.resultPass').css('color', 'red').text('비밀번호가 일치하지 않습니다.');
		}	
		
	});
		
	
	
	// 이메일 유효성 검사
	$('input[name=email]').focusout(function(){
		let email = $(this).val();
		
		if(!email.match(regEmail)){
			isEmailOk = false;
			$('.resultEmail').css('color', 'red').text('이메일이 유효하지 않습니다.');
		}else{
			isEmailOk = true;
			$('.resultEmail').text('');
		}			
	});
	

	
	// 폼 전송이 시작될 때 실행되는 폼 이벤트(폼 전송 버튼을 클릭했을 때) 
	$('.register > form').submit(function(){
	
		
		////////////////////////////////////
		// 폼 데이터 유효성 검증(Validation)
		////////////////////////////////////
		// 아이디 검증
		if(!isUidOk){
			alert('아이디를 확인 하십시요.');
			return false;
		}
		// 비밀번호 검증
		if(!isPassOk){
			alert('비밀번호를 확인 하십시요.');
			return false;
		}
	
		// 이메일 검증
		if(!isEmailOk){
			alert('이메일을 확인 하십시요.');
			return false;
		}
		// 휴대폰 검증
		if(!isHpOk){
			alert('휴대폰을 확인 하십시요.');
			return false;
		}
		
		// 최종 전송
		return true;
	});
	
	});
