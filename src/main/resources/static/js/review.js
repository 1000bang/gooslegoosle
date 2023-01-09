let index = {
	init: function(){
		$('#update').bind('click', () => {
			this.update();
		});
		$('#replySave').bind('click', () => {
			this.replySave();
		});
		$('#reviewDelete').bind('click', () => {
			this.delete();
		});
		$('#replyDelete').bind('click', () => {
			this.replyDelete();
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
	},
	delete : function(){
		let reviewId = $("#review-id").val();
		console.log(reviewId)
		$.ajax({
			type:'DELETE',
			url: `/api/review/${reviewId}`,
		}).done(function(data, textStatus, xhr){
			if(data.httpStatus == 'OK'){
				alert("리뷰가 삭제 되었습니다.")
				location.href = "/"
			}
		}).fail(function(error){
			console.log("리뷰 삭제에 실패했습니다.")
		});
	},
	replySave : function(){
		let replyData = {
			reviewId : $('#review-id').val(),
			replyContent : $('#replyContent').val(),
		};
		console.log(replyData)
		$.ajax({
			type:'POST',
			url:`/api/review/${replyData.reviewId}/replySave`,
			data:JSON.stringify(replyData),
			contentType:'application/json; charset=utf-8',
			dataType:'json'
		}).done(function(data, textStatus, xhr){
			 if(data.httpStatus == 'OK'){
				 alert("댓글이 작성 되었습니다.")
				 location.href = `/review/${replyData.reviewId}`;
			 }
		}).fail(function(error){
			console.log(error)
			console.log(replyData)
		})
	},
	
	replyDelete : function(reviewId, replyId){
		console.log(reviewId);
		console.log(replyId);
		$.ajax({
			type:'DELETE',
			url:`/api/review/${reviewId}/reply/${replyId}`,
			dataType:'json',

		}).done(function(data, textStatus, xhr){
			if(data.httpStatus == 'OK'){
				alert("댓글이 삭제 되었습니다.")
				location.href = `/review/${reviewId}`;
			}
		}).fail(function(error){
			console.log(error)
			console.log("리뷰 삭제에 실패했습니다.")
		});
	},
}

index.init();
