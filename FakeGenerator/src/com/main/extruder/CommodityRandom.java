package com.main.extruder;

import java.util.Random;

public class CommodityRandom {

	private static String[] Beginning = { "orig fekete", "reg szürke", "orig fc", "orig natur", "orig kék", "reg nat",
			"orig zöld" };

	private static Random rand = new Random();

	public static String generateCommodity() {

		return Beginning[rand.nextInt(Beginning.length)];

	}
}
