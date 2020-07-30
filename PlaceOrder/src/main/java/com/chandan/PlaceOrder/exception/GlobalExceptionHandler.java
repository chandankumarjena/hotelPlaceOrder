package com.chandan.PlaceOrder.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleAnyException(
			Exception exception, WebRequest request ){
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(),
				exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> customValidationException(
			MethodArgumentNotValidException exception){
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(),
				"Validation Error", exception.getBindingResult().getFieldError().getDefaultMessage() );
		return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
	}
}
