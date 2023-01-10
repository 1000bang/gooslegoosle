<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="header.jsp"%>


<br />
<br />

<div class="container" style="min-height: 630px">
	<h2 class="h2">파트너 관리</h2>
	<br />
	<div class="row">
		<c:forEach var="request" items="${store.content}">
			<div class="col-md-6">
				<div class="card m-2">
					<div class="card-body">

						<c:choose>
							<c:when test="${request.status eq 'deny'}">
								<div class="badge bg-danger text-white position-absolute"
									style="top: 0.5rem; right: 0.5rem">${request.status}</div>
							</c:when>
							<c:when test="${request.status eq 'approve'}">
								<div class="badge bg-success text-white position-absolute"
									style="top: 0.5rem; right: 0.5rem">${request.status}</div>
							</c:when>

							<c:otherwise>
								<div class="badge bg-info text-white position-absolute"
									style="top: 0.5rem; right: 0.5rem">${request.status}</div>
							</c:otherwise>
						</c:choose>

						<h2 style="font-weight: bold">${request.storeName}</h2>
						
						<div class="mb-5">
							<a href="#!"><img class="card-img"
								src="http://localhost:9090/magazine/${request.businessCard}" alt="..."></a>

						</div>
						<p><strong>ID :</strong>  ${request.user.username}</p>
						<p><strong>주소 :</strong> ${request.address}</p>
						<p><strong>PN :</strong> ${request.phoneNumber}</p>
						<c:if test="${request.status eq 'await'}">
							<div class="justify-content-right">
							<a class="btn btn-success mr-1"
								href="/admin/manage/approve/${request.id}">승인</a>
							<a class="btn btn-danger" href="/admin/manage/deny/${request.id}">거절</a>
							</div>
						</c:if>
					</div>
				</div>
			</div>

		</c:forEach>
	</div>
	
	<br/><br/>
	<ul class="pagination justify-content-center" style="margin: 20px 0">

		<c:set var="isDisabled" value="disabled">
		</c:set>
		<c:set var="isNotDisabled" value="">
		</c:set>
		<li class="page-item ${store.first ? isDisabled : isNotDisabled}">
			<a class="page-link text-dark" href="?page=${startPage}">처음</a>
		</li>
		<li class="page-item ${store.first ? isDisabled : isNotDisabled}">
			<a class="page-link text-dark" href="?page=${store.number - 1}">◀</a>
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

		<li class="page-item ${store.last ? isDisabled : isNotDisabled}">
			<a class="page-link text-dark" href="?page=${store.number + 1}">▶</a>
		</li>
		<li class="page-item ${store.last ? isDisabled : isNotDisabled}">
			<a class="page-link text-dark" href="?page=${endPage}">끝 </a>
		</li>
	</ul>

	<br /> <br /> <br />
	
	
</div>
<br/>
<br/>
<%@ include file="../layout/footer.jsp"%>

