<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/partner_header.jsp"%>
<section id="partner-join">
	<form action="" class="was-validated">
		<div id="partner-info" class="info-box">
			<p class="info-title">사장님 정보를 입력해주세요 !</p>
			<div class="form-group">
				<label for="username">이름</label> <input type="text"
					class="form-control" id="username" placeholder="이름을 입력해주세요."
					name="username" required>
				<div class="valid-feedback">완료 !</div>
				<div class="invalid-feedback">필수 입력 사항입니다.</div>
			</div>
			<div class="form-group">
				<label for="phonenumber">휴대전화번호</label> <input type="text"
					class="form-control" id="phonenumber" placeholder="휴대전화번호를 입력해주세요."
					name="phonenumber" required>
				<div class="valid-feedback">완료 !</div>
				<div class="invalid-feedback">필수 입력 사항입니다.</div>
			</div>
			<div class="form-group">
				<label for="email">이메일</label> <input type="email"
					class="form-control" id="email" placeholder="이메일을 입력해주세요."
					name="email" required>
				<div class="valid-feedback">완료 !</div>
				<div class="invalid-feedback">필수 입력 사항입니다.</div>
			</div>
			<div class="form-group">
				<label for="password">비밀번호</label> <input type="password"
					class="form-control" id="password" placeholder="비밀번호를 입력해주세요."
					name="password" required>
				<div class="valid-feedback">완료 !</div>
				<div class="invalid-feedback">필수 입력 사항입니다.</div>
			</div>
		</div>
		<!-- partner info end ======== -->
		<div id="store-info" class="info-box">
			<p class="info-title">가게 정보를 입력해주세요 !</p>
			<p class="info">사업자 등록증 첨부</p>
			<div class="custom-file">
				<input type="file" class="custom-file-input" id="customFile"
					required="required" name="file"> <label
					class="custom-file-label" for="customFile">파일을 선택해주세요.</label>
				<div class="valid-feedback">완료 !</div>
				<div class="invalid-feedback">필수 입력 사항입니다.</div>
			</div>
			<div class="form-group">
				<label for="storename" class="ma-bo">식당 상호명 </label> <input
					type="text" class="form-control" id="storename"
					placeholder="식당 상호명을 입력해주세요." name="storename" required>
				<div class="valid-feedback">완료 !</div>
				<div class="invalid-feedback">필수 입력 사항입니다.</div>
			</div>
			<div class="form-group">
				<label for="address">식당 주소</label> <input type="text"
					class="form-control" id="main" placeholder="식당주소를 입력해주세요."
					name="address" required>
				<div class="valid-feedback">완료 !</div>
				<div class="invalid-feedback">필수 입력 사항입니다.</div>
			</div>
			<div class="form-group">
				<label for="mainnumber">식당 대표 전화번호</label> <input type="text"
					class="form-control" id="mainnumber"
					placeholder="식당 대표 전화번호를 입력해주세요." name="mainnumber" required>
				<div class="valid-feedback">완료 !</div>
				<div class="invalid-feedback">필수 입력 사항입니다.</div>
			</div>
		</div>
		<!-- store_info ======== -->
	</form>
	<button type="button"
		class="btn btn-primary d-flex justify-content-center" id="btn-partner-join">파트너
		신청하기</button>
</section>
<%@ include file="../layout/footer.jsp"%>