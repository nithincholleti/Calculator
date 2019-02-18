package com.ood.util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.ood.customexceptions.CustomExceptions;
import com.ood.customexceptions.DayLimitException;
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
			if (vehicleType != null) {
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

	public static boolean validateUserInputDates(String type, String startDate, String endDate)
			throws DayLimitException {
		if (type.equalsIgnoreCase(ApplicationConstants.DAYLIMIT)) {
			float totalNoOfDays = (float) ChronoUnit.DAYS.between(LocalDate.parse(startDate), LocalDate.parse(endDate)) + 1;
			if (totalNoOfDays > 14) {
				throw new DayLimitException(ApplicationConstants.ERRORMEDATES);
			} else if (totalNoOfDays < 0) {
				throw new DayLimitException(ApplicationConstants.ERRORMEDAY);
			}
		}
		return true;
	}
}
