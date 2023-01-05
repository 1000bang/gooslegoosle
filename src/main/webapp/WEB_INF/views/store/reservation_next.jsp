<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<br />
<br />

<div class="container" style="min-height: 630px">
	<form action="" method="">
		<h2>예약자 정보</h2>
		<div hidden="true" id=userid>${principal.user.id}</div>
		<input hidden="true" id=storeId type="text" value="${storeDetail.id}" />
		<div class="form-group">
			<input type="text" class="form-control" placeholder="Enter usernmae" id="username"
				value="${principal.user.username}" readonly="readonly">

		</div>

		<div class="form-group">
			<input type="text" class="form-control mr-1 "
				placeholder="Enter phoneNumber" id="phoneNumber" name="phoneNumber"
				value="010-9411-0807" readonly="readonly">
		</div>
		<br /> <br />
		<h2>예약 정보</h2>

		<div class="form-group">
			<label>가게명 </label><input type="text" class="form-control mr-1 " id="storeName"
				value="${reservationDetail.store.partner.storeName}" readonly="readonly">
		</div>

		<div class="form-group">
			<label>예약금 </label> <input type="text" class="form-control mr-1 "
				id="deposit" value="20000원 " readonly="readonly">
		</div>

		<div class="form-group">

			<label>인원수 </label><input type="text" class="form-control" placeholder="" id="headCount"
				value="${reservationDetail.headCount}" readonly="readonly">
		</div>

		<div class="form-group">
			<label>예약 날짜 </label><input type="text" class="form-control" placeholder="" id="date"
				value="${reservationDetail.date}" readonly="readonly">
		</div>

		<div class="form-group">
			<label>예약 시간 </label><input type="text" class="form-control" placeholder="" id="time"
				value="${reservationDetail.time}" readonly="readonly">

		</div>

		<div class="form-group">
			<input type="text" class="form-control" placeholder=""
				value="?? : ???" readonly="readonly">
		</div>
		<br /> <br />
	</form>
	<div class="input-group justify-content-center">
<button id="back" class="btn" onclick="history.back();" style="background-color: #63BFBC; color: white; border-radius: 50px; width: 121px; height: 50px; margin-top: 8px; font-weight: 600">돌아가기</button>
		<button type="button" class="btn" id="kakao-Pay"
			style="width: 15vh;"><img alt="" src="/images/kakao-pay.png">
		</button>
	</div>

	<br /> <br>
</div>

<script type="text/javascript" src="/js/reservation.js"></script>
<%@ include file="../layout/footer.jsp"%>

