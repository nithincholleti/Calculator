package com.ood.objectFactory;

import com.ood.paradise.objects.BasePriceForCars;
import com.ood.paradise.objects.Bicycles;
import com.ood.paradise.objects.EconomyCars;
import com.ood.paradise.objects.Jetskis;
import com.ood.paradise.objects.Limousines;
import com.ood.paradise.objects.LuxuryCars;
import com.ood.paradise.objects.MidsizeCars;
import com.ood.paradise.objects.Motorcycles;
import com.ood.paradise.objects.Scooters;
import com.ood.paradise.objects.Suv;
import com.ood.paradise.objects.Vehicle;
import com.ood.util.ApplicationConstants;
import com.ood.util.VehicleEnum;

/**
 * @author nithin
 * 
 */
public class VehicleFactory {
	private BasePriceForCars base;

	public VehicleFactory(BasePriceForCars inputBase) {
		this.base = inputBase;
	}

	/*
	 * Following method is used to create instances of different vehicles based on
	 * user input
	 */
	public Vehicle getVehicleInstance(VehicleEnum invehicleType) {
		/*
		 * 1.Midsize car 2.Economy Car 3.SUV 4.Luxury Car 5.Limousine 6.Bicycle
		 * 7.Scooter 8.Motorcycle 9.Jetskis
		 */

		if (invehicleType.equals(VehicleEnum.MIDSIZECAR)) {
			return new MidsizeCars(30, 25, 20);
		} else if (invehicleType.equals(VehicleEnum.ECONOMYCAR)) {
			return new EconomyCars(50, base);
		} else if (invehicleType.equals(VehicleEnum.SUV)) {
			new Suv(50, base, 15);
		} else if (invehicleType.equals(VehicleEnum.LUXURYCAR)) {
			return new LuxuryCars(base, 100);
		} else if (invehicleType.equals(VehicleEnum.LIMOUSINE)) {
			return new Limousines(100, 40, 100, 150, 75);
		} else if (invehicleType.equals(VehicleEnum.BICYCLE)) {
			return new Bicycles(10);
		} else if (invehicleType.equals(VehicleEnum.SCOOTER)) {
			return new Scooters(25);
		} else if (invehicleType.equals(VehicleEnum.MOTORCYCLE)) {
			return new Motorcycles(25);
		} else if (invehicleType.equals(VehicleEnum.JETSKIS)) {
			return new Jetskis(base.getBaseRate());
		}
		return null;
	}
}
