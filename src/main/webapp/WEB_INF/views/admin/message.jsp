<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>쪽지보내기</title>
</head>
<body>
	<br>
	<br>

	<div class="container" style="min-height: 630px">
		<h1 class="h2">쪽지 보내기</h1>
		<br>
		<form >
		<div class="form-group">
		<input type="text" hidden="true"
					class="form-control" id="id" name="id"
					value="${user.id}" readonly="readonly">
		</div>
			<div class="form-group">
				<label for="usernmae">아이디 :</label> <input type="text"
					class="form-control" id="username" name="username"
					value="${user.username}" readonly="readonly">
			</div>

			<div class="form-group">
				<label for="usernmae">이름 :</label> <input type="text"
					class="form-control" id="userNickname" name="userNickname"
					value="${user.userNickname}" readonly="readonly">
			</div>

			<div class="form-group">
				<label for="comment">내용 :</label>
				<textarea class="form-control" rows="5" id="comment"></textarea>
			</div>
		</form>
			<div class="input-group justify-content-end">

				<button type="button" id="btn--send" class="btn align-self-end"
					style="width: 15vh; color: white; background-color: #63BFBC;">보내기</button>
			</div>
		<br /> <br /> <br />
	</div>

<script type="text/javascript" src="/js/admin.js"></script>
</body>
</html>