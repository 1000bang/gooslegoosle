<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal" />
</sec:authorize>

<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="UTF-8">
<meta id="_csrf" name="${_csrf.parameterName}" content="${_csrf.token}">
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}">
<title>구슬구슬</title>
<link rel="shortcut icon" href="/images/fav.png">
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
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
<link rel="stylesheet" href="/css/swiper.css" />
<script src="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.js"></script>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
<link rel="stylesheet" type="text/css"
	href="https://npmcdn.com/flatpickr/dist/themes/material_green.css">
<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
<script src="https://npmcdn.com/flatpickr/dist/l10n/ko.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.css">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.js"></script>


</head>
<body>
	<div id="wrap">
		<header id="header" class="main_header">

			<div id="logo">
				<a href="/"><img src="/images/logo2.png" alt=""></a>
			</div>
			<div class="searchBox">
				<form action="/search">
					<button type="submit" class="searchButton">
						<img src="/images/search.png" alt="">
					</button>
					<input type="text" placeholder="음식 또는 식당명 입력" name="searchWord">
				</form>
			</div>
			<nav id="nav">
				<ul>
					<c:choose>
						<c:when test="${empty principal}">
							<li><a href="/magazine">Magazine</a></li>
							<li><a href="/notice">Notice</a></li>
							<li><a href="/reviews">Review</a></li>
							<li><a href="/auth/login_form">Login</a></li>
							<li><a href="/auth/join_form">Join</a></li>
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${principal.user.role eq 'ADMIN'}">

								</c:when>
								<c:otherwise>
									<li class="bell">
										<div class="bellBox">
											<a href="/my_message"><img src="/images/bell.png" alt=""></a>
											<c:forEach var="item" items="${principal.user.message}">
												<c:if test="${item.read eq false}">
													<c:set var="i" value="${i + 1}" />
													<input hidden="false" value="${i}" id="mes">
												</c:if>
											</c:forEach>
											
											<c:if test="${i ge 0}">
											<p id="temp" style="width: 50%; height: 50%;">${i}</p>
										</c:if>
										</div>
									</li>
								</c:otherwise>
							</c:choose>

							<li><a href="/magazine">Magazine</a></li>
							<li><a href="/notice">Notice</a></li>
							<li><a href="/reviews">Review</a></li>
							<li id="more--view"><a href="#">About Me</a>
								<ul id="nave--moreview--item" style="padding-top: 0">
									<li><a class="dropdown-item" href="/user/update">Profile</a></li>
									<li><a class="dropdown-item" href="/myReview">My
											Review</a></li>
									<li><a class="dropdown-item" href="/myReservation">My
											Reservation</a></li>
									<li><a class="dropdown-item" href="/seviceCenter">Service
											Center</a></li>
									<li><a class="dropdown-item" href="/m-logout">LogOut</a></li>
								</ul></li>
							<c:choose>
								<c:when test="${principal.user.role eq 'ADMIN'}">
									<li id="more--view"><a href="/admin/manage"
										style="color: #0067a3">Manage</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="/auth/partner/main_partner"
										style="color: #0067a3">Partner?</a></li>
								</c:otherwise>
							</c:choose>


						</c:otherwise>
					</c:choose>
				</ul>
			</nav>
		</header>

		<script>
			$(document).ready(function() {
				console.log(${i});
				if ($("#mes") == 0) {
					$("#temp").css({
						display : none
					})
				}
			});
		</script>