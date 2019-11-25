package com.pritam.idm.exceptions;

public class ErrorResponse {
	private String errorDetails;
	private String errorCode;
	private String correctiveAction;
	private String likelyCause;
	private Class<? extends Exception> exceptionType;
	public ErrorResponse(String errorDetails, Class<? extends Exception> exceptionType) {
		super();
		this.errorDetails = errorDetails;
		this.exceptionType = exceptionType;
	}
	public Class<? extends Exception> getExceptionType() {
		return exceptionType;
	}
	public void setExceptionType(Class<? extends Exception> exceptionType) {
		this.exceptionType = exceptionType;
	}
	public ErrorResponse(String errorDetails) {
		super();
		this.errorDetails = errorDetails;
	}
	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getErrorDetails() {
		return errorDetails;
	}
	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getCorrectiveAction() {
		return correctiveAction;
	}
	public void setCorrectiveAction(String correctiveAction) {
		this.correctiveAction = correctiveAction;
	}
	public String getLikelyCause() {
		return likelyCause;
	}
	public void setLikelyCause(String likelyCause) {
		this.likelyCause = likelyCause;
	}
}
