<%@page import="java.math.BigInteger"%>
<%@page import="java.security.SecureRandom"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<br>
<br>
<div class="container">
	<form action="/auth/loginProc" method="Post">
		<div class="form-group">
			<label for="usernmae">이름 :</label> <input type="text"
				class="form-control" placeholder="Enter usernmae" id="username"
				name="username" value="홍길동">

		</div>
		<div class="form-group">
			<label for="password">비밀번호 :</label> <input type="password"
				class="form-control" placeholder="Enter password" id="password"
				name="password" value="asd123">
		</div>

		<input type="hidden" name="${error}" content="${exception}"></input>
		<c:choose>
			<c:when test="${empty error}">
			</c:when>
			<c:otherwise>
				<span>
					<p id="valid" class="alert alert-danger">"${exception}"</p>
				</span>
			</c:otherwise>
		</c:choose>

		<br>
		<br>

		<div class="d-flex flex-column align-items-center">

			<button type="submit" id="" class="btn btn-danger"
				style="width: 30vh; height: 7vh">Log-in</button>


			<hr />
			<span class="social-sign-in__title">간편 로그인</span> <br>
			<div class="d-flex ">
				<a
					href="https://kauth.kakao.com/oauth/authorize?client_id=026e230aaa7d30f98a0e8cad9f217377&redirect_uri=http://localhost:9090/auth/callback&response_type=code&state=kakao">
					<img style="width: 10vh; height: 10vh;"  alt="카카오 로그인 " src="/images/social/kakao.png" class="m-2">
				</a>
				<%
				String clientId = "IdFsFqY3HF0S1iEY73kF";
				String redirectURI = URLEncoder.encode("http://localhost:9090/auth/callback", "UTF-8");
				SecureRandom random = new SecureRandom();
				String state = new BigInteger(130, random).toString();
				String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
				apiURL += "&client_id=" + clientId;
				apiURL += "&redirect_uri=" + redirectURI;
				apiURL += "&state=" + state;
				session.setAttribute("state", state);
				%>
				<a href="<%=apiURL%>"><img class="m-2" style="width: 10vh; height: 10vh;" src="/images/social/naver.png" /></a> <a
					href="https://accounts.google.com/o/oauth2/v2/auth?client_id=581731462324-vd9i5jd12s0j4d97jcv6n57l1nf2suik.apps.googleusercontent.com&redirect_uri=http://localhost:9090/auth/callback&response_type=code&scope=https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/userinfo.email&state=google">

					<img class="m-2"
					style="border: 1px solid #555; border-radius: 100px; -moz-border-radius: 100px; -khtml-border-radius: 100px; -webkit-border-radius: 100px; width: 10vh; height: 10vh;"
					alt="구글 로그인 " src="/images/social/google.png">
				</a>
			</div>
		</div>
	</form>
</div>

<br>
<br>
<%@ include file="../layout/footer.jsp"%>