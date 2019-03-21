package com.main.extruder;

import java.util.Random;

public class GrammMeterRandom {
	private static String[] Beginning = { "36,8", "66,24", "12,42", "38,64", "77,28", "55,2" };

	private static Random rand = new Random();

	public static String generateGrammMeter() {

		return Beginning[rand.nextInt(Beginning.length)];

	}
}
