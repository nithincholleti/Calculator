package com.ood.paradise.objects;

import com.ood.util.VehicleEnum;

/**
 * @author nithin
 *
 */

public class Jetskis extends Vehicle{

	private float baseRate;

	/*
	 * this input must come from user
	 */
	private int hours;

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public Jetskis(float inBaseRate) {
		this.baseRate = inBaseRate;
		this.type = VehicleEnum.JETSKIS;
	}

	public void calculateTotalAmount() {
		float total = 0;
		total = hours * baseRate;
		this.totalAmountForDates = total;
	}

	@Override
	public void calculatePerDayRate() {
		
	}

}
