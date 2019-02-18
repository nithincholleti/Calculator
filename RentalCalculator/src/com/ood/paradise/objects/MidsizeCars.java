/**
 * 
 */
package com.ood.paradise.objects;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @author nithin
 *
 */
public class MidsizeCars extends Vehicle {

	public MidsizeCars(float inputBaseRate, float inputPremiumPercentage, float inputDiscountPercentage) {
		this.baseRate = inputBaseRate;
		this.permiumCostPercentage = inputPremiumPercentage;
		this.discountCostPercentage = inputDiscountPercentage;
		this.type = "MidsizeCar";
		calculatePerDayRate();
	}

	@Override
	public void calculatePerDayRate() {
		premiumDayRate = baseRate + (baseRate * ((float) permiumCostPercentage / (float) 100));
		discountDayRate = baseRate - (baseRate * ((float) discountCostPercentage / (float) 100));
	}

	@Override
	public void calculateTotalAmount() {

		// calculating number of days in between
		float totalNoOfDays = (float) ChronoUnit.DAYS.between(startDate, endDate) + 1;
		
		float noOfPremiumDays = countDaysOfWeek(startDate, endDate, DayOfWeek.FRIDAY)
								+ countDaysOfWeek(startDate, endDate, DayOfWeek.SATURDAY);
		
		float noOfDiscountDays = countDaysOfWeek(startDate, endDate, DayOfWeek.SUNDAY);
		
		float normalDays = totalNoOfDays - noOfDiscountDays - noOfPremiumDays;

		float total = (normalDays * baseRate) + (noOfPremiumDays * premiumDayRate)
				+ (noOfDiscountDays * discountDayRate);

		this.totalAmountForDates = total;

	}

}
