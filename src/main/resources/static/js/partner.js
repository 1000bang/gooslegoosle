
let index = {
	init: function() {

		$("#btn-partner-join").bind("click", () => {
			this.join();
		});

	},

	join: function() {

		let data = {
			username: $("#username").val(),
			phoneNumber: $("#phonenumber").val(),
			email: $("#email").val(),
			password: $("#password").val(),
			stroename: $("#storename").val(),
			address: $("#address").val(),
			mainnumber: $("#mainnumber").val(),
		}

		$.ajax({
			type: "POST",
			url: "/auth/partner",
			data: JSON.stringify(data),
			contentType: "application/json; charset=UTF-8",
			dataType: "json"

		}).done(function(data, textStatus, xhr){
			
			if(data.status == "OK"){
				alert("신청이 완료되었습니다.");
				location.href = "/";
			}
			
		}).fail(function(error){
			alert("실패" + error);
			console.log(error);
		});
	}


}

index.init();











