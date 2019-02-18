package com.ood.calculator;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.ood.paradise.objects.Renter;
import com.ood.paradise.objects.Vehicle;
import com.ood.util.ApplicationConstants;
import com.ood.util.PerformCaculations;
import com.ood.util.Validation;

public class ParadiseCalculator {

	private Renter renter;

	public Renter getRenter() {
		return renter;
	}

	public ParadiseCalculator() {
		this.renter = new Renter();
	}

	/*
	 * entry point into the calculator application
	 */
	public static void main(String args[]) throws ParseException {

		/*
		 * Initializing basic objects before starting the application
		 */
		ParadiseCalculator client = new ParadiseCalculator();
		PerformCaculations calculations = new PerformCaculations();
		List<Vehicle> userList = new ArrayList<Vehicle>();

		System.out.println("Welcome To Paradise Rental Calculator");
		System.out.println("Please enter renter's age ");
		Scanner sc = new Scanner(System.in);
		String value = sc.nextLine();
		String loopChar = "Y";
		try {
			/*
			 * performing sanity check on user input
			 */
			if (Validation.validateUserInput(ApplicationConstants.AGE, value)) {
				client.getRenter().setListOfVehicles(userList);
				client.getRenter().setAge(Integer.valueOf(value));
				while (loopChar.equalsIgnoreCase("Y")) {
					// start reading input from user
					calculations.consoleInputAndCalculation(userList);
					System.out.println("Do you want to add more cars for the renter (Y/N) \r\n");
					// check if user still need to add vehicles
					loopChar = sc.nextLine();
				}
				// printing final cost
				System.out.println("Total Cost " + client.getRenter().totalCost());
			}
		} catch (Exception e) {
			e.printStackTrace();
		    System.exit(1);
		}
	}
}
