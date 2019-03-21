package com.main.extruder;

import java.util.Random;

public class ActualSizeRandom {
	private static String[] Beginning = { "430*0,07", "430*0,08", "800*1000*0,02", "2000*2100*0,15", "400*0,06",
			"1400*1800*0,045", "1800*1800*0,03", "1900*1500*0,095", "2000*2100*0,15", "570*2*215*1200*0,052",
			"2500*0,13" };

	private static Random rand = new Random();

	public static String generateActualSize() {

		return Beginning[rand.nextInt(Beginning.length)];

	}
}
