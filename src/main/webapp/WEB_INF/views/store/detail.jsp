<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>


<br />
<br />
<input type="hidden" id="address" value="${storeDetail.store.address}"></input>
<div class="container">
	<div class="row">
		<div class="col-lg-8">
			<div class="card mb-4">
				<a href="#!"><img class="card-img-top"
					src="https://dummyimage.com/850x350/dee2e6/6c757d.jpg" alt="..."></a>
				<div class="card-body">
					<div class="small text-muted"># ${storeDetail.category}</div>
					<h1 class="card-title h1">${storeDetail.store.storeName}</h1>

				</div>
			</div>
			<div class="card mb-4">
				<div class="card-body">

					<p class="card-text">주소 : ${storeDetail.store.address}
						${storeDetail.store.extraAddress}</p>
					<p class="card-text">대표번호 : ${storeDetail.store.phoneNumber}</p>

					<c:forEach var="menu" items="${storeDetail.menu}">
						<p class="card-text">${menu.menuName}</p>
						<p class="card-text">가격 : ${menu.menuPrice}</p>
					</c:forEach>
				</div>
			</div>

			<div class="card mb-4">
				<div class="card-body">
					<h3 class="card-title h3">영업시간</h3>
					<p class="card-text">영업시간 : ${storeDetail.openTime}시 ~
						${storeDetail.closeTime}시</p>
					<p class="card-text">브레이크타임 : ${storeDetail.breakTime}</p>
				</div>
			</div>
			
			<div class="card mb-4">
				<div class="card-body">
					<h3 class="card-title h3">메뉴 </h3>
					<c:forEach var="menu" items="${storeDetail.menu}">
						<p class="card-text">${menu.menuName}</p>
						<p class="card-text">가격 : ${menu.menuPrice}</p>
					</c:forEach>
				</div>
			</div>
			
			<div class="card mb-4">
				<div class="card-body">
					<h3 class="card-title h3">방문자 평가 </h3>
					
				</div>
			</div>
		</div>
		<!-- 왼쪽   -->
		<div class="col-lg-4">
			<div class="card mb-4">
				<div class="card-header">지도</div>
				<div class="card-body">
					<div id="map" style="width: 100%; height: 350px;"></div>
				<p class="card-text">주소 : ${storeDetail.store.address}
						${storeDetail.store.extraAddress}</p>
				
				</div>
			</div>


		</div>




	</div>
	<!-- row  -->

</div>



<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8c530edd51a40103966e7768c176ca6c&libraries=services"></script>
<script>
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
										content : '<div style="width:150px;text-align:center;padding:6px 0;">${storeDetail.store.storeName}</div>'
									});
							infowindow.open(map, marker);

							// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
							map.setCenter(coords);
						}
					});
</script>





<%@ include file="../layout/footer.jsp"%>

