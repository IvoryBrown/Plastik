package com.main.extruder;

import java.util.Random;

public class NameRandom {
	private static String[] Beginning = { "Cmg-12001", "Cmg-12002", "Cmg-1200", "Cmg-1300", "Cmg-1400", "Cmg-1500",
			"Cmg-1600", "Cmg-1700", "Cmg-1800", "Cmg-1900", "Cmg-1210", "Cmg-1220", "Cmg-1230", "Cmg-1240" };

	private static Random rand = new Random();

	public static String generateName() {

		return Beginning[rand.nextInt(Beginning.length)];

	}
}
