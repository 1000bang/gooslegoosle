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
			class="btn" style="width:20vh; color: white; background-color: #63BFBC;"
			id="add-menu-btn">파트너 홈으로 돌아가기 </button></div> <br/>
				<div class="d-flex justify-content-center">
		<button type="button" onclick="location.href = '/partner/updateStore/${principal.user.id}'; "
			class="btn" style="width:20vh; color: white; background-color: #63BFBC;"
			id="add-menu-btn"> 내 가게 수정하기 </button></div> 
	</form>


</section>

<script type="text/javascript" src="/js/partner.js"></script>
<%@ include file="../layout/footer.jsp"%>
