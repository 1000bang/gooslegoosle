<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ include file="../layout/header.jsp"%>



<br>
<br>

<div class="container" style="min-height: 558px">
<h1 class="h2"> 공지사항 </h1>
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

		<c:forEach var="num" items="${notice.content}">
		<tbody>
			<tr onclick="location.href = '/notice/'+ ${num.id}" >
				<td>${num.id}</td>
				<td>${num.title}</td>
				<td>${num.userId.username}</td>
				<td>${num.createDate}</td>
			</tr>
		</tbody>
		</c:forEach>
	</table>

<hr/>
<c:if test="${principal.user.role eq 'ADMIN'}">
<a type="button" class="btn" href="/notice/board" style="float: right; color: white; background-color: #63BFBC;">글쓰기 </a>
</c:if>
<br/>
	<ul class="pagination justify-content-center" style="margin: 20px 0">

		<c:set var="isDisabled" value="disabled">
		</c:set>
		<c:set var="isNotDisabled" value="">
		</c:set>
		<li class="page-item ${notice.first ? isDisabled : isNotDisabled}">
			<a class="page-link text-dark" href="?page=${startPage}">처음</a>
		</li>
		<li class="page-item ${notice.first ? isDisabled : isNotDisabled}">
			<a class="page-link text-dark" href="?page=${notice.number - 1}">◀</a>
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

		<li class="page-item ${notice.last ? isDisabled : isNotDisabled}">
			<a class="page-link text-dark" href="?page=${notice.number + 1}">▶</a>
		</li>
		<li class="page-item ${notice.last ? isDisabled : isNotDisabled}">
			<a class="page-link text-dark" href="?page=${endPage}">끝 </a>
		</li>
	</ul>

	<br /> <br /> <br />
</div>



<%@ include file="../layout/footer.jsp"%>

