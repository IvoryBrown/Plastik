package com.main.extruder;

import java.util.Random;

public class WidthRandom {
	private static String[] Beginning = { "1200", "350","300","1400","1600","2500" };

	private static Random rand = new Random();

	public static String generateWidth() {

		return Beginning[rand.nextInt(Beginning.length)];

	}
}
