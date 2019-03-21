package com.main;

import com.main.client.Client;
import com.main.extruder.Extruder;

public class Main {
	static Client nclient = new Client();
	static Extruder extruder = new Extruder();

	public static void main(String[] args) {
		runTask();
	}

	private static void runTask() {
		try {
			while (true) {
				clientGenerator();
				Thread.sleep(300);
				extruderGenerator();
				transmission();
				Thread.sleep(300000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void clientGenerator() {

		System.out.println("--------------Ügyfél----------------");
		System.out.println("Vezeték-> " + nclient.getFirstName());
		System.out.println("Kereszt-> " + nclient.getLastName());
		System.out.println("Teljes-> " + nclient.getFullName());
		System.out.println("Irányítószám-> " + nclient.getClientPostcode());
		System.out.println("Város-> " + nclient.getClientCity());
		System.out.println("Utca/ház-> " + nclient.getClientStreet());
		System.out.println("Mobil-> " + nclient.getClientMobil());
		System.out.println("Email-> " + nclient.getClientemail());

	}

	private static void extruderGenerator() {

		System.out.println("--------------Extruder-----------------");
		System.out.println("Azonosító-> " + Extruder.getExtruderIdentification());
		System.out.println("Státusz-> " + extruder.getExtruderStatus());
		System.out.println("Felvétel-> " + extruder.getExtruderAddDate());
		System.out.println("Határidő-> " + extruder.getExtruderEndDate());
		System.out.println("Alapanyag-> " + extruder.getExtruderCommodity());
		System.out.println("Méret-> " + extruder.getExtruderActualSize());
		System.out.println("Szélesség-> " + extruder.getExtruderWidth());
		System.out.println("Hossz-> " + extruder.getExtruderLength());
		System.out.println("Vastagság-> " + extruder.getExtruderThickness());
		System.out.println("Zsák/Sík-> " + extruder.getExtruderFlatPlateBag());
		System.out.println("g/m-> " + extruder.getExtruderGrammMeter());
		System.out.println("Megrenelt/kg-> " + extruder.getExtruderOrderedKg());
		System.out.println("ExtruderNév-> " + extruder.getExtruderName());
		System.out.println("Megjegyzés-> " + extruder.getExtruderComment());
		System.out.println("Prioritás-> " + extruder.getExtruderPriority());

	}
	
	private static void transmission() {
		System.out.println("Azonosító-> " + Extruder.getExtruderIdentification());
	}

}
