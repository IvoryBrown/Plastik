package com.extruder.newjob.controller;

import com.client.database.ClientDataBase;
import com.client.pojo.Client;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class NewJobController {
	private TableView<Client> clientPopupTableView;
	private TableColumn<Client, String> clientName, clientPostcode, clientCity, clientStreet;
	private TextField extruderClientName;
	private final ObservableList<Client> dataClient = FXCollections.observableArrayList();
	private ClientDataBase clientDB = new ClientDataBase();
	private String clientId;

	@SuppressWarnings("unchecked")
	public NewJobController(TableView<Client> clientPopupTableView, TextField extruderClientName) {
		this.clientPopupTableView = clientPopupTableView;
		this.extruderClientName = extruderClientName;
		this.clientPopupTableView.getItems().clear();
		this.clientPopupTableView.getColumns().clear();
		clientPopupTableView.setItems(dataClient);
		setTable();
		clientPopupTable();
		clientPopupTableView.getColumns().addAll(clientName, clientPostcode, clientCity, clientStreet);
		
	}

	

	private void setTable() {
		extruderClientName.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!extruderClientName.getText().trim().isEmpty()) {
					clientPopupTableView.setVisible(true);
					popupDataClient(newValue);
				} else {
					clientPopupTableView.setVisible(false);
				}
			}
		});

		extruderClientName.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue,
					Boolean newPropertyValue) {
				if (!newPropertyValue) {
					if (!extruderClientName.getText().trim().isEmpty()) {
						clientPopupTableView.setVisible(true);
					} else {
						clientPopupTableView.setVisible(false);
					}
					clientPopupTableView.setVisible(false);
				}
			}
		});
	}

	private void clientPopupTable() {
		clientName = new TableColumn<>("Név");
		clientName.setMinWidth(210);
		clientName.setCellValueFactory(new PropertyValueFactory<Client, String>("clientName"));

		clientPostcode = new TableColumn<>("Irányítószám");
		clientPostcode.setMinWidth(100);
		clientPostcode.setCellValueFactory(new PropertyValueFactory<Client, String>("clientPostcode"));

		clientCity = new TableColumn<>("Helység");
		clientCity.setMinWidth(150);
		clientCity.setCellValueFactory(new PropertyValueFactory<Client, String>("clientCity"));

		clientStreet = new TableColumn<>("Utca, hsz");
		clientStreet.setMinWidth(150);
		clientStreet.setCellValueFactory(new PropertyValueFactory<Client, String>("clientStreet"));
		clientPopupTableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Client>() {
			@Override
			public void changed(ObservableValue<? extends Client> observable, Client oldValue, Client newValue) {
				if (oldValue == null || newValue != null) {
					extruderClientName.setText(newValue.getClientName());
					clientId = newValue.getClientId();
					clientPopupTableView.setVisible(false);
				}
			}
		});
	}

	private ObservableList<Client> popupDataClient(String s) {
		dataClient.clear();
		dataClient.addAll(clientDB.searchAllClient(s));
		return dataClient;
	}
}
