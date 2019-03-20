package com.main.client;

import java.util.Random;

public class EmailGenerator {
	private static String[] start = { "@gmail.com", "@gmail.hu", "@valami.com", "@akarmi.com" };

	private static String getSaltString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;

	}
	
	private static Random rand = new Random();

	private static String randomEmailStartCode() {

		return start[rand.nextInt(start.length)];

	}
	
	public static String generateEmail() {

		return getSaltString() + randomEmailStartCode();

	}
}
