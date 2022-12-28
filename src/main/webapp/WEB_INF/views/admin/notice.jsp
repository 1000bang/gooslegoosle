<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ include file="../layout/header.jsp"%>



<br>
<br>

<div class="container">
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
		<tbody >
			<tr onclick="location.href = '/admin/notice/'+ ${num.id}" >
				<td>${num.id}</td>
				<td>${num.title}</td>
				<td>${num.userId.username}</td>
				<td>${num.createDate}</td>
			</tr>
		</tbody>
		</c:forEach>
	</table>

<hr/>
<a type="button" class="btn btn-danger" href="/admin/notice/board" style="float: right">글쓰기 </a>
</div>
<br/>
<br/>
<br/>


<%@ include file="../layout/footer.jsp"%>

