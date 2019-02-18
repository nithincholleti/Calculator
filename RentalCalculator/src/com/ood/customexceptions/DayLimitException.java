package com.ood.customexceptions;

public class DayLimitException extends Exception {
/*
 * following class is used to create custom excepions.
 */
	public DayLimitException(String errorMessage) {

		super(errorMessage);
	}

}
