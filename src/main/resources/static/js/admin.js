let token = $("meta[name='_csrf']").attr("content");
let csrfHeader = $("meta[name='_csrf_header']").attr("content");
let index = {
	init: function() {

		
		$("#btn--send").bind("click", () => {
			this.sendMessage();
		});

	},

	

	sendMessage: function() {
		var id = $("#id").val();
		var data = {
			
			comment: $("#comment").val(), 
		}
		
		$.ajax({
			beforeSend : function(xhr){
				xhr.setRequestHeader(csrfHeader, token);
			},
			
			type: "POST",
			url: '/admin/message/send/'+id,
			data: JSON.stringify(data),
			contentType: "application/json; charset = utf-8",
			dataType: "json"
		}).done(function(data, textStatus, xhr) {
			if (data.httpStatus == "OK") {
				window.close();
				alert("메세지 전송 완료");
			}

		}).fail(function(error) {
			alert("실패" + error);
			console.log(error.responseJSON.message);
		});
	},

	

}


index.init();











