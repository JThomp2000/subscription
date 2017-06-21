package com.jt.subscription.model;

public class ErrorMessage {
	private String errorMessage;
	
	public ErrorMessage() 
	{
		
	}
		
	public ErrorMessage(String errorMessage) 
	{
		super();
		this.errorMessage = errorMessage;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}	
}
