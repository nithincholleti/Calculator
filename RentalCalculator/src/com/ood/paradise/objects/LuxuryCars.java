package com.ood.paradise.objects;

import java.time.DayOfWeek;
import java.time.temporal.ChronoUnit;

import com.ood.util.VehicleEnum;

/**
 * @author nithin
 *
 */

public class LuxuryCars extends Vehicle {
	private BasePriceForCars midSizeCar;

	public LuxuryCars(BasePriceForCars car, float inputPremiumPercentage) {
		this.midSizeCar = car;
		this.permiumCostPercentage = inputPremiumPercentage;
		this.type = VehicleEnum.LUXURYCAR;
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

		this.totalAmountForDates = total;
	}

}
