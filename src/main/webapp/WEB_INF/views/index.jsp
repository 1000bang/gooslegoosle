<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="layout/header.jsp"%>
<c:choose>
	<c:when test="${empty principal}">
	</c:when>
	<c:when test="${principal.user.role eq 'USER'}">
		<div class="loginInfo">
			<strong>${principal.user.userNickname}</strong>&nbsp; 님 환영합니다 !
		</div>
	</c:when>
	<c:when test="${principal.user.role eq 'HOST'}">
		<div class="loginInfo">
			<strong>${principal.user.userNickname}</strong>&nbsp; 님(HOST) 환영합니다 !
		</div>
	</c:when>
	<c:when test="${principal.user.role eq 'ADMIN'}">
		<div class="loginInfo">
			<strong>${principal.user.userNickname}</strong>&nbsp; 님(관리자) 환영합니다 !
		</div>
	</c:when>
</c:choose>
<article id="m-content1">
	<section id="image">
		<!-- Slider main container -->
		<div class="swiper">
			<!-- Additional required wrapper -->
			<div class="swiper-wrapper">
				<!-- Slides -->
				<div class="swiper-slide">
					<img src="../images/k-food.jpg" alt="">
				</div>
				<div class="swiper-slide">
					<img src="../images/j-food.jpg" alt="">
				</div>
				<div class="swiper-slide">
					<img src="../images/c-food.jpg" alt="">
				</div>
				<div class="swiper-slide">
					<img src="../images/w-food.jpg" alt="">
				</div>
				...
			</div>
			<!-- If we need pagination -->
			<div class="swiper-pagination"></div>

			<!-- If we need navigation buttons -->
			<div class="swiper-button-prev" style="top: 50%"></div>
			<div class="swiper-button-next" style="top: 50%"></div>

			<!-- If we need scrollbar -->
			<div class="swiper-scrollbar"></div>
		</div>


	</section>

</article>
<!-- content2 -->
<article id="m-content2">

	<div class="k-container">
		<div class="title">
			<h2>#전체</h2>
		</div>
		<div class="main-Content">
			<div class="swiper mySwiper" style="height: 300px">

				<div class="swiper-wrapper" id="food-slice">
					<c:forEach var="storeInfo" items="${store}">
						<div class="swiper-slide">
							<a href="/store/${storeInfo.id}"> <img
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

	<div class="k-container">
		<div class="title">
			<h2>#한식</h2>
		</div>
		<div class="main-Content">
			<div class="swiper mySwiper" style="height: 300px">

				<div class="swiper-wrapper" id="food-slice">
					<c:forEach var="storeInfo" items="${koreanStore.content}">
						<div class="swiper-slide">
							<a href="/store/${storeInfo.id}"> <img
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

	<div class="k-container">
		<div class="title">
			<h2>#일식</h2>
		</div>
		<div class="main-Content">
			<div class="swiper mySwiper" style="height: 300px">

				<div class="swiper-wrapper" id="food-slice" style="height: 100px;">
					<c:forEach var="storeInfo" items="${japanessStore.content}">
						<div class="swiper-slide" style="height: 50px;">
							<a href="/store/${storeInfo.id}"> <img
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


	<div class="k-container">
		<div class="title">
			<h2>#중식</h2>
		</div>
		<div class="main-Content">
			<div class="swiper mySwiper" style="height: 300px">

				<div class="swiper-wrapper" id="food-slice" style="height: 100px">
					<c:forEach var="storeInfo" items="${chineseStore.content}">
						<div class="swiper-slide" style="height: 50px">
							<a href="/store/${storeInfo.id}"> <img
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


	<div class="k-container">
		<div class="title">
			<h2>#양식</h2>
		</div>
		<div class="main-Content">
			<div class="swiper mySwiper" style="height: 300px">

				<div class="swiper-wrapper" id="food-slice" style="height: 100px;">
					<c:forEach var="storeInfo" items="${westernStore.content}">
						<div class="swiper-slide" style="height: 50px">
							<a href="/store/${storeInfo.id}"> <img
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
<br />
<br />

<script src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>

<script type="text/javascript">
	$(".loginInfo").fadeOut(5000);
	const swiper = new Swiper('.swiper', {
		// Optional parameters
		direction : 'horizontal',
		loop : true,

		// If we need pagination
		pagination : {
			el : '.swiper-pagination',
		},

		// Navigation arrows
		navigation : {
			nextEl : '.swiper-button-next',
			prevEl : '.swiper-button-prev',
		},

		// And if we need scrollbar
		scrollbar : {
			el : '.swiper-scrollbar',
		},
	});

	var swipers = new Swiper(".mySwiper", {
		slidesPerView : 5,
		spaceBetween : 20,
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
<%@ include file="layout/footer.jsp"%>
