<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>


<br />
<br />

<div class="container">
	<h2 class="h2">매거진</h2>
	<br />
	
	<c:forEach var="mag" items="${magazine}">
	<div class="row">
		<div class="col-md-8 mb-5">
			<div class="card h-100">
			
			
				<div class="card-body" >
					<h2 class="card-title">${mag.title}</h2>
					<p class="card-text" >${mag.content}</p>
				</div>
				<div class="card-footer">
					<a class="btn btn-sm" style="color: white; background-color: #63BFBC;" href="/magazine/detail/${mag.id}">More Info</a>
				</div>
			</div>
		</div>
		<div class="col-md-4 mb-5">
			<a href="#!"><img class="card-img"
				src="http://localhost:9090/magazine/${mag.thumbnail}" alt="..."></a>

		</div>
	</div>
	</c:forEach>
	<hr />
	<c:if test="${principal.user.role eq 'ADMIN'}">
		<a type="button" class="btn" href="/magazine/board"
			style="float: right; color: white; background-color: #63BFBC;">글쓰기 </a>
	</c:if>

	<br /> <br /> <br />
</div>

<%@ include file="../layout/footer.jsp"%>

