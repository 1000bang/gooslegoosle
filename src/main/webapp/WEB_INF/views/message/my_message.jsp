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
				<th></th>
				<th>번호</th>
				<th>내용</th>
				<th>받는 사람</th>
				<th>날짜</th>
				<th>상태</th>

			</tr>
		</thead>
		<c:forEach var="num" items="${message.content}" varStatus="status">
			<c:set var="count"
				value="${(message.totalElements + 1) - (status.count + (10 * (nowPage - 1)))}"></c:set>
			<tbody>
				<tr
					onclick="window.open('/my_message/'+ ${num.id}, '네이버팝업', 'width=700px,height=600px,scrollbars=yes')">
					<td style="color: red"><c:if
							test="${nowDate - dataDate le 100}"> new </c:if></td>
					<td>${count}</td>
					<td>${num.comment}</td>
					<td>${num.user.userNickname}</td>
					<td><fmt:formatDate value="${num.createTime}"
							pattern="yyyy-MM-dd" /></td>
					<c:choose>
						<c:when test="${num.read eq true}">
							<td>읽음</td>
						</c:when>
						<c:when test="${num.read eq false}">
							<td>안읽음</td>
						</c:when>
					</c:choose>
				</tr>
			</tbody>
		</c:forEach>
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