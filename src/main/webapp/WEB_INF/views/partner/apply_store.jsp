<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/partner_header.jsp"%>
    <section id="store-apply">
        <form action="" class="was-validated" id="store-info-bg">
        <input type="hidden" id="id" value="${store.id}">
            <div id="store-info" class="info-box">
                <p class="info-title">가게 영업 정보를 입력해주세요 !</p>
                <div class="form-group">
                    <label for="storename">가게 상호명</label>
                    <input type="text" class="form-control" id="storename" placeholder="가게 상호명을 입력해주세요."
                        name="storename" required>
                    <div class="valid-feedback">완료 ! </div>
                    <div class="invalid-feedback">필수 입력 사항입니다.</div>
                </div>
                <div class="form-group">
                    <label for="category">카테고리</label>
                    <select class="form-control" id="category_select" name="category_select">
                        <option value = "KOREAN" id = "01">한식</option>
                        <option value = "JAPANESE" id = "02">일식</option>
                        <option value = "CHINESE" id = "03">중식</option>
                        <option value = "WESTERN" id = "04">양식</option>
                        <option value="">카페</option>
                    </select>
                </div>

                <div class="form-group" id="store-item">
                    <p class="time">가게 영업시간</p>

                    <div class="time-form-wrap">
                        <input type="text" class="form-control" id="opentime" placeholder="OpenTime" name="opentime"
                            required>
                        <div class="valid-feedback">완료 ! </div>
                        <div class="invalid-feedback">필수 입력 사항입니다.</div>
                    </div>
                    
                    <div class="time-form-wrap">
                        <input type="text" class="form-control" id="closetime" placeholder="Closetime" name="closetime"
                            required>
                        <div class="valid-feedback">완료 ! </div>
                        <div class="invalid-feedback">필수 입력 사항입니다.</div>
                    </div>

                    <div class="time-form-wrap">
                    <input type="text" class="form-control" id="breaktime" placeholder="BreakTime" name="breaktime">
                    </div>
                   
                </div>

                <div class="form-group">
                    <label for="mainnumber" id="main">가게 대표 전화</label>
                    <input type="text" class="form-control" id="mainnumber" placeholder="가게 대표 전화를 입력해주세요."
                        name="mainnumber" required>
                    <div class="valid-feedback">완료 ! </div>
                    <div class="invalid-feedback">필수 입력 사항입니다.</div>
                </div>

		</div>
        </form>
        <button type="button" class="btn btn-primary d-flex justify-content-center" id="partner-btn">다음 (메뉴 등록)</button>
    </section>
    
    <script type="text/javascript" src="/js/partner.js"></script>
<%@ include file="../layout/footer.jsp"%>
