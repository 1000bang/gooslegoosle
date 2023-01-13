package com.threebee.gooslegoosle.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.threebee.gooslegoosle.auth.PrincipalDetail;
import com.threebee.gooslegoosle.dto.ResponseDto;
import com.threebee.gooslegoosle.dto.kakao.pay.PaymentReqDto;
import com.threebee.gooslegoosle.dto.kakao.pay.PaymentResDto;
import com.threebee.gooslegoosle.entity.ReservationEntity;
import com.threebee.gooslegoosle.entity.ReviewEntity;
import com.threebee.gooslegoosle.entity.StoreEntity;
import com.threebee.gooslegoosle.service.PartnerService;
import com.threebee.gooslegoosle.service.ReservationService;
import com.threebee.gooslegoosle.service.ReviewService;
import com.threebee.gooslegoosle.service.StoreService;

@Controller
public class StoreController {

	@Autowired
	private	StoreService storeService;
	
	@Autowired
	private PartnerService partnerService;
	
	@Autowired
	private ReviewService reviewService;
	
	private String tid;
	
	private PaymentReqDto paymentReqDto;
	
	@GetMapping("/store/{id}")
	public String fetchIndex(Model model, @PathVariable int id, 
			@PageableDefault(size = 3, sort = "id", direction = Direction.DESC) Pageable pageable) {
		
		StoreEntity detail = storeService.findStoreDetailByStoreId(id);
	
		Page<ReviewEntity> storeReview = reviewService.getStoreReviewList(id, pageable);
		int nowPage = storeReview.getPageable().getPageNumber() + 1;
		int startPageNumber = Math.max(nowPage - 2, 1);
		int endPageNumber = Math.min(nowPage + 2, storeReview.getTotalPages());
		int end = storeReview.getTotalPages() - 1;

		ArrayList<Integer> pageNumbers = new ArrayList<>();
		for (int i = startPageNumber; i <= endPageNumber; i++) {
			pageNumbers.add(i);
		}
		model.addAttribute("pageNumbers", pageNumbers);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", 0);
		model.addAttribute("endPage", end);
		model.addAttribute("review",storeReview);
		model.addAttribute("storeDetail",detail);
		return "/store/detail";
	}
	
	@GetMapping("/store/reservation/{id}")
	public String fetchReserve(Model model, @PathVariable int id) {
		
		StoreEntity detail = storeService.findStoreDetailByStoreId(id);
		
		model.addAttribute("storeDetail",detail);
		return "/store/reservation";
	}
	
	@GetMapping("/store/all")
	public String fetchAllStore(Model model, @PageableDefault(size = 6, sort = "id", direction = Direction.DESC) Pageable pageable) {
		Page<StoreEntity> store = storeService.findAll(pageable);
		
		int nowPage = store.getPageable().getPageNumber() + 1;
		int startPageNumber = Math.max(nowPage - 2, 1);
		int endPageNumber = Math.min(nowPage + 2, store.getTotalPages());
		int end = store.getTotalPages() - 1;

		ArrayList<Integer> pageNumbers = new ArrayList<>();
		for (int i = startPageNumber; i <= endPageNumber; i++) {
			pageNumbers.add(i);
		}
		model.addAttribute("pageNumbers", pageNumbers);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", 0);
		model.addAttribute("endPage", end);
		model.addAttribute("store",store);
		return "/store/all_store";
	}
	
	@Autowired
	private ReservationService reservationService;
	
	
	private ReservationEntity resData;
	
	private PaymentReqDto reqDto;
	
	
	@PostMapping("/store/reservation/{id}/save")
	@ResponseBody
	public ResponseDto<Integer> fetchSaveReserve(@RequestBody ReservationEntity res, @PathVariable int id, @AuthenticationPrincipal PrincipalDetail detail) {
		StoreEntity store = storeService.findStoreDetailByStoreId(id);
		res.setStore(store);
		resData = res;
		//reservationService.saveReservation(resData detail.getUser()); 카카오결제 후에 사용 Reservation DB에 Insert!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		return new ResponseDto<Integer>(HttpStatus.OK, 1);
	}
	
	@GetMapping("/store/reservation/{id}/reservation_next")
	public String reservationNext(Model model, @PathVariable int id, @AuthenticationPrincipal PrincipalDetail detail) {
		
		
		//ReservationEntity reservationEntity = reservationService.findid(detail.getUser().getId()); 위에 insert 후에 영수증 느낌으로 뿌려줄 때 사용
		model.addAttribute("reservationDetail", resData);

		return "/store/reservation_next";
	}
	
	@GetMapping("/store/reservation/pay/fail")
	public String payFail() {
		return "/store/reservation_pay_fail";
	}
	
	@PostMapping("/pay/ready")
	@ResponseBody
	public ResponseDto<PaymentResDto> readyForPay(@RequestBody PaymentReqDto reqData){
		RestTemplate rt = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		
		headers.add("Authorization", "KakaoAK 11f4787a3e20f1290090dbe6f4969397");
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("cid", "TC0ONETIME");
		params.add("partner_order_id", "1212121212"); // <-- 주문 번호가 없음.ㅠ
		params.add("partner_user_id", reqData.getUsername());
		params.add("item_name", reqData.getStoreName());
		params.add("quantity", "1");
		params.add("total_amount", "20000");
		params.add("tax_free_amount", "0");
		params.add("approval_url", "http://localhost:9090/pay/success");
		params.add("cancel_url", "http://localhost:9090/store/reservation/pay/fail");
		params.add("fail_url", "http://localhost:9090/store/reservation/pay/fail");
		
		HttpEntity<MultiValueMap<String, String>> reqPayment = new HttpEntity<>(params,headers);
		
		// 헤더를 변조해서 넣는 코드
		ResponseEntity<PaymentResDto> response = rt.exchange("https://kapi.kakao.com/v1/payment/ready", HttpMethod.POST,
				reqPayment, PaymentResDto.class);
		tid = response.getBody().tid;
		paymentReqDto = reqData;
		
		return new ResponseDto<PaymentResDto>(HttpStatus.OK, response.getBody());
	}

	
	//////////////////////////SUCCESS APPROVAL/////////////////////////////////
	@GetMapping("/pay/success")
	public String payCompleted(@RequestParam("pg_token") String pgToken, Model model, @AuthenticationPrincipal PrincipalDetail principalDetail) {
		RestTemplate rt = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		
		headers.add("Authorization", "KakaoAK 11f4787a3e20f1290090dbe6f4969397");
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("cid", "TC0ONETIME");
		params.add("tid", tid);
		params.add("partner_order_id", "1212121212"); // <-- 주문 번호가 없음.ㅠ
		params.add("partner_user_id", paymentReqDto.getUsername());
		params.add("pg_token", pgToken);
		
		HttpEntity<MultiValueMap<String, String>> reqPayment = new HttpEntity<>(params,headers);
		
		// 헤더를 변조해서 넣는 코드
		ResponseEntity<PaymentResDto> response = rt.exchange("https://kapi.kakao.com/v1/payment/approve", HttpMethod.POST,
				reqPayment, PaymentResDto.class);
//		tid = response.getBody().tid;
                                                                                                                                                                         
				
	

		reservationService.saveReservation(resData, principalDetail.getUser(), tid); 
		
		model.addAttribute("reservationDetail", resData);
		model.addAttribute("response", response);

		return "/store/reservation_pay_success";
	}
	
}
