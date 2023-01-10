let index = {

	init: function(){
		$("#btn--save").bind("click", () => {
			this.save();
		});
		$("#btn--update").bind("click", () => {
			this.update();
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
			type : "POST",
			url : "/auth/joinProc", //post를 이 주소로 보낸
			data : JSON.stringify(data), //http 메세지 body영역에 들어감 
			contentType : "application/json; charset=utf-8", //보낼 때 데이터 타입
			dataType: "json" // 응답이 왔을 때 mime type 지정
						
		}).done(function(data, textStatus, xhr ){
			alert("회원가입성공 ")
			location.href = "/"; // 성공하면 루트컨텍스트로 가
		}).fail(function(error){
			console.log(error);
			alert("회원가입실패" + error.responseJSON.message);
		});
	
	},
	update: function(){
		let data = {
			id : $("#id").val(),
			username : $("#username").val(),
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
			data : JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(data, textStatus, xhr){
			if(data.httpStatus == "OK"){
				alert("회원정보 수정 성공");
				location.href = "/"; 
			}
		}).fail(function(error){
			alert("회원정보 수정 실패 " + error.responseJSON.message);
		});
		
	}

}

index.init();