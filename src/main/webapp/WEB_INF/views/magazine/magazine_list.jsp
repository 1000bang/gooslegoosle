<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>


<br />
<br />

<div class="container" style="min-height: 630px">
	<h2 class="h2">매거진</h2>
	<br />

	<c:forEach var="mag" items="${magazine.content}">
		<div class="row" style="animation: reviewBox 3s;">
			<div class="col-md-8 mb-5">
				<div class="card">


					<div class="card-body"
						onclick="location.href = '/magazine/detail/${mag.id}'">
						<h2 class="card-title" style="color: #63BFBC">${mag.title}</h2>
						<p class="card-text" id="card-text">구슬구슬 리뷰어들이 직접 방문하고 솔직하게
							평가한 전국의 숨은 맛집! 이번주도 좋은 평가를 받은 식당들 중에서 엄선하여 소개해 드립니다. 구슬구슬은 식당 후기에
							대하여 스폰 및 광고를 전혀받고 있지 않으니, 믿고 보셔도 됩니다.</p>
						<div
							style="width: 119px; height: 27px; position: absolute; left: 83%; top: 8%;">
							<a href="#!"><img class="card-img"
								src="http://localhost:9090/magazine/${mag.thumbnail}" alt="..."></a>

						</div>
					</div>

				</div>

			</div>

		</div>

	</c:forEach>
	<hr />
	<c:if test="${principal.user.role eq 'ADMIN'}">
		<a type="button" class="btn" href="/magazine/board"
			style="float: right; color: white; background-color: #63BFBC;">글쓰기
		</a>
	</c:if>
	<br />

	<!-- page  -->
	<ul class="pagination justify-content-center" style="margin: 20px 0">

		<c:set var="isDisabled" value="disabled">
		</c:set>
		<c:set var="isNotDisabled" value="">
		</c:set>
		<li class="page-item ${magazine.first ? isDisabled : isNotDisabled}">
			<a class="page-link text-dark" href="?page=${startPage}">처음</a>
		</li>
		<li class="page-item ${magazine.first ? isDisabled : isNotDisabled}">
			<a class="page-link text-dark" href="?page=${magazine.number - 1}">◀</a>
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

		<li class="page-item ${magazine.last ? isDisabled : isNotDisabled}">
			<a class="page-link text-dark" href="?page=${magazine.number + 1}">▶</a>
		</li>
		<li class="page-item ${magazine.last ? isDisabled : isNotDisabled}">
			<a class="page-link text-dark" href="?page=${endPage}">끝 </a>
		</li>
	</ul>

	<br /> <br /> <br />
</div>

<%@ include file="../layout/footer.jsp"%>

