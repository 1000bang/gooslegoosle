<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

<section class="py-5">
	<div class="container mt-5">
		<div class="d-flex justify-content-between m-2">
			<div class="Row" style="min-height: 1000px;flex-wrap: wrap;">
				<c:forEach var="review" items="${reviews.getContent()}">
					<div class="my_container" style="margin-bottom: 50px">
						<div class="review_picture">
							<img alt="" src="http://localhost:9090/magazine/${review.thumbnail}">
						</div>
						<div class="about_story">
							<h2>${review.getReviewTitle()}</h2>
							<div class="content_text">${review.getReviewContent()}</div>
							<a id="into" class="btn btn-outline-dark mt-auto"
								href="review/${review.getId()}">더보기</a> <br>
							<br>
						</div>

					</div>
				</c:forEach>
			</div>

		</div>
		
</section>

<script src="/js/review.js"></script>
<%@include file="../layout/footer.jsp"%>