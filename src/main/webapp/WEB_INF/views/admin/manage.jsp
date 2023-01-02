<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>


<br />
<br />

<div class="container">
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

						<p>${request.address}</p>
						<p>${request.phoneNumber}</p>
						<c:if test="${request.status eq 'await'}">
							<a class="btn btn-success mr-1"
								href="/admin/manage/approve/${request.id}">승인</a>
							<a class="btn btn-danger" href="/admin/manage/deny/${request.id}">거절</a>
						</c:if>
					</div>
				</div>
			</div>

		</c:forEach>
	</div>
</div>

<%@ include file="../layout/footer.jsp"%>

