package com.pritam.idm.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ApplicationCustomException extends RuntimeException {
	/**
	 * serialVersionUID. 
	 */
	private static final long serialVersionUID = 3953002176967072469L;
	/**
	 * errorResponse. 
	 */
	private ErrorResponse errorResponse;
	
	public ApplicationCustomException(ErrorResponse errorResponse) {
		super();
		this.errorResponse = errorResponse;
	}


	public ApplicationCustomException() {
		super();
	}

	public ErrorResponse getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse(ErrorResponse errorResponse) {
		this.errorResponse = errorResponse;
	}

	public ApplicationCustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ApplicationCustomException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApplicationCustomException(String message) {
		super(message);
		this.errorResponse = new ErrorResponse(message,this.getClass());
	}

	public ApplicationCustomException(Throwable cause) {
		super(cause);
	}


}
