package com.office.extruder.name;

import com.project.setting.machine.database.MachineDataBase;
import com.project.setting.machine.pojo.Machine;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ExtruderName {
	private final ObservableList<Machine> dataExtruderName = FXCollections.observableArrayList();
	private MachineDataBase machineDataBase = new MachineDataBase();

	public ExtruderName() {
		dataExtruderName.addAll(machineDataBase.getAllMachine());
		extruderName();
	}

	public String extruderName() {
		String name = dataExtruderName.get(0).getMachineName();
		return name;
	}
}
