package com.main.extruder;

import java.util.Random;

public class PriorityRandom {
	private final static String CHARLIST = "0123456789";

	private static int getRandom() {
		int randomInt = 0;
		Random randomGenerator = new Random();
		randomInt = randomGenerator.nextInt(CHARLIST.length());
		if (randomInt - 1 == -1) {
			return randomInt;
		} else {
			return randomInt - 1;
		}
	}

	private static String random() {
		int stringLength = 3;
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < stringLength; i++) {
			int num = getRandom();
			char ch = CHARLIST.charAt(num);
			str.append(ch);
		}
		return str.toString();
	}

	public static String generatePriority() {

		return random();

	}
}
