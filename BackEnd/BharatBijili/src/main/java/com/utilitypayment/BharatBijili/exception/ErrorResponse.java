package com.utilitypayment.BharatBijili.exception;

public class ErrorResponse {
	private String errorNumber;
    private String errorMessage;
	
	public ErrorResponse(String errorNumber, String errorMessage) {
		super();
		this.errorNumber = errorNumber;
		this.errorMessage = errorMessage;
	}
	public ErrorResponse() {
		super();
	}
	public String getErrorNumber() {
		return errorNumber;
	}
	public void setErrorNumber(String errorNumber) {
		this.errorNumber = errorNumber;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
    
    

}
