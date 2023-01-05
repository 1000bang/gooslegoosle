
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

		$("#add-store-menu-btn").bind("click", () => {
			this.addStoreMenu();
		});
		$("#store--update").bind("click", () => {
			this.storeUpdate();
		});


	},

	storeUpdate : function(){
		var id = $("#partnerId").val();
		
		var data = {	
			storeName: $("#storeName").val(),
			mainNumber: $("#mainNumber").val(),
			address : $("#address").val(),
			detailAddress : $("#detailAddress").val(),
			category: $("#category_select").val(),
			openTime: $("#openTime").val(),
			closeTime: $("#closeTime").val(),
			breakTime: $("#breakTime").val(),
			
		};
		$.ajax({
			type: "POST",
			url: `/store/update/${id}`,
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(data, textStatus, xhr) {
			if (data.httpStatus == "OK") {
				alert("수정 완료");
				location.reload();
			}

		}).fail(function(error) {
			console.log(error);
			alert("수정실패" + error);
		});
		
		
		
		
	},

	addPartner: function() {

		var form = $('#uploadForm')[0];

		var formData = new FormData(form);

		$.ajax({
			type: "POST",
			url: `/api/partner/${id}`,
			data: formDate,
			dataType: 'json',
			processData: false,
			contentType: false,
			enctype: 'multipart/form-data',

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
		console.log("===========" + id);

		$.ajax({
			type: "POST",
			url: `/api/partner/add_store/${id}`,
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(data, textStatus, xhr) {
			if (data.httpStatus == "OK") {
				alert("가게등록 완료");
				location.href = `/partner/addMenu/${id}`;
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
		console.log(id);
		console.log(data);
		$.ajax({
			type: "POST",
			url: `/partner/add_menu/${id}`,
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(data, textStatus, xhr) {

			if (data.httpStatus == "OK") {
				addMenuData(data.body);
			}

		}).fail(function(error) {
			console.log(error);
			alert("메뉴 등록 실패" + error.responseJSON.message);
		});

	},

	addMenu: function() {
		let id = $("#id").val();

		let data = {

			menuName: $("#menuName").val(),
			menuPrice: $("#menuPrice").val(),
		};
		console.log(id);
		console.log(data);
		$.ajax({
			type: "POST",
			url: `/partner/add_menu/${id}/done`,
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
			alert("메뉴 등록 실패" + error.responseJSON.message);
		});


	},

	menuDelete: function(menuId) {
		$.ajax({
			type: "DELETE",
			url: `/menu/delete/${menuId}`,
			dataType: "json"
		}).done(function(resData) {
			if (resData.httpStatus == "OK") {
				alert("삭제 완료");			
				location.reload();
			}
		}).fail(function(error) {
			console.log(error)
			alert("삭제 실패하였습니다. ");
		});

	},
	
		menuUpdate: function(menuId) {
		let menuData = {
			menuName: $("#menuName").val(),
			menuPrice: $("#menuPrice").val(),
		}
		$.ajax({
			type: "put",
			url: `/menu/update/${menuId}`,
			data: JSON.stringify(menuData),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resData) {
			if (resData.httpStatus == "OK") {
				alert("수정 완료 되었습니다. ");
				
			}
		}).fail(function(error) {
			alert("수정 실패하였습니다. ");
		});
	

	},


}
function addMenuData(menu) {

	let childElement = `
				<br/>
				<div class="form-group card">
			
				<div class="d-flex justify-content-between align-items-center">
					<div> &nbsp;•&nbsp;
					<a class="card-text m-3">${menu.menuName} </a> ——
					<a class="card-text m-3">${menu.menuPrice}</a>원 
					</div>
				</div>
				</div>
`

	$("#menu--box").prepend(childElement);

	$("#menuName").val("");
	$("#menuPrice").val("");

}


index.init();











