<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

<header class="bg-dark">
	<div class="container my-5" id="container-top">
		<div class="text-center text-white">
			<h1 class="display-4 fw-bolder">Food in Life</h1>
			<p class="lead fw-normal text-white-50 mb-0">
				<span>당</span> <span>신</span> <span>이</span> <span>즐</span> <span>겼</span>
				<span>던</span> <span>리</span> <span>뷰</span> <span>를</span> <span>공</span>
				<span>유</span> <span>해</span> <span>주</span> <span>세</span> <span>요</span>
			</p>
		</div>
	</div>
</header>

<section class="py-5">
	<div class="container px-4 px-lg-5 mt-5">
		<div class="d-flex justify-content-between m-2">
			<div class="d-flex justify-content">
				<button class="btn" style="color: white; background-color: #63BFBC;">
					<a href="/review/review_save">리뷰 작성하기</a>
				</button>
			</div>
			<div>
				<form action="/review/search" method="get" class="form-inline">
					<input class="form-control mr-1" type="text"
						placeholder="생각나는 음식 리뷰 검색" name="search" value="${search}">
					<button type="submit" class="btn"
						style="color: white; background-color: #63BFBC;">TITLE</button>
				</form>
			</div>
		</div>

		<div class="Row">
			<c:forEach var="review" items="${reviews.content}">
				<c:set var="now" value="<%=new java.util.Date()%>" />
				<c:set var="nowDate">
					<fmt:formatDate value="${now}" pattern="yyyyMMddHH" />
				</c:set>
				<c:set var="dataDate">
					<fmt:formatDate value="${review.createTime}" pattern="yyyyMMddHH" />
				</c:set>
				
				<div class="my_container">
					<div class="review_picture">
						<img alt=""
							src="http://localhost:9090/magazine/${review.thumbnail}">
					</div>
					<div class="about_story">
					<div class="d-flex flex-row">
						<h2>${review.getReviewTitle()}</h2>
						<c:if test="${nowDate - dataDate le 100}">
						<p style="background-color: red; color: white; width:30px; height:30px; border-radius: 2em; font-size: 10px; text-align: center; padding-top: 7px; position: absolute;
    right: 6%; top: 43%;">New</p>
						</c:if>
					</div>
						<div class="content_text">
							<div>${review.getReviewContent()}</div>
						</div>
						<a id="into" class="btn btn-outline-dark mt-auto"
							href="/review/${review.getId()}">더보기</a> <br>
						<br>
					</div>

				</div>
			</c:forEach>
		</div>
		<br>
		<br>
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
<%@include file="../layout/footer.jsp"%>