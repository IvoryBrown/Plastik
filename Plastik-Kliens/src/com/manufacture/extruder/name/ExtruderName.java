package com.manufacture.extruder.name;

import com.project.setting.machine.database.MachineDataBase;
import com.project.setting.machine.pojo.Machine;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ToggleButton;

public class ExtruderName {
	private final ObservableList<Machine> dataExtruderName = FXCollections.observableArrayList();
	private MachineDataBase machineDataBase = new MachineDataBase();

	public ExtruderName( ToggleButton extruderNameBtn1, ToggleButton extruderNameBtn2, ToggleButton extruderNameBtn3,
			ToggleButton extruderNameBtn4, ToggleButton extruderNameBtn5, ToggleButton extruderNameBtn6, ToggleButton extruderNameBtn7,
			ToggleButton extruderNameBtn8, ToggleButton extruderNameBtn9, ToggleButton extruderNameBtn10, ToggleButton extruderNameBtn11,
			ToggleButton extruderNameBtn12, ToggleButton extruderNameBtn13, ToggleButton extruderNameBtn14) {
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
		extruderNameBtn1. getStylesheets().add(getClass().getResource("/com/main/view/css/button.css").toExternalForm());
		extruderNameBtn1.getStyleClass().add("extruderButton");
		extruderNameBtn2. getStylesheets().add(getClass().getResource("/com/main/view/css/button.css").toExternalForm());
		extruderNameBtn2.getStyleClass().add("extruderButton");
		extruderNameBtn3. getStylesheets().add(getClass().getResource("/com/main/view/css/button.css").toExternalForm());
		extruderNameBtn3.getStyleClass().add("extruderButton");
		extruderNameBtn4. getStylesheets().add(getClass().getResource("/com/main/view/css/button.css").toExternalForm());
		extruderNameBtn4.getStyleClass().add("extruderButton");
		extruderNameBtn5. getStylesheets().add(getClass().getResource("/com/main/view/css/button.css").toExternalForm());
		extruderNameBtn5.getStyleClass().add("extruderButton");
		extruderNameBtn6. getStylesheets().add(getClass().getResource("/com/main/view/css/button.css").toExternalForm());
		extruderNameBtn6.getStyleClass().add("extruderButton");
		extruderNameBtn7. getStylesheets().add(getClass().getResource("/com/main/view/css/button.css").toExternalForm());
		extruderNameBtn7.getStyleClass().add("extruderButton");
		extruderNameBtn8. getStylesheets().add(getClass().getResource("/com/main/view/css/button.css").toExternalForm());
		extruderNameBtn8.getStyleClass().add("extruderButton");
		extruderNameBtn9. getStylesheets().add(getClass().getResource("/com/main/view/css/button.css").toExternalForm());
		extruderNameBtn9.getStyleClass().add("extruderButton");
		extruderNameBtn10. getStylesheets().add(getClass().getResource("/com/main/view/css/button.css").toExternalForm());
		extruderNameBtn10.getStyleClass().add("extruderButton");
		extruderNameBtn11. getStylesheets().add(getClass().getResource("/com/main/view/css/button.css").toExternalForm());
		extruderNameBtn11.getStyleClass().add("extruderButton");
		extruderNameBtn12. getStylesheets().add(getClass().getResource("/com/main/view/css/button.css").toExternalForm());
		extruderNameBtn12.getStyleClass().add("extruderButton");
		extruderNameBtn13. getStylesheets().add(getClass().getResource("/com/main/view/css/button.css").toExternalForm());
		extruderNameBtn13.getStyleClass().add("extruderButton");
		extruderNameBtn14. getStylesheets().add(getClass().getResource("/com/main/view/css/button.css").toExternalForm());
		extruderNameBtn14.getStyleClass().add("extruderButton");
	}
}
