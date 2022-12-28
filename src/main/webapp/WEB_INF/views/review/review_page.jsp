<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

<header class="bg-dark py-5">
	<div class="container px-4 px-lg-5 my-5">
		<div class="text-center text-white">
			<h1 class="display-4 fw-bolder">Food in Life</h1>
			<p class="lead fw-normal text-white-50 mb-0">당신의 즐겼던 리뷰를 공유 해주세요</p>
		</div>
	</div>
</header>

<section class="py-5">
	<div class="container px-4 px-lg-5 mt-5">
		<div class="d-flex justify-content-end m-2">

			<form action="/review/search" method="get" class="form-inline">
				<input class="form-control mr-1" type="text" placeholder="생각나는 음식 리뷰 검색" name="search" value="${search}">
				<button type="submit" class="btn btn-warning">TITLE</button>
			</form>
		</div>
		<div class="column">

			<c:forEach var="review" items="${reviews.getContent()}">
				<div class="col mb-5">
					<div class="card h-100">
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder">${review.getReviewTitle()}</h5>
								<br>
								<!-- Product reviews-->
								<div class="d-flex justify-content-center small text-warning mb-2">
									<div class="bi-star-fill">${review.getReviewContent()}</div>
								</div>

							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto" href="#">더보기</a>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<ul class="pagination justify-content-center">
			<c:set var="isDisabled" value="disabled"></c:set>
			<c:set var="isNotDisabled" value=""></c:set>
			<li class="page-item ${reviews.first ? isDisabled : isNotDisabled}"><a class="page-link" href="?page=${reviews.number-1}">Previous</a></li>
			<c:forEach var="num" items="${pageNumbers}">
				<c:choose>
					<c:when test="${nowPage eq num}">
						<li class="page-item active"><a class="page-link" href="?page=${num - 1}">${num}</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href="?page=${num - 1}">${num}</a></li>
					</c:otherwise>
				</c:choose>

			</c:forEach>

			<li class="page-item ${reviews.last ? isDisabled: isNotDisabled}"><a class="page-link" href="?page=${reviews.number+1}">Next</a></li>
		</ul>
	</div>
</section>
<%@include file="../layout/footer.jsp"%>