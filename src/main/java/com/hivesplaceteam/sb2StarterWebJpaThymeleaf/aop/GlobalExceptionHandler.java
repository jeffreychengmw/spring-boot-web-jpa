package com.hivesplaceteam.sb2StarterWebJpaThymeleaf.aop;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hivesplaceteam.sb2StarterWebJpaThymeleaf.exception.ErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ServletRequestBindingException.class)
	public ResponseEntity<?> servletRequestBindingException(ServletRequestBindingException e) {
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setErrorCode(HttpStatus.BAD_REQUEST.toString());
		List<String> errorMessage = new ArrayList<String>();
		errorMessage.add(e.getMessage());
		errorDetails.setErrorMessage(errorMessage);
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> resourceNotFoundException(RuntimeException e) {
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setErrorCode(HttpStatus.NOT_FOUND.toString());
		List<String> errorMessage = new ArrayList<String>();
		errorMessage.add(e.getMessage());
		errorDetails.setErrorMessage(errorMessage);
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	/******************************
	 **** Make this ExceptionHandler as the last method
	 ******************************/
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exception(Exception e) {
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		List<String> errorMessage = new ArrayList<String>();
		errorMessage.add(e.getMessage());
		errorDetails.setErrorMessage(errorMessage);
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
