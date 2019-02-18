package com.ood.paradise.objects;

import java.time.DayOfWeek;
import java.time.temporal.ChronoUnit;

/**
 * @author nithin
 *
 */
public class EconomyCars extends Vehicle {

	private BasePriceForCars midSizeCar;

	public EconomyCars(float inputDiscountPercentage, BasePriceForCars base) {
		this.midSizeCar = base;
		this.discountCostPercentage = inputDiscountPercentage;
		this.type = "EconomyCar";
		calculatePerDayRate();
	}

	@Override
	public void calculatePerDayRate() {
		this.baseRate = midSizeCar.getBaseRate()
				- (midSizeCar.getBaseRate() * ((float) discountCostPercentage / (float) 100));

		this.premiumDayRate = midSizeCar.getPremiumDayRate()
				- (midSizeCar.getPremiumDayRate() * ((float) discountCostPercentage / (float) 100));

		this.discountDayRate = midSizeCar.getDiscountDayRate()
				- (midSizeCar.getDiscountDayRate() * ((float) discountCostPercentage / (float) 100));
	}
	
	@Override
	public void calculateTotalAmount() {
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
