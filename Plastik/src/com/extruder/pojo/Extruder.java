package com.extruder.pojo;

import javafx.beans.property.SimpleStringProperty;

public class Extruder {

	private final SimpleStringProperty extruderId;
	private final SimpleStringProperty extruderClientId;
	private final SimpleStringProperty extruderAddDate;
	private final SimpleStringProperty extruderEndDate;

	public Extruder() {
		this.extruderId = new SimpleStringProperty(String.valueOf(""));
		this.extruderClientId = new SimpleStringProperty(String.valueOf(""));
		this.extruderAddDate = new SimpleStringProperty("");
		this.extruderEndDate = new SimpleStringProperty("");
	}

}
