<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

<section class="py-5">
	<h2 style="text-align: center;">나의 리뷰</h2>
	<div class="container mt-5" style="border-top: 3px solid #000;">
		<div class="d-flex justify-content-between m-2">
			<div class="Row"
				style="min-height: 1000px; flex-wrap: wrap; padding-left: 35px;">


				<c:choose>
					<c:when test="${empty reviews.content}">
					<br/>
						<div class="d-flex justify-content-center">
							<h4 style="color: #63BFBC">${principal.user.userNickname}님 
								작성하신 리뷰가 없습니다.</h4>
						</div>
						<br />
					</c:when>
					<c:otherwise>
						<c:forEach var="review" items="${reviews.getContent()}">
							<div class="my_container">
								<div class="review_picture">
									<img alt=""
										src="http://localhost:9090/magazine/${review.thumbnail}">
								</div>
								<div class="about_story">
									<h2>${review.getReviewTitle()}</h2>
									<div class="content_text">${review.getReviewContent()}</div>
									<a id="into" class="btn btn-outline-dark mt-auto"
										href="review/${review.getId()}">더보기</a> <br> <br>
								</div>

							</div>
						</c:forEach>
						</c:otherwise>
						</c:choose>
			</div>

		</div>
		<ul class="pagination justify-content-center" style="margin: 20px 0">

			<c:set var="isDisabled" value="disabled">
			</c:set>
			<c:set var="isNotDisabled" value="">
			</c:set>
			<li class="page-item ${reviews.first ? isDisabled : isNotDisabled}">
				<a class="page-link text-dark" href="?page=${startPage}">처음</a>
			</li>
			<li class="page-item ${reviews.first ? isDisabled : isNotDisabled}">
				<a class="page-link text-dark" href="?page=${reviews.number - 1}">◀</a>
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

			<li class="page-item ${reviews.last ? isDisabled : isNotDisabled}">
				<a class="page-link text-dark" href="?page=${reviews.number + 1}">▶</a>
			</li>
			<li class="page-item ${reviews.last ? isDisabled : isNotDisabled}">
				<a class="page-link text-dark" href="?page=${endPage}">끝 </a>
			</li>
		</ul>

	</div>

</section>

<script src="/js/review.js"></script>
<%@include file="../layout/footer.jsp"%>