<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/partner_header.jsp"%>
<section id="store-apply">
	<form action="" id="store-info-bg">
		
		<div class="d-flex ">
		<img alt="" src="/images/logo2.png" style="width: 12vh; height: 10vh">
		
		</div>
		<h2 style="text-align: center">이미 가게를 등록하셨습니다. </h2>
		
		<br/><br/>
		<div class="d-flex justify-content-center">
		<button type="button" onclick="location.href = '/auth/partner/main_partner'; "
			class="btn" style="width:25vh; color: white; background-color: #63BFBC;"
			id="add-menu-btn">파트너 홈으로 돌아가기 </button></div> <br/>
				<div class="d-flex justify-content-center">
		<button type="button" onclick="location.href = '/partner/updateStore/${principal.user.id}'; "
			class="btn" style="width:25vh; color: white; background-color: #63BFBC;"
			id="add-menu-btn"> 내 가게 수정하기 </button></div> 
	</form>


</section>

<footer id="footer" style="position: absolute;
    top: 85%;">
	<div class="footer-line">
		<div id="endLogo">
			<a href=""><img src="/images/logo2.png" alt=""></a>
		</div>
		<div id="endAbout">
			<ul class="aboutUl">
				<li><a href="#">이용약관&nbsp;&nbsp; </a></li>
				<li><a href="#">이메일주소 무단수집거부&nbsp;&nbsp; </a></li>
				<li><a href="#">개인정보처리방침&nbsp;&nbsp; </a></li>
			</ul>
			<div class="address">
				<address>서울특별시 성동구 고산자로 130 4층(응봉동,지오빌딩) 대표전화 :
					02-2282-2022 이메일 : tjdqls2s@naver.com</address>
			</div>
		</div>
		<div id="endSNS">
		<!-- 손 이미지 -->
			<img src="/images/sns.png" alt="">
			<div>
				<p>Click ↓</p>
				<a class="instagram" href="https://www.instagram.com/bin__starr/" style="display: block">
					<img src="/images/insta.png" alt="" >
				</a>
			</div>
		</div>
	</div>
</footer>
</div>
</body>
</html>

<script type="text/javascript" src="/js/partner.js"></script>
