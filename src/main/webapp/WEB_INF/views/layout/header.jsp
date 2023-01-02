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

<title>구슬구슬</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/review.css">
<link rel="stylesheet" href="/css/review_detail.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/main.css">
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
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>


</head>
<body>
	<div id="wrap">
		<nav class="navbar navbar-expand-md navbar-dark header-color">
			<a class="navbar-brand logo-text" href="/">구슬구슬</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#collapsibleNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="collapsibleNavbar">
				<ul class="navbar-nav">
					<c:choose>
						<c:when test="${empty principal}">

							<li class="nav-item b-menu"><a class="nav-link"
								href="/auth/login_form">로그인</a></li>
							<li class="nav-item b-menu"><a class="nav-link"
								href="/auth/join_form">회원가입</a></li>
						</c:when>
						<c:otherwise>

							<c:choose>
								<c:when test="${principal.user.role eq 'ADMIN'}">

									<li class="nav-item"><a class="nav-link" href="/notice">공지사항</a></li>
									<li class="nav-item"><a class="nav-link" href="/magazine">매거진</a></li>
									<li class="nav-item"><a class="nav-link"
										href="/admin/manage">점주관리</a></li>
									<li class="nav-item"><a class="nav-link" href="/admin/user">회원관리</a></li>
									<li class="nav-item"><a class="nav-link" href="/logout">로그아웃
									</a></li>
								</c:when>
								<c:otherwise>
									<li class="nav-item"><a class="nav-link" href="/magazine">매거진</a></li>
									<li class="nav-item"><a class="nav-link" href="/notice">공지사항</a></li>
									<li class="nav-item"><a class="nav-link" href="#">리뷰 </a></li>
									<c:if test="${principal.user.id eq '1'}">
										<li class="nav-item"><a class="nav-link"
											href="/api/user/${principal.user.id}">관리자 등록 </a></li>
									</c:if>

									<li class="nav-item dropdown"><a
										class="nav-link dropdown-toggle" href="#" id="navbardrop"
										data-toggle="dropdown"> 설정 </a>
										<div class="dropdown-menu">
											<a class="dropdown-item text-dark" href="/user/update">회원정보</a>
											<a class="dropdown-item text-dark" href="/logout">로그아웃 </a> <a
												class="dropdown-item text-dark" href="/reviews"> 내리뷰 관리 </a>
										</div></li>
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>


					<li class="nav-item"><c:choose>
							<c:when test="${principal.user.role eq 'ADMIN'}">
							</c:when>
							<c:otherwise>
								<a class="nav-link" href="/auth/partner/main_partner">우리매장 등록하기</a>
							</c:otherwise>
						</c:choose></li>
				</ul>
			</div>
		</nav>