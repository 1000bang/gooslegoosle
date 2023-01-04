<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/partner_header.jsp"%>
<section id="store-apply">
	<form action="/partner/add_store/${partner.id}" class="was-validated"
		id="store-info-bg" method="post" enctype="multipart/form-data">
		<input type="hidden" id="storeId" value="${partner.id}">
		<div id="store-info" class="info-box">
			<p class="info-title">가게 영업 정보를 입력해주세요 !</p>
			<div class="form-group">
				<label for="storeName">가게 상호명</label> <input type="text"
					class="form-control" id="storeName" placeholder="가게 상호명을 입력해주세요."
					name="storeName" required>
				<div class="valid-feedback">완료 !</div>
				<div class="invalid-feedback">필수 입력 사항입니다.</div>
			</div>
			<!-- storeName end -->
			<p class="info">사업장 사진</p>
			<div class="custom-file">
				<input type="file" multiple="multiple" class="custom-file-input"
					id="storePics" required="required" name="storePics"> <label
					class="custom-file-label" for="customFile">파일을 선택해주세요.</label>
				<div class="valid-feedback">완료 !</div>
				<div class="invalid-feedback">필수 입력 사항입니다.</div>
			</div>
			<div class="form-group">
				<label for="category">카테고리</label> <select class="form-control"
					id="category_select" name="category">
					<option value="KOREAN" id="01">한식</option>
					<option value="JAPANESE" id="02">일식</option>
					<option value="CHINESE" id="03">중식</option>
					<option value="WESTERN" id="04">양식</option>
					<option value="">카페</option>
				</select>
			</div>
			<!-- category end -->

			<div class="form-group" id="store-item">
				<p class="time">가게 영업시간</p>

				<div class="time-form-wrap">
					<input type="text" class="form-control" id="openTime"
						placeholder="openTime" name="openTime" required>
					<div class="valid-feedback">완료 !</div>
					<div class="invalid-feedback">필수 입력 사항입니다.</div>
				</div>
				<!-- openTime end -->

				<div class="time-form-wrap">
					<input type="text" class="form-control" id="closeTime"
						placeholder="closeTime" name="closeTime" required>
					<div class="valid-feedback">완료 !</div>
					<div class="invalid-feedback">필수 입력 사항입니다.</div>
				</div>
				<!-- closeTime end -->

				<div class="time-form-wrap">
					<input type="text" class="form-control" id="breakTime"
						placeholder="breakTime" name="breakTime">
				</div>
				<!-- breakTime end -->

			</div>

			<div class="form-group">
				<label for="mainNumber" id="main">가게 대표 전화</label> <input
					type="text" class="form-control" id="mainNumber"
					placeholder="가게 대표 전화를 입력해주세요." name="mainNumber" required>
				<div class="valid-feedback">완료 !</div>
				<div class="invalid-feedback">필수 입력 사항입니다.</div>
			</div>
			
		</div>
		<button type="submit" class="btn"
			style="color: white; background-color: #63BFBC; float: right">다음
			(메뉴 등록)</button>
		<br /> <br />
	</form>
</section>


<%@ include file="../layout/footer.jsp"%>
