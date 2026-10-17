package com.example.sorapi.global.dto;

public class ErrorResponse {
	
	private String code;
	private String message;
	
	public ErrorResponse(String code, String message) {
		this.code = code;
		this.message = message;	
	}
	
	public String getCode() {
		return code;
	}
	
	public String getMessge() {
		return message;
	}
}
