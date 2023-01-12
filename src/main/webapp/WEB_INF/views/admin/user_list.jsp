<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>


<br>
<br>
<div class="container" style="min-height: 630px">
	<h1 class="h2">회원관리</h1>
	<br>
	<div class="d-flex justify-content-end m-2">
		<form action="/admin/user/search" method="get" class="form-inline">
			<input class="form-control mr-2" type="text"
				placeholder="회원명을 입력하세요 " name="q">
			<!-- &nbsp;&nbsp; -->
			<button type="submit" class="btn" style="color: white; background-color: #63BFBC">검색</button>
		</form>
	</div>
	<br>
	<table class="table table-hover">
		<thead>
			<tr>
				<th></th>
				<th>회원 번호</th>
				<th>회원 이름</th>
				<th>회원 역할</th>
				<th>가입 날짜</th>
				<th>경고 횟수</th>
				<th>이용 제한</th>
				<th>쪽지</th>
			</tr>
		</thead>

		<c:forEach var="users" items="${user.content}" varStatus="status">
			<tbody>
			<c:set var="now" value="<%=new java.util.Date()%>" />
			<c:set var="nowDate"><fmt:formatDate value="${now}" pattern="yyyyMMddHH" /></c:set> 
			<c:set var="dataDate"><fmt:formatDate value="${users.createdDate}" pattern="yyyyMMddHH" /></c:set> 
				
				
				<tr>
					<td style="color: red"><c:if test="${nowDate - dataDate le 100}"> new </c:if></td>
					<td>${fn:length(user.content)- status.index}</td>
					<td>${users.username}</td>
					<td>${users.role}</td>
					<td><fmt:formatDate value="${users.createdDate}" pattern="yyyy-MM-dd"/></td>
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
					<td><a type="button" class="btn-sm"
						style="color: white; background-color: #63BFBC"
						onclick="window.open('/admin/message/${users.id}', '쪽지보내기', 'width=700px,height=600px,scrollbars=yes')">
							쪽지보내기 </a></td>
				</tr>
				
				
				
			</tbody>
		</c:forEach>
	</table>

	<br /> <br />
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