package com.project.setting.worker.controller;

import com.project.setting.worker.database.WorkersDataBase;
import com.project.setting.worker.pojo.Workers;

import javafx.scene.control.TextField;

public class WorkersController {
	private WorkersDataBase workersDataBase = new WorkersDataBase();

	public void setTextField(TextField workersName, TextField workersNumber) {
		workersDataBase.addWorker(new Workers(workersName.getText(), workersNumber.getText(), "Aktív"));

	}

}
