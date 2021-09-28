package it.euris.academy.cinema.exception;

public class IdMustNotBeNull extends RuntimeException {
private static final long serialVersionId = 1L;
	
	public IdMustNotBeNull() { 
		super("Id must not be null. You sent ...");
	}
	
	public IdMustNotBeNull(String message) {
		super(message);
	}
}
