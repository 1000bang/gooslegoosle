<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file ="layout/header.jsp" %>
<c:choose>
	<c:when test="${empty principal}">
	</c:when>
	<c:when test = "${principal.user.role eq 'USER'}">
		<div class="alert alert-danger">
			<strong>${principal.username}</strong>&nbsp; 님 환영합니다 !
		</div>
	</c:when>
	<c:when test = "${principal.user.role eq 'HOST'}">
		<div class="alert alert-info">
			<strong>${principal.username}</strong>&nbsp; 님(HOST) 환영합니다 !
		</div>
	</c:when>
	<c:when test = "${principal.user.role eq 'ADMIN'}">
		<div class="alert alert-danger">
			<strong>${principal.username}</strong>&nbsp; 님(관리자) 환영합니다 !
		</div>
	</c:when>
</c:choose>



<%@ include file="layout/footer.jsp"%>

