<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>
<article id="m-content2" style="height: 1600px; overflow: hidden;" class="m-content2">
	<c:forEach var="storeInfo" items="${store}">
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
</article>

<script type="text/javascript">
	$(window).scroll(() => {
		console.log(${storeInfo.totalElement});
	}); 
</script>
<%@include file="../layout/footer.jsp"%>

