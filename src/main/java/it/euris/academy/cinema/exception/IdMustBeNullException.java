package it.euris.academy.cinema.exception;

public class IdMustBeNullException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public IdMustBeNullException() {
		super("Id must be null");
	}
	
	public IdMustBeNullException(String message) {
		super(message);
	}
}
