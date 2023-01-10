package com.threebee.gooslegoosle.dto;

import java.math.BigInteger;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ChartMonthDTO {

	private String start;
	private String end;
	private String format;
	private BigInteger count;
	
	public ChartMonthDTO(Object[] obj) {
		this.start = (String)obj[0];
		this.end = (String)obj[1];
		this.count = (BigInteger)obj[3];
	}
}
