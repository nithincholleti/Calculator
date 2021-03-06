package com.ood.paradise.objects;


import java.time.temporal.ChronoUnit;

import com.ood.util.VehicleEnum;

/**
 * @author nithin
 *
 */
public class Motorcycles extends Vehicle {
	
	public Motorcycles(float inputBaseRate) {
		this.baseRate = inputBaseRate;
		this.type = VehicleEnum.MOTORCYCLE;
	}

	public void calculateTotalAmount() {
		// calculating number of days in between
		float totalNoOfDays = (float) ChronoUnit.DAYS.between(startDate, endDate) + 1;
		float total = 0;
		total = (totalNoOfDays * baseRate);
		this.totalAmountForDates = total;
	}

	@Override
	public void calculatePerDayRate() {
	}

}
