package com.main.extruder;

public class Extruder {
	private String extruderIdentification;
	private String extruderStatus;
	private String extruderAddDate;
	private String extruderEndDate;

	public String getExtruderIdentification() {
		this.extruderIdentification = IdentificationGenereator.generateIdentification();
		return extruderIdentification;
	}

	public void setExtruderIdentification(String extruderIdentification) {
		this.extruderIdentification = extruderIdentification;
	}

	public String getExtruderStatus() {
		this.extruderStatus = StatusRandom.generateStatus();
		return extruderStatus;
	}

	public void setExtruderStatus(String extruderStatus) {
		this.extruderStatus = extruderStatus;
	}

	public String getExtruderAddDate() {
		extruderAddDate = DateRandom.date();
		return extruderAddDate;
	}

	public void setExtruderAddDate(String extruderAddDate) {
		this.extruderAddDate = extruderAddDate;
	}

	public String getExtruderEndDate() {
		extruderEndDate = DateRandom.date();
		return extruderEndDate;
	}

	public void setExtruderEndDate(String extruderEndDate) {
		this.extruderEndDate = extruderEndDate;
	}
}
