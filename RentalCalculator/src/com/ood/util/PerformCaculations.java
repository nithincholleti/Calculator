package com.ood.util;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import com.ood.objectFactory.VehicleFactory;
import com.ood.paradise.objects.BasePriceForCars;
import com.ood.paradise.objects.Jetskis;
import com.ood.paradise.objects.Limousines;
import com.ood.paradise.objects.Suv;
import com.ood.paradise.objects.Vehicle;
import com.ood.util.Validation;

/**
 * @author nithin
 *
 */

public class PerformCaculations {

	private VehicleFactory vehicleFactory;
	private BasePriceForCars base;

	/*
	 * create vehicle factory object. This object is used to create different types
	 * if vehicles
	 */
	public PerformCaculations() {
		this.base = new BasePriceForCars(30, 25, 20);
		this.vehicleFactory = new VehicleFactory(base);
	}

	/*
	 * Following method creates vehicles objects and add to userList which is part
	 * of renter objects
	 */
	private void addVehiclesToList(List<Vehicle> userList, int counter, VehicleEnum vehicleType) {
		String startDate;
		String endDate;
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= Integer.valueOf(counter); i++) {
			try {
				Vehicle midsizeCar = vehicleFactory.getVehicleInstance(vehicleType);
				System.out.println("Dates must be entered in YYYY-MM-DD format only.");
				System.out.println("Enter start date for " + vehicleType + " " + i);
				startDate = sc.nextLine();
				if (Validation.validateUserInput(ApplicationConstants.DATE, startDate)) {
					midsizeCar.setStartDate(LocalDate.parse(startDate));
				}
				System.out.println("Enter end date for " + vehicleType + " " + i);
				endDate = sc.nextLine();
				if (Validation.validateUserInput(ApplicationConstants.DATE, endDate)) {
					midsizeCar.setEndDate(LocalDate.parse(endDate));
				}
				userList.add(midsizeCar);
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}

	/*
	 * Following method creates SUV cars objects and add to userList which is part
	 * of renter objects
	 */
	private void addSUVVehiclesToList(List<Vehicle> userList, int counter, VehicleEnum vehicleType) {
		String startDate;
		String endDate;
		String isCarTakenOffRoad;
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= Integer.valueOf(counter); i++) {
			try {
				Vehicle SUVCar = vehicleFactory.getVehicleInstance(vehicleType);
				System.out.println("Dates must be entered in YYYY-MM-DD format only.");
				System.out.println("Enter start date for " + vehicleType + " " + i);
				startDate = sc.nextLine();
				if (Validation.validateUserInput(ApplicationConstants.DATE, startDate)) {
					SUVCar.setStartDate(LocalDate.parse(startDate));
				}
				System.out.println("Enter end date for " + vehicleType + " " + i);
				endDate = sc.nextLine();
				if (Validation.validateUserInput(ApplicationConstants.DATE, endDate)) {
					SUVCar.setEndDate(LocalDate.parse(endDate));
				}
				System.out.println("Was this car taken offroad (Y/N)");
				isCarTakenOffRoad = sc.nextLine();
				if (Validation.validateUserInput(ApplicationConstants.YESNO, isCarTakenOffRoad)) {
					if (isCarTakenOffRoad.equalsIgnoreCase("Y")) {
						((Suv) SUVCar).setCarTakenOffRoad(true);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}

	/*
	 * Following method creates LIMOUSINE cars objects and add to userList which is
	 * part of renter objects
	 */
	private void addLIMOUSINEVehiclesToList(List<Vehicle> userList, int counter, VehicleEnum vehicleType) {
		String startDate;
		String endDate;
		String driverPackage;
		String premiumPackage;
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= Integer.valueOf(counter); i++) {
			try {
				Vehicle LimousineCar = vehicleFactory.getVehicleInstance(vehicleType);
				System.out.println("Dates must be entered in YYYY-MM-DD format only.");
				System.out.println("Enter start date for " + vehicleType + " " + i);
				startDate = sc.nextLine();
				if (Validation.validateUserInput(ApplicationConstants.DATE, startDate)) {
					LimousineCar.setStartDate(LocalDate.parse(startDate));
				}
				System.out.println("Enter end date for " + vehicleType + " " + i);
				endDate = sc.nextLine();
				if (Validation.validateUserInput(ApplicationConstants.DATE, endDate)) {
					LimousineCar.setEndDate(LocalDate.parse(endDate));
				}

				System.out.println("Driver Package included ? (Y/N)");
				driverPackage = sc.nextLine();
				if (Validation.validateUserInput(ApplicationConstants.YESNO, driverPackage)) {
					if (driverPackage.equalsIgnoreCase("Y")) {
						((Limousines) LimousineCar).setDriverIncluded(true);
					} else {
						((Limousines) LimousineCar).setDriverIncluded(false);
					}
				}

				System.out.println("Premium Package included ? (Y/N)");
				premiumPackage = sc.nextLine();
				if (Validation.validateUserInput(ApplicationConstants.YESNO, premiumPackage)) {
					if (premiumPackage.equalsIgnoreCase("Y")) {
						((Limousines) LimousineCar).setChampagneIncluded(true);
					} else {
						((Limousines) LimousineCar).setChampagneIncluded(false);
					}
				}
				userList.add(LimousineCar);
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}

	/*
	 * Following method creates JetSkis objects and add to userList which is part of
	 * renter objects
	 */

	private void addJetSkisToList(List<Vehicle> userList, int counter, VehicleEnum vehicleType) {
		String hours;
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= Integer.valueOf(counter); i++) {
			try {
				Vehicle jetskis = vehicleFactory.getVehicleInstance(vehicleType);
				System.out.println("Enter number of hours for " + vehicleType + " " + i);
				hours = sc.nextLine();
				if (Validation.validateUserInput(ApplicationConstants.NUMERIC, hours)) {
					((Jetskis) jetskis).setHours(Integer.valueOf(hours));
				}
				userList.add(jetskis);
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}

	/*
	 * Following method is used to read input from console and initialize
	 * appropriate objects.
	 */
	public void consoleInputAndCalculation(List<Vehicle> userList) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Select one car from the list to start calculation");
		System.out.println("1. Midsize car\r\n" + "2. Economy Car\r\n" + "3. SUV\r\n" + "4. Luxury Car\r\n"
				+ "5. Limousine\r\n" + "6. Bicycle\r\n" + "7. Scooter\r\n" + "8. Motorcycle\r\n" + "9. Jetskis ");

		String selection = sc.nextLine();
		String counter;

		/*
		 * performs basic sanity check before creating or adding the object to list.If
		 * sanity check fails, it will throw an exception
		 */
		try {
			if (Validation.validateUserInput(ApplicationConstants.VEHICLETYPE, selection)) {
				int carValue = Integer.valueOf(selection);
				VehicleEnum vEnum = VehicleEnum.valueOf(carValue);
				switch (vEnum) {
				case MIDSIZECAR:
					System.out.println("How many Midsize cars were rented ?");
					counter = sc.nextLine();
					if (Validation.validateUserInput(ApplicationConstants.NUMERIC, counter)) {
						addVehiclesToList(userList, Integer.valueOf(counter), VehicleEnum.MIDSIZECAR);
					}
					break;
				case ECONOMYCAR:
					System.out.println("How many Economy cars were rented ?");
					counter = sc.nextLine();
					if (Validation.validateUserInput(ApplicationConstants.NUMERIC, counter)) {
						addVehiclesToList(userList, Integer.valueOf(counter), VehicleEnum.ECONOMYCAR);
					}
					break;
				case SUV:
					System.out.println("How many SUV cars were rented ?");
					counter = sc.nextLine();
					if (Validation.validateUserInput(ApplicationConstants.NUMERIC, counter)) {
						addSUVVehiclesToList(userList, Integer.valueOf(counter), VehicleEnum.SUV);
					}
					break;
				case LUXURYCAR:
					System.out.println("How many Luxury cars were rented ?");
					counter = sc.nextLine();
					if (Validation.validateUserInput(ApplicationConstants.NUMERIC, counter)) {
						addVehiclesToList(userList, Integer.valueOf(counter), VehicleEnum.LUXURYCAR);
					}
					break;
				case LIMOUSINE:
					System.out.println("How many Limousine cars were rented ?");
					counter = sc.nextLine();
					if (Validation.validateUserInput(ApplicationConstants.NUMERIC, counter)) {
						addLIMOUSINEVehiclesToList(userList, Integer.valueOf(counter), VehicleEnum.LIMOUSINE);
					}
					break;
				case BICYCLE:
					System.out.println("How many Bicycle were rented ?");
					counter = sc.nextLine();
					if (Validation.validateUserInput(ApplicationConstants.NUMERIC, counter)) {
						addVehiclesToList(userList, Integer.valueOf(counter), VehicleEnum.BICYCLE);
					}
					break;
				case SCOOTER:
					System.out.println("How many scooters were rented ?");
					counter = sc.nextLine();
					if (Validation.validateUserInput(ApplicationConstants.NUMERIC, counter)) {
						addVehiclesToList(userList, Integer.valueOf(counter), VehicleEnum.SCOOTER);
					}
					break;
				case MOTORCYCLE:
					System.out.println("How many Motorcycle were rented ?");
					counter = sc.nextLine();
					if (Validation.validateUserInput(ApplicationConstants.NUMERIC, counter)) {
						addVehiclesToList(userList, Integer.valueOf(counter), VehicleEnum.MOTORCYCLE);
					}
					break;
				case JETSKIS:
					System.out.println("How many jetskis were rented ?");
					counter = sc.nextLine();
					if (Validation.validateUserInput(ApplicationConstants.NUMERIC, counter)) {
						addJetSkisToList(userList, Integer.valueOf(counter), VehicleEnum.JETSKIS);
					}
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

}
