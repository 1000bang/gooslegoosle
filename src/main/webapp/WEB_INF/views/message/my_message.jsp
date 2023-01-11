<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>



<br>
<br>

<div class="container" style="min-height: 558px">
	<h1 class="h2">메세지 보관함</h1>
	<br>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>내용</th>
				<th>받는 사람</th>
				<th>날짜</th>

			</tr>
		</thead>
		<c:choose>
			<c:when test="${principal.user.role eq 'ADMIN'}">
				<c:forEach var="num" items="${message.content}">
					<tbody>
						<tr onclick="#">
							<td>${num.id}</td>
							<td>${num.comment}</td>
							<td>${num.user.userNickname}</td>
							<td>${num.createTime}</td>					
						</tr>
					</tbody>
				</c:forEach>
			</c:when>
			<c:otherwise>
					<c:forEach var="num" items="${message.content}">
				<c:choose>
					<c:when test="${principal.user.id == num.user.id}">
						<tbody>
						<tr onclick="window.open('/my_message/'+ ${num.id}, '네이버팝업', 'width=700px,height=600px,scrollbars=yes')">
							<td>${num.id}</td>
							<td>${num.comment}</td>
							<td>${num.user.userNickname}</td>
							<td>${num.createTime}</td>
						</tr>
					</tbody>
					</c:when>
				</c:choose>
					
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>

	<hr />
	<br />
	<ul class="pagination justify-content-center" style="margin: 20px 0">

		<c:set var="isDisabled" value="disabled">
		</c:set>
		<c:set var="isNotDisabled" value="">
		</c:set>
		<li class="page-item ${message.first ? isDisabled : isNotDisabled}">
			<a class="page-link text-dark" href="?page=${startPage}">처음</a>
		</li>
		<li class="page-item ${message.first ? isDisabled : isNotDisabled}">
			<a class="page-link text-dark" href="?page=${message.number - 1}">◀</a>
		</li>
		<c:forEach var="num" items="${pageNumbers}">
			<c:choose>
				<c:when test="${nowPage eq num}">
					<li class="page-item active bg-dark"><a
						class="page-link text-dark "
						style="background-color: #63BFBC; border-color: #63BFBC;"
						href="?page=${num - 1}">${num} </a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link text-dark"
						href="?page=${num - 1}">${num}</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<li class="page-item ${message.last ? isDisabled : isNotDisabled}">
			<a class="page-link text-dark" href="?page=${notice.number + 1}">▶</a>
		</li>
		<li class="page-item ${message.last ? isDisabled : isNotDisabled}">
			<a class="page-link text-dark" href="?page=${endPage}">끝 </a>
		</li>
	</ul>

	<br /> <br /> <br />
</div>



<%@ include file="../layout/footer.jsp"%>

