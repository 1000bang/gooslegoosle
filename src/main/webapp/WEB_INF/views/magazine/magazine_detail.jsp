
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<br>
<br>
<div class="container">

	<button class="btn btn-outline-secondary" onclick="history.back();">돌아가기</button>
	<c:if test="${magazine.userId.id == principal.user.id}">
		<a class="btn btn-outline-warning" id="" href="/magazine/update/${magazine.id}">수정</a>
		<a class="btn btn-outline-danger" id="" href="/api/magazine/delete/${magazine.id}">삭제</a>
	</c:if>
	<br /> <br /> <br />

	<div>
		<input type="hidden" id="board-id" value="${magazine.id}"> 글 번호 : <span> <i> ${magazine.id + 100} </i></span>
	</div>
	<div>
		 작성자 : <span> <i> ${magazine.userId.userNickname} </i></span>
	</div>
	<div>
		작성일 : <span> <i> ${magazine.createDate} </i></span>
	</div>
	
	<hr/>	
	<br /> <br /> <br />
	<div class="">
		<h3>${magazine.title}</h3>
	</div>
	<br /> <br />
	<div>${magazine.content}</div>
	<br /> <br /> <br />
	


	
</script>
<%@ include file="../layout/footer.jsp"%>