<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<article id="m-content2">
	<div class="k-container">
		<div class="title">
			<h2>#한식</h2>
		</div>
		<div class="main-Content">
			<div class="swiper mySwiper" style="height: 400px">

				<div class="swiper-wrapper" id="food-slice" style="height:100px">
					<c:forEach var="storeInfo" items="${koreanStore}">
						<div class="swiper-slide" style="height: 50px">
							<a href="/store/${storeInfo.id}"> <img style="width: 20vh; height: 20vh "
								src="http://localhost:9090/magazine/${storeInfo.image[0].postImageUrl}"
								alt="">
							</a>
							<p>${storeInfo.partner.storeName}</p>
						</div>
					</c:forEach>
				
				</div>
				<div class="swiper-button-next"></div>
				<div class="swiper-button-prev"></div>
				<div class="swiper-pagination"></div>
			</div>
		</div>
	</div>
</article>
<!-- Swiper JS -->
<script src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>

<!-- Initialize Swiper -->
<script>
	var swiper = new Swiper(".mySwiper", {
		slidesPerView : 5,
		spaceBetween : 30,
		slidesPerGroup : 5,
		loop : true,
		loopFillGroupWithBlank : true,
		pagination : {
			el : ".swiper-pagination",
			clickable : true,
		},
		navigation : {
			nextEl : ".swiper-button-next",
			prevEl : ".swiper-button-prev",
		},
	});
</script>
</body>
</html>