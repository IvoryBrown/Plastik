package com.office.transmission.pojo;

import javafx.beans.property.SimpleStringProperty;

public class TransmissionFinished {
	private final SimpleStringProperty transmissionId;
	private final SimpleStringProperty transmissionExtruderIdentification;
	private final SimpleStringProperty transmissionIdentification;
	private final SimpleStringProperty transmissionExtruderName;
	private final SimpleStringProperty transmissionDate;
	private final SimpleStringProperty transmissionWorkerName;
	private final SimpleStringProperty transmissionClientName;
	private final SimpleStringProperty transmissionExtruderActualSize;
	private final SimpleStringProperty transmissionBKg;
	private final SimpleStringProperty transmissionNKg;
	private final SimpleStringProperty transmissionSpool;
	private final SimpleStringProperty extruderId;

	public TransmissionFinished() {
		this.transmissionId = new SimpleStringProperty("");
		this.transmissionExtruderIdentification = new SimpleStringProperty("");
		this.transmissionIdentification = new SimpleStringProperty("");
		this.transmissionExtruderName = new SimpleStringProperty("");
		this.transmissionDate = new SimpleStringProperty("");
		this.transmissionWorkerName = new SimpleStringProperty("");
		this.transmissionClientName = new SimpleStringProperty("");
		this.transmissionExtruderActualSize = new SimpleStringProperty("");
		this.transmissionBKg = new SimpleStringProperty("");
		this.transmissionNKg = new SimpleStringProperty("");
		this.transmissionSpool = new SimpleStringProperty("");
		this.extruderId = new SimpleStringProperty("");
	}

	// table Nkg setting
	public TransmissionFinished(double transmissionNKg, Integer extruderId) {
		this.transmissionId = new SimpleStringProperty("");
		this.transmissionExtruderIdentification = new SimpleStringProperty("");
		this.transmissionIdentification = new SimpleStringProperty("");
		this.transmissionExtruderName = new SimpleStringProperty("");
		this.transmissionDate = new SimpleStringProperty("");
		this.transmissionWorkerName = new SimpleStringProperty("");
		this.transmissionClientName = new SimpleStringProperty("");
		this.transmissionExtruderActualSize = new SimpleStringProperty("");
		this.transmissionSpool = new SimpleStringProperty("");
		this.transmissionBKg = new SimpleStringProperty("");
		this.transmissionNKg = new SimpleStringProperty(String.valueOf(transmissionNKg));
		this.extruderId = new SimpleStringProperty(String.valueOf(extruderId));
	}

	// table
	public TransmissionFinished(Integer transmissionId, String transmissionExtruderIdentification,
			String transmissionIdentification, String transmissionExtruderName, String transmissionDate,
			String transmissionWorkerName, String transmissionClientName, String transmissionExtruderActualSize,
			double transmissionBKg, double transmissionNKg, String transmissionSpool, Integer extruderId) {
		this.transmissionId = new SimpleStringProperty(String.valueOf(transmissionId));
		this.transmissionExtruderIdentification = new SimpleStringProperty(transmissionExtruderIdentification);
		this.transmissionIdentification = new SimpleStringProperty(transmissionIdentification);
		this.transmissionExtruderName = new SimpleStringProperty(transmissionExtruderName);
		this.transmissionDate = new SimpleStringProperty(transmissionDate);
		this.transmissionWorkerName = new SimpleStringProperty(transmissionWorkerName);
		this.transmissionClientName = new SimpleStringProperty(transmissionClientName);
		this.transmissionExtruderActualSize = new SimpleStringProperty(transmissionExtruderActualSize);
		this.transmissionBKg = new SimpleStringProperty(String.valueOf(transmissionBKg));
		this.transmissionNKg = new SimpleStringProperty(String.valueOf(transmissionNKg));
		this.transmissionSpool = new SimpleStringProperty(transmissionSpool);
		this.extruderId = new SimpleStringProperty(String.valueOf(extruderId));
	}

	// add database
	public TransmissionFinished(String transmissionExtruderIdentification, String transmissionIdentification,
			String transmissionExtruderName, String transmissionDate, String transmissionWorkerName,
			String transmissionClientName, String transmissionExtruderActualSize, double transmissionBKg,
			double transmissionNKg, String transmissionSpool, Integer extruderId) {
		this.transmissionId = new SimpleStringProperty(String.valueOf(""));
		this.transmissionExtruderIdentification = new SimpleStringProperty(transmissionExtruderIdentification);
		this.transmissionIdentification = new SimpleStringProperty(transmissionIdentification);
		this.transmissionExtruderName = new SimpleStringProperty(transmissionExtruderName);
		this.transmissionDate = new SimpleStringProperty(transmissionDate);
		this.transmissionWorkerName = new SimpleStringProperty(transmissionWorkerName);
		this.transmissionClientName = new SimpleStringProperty(transmissionClientName);
		this.transmissionExtruderActualSize = new SimpleStringProperty(transmissionExtruderActualSize);
		this.transmissionBKg = new SimpleStringProperty(String.valueOf(transmissionBKg));
		this.transmissionNKg = new SimpleStringProperty(String.valueOf(transmissionNKg));
		this.transmissionSpool = new SimpleStringProperty(transmissionSpool);
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

	public SimpleStringProperty getTransmissionExtruderIdentificationProperty() {
		return this.transmissionExtruderIdentification;
	}

	public String getTransmissionExtruderIdentification() {
		return this.transmissionExtruderIdentification.get();
	}

	public void setTransmissionExtruderIdentification(String transmissionExtruderIdentification) {
		this.transmissionExtruderIdentification.set(transmissionExtruderIdentification);
	}

	public SimpleStringProperty getTransmissionIdentificationProperty() {
		return this.transmissionIdentification;
	}

	public String getTransmissionIdentification() {
		return this.transmissionIdentification.get();
	}

	public void setTransmissionIdentification(String transmissionIdentification) {
		this.transmissionIdentification.set(transmissionIdentification);
	}

	public SimpleStringProperty getTransmissionExtruderNameProperty() {
		return this.transmissionExtruderName;
	}

	public String getTransmissionExtruderName() {
		return this.transmissionExtruderName.get();
	}

	public void setTransmissionExtruderName(String transmissionExtruderName) {
		this.transmissionExtruderName.set(transmissionExtruderName);
	}

	public SimpleStringProperty getTransmissionDateProperty() {
		return this.transmissionDate;
	}

	public String getTransmissionDate() {
		return this.transmissionDate.get();
	}

	public void setTransmissionDate(String transmissionDate) {
		this.transmissionDate.set(transmissionDate);
	}

	public SimpleStringProperty getTransmissionWorkerNameProperty() {
		return this.transmissionWorkerName;
	}

	public String getTransmissionWorkerName() {
		return this.transmissionWorkerName.get();
	}

	public void setTransmissionWorkerName(String transmissionWorkerName) {
		this.transmissionWorkerName.set(transmissionWorkerName);
	}

	public SimpleStringProperty getTransmissionClientNameProperty() {
		return this.transmissionClientName;
	}

	public String getTransmissionClientName() {
		return this.transmissionClientName.get();
	}

	public void setTransmissionClientName(String transmissionClientName) {
		this.transmissionClientName.set(transmissionClientName);
	}

	public SimpleStringProperty getTransmissionExtruderActualSizeroperty() {
		return this.transmissionExtruderActualSize;
	}

	public String getTransmissionExtruderActualSize() {
		return this.transmissionExtruderActualSize.get();
	}

	public void setTransmissionExtruderActualSize(String transmissionExtruderActualSize) {
		this.transmissionExtruderActualSize.set(transmissionExtruderActualSize);
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

	public SimpleStringProperty getTransmissionSpoolProperty() {
		return this.transmissionSpool;
	}

	public String getTransmissionSpool() {
		return this.transmissionSpool.get();
	}

	public void setTransmissionSpool(String transmissionSpool) {
		this.transmissionSpool.set(transmissionSpool);
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
