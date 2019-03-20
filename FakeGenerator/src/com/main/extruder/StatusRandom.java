package com.main.extruder;

import java.util.Random;

public class StatusRandom {
	private static String[] Beginning = { "Elkészült", "Folyamatban" };

	private static Random rand = new Random();

	public static String generateStatus() {

		return Beginning[rand.nextInt(Beginning.length)];

	}
}
