
let index = {
	init: function() {

		$("#btn-partner-join").bind("click", () => {
			this.applyPartner();
		});

	},

	applyPartner: function() {

		let data = {
			username: $("#username").val(),
			email: $("#email").val(),
			phoneNumber: $("#phonenumber").val(),
			password: $("#password").val(),
			storeName: $("#storename").val(),
			address: $("#address").val(),
			mainnumber: $("#mainnumber").val(),
		}

		$.ajax({
			type: "POST",
			url: "/api/partner",
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
			console.log(error.responseJSON.message);
		});
	},
	


}

index.init();











