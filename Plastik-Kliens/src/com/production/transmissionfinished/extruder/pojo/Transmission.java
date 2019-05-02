package com.production.transmissionfinished.extruder.pojo;

import com.production.transmissionfinished.extruder.database.TransmissionExtruderDataBase;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Transmission {

	private static String extruderId;
	private static String extruderIdentification;
	private static String extruderName;
	private static String extruderClientName;
	private static String extruderActualSize;
	private static String extruderActualKg;
	private static String extruderorderKg;

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

	public static String getExtruderActualKg() {
		return extruderActualKg;
	}
	public static String getFinishedActualKg() {
		String f = null;
		double sum = 0;
		ObservableList<TransmissionExtruder> dataExtruder = FXCollections.observableArrayList();
		dataExtruder.addAll(new TransmissionExtruderDataBase().getTransmisionNKg(Integer.parseInt(extruderId)));
		if (dataExtruder.size() != 0) {
			for (int i = 0; i < dataExtruder.size(); i++) {
				double g = Double.valueOf(dataExtruder.get(i).getTransmissionNKg());
				sum += g;
			}
		}
		double n_kg1 = Math.round(sum * 1e2) / 1e2;
		f = String.valueOf(n_kg1);
		return f;
	}

	public static void setExtruderActualKg(String extruderActualKg) {
		Transmission.extruderActualKg = extruderActualKg;
	}

	public static String getExtruderorderKg() {
		return extruderorderKg;
	}

	public static void setExtruderorderKg(String extruderorderKg) {
		Transmission.extruderorderKg = extruderorderKg;
	}
}
