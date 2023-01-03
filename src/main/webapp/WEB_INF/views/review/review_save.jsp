<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

<div class="container" style="min-height: 675px">
	<form action="/api/reviews" method="POST">
	
		<div class="form-group">
		
			<label for="title">Title</label> 
			<input type="text" name="reviewTitle" id="reviewTitle" class="form-control">
		</div>
		<div class="form-group">
			<label for="content">Content</label>
			<textarea name="reviewContent" id="reviewContent" rows="5" class="form-control content"></textarea>
			<br/>
			<br/>
			<button type="submit" class="btn" style="color: white; background-color: #63BFBC; float:right" id="">글쓰기 완료</button>
			</form>
			<br/>
			<br/>
</div>
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

