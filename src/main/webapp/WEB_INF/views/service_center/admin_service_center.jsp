<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../admin/header.jsp"%>



<br>
<br>

<div class="container" style="min-height: 558px">
	<h1 class="h2">고객센터</h1>
	<br>
	<table class="table table-hover">
		<thead>
			<tr>
				<th></th>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>날짜</th>

			</tr>
		</thead>
				<c:forEach var="service" items="${services.content}"
					varStatus="status">
					<c:set var="count"
				value="${(services.totalElements + 1) - (status.count + (6 * (nowPage - 1)))}"></c:set>
					<tbody>
						<c:set var="now" value="<%=new java.util.Date()%>" />
						<c:set var="nowDate">
							<fmt:formatDate value="${now}" pattern="yyyyMMddHH" />
						</c:set>
						<c:set var="dataDate">
							<fmt:formatDate value="${service.createDate}"
								pattern="yyyyMMddHH" />
						</c:set>
						<tr onclick="location.href = '/seviceCenter/'+ ${service.id}">
							<td style="color: red"><c:if
									test="${nowDate - dataDate le 100}"> new </c:if></td>
							<td>${count}</td>
							<td>${service.title}</td>
							<td>${service.userId.userNickname}</td>
							<td><fmt:formatDate value="${service.createDate}"
									pattern="yyyy-MM-dd" /></td>
						</tr>
					</tbody>
				</c:forEach>
	</table>

	<hr />

	<a type="button" class="btn" href="/seviceCenter/board"
		style="float: right; color: white; background-color: #63BFBC;">글쓰기
	</a> <br />
	<ul class="pagination justify-content-center" style="margin: 20px 0">

		<c:set var="isDisabled" value="disabled">
		</c:set>
		<c:set var="isNotDisabled" value="">
		</c:set>
		<li class="page-item ${service.first ? isDisabled : isNotDisabled}">
			<a class="page-link text-dark" href="?page=${startPage}">처음</a>
		</li>
		<li class="page-item ${notice.first ? isDisabled : isNotDisabled}">
			<a class="page-link text-dark" href="?page=${service.number - 1}">◀</a>
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

		<li class="page-item ${service.last ? isDisabled : isNotDisabled}">
			<a class="page-link text-dark" href="?page=${notice.number + 1}">▶</a>
		</li>
		<li class="page-item ${service.last ? isDisabled : isNotDisabled}">
			<a class="page-link text-dark" href="?page=${endPage}">끝 </a>
		</li>
	</ul>

</div>
<br />
<br />
<br />
<script>
$( document ).ready(function() {
    console.log(${services.content});
});


</script>


<%@ include file="../layout/footer.jsp"%>

