package com.office.client.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.office.client.database.ClientDataBase;
import com.office.client.pojo.Client;
import com.setting.label.MessageLabel;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ClientController {
	private Label addNewClientMessageLabel;
	private TextField clientNameTxt, clientPostcodeTxt, clientCityTxt, clientStreetTxt, clientPhoneTxt, clientMailTxt;
	private TextArea clientCommentTxt;
	private ClientDataBase clientDB = new ClientDataBase();

	public ClientController(Label addNewClientMessageLabel, TextField clientNameTxt, TextField clientPostcodeTxt,
			TextField clientCityTxt, TextField clientStreetTxt, TextField clientPhoneTxt, TextField clientMailTxt,
			TextArea clientCommentTxt) {
		this.addNewClientMessageLabel = addNewClientMessageLabel;
		this.clientNameTxt = clientNameTxt;
		this.clientPostcodeTxt = clientPostcodeTxt;
		this.clientCityTxt = clientCityTxt;
		this.clientStreetTxt = clientStreetTxt;
		this.clientPhoneTxt = clientPhoneTxt;
		this.clientMailTxt = clientMailTxt;
		this.clientCommentTxt = clientCommentTxt;
		addClient();
	}
	

	private boolean checkClient() {
		if (clientNameTxt.getText().trim().isEmpty()) {
			clientNameTxt.setStyle(" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;");
		} else {
			clientNameTxt.setStyle(null);
		}
		if (clientPostcodeTxt.getText().trim().isEmpty()) {
			clientPostcodeTxt.setStyle(" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;");
		} else {
			clientPostcodeTxt.setStyle(null);
		}
		if (clientCityTxt.getText().trim().isEmpty()) {
			clientCityTxt.setStyle(" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;");
		} else {
			clientCityTxt.setStyle(null);
		}
		if (clientStreetTxt.getText().trim().isEmpty()) {
			clientStreetTxt.setStyle(" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;");
		} else {
			clientStreetTxt.setStyle(null);
		}
		if (clientNameTxt.getText().trim().isEmpty() || clientPostcodeTxt.getText().trim().isEmpty()
				|| clientCityTxt.getText().trim().isEmpty() || clientStreetTxt.getText().trim().isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	private boolean checkClientMail() {
		Pattern emailPattern = Pattern.compile(
				"^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
		if (!clientMailTxt.getText().trim().isEmpty()) {
			Matcher m = emailPattern.matcher(clientMailTxt.getText());
			if (m.matches()) {
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

	private void textClear() {
		this.clientNameTxt.clear();
		this.clientPostcodeTxt.clear();
		this.clientCityTxt.clear();
		this.clientStreetTxt.clear();
		this.clientPhoneTxt.clear();
		this.clientMailTxt.clear();
		this.clientCommentTxt.clear();

	}

	private void addClient() {
		if (checkClient()) {
			if (checkClientMail()) {
				clientDB.addClient(new Client(clientNameTxt.getText(), clientPostcodeTxt.getText(),
						clientCityTxt.getText(), clientStreetTxt.getText(), clientPhoneTxt.getText(),
						clientMailTxt.getText(), clientCommentTxt.getText()));
				new MessageLabel().goodMessage("Sikeres mentés", addNewClientMessageLabel);
				textClear();
			} else {
				new MessageLabel().errorMessage("Nem megfelelő email", addNewClientMessageLabel);
			}

		} else {
			new MessageLabel().errorMessage("Sikertelen mentés", addNewClientMessageLabel);
		}
	}
}
