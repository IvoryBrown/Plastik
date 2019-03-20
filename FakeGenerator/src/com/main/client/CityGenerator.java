package com.main.client;

import java.util.Random;

public class CityGenerator {

	private static String[] Beginning = { "Aba", "Abádszalók", "Budapest", "Debrecen", "Szeged", "Pécs", "Győr",
			"Nyíregyháza", "Kecskemét", "Székesfehérvár", "Szombathely", "Szolnok", "Érd", "Tatabánya", "Sopron",
			"Kaposvár", "Veszprém", "Békéscsaba", "Zalaegerszeg", "Eger", "Nagykanizsa", "Dunaújváros",
			"Hódmezővásárhely", "Dunakeszi", "Szigetszentmiklós", "Cegléd" };

	private static Random rand = new Random();

	public static String generateCity() {

		return Beginning[rand.nextInt(Beginning.length)];

	}
}
