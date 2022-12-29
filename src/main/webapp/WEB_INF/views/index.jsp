<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="layout/header.jsp"%>
<c:choose>
	<c:when test="${empty principal}">
	</c:when>
	<c:when test="${principal.user.role eq 'USER'}">
		<div class="alert alert-danger">
			<strong>${principal.username}</strong>&nbsp; 님 환영합니다 !
		</div>
	</c:when>
	<c:when test="${principal.user.role eq 'HOST'}">
		<div class="alert alert-info">
			<strong>${principal.username}</strong>&nbsp; 님(HOST) 환영합니다 !
		</div>
	</c:when>
	<c:when test="${principal.user.role eq 'ADMIN'}">
		<div class="alert alert-danger">
			<strong>${principal.username}</strong>&nbsp; 님(관리자) 환영합니다 !
		</div>
	</c:when>
</c:choose>
<br />
<br />
<div class="container">
	<h2 class="h2">#한식</h2>
	<div class="row">
		<c:forEach var="storeInfo" items="${store.content}">
			<c:if test="${storeInfo.upload eq true}">
				<div class="col-md-3">
					<div class="card h-100">
						<!-- Product image-->
						<img class="card-img-top"
							src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="...">
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder">${storeInfo.storeName}</h5>
								<!-- Product reviews-->
								<div
									class="d-flex justify-content-center small text-warning mb-2">
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
								</div>
								${storeInfo.address}
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto"
									href="/store/${storeInfo.id}">상세보기 </a>
							</div>
						</div>
					</div>
				</div>
			</c:if>
		</c:forEach>

	</div>
</div>
<br />
<br />
<div class="container">
	<h2 class="h2">#중식</h2>
	<div class="row">

		<c:forEach var="storeInfo" items="${store.content}">

			<div class="col-md-3">
				<div class="card h-100">
					<!-- Product image-->
					<img class="card-img-top"
						src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="...">
					<!-- Product details-->
					<div class="card-body p-4">
						<div class="text-center">
							<!-- Product name-->
							<h5 class="fw-bolder">${storeInfo.storeName}</h5>
							<!-- Product reviews-->
							<div
								class="d-flex justify-content-center small text-warning mb-2">
								<div class="bi-star-fill"></div>
								<div class="bi-star-fill"></div>
								<div class="bi-star-fill"></div>
								<div class="bi-star-fill"></div>
								<div class="bi-star-fill"></div>
							</div>
							${storeInfo.address}
						</div>
					</div>
					<!-- Product actions-->
					<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
						<div class="text-center">
							<a class="btn btn-outline-dark mt-auto" href="#">상세보기 </a>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>

	</div>
</div>
<br />
<br />
<%@ include file="layout/footer.jsp"%>

