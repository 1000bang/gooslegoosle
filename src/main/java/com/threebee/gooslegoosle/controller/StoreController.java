package com.threebee.gooslegoosle.controller;

import org.springframework.data.domain.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threebee.gooslegoosle.auth.PrincipalDetail;
import com.threebee.gooslegoosle.dto.ResponseDto;
import com.threebee.gooslegoosle.dto.StoreFileDTO;
import com.threebee.gooslegoosle.entity.MenuEntity;
import com.threebee.gooslegoosle.entity.PartnerEntity;
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
	
	@GetMapping("/store/{id}")
	public String fetchIndex(Model model, @PathVariable int id, 
			@PageableDefault(size = 3, sort = "id", direction = Direction.DESC) Pageable pageable) {
		
		StoreEntity detail = storeService.findStoreDetailByStoreId(id);
	
		Page<ReviewEntity> storeReview = reviewService.getStoreReviewList(id, pageable);
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
	
	@Autowired
	private ReservationService reservationService;
	
	
	private ReservationEntity resData;
	
	
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

	
	//////////////////////////SUCCESS APPROVAL/////////////////////////////////
	@GetMapping("/pay/success")
	public String payCompleted(@RequestParam("pg_token") String pgToken, Model model) {
		System.out.println("성공???????");
		
		// 카카오 결재 요청하기
//		ApproveRes approve = paymentService.payApprove(tid, pgToken, dtoData);	
//		
//		ApproveRes payment = ApproveRes.builder()
//				.partnerUserId(approve.getPartnerUserId())
//				.quantity(approve.getQuantity())
//				.amount(approve.getAmount())
//				.itemName(approve.getItemName())
//				.approvedAt(approve.getApprovedAt())
//				.amount(approve.getAmount())
//				.paymentMethodType(approve.getPaymentMethodType())
//				.build();
				
	
		//reservationService.saveReservation(resData detail.getUser()); 
		return "item/success";
	}
	
}
