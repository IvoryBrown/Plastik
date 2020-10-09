package application.client.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.client.database.ClientDB;
import application.client.pojo.Client;
import application.setting.check.CheckExit;
import application.setting.check.MailCheck;
import application.setting.check.TextFieldNull;
import application.setting.check.TextFieldNumber;
import application.setting.message.Message;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class NewClientController implements Initializable {
	@FXML
	private TextField clientCompanyTxt, clientCountyTxt, clientZipCodeTxt, clientCityTxt, clientAddressTxt,
			clientSCountyTxt, clientSZipCodeTxt, clientSCityTxt, clientSAddressTxt, clientNameTxt, clientPhoneTxt,
			clientEmailTxt;
	@FXML
	private TextArea clientCommentTxt;
	@FXML
	private Button saveButton, noButton;
	@FXML
	private AnchorPane clientAnchorPane;
	@FXML
	private Label messageLbl;

	private ClientDB clientDB = new ClientDB();

	@FXML
	private void saveButton() {
		updateClientDB();
	}

	// Copy A txt to B txt
	@FXML
	private void copyButton() {
		clientSCountyTxt.setText(clientCountyTxt.getText());
		clientSZipCodeTxt.setText(clientZipCodeTxt.getText());
		clientSCityTxt.setText(clientCityTxt.getText());
		clientSAddressTxt.setText(clientAddressTxt.getText());

	}

	//add database 
	private void updateClientDB() {
		if (TextFieldNull.checkTextField(clientCompanyTxt, clientCountyTxt, clientZipCodeTxt, clientCityTxt,
				clientAddressTxt)) {
			if (MailCheck.checkClientMail(clientEmailTxt.getText())) {
				clientDB.addClient(new Client(clientCompanyTxt.getText(), clientCountyTxt.getText(),
						clientZipCodeTxt.getText(), clientCityTxt.getText(), clientAddressTxt.getText(),
						clientSCountyTxt.getText(), clientSZipCodeTxt.getText(), clientSCityTxt.getText(),
						clientSAddressTxt.getText(), clientNameTxt.getText(), clientPhoneTxt.getText(),
						clientEmailTxt.getText(), clientCommentTxt.getText()));
				CheckExit.exitWindow(noButton);
			} else {
				Message.noMessage(messageLbl, "Nem megfelelő email cím");
			}

		} else {
			Message.noMessage(messageLbl, "Sikertelen mentés");
		}

	}

	@FXML
	private void noButton() {
		CheckExit.exitWindow(noButton);

	}

	// kwyboard
	private void setKeyEvent() {
		// ESC exit button
		clientAnchorPane.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			if (key.getCode() == KeyCode.ESCAPE) {
				CheckExit.exitWindow(noButton);
			}
		});

		clientAnchorPane.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			if (key.getCode() == KeyCode.F10) {
				updateClientDB();
			}
		});
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setKeyEvent();
		TextFieldNumber.checkNumberTextField(clientZipCodeTxt);
		TextFieldNumber.checkNumberTextField(clientSZipCodeTxt);
	}

}
