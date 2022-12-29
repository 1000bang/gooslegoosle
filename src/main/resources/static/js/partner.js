
let index = {
	init: function() {

		$("#partner-join-btn").bind("click", () => {
			this.applyPartner();
		});

		$("#partner-btn").bind("click", () => {
			this.applyStore();
		});
		
		$("#apply-store-btn").bind("click", () => {
			this.applyMenu();
		});

	},

	applyPartner: function() {

		let id = $("#id").val();

		let data = {

			username: $("#username").val(),
			email: $("#email").val(),
			phoneNumber: $("#phoneNumber").val(),
			password: $("#password").val(),
			storeName: $("#storeName").val(),
			address: $("#address").val(),
			mainNumber: $("#mainNumber").val(),
		}

		$.ajax({
			type: "POST",
			url: `/api/partner/${id}`,
			data: JSON.stringify(data),
			contentType: "application/json; charset=UTF-8",
			dataType: "json"

		}).done(function(data, textStatus, xhr) {

			if (data.httpStatus == "OK") {
				alert("신청이 완료되었습니다.");
				location.href = "/auth/partner/main_partner";
			}

		}).fail(function(error) {
			alert("실패" + error);
			console.log(error.responseJSON.message);
		});
	},

	applyStore: function() {
		
		let id = $("#id").val();

		let data = {

			storeName: $("#storeName").val(),
			category: $("#category_select").val(),
			openTime: $("#openTime").val(),
			closeTime: $("#closeTime").val(),
			breakTime: $("#breakTime").val(),
		};
		
		console.log(data);

		$.ajax({
			type: "POST",
			url: `/api/partner/apply_store/${id}`,
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(data, textStatus, xhr) {
			if (data.httpStatus == "OK") {
				alert("가게등록 완료");
				location.href = `/auth/partner/apply_menu/${id}`;
			}

		}).fail(function(error) {
			console.log(error);
			alert("가게등록실패" + error);
		});

	},
	
	applyMenu: function() {
		
		let id = $("#id").val();

		let data = {

			menuName: $("#menuname").val(),
			menuPrice: $("#menuprice").val(),
		};
		
		console.log(data);

		$.ajax({
			type: "POST",
			url: `/api/partner/apply_menu/${id}`,
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(data, textStatus, xhr) {
			if (data.httpStatus == "OK") {
				alert("메뉴 등록 완료");
				location.href = "/";
			}

		}).fail(function(error) {
			console.log(error);
			alert("메뉴 등록 실패" + error);
		});

	},

}

index.init();











