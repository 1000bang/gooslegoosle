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




</head>
<body>
	<div id="wrap">
		<header id="header" class="main_header">

			<div id="logo" style="width: 160px; padding-top: 3%;">
				<a href="/admin/manage" style="text-decoration: none"><h2 style="font-family: cursive; font-weight: bold; ">구슬구슬M</h2></a>
			</div>

			<nav id="nav">
				<ul>
					<li><a href="/admin/manage">Store M</a></li>
					<li id="more--view"><a href="/admin/manage">User M</a>
						<ul id="nave--moreview--item" style="padding-top: 0">
							<li><a class="dropdown-item" href="/admin/user">Management</a></li></li>
							<li><a class="dropdown-item" href="/admin/message">Message</a></li>
						</ul>
					
					
					
					<li><a href="/admin/seviceCenter">Service</a></li>
					<li><a href="/admin/statics" style="color: #0067a3">Statics</a></li>
					<li><a href="/logout">LogOut</a></li>
				</ul>
			</nav>
		</header>