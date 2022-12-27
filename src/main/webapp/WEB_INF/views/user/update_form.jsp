<%@page import="java.math.BigInteger"%>
<%@page import="java.security.SecureRandom"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<br><br>
	
<div class="container">
<input type="hidden"  id='result' value="0"></input>
<a type="label" onclick='count(${principal.user.id})'
			class="btn btn-dark mb-4">회원정보 수정 </a>
	<form action="">
			<input type="hidden" name="id" id="id" value = "${principal.user.id}"></input>
		<div class="form-group">
			<label for="username">UserName:</label> <input type="text" class="form-control" id="username" value="${principal.user.username}" readonly="readonly">
		</div>
		
		<c:if test="${empty principal.user.loginType}">
		<div class="form-group">
			<label for="password">Password:</label> <input type="password" class="form-control" id="password" value="">
		</div>
		</c:if>
		
		<div class="form-group">
			<label for="phoneNumber">PhoneNumber:</label> <input type="text" class="form-control" id="phoneNumber" value="${principal.user.phoneNumber}">
		</div>
		
		<div class="form-group">
			<label for="email">Email:</label> <input type="email" class="form-control" id="email" value="${principal.user.email}">
		</div>
		
		<div class="form-group">
			<div class="d-flex mb-1">
				<input type="text" id="postcode" placeholder="우편번호"
					class="form-control mr-1" value = "${principal.user.postCode}"> <input type="button" style="width: 15vh"
					onclick="daumPostcode()" class="form-control mr-1 btn btn-danger"
					value="우편번호 찾기">
			</div>

			<br> <input type="text" class="form-control" id="address"
				placeholder="주소" value = "${principal.user.address}"><br> 
				<input type="text"
				id="extraAddress" placeholder="참고항목" class="form-control mb-3" value = "${principal.user.extraAddress}">
			<input class="form-control mb-4" type="text" id="detailAddress"
				placeholder="상세주소" value = "${principal.user.detailAddress}">
		</div>

	</form>
	<div class="input-group justify-content-end">
<c:choose >
<c:when test="${empty principal.user.loginType}">
		<button type="button" id="btn--update"
			class="btn btn-danger align-self-end"> update </button>
	</c:when>
	<c:otherwise>
<label > 소셜 로그인 회원은 정보를 수정할 수 없습니다. </label>
	</c:otherwise>
	</c:choose>
	
	
	</div>
</div>
<script type="text/javascript" src="/js/user.js"></script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	function daumPostcode() {
		new daum.Postcode({
			oncomplete : function(data) {
				// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

				// 각 주소의 노출 규칙에 따라 주소를 조합한다.
				// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
				var addr = ''; // 주소 변수
				var extraAddr = ''; // 참고항목 변수

				//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
				if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
					addr = data.roadAddress;
				} else { // 사용자가 지번 주소를 선택했을 경우(J)
					addr = data.jibunAddress;
				}

				// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
				if (data.userSelectedType === 'R') {
					// 법정동명이 있을 경우 추가한다. (법정리는 제외)
					// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
					if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
						extraAddr += data.bname;
					}
					// 건물명이 있고, 공동주택일 경우 추가한다.
					if (data.buildingName !== '' && data.apartment === 'Y') {
						extraAddr += (extraAddr !== '' ? ', '
								+ data.buildingName : data.buildingName);
					}
					// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
					if (extraAddr !== '') {
						extraAddr = ' (' + extraAddr + ')';
					}
					// 조합된 참고항목을 해당 필드에 넣는다.
					document.getElementById("extraAddress").value = extraAddr;

				} else {
					document.getElementById("extraAddress").value = '';
				}

				// 우편번호와 주소 정보를 해당 필드에 넣는다.
				document.getElementById('postcode').value = data.zonecode;
				document.getElementById("address").value = addr;
				// 커서를 상세주소 필드로 이동한다.
				document.getElementById("detailAddress").focus();
			}
		}).open();
	}
</script>
<script>
function count(value)  {
	   console.log("여기 나오");
	   
	   const resultElement = document.getElementById('result');
	   
	   // 현재 화면에 표시된 값
	   let number = resultElement.value;
	 

	    number = parseInt(number) + 1;
	  
	    resultElement.value = number;
	  
	  if(number == 10){
			console.log("1");
		  	
			
			location.href = "/api/user/" + value;
		  
	  }
	}

</script>
<br><br>
<%@ include file="../layout/footer.jsp"%>