package com.main.client;

import java.util.Random;

public class PostCodeGenerator {
	private static String charList = "0123456789";

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

	public static String randomPostCode() {
		int stringLength = 4;
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < stringLength; i++) {
			int num = getRandom();
			char ch = charList.charAt(num);
			str.append(ch);
		}
		return str.toString();
	}
}