package com.project.setting.machine.pojo;

import javafx.beans.property.SimpleStringProperty;

public class Machine {

	private final SimpleStringProperty machineId;
	private final SimpleStringProperty machineName;

	public Machine() {
		this.machineName = new SimpleStringProperty("");
		this.machineId = new SimpleStringProperty("");
	}

	public Machine(Integer machineId, String machineName) {
		this.machineId = new SimpleStringProperty(String.valueOf(machineId));
		this.machineName = new SimpleStringProperty(machineName);
	}

	public SimpleStringProperty getMachineIdProperty() {
		return this.machineId;
	}

	public String getMachineId() {
		return this.machineId.get();
	}

	public void setMachineId(String machineId) {
		this.machineId.set(machineId);
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
