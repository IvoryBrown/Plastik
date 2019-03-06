package com.extruder.pojo;

import javafx.beans.property.SimpleStringProperty;

public class CalculationButton {
	private SimpleStringProperty fieldSubRecordName;
	private SimpleStringProperty fieldSubRecordValueName;
	private SimpleStringProperty fieldSubRecordValuePercentage;
	private SimpleStringProperty fieldSubRecordValuePercentageKg;

	public CalculationButton(String fieldSubRecordName, String fieldSubRecordValueName,
			String fieldSubRecordValuePercentage, String fieldSubRecordValuePercentageKg) {
		this.fieldSubRecordName = new SimpleStringProperty(fieldSubRecordName);
		this.fieldSubRecordValueName = new SimpleStringProperty(fieldSubRecordValueName);
		this.fieldSubRecordValuePercentage = new SimpleStringProperty(fieldSubRecordValuePercentage);
		this.fieldSubRecordValuePercentageKg = new SimpleStringProperty(fieldSubRecordValuePercentageKg);
	}

	public String getFieldSubRecordName() {
		return this.fieldSubRecordName.get();
	}

	public String fieldSubRecordValueName() {
		return this.fieldSubRecordValueName.get();
	}

	public String getFieldSubRecordValuePercentage() {
		return this.fieldSubRecordValuePercentage.get();
	}

	public String getFieldSubRecordValuePercentageKg() {
		return this.fieldSubRecordValuePercentageKg.get();
	}
}
