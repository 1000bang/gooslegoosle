let index = {
	init:function(){
		$('#kakao-Pay').bind("click", () => {
			this.kakaoPay();
		});
	},
	
	kakaoPay : function(){
		let data = {
			storeName : $('#storeName').val(),
			username : $('#username').val(),
			headCount : $('#headCount').val(),
			date : $('#date').val(),
			time : $('#time').val(),
			deposit : $('#deposit').val()
		};
		console.log(data)
		
		$.ajax({
			type : 'post',
			url : '/pay/ready',
			data : JSON.stringify(data),
			contentType : 'application/json; charset=utf-8',
			dataType : 'json'
		}).done(function(data, textStatus, xhr){
			console.log(data + "12121212");
			if(data.httpStatus == 'OK'){
				console.log("ok!!!s")
				console.log(data.body.next_redirect_pc_url)
				alert('음..');
				location.href = data.body.next_redirect_pc_url;
			}
		}).fail(function(error) {
			console.log(error.responseJSON.error);
			alert("글쓰기 실패  " + error.responseJSON.error)
		});
	}
	
}

index.init();
