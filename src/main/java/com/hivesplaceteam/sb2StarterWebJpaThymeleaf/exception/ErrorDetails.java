package com.hivesplaceteam.sb2StarterWebJpaThymeleaf.exception;

public class ErrorDetails {

	//equal to HttpStatus Code if else defined
	private String errorCode;
	private String errorMessage;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	@Override
	public String toString() {
		return "ErrorDetails [errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
	}

}
