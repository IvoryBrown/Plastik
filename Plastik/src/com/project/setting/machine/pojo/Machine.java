package com.project.setting.machine.pojo;

import javafx.beans.property.SimpleStringProperty;

public class Machine {

	private final SimpleStringProperty machineName;

	public Machine() {
		this.machineName = new SimpleStringProperty("");
	}

	public Machine(String machineName) {
		this.machineName = new SimpleStringProperty(machineName);
	}

	public SimpleStringProperty getMachineNameProperty() {
		return this.machineName;
	}

	public String getMachineName() {
		return this.machineName.get();
	}

	public void setMachineName(String machineName) {
		this.machineName.set(machineName);
	}
}
