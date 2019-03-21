package com.main.extruder;

import java.util.Random;

public class ThicknessRandom {
	private static String[] Beginning = { "0,035", "0,12", "0,02", "0,065", "0,03", "0,045", "0,035" };

	private static Random rand = new Random();

	public static String generateThickness() {

		return Beginning[rand.nextInt(Beginning.length)];

	}
}
