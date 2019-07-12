package com.devpro.spring.model;

public class AjaxResponseBody {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public AjaxResponseBody() {
		super();
	}

	public AjaxResponseBody(String message) {
		super();
		this.message = message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
