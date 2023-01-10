<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>


<br><br>
<div class="container">
	<form action="">
	<input type="hidden" id = "id" value="principal.user.id">
	
	<div class="form-group">
		<label for="title" id="board-id" data-id = "${notice.id}">글 번호 : ${notice.id} </label> 
	</div>
	
	
	
	<div class="form-group">
			
			<label for="username">Username</label> 
			<input type="text" name="username" id="username" 
			class="form-control" value="${principal.user.userNickname}" readonly="readonly">

		</div>
	
		<div class="form-group">
			<label for="title">Title</label> <input type="text" name="title" id="title" 
			class="form-control" value="${notice.title}">

		</div>
		<div>
			<label for="content">Content</label>
			<textarea name="content" id="content" rows="5" class="form-control content">
			${notice.content}
	</textarea>
		</div>

	</form>

	<button type="button" id="btn--update" class="btn" style="color: white; background-color: #63BFBC;">글 수정하기 </button>

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