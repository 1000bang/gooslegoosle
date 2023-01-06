let index = {

	init: function(){
		$("#btn--save").bind("click", () => {
			this.save();
		});
		
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