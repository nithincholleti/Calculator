package com.ood.paradise.objects;

import java.time.temporal.ChronoUnit;

/**
 * @author nithin
 *
 */

public class Bicycles extends Vehicle {

	public Bicycles(float inputBaseRate) {
		this.baseRate = inputBaseRate;
		this.type = "Bicycle";
	}

	@Override
	public void calculateTotalAmount() {
		// calculating number of days in between
		float totalNoOfDays = (float) ChronoUnit.DAYS.between(startDate, endDate) + 1;
		// if a renter rents an SUV, their first bike rental is free
		float total = (totalNoOfDays * baseRate);
		this.totalAmountForDates = total;
	}

	@Override
	public void calculatePerDayRate() {
		// TODO Auto-generated method stub

	}

}
