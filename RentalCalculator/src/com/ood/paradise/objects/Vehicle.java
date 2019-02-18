package com.ood.paradise.objects;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;

import com.ood.util.VehicleEnum;

/**
 * @author nithin
 *
 */
public abstract class Vehicle {

	protected float baseRate;
	protected float premiumDayRate;
	protected float discountDayRate;
	protected float permiumCostPercentage;
	protected float discountCostPercentage;
	protected float totalAmountForDates;
	protected VehicleEnum type;

	/*
	 * Extending class will implement logic to calculate total cost for given dates
	 */
	public abstract void calculateTotalAmount();

	/*
	 * Each and every vehicle has different rates on Friday, Saturday and Sunday.
	 * extending classes will implement logic as per brd
	 */
	public abstract void calculatePerDayRate();

	
	public VehicleEnum getType() {
		return type;
	}

	/*
	 * these inputs must come from user
	 */
	protected LocalDate startDate;

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	protected LocalDate endDate;

	public float getTotalAmountForDates() {
		return totalAmountForDates;
	}

	public void setTotalAmountForDates(float totalAmountForDates) {
		this.totalAmountForDates = totalAmountForDates;
	}

	public float getBaseRate() {
		return baseRate;
	}

	public float getPremiumDayRate() {
		return premiumDayRate;
	}

	public float getDiscountDayRate() {
		return discountDayRate;
	}
	
	/*
	 * Following method is used to count number of Fridays, Saturdays and Sundays
	 */
	public int countDaysOfWeek(LocalDate startDate, LocalDate endDate, DayOfWeek daytoFind) {
		int tempCount = 0;
		while (startDate.compareTo(endDate) <= 0) {
			if (startDate.getDayOfWeek().getValue() == daytoFind.getValue()) {
				tempCount++;
			}
			startDate = startDate.plusDays(1);
		}
		return tempCount;
	}

}
