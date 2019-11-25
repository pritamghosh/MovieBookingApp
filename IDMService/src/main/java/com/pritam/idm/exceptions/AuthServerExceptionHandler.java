package com.pritam.idm.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class AuthServerExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ApplicationCustomException.class)
	public final ResponseEntity<ErrorResponse> handleApplicationExceptions(ApplicationCustomException ex,
			WebRequest request) {
		ErrorResponse error = ex.getErrorResponse();
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BadCredentialException.class)
	public final ResponseEntity<ErrorResponse> handleApplicationExceptions(BadCredentialException ex,
			WebRequest request) {
		ErrorResponse error = ex.getErrorResponse();
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.UNAUTHORIZED);
	}
}
