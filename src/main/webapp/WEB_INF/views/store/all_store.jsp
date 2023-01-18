<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

<header class="bg-dark">
	<div class="container my-5" id="container-top">
		<div class="text-center text-white">
			<h1 class="display-4 fw-bolder">Best Store</h1>
			<p class="lead fw-normal text-white-50 mb-0">
				<span>당</span> <span>신</span> <span>이</span> <span>찾</span> <span>는</span>
				<span>맛</span> <span>집</span> <span>리</span> <span>스</span> <span>트</span>
			</p>
		</div>
	</div>
</header>
<article id="m-content2" >
	
	<c:forEach var="storeInfo" items="${store.content}">
		<div class="all-container"
			style="display: flex; justify-content: space-between;width: 55%; height: 250px;">
			<div class="con1">
				<a href="/store/${storeInfo.id}"> <img
					src="http://localhost:9090/magazine/${storeInfo.image[0].postImageUrl}"
					alt="">
				</a>
			</div>
			<div class="con2">
				<div class="storeHeader">
					<h2 class="allstoreName">${storeInfo.partner.storeName}</h2>
					<p>#${storeInfo.category}</p>
				</div>
				<div>
					<div class="storeContent" style="display: flex;">
						<span>주소 : </span>
						<p>${storeInfo.partner.address}</p>
					</div>
					
					<div class="storeContent" style="display: flex;">
						<span>가게 번호 : </span>
						<p>${storeInfo.partner.mainNumber}</p>
					</div>
					
					<div class="storeContent" style="display: flex;">
						<span>영업 시간 : </span>
						<p>${storeInfo.openTime} 시 ~ ${storeInfo.closeTime} 시</p>
					</div>
					
					<div class="storeContent" style="display: flex;">
						<span>브레이크타임 : </span>
						<p>${storeInfo.breakTime}</p>
					</div>
					
				</div>
			</div>
			<div class="con3">
				<button class="btn">
					<a href="/store/${storeInfo.id}">자세히 +</a>
				</button>
				<button class="btn">
					<a href="/store/reservation/${storeInfo.id}">예약하기</a>
				</button>
			</div>
		</div>
	</c:forEach>
	<ul class="pagination justify-content-center" style="margin: 20px 0">

		<c:set var="isDisabled" value="disabled">
		</c:set>
		<c:set var="isNotDisabled" value="">
		</c:set>
		<li class="page-item ${store.first ? isDisabled : isNotDisabled}">
			<a class="page-link text-dark" href="?page=${startPage}">처음</a>
		</li>
		<li class="page-item ${store.first ? isDisabled : isNotDisabled}">
			<a class="page-link text-dark" href="?page=${storeInfo.number - 1}">◀</a>
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
</article>

<script type="text/javascript">
	$(window).scroll(() => {
		console.log(${storeInfo.totalElement});
	}); 
</script>
<%@include file="../layout/footer.jsp"%>

