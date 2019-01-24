package com.project.setting.worker.controller;

import com.project.setting.worker.database.WorkersDataBase;
import com.project.setting.worker.pojo.Workers;
import com.setting.label.MessageLabel;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class WorkersController {
	private WorkersDataBase workersDataBase = new WorkersDataBase();
	private TextField workersName, workersNumber;
	private Label messageLbl;

	public void setTextField(TextField workersName, TextField workersNumber, Label messageLbl) {
		this.workersName = workersName;
		this.workersNumber = workersNumber;
		this.messageLbl = messageLbl;
		if (checkTextField()) {
			workersDataBase.addWorker(new Workers(workersName.getText(), workersNumber.getText(), "Aktív"));
			new MessageLabel().goodMessage("Sikeres mentés", messageLbl);
		} else {
			new MessageLabel().errorMessage("Sikertelen mentés", messageLbl);
}

	}
	

	private boolean checkTextField() {
		if (workersName.getText().trim().isEmpty()) {
			workersName.setStyle(" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;");
		} else {
			workersName.setStyle(null);
		}
		if (workersNumber.getText().trim().isEmpty()) {
			workersNumber.setStyle(" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;");
		} else {
			workersNumber.setStyle(null);
		}
		if (workersName.getText().trim().isEmpty() || workersNumber.getText().trim().isEmpty()) {
			return false;
		} else {
			return true;
		}

	}

}
