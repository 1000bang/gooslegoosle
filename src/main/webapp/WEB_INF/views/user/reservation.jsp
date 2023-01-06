<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>


<br />
<br />

<div class="container">
	<!-- ${reservation} -->
	<div class="mb-4">
		<h2 class="h2">나의 예약 목록</h2>
	</div>
	<div class="container" style="min-height: 558px">
		<br>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>예약번호</th>
					<th>예약자 성함 </th>
					<th>예약 장소</th>
					<th>인원수</th>
					<th>날짜</th>
					<th>요청사항</th>
					<th>상태</th>
					<th> </th>

				</tr>
			</thead>

			<c:forEach var="num" items="${reservation}">
				<tbody>
					<tr>
						<td>${num.id}</td>
						<td>${num.user.username}</td>
						<td>${num.store.partner.storeName}</td>
						<td>${num.headCount}</td>
						<td>${num.date}</td>
						<td>${num.request}</td>
						<td>${num.approve}</td>
						<c:if test="${num.approve eq 'Deny'}">
						<td><a type="button" class="btn m-2" href="/pay/return/${num.id}"
				style="color: white; background-color: #63BFBC;"> 예약금 반환
			</a></td>
			</c:if>
					</tr>
				</tbody>
			</c:forEach>
		</table>

		<hr />
		
		
	</div>


</div>


<br />
<br />


<script type="text/javascript" src="/js/reservation.js"></script>
<%@ include file="../layout/footer.jsp"%>

