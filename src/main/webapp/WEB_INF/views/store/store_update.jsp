<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>


<br />
<br />
<div class="container">

	<div class="mb-4">
		<h2 class="h2">가게 정보 수정</h2>
	</div>

	<form action="">

		<div class="form-group">
			<label for="username">가게이름 :</label> <input type="text"
				class="form-control" id="username" value="${partner.storeName}"
				>
		</div>

		<div class="form-group">
			<label for="username">대표 번호 :</label> <input type="text"
				class="form-control" id="username" value="${partner.mainNumber}"
				>
		</div>
		<div class="form-group">
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
		<br />
		<div class="input-group justify-content-center">

			<button type="button" class="btn"
				style="width: 15vh; color: white; background-color: #63BFBC;">수정
			</button>
		</div>


		<hr />
		<h3 class="h3">메뉴 정보 수정</h3>
		<br />
		<c:forEach var="item" items="${store.menu}">
			<div class="form-group">
				<label for="phoneNumber">메뉴이름 </label> <input type="text"
					class="form-control" id="phoneNumber" value="${item.menuName}">
			</div>

			<div class="form-group">
				<label for="phoneNumber">메뉴가격</label> <input type="text"
					class="form-control" id="phoneNumber" value="${item.menuPrice}">
			</div>
			<hr />
		</c:forEach>
		<br />
		<div class="input-group justify-content-center">

			<button type="button" class="btn"
				style="width: 15vh; color: white; background-color: #63BFBC;">수정
			</button>
		</div>
	</form>
</div>
<br />
<br />
<br />




<%@ include file="../layout/footer.jsp"%>

