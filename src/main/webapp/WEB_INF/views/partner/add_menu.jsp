<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/partner_header.jsp"%>
<section id="store-apply">
	<form action="" class="was-validated" id="store-info-bg">
		<input type="hidden" id="id" value="${store.id}">
		<div id="store-info" class="info-box">
			<p class="info-title">메뉴 정보를 입력해주세요 !</p>

			<div class="form-group">
				<label for="menuName">메뉴명</label> <input type="text"
					class="form-control" id="menuName" placeholder="메뉴 이름을 입력해주세요."
					name="menuName" required>
				<div class="valid-feedback">완료 !</div>
				<div class="invalid-feedback">필수 입력 사항입니다.</div>
			</div>
			<div class="form-group">
				<label for="menuPrice">메뉴가격</label> <input type="text"
					class="form-control" id="menuPrice" placeholder="메뉴 가격을 입력해주세요."
					name="menuPrice" required>
				<div class="valid-feedback">완료 !</div>
				<div class="invalid-feedback" >필수 입력 사항입니다.</div>
			</div>
		<div id="menu--box"></div>
		<c:forEach var="menus" items="${menus}">
		<br/>
				<div class="form-group card">
			
				<div class="d-flex justify-content-between align-items-center">
					<div>&nbsp;•&nbsp;
					<a class="card-text m-3">${menus.menuName} </a> ——
					<a class="card-text m-3">${menus.menuPrice}</a>원 
					</div>
					<button class="btn m-3" onclick="index.menuDelete(${menus.id},this)" style="height: 35">❌</button>
				</div>
				</div>
		</c:forEach>
		</div>
		
		
		<div class="input-group d-flex flex-column justify-content-center">
		<div class="d-flex justify-content-center"><button type="button"
			class="btn" style="width:20vh; color: white; background-color: #63BFBC;"
			id="add-store-menu-btn" >메뉴 추가 </button></div>
		</div>
		<br/>
		<div class="d-flex justify-content-center">
		<button type="button"
			class="btn" style="width:20vh; color: white; background-color: #63BFBC;"
			id="add-menu-btn">등록 완료</button></div> 
	</form>


</section>

<script type="text/javascript" src="/js/partner.js"></script>
<%@ include file="../layout/footer.jsp"%>
