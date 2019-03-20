package com.main.client;

import java.util.Random;

public class MobilGenerator {
	private static String charList = "0123456789";
	private static String[] start = { "20", "30", "70" };

	private static int getRandom() {
		int randomInt = 0;
		Random randomGenerator = new Random();
		randomInt = randomGenerator.nextInt(charList.length());
		if (randomInt - 1 == -1) {
			return randomInt;
		} else {
			return randomInt - 1;
		}

	}

	private static String randomMobilEndCode() {
		int stringLength = 4;
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < stringLength; i++) {
			int num = getRandom();
			char ch = charList.charAt(num);
			str.append(ch);
		}
		return str.toString();
	}

	private static String randomMobilUnCode() {
		int stringLength = 3;
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < stringLength; i++) {
			int num = getRandom();
			char ch = charList.charAt(num);
			str.append(ch);
		}
		return str.toString();
	}

	private static Random rand = new Random();

	private static String randomMobilStartCode() {

		return start[rand.nextInt(start.length)];

	}

	public static String generateMobil() {

		return "+36 " + randomMobilStartCode() + " " + randomMobilUnCode() + " " + randomMobilEndCode();

	}
}
