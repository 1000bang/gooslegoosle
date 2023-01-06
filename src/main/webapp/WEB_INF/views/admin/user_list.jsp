<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>


<br><br>
<div class="container" style="min-height: 630px">
<h1 class="h2"> 회원관리  </h1>
<br>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>회원 번호</th>
				<th>회원 이름</th>
				<th>회원 역할</th>
				<th>가입 날짜</th>
				<th>경고 횟수</th>
				<th> 강티  </th>
			</tr>
		</thead>

		<c:forEach var="users" items="${user}">
		<tbody >
			<tr>
				<td>${users.id}</td>
				<td>${users.username}</td>
				<td>${users.role}</td>
				<td>${users.createdDate}</td>
				<td>${users.warning}</td>
				
				<td>
				<a type="button" class="btn-sm btn-warning" style="color: white" href="/admin/warning/${users.id}"> 경고 </a>
				<c:choose>
					<c:when test="${users.enable eq true}">
						<a type="button" class="btn-sm btn-danger" style="color: white" href="/admin/stop/${users.id}">이용중지 </a>				
					</c:when>
					<c:when test="${users.enable eq false}">
						<a type="button" class="btn-sm" style="color: white; background-color: #63BFBC" href="/admin/unstop/${users.id}">정지해제 </a>				
					</c:when>
				</c:choose>

				</td>
				
			</tr>
		</tbody>
		</c:forEach>
	</table>
	</div>



<%@ include file="../layout/footer.jsp"%>