<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>


<br><br>
<div class="container">
	<form action="">
		<div class="form-group">
			<label for="title">제목 </label> <input type="text" name="title" id="title" class="form-control">

		</div>
		<div>
			<label for="content">내용 </label>
			<textarea name="content" id="content" rows="5" class="form-control content">
	</textarea>
		</div>

	</form>
	<br>
	<button type="button" id="btn--save" class="btn" style="float: right; color: white; background-color: #63BFBC;">글쓰기 완료</button>
<br><br><br><br>
</div>

<script>
	$('.content').summernote({
		placeholder : '내용을 입력하세요 ',
		tabsize : 2,
		height : 300
	});
</script>

<script type="text/javascript" src="/js/notice.js">

</script>
<%@ include file="../layout/footer.jsp"%>