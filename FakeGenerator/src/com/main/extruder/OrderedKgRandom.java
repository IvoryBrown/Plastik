package com.main.extruder;

import java.util.Random;

public class OrderedKgRandom {
	private static String[] Beginning = { "1150", "7000", "250", "4800", "5000", "440" };

	private static Random rand = new Random();

	public static String generateOrderedKg() {

		return Beginning[rand.nextInt(Beginning.length)];

	}
}
