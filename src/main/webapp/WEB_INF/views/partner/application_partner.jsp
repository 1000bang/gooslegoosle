<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/partner_header.jsp"%>
<section id="partner-join">

	<c:choose>
		<c:when test="${empty principal}">
			<div id="warning--wrap">
				<div id="login-warning">로그인 후 이용 부탁드립니다.</div>
				<p class="warning-msg">파트너 신청은 회원가입 이용바랍니다.</p>
				<p class="warning-msg">소셜 로그인은 파트너 신청이 어렵습니다.</p>
				<a href="/auth/login_form">
				<button class="btn move--btn btn--mar">로그인 하러 가기</button></a> 
				<a href="/auth/application_partner">
				<button class="btn move--btn">회원가입 하러 가기</button></a>
			</div>
		</c:when>
		<c:otherwise>
			<form class="was-validated"  id="uploadForm" action="/partner/${principal.user.id}" method="POST" enctype="multipart/form-data">
				<input type="hidden" id="id" value="${principal.user.id}">
				
				<div id="partner-info" class="info-box">
					<p class="info-title">사장님 정보를 입력해주세요 !</p>
					<div class="form-group">
						<label for="username">이름</label> <input type="text"
							class="form-control" id="username" placeholder="이름을 입력해주세요."
							value="${principal.user.username}" name="username" required>
						<div class="valid-feedback">완료 !</div>
						<div class="invalid-feedback">필수 입력 사항입니다.</div>
					</div> <!-- username end -->
					
					<div class="form-group">
						<label for="phoneNumber">휴대전화번호</label> <input type="text"
							class="form-control" id="phoneNumber"
							placeholder="휴대전화번호를 입력해주세요."
							value="${principal.user.phoneNumber}" name="phoneNumber" required>
						<div class="valid-feedback">완료 !</div>
						<div class="invalid-feedback">필수 입력 사항입니다.</div>
					</div><!-- phoneNumber end -->
					
					<div class="form-group">
						<label for="email">이메일</label> <input type="email"
							class="form-control" id="email" placeholder="이메일을 입력해주세요."
							value="${principal.user.email}" name="email" required>
						<div class="valid-feedback">완료 !</div>
						<div class="invalid-feedback">필수 입력 사항입니다.</div>
					</div>
					
				</div> <!-- password end -->
				<!-- partner info end ======== -->

				<div id="store-info" class="info-box">
					<p class="info-title">가게 정보를 입력해주세요 !</p>
					<p class="info">사업자 등록증 첨부</p>
					<div class="custom-file">
						<input type="file" class="custom-file-input" id="businessCard"
							required="required" name="businessCard"> <label
							class="custom-file-label" for="customFile">파일을 선택해주세요.</label>
						<div class="valid-feedback">완료 !</div>
						<div class="invalid-feedback">필수 입력 사항입니다.</div>
					</div>
					<div class="form-group">
						<label for="storeName" class="ma-bo">식당 상호명 </label> <input
							type="text" class="form-control" id="storeName"
							placeholder="식당 상호명을 입력해주세요." name="storeName" required>
						<div class="valid-feedback">완료 !</div>
						<div class="invalid-feedback">필수 입력 사항입니다.</div>
					</div>
					<!-- storeName end -->

					<div class="form-group " id="address-wrap">
						<label for="storename">주소</label>
						<div class="">
							<input type="text" id="postcode" placeholder="우편번호"
								class="form-control">
						</div>
						<input type="text" class="form-control" id="address"
							name="address" placeholder="주소" value="${principal.user.address}"><br>
						<input type="text" id="extraAddress" placeholder="참고항목"
							class="form-control mb-3" value="${principal.user.extraAddress}">
						<input class="form-control mb-4" type="text" id="detailAddress"
							name="detailAddress" placeholder="상세주소"
							value="${principal.user.detailAddress}"> <input
							type="button" style="width: 15vh" onclick="daumPostcode()"
							class="form-control btn btn-danger" value="주소 찾기" id="find--btn">
					</div>
					<!-- address end -->

					<div class="form-group">
						<label for="mainNumber">식당 대표 전화번호</label> <input type="text"
							class="form-control" id="mainNumber"
							placeholder="식당 대표 전화번호를 입력해주세요." name="mainNumber" required>
						<div class="valid-feedback">완료 !</div>
						<div class="invalid-feedback">필수 입력 사항입니다.</div>
					</div>
					<!-- mainNumber end -->
				</div>
				<!-- store_info ======== -->
				<button type="submit" class="btn btn-primary" id="">파트너
					신청하기</button>
			</form>
			
		<!-- <a href="/auth/partner/main_page"></a> -->	
		</c:otherwise>
	</c:choose>

</section>

<script type="text/javascript" src="/js/partner.js"></script>

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
<%@ include file="../layout/footer.jsp"%>