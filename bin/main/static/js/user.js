let index = {

	init: function() {
		$("#btn--save").bind("click", () => {
			this.save();
		});
		$("#btn--update").bind("click", () => {
			this.update();
		});
		$("#btn--send").bind("click", () => {
			this.sendMes();
		});



	},

	sendMes: function() {
		let phoneNumber = $('#phoneNumber').val();
		Swal.fire('인증번호 발송 완료!');

		$.ajax({
			type: "GET",
			url: "/auth/check",
			data: {
				"phoneNumber": phoneNumber
			}

		}).done(function(data, textStatus, xhr) {
			$('#checkBtn').click(function() {
				if ($.trim(data) == $('#authCode').val()) {
					Swal.fire(
						'인증성공!',
						'휴대폰 인증이 정상적으로 완료되었습니다.',
						'success'
					);
					$('#phoneNumber').prop('readonly', true);
					$('#authCode').prop('readonly', true);
				} else {
					Swal.fire({
						icon: 'error',
						title: '인증오류',
						text: '인증번호가 올바르지 않습니다!',
						footer: '<a href="/">다음에 인증하기</a>'
					})
				}
			});

		}).fail(function(error) {
			console.log(error.responseJSON.message);
			alert("회원가입실패" + error.responseJSON.message);
		});




	},


	save: function() {
		let data = {
			username: $("#username").val(),
			userNickname: $("#userNickname").val(),
			password: $("#password").val(),
			email: $("#email").val(),
			phoneNumber: $("#phoneNumber").val(),
			address: $("#address").val(),
			postCode: $("#postcode").val(),
			extraAddress: $("#extraAddress").val(),
			detailAddress: $("#detailAddress").val(),

		};

		$.ajax({
			type: "POST",
			url: "/auth/joinProc", //post를 이 주소로 보낸
			data: JSON.stringify(data), //http 메세지 body영역에 들어감 
			contentType: "application/json; charset=utf-8", //보낼 때 데이터 타입
			dataType: "json" // 응답이 왔을 때 mime type 지정

		}).done(function(data, textStatus, xhr) {
			alert("회원가입성공 ")
			location.href = "/"; // 성공하면 루트컨텍스트로 가
		}).fail(function(error) {
			console.log(error.responseJSON.message);
			alert("회원가입실패" + error.responseJSON.message);
		});

	},
	update: function() {
		let data = {
			id: $("#id").val(),
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val(),
			phoneNumber: $("#phoneNumber").val(),
			address: $("#address").val(),
			postCode: $("#postcode").val(),
			extraAddress: $("#extraAddress").val(),
			detailAddress: $("#detailAddress").val(),
		}


		$.ajax({
			type: "PUT",
			url: "/api/user",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(data, textStatus, xhr) {
			if (data.httpStatus == "OK") {
				alert("회원정보 수정 성공");
				location.href = "/";
			}
		}).fail(function(error) {
			alert("회원정보 수정 실패 " + error.responseJSON.message);
		});

	}

}

index.init();