<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="layout/header.jsp"%>
<c:choose>
	<c:when test="${empty principal}">
	</c:when>
	<c:when test="${principal.user.role eq 'USER'}">
		<div class="loginInfo">
			<strong>${principal.username}</strong>&nbsp; 님 환영합니다 !
		</div>
	</c:when>
	<c:when test="${principal.user.role eq 'HOST'}">
		<div class="loginInfo">
			<strong>${principal.username}</strong>&nbsp; 님(HOST) 환영합니다 !
		</div>
	</c:when>
	<c:when test="${principal.user.role eq 'ADMIN'}">
		<div class="loginInfo">
			<strong>${principal.username}</strong>&nbsp; 님(관리자) 환영합니다 !
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
			<div class="swiper-button-prev"></div>
			<div class="swiper-button-next"></div>

			<!-- If we need scrollbar -->
			<div class="swiper-scrollbar"></div>
		</div>


	</section>

</article>
<!-- content2 -->
<article id="m-content2">
	<div class="k-container">
		<div class="title">
			<h2>#한식</h2>
		</div>
		<div class="main-Content">
			<ul class="food-slice">
				<li><a href="#"><img src="../images/k-food/1.jpg" alt=""></a>
					<p>애성회관 한우곰탕</p></li>
				<li><a href="#"><img src="../images/k-food/2.jpg" alt=""></a>
					<p>도마</p></li>
				<li><a href="#"><img src="../images/k-food/3.jpg" alt=""></a>
					<p>명동교자 본점</p></li>
				<li><a href="#"><img src="../images/k-food/4.jpg" alt=""></a>
					<p>우래옥 본점</p></li>
				<li><a href="#"><img src="../images/k-food/5.jpg" alt=""></a>
					<p>정돈</p></li>
				<!-- <li>
                            <a href="#"><img src="./img/k-food/6.jpg" alt=""></a>
                            <p>할머니의 레시피</p>
                        </li> -->


			</ul>
		</div>
	</div>

	<div class="w-container">
		<div class="title">
			<h2>#양식</h2>
		</div>
		<div class="main-Content">
			<ul class="food-slice">
				<li><a href="#"><img src="../images/w-food/w-1.jpg" alt=""></a>
					<p>비엘티스테이크</p></li>
				<li><a href="#"><img src="../images/w-food/w-2.jpg" alt=""></a>
					<p>정식당</p></li>
				<li><a href="#"><img src="../images/w-food/w-3.jpg" alt=""></a>
					<p>텍사스 데 브라질</p></li>
				<li><a href="#"><img src="../images/w-food/w-4.jpg" alt=""></a>
					<p>붓처스컷 삼성점</p></li>
				<li><a href="#"><img src="../images/w-food/w-5.jpg" alt=""></a>
					<p>울프강 스테이크하우스</p></li>
				<!-- <li>
                            <a href="#"><img src="./img/w-food/w-6.jpg" alt=""></a>
                            <p>파씨오네</p>
                        </li> -->

			</ul>
		</div>
	</div>
	<div class="j-container">
		<div class="title">
			<h2>#일식</h2>
		</div>
		<div class="main-Content">
			<ul class="food-slice">
				<li><a href="#"><img src="../images/j-food/j-1.jpg" alt=""></a>
					<p>오레노라멘</p></li>
				<li><a href="#"><img src="../images/j-food/j-2.jpg" alt=""></a>
					<p>가마메시야 울림</p></li>
				<li><a href="#"><img src="../images/j-food/j-3.jpg" alt=""></a>
					<p>스시소라</p></li>
				<li><a href="#"><img src="../images/j-food/j-4.jpg" alt=""></a>
					<p>사당광안리</p></li>
				<li><a href="#"><img src="../images/j-food/j-5.jpg" alt=""></a>
					<p>진가와</p></li>
				<!-- <li>
                            <a href="#"><img src="./img/j-food/j-6.jpg" alt=""></a>
                            <p>냠냠 물고기</p>
                        </li> -->

			</ul>
		</div>
	</div>
	<div class="c-container">
		<div class="title">
			<h2>#중식</h2>
		</div>
		<div class="main-Content">
			<ul class="food-slice">
				<li><a href="#"><img src="../images/c-food/j-1.jpg" alt=""></a>
					<p>란주칼면</p></li>
				<li><a href="#"><img src="../images/c-food/j-2.jpg" alt=""></a>
					<p>송죽장</p></li>
				<li><a href="#"><img src="../images/c-food/j-3.jpg" alt=""></a>
					<p>마담밍</p></li>
				<li><a href="#"><img src="../images/c-food/j-4.jpg" alt=""></a>
					<p>오향가</p></li>
				<li><a href="#"><img src="../images/c-food/j-5.jpg" alt=""></a>
					<p>안동장</p></li>
				<!-- <li>
                            <a href="#"><img src="./img/c-food/j-6.jpg" alt=""></a>
                            <p>대관원</p>
                        </li> -->

			</ul>
		</div>
	</div>
	<div class="c-container">
		<div class="title">
			<h2>#한식</h2>
		</div>
		<div class="main-Content">
			<ul class="food-slice">

				<c:forEach var="storeInfo" items="${koreanStore.content}">
					<%-- <c:if test="${storeInfo.upload eq true && storeInfo.category eq 'KOREAN'}"> --%>
					<c:if test="${storeInfo.partner.upload eq true}">
						<li><c:choose>

								<c:when test="${storeInfo.image[0] eq null}"></c:when>
								<c:otherwise>
									<a href="/store/${storeInfo.id}"> <img
										src="http://localhost:9090/magazine/${storeInfo.image[0].postImageUrl}"
										alt="">
									</a>
									<p>${storeInfo.partner.storeName}</p>
								</c:otherwise>
							</c:choose></li>
					</c:if>
				</c:forEach>
			</ul>
		</div>
	</div>
	<div class="c-container">
		<div class="title">
			<h2>#양식</h2>
		</div>
		<div class="main-Content">
			<ul class="food-slice">
				<c:forEach var="storeInfo" items="${westernStore.content}">
					<c:if test="${storeInfo.partner.upload eq true}">
						<li><c:choose>
								<c:when test="${storeInfo.image[0] eq null}"></c:when>
								<c:otherwise>
									<a href="/store/${storeInfo.id}"> <img
										src="http://localhost:9090/magazine/${storeInfo.image[0].postImageUrl}"
										alt="">
									</a>
									<p>${storeInfo.partner.storeName}</p>
								</c:otherwise>
							</c:choose></li>
					</c:if>
				</c:forEach>
			</ul>
		</div>
	</div>
	<div class="c-container">
		<div class="title">
			<h2>#일식</h2>
		</div>
		<div class="main-Content">
			<ul class="food-slice">
				<c:forEach var="storeInfo" items="${japanessStore.content}">
					<%-- <c:if test="${storeInfo.upload eq true && storeInfo.category eq 'KOREAN'}"> --%>
					<c:if test="${storeInfo.partner.upload eq true}">
						<li><c:choose>
								<c:when test="${storeInfo.image[0] eq null}"></c:when>
								<c:otherwise>
									<a href="/store/${storeInfo.id}"> <img
										src="http://localhost:9090/magazine/${storeInfo.image[0].postImageUrl}"
										alt="">
									</a>
									<p>${storeInfo.partner.storeName}</p>
								</c:otherwise>
							</c:choose></li>
					</c:if>
				</c:forEach>
			</ul>
		</div>
	</div>
	<div class="c-container">
		<div class="title">
			<h2>#중식</h2>
		</div>
		<div class="main-Content">
			<ul class="food-slice">
				<c:forEach var="storeInfo" items="${chineseStore.content}">
					<%-- <c:if test="${storeInfo.upload eq true && storeInfo.category eq 'KOREAN'}"> --%>

					<c:if test="${storeInfo.partner.upload eq true}">
						<li><c:choose>
								<c:when test="${storeInfo.image[0] eq null}"></c:when>
								<c:otherwise>
									<a href="/store/${storeInfo.id}"> <img
										src="http://localhost:9090/magazine/${storeInfo.image[0].postImageUrl}"
										alt="">
									</a>
									<p>${storeInfo.partner.storeName}</p>
								</c:otherwise>
							</c:choose></li>
					</c:if>
				</c:forEach>
			</ul>
		</div>
	</div>
</article>
<br />
<br />
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
</script>
<%@ include file="layout/footer.jsp"%>
