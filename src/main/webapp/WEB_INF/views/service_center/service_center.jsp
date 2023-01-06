<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>



<br>
<br>

<div class="container" style="min-height: 558px">
	<h1 class="h2">고객센터</h1>
	<br>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>날짜</th>

			</tr>
		</thead>
		<c:choose>
			<c:when test="${principal.user.role eq 'ADMIN'}">
				<c:forEach var="service" items="${services.content}">
				<tbody>
					<tr onclick="location.href = '/seviceCenter/'+ ${service.id}">
						<td>${service.id}</td>
						<td>${service.title}</td>
						<td>${service.userId.username}</td>
						<td>${service.createDate}</td>
					</tr>
				</tbody>
			</c:forEach>
			</c:when>
		
			<c:otherwise>
				<c:forEach var="service" items="${services.content}">
				<c:choose>
				<c:when test="${principal.user.id == service.userId.id}">
					<tbody>
					<tr onclick="location.href = '/seviceCenter/'+ ${service.id}">
						<td>${service.id}</td>
						<td>${service.title}</td>
						<td>${service.userId.username}</td>
						<td>${service.createDate}</td>
					</tr>
					</tbody>
				</c:when>
				<c:otherwise>
				<tbody>
					<tr>
						<td>${service.id}</td>
						<td>비공개 글입니다.</td>
						<td>비공개</td>
						<td>****/**/**</td>
					</tr>
				</tbody>
				</c:otherwise>
				</c:choose>
			</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>

	<hr />

	<a type="button" class="btn" href="/seviceCenter/board"
		style="float: right; color: white; background-color: #63BFBC;">글쓰기
	</a>

</div>
<br />
<br />
<br />


<%@ include file="../layout/footer.jsp"%>

