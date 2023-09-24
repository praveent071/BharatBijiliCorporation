package com.utilitypayment.BharatBijili.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class CustomExceptionHandler {
	@ExceptionHandler(InsufficientBalanceException.class)
	 public ResponseEntity<Object> handleCustomException(InsufficientBalanceException ex) {
		ErrorResponse errorResponse = new ErrorResponse("400",ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidCardException.class)
	 public ResponseEntity<Object> handleCustomException(InvalidCardException ex) {
		ErrorResponse errorResponse = new ErrorResponse("400",ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CardExpiredException.class)
	 public ResponseEntity<Object> handleCustomException(CardExpiredException ex) {
		ErrorResponse errorResponse = new ErrorResponse("400",ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidWalletException.class)
	 public ResponseEntity<Object> handleCustomException(InvalidWalletException ex) {
		ErrorResponse errorResponse = new ErrorResponse("400",ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	 public ResponseEntity<Object> handleCustomException(CustomerNotFoundException ex) {
		ErrorResponse errorResponse = new ErrorResponse("400",ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}


}
