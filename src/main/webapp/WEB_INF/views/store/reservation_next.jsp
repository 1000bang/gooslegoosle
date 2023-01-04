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
			<input type="text" class="form-control" placeholder="Enter usernmae"
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
			<input type="text" class="form-control mr-1 "
				value="${reservationDetail.store.partner.storeName}" readonly="readonly">
		</div>

		<div class="form-group">
			<label>예약금 </label> <input type="text" class="form-control mr-1 "
				id="deposit" value="20000원 " readonly="readonly">
		</div>

		<div class="form-group">

			<input type="text" class="form-control" placeholder=""
				value="인원수 : ${reservationDetail.headCount}" readonly="readonly">
		</div>

		<div class="form-group">
			<input type="text" class="form-control" placeholder=""
				value="예약 날짜 : ${reservationDetail.date}" readonly="readonly">
		</div>

		<div class="form-group">
			<input type="text" class="form-control" placeholder=""
				value="예약 시간 : ${reservationDetail.time}" readonly="readonly">

		</div>

		<div class="form-group">
			<input type="text" class="form-control" placeholder=""
				value="예약 시간 : ${reservationDetail.time}" readonly="readonly">
		</div>
		<br /> <br />
	</form>
	<div class="input-group justify-content-center">
<button id="back" class="btn" onclick="history.back();" style="background-color: #63BFBC; color: white; border-radius: 50px; width: 121px; height: 50px; margin-top: 8px; font-weight: 600">돌아가기</button>
		<button type="button" class="btn" onclick="reservation()"
			style="width: 15vh;"><img alt="" src="/images/kakao-pay.png">
		</button>
	</div>

	<br /> <br>
</div>

<script>
	function reservation() {
		let data = {
			request : $("#request").val(),
			date : $("#date").val(),
			time : $("#time").val(),
			headCount : $("#headCount").val(),
		};

		let store = $("#storeId").val();

		console.log(store);
		console.log(data);

		$.ajax({
			type : "POST",
			url : "/store/reservation/" + store + "/save",
			data : JSON.stringify(data),
			contentType : "application/json; charset = utf-8",
			dataType : "json"

		}).done(function(data, textStatus, xhr) {
			console.log(data);
			console.log(textStatus);
			console.log(xhr);
			if (data.httpStatus == "OK") {
				alert("예약 완료 ");
			}
			location.href = "/";
		}).fail(function(error) {
			console.log(error);
			alert("예약 실패  " + error.responseJSON.error)
		});

	}
</script>




<%@ include file="../layout/footer.jsp"%>

