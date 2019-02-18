package com.ood.util;

import java.time.LocalDate;

import com.ood.customexceptions.CustomExceptions;
import com.ood.customexceptions.InvalidAgeException;

/**
 * @author nithin
 *
 */
public class Validation {

	/*
	 * Following methods is used to perform sanity check on user input
	 */
	public static boolean validateUserInput(String type, String input) throws CustomExceptions {

		if (type.equalsIgnoreCase(ApplicationConstants.VEHICLETYPE)) {
			VehicleEnum vehicleType = VehicleEnum.valueOf(Integer.valueOf(input));
			if (vehicleType!=null) {
				return true;
			} else {
				throw new CustomExceptions(ApplicationConstants.ERRORMESSAGE);
			}
		}

		if (type.equalsIgnoreCase(ApplicationConstants.DATE)) {
			try {
				LocalDate.parse(input);
				return true;
			} catch (Exception e) {
				throw new CustomExceptions(ApplicationConstants.ERRORMESSAGE);
			}
		}
		
		if (type.equalsIgnoreCase(ApplicationConstants.YESNO)) {
			if (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("N")) {
				return true;
			} else {
				throw new CustomExceptions(ApplicationConstants.ERRORMESSAGE);
			}
		}

		if (type.equalsIgnoreCase(ApplicationConstants.NUMERIC)) {
			if (input.matches("-?\\d+(\\.\\d+)?")) {
				return true;
			} else {
				throw new CustomExceptions(ApplicationConstants.ERRORMESSAGE);
			}
		}

		if (type.equalsIgnoreCase(ApplicationConstants.AGE)) {
			try {
				if (Integer.valueOf(input) >= 18) {
					return true;
				} else {
					throw new InvalidAgeException(ApplicationConstants.ERRORMESSAGEAGE);
				}
			} catch (Exception e) {
				throw new CustomExceptions(ApplicationConstants.ERRORMESSAGEAGE);
			}
		}

		return false;
	}
}
