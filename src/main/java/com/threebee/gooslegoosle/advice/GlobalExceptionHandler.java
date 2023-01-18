package com.threebee.gooslegoosle.advice;



import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import com.threebee.gooslegoosle.dto.exception.CustomError;
import com.threebee.gooslegoosle.dto.exception.ErrorResponse;




@RestControllerAdvice
public class GlobalExceptionHandler {

	
	/*
	 * private String statusCode;
private String requestUri;
private int code;
private String message;
private String resultCode;
private List<CustomError> errorList;
	 * 
	 */
	

public ResponseEntity<?> exception(Exception e) {
		
		System.out.println("--------------");
		System.out.println(e.getClass().getName());
		System.out.println(e.getLocalizedMessage());
		System.out.println("--------------");
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
	}
	

/*
 * IllegalArgumentException
 * MethodArgumentNotValidException
 * HttpRequestMethodNotSupportedException
 * SQLIntegrityConstraintViolationException
 * unexpectedRollbackException
 */


//	@ExceptionHandler(value = IllegalArgumentException.class)
//	public String illegalArgumentException(IllegalArgumentException e) {
//		return "<h1>" + e.getMessage() + "</h1>";
//		
//	}
//
//	@ExceptionHandler(value = MethodArgumentNotValidException.class)
//	public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e) {
//		
//		System.out.println("MethodArgumentNotValidException");
//		
//		List<CustomError> eList = new ArrayList<>();
//		BindingResult bindingResult = e.getBindingResult();
//		bindingResult.getAllErrors().forEach(action -> {
//			FieldError fieldError = (FieldError) action;
//			String fieldName = fieldError.getField();
//			String message = fieldError.getDefaultMessage();
//			CustomError customError = new CustomError();
//			customError.setField(fieldName);
//			customError.setMessage(message);
//			eList.add(customError);		
//		});
//		
//		//Todo
//		//error Response s는 추후처리 
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(eList);
//		
//	}
//	@ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
//	public ResponseEntity httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
//		
//		System.out.println("HttpRequestMethodNotSupportedException:");
//		
//		ErrorResponse errorResponse = ErrorResponse
//				.builder()
//				.statusCode(HttpStatus.BAD_REQUEST.toString())
//				.code(HttpStatus.BAD_REQUEST.value())
//				.message(e.getMessage())
//				.build();
//
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
//		
//	}
//	
//	
//	@ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
//	public ResponseEntity<ErrorResponse> sQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e) {
//		
//		ErrorResponse errorResponse = ErrorResponse
//				.builder()
//				.statusCode(HttpStatus.BAD_REQUEST.toString())
//				.code(HttpStatus.BAD_REQUEST.value())
//				.message("동일한 아이디가 존재합니다. ")
//				.build();
//		//return new ResponseEntity<ErrorResponse>)(HttpStatus.BAD_REQUEST, errorResponse);
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
//	}
//	
//	
//	@ExceptionHandler(value = UnexpectedRollbackException.class)
//	public ResponseEntity unexpectedRollbackException(UnexpectedRollbackException e) {
//		
//		System.out.println("UnexpectedRollbackException");
//		
//		ErrorResponse errorResponse = ErrorResponse
//				.builder()
//				.statusCode(HttpStatus.BAD_REQUEST.toString())
//				.code(HttpStatus.BAD_REQUEST.value())
//				.message("동일한 아이디가 존재합니다. ")
//				.build();
//
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
//		
//	}


}
