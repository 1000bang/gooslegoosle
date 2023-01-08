<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/partner_header.jsp"%>


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

			<c:forEach var="num" items="${reservation.content}">
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

<ul class="pagination justify-content-center" style="margin: 20px 0">

		<c:set var="isDisabled" value="disabled">
		</c:set>
		<c:set var="isNotDisabled" value="">
		</c:set>
		<li class="page-item ${reservation.first ? isDisabled : isNotDisabled}">
			<a class="page-link text-dark" href="?page=${startPage}">처음</a>
		</li>
		<li class="page-item ${reservation.first ? isDisabled : isNotDisabled}">
			<a class="page-link text-dark" href="?page=${reservation.number - 1}">◀</a>
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

		<li class="page-item ${reservation.last ? isDisabled : isNotDisabled}">
			<a class="page-link text-dark" href="?page=${reservation.number + 1}">▶</a>
		</li>
		<li class="page-item ${reservation.last ? isDisabled : isNotDisabled}">
			<a class="page-link text-dark" href="?page=${endPage}">끝 </a>
		</li>
	</ul>

</div>


<br />
<br />


<script type="text/javascript" src="/js/reservation.js"></script>
<%@ include file="../layout/footer.jsp"%>

