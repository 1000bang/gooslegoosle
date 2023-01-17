<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<div class="container" style="min-height: 675px; padding-top: 50px;">
	<form action="/auth/findId" method="Post">

		<div class="form-group">
			<label for="email">아이디 찾기</label> 
			<input type="email" class="form-control" placeholder="Enter Email" id="email" name="email" >
		</div>
		<div class="d-flex flex-column align-items-center">
		</div>
		<br> <br>
	</form>
	<div class="input-group justify-content-center">
			<button type="button" id="searchId" class="btn" style="width: 30vh; height: 5vh; color: white; background-color: #63BFBC;">찾기</button>
	</div>
	<form action="" method="Post">

		<div class="form-group">
			<label for="email">비밀번호 찾기</label> 
			<input type="id" class="form-control" placeholder="Enter Id" id="id" name="id" >
			<br>
			<input type="email" class="form-control" placeholder="Enter Email" id="email" name="email" >
		</div>
		<br>
		
	</form>
	<div class="input-group justify-content-center">
			<button type="button" id="searchPw" class="btn" style="width: 30vh; height: 5vh; color: white; background-color: #63BFBC;">찾기</button>
	</div>
</div>

<script type="text/javascript" src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>
