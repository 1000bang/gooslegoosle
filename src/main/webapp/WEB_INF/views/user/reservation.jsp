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
					<th></th>
					<th>예약번호</th>
					<th>예약자 성함</th>
					<th>예약 장소</th>
					<th>인원수</th>
					<th>날짜</th>
					<th>요청사항</th>
					<th>상태</th>
					<th></th>

				</tr>
			</thead>
			<c:choose>
				<c:when test="${empty reservation.content}">
					<div class="d-flex justify-content-center">
						<h4 style="color: #63BFBC">${principal.user.userNickname}님의
							예약 내역이 없습니다.</h4>
					</div>
					<br />
				</c:when>
				<c:otherwise>
					<c:forEach var="num" items="${reservation.content}"
						varStatus="status">
						<c:set var="count"
							value="${(reservation.totalElements + 1) - (status.count + (8 * (nowPage - 1)))}"></c:set>


						<tbody>
							<tr>
								<td style="color: red"><c:if
										test="${status.first || num.approve eq 'Wait'}">New</c:if></td>
								<td>${count}</td>
								<td>${num.user.userNickname}</td>
								<td>${num.store.partner.storeName}</td>
								<td>${num.headCount}</td>
								<td>${num.date}</td>
								<td>${num.request}</td>
								<td>${num.approve}</td>
								<c:if test="${num.approve eq 'Deny'}">
									<td><a type="button" class="btn m-2"
										href="/pay/return/${num.id}"
										style="color: white; background-color: #63BFBC;"> 예약금 반환 </a></td>
								</c:if>
							</tr>
						</tbody>

					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>

		<hr />


	</div>

	<ul class="pagination justify-content-center" style="margin: 20px 0">

		<c:set var="isDisabled" value="disabled">
		</c:set>
		<c:set var="isNotDisabled" value="">
		</c:set>
		<li
			class="page-item ${reservation.first ? isDisabled : isNotDisabled}">
			<a class="page-link text-dark" href="?page=${startPage}">처음</a>
		</li>
		<li
			class="page-item ${reservation.first ? isDisabled : isNotDisabled}">
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

