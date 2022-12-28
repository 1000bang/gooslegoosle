<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>
<div class="container"></div>


<button id="back" class="btn bg-secondary" onclick="history.back();">돌아가기</button>
<input type="hidden" id="id" value="${principal.user.id}">
<input type="hidden" id="review-id" value="${reviews.getId()}"> 글 번호 : <span><i>${reviews.getId() + 100}</i></span>
	<c:if test="${reviews.user.id == principal.user.id}">
		<a class="btn btn-warning" id="" href="/review/${reviews.id}/review_update">수정하기</a>
		<button class="btn btn-danger" id="btn--delete">삭제하기</button>
	</c:if>
	<div class="detail-body">
		<div id="review-profile">
			<div class="about-profile">
				<!-- foreach문으로 사진 돌리기 -->
				<div class="items"><img src="./img/1.jpg" alt=""></div>
				<div class="items"><img src="./img/2.jpg" alt=""></div>
				<div class="items"><img src="./img/3.jpg" alt=""></div>
				<div class="items"><img src="./img/4.jpg" alt=""></div>
				<div class="items"><img src="./img/5.jpg" alt=""></div>
				<div class="items"><img src="./img/6.jpg" alt=""></div>
				<div class="items"><img src="./img/7.jpg" alt=""></div>
				<div class="items"><img src="./img/8.jpg" alt=""></div>
				<div class="items"><img src="./img/9.jpg" alt=""></div>
				<div class="items"><img src="./img/10.jpg" alt=""></div>
				<div class="items"><img src="./img/11.jpg" alt=""></div>
				<div class="items"><img src="./img/12.jpg" alt=""></div>
		</div>
		<div class="title"><p>TITLE</p></div>
		<div class="address"><p>ADDRESS</p></div>
		<div class="review-content">${reviews.getReviewContent()}</div>
		<div class="rate"><p>★★★★★</p> </div>
		<div >
		<button class="like" id="like">
		<c:if test=""></c:if>
		<img alt="" src="../images/unheart.png" id="likeImg">
		</button>
		<div><p id="like_check"></div>
			
		</div>


	</div>
</div>

<script src="/js/review.js"></script>

<%@include file="../layout/footer.jsp"%>


