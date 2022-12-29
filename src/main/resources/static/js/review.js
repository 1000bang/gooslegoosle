let index = {
	init: function(){
		$('#like').bind('click', () => {
			this.clickLike();
		});
		$('#update').bind('click', () => {
			this.update();
		});
	},
	update : function(){	
		let reviewId = $("#review-id").attr("data-id");
		let data = {
			reviewTitle:$('#reviewTitle').val(),
			reviewContent:$('#reviewContent').val()
		}
		// ajax 통신 요청
		$.ajax({
			type:'PUT',
			url:`/api/review/${reviewId}`,
			data:JSON.stringify(data),
			contentType:'application/json; charset=utf-8',
			dataType:'json'
		}).done(function(data, textStatus, xhr){
			if(data.httpStatus == 'OK'){
				alert("수정 성공")
				location.href = `/review/${reviewId}`
			}
		}).fail(function(error){
			console.log(error)
		});
	}
}

index.init();
