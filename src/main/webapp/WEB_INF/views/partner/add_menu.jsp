<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/partner_header.jsp"%>
<section id="store-apply">
	<form action="" class="was-validated" id="store-info-bg">
		<input type="hidden" id="id" value="${partner.id}">
		<div id="store-info" class="info-box">
			<p class="info-title">메뉴 정보를 입력해주세요 !</p>

			<div class="form-group">
				<label for="menuName">메뉴명</label> <input type="text"
					class="form-control" id="menuName" placeholder="메뉴 이름을 입력해주세요."
					name="menuName" required>
				<div class="valid-feedback">완료 !</div>
				<div class="invalid-feedback">필수 입력 사항입니다.</div>
			</div>
			<div class="form-group">
				<label for="menuPrice">메뉴가격</label> <input type="text"
					class="form-control" id="menuPrice" placeholder="메뉴 가격을 입력해주세요."
					name="menuPrice" required>
				<div class="valid-feedback">완료 !</div>
				<div class="invalid-feedback">필수 입력 사항입니다.</div>
			</div>
		</div>
		<button type="button"
			class="btn btn-primary d-flex justify-content-center"
			id="add-menu-btn">메뉴 추가 등록</button>
		<button type="button"
			class="btn btn-primary d-flex justify-content-center"
			id="add-store-menu-btn" >가게 등록하기</button>
	</form>


</section>

<script type="text/javascript" src="/js/partner.js"></script>
<%@ include file="../layout/footer.jsp"%>
