package com.production.transmissionfinished.extruder.pojo;

public class Transmission {

	private static String extruderId;
	private static String extruderIdentification;
	private static String extruderName;
	private static String extruderClientName;
	private static String extruderActualSize;

	public static String getExtruderId() {
		return extruderId;
	}

	public static void setExtruderId(String extruderId) {
		Transmission.extruderId = extruderId;
	}

	public static String getExtruderIdentification() {
		return extruderIdentification;
	}

	public static void setExtruderIdentification(String extruderIdentification) {
		Transmission.extruderIdentification = extruderIdentification;
	}

	public static String getExtruderName() {
		return extruderName;
	}

	public static void setExtruderName(String extruderName) {
		Transmission.extruderName = extruderName;
	}

	public static String getExtruderClientName() {
		return extruderClientName;
	}

	public static void setExtruderClientName(String extruderClientName) {
		Transmission.extruderClientName = extruderClientName;
	}

	public static String getExtruderActualSize() {
		return extruderActualSize;
	}

	public static void setExtruderActualSize(String extruderActualSize) {
		Transmission.extruderActualSize = extruderActualSize;
	}
}
