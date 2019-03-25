package com.main.leextruder;

import java.util.Random;

public class NNKgRandom {
	private static String[] Beginning = { "430", "430", "800", "200", "40",
			"140", "180", "190", "20", "57",
			"2500" };

	private static Random rand = new Random();

	public static String generateNNkg() {

		return Beginning[rand.nextInt(Beginning.length)];

	}
}
