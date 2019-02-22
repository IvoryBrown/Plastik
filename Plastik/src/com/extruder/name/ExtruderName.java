package com.extruder.name;

import com.project.setting.machine.database.MachineDataBase;
import com.project.setting.machine.pojo.Machine;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ToggleButton;

public class ExtruderName {
	private final ObservableList<Machine> dataExtruderName = FXCollections.observableArrayList();
	private MachineDataBase machineDataBase = new MachineDataBase();

	public ExtruderName(ToggleButton extruderNameAllBtn, ToggleButton extruderNameBtn1, ToggleButton extruderNameBtn2, ToggleButton extruderNameBtn3,
			ToggleButton extruderNameBtn4, ToggleButton extruderNameBtn5, ToggleButton extruderNameBtn6, ToggleButton extruderNameBtn7,
			ToggleButton extruderNameBtn8, ToggleButton extruderNameBtn9, ToggleButton extruderNameBtn10, ToggleButton extruderNameBtn11,
			ToggleButton extruderNameBtn12, ToggleButton extruderNameBtn13, ToggleButton extruderNameBtn14) {
		dataExtruderName.addAll(machineDataBase.getAllMachine());
		extruderNameAllBtn.setText("Összes");
		extruderNameBtn1.setText(dataExtruderName.get(0).getMachineName());
		extruderNameBtn2.setText(dataExtruderName.get(1).getMachineName());
		extruderNameBtn3.setText(dataExtruderName.get(2).getMachineName());
		extruderNameBtn4.setText(dataExtruderName.get(3).getMachineName());
		extruderNameBtn5.setText(dataExtruderName.get(4).getMachineName());
		extruderNameBtn6.setText(dataExtruderName.get(5).getMachineName());
		extruderNameBtn7.setText(dataExtruderName.get(6).getMachineName());
		extruderNameBtn8.setText(dataExtruderName.get(7).getMachineName());
		extruderNameBtn9.setText(dataExtruderName.get(8).getMachineName());
		extruderNameBtn10.setText(dataExtruderName.get(9).getMachineName());
		extruderNameBtn11.setText(dataExtruderName.get(10).getMachineName());
		extruderNameBtn12.setText(dataExtruderName.get(11).getMachineName());
		extruderNameBtn13.setText(dataExtruderName.get(12).getMachineName());
		extruderNameBtn14.setText(dataExtruderName.get(13).getMachineName());

	}
}
