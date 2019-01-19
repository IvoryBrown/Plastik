package com.project.setting.database.controller;

import com.login.setting.setting.database.filewrite.SettingDBFile;
import com.setting.file.DBFileWriter;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DataBaseController {
	private TextField urlTxt, userNameTxt, passwordTxt;
	private Button saveBtn;

	public DataBaseController(TextField urlTxt, TextField userNameTxt, TextField passwordTxt, Button saveBtn) {
		urlTxt.setText(DBFileWriter.getDBOutput());
		userNameTxt.setText(DBFileWriter.getNameOutput());
		passwordTxt.setText(DBFileWriter.getPasswordOutput());
	}
}
