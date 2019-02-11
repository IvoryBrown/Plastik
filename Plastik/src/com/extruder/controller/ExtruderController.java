package com.extruder.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.client.database.ClientDataBase;
import com.client.pojo.Client;
import com.extruder.name.ExtruderName;
import com.menu.calculations.CalculationsController;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class ExtruderController implements Initializable {
	@FXML
	private MenuButton manufactureMenuBar;
	@FXML
	private Label messageLbl;
	@FXML
	private Button extruderNameBtn1, extruderNameBtn2, extruderNameBtn3, extruderNameBtn4, extruderNameBtn5,
			extruderNameBtn6, extruderNameBtn7, extruderNameBtn8, extruderNameBtn9, extruderNameBtn10,
			extruderNameBtn11, extruderNameBtn12, extruderNameBtn13, extruderNameBtn14;
	@FXML
	private Button extruderNewJobBtn;
	@FXML
	private AnchorPane extruderNewJobsPane, extruderActualJobsPane;
	@FXML
	private TableView<String> extruderTableView;
	@FXML
	private TableView<Client> clientPopupTableView;
	private TableColumn<Client, String> clientName, clientPostcode, clientCity, clientStreet;
	@FXML
	private TextField extruderClientName;
	private final ObservableList<Client> dataClient = FXCollections.observableArrayList();
	private ClientDataBase clientDB = new ClientDataBase();
	String test1;

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
	}

	@SuppressWarnings("unchecked")
	private void clientPopupTable() {
		clientName = new TableColumn<>("Név");
		clientName.setMinWidth(150);
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

	private void jobsPane() {
		extruderNewJobsPane.setVisible(true);
		extruderActualJobsPane.setVisible(false);
	}

	private void actualJobsPane() {
		extruderNewJobsPane.setVisible(false);
		extruderActualJobsPane.setVisible(true);
	}

	@FXML
	private void extruderNewJobBtn() {
		jobsPane();
	}

	@FXML
	private void extruderNameBtn1() {
		actualJobsPane();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		new CalculationsController(manufactureMenuBar);
		new ExtruderName(extruderNameBtn1, extruderNameBtn2, extruderNameBtn3, extruderNameBtn4, extruderNameBtn5,
				extruderNameBtn6, extruderNameBtn7, extruderNameBtn8, extruderNameBtn9, extruderNameBtn10,
				extruderNameBtn11, extruderNameBtn12, extruderNameBtn13, extruderNameBtn14);
		setTable();
		clientPopupTable();
		clientPopupTableView.setItems(dataClient);
		clientPopupTableView.getColumns().addAll(clientName, clientPostcode, clientCity, clientStreet);
	}

}
