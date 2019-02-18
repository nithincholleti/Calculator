package com.ood.customexceptions;

public class InvalidAgeException extends Exception {
	/*
	 * following class is used to create custom excepions for age.
	 */
	public InvalidAgeException(String errorMessage) {

		super(errorMessage);
	}

}
