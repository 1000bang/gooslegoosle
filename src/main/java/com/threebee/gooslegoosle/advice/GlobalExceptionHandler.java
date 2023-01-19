package com.threebee.gooslegoosle.advice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public void exception(Exception e) {

		System.out.println(">>>>>>Error<<<<<<<<");
		System.out.println(e.getClass().getName());
		System.out.println(e.getLocalizedMessage());
		System.out.println(">>>>>>Error<<<<<<<<");

		// return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e, BindingResult result) {
		List<String> error = new ArrayList<>();
		result.getAllErrors().forEach((item)->{	
			error.add(item.getDefaultMessage());
		});
		

		 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}
	
	
	
	/*
	 * IllegalArgumentException MethodArgumentNotValidException
	 * HttpRequestMethodNotSupportedException
	 * SQLIntegrityConstraintViolationException unexpectedRollbackException
	 */

//
//	@ExceptionHandler(value = ConstraintViolationException.class)
//	public ResponseEntity<?> constraintViolationException(ConstraintViolationException e, BindingResult br) {
//		System.out.println("11111111111111111111");
//		br.getAllErrors().forEach( item -> {
//			System.out.println(">>>>>>Error<<<<<<<<");
//			System.out.println(item.getObjectName());
//			System.out.println(item.getDefaultMessage());
//			System.out.println(">>>>>>Error<<<<<<<<");
//		});
//		
//		System.out.println(e.getClass().getName());
//		System.out.println(e.getLocalizedMessage());
//		
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage().toString());
//		
//	}
////
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
