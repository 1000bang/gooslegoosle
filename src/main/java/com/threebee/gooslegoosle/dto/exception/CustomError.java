package com.threebee.gooslegoosle.dto.exception;

import lombok.Data;

@Data
public class CustomError {
	
	private String field;
	private String message;

}
