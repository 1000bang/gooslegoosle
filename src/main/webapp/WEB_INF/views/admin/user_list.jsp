<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>


<br><br>
<div class="container">
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
				<a type="button" class="btn-sm btn-warning" href="/admin/warning/${users.id}"> 경고 </a>
				<a type="button" class="btn-sm btn-danger" href="/admin/delete/${users.id}">삭제 </a>
				</td>
				
			</tr>
		</tbody>
		</c:forEach>
	</table>
	</div>



<%@ include file="../layout/footer.jsp"%>