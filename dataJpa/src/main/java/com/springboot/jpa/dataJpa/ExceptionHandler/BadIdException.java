package com.springboot.jpa.dataJpa.ExceptionHandler;

public class BadIdException extends RuntimeException{
	
	
	public BadIdException(String msg) {
		super(msg);
	}

	
}
