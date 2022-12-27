package com.threebee.gooslegoosle.dto.kakao.pay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentReqDto {

	private String username;
	private String count;
	private String amount;
	private String itemname;
	private String postcode;
	private String roadAddress;
	private String detailAddress;
}
