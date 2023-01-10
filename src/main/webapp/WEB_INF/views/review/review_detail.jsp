<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>


<div class="container">



<input type="hidden" id="id" value="${principal.user.id}">
<input type="hidden" id="review-id" value="${reviews.getId()}">
<button id="back" class="btn btn-outline-secondary" onclick="history.back();">돌아가기</button>
<c:if test="${reviews.user.id == principal.user.id}">
	<a class="btn btn-outline-warning" id="" href="/review/${reviews.id}/review_update">수정하기</a>
	<button class="btn btn-outline-danger" id="reviewDelete">삭제하기</button>
</c:if>
</div>
<br/>
<br/>
<div class="detail-body">
	<div id="review-profile">
		<div class="about-profile">
			<img alt="" style="width: 100%; height: 100%; object-fit: cover" src="http://localhost:9090/magazine/${reviews.thumbnail}">
		</div>
		<div class="title">
			<p>${reviews.getReviewTitle()}</p>
		</div>
		<div class="address">
			<strong>주소  : </strong>${reviews.store.partner.address}
		</div>
		<div class="review-content">${reviews.getReviewContent()}</div>
		<div class="rate">
			<p>★★★★★</p>
			<p>작성자 : <span>${reviews.getUser().getUserNickname()}</span></p>
		</div>
		<div class="card">

			<div class="card-body">
				<textarea rows="1" class="form-control" id="replyContent"></textarea>
			</div>
			<div class="card-footer">
				<button class="btn" style="color: white; background-color: #63BFBC;" id="replySave">등록</button>
			</div>
		</div>
		<br>
		<div class="card">
			<div class="card-header">댓글 목록</div>
		</div>
		<ul class="list-group">
			<c:forEach var="reply" items="${reviews.reviewReplys}">
				<li class="list-group-item d-flex justify-content-between">
					<div class="replyTextTitle">댓글()</div>
					<div class="replyTextContent">${reply.replyContent}</div>
					<div class="d-flex">
						<div class="replyText">작성자 :&nbsp;${reply.user.useNickrname}&nbsp;&nbsp;&nbsp;</div>
						<c:if test="${reply.user.id eq principal.user.id}">
						<button class="btn btn-danger" onclick="index.replyDelete(${reviews.id}, ${reply.getId()});">삭제</button>
						</c:if>
					</div>
				</li>
			</c:forEach>
		</ul>

	</div>

</div>
<br/>
<br/>
<br/>
<script src="/js/review.js"></script>

<%@include file="../layout/footer.jsp"%>


