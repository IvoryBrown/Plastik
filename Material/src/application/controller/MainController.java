package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.client.main.ClientMain;
import application.extruder.main.ExtruderMain;
import application.setting.check.CheckExit;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class MainController implements Initializable {
	// Fooldal; partnerek
	// Fo panel
	@FXML
	private Button clientButton, extruderButton, exitButton;
	@FXML
	private AnchorPane testAnchorpena;

	// cliens
	@FXML
	private void clientButton() {
		new ClientMain().Start();
	}

	// cliens
	@FXML
	private void extruderButton() {
	new ExtruderMain().Start();
	}

	// exit
	@FXML
	private void exitButton() {
		CheckExit.exitApp();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// keyboard exit
		testAnchorpena.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			if (key.getCode() == KeyCode.ESCAPE) {
				CheckExit.exitApp();
			}
		});

		// keyboard client
		testAnchorpena.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			if (key.getCode() == KeyCode.F7) {
				new ClientMain().Start();
			}
		});

		// keyboard client
		testAnchorpena.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			if (key.getCode() == KeyCode.F8) {
				new ExtruderMain().Start();
			}
		});

	}

}
