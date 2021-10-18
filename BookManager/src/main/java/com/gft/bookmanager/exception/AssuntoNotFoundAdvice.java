package com.gft.bookmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AssuntoNotFoundAdvice {
	
	@ResponseBody
	@ExceptionHandler(AssuntoNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String autorNotFoundHandler(AssuntoNotFoundException ex) {
		return ex.getMessage();
	}
}
