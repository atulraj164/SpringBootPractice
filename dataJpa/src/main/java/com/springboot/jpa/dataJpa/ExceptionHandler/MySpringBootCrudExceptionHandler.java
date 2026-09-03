package com.springboot.jpa.dataJpa.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MySpringBootCrudExceptionHandler {
    
	@ExceptionHandler(value=NullPointerException.class)
	public String handleNullPointterException(NullPointerException ex) {
		return "null pointer exception occured: "+ ex.getMessage();
	}
	
	@ExceptionHandler(value=BadIdException.class)
	public ResponseEntity<String> handleBadIdException(BadIdException ex) {
		return  ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(ex.getMessage());
	}
}
