package com.ood.paradise.objects;


import java.time.temporal.ChronoUnit;

import com.ood.util.VehicleEnum;

/**
 * @author nithin
 *
 */

public class Scooters extends Vehicle {

	public Scooters(float inputBaseRate) {
		this.baseRate = inputBaseRate;
		this.type = VehicleEnum.SCOOTER;
	}

	@Override
	public void calculateTotalAmount() {
		// calculating number of days in between
		float totalNoOfDays = (float) ChronoUnit.DAYS.between(startDate, endDate) + 1;
		float total = (totalNoOfDays * baseRate);
		this.totalAmountForDates = total;
	}

	@Override
	public void calculatePerDayRate() {
		// TODO Auto-generated method stub

	}

}
