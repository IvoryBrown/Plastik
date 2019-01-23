package com.project.setting.worker.pojo;

import javafx.beans.property.SimpleStringProperty;

public class Workers {
	private final SimpleStringProperty workersId;
	private final SimpleStringProperty workersName;
	private final SimpleStringProperty workersPassword;
	private final SimpleStringProperty workersStatus;

	public Workers() {
		this.workersId = new SimpleStringProperty("");
		this.workersName = new SimpleStringProperty("");
		this.workersPassword = new SimpleStringProperty("");
		this.workersStatus = new SimpleStringProperty("");
	}

	public Workers(String workersName, String workersPassword, String workersStatus) {
		this.workersId = new SimpleStringProperty("");
		this.workersName = new SimpleStringProperty(workersName);
		this.workersPassword = new SimpleStringProperty(workersPassword);
		this.workersStatus = new SimpleStringProperty(workersStatus);
	}

	public Workers(Integer workersId, String workersName, String workersPassword, String workersStatus) {
		this.workersId = new SimpleStringProperty(String.valueOf(workersId));
		this.workersName = new SimpleStringProperty(workersName);
		this.workersPassword = new SimpleStringProperty(workersPassword);
		this.workersStatus = new SimpleStringProperty(workersStatus);
	}

	public SimpleStringProperty getWorkersIdProperty() {
		return this.workersId;
	}

	public String getWorkersId() {
		return this.workersId.get();
	}

	public void setWorkersId(String workersId) {
		this.workersId.set(workersId);
	}

	public SimpleStringProperty getWorkersNameProperty() {
		return this.workersName;
	}

	public String getWorkersName() {
		return this.workersName.get();
	}

	public void setWorkersName(String workersName) {
		this.workersName.set(workersName);
	}

	public SimpleStringProperty getWorkersPasswordProperty() {
		return this.workersPassword;
	}

	public String getWorkersPassword() {
		return this.workersPassword.get();
	}

	public void setWorkersPassword(String workersPassword) {
		this.workersPassword.set(workersPassword);
	}

	public SimpleStringProperty getWorkersStatusProperty() {
		return this.workersStatus;
	}

	public String getWorkersStatus() {
		return this.workersStatus.get();
	}

	public void setWorkersStatus(String workersStatus) {
		this.workersStatus.set(workersStatus);
	}

}
