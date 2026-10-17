package com.example.sorapi.domain.routing;

public class RoutingResult {
	
	private final boolean success;
	private final String message;

	public RoutingResult(boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}
	
	
}
