package com.threebee.gooslegoosle.dto.kakao.pay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentReqDto {
 
	private String storeName;
	private String username;
	private String headCount;
	private String date;
	private String time;
	private String deposit;
}
