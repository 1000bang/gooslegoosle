let token = $("meta[name='_csrf']").attr("content");
let csrfHeader = $("meta[name='_csrf_header']").attr("content");

let index = {
	init: function() {
		$('#kakao-Pay').bind("click", () => {
			this.kakaoPay();
		});
	},

	kakaoPay: function() {
		let data = {
			storeName: $('#storeName').val(),
			username: $('#username').val(),
			headCount: $('#headCount').val(),
			date: $('#date').val(),
			time: $('#time').val(),
			deposit: $('#deposit').val(),
			request: $('#request').val()
		};
		console.log("request : " + request)

		$.ajax({
			beforeSend : function(xhr){
				xhr.setRequestHeader(csrfHeader, token);
			},
			
			type: 'post',
			url: '/pay/ready',
			data: JSON.stringify(data),
			contentType: 'application/json; charset=utf-8',
			dataType: 'json'
		}).done(function(data, textStatus, xhr) {
			console.log(data.request);
			if (data.httpStatus == 'OK') {
				console.log("ok!!!s")
				console.log(data.body.next_redirect_pc_url)
				alert('결제 페이지로 이동');
				location.href = data.body.next_redirect_pc_url;
			};
		}).fail(function(error) {
			console.log(error.responseJSON.error);
			alert("글쓰기 실패  " + error.responseJSON.error)
		});
	},
	approve: function() {
		var resId = [];
		$("input[name=resId]:checked").each(function() {
			var chk = $(this).val();
			resId.push(chk);
		})

		var data = {

			id: resId
		};

		$.ajax({
			beforeSend : function(xhr){
				xhr.setRequestHeader(csrfHeader, token);
			},
			
			type: 'post',
			url: '/reservation/approve',
			data: JSON.stringify(data),
			contentType: 'application/json; charset=utf-8',
			dataType: 'json'
		}).done(function(data, textStatus, xhr) {
			if (data.httpStatus == 'OK') {
				alert("승인 성공")
				location.reload();
			}
		}).fail(function(error) {
			alert("승인 실패  " + error.responseJSON.error)
		});
	},


	deny: function() {
		var resId = [];
		$("input[name=resId]:checked").each(function() {
			var chk = $(this).val();
			resId.push(chk);
		})

		var data = {
			 
			id : resId      
		};

		$.ajax({
			beforeSend : function(xhr){
				xhr.setRequestHeader(csrfHeader, token);
			},
			
			type: 'post',
			url: '/reservation/deny',
			data: JSON.stringify(data),
			contentType: 'application/json; charset=utf-8',
			dataType: 'json'
		}).done(function(data, textStatus, xhr) {
			if (data.httpStatus == 'OK') {
				alert("거절 성공")
				location.reload();
			}
		}).fail(function(error) {
			alert("거절 실패  " + error.responseJSON.error)
		});
	},

}

index.init();
