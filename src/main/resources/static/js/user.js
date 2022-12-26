let index = {

	init: function(){
		$("#btn--save").bind("click", () => {
			this.save();
		});

	},
	save: function() {
		let data = {
			username: $("#username").val(), 
			password: $("#password").val(),
			email: $("#email").val(),
			phoneNumber: $("#phoneNumber").val(),
			address: $("#address").val(),
		};

		$.ajax({
			type : "POST",
			url : "/auth/joinProc", //post를 이 주소로 보낸
			data : JSON.stringify(data), //http 메세지 body영역에 들어감 
			contentType : "application/json; charset=utf-8", //보낼 때 데이터 타입
			dataType: "json" // 응답이 왔을 때 mime type 지정
						
		}).done(function(data, textStatus, xhr ){
			alert("회원가성공 ")
			location.href = "/"; // 성공하면 루트컨텍스트로 가
		}).fail(function(error){
			console.log(error);
			alert("회원가입실패" + error.responseJSON.message);
		});
	
	}

}

index.init();