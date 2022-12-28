<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>



<div class="container-float">

	<div class="row">
		<c:forEach var="request" items="${store.content}">

			<div class="col-md-6">
				<div class="card m-2">
					<div class="card-body">
						<h2 style="font-weight : bold">${request.storeName}</h2>
						<p>${request.address}</p>
						<p>${request.phoneNumber}</p>
						<a class="btn btn-success mr-1" href="/admin/manage/approve/${request.id}">승인</a> <a
							class="btn btn-danger" href="/admin/manage/deny/${request.id}">거절</a>
					</div>
				</div>
			</div>

		</c:forEach>
	</div>
</div>

<%@ include file="../layout/footer.jsp"%>

