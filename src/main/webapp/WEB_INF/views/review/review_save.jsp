<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

<div class="container" style="min-height: 675px">
	<form action="/api/reviews" method="POST" enctype="multipart/form-data">
		<label for="thumb" style="margin-top: 30px; font-weight: 600">썸네일</label>
		<div class="custom-file mb-2">
			<input type="file" name="file" class="custom-file-input"
				id="customFile" required="required"> <label
				class="custom-file-label" for="customFile">파일을 선택해주세요 </label>
		</div>

		<div class="form-group">
			<select class="custom-select mb-1 form-control" id="time" name="time">
				<option selected> 리뷰할 식당 </option>
				<c:forEach var="item" items="principal.user.reservation">
				<option value="">${item.store.partner.storeName}</option>
				</c:forEach>
			</select>

		</div>

		<div class="form-group">

			<label for="title" style="font-weight: 600">리뷰 제목</label> <input
				type="text" name="reviewTitle" id="reviewTitle" class="form-control">
		</div>
		<div class="form-group">

			<label for="content">Content</label>
			<textarea name="reviewContent" id="reviewContent" rows="5"
				class="form-control content"></textarea>
			<br /> <br />
			<button type="submit" class="btn"
				style="color: white; background-color: #63BFBC; float: right" id="">글쓰기
				완료</button>
		</div>
	</form>
	<br /> <br />
</div>
<script>
	$('.content').summernote({
		placeholder : '내용을 입력해주세요',
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
<script type="text/javascript" src="/js/review.js"></script>

<%@include file="../layout/footer.jsp"%>

