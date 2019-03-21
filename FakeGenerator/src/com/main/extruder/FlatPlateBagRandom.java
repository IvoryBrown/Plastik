package com.main.extruder;

import java.util.Random;

public class FlatPlateBagRandom {
	private static String[] Beginning = { "1", "2" };

	private static Random rand = new Random();

	public static String generateFlatPlateBag() {

		return Beginning[rand.nextInt(Beginning.length)];

	}
}
