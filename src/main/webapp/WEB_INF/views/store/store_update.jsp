<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/partner_header.jsp"%>


<br />
<br />
<div class="container">

	<div class="mb-4">
		<h2 class="h2">가게 정보 수정</h2>
	</div>

	<form action="">

		<input hidden="true" id="partnerId" value="${partner.id}">
		<div class="form-group">
			<label for="storeName">가게이름 :</label> <input type="text"
				class="form-control" id="storeName" value="${partner.storeName}">
		</div>

		<div class="form-group">
			<label for="mainNumber">대표 번호 :</label> <input type="text"
				class="form-control" id="mainNumber" value="${partner.mainNumber}">
		</div>
		<div class="form-group">
		<label for="address">주소 :</label>
			<div class="d-flex mb-1">
			
				<input type="text" id="postcode" placeholder="우편번호"
					class="form-control mr-1" value=""> <input type="button"
					style="width: 15vh; color: white; background-color: #63BFBC;"
					onclick="daumPostcode()" class="form-control mr-1 btn"
					value="우편번호 찾기">
			</div>

			<br> <input type="text" class="form-control" id="address"
				placeholder="주소" value="${partner.address}"><br> <input
				type="text" id="extraAddress" placeholder="참고항목"
				class="form-control mb-3" value=""> <input
				class="form-control mb-4" type="text" id="detailAddress"
				placeholder="상세주소" value="${partner.detailAddress}">
		</div>

		<div class="form-group">
			<label for="username">카테고리 :</label> <select class="form-control"
				id="category_select" name="category">
				<option value="KOREAN" id="01">한식</option>
				<option value="JAPANESE" id="02">일식</option>
				<option value="CHINESE" id="03">중식</option>
				<option value="WESTERN" id="04">양식</option>
				<option value="">카페</option>
			</select>
		</div>

		<div class="form-group">
			<label for="openTime">오픈 시간 :</label> <input type="text"
				class="form-control" id="openTime" value="${store.openTime}">
		</div>

		<div class="form-group">
			<label for="closeTime">마감 시간 :</label> <input type="text"
				class="form-control" id="closeTime" value="${store.closeTime}">
		</div>

		<div class="form-group">
			<label for="breakTime">쉬는 시간 :</label> <input type="text"
				class="form-control" id="breakTime" value="${store.breakTime}">
		</div>


		<br />


		<div class="input-group justify-content-center">

			<button type="button" class="btn" id="store--update"
				style="width: 15vh; color: white; background-color: #63BFBC;">수정
			</button>
		</div>


		<hr />
		<h3 class="h3">메뉴 정보 수정</h3>
		<br />
		<c:forEach var="item" items="${store.menu}">
			<div class="form-group">
				<label for="phoneNumber">메뉴이름 </label> <input type="text"
					class="form-control" id="menuName" value="${item.menuName}">
			</div>

			<div class="form-group">
				<label for="phoneNumber">메뉴가격</label> <input type="text"
					class="form-control" id="menuPrice" value="${item.menuPrice}">
			</div>
			<div class="input-group justify-content-center">

				<button type="button" class="btn m-2"
					onclick="index.menuUpdate(${item.id})"
					style="width: 15vh; color: white; background-color: #63BFBC;">수정
				</button>
				<button type="button" class="btn m-2"
					onclick="index.menuDelete(${item.id})"
					style="width: 15vh; color: white; background-color: #63BFBC;">삭제
				</button>
			</div>
			<hr />
		</c:forEach>
		<br />
	</form>
</div>
<br />
<br />
<br />


<script type="text/javascript" src="/js/partner.js"></script>


<%@ include file="../layout/footer.jsp"%>

