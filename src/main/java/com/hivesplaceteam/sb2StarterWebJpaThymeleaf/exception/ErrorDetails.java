package com.hivesplaceteam.sb2StarterWebJpaThymeleaf.exception;

import java.util.ArrayList;
import java.util.List;

public class ErrorDetails {

	//equal to HttpStatus Code if else defined
	private String errorCode;
	private List<?> errorMessage = new ArrayList<>();
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public List<?> getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(List<?> errorMessage) {
		this.errorMessage = errorMessage;
	}
	@Override
	public String toString() {
		return "ErrorDetails [errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
	}

}
