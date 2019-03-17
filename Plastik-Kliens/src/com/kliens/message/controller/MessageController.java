package com.kliens.message.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.kliens.message.database.MessageDataBase;
import com.kliens.message.main.MessageMain;
import com.kliens.message.pojo.Kliens;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class MessageController implements Initializable {
	@FXML
	private TextArea messageKliensTxt;

	@FXML
	private void messageBtn() {
		Kliens.setTrue();
		new MessageDataBase().updateClient("1", false);
		MessageMain.primaryStage.close();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		messageKliensTxt.setText(Kliens.message().get(0).getMessage());
	}

}
