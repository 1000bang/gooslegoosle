<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<br />
<br />

<div class="container" style="min-height: 630px">
	<div class="container" style="min-height: 630px">
		<form action="" method="">
			<div hidden="true" id=userid>${principal.user.id}</div>
			<input hidden="true" id=storeId type="text" value="${storeDetail.id}" />
			
			<h2 style="text-align: center; margin-bottom: 1.5rem; font-weight: 900;">상세 내역</h2>
			<div class="form-group">
			<label style="font-size: 19px; font-weight: 700;">사용자명 </label>
				<input type="text" class="form-control" placeholder="Enter usernmae"
					id="username" value="${principal.user.username}"
					readonly="readonly">

			</div>

			<div class="form-group">
				<label style="font-size: 19px; font-weight: 700;">가맹점명 </label><input type="text" class="form-control mr-1 "
					id="storeName" value="${reservationDetail.store.partner.storeName}"
					readonly="readonly">
			</div>

			<div class="form-group">
				<label style="font-size: 19px; font-weight: 700;">예약 날짜 </label><input type="text" class="form-control"
					placeholder="" id="date" value="${reservationDetail.date}"
					readonly="readonly">
			</div>

			<div class="form-group">
				<label style="font-size: 19px; font-weight: 700;">예약 시간 </label><input type="text" class="form-control"
					placeholder="" id="time" value="${reservationDetail.time}"
					readonly="readonly">

			</div>

			<div class="form-group">
				<label style="font-size: 19px; font-weight: 700;">결제 일시 </label><input type="text" class="form-control mr-1 "
					id="time" value="${response.body.additionalProperties.approved_at}"
					readonly="readonly">
			</div>

			<div class="form-group">
				<label style="font-size: 19px; font-weight: 700;">결제 방법 </label><input type="text" class="form-control"
					placeholder="" id="headCount"
					value="${response.body.additionalProperties.payment_method_type}"
					readonly="readonly">
			</div>

			<div class="form-group">
				<label style="font-size: 19px; font-weight: 700;">요청 사항 </label><input type="text" class="form-control"
					placeholder="" value="${reservationDetail.request}"
					readonly="readonly">
			</div>
			<div class="form-group">
				<label style="font-size: 19px; font-weight: 700;">결제요금 </label> <input type="text" class="form-control mr-1 "
					id="deposit" value="20000원 " readonly="readonly">
			</div>
		</form>

		<br /> <br>
	</div>
	<div class="input-group justify-content-center">
		<button id="back" class="btn"
			style="background-color: #63BFBC; color: white; border-radius: 50px; width: 121px; height: 50px; margin-top: -32px; font-weight: 600; margin-bottom: 32px;">
			<a href="/">홈으로 가기</a>
		</button>

	</div>

</div>

<script type="text/javascript" src="/js/reservation.js"></script>
<%@ include file="../layout/footer.jsp"%>

