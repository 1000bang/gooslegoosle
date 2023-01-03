<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>
<div class="container"></div>


<button id="back" class="btn bg-secondary" onclick="history.back();">돌아가기</button>
<input type="hidden" id="id" value="${principal.user.id}">
<input type="hidden" id="review-id" value="${reviews.getId()}">
글 번호 :
<span><i>${reviews.getId() + 100}</i></span>
<c:if test="${reviews.user.id == principal.user.id}">
	<a class="btn btn-outline-warning" id="" href="/review/${reviews.id}/review_update">수정하기</a>
	<button class="btn btn-outline-danger" id="reviewDelete">삭제하기</button>
</c:if>
<div class="detail-body">
	<div id="review-profile">
		<div class="about-profile">
			<!-- foreach문으로 사진 돌리기 -->
		</div>
		<div class="title">
			<p>${reviews.getReviewTitle()}</p>
		</div>
		<div class="address">
			<strong>ADDRESS</strong>
		</div>
		<div class="review-content">${reviews.getReviewContent()}</div>
		<div class="rate">
			<p>★★★★★</p>
			<p>작성자 : <span>${reviews.getUser().getUsername()}</span></p>
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
						<div class="replyText">작성자 :&nbsp;${reply.user.username}&nbsp;&nbsp;&nbsp;</div>
						<c:if test="${reply.user.id eq principal.user.id}">
						<button class="btn btn-danger" onclick="index.replyDelete(${reviews.id}, ${reply.getId()});">삭제</button>
						</c:if>
					</div>
				</li>
			</c:forEach>
		</ul>

	</div>

</div>

<script src="/js/review.js"></script>

<%@include file="../layout/footer.jsp"%>


