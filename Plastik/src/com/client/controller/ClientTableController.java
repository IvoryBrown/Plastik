package com.client.controller;

import com.client.database.ClientDataBase;
import com.client.pojo.Client;
import com.setting.label.MessageLabel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ClientTableController {
	private TableColumn<Client, Integer> clientId;
	private TableColumn<Client, String> clientName, clientPostcode, clientCity, clientStreet, clientPhone, clientMail,
			clientComment;
	private TableView<Client> clientTableView;
	private final ObservableList<Client> dataClient = FXCollections.observableArrayList();
	private ClientDataBase clientDB = new ClientDataBase();
	private Label clientTableMessageLabel;
	private TextField clientFilteringTxt;
	private Button clientFilteringBtn;
	private MessageLabel message = new MessageLabel();

	public ClientTableController(TableView<Client> clientTableView, Label clientTableMessageLabel,
			TextField clientFilteringTxt, Button clientFilteringBtn) {
		this.clientTableView = clientTableView;
		this.clientTableMessageLabel = clientTableMessageLabel;
		this.clientFilteringTxt = clientFilteringTxt;
		this.clientFilteringBtn = clientFilteringBtn;
		clearData();
		searchClientAction();
	}

	private void searchClient() {
		dataClient.clear();
		dataClient.addAll(clientDB.searchAllClient(clientFilteringTxt.getText()));
		if (dataClient.size() != 0) {
			message.goodMessage("Sikeres keresés: " + dataClient.size() + " találat", clientTableMessageLabel);
		} else {
			message.errorMessage("Sikertelen keresés: " + dataClient.size() + " találat", clientTableMessageLabel);
		}
		if (clientFilteringTxt.getText().trim().isEmpty()) {
			clientTableMessageLabel.setText("");
		}
	}

	private void clearData() {
		clientTableView.getItems().clear();
		clientTableView.getColumns().clear();
		dataClient.clear();
		clientTable();
	}

	private void searchClientAction() {
		clientFilteringTxt.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.ENTER)) {
					searchClient();
				}
			}
		});
		clientFilteringBtn.setOnAction((event) -> {
			searchClient();
		});
	}

	@SuppressWarnings("unchecked")
	private void clientTable() {
		clientId = new TableColumn<>("ID");
		clientId.setMinWidth(50);
		clientId.setCellValueFactory(new PropertyValueFactory<Client, Integer>("clientId"));

		clientName = new TableColumn<>("Név");
		clientName.setMinWidth(150);
		clientName.setCellValueFactory(new PropertyValueFactory<Client, String>("clientName"));
		clientName.setCellFactory(TextFieldTableCell.forTableColumn());
		clientName.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Client, String>>() {
			@Override
			public void handle(TableColumn.CellEditEvent<Client, String> d) {
				Client actualClient = (Client) d.getTableView().getItems().get(d.getTablePosition().getRow());
				if (!d.getNewValue().trim().isEmpty()) {
					actualClient.setClientName(d.getNewValue());
					message.goodMessage("Név sikeres frissitése", clientTableMessageLabel);
					clientDB.updateClient(actualClient);
				} else {
					errorDataClient();
					message.errorMessage("Üres a mező", clientTableMessageLabel);
				}

			}
		});

		clientPostcode = new TableColumn<>("Irányítószám");
		clientPostcode.setMinWidth(100);
		clientPostcode.setCellValueFactory(new PropertyValueFactory<Client, String>("clientPostcode"));
		clientPostcode.setCellFactory(TextFieldTableCell.forTableColumn());
		clientPostcode.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Client, String>>() {
			@Override
			public void handle(TableColumn.CellEditEvent<Client, String> d) {
				Client actualClient = (Client) d.getTableView().getItems().get(d.getTablePosition().getRow());
				if (!d.getNewValue().trim().isEmpty()) {
					actualClient.setClientPostcode(d.getNewValue());
					message.goodMessage("Irányítószám sikeres frissitése", clientTableMessageLabel);
					clientDB.updateClient(actualClient);
				} else {
					errorDataClient();
					message.errorMessage("Üres a mező", clientTableMessageLabel);
				}

			}
		});

		clientCity = new TableColumn<>("Helység");
		clientCity.setMinWidth(150);
		clientCity.setCellValueFactory(new PropertyValueFactory<Client, String>("clientCity"));
		clientCity.setCellFactory(TextFieldTableCell.forTableColumn());
		clientCity.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Client, String>>() {
			@Override
			public void handle(TableColumn.CellEditEvent<Client, String> d) {
				Client actualClient = (Client) d.getTableView().getItems().get(d.getTablePosition().getRow());
				if (!d.getNewValue().trim().isEmpty()) {
					actualClient.setClientCity(d.getNewValue());
					message.goodMessage("Helység sikeres frissitése", clientTableMessageLabel);
					clientDB.updateClient(actualClient);
				} else {
					errorDataClient();
					message.errorMessage("Üres a mező", clientTableMessageLabel);
				}

			}
		});

		clientStreet = new TableColumn<>("Utca, hsz");
		clientStreet.setMinWidth(150);
		clientStreet.setCellValueFactory(new PropertyValueFactory<Client, String>("clientStreet"));
		clientStreet.setCellFactory(TextFieldTableCell.forTableColumn());
		clientStreet.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Client, String>>() {
			@Override
			public void handle(TableColumn.CellEditEvent<Client, String> d) {
				Client actualClient = (Client) d.getTableView().getItems().get(d.getTablePosition().getRow());
				if (!d.getNewValue().trim().isEmpty()) {
					actualClient.setClientStreet(d.getNewValue());
					message.goodMessage("Utca, hsz sikeres frissitése", clientTableMessageLabel);
					clientDB.updateClient(actualClient);
				} else {
					errorDataClient();
					message.errorMessage("Üres a mező", clientTableMessageLabel);
				}

			}
		});

		clientPhone = new TableColumn<>("Mobil");
		clientPhone.setMinWidth(150);
		clientPhone.setCellValueFactory(new PropertyValueFactory<Client, String>("clientPhone"));
		clientPhone.setCellFactory(TextFieldTableCell.forTableColumn());
		clientPhone.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Client, String>>() {
			@Override
			public void handle(TableColumn.CellEditEvent<Client, String> d) {
				Client actualClient = (Client) d.getTableView().getItems().get(d.getTablePosition().getRow());
				actualClient.setClientPhone(d.getNewValue());
				message.goodMessage("Mobil sikeres frissitése", clientTableMessageLabel);
				clientDB.updateClient(actualClient);
			}
		});

		clientMail = new TableColumn<>("Email");
		clientMail.setMinWidth(150);
		clientMail.setCellValueFactory(new PropertyValueFactory<Client, String>("clientMail"));
		clientMail.setCellFactory(TextFieldTableCell.forTableColumn());
		clientMail.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Client, String>>() {
			@Override
			public void handle(TableColumn.CellEditEvent<Client, String> d) {
				Client actualClient = (Client) d.getTableView().getItems().get(d.getTablePosition().getRow());
				actualClient.setClientMail(d.getNewValue());
				message.goodMessage("Email sikeres frissitése", clientTableMessageLabel);
				clientDB.updateClient(actualClient);
			}
		});

		clientComment = new TableColumn<>("Megjegyzés");
		clientComment.setMinWidth(550);
		clientComment.setCellValueFactory(new PropertyValueFactory<Client, String>("clientComment"));
		clientComment.setCellFactory(TextFieldTableCell.forTableColumn());
		clientComment.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Client, String>>() {
			@Override
			public void handle(TableColumn.CellEditEvent<Client, String> d) {
				Client actualClient = (Client) d.getTableView().getItems().get(d.getTablePosition().getRow());
				actualClient.setClientComment(d.getNewValue());
				message.goodMessage("Megjegyzés sikeres frissitése", clientTableMessageLabel);
				clientDB.updateClient(actualClient);
			}
		});

		clientTableView.setItems(dataClient);
		clientTableView.getColumns().addAll(clientId, clientName, clientPostcode, clientCity, clientStreet, clientPhone,
				clientMail, clientComment);
		dataClient.addAll(clientDB.getAllClient());
	}

	private ObservableList<Client> errorDataClient() {
		dataClient.clear();
		dataClient.addAll(clientDB.getAllClient());
		return dataClient;

	}
}
