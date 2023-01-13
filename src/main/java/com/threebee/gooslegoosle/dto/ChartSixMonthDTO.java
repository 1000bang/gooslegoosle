package com.threebee.gooslegoosle.dto;

import java.math.BigInteger;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ChartSixMonthDTO {

	private Integer month;
	private BigInteger count;
	
	public ChartSixMonthDTO(Object[] obj) {
	
		this.month = (Integer)obj[0];
		this.count = (BigInteger)obj[1];
			
	}
}
