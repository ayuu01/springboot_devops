package com.bench.SpringBootDevops.exception;

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = -6874215221854343L;

	private int code;
	private String message;

	public ValidationException(int code, String message) {
		super(message);
		this.setCode(code);
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}