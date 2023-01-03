<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

<div class="container">
	<form action="">
	<input type="hidden" id="id" value="principal.user.id">
	
		<div class="form-group">
			<label for="title" id="review-id" data-id="${review.id}">글 번호 : ${review.id}</label> 
		</div>
		
		<div class="form-group">
			<label for="title">username:</label> 
			<input type="text" name="username" id="username" class="form-control" value="${principal.user.username}" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="title">Title</label> <input type="text" name="reviewTitle" id="reviewTitle" class="form-control" value="${review.reviewTitle}" >
		</div>
		<div class="form-group">
			<label for="content">Content</label>
			<textarea name="reviewContent" id="reviewContent" rows="5" class="form-control content">${review.reviewContent}</textarea>
		</div>
	</form>
	<button type="button" class="btn" style="color: white; background-color: #63BFBC;" id="update">글 수정하기</button>
</div>

<script>
	$('.content').summernote({
		placeholder : '내용을 입력해주세요',
		tabsize : 2,
		height : 300
	});
</script>
<script type="text/javascript" src="/js/review.js"></script>
<%@include file="../layout/footer.jsp"%>
