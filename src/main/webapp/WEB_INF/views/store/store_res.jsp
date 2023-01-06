<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>


<br />
<br />

<div class="container">
	<!-- ${reservation} -->
	<div class="mb-4">
		<h2 class="h2">예약 목록</h2>
	</div>
	<div class="container" style="min-height: 558px">
		<br>
		<table class="table table-hover">
			<thead>
				<tr>
				
					<th> </th>
					<th>예약번호</th>
					<th>예약자 성함 </th>
					<th>휴대폰 번호</th>
					<th>인원수</th>
					<th>날짜</th>
					<th>요청사항</th>
					<th>상태</th>

				</tr>
			</thead>

			<c:forEach var="num" items="${reservation}">
				<tbody>
					<tr>
						<td><input type="checkbox" name="resId" value="${num.id}"></td>
						<td>${num.id}</td>
						<td>${num.user.username}</td>
						<td>${num.phoneNumber}</td>
						<td>${num.headCount}</td>
						<td>${num.date}</td>
						<td>${num.request}</td>
						<td>${num.approve}</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>

		<hr />
		
			<a type="button" class="btn m-2" onclick="index.approve()"
				style="float: right; color: white; background-color: #63BFBC;"> 승인
			</a>
			
			<a type="button" class="btn m-2" onclick="index.deny()"
				style="float: right; color: white; background-color: #63BFBC;"> 거절
			</a>
		
	</div>


</div>


<br />
<br />


<script type="text/javascript" src="/js/reservation.js"></script>
<%@ include file="../layout/footer.jsp"%>

