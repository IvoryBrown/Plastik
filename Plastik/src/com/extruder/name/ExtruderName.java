package com.extruder.name;

import com.project.setting.machine.database.MachineDataBase;
import com.project.setting.machine.pojo.Machine;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

public class ExtruderName {
	private final ObservableList<Machine> dataExtruderName = FXCollections.observableArrayList();
	private MachineDataBase machineDataBase = new MachineDataBase();

	public ExtruderName(Button extruderNameBtn1, Button extruderNameBtn2, Button extruderNameBtn3,
			Button extruderNameBtn4, Button extruderNameBtn5, Button extruderNameBtn6, Button extruderNameBtn7,
			Button extruderNameBtn8, Button extruderNameBtn9, Button extruderNameBtn10, Button extruderNameBtn11,
			Button extruderNameBtn12, Button extruderNameBtn13, Button extruderNameBtn14) {
		dataExtruderName.addAll(machineDataBase.getAllMachine());
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
