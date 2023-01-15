let token = $("meta[name='_csrf']").attr("content");
let csrfHeader = $("meta[name='_csrf_header']").attr("content");

let index = {

	init: function(){
		
		$("#btn--update").bind("click", () => {
			this.update();
		});

	},

	
	
	update: function() {
		let data = {
			title: $("#title").val(), 
			content: $("#content").val(),
		};

		$.ajax({
			beforeSend : function(xhr){
				xhr.setRequestHeader(csrfHeader, token);
			},
			
			type: "Put",
			url: `/api/magazine/${$("#board-id").attr("data-id")}`,
			data: JSON.stringify(data),
			contentType: "application/json; charset = utf-8",
			dataType: "json"
		}).done(function(data, textStatus, xhr) {
			console.log(data);
			console.log(textStatus);
			console.log(xhr);
			if (data.httpStatus == "OK") {
				alert("수정 완료 ");
			}
			location.href = "/";
		}).fail(function(error) {
			console.log(error);
			alert("수정 실패 " + error.responseJSON.error)
		});
		
	},
	
	
	



}

index.init();