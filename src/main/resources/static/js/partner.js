
let index = {
	init: function() {

		$("#add-partner-btn").bind("click", () => {
			this.addPartner();
		});

		$("#add-store-btn").bind("click", () => {
			this.addStore();
		});
		
		$("#add-menu-btn").bind("click", () => {
			this.addMenu();
		});
		
		$("#add-store-menu-btn").bind("click", () =>{
			this.addStoreMenu();
		});

	},

	addPartner: function() {

		var form = $('#uploadForm')[0];
	
    	var formData = new FormData(form);

		$.ajax({
			type: "POST",
			url: `/api/partner/${id}`,
			data: formDate,
			dataType:'json',
    		processData:false,
    		contentType:false,
			enctype:'multipart/form-data',

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

	addStore: function() {
		
		let id = $("#storeId").val();

		let data = {

			storeName: $("#storeName").val(),
			category: $("#category_select").val(),
			openTime: $("#openTime").val(),
			closeTime: $("#closeTime").val(),
			breakTime: $("#breakTime").val(),
			mainNumber: $("#mainNumber").val(),
		};
		
		console.log(data);
		console.log("==========="+id);

		$.ajax({
			type: "POST",
			url: `/api/partner/add_store/${id}`,
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(data, textStatus, xhr) {
			if (data.httpStatus == "OK") {
				alert("가게등록 완료");
				location.href = `/partner/add_menu/${id}`;
			}

		}).fail(function(error) {
			console.log(error);
			alert("가게등록실패" + error);
		});

	},
	
	addStoreMenu: function() {
		
		let id = $("#id").val();

		let data = {

			menuName: $("#menuName").val(),
			menuPrice: $("#menuPrice").val(),
		};

		$.ajax({
			type: "POST",
			url: `/api/partner/add_menu/${id}`,
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(data, textStatus, xhr) {
			
			if (data.httpStatus == "OK") {
				alert("메뉴 등록 완료");
				location.href = "/auth/partner/main_partner";
			}

		}).fail(function(error) {
			console.log(error);
			alert("메뉴 등록 실패" + error);
		});

	},

}

index.init();











