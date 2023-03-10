<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/partner_header.jsp"%>
<section id="store-apply" style="height: 108%;">
	<form action="/partner/add_store/${partner.id}" class="was-validated"
		id="store-info-bg" method="post" enctype="multipart/form-data">
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token}">
		<input type="hidden" id="storeId" value="${partner.id}">
		<div id="store-info" class="info-box">
			<p class="info-title">가게 영업 정보를 입력해주세요 !</p>
			<div class="form-group">
				<label for="storeName">가게 상호명</label> <input type="text"
					class="form-control" id="storeName" placeholder="가게 상호명을 입력해주세요."
					name="storeName" value="${partner.storeName}" required>
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

<footer id="footer" style="position: absolute;
    top: 113%;">
	<div class="footer-line">
		<div id="endLogo">
			<a href=""><img src="/images/logo2.png" alt=""></a>
		</div>
		<div id="endAbout">
			<ul class="aboutUl">
				<li><a href="#">이용약관&nbsp;&nbsp; </a></li>
				<li><a href="#">이메일주소 무단수집거부&nbsp;&nbsp; </a></li>
				<li><a href="#">개인정보처리방침&nbsp;&nbsp; </a></li>
			</ul>
			<div class="address">
				<address>서울특별시 성동구 고산자로 130 4층(응봉동,지오빌딩) 대표전화 :
					02-2282-2022 이메일 : tjdqls2s@naver.com</address>
			</div>
		</div>
		<div id="endSNS">
		<!-- 손 이미지 -->
			<img src="/images/sns.png" alt="">
			<div>
				<p>Click ↓</p>
				<a class="instagram" href="https://www.instagram.com/bin__starr/" style="display: block">
					<img src="/images/insta.png" alt="" >
				</a>
			</div>
		</div>
	</div>
</footer>
<script>
$("#storePics").on(
		"change",
		  function() {
			$(this).siblings(".custom-file-label").addClass("selected")
			.html("");
			
			
			 var files=$('input[name="storePics"]')[0].files;
			console.log(files);
			
			
			for (i = 0; i < files.length; i++) {
				$(this).siblings(".custom-file-label").addClass("selected")
				.append(files[i].name);
				} 

		});
</script>
</div>
</body>
</html>

