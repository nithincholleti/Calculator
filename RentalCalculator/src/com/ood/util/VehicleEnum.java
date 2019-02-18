package com.ood.util;

public enum VehicleEnum {

	MIDSIZECAR(1), ECONOMYCAR(2), SUV(3), LUXURYCAR(4), LIMOUSINE(5), BICYCLE(6), SCOOTER(7), MOTORCYCLE(8), JETSKIS(9);

	private int value;

	VehicleEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static VehicleEnum valueOf(int inputValue) {
		for (VehicleEnum env : VehicleEnum.values()) {
			if (env.getValue() == inputValue) {
				return env;
			}
		}
		return null;
	}

}
