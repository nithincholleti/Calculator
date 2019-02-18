package com.ood.paradise.objects;

import java.util.List;

/**
 * @author nithin
 *
 */
public class Renter {
	private int age;
	private List<Vehicle> listOfVehicles;
	private boolean isSUVRented;

	public boolean isSUVRented() {
		return isSUVRented;
	}

	public void setSUVRented(boolean isSUVRented) {
		this.isSUVRented = isSUVRented;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Vehicle> getListOfVehicles() {
		return listOfVehicles;
	}

	public void setListOfVehicles(List<Vehicle> listOfVehicles) {
		this.listOfVehicles = listOfVehicles;
	}

	/*
	 * Loops over the list and adds the total to get final result
	 */
	public float totalCost() {
		float summation = 0;
		List<Vehicle> lis = this.listOfVehicles;
		boolean isfirstBicycle = false;
		for (Vehicle veh : lis) {
			veh.calculateTotalAmount();
			summation = summation + veh.getTotalAmountForDates();
			/*
			 * adding Hazard Insurance
			 */
			if (veh.getType().equals("Motorcycle")) {
				if (age >= 18 && age <= 25) {
					summation = summation + 50;
				} else if (age >= 26 && age <= 32) {
					summation = summation + 35;
				} else if (age >= 33 && age < 45) {
					summation = summation + 35;
				} else if (age >= 45) {
					summation = summation + 0;
				}
			}
			/*
			 * If renter rents SUV then first Bicycle is free. Subtracting it from total
			 */
			if (veh.getType().equals("Bicycle") && isSUVRented == true && isfirstBicycle == false) {
				isfirstBicycle = true;
				summation = summation - veh.getTotalAmountForDates();
			}

		}
		return summation;
	}
}
