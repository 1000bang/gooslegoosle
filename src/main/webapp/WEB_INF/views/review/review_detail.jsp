<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>
<div class="container">


<button class="btn bg-secondary" onclick="history.back();">돌아가기</button>
<input type="hidden" id="board-id" value="${reviews.getId()}"> 글 번호 : <span><i>${reviews.getId()}</i></span>
	<c:if test="${reviews.user.id == principal.user.id}">
		<a class="btn btn-warning" id="" href="/review/${reviews.id}/update_form">수정하기</a>
		<button class="btn btn-danger" id="btn--delete">삭제하기</button>
	</c:if>
</div>

<%@include file="../layout/footer.jsp"%>

