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
				<div class="card h-100">


					<div class="card-body">
						<h2 class="card-title">${mag.title}</h2>
						<p class="card-text">${mag.content}</p>
						<div
							style="width: 119px; height: 27px px; position: absolute; left: 83%; top: 8%;">
							<a href="#!"><img class="card-img"
								src="http://localhost:9090/magazine/${mag.thumbnail}" alt="..."></a>

						</div>
					</div>
					<div class="card-footer">
						<a class="btn btn-sm"
							style="color: white; background-color: #63BFBC;"
							href="/magazine/detail/${mag.id}">More Info</a>
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

