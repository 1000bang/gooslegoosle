<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>


<br />
<br />
<input type="hidden" id="address" value="${storeDetail.partner.address}"></input>
<div class="container">
	<div class="row">
		<div class="col-lg-8">
			<div class="card mb-4">
				<c:choose>
					<c:when test="${fn:length(storeDetail.image) ge 2}">
						<div class="swiper myswiper0" >
							<div class="swiper-wrapper" style="height: fit-content;">
								<c:forEach var="items" items="${storeDetail.image}">
									<div class="swiper-slide">
										<img class="card-img-top"
											src="http://localhost:9090/magazine/${items.postImageUrl}"
											alt="...">
									</div>
								</c:forEach>
							</div>
							<div class="swiper-button-next swiper-button-next0"
								style="position: absolute; right: 0%; top: 50%;"></div>
							<div class="swiper-button-prev swiper-button-prev0"
								style="position: absolute; left: 0%; top: 50%;"></div>
						</div>
					
					</c:when>
					<c:otherwise>
						<a href="#!"><img class="card-img-top"
							src="http://localhost:9090/magazine/${storeDetail.image[0].postImageUrl}"
							alt="..."></a>

					</c:otherwise>

				</c:choose>

				<div class="card-body">
					<div class="small text-muted"># ${storeDetail.category}</div>
					<h1 class="card-title h1">${storeDetail.partner.storeName}</h1>
					<br /> <input type="button" class="btn btn-warning"
						onClick="sendLinkDefault();" value="카카오톡으로 공유하기 "
						style="color: white" />
				</div>
			</div>
			<div class="card mb-4">
				<div class="card-body">

					<p class="card-text">주소 : ${storeDetail.partner.address}
						${storeDetail.partner.detailAddress}</p>
					<p class="card-text">대표번호 : ${storeDetail.partner.mainNumber}</p>

					<c:forEach var="menu" items="${storeDetail.menu}">
						<p class="card-text">#${menu.menuName}</p>

					</c:forEach>
				</div>
			</div>

			<div class="card mb-4">
				<div class="card-body">
					<h3 class="card-title h3">영업시간</h3>
					<hr />
					<p class="card-text">영업시간 : ${storeDetail.openTime}시 ~
						${storeDetail.closeTime}시</p>
					<p class="card-text">브레이크타임 : ${storeDetail.breakTime}</p>
				</div>
			</div>

			<div class="card mb-4">
				<div class="card-body">
					<h3 class="card-title h3">메뉴</h3>
					<hr />
					<c:forEach var="menu" items="${storeDetail.menu}">
						<div class="d-flex justify-content-around">
							<p class="card-text">${menu.menuName}</p>
							<p class="card-text">----- &nbsp; ${menu.menuPrice}원</p>
						</div>
					</c:forEach>
				</div>
			</div>

			<div class="card mb-4">
				<div class="card-body">
					<h3 class="card-title h3">방문자 평가</h3>
					<hr />

					<c:forEach var="reviews" items="${review.content}">
						<div class="card m-4">
							<div class="card-body">
								<h6 class="card-title h6">
									<strong>작성자 :</strong> ${reviews.user.userNickname}
								</h6>
								<c:choose>
									<c:when test="${reviews.starScore eq 1}">
										<p class="card-text">
											<strong>별점 :</strong> ⭐
										</p>
									</c:when>
									<c:when test="${reviews.starScore eq 2}">
										<p class="card-text">
											<strong>별점 :</strong> ⭐⭐
										</p>
									</c:when>
									<c:when test="${reviews.starScore eq 3}">
										<p class="card-text">
											<strong>별점 :</strong> ⭐⭐⭐
										</p>
									</c:when>
									<c:when test="${reviews.starScore eq 4}">
										<p class="card-text">
											<strong>별점 :</strong> ⭐⭐⭐⭐
										</p>
									</c:when>
									<c:when test="${reviews.starScore eq 5}">
										<p class="card-text">
											<strong>별점 :</strong> ⭐⭐⭐⭐⭐
										</p>
									</c:when>


								</c:choose>
								<hr />
								<h5 class="card-title h5">${reviews.reviewTitle}</h5>
								<p class="card-text">${reviews.reviewContent}</p>

								<div class="d-flex flex-row">
									<p>
										<a type="button" class="btn"
											style="color: white; background-color: #63BFBC; width: 15vh"
											href="/review/${reviews.id}"> 더보기</a>
									</p>
								</div>
							</div>

						</div>
					</c:forEach>

					<ul class="pagination justify-content-center"
						style="margin: 20px 0">

						<c:set var="isDisabled" value="disabled">
						</c:set>
						<c:set var="isNotDisabled" value="">
						</c:set>
						<li class="page-item ${review.first ? isDisabled : isNotDisabled}">
							<a class="page-link text-dark" href="?page=${startPage}">처음</a>
						</li>
						<li class="page-item ${review.first ? isDisabled : isNotDisabled}">
							<a class="page-link text-dark" href="?page=${review.number - 1}">◀</a>
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

						<li class="page-item ${review.last ? isDisabled : isNotDisabled}">
							<a class="page-link text-dark" href="?page=${review.number + 1}">▶</a>
						</li>
						<li class="page-item ${review.last ? isDisabled : isNotDisabled}">
							<a class="page-link text-dark" href="?page=${endPage}">끝 </a>
						</li>
					</ul>

				</div>
			</div>
		</div>
		<!-- 오른쪽   -->
		<div class="col-lg-4">
			<div class="card mb-4">
				<div class="card-header">
					<strong>가게 위치 보기</strong>
				</div>
				<div class="card-body">
					<div id="map" style="width: 100%; height: 350px;"></div>
					<p class="card-text">주소 : ${storeDetail.partner.address}
						${storeDetail.partner.detailAddress}</p>

				</div>



			</div>
			<div class="input-group justify-content-center">
				<a type="button" class="btn"
					style="color: white; background-color: #63BFBC; width: 37vh"
					href="/store/reservation/${storeDetail.id}"> 예약하기</a>

			</div>

		</div>




	</div>
	<!-- row  -->

</div>



<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8c530edd51a40103966e7768c176ca6c&libraries=services"></script>
<script>
	const swiper0 = new Swiper('.myswiper0', {
		direction : 'horizontal',
		autoHeight : true,
		loop : true,
		navigation : {
			nextEl : '.myswiper0 .swiper-button-next0',
			prevEl : '.myswiper0 .swiper-button-prev0',
		},

	});

	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	mapOption = {
		center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
		level : 3
	// 지도의 확대 레벨
	};

	// 지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption);

	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();

	// 주소로 좌표를 검색합니다
	geocoder
			.addressSearch(
					$("#address").val(),
					function(result, status) {

						// 정상적으로 검색이 완료됐으면 
						if (status === kakao.maps.services.Status.OK) {

							var coords = new kakao.maps.LatLng(result[0].y,
									result[0].x);

							// 결과값으로 받은 위치를 마커로 표시합니다
							var marker = new kakao.maps.Marker({
								map : map,
								position : coords
							});

							// 인포윈도우로 장소에 대한 설명을 표시합니다
							var infowindow = new kakao.maps.InfoWindow(
									{
										content : '<div style="width:150px;text-align:center;padding:6px 0;">${storeDetail.partner.storeName}</div>'
									});
							infowindow.open(map, marker);

							// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
							map.setCenter(coords);
						}
					});
</script>
<script type="text/JavaScript"
	src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<script>
	try {
		function sendLinkDefault() {
			Kakao.init('8c530edd51a40103966e7768c176ca6c')
			Kakao.Link
					.sendDefault({
						objectType : 'feed',
						content : {
							title : '${storeDetail.partner.storeName}',
							description : '#${storeDetail.category} ${storeDetail.partner.address} 동네 최고의 맛집으로 초대합니다.',
							imageUrl : "https://ifh.cc/g/7ot6PA.png",
							link : {
								mobileWebUrl : 'https://developers.kakao.com',
								webUrl : 'https://developers.kakao.com',
							},
						},
						buttons : [ {
							title : '웹으로 보기',
							link : {
								mobileWebUrl : 'https://developers.kakao.com',
								webUrl : 'https://developers.kakao.com',
							},
						}, ],
					})
		}
		;
		window.kakaoDemoCallback && window.kakaoDemoCallback()
	} catch (e) {
		window.kakaoDemoException && window.kakaoDemoException(e)
	}
</script>



<%@ include file="../layout/footer.jsp"%>

