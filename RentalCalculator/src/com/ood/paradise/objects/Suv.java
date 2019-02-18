package com.ood.paradise.objects;

import java.time.DayOfWeek;
import java.time.temporal.ChronoUnit;

/**
 * @author nithin
 *
 */
public class Suv extends Vehicle {

	private BasePriceForCars midSizeCar;
	/*
	 * This input must come from user.
	 * */
	private boolean isCarTakenOffRoad;

	public void setCarTakenOffRoad(boolean isCarTakenOffRoad) {
		this.isCarTakenOffRoad = isCarTakenOffRoad;
	}

	private float additionalCost;

	public Suv(float inputPremiumPercentage, BasePriceForCars car, float inputAdditionalCost) {
		this.midSizeCar = car;
		this.permiumCostPercentage = inputPremiumPercentage;
		this.additionalCost = inputAdditionalCost;
		this.type = "Suv";
		calculatePerDayRate();
	}

	@Override
	public void calculatePerDayRate() {

		this.baseRate = midSizeCar.getBaseRate()
				+ (midSizeCar.getBaseRate() * ((float) permiumCostPercentage / (float) 100));

		this.premiumDayRate = midSizeCar.getPremiumDayRate()
				+ (midSizeCar.getPremiumDayRate() * ((float) permiumCostPercentage / (float) 100));

		this.discountDayRate = midSizeCar.getDiscountDayRate()
				+ (midSizeCar.getDiscountDayRate() * ((float) permiumCostPercentage / (float) 100));

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

		if (isCarTakenOffRoad) {
			total = total + additionalCost;
		}

		this.totalAmountForDates = total;
	}

}
