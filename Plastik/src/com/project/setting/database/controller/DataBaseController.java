package com.project.setting.database.controller;

import com.setting.file.DBFileWriter;
import com.setting.label.MessageLabel;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DataBaseController {
	private TextField urlTxt, userNameTxt, passwordTxt;
	private Label messageLbl;

	public void setTexField(TextField urlTxt, TextField userNameTxt, TextField passwordTxt, Label messageLbl) {
		this.messageLbl = messageLbl;
		this.urlTxt = urlTxt;
		this.userNameTxt = userNameTxt;
		this.passwordTxt = passwordTxt;
		DBFileWriter.setDataBaseOutput();
		urlTxt.setText(DBFileWriter.getDBOutput());
		userNameTxt.setText(DBFileWriter.getNameOutput());
		passwordTxt.setText(DBFileWriter.getPasswordOutput());
	}
	
	private void setTextField() {
		DBFileWriter.setDataBaseOutput();
		urlTxt.setText(DBFileWriter.getDBOutput());
		userNameTxt.setText(DBFileWriter.getNameOutput());
		passwordTxt.setText(DBFileWriter.getPasswordOutput());
}

	public void setDBtextField() {
		if (urlTxt.getText().trim().isEmpty() || userNameTxt.getText().trim().isEmpty()) {
			new MessageLabel().errorMessage("Sikertelen mentés!", messageLbl);
			setTextField();
		} else {
			DBFileWriter.writeDB(urlTxt.getText(), userNameTxt.getText(), passwordTxt.getText());
			new MessageLabel().goodMessage("Sikeres mentés!", messageLbl);
		}

	}

}
