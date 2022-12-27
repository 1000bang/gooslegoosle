package com.threebee.gooslegoosle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PartnerDTO {

	private String username;
	private String phonenumber;
	private String email;
	private int postcode;
	private String password;
	private String storeName;
	private String address;
	private String mainnumber;
	
}
