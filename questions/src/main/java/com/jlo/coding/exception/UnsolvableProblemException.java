package com.jlo.coding.exception;

public class UnsolvableProblemException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5655665894770119124L;

	public UnsolvableProblemException() {
		super("No Solution for the Problem");
	}

	public UnsolvableProblemException(String string) {
		super(string);
	}

	
}
