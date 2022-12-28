<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/partner_header.jsp"%>
    <section id="store-apply">
        <form action="" class="was-validated" id="store-info-bg">
        <input type="hidden" id="id" value="${store.id}">
            <div id="store-info" class="info-box">
                <p class="info-title">메뉴 정보를 입력해주세요 !</p>
                <div class="form-group">
                    <label for="menuname">메뉴명</label>
                    <input type="text" class="form-control" id="menuname" placeholder="메뉴 이름을 입력해주세요."
                        name="menuname" required>
                    <div class="valid-feedback">완료 ! </div>
                    <div class="invalid-feedback">필수 입력 사항입니다.</div>
                </div>
                <div class="form-group">
                    <label for="menuprice">메뉴가격</label>
                    <input type="text" class="form-control" id="menuprice" placeholder="메뉴 가격을 입력해주세요."
                        name="menuprice" required>
                    <div class="valid-feedback">완료 ! </div>
                    <div class="invalid-feedback">필수 입력 사항입니다.</div>
                </div>
                <!-- <div class="form-group">
                    <label for="storename">메뉴사진</label>
                    <input type="text" class="form-control" id="storename" placeholder="가게 상호명을 입력해주세요."
                        name="storename" required>
                    <div class="valid-feedback">완료 ! </div>
                    <div class="invalid-feedback">필수 입력 사항입니다.</div>
                </div>
                <div class="form-group">
                    <label for="storename">메뉴설명</label>
                    <input type="text" class="form-control" id="storename" placeholder="가게 상호명을 입력해주세요."
                        name="storename" required>
                    <div class="valid-feedback">완료 ! </div>
                    <div class="invalid-feedback">필수 입력 사항입니다.</div>
                </div> -->
            </div>
        </form>
        <button type="button" class="btn btn-primary d-flex justify-content-center" id="apply-store-btn">가게 등록하기</button>
    </section>
    
    <script type="text/javascript" src="/js/partner.js"></script>
<%@ include file="../layout/footer.jsp"%>
