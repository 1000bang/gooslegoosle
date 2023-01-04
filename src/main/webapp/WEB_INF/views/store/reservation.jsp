<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<br />
<br />

<div class="container" style="min-height: 630px">
	<form action="" method="">
		<h2>예약자 정보</h2>
		<div hidden="true" id=userid>${principal.user.id}</div>
		<input hidden="true" id=storeId type="text" value="${storeDetail.id}"/>
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
				value="${storeDetail.partner.storeName}" readonly="readonly">
		</div>

		<div class="form-group">
			<label>예약금 </label> <input type="text" class="form-control mr-1 "
				id="deposit" value="10000원 " readonly="readonly">
		</div>

		<div class="form-group">

			<select class="custom-select mb-1 form-control" id="headCount"
				name="headCount">
				<option selected>예약하실 인원을 선택하세요</option>
				<option value="1">1명</option>
				<option value="2">2명</option>
				<option value="3">3명</option>
				<option value="4">4명</option>
				<option value="5">5명</option>
			</select>
		</div>

		<div class="form-group">
			<label class="form-label" for="reservationDate">예약 날짜</label>
    <input class="form-control" id="date" pattern="\d{4}-\d{2}-\d{2}" placeholder="원하는 예약 날짜를 선택하세요"
           required th:field="*{date}" type="text" value="">
		</div>

		<div class="form-group">
			<select class="custom-select mb-1 form-control" id="time" name="time">
				<option selected>예약하실 시간을 선택하세요</option>
				<option value="18시">18시</option>
				<option value="18시30분">18시 30분</option>
				<option value="19시">19시</option>
				<option value="19시30분">19시30분</option>
				<option value="20시">20시</option>
			</select>

		</div>

		<div class="form-group">
			<input type="text" class="form-control mr-1 " id="request"
				name="request" value="" placeholder="요청사항을 입력하세요 ">
		</div>
		<br /> <br />
	</form>
	<div class="input-group justify-content-center">

		<button type="button" class="btn" onclick="reservation()"
			style="width: 15vh; color: white; background-color: #63BFBC;">예약하기
		</button>
	</div>

	<br /> <br>
</div>


<script>
var today, date;
today = new Date(new Date().getFullYear(), new Date().getMonth(), new Date().getDate());
fp.setDate(today);
date = $('#date').flatpickr({
	format : "yyyy-mm-dd",
	language: "english",
	startDate : '-3d',
	minDate: today
});
function reservation(){
	let data = {		
			request: $("#request").val(),
			date: $("#date").val(),
			time: $("#time").val(),
			headCount: $("#headCount").val(),
		};

	let store = $("#storeId").val();
	
	
	console.log(store);
	console.log(data);
	
		$.ajax({
			type: "POST",
			url: "/store/reservation/"+ store +"/save",
			data: JSON.stringify(data),
			contentType: "application/json; charset = utf-8",
			dataType: "json"
			
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

