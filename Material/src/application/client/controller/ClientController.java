package application.client.controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import application.client.database.ClientDB;
import application.client.main.NewUpdateClient;
import application.client.pojo.Client;
import application.client.pojo.ClientUpdate;
import application.setting.check.CheckExit;
import application.setting.message.Message;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.StageStyle;

public class ClientController implements Initializable {
	@FXML
	private Button exitButton, newClientButton;
	@FXML
	private TextField searchTxt;
	@FXML
	private AnchorPane clientAnchorPane;
	@FXML
	private TableView<Client> clientTabelView;
	private TableColumn<Client, Integer> clientId, clientZipCode, clientSZipCode;
	private TableColumn<Client, String> clientCompany, clientCounty, clientCity, clientAddress, clientSCounty,
			clientSCity, clientSAddress, clientName, clientPhone, clientEmail, clientComment;
	@FXML
	private Label messageLbl;
	private ClientDB clientDB = new ClientDB();

	// exit app
	@FXML
	private void exitButton() {
		CheckExit.exitWindow(exitButton);
	}

	// New Client
	@FXML
	private void newClientButton() {
		new NewUpdateClient().StartNewClient();
	}

	// update client
	@FXML
	private void updateClientButton() {
		if (clientTabelView.getSelectionModel().getSelectedItem() != null) {
			new NewUpdateClient().StartUpdateClient();
			messageLbl.setText(null);
		} else {
			Message.noMessage(messageLbl, "Válasz egy ügyfelet!");
		}

	}

	// refresh table
	@FXML
	private void refreshButton() {
		clientTabelView.setItems(workerData(""));
		Message.yesMessage(messageLbl, "Sikeres frissités!");
	}

	// delete client
	@FXML
	private void deleteButton() {
		if (clientTabelView.getSelectionModel().getSelectedItem() != null) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Törlés");
			alert.setHeaderText("");
			alert.getDialogPane().getStylesheets().add("/application/css/ShowInfo.css");
			alert.initStyle(StageStyle.TRANSPARENT);
			String s = "Biztos törölni szeretnéd ?";
			alert.setContentText(s);
			Optional<ButtonType> result = alert.showAndWait();
			if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
				clientDB.removeClient(ClientUpdate.getClientId());
				refreshButton();
				Message.yesMessage(messageLbl, "Sikeres törlés!");
			}
		} else {
			Message.noMessage(messageLbl, "Válasz egy ügyfelet!");
		}

	}

	// Table
	private void setClientTableData() {
		// ID column
		clientId = new TableColumn<Client, Integer>("IDNR");
		clientId.setCellValueFactory(new PropertyValueFactory<Client, Integer>("clientId"));

		clientCompany = new TableColumn<Client, String>("Név");
		clientCompany.setCellValueFactory(new PropertyValueFactory<Client, String>("clientCompany"));

		clientCounty = new TableColumn<Client, String>("Ország");
		clientCounty.setCellValueFactory(new PropertyValueFactory<Client, String>("clientCounty"));

		clientZipCode = new TableColumn<Client, Integer>("Irány.");
		clientZipCode.setCellValueFactory(new PropertyValueFactory<Client, Integer>("clientZipCode"));

		clientCity = new TableColumn<Client, String>("Város");
		clientCity.setCellValueFactory(new PropertyValueFactory<Client, String>("clientCity"));

		clientAddress = new TableColumn<Client, String>("Cím");
		clientAddress.setCellValueFactory(new PropertyValueFactory<Client, String>("clientAddress"));

		clientSCounty = new TableColumn<Client, String>("Ország Száll.");
		clientSCounty.setCellValueFactory(new PropertyValueFactory<Client, String>("clientSCounty"));

		clientSZipCode = new TableColumn<Client, Integer>("Irány. Száll.");
		clientSZipCode.setCellValueFactory(new PropertyValueFactory<Client, Integer>("clientSZipCode"));

		clientSCity = new TableColumn<Client, String>("Város Száll.");
		clientSCity.setCellValueFactory(new PropertyValueFactory<Client, String>("clientSCity"));

		clientSAddress = new TableColumn<Client, String>("Cím Száll.");
		clientSAddress.setCellValueFactory(new PropertyValueFactory<Client, String>("clientSAddress"));

		clientName = new TableColumn<Client, String>("Kapcsolattartó");
		clientName.setCellValueFactory(new PropertyValueFactory<Client, String>("clientName"));

		clientPhone = new TableColumn<Client, String>("Telefonszám");
		clientPhone.setCellValueFactory(new PropertyValueFactory<Client, String>("clientPhone"));

		clientEmail = new TableColumn<Client, String>("E-mail");
		clientEmail.setCellValueFactory(new PropertyValueFactory<Client, String>("clientEmail"));

		clientComment = new TableColumn<Client, String>("Megjegyzés");
		clientComment.setCellValueFactory(new PropertyValueFactory<Client, String>("clientComment"));

		// Tabel select mouse
		clientTabelView.setOnMouseClicked((MouseEvent event) -> {
			if (event.getClickCount() > 0) {
				this.onEdit();
			}
		});

	}

	// table mouse action
	private void onEdit() {
		// check the table's selected item and get selected item
		// pojo clientupdate
		if (clientTabelView.getSelectionModel().getSelectedItem() != null) {
			Client selectedPerson = clientTabelView.getSelectionModel().getSelectedItem();
			ClientUpdate.setClientId(selectedPerson.getClientId());
			ClientUpdate.setClientCompany(selectedPerson.getClientCompany());
			ClientUpdate.setClientCounty(selectedPerson.getClientCounty());
			ClientUpdate.setClientZipCode(selectedPerson.getClientZipCode());
			ClientUpdate.setClientCity(selectedPerson.getClientCity());
			ClientUpdate.setClientAddress(selectedPerson.getClientAddress());
			ClientUpdate.setClientSCounty(selectedPerson.getClientSCounty());
			ClientUpdate.setClientSZipCode(selectedPerson.getClientSZipCode());
			ClientUpdate.setClientSCity(selectedPerson.getClientSCity());
			ClientUpdate.setClientName(selectedPerson.getClientName());
			ClientUpdate.setClientPhone(selectedPerson.getClientPhone());
			ClientUpdate.setClientEmail(selectedPerson.getClientEmail());
			ClientUpdate.setClientComment(selectedPerson.getClientComment());
		}
	}

	// kwyboard
	private void setKeyEvent() {
		// ESC exit button
		clientAnchorPane.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			if (key.getCode() == KeyCode.ESCAPE) {
				CheckExit.exitWindow(exitButton);
			}
		});

		// Update client
		clientAnchorPane.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			if (key.getCode() == KeyCode.F11) {
				if (clientTabelView.getSelectionModel().getSelectedItem() != null) {
					new NewUpdateClient().StartUpdateClient();
					messageLbl.setText(null);
				} else {
					Message.noMessage(messageLbl, "Válasz egy ügyfelet!");
				}

			}
		});

		// new client
		clientAnchorPane.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			if (key.getCode() == KeyCode.F10) {
				new NewUpdateClient().StartNewClient();
			}
		});

		// refresh client
		clientAnchorPane.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			if (key.getCode() == KeyCode.F5) {
				refreshButton();
				Message.yesMessage(messageLbl, "Sikeres frissités!");
			}
		});

		// delete client
		clientAnchorPane.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			if (key.getCode() == KeyCode.DELETE) {
				if (clientTabelView.getSelectionModel().getSelectedItem() != null) {
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Törlés");
					alert.setHeaderText("");
					alert.getDialogPane().getStylesheets().add("/application/css/ShowInfo.css");
					alert.initStyle(StageStyle.TRANSPARENT);
					String s = "Biztos törölni szeretnéd ?";
					alert.setContentText(s);
					Optional<ButtonType> result = alert.showAndWait();
					if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
						clientDB.removeClient(ClientUpdate.getClientId());
						refreshButton();
						Message.yesMessage(messageLbl, "Sikeres törlés!");
					}
				} else {
					Message.noMessage(messageLbl, "Válasz egy ügyfelet!");
				}
			}
		});
	}

	// auto update table
//	private  void refreshTable() {
//
//		Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(3), new EventHandler<ActionEvent>() {
//
//			@Override
//			public void handle(ActionEvent event) {
//				clientTabelView.setItems(workerData());
//			}
//		}));
//		fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
//		fiveSecondsWonder.play();
//	
//		
//
//	}

	// client DB list
	public ObservableList<Client> workerData(String client) {
		final ObservableList<Client> workerData = FXCollections.observableArrayList();
		workerData.addAll(clientDB.getAllClient(client));
		return workerData;

	}

	// Search Cliens
	private void saerchClient() {
		searchTxt.textProperty().addListener((observable, oldValue, newValue) -> {
			clientTabelView.setItems(workerData(newValue));
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.setKeyEvent();
		clientTabelView.setItems(workerData(""));
		clientTabelView.setPlaceholder(new Label("Nincs megjeleníthető adat!"));
		this.setClientTableData();
		clientTabelView.getColumns().addAll(clientId, clientCompany, clientCounty, clientZipCode, clientCity,
				clientAddress, clientSCounty, clientSZipCode, clientSCity, clientSAddress, clientName, clientPhone,
				clientEmail, clientComment);
		this.saerchClient();
	}

}
