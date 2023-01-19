let token = $("meta[name='_csrf']").attr("content");
let csrfHeader = $("meta[name='_csrf_header']").attr("content");

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
		$("#searchId").bind("click", () => {
			this.search();
		});
		$("#searchPw").bind("click", () => {
			this.searchPw();
		});




	},

	sendMes: function() {
		let phoneNumber = $('#phoneNumber').val();
		Swal.fire('인증번호 발송 완료!');

		$.ajax({
			beforeSend: function(xhr) {
				xhr.setRequestHeader(csrfHeader, token);
			},

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
						footer: '<a href="/">다음에 가입하기</a>'
					})
				}
			});

		}).fail(function(error) {
			console.log(error.responseJSON.message);
			alert("회원가입실패" + error.responseJSON.message);
		});




	},


	save: function() {

		if ($("#confirmMsg").text() == '비밀번호 일치' && $("#authCode").val() != null) {
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
				beforeSend: function(xhr) {
					xhr.setRequestHeader(csrfHeader, token);
				},

				type: "POST",
				url: "/auth/joinProc", //post를 이 주소로 보낸
				data: JSON.stringify(data), //http 메세지 body영역에 들어감 
				contentType: "application/json; charset=utf-8", //보낼 때 데이터 타입
				dataType: "json" // 응답이 왔을 때 mime type 지정

			}).done(function(data, textStatus, xhr) {
				Swal.fire({
					icon: 'success',
                    title: '회원가입 성공 ',
                    text: '축하합니다 구슬구슬 회원가입에 성공하셨습니다.',
                    confirmButtonColor : "#63BFBC",
                    confirmButtonText : "확인"
                    
				}).then((result) => {
                    if (result.isConfirmed) {
						location.href = "/"; // 성공하면 루트컨텍스트로 가
						};
				});
			}).fail(function(error) {
				console.log(error.responseJSON);
				Swal.fire({
				icon: 'error',
				title: '작성오류',
				text: error.responseJSON,
			})
			});
		} else {
			Swal.fire({
				icon: 'error',
				title: '인증오류',
				text: '인증절차가 진행되지 않았습니다.',
				footer: '<a href="/">다음에 가입하기</a>'
			})
		}

	},
	update: function() {
		let data = {
			id: $("#id").val(),
			userNickname: $("#userNickname").val(),
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
			beforeSend: function(xhr) {
				xhr.setRequestHeader(csrfHeader, token);
			},

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

	},
	search: function() {
		let data = {
			email: $("#email").val()
		}

		console.log(data);
		$.ajax({
			beforeSend: function(xhr) {
				xhr.setRequestHeader(csrfHeader, token);
			},
			type: "POST",
			url: "/auth/find",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(data, textStatus, xhr) {
			if (data.httpStatus == "OK") {
				Swal.fire({
                    icon: 'success',
                    text: "아이디 : " + data.body,
                });
			}
		}).fail(function(error) {
				Swal.fire({
                    icon: 'fail',
                    text: "입력된 이메일이 없습니다. ",
                });
		});

	},
	searchPw: function() {
		let data = {
			username : $("#username").val(),
			email: $("#email1").val(),
		}

		console.log(data);
		$.ajax({
			beforeSend: function(xhr) {
				xhr.setRequestHeader(csrfHeader, token);
			},
			type: "POST",
			url: "/auth/findPw",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(data, textStatus, xhr) {
			if (data.httpStatus == "OK") {
				Swal.fire({
                    icon: 'success',
                    text: `이메일로 임시 비밀번호를 보냈습니다.`,
                });
			}
		}).fail(function(error) {
			alert(data.body)
				Swal.fire({
                    icon: 'fail',
                    text: `입력된 이메일이 없습니다.`,
                });
		});

	}

}

index.init();