<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal" />
</sec:authorize>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta id="_csrf" name="${_csrf.parameterName}" content="${_csrf.token}">
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}">
<title>구슬구슬파트너센터</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/reset.css">
<link rel="stylesheet" href="/css/header.css">
<link rel="stylesheet" href="/css/main.css">
<link rel="stylesheet" href="/css/footer.css">
<link rel="stylesheet" href="/css/partner.css">
<link rel="stylesheet" href="/css/partner_main.css">
<link rel="stylesheet" href="/css/apply_store.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div id="wrap">
		<header>
			<nav class="navbar navbar-expand-md navbar-dark header-color">
				<a class="navbar-brand logo-text" href="/auth/partner/main_partner">구슬구슬
					파트너</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#collapsibleNavbar">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="collapsibleNavbar">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" href="/">구슬구슬</a></li>

						<c:choose>
							<c:when test="${empty principal}">
								<li class="nav-item b-menu"><a class="nav-link"
									href="/auth/login_form">로그인</a></li>
								<li class="nav-item"><a class="nav-link"
									href="/partner/application_partner">파트너신청하기</a></li>
							</c:when>
							<c:otherwise>
								<c:if test="${principal.user.role eq 'HOST'}">

									<li class="nav-item"><a class="nav-link"
										href="/partner/addstore/${principal.user.id}">가게 등록</a></li>
									<li class="nav-item"><a class="nav-link"
										href="/partner/updateStore/${principal.user.id}">가게 수정</a></li>
									<li class="nav-item"><a class="nav-link"
										href="/partner/reservation/${principal.user.id}">예약관리</a></li>
									<li class="nav-item"><a class="nav-link" href="/store/my/${principal.user.id}">내 가게</a></li>

									<li class="nav-item"><a class="nav-link"
										href="/partner/chart/${principal.user.id}">통계 </a></li>

								</c:if>
								<li class="nav-item"><a class="nav-link" href="/m-logout">로그아웃
								</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</nav>
		</header>