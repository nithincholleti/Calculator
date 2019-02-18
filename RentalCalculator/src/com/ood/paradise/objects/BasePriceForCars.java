package com.ood.paradise.objects;

/**
 * @author nithin
 *
 */
public class BasePriceForCars {
	
	private float baseRate;
	private float permiumCostPercentage;
	private float discountCostPercentage;
	private float premiumDayRate;
	private float discountDayRate;

	/**
	 * following are the basic input variable required to create basicprice car
	 * object.
	 *
	 */
	public BasePriceForCars(float inputBaseRate, float inputPremiumPercentage, float inputDiscountPercentage) {
		this.baseRate = inputBaseRate;
		this.permiumCostPercentage = inputPremiumPercentage;
		this.discountCostPercentage = inputDiscountPercentage;
		this.premiumDayRate = baseRate + (baseRate * ((float) permiumCostPercentage / (float) 100));
		this.discountDayRate = baseRate - (baseRate * ((float) discountCostPercentage / (float) 100));

	}

	public float getBaseRate() {
		return baseRate;
	}

	public float getPermiumCostPercentage() {
		return permiumCostPercentage;
	}

	public float getDiscountCostPercentage() {
		return discountCostPercentage;
	}

	public float getPremiumDayRate() {
		return premiumDayRate;
	}

	public float getDiscountDayRate() {
		return discountDayRate;
	}

}
