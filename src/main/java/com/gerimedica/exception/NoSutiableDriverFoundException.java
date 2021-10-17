package com.gerimedica.exception;

public class NoSutiableDriverFoundException extends RuntimeException {
	

	private static final long serialVersionUID = 1L;

	/**
	 * exception is called when noDriver is found with the message passed
	 * @param message
	 */
	public NoSutiableDriverFoundException(String message) {
		super(message);
	}

	/**
	 * exception is called when noDriver is found
	 */
	public NoSutiableDriverFoundException(){
		this("");
	}

}
