package com.main.client;

import java.util.Random;

public class StreetGenerator {

	private static String[] street = { "48-as tér", "Abaligeti út", "Acsády Ignác utca", "Ács utca", "Ady Endre utca", "Áfonya utca", "Agancs dűlő",
			"Ágoston tér", "Ágota utca", "Ág utca", "Aidinger János út", "Ajtósi Dürer utca", "Akácfa dűlő", "Akácfa köz", "Akácos sor",
			"Akác utca", "Aknász utca", "Akó dűlő", "Alajos utca", "Alkony utca", "Alkotás utca", "Alkotmány utca",
			"Állomás utca", "Álmos utca", "Alsóbalokány utca", "Alsógyükési út","Alsóhavi utca","Alsó-hegyi dűlő" };
	
	private static String[] end = { "2", "4", "22", "45", "66", "102", "1",
			"43", "44", "89", "132", "432", "453", "63", "32",
			"32", "56", "44", "345", "32", "67", "76",
			"45", "25", "69", "4321","78","46" };

	private static Random rand = new Random();

	public static String generateStreet() {

		return street[rand.nextInt(street.length)]+" "+end[rand.nextInt(end.length)];

	}
}
