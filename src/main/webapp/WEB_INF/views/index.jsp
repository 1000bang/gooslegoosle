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
		<div class="textbox"><h1>안녕하세요~~~~~~</h1> <p>temp text</p> </div>
		<div class="swiper myswiper0" >
			<div class="swiper-wrapper" >
				<!-- Additional required wrapper -->
				<!-- Slides -->
				<div class="swiper-slide">
				</div>
				<div class="swiper-slide">
				</div>
				<div class="swiper-slide">
				</div>
				<div class="swiper-slide">
				</div>
			</div>
			<div class="swiper-button-next swiper-button-next0" style="position: absolute; right: 0%; top: 50%;"></div>
			<div class="swiper-button-prev swiper-button-prev0" style="position: absolute; left: 0%; top: 50%;"></div>
		</div>


	</section>

</article>
<!-- content2 -->
<article id="m-content2">

	<div class="k-container">
		<div class="title">
			<h2>#전체</h2>
			<button class="btn">
					<a href="/store/all">전체 보기</a>
				</button>
		</div>
		<div class="main-Content">
			<div class="swiper mySwiper myswiper1" style="height: 300px">

				<div class="swiper-wrapper" id="food-slice" style="height: 100px">
					<c:forEach var="storeInfo" items="${store}">
						<div class="swiper-slide" style="height: 50px">
							<a href="/store/${storeInfo.id}"> <img
								src="http://localhost:9090/magazine/${storeInfo.image[0].postImageUrl}"
								alt="">
							</a>
							<p>${storeInfo.partner.storeName}</p>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="swiper-button-next swiper-button-next1"></div>
			<div class="swiper-button-prev swiper-button-prev1"></div>
		</div>
	</div>

	<div class="k-container">
		<div class="title">
			<h2>#한식</h2>
		</div>
		<div class="main-Content">
			<div class="swiper mySwiper myswiper2" style="height: 300px">

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
			</div>
			<div class="swiper-button-next swiper-button-next2"></div>
			<div class="swiper-button-prev swiper-button-prev2"></div>
			<div class="swiper-pagination"></div>
		</div>
	</div>

	<div class="k-container">
		<div class="title">
			<h2>#일식</h2>
		</div>
		<div class="main-Content">
			<div class="swiper mySwiper myswiper3" style="height: 300px">

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
			</div>
			<div class="swiper-button-next swiper-button-next3"></div>
			<div class="swiper-button-prev swiper-button-prev3"></div>
			<div class="swiper-pagination"></div>
		</div>
	</div>


	<div class="k-container">
		<div class="title">
			<h2>#중식</h2>
		</div>
		<div class="main-Content">
			<div class="swiper mySwiper myswiper4" style="height: 300px">

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
			</div>
			<div class="swiper-button-next swiper-button-next4"></div>
			<div class="swiper-button-prev swiper-button-prev4"></div>
			<div class="swiper-pagination"></div>
		</div>
	</div>


	<div class="k-container">
		<div class="title">
			<h2>#양식</h2>
		</div>
		<div class="main-Content">
			<div class="swiper mySwiper myswiper5" style="height: 300px">

				<div class="swiper-wrapper myswiper" id="food-slice"
					style="height: 100px;">
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
			</div>
			<div class="swiper-button-next swiper-button-next5"></div>
			<div class="swiper-button-prev swiper-button-prev5"></div>
			<div class="swiper-pagination"></div>
		</div>
	</div>





</article>
<br />
<br />

<script src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>

<script type="text/javascript">
	$(".loginInfo").fadeOut(5000);
	const swiper0 = new Swiper('.myswiper0', {
		direction : 'horizontal',
		autoplay : {
			delay:3000,
		},
		navigation : {
			nextEl : '.myswiper0 .swiper-button-next0',
			prevEl : '.myswiper0 .swiper-button-prev0',
		},

	});
	const swiper1 = new Swiper('.myswiper1', {
		// Optional parameters
		direction : 'horizontal',
		loop : true,

		// Navigation arrows
		navigation : {
			nextEl : '.myswiper1 ~ .swiper-button-next1',
			prevEl : '.myswiper1 ~ .swiper-button-prev1',
		},

	});
	const swiper2 = new Swiper('.myswiper2', {
		// Optional parameters
		direction : 'horizontal',
		loop : true,

		// Navigation arrows
		navigation : {
			nextEl : '.myswiper2 ~ .swiper-button-next2',
			prevEl : '.myswiper2 ~ .swiper-button-prev2',
		},

	});
	const swiper3 = new Swiper('.myswiper3', {
		// Optional parameters
		direction : 'horizontal',
		loop : true,

		// Navigation arrows
		navigation : {
			nextEl : '.myswiper3 ~ .swiper-button-next3',
			prevEl : '.myswiper3 ~ .swiper-button-prev3',
		},

	});
	const swiper4 = new Swiper('.myswiper4', {
		// Optional parameters
		direction : 'horizontal',
		loop : true,

		// Navigation arrows
		navigation : {
			nextEl : '.myswiper4 ~ .swiper-button-next4',
			prevEl : '.myswiper4 ~ .swiper-button-prev4',
		},

	});
	const swiper5 = new Swiper('.myswiper5', {
		// Optional parameters
		direction : 'horizontal',
		loop : true,

		// Navigation arrows
		navigation : {
			nextEl : '.myswiper5 ~ .swiper-button-next5',
			prevEl : '.myswiper5 ~ .swiper-button-prev5',
		},

	});

	var swipers = new Swiper(".mySwiper", {
		slidesPerView : 5,
		slidesPerGroup : 4,
		slidesPerGroup : 5,
		loop : true,
		loopFillGroupWithBlank : true,
	});
	var swipers1 = new Swiper(".mySwiper0", {
		slidesPerView : 1,
		spaceBetween : 1,
		slidesPerGroup : 1,
		loop : true,
		loopFillGroupWithBlank : true,
	});
</script>
<%@ include file="layout/footer.jsp"%>
