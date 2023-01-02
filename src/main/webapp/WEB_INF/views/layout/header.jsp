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
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>


</head>
<body>
	<div id="wrap">
		<header id="header">

			<div id="logo">
				<a href="/"><img src="../images/logo.png" alt=""></a>
			</div>
			<div class="searchBox">
				<button class="searchButton">
					<img src="../images/search.png" alt="">
				</button>
				<input type="text" placeholder="음식 또는 식당명 입력">
			</div>
			<nav id="nav">
				<ul>
					<c:choose>
						<c:when test="${empty principal}">
							<li><a href="/magazine">Magazine</a></li>
							<li><a href="/notice">Notice</a></li>
							<li><a href="#">Review</a></li>
							<li><a href="/auth/login_form">Login</a></li>
							<li><a href="/auth/join_form">Join</a></li>
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${principal.user.role eq 'ADMIN'}">
									<li><a href="/magazine">Magazine</a></li>
									<li><a href="/notice">Notice</a></li>
									<li><a href="#">Review</a></li>
									<li id="more--view"><a href="#">Manage</a>
										<ul id="nave--moreview--item" style="padding-top: 0">
                                    		<li><a class="dropdown-item" href="/admin/manage">Store M</a></li>
                                    		<li><a class="dropdown-item" href="/admin/user">User M</a></li>
                                		</ul> 
									</li>
									<!-- 회원 관리, 점주 관리 -->
									<li><a href="/logout">LogOut</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="/magazine">Magazine</a></li>
									<li><a href="/notice">Notice</a></li>
									<li><a href="#">Review</a></li>
									<li id="more--view"><a href="#">About Me</a>
										<ul id="nave--moreview--item" style="padding-top: 0">
                                    		<li><a class="dropdown-item" href="/user/update">Profile</a></li>
                                    		<li><a class="dropdown-item" href="/user/update">My Review</a></li>
                            				<li><a class="dropdown-item" href="/logout">LogOut</a></li>
                                		</ul> 
									</li>
									<li><a href="/auth/partner/main_partner">Partner?</a></li>
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>
				</ul>
			</nav>
		</header>