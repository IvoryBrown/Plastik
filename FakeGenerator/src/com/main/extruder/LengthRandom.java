package com.main.extruder;

import java.util.Random;

public class LengthRandom {
	private static String[] Beginning = { "0", "1800","0","2000","1600","0","400" };

	private static Random rand = new Random();

	public static String generateLength() {

		return Beginning[rand.nextInt(Beginning.length)];

	}
}
