
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<br>
<br>
<div class="container" style="min-height: 630px">

	<button class="btn btn-outline-secondary" onclick="history.back();">돌아가기</button>
	<c:if test="${notice.userId.id == principal.user.id}">
		<a class="btn btn-outline-warning" id="" href="/notice/update/${notice.id}">수정</a>
		<a class="btn btn-outline-danger" id="" href="/notice/delete/${notice.id}">삭제</a>
	</c:if>
	<br /> <br /> <br />

	<div>
		<input type="hidden" id="board-id" value="${notice.id}"> 글 번호 : <span> <i> ${notice.id + 100} </i></span>
	</div>
	<div>
		글 작성자 : <span> <i> ${notice.userId.username} </i></span>
	</div>
	<br /> <br /> <br />
	<div class="">
		<h3>${notice.title}</h3>
	</div>
	<br /> <br />
	<div>${notice.content}</div>
	<br /> <br /> <br />
</div>	


<script type="text/javascript" src="/js/notice.js">
	
</script>
<%@ include file="../layout/footer.jsp"%>