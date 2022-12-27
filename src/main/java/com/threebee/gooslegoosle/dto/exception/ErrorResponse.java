package com.threebee.gooslegoosle.dto.exception;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {

	
	private String statusCode;
	private String requestUri;
	private int code;
	private String message;
	private String resultCode;
	private List<CustomError> errorList;
	
}
