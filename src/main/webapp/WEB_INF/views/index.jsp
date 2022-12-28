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
<br/>
<br/>
<div class="container">
<h2 class="h2"> #한식 </h2>
	<div class="row">
		<%-- <c:forEach var="num" items="${store.content}"> --%>

			<div class="col-md-3">
				<div class="card m-2">
					<div class="card-body">
						<h4 class="h4">가게 이름 </h4>
						<p> 가게 사진 </p>
						<a href="/board/${num.id}" class="btn btn-success">상세보기</a>
					</div>
				</div>
			</div>

	<%-- 	</c:forEach> --%>
	</div>
</div>
<br/><br/>
<div class="container">
<h2 class="h2"> #중식 </h2>
	<div class="row">
		<%-- <c:forEach var="num" items="${store.content}"> --%>

			<div class="col-md-3">
				<div class="card m-2">
					<div class="card-body">
						<h4 class="h4">가게 이름 </h4>
						<p> 가게 사진 </p>
						<a href="/board/${num.id}" class="btn btn-success">상세보기</a>
					</div>
				</div>
			</div>

	<%-- 	</c:forEach> --%>
	</div>
</div>
<%@ include file="layout/footer.jsp"%>

