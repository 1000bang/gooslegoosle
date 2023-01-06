<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>


<br>
<br>
<div class="container">
	<form action="/magazine/save" method="post"
		enctype="multipart/form-data">
		<label for="thumb"> 썸네일 </label>
		<div class="custom-file mb-2">
			<input type="file" name="file" class="custom-file-input"
				id="customFile" required="required"> <label
				class="custom-file-label" for="customFile">파일을 선택해주세요 </label>
		</div>
		<div class="form-group">
			<label for="title">제목 </label> <input type="text" name="title"
				id="title" class="form-control">

		</div>
		<div>
			<label for="content">내용 </label>
			<textarea name="content" id="content" rows="5"
				class="form-control content">
	</textarea>
		</div>
		<br/>
		<br/>
	<button type="submit" class="btn" style="float: right; color: white; background-color: #63BFBC;">글쓰기 완료</button>

	</form>
	<br> <br>
	<br>
	<br>
	<br>
</div>

<script>
	$('.content').summernote({
		placeholder : '내용을 입력하세요 ',
		tabsize : 2,
		height : 300
	});
</script>
<script>
	// Add the following code if you want the name of the file appear on select
	$(".custom-file-input").on(
			"change",
			function() {
				var fileName = $(this).val().split("\\").pop();
				$(this).siblings(".custom-file-label").addClass("selected")
						.html(fileName);
			});
</script>

<script type="text/javascript" src="/js/magazine.js">
	
</script>
<%@ include file="../layout/footer.jsp"%>