package com.ood.paradise.objects;

import java.time.DayOfWeek;
import java.time.temporal.ChronoUnit;

import com.ood.util.VehicleEnum;

/**
 * @author nithin
 *
 */
public class Limousines extends Vehicle {

	private float flatRate;
	private float champagneServiceCost;
	private float premiumDayChampagneServiceCost;
	private float driverCost;
	private float premiumDayDriverCost;
	/*
	 * These inputs must come from the user.
	 */
	private boolean isDriverIncluded;
	private boolean isChampagneIncluded;

	public void setDriverIncluded(boolean isDriverIncluded) {
		this.isDriverIncluded = isDriverIncluded;
	}

	public void setChampagneIncluded(boolean isChampagneIncluded) {
		this.isChampagneIncluded = isChampagneIncluded;
	}

	public Limousines(float inputBaseRate, float inputPremiumPercentage, float inputFlatRate, float inDriverCost,
			float inChampagneServiceCost) {
		this.baseRate = inputBaseRate;
		this.permiumCostPercentage = inputPremiumPercentage;
		this.flatRate = inputFlatRate;
		this.champagneServiceCost = inChampagneServiceCost;
		this.driverCost = inDriverCost;
		this.type = VehicleEnum.LIMOUSINE;
		calculatePerDayRate();
	}

	@Override
	public void calculatePerDayRate() {
		premiumDayRate = baseRate + (baseRate * ((float) permiumCostPercentage / (float) 100));
		premiumDayDriverCost = driverCost + (driverCost * ((float) permiumCostPercentage / (float) 100));
		premiumDayChampagneServiceCost = champagneServiceCost + (champagneServiceCost * ((float) permiumCostPercentage / (float) 100));
		discountDayRate = flatRate;
	}

	@Override
	public void calculateTotalAmount() {

		float totalDriverCost = 0;
		float totalChampagneServiceCost = 0;

		float totalNoOfDays = (float) ChronoUnit.DAYS.between(startDate, endDate) + 1;

		float noOfPremiumDays = countDaysOfWeek(startDate, endDate, DayOfWeek.FRIDAY)
				+ countDaysOfWeek(startDate, endDate, DayOfWeek.SATURDAY);

		float noOfDiscountDays = countDaysOfWeek(startDate, endDate, DayOfWeek.SUNDAY);

		float normalDays = totalNoOfDays - noOfDiscountDays - noOfPremiumDays;

		/*
		 * Limo with driver
		 */
		if (isDriverIncluded) {
			float costForNormalDaysDr = driverCost * normalDays;
			float costForPremiumDaysDr = premiumDayDriverCost * noOfPremiumDays;
			totalDriverCost = costForNormalDaysDr + costForPremiumDaysDr;
		}
		/*
		 * limo with Champagne
		 */
		if (isChampagneIncluded) {
			float costForNormalDaysCh = champagneServiceCost * normalDays;
			float costForPremiumDaysCh = premiumDayChampagneServiceCost * noOfPremiumDays;
			totalChampagneServiceCost = costForNormalDaysCh + costForPremiumDaysCh;
		}

		/*
		 * calculate cost on sundays or discounted days- flat rate, no champagne
		 * services cost and driver cost included
		 */
		float costForSundays = noOfDiscountDays * discountDayRate;

		/*
		 * Sum up all the totals
		 */
		float total = (normalDays * baseRate) + (noOfPremiumDays * premiumDayRate) + costForSundays + totalDriverCost
						+ totalChampagneServiceCost;

		this.totalAmountForDates = total;
	}

}
