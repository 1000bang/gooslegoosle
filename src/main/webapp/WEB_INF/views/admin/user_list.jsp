<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>


<br>
<br>
<div class="container" style="min-height: 630px">
	<h1 class="h2">회원관리</h1>
	<br>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>회원 번호</th>
				<th>회원 이름</th>
				<th>회원 역할</th>
				<th>가입 날짜</th>
				<th>경고 횟수</th>
				<th>강티</th>
			</tr>
		</thead>

		<c:forEach var="users" items="${user.content}">
			<tbody>
				<tr>
					<td>${users.id}</td>
					<td>${users.username}</td>
					<td>${users.role}</td>
					<td>${users.createdDate}</td>
					<td>${users.warning}</td>

					<td><a type="button" class="btn-sm btn-warning"
						style="color: white" href="/admin/warning/${users.id}"> 경고 </a> <c:choose>
							<c:when test="${users.enable eq true}">
								<a type="button" class="btn-sm btn-danger" style="color: white"
									href="/admin/stop/${users.id}">이용중지 </a>
							</c:when>
							<c:when test="${users.enable eq false}">
								<a type="button" class="btn-sm"
									style="color: white; background-color: #63BFBC"
									href="/admin/unstop/${users.id}">정지해제 </a>
							</c:when>
						</c:choose></td>

				</tr>
			</tbody>
		</c:forEach>
	</table>
	
		<br/><br/>
	<ul class="pagination justify-content-center" style="margin: 20px 0">

		<c:set var="isDisabled" value="disabled">
		</c:set>
		<c:set var="isNotDisabled" value="">
		</c:set>
		<li class="page-item ${user.first ? isDisabled : isNotDisabled}">
			<a class="page-link text-dark" href="?page=${startPage}">처음</a>
		</li>
		<li class="page-item ${user.first ? isDisabled : isNotDisabled}">
			<a class="page-link text-dark" href="?page=${user.number - 1}">◀</a>
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

		<li class="page-item ${user.last ? isDisabled : isNotDisabled}">
			<a class="page-link text-dark" href="?page=${user.number + 1}">▶</a>
		</li>
		<li class="page-item ${user.last ? isDisabled : isNotDisabled}">
			<a class="page-link text-dark" href="?page=${endPage}">끝 </a>
		</li>
	</ul>

	<br /> <br /> <br />
</div>



<%@ include file="../layout/footer.jsp"%>