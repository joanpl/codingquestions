package com.jlo.coding.exception;

public class ProblemInputException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5655665894770119124L;

	public ProblemInputException() {
		super("Problem input exception - invalid");
	}

	public ProblemInputException(String string) {
		super(string);
	}

	
}
