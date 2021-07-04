package com.backend.challenge.exception;

public class ValidarSenhaException extends Exception {

	private static final long serialVersionUID = 2026395529966277822L;
	
	public ValidarSenhaException(String errorMessage) {
		super(errorMessage);
	}

}
