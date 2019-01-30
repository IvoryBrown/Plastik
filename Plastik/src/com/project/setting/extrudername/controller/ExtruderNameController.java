package com.project.setting.extrudername.controller;

import com.project.setting.machine.database.MachineDataBase;
import com.project.setting.machine.pojo.Machine;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;

public class ExtruderNameController {
	private Label extruder1NameLabel, extruder2NameLabel, extruder3NameLabel, extruder4NameLabel, extruder5NameLabel,
			extruder6NameLabel, extruder7NameLabel, extruder8NameLabel, extruder9NameLabel, extruder10NameLabel,
			extruder11NameLabel, extruder12NameLabel, extruder13NameLabel, extruder14NameLabel, extruder15NameLabel,
			extruder16NameLabel, extruder17NameLabel, extruder18NameLabel;
	private final ObservableList<Machine> dataExtruderName = FXCollections.observableArrayList();
	private MachineDataBase machineDataBase = new MachineDataBase();

	public ExtruderNameController(Label extruder1NameLabel, Label extruder2NameLabel, Label extruder3NameLabel,
			Label extruder4NameLabel, Label extruder5NameLabel, Label extruder6NameLabel, Label extruder7NameLabel,
			Label extruder8NameLabel, Label extruder9NameLabel, Label extruder10NameLabel, Label extruder11NameLabel,
			Label extruder12NameLabel, Label extruder13NameLabel, Label extruder14NameLabel, Label extruder15NameLabel,
			Label extruder16NameLabel, Label extruder17NameLabel, Label extruder18NameLabel) {
		this.extruder1NameLabel = extruder1NameLabel;
		this.extruder2NameLabel = extruder2NameLabel;
		this.extruder3NameLabel = extruder3NameLabel;
		this.extruder4NameLabel = extruder4NameLabel;
		this.extruder5NameLabel = extruder5NameLabel;
		this.extruder6NameLabel = extruder6NameLabel;
		this.extruder7NameLabel = extruder7NameLabel;
		this.extruder8NameLabel = extruder8NameLabel;
		this.extruder9NameLabel = extruder9NameLabel;
		this.extruder10NameLabel = extruder10NameLabel;
		this.extruder11NameLabel = extruder11NameLabel;
		this.extruder12NameLabel = extruder12NameLabel;
		this.extruder13NameLabel = extruder13NameLabel;
		this.extruder14NameLabel = extruder14NameLabel;
		this.extruder15NameLabel = extruder15NameLabel;
		this.extruder16NameLabel = extruder16NameLabel;
		this.extruder17NameLabel = extruder17NameLabel;
		this.extruder18NameLabel = extruder18NameLabel;
		dataExtruderName.addAll(machineDataBase.getAllMachine());
		setLabel();
	}

	private void setLabel() {
		extruder1NameLabel.setText(dataExtruderName.get(0).getMachineName());
		extruder2NameLabel.setText(dataExtruderName.get(1).getMachineName());
		extruder3NameLabel.setText(dataExtruderName.get(2).getMachineName());
		extruder4NameLabel.setText(dataExtruderName.get(3).getMachineName());
		extruder5NameLabel.setText(dataExtruderName.get(4).getMachineName());
		extruder6NameLabel.setText(dataExtruderName.get(5).getMachineName());
		extruder7NameLabel.setText(dataExtruderName.get(6).getMachineName());
		extruder8NameLabel.setText(dataExtruderName.get(7).getMachineName());
		extruder9NameLabel.setText(dataExtruderName.get(8).getMachineName());
		extruder10NameLabel.setText(dataExtruderName.get(9).getMachineName());
		extruder11NameLabel.setText(dataExtruderName.get(10).getMachineName());
		extruder12NameLabel.setText(dataExtruderName.get(11).getMachineName());
		extruder13NameLabel.setText(dataExtruderName.get(12).getMachineName());
		extruder14NameLabel.setText(dataExtruderName.get(13).getMachineName());
		extruder15NameLabel.setText(dataExtruderName.get(14).getMachineName());
		extruder16NameLabel.setText(dataExtruderName.get(15).getMachineName());
		extruder17NameLabel.setText(dataExtruderName.get(16).getMachineName());
		extruder18NameLabel.setText(dataExtruderName.get(17).getMachineName());
	}
}
