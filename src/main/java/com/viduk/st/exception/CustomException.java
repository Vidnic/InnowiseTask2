package com.viduk.st.exception;

public class CustomException extends Exception {
	private static final long serialVersionUID = 6271888703433909785L;

	public CustomException() {
		super();
	}
	public CustomException(String message) {
		super(message);
	}
	public CustomException(String message, Throwable cause) {
    super(message, cause);
}
}
