package com.production.transmission.extruder.pojo;

import javafx.beans.property.SimpleStringProperty;

public class TransmissionExtruder {
	private final SimpleStringProperty transmissionId;
	private final SimpleStringProperty transmissionBKg;
	private final SimpleStringProperty transmissionNKg;
	private final SimpleStringProperty transmissionAllKg;
	private final SimpleStringProperty extruderId;

	public TransmissionExtruder() {
		this.transmissionId = new SimpleStringProperty("");
		this.transmissionBKg = new SimpleStringProperty("");
		this.transmissionNKg = new SimpleStringProperty("");
		this.transmissionAllKg = new SimpleStringProperty("");
		this.extruderId = new SimpleStringProperty("");
	}

	public TransmissionExtruder(double transmissionNKg, Integer extruderId) {
		this.transmissionId = new SimpleStringProperty("");
		this.transmissionBKg = new SimpleStringProperty("");
		this.transmissionNKg = new SimpleStringProperty(String.valueOf(transmissionNKg));
		this.transmissionAllKg = new SimpleStringProperty("");
		this.extruderId = new SimpleStringProperty(String.valueOf(extruderId));
	}

	public SimpleStringProperty getTransmissionIdProperty() {
		return this.transmissionId;
	}

	public String getTransmissionId() {
		return this.transmissionId.get();
	}

	public void setTransmissionId(String transmissionId) {
		this.transmissionId.set(transmissionId);
	}

	public SimpleStringProperty getTransmissionBKgProperty() {
		return this.transmissionBKg;
	}

	public String getTransmissionBKg() {
		return this.transmissionBKg.get();
	}

	public void setTransmissionBKg(String transmissionBKg) {
		this.transmissionBKg.set(transmissionBKg);
	}

	public SimpleStringProperty getTransmissionNKgProperty() {
		return this.transmissionNKg;
	}

	public String getTransmissionNKg() {
		return this.transmissionNKg.get();
	}

	public void setTransmissionNKg(String transmissionNKg) {
		this.transmissionNKg.set(transmissionNKg);
	}

	public SimpleStringProperty getTransmissionAllKgProperty() {
		return this.transmissionAllKg;
	}

	public String getTransmissionAllKg() {
		return this.transmissionAllKg.get();
	}

	public void setTransmissionAllKg(String transmissionAllKg) {
		this.transmissionAllKg.set(transmissionAllKg);
	}

	public SimpleStringProperty getExtruderIdProperty() {
		return this.extruderId;
	}

	public String getExtruderId() {
		return this.extruderId.get();
	}

	public void setExtruderId(String extruderId) {
		this.extruderId.set(extruderId);
	}
}
