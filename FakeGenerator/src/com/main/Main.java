package com.main;

import com.main.client.Client;
import com.main.extruder.Extruder;

public class Main {

	public static void main(String[] args) {
		runTask();
	}

	private static void runTask() {
		try {
			while (true) {
				clientGenerator();
				extruderGenerator();
				Thread.sleep(3000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void clientGenerator() {
		Client n = new Client();
		System.out.println("--------------Ügyfél----------------");
		System.out.println("Vezeték-> " + n.getFirstName());
		System.out.println("Kereszt-> " + n.getLastName());
		System.out.println("Teljes-> " + n.getFullName());
		System.out.println("Irányítószám-> " + n.getClientPostcode());
		System.out.println("Város-> " + n.getClientCity());
		System.out.println("Utca/ház-> " + n.getClientStreet());
		System.out.println("Mobil-> " + n.getClientMobil());
		System.out.println("Email-> " + n.getClientemail());

	}

	private static void extruderGenerator() {
		Extruder n = new Extruder();
		System.out.println("--------------Extruder-----------------");
		System.out.println("Azonosító-> " + n.getExtruderIdentification());
		System.out.println("Státusz-> " + n.getExtruderStatus());
		System.out.println("Felvétel-> " + n.getExtruderAddDate());
		System.out.println("Határidő-> " + n.getExtruderEndDate());


	}

}
