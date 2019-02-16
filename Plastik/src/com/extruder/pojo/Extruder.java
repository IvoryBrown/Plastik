package com.extruder.pojo;

import javafx.beans.property.SimpleStringProperty;

public class Extruder {

	private final SimpleStringProperty extruderId;
	private final SimpleStringProperty extruderClientId;
	private final SimpleStringProperty extruderIdentification;
	private final SimpleStringProperty extruderStatus;
	private final SimpleStringProperty extruderAddDate;
	private final SimpleStringProperty extruderEndDate;
	private final SimpleStringProperty extruderCommodity;
	private final SimpleStringProperty extruderActualSize;
	private final SimpleStringProperty extruderWidth;
	private final SimpleStringProperty extruderLength;
	private final SimpleStringProperty extruderThickness;
	private final SimpleStringProperty extruderFlatPlateBag;
	private final SimpleStringProperty extruderGrammMeter;
	private final SimpleStringProperty extruderOrderedKg;
	private final SimpleStringProperty extruderActualKg;
	private final SimpleStringProperty extruderName;

	public Extruder() {
		this.extruderId = new SimpleStringProperty(String.valueOf(""));
		this.extruderClientId = new SimpleStringProperty(String.valueOf(""));
		this.extruderIdentification = new SimpleStringProperty("");
		this.extruderStatus = new SimpleStringProperty("");
		this.extruderAddDate = new SimpleStringProperty("");
		this.extruderEndDate = new SimpleStringProperty("");
		this.extruderCommodity = new SimpleStringProperty("");
		this.extruderActualSize = new SimpleStringProperty("");
		this.extruderWidth = new SimpleStringProperty("");
		this.extruderLength = new SimpleStringProperty("");
		this.extruderThickness = new SimpleStringProperty("");
		this.extruderFlatPlateBag = new SimpleStringProperty("");
		this.extruderGrammMeter = new SimpleStringProperty("");
		this.extruderOrderedKg = new SimpleStringProperty("");
		this.extruderActualKg = new SimpleStringProperty("");
		this.extruderName = new SimpleStringProperty("");
	}

}
