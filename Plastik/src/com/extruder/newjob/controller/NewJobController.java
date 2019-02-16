package com.extruder.newjob.controller;

import com.client.database.ClientDataBase;
import com.client.pojo.Client;
import com.project.setting.commodityname.database.CommodityNameDataBase;
import com.project.setting.commodityname.pojo.CommodityName;
import com.project.setting.machine.database.MachineDataBase;
import com.project.setting.machine.pojo.Machine;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class NewJobController {
	private TableView<Client> clientPopupTableView;
	private TableColumn<Client, String> clientName, clientPostcode, clientCity, clientStreet;
	private TextField extruderClientName, extruderIdentificationTxt, extruderActualSizeTxt, extruderWidthTxt,
			extruderLengthTxt, extruderThicknessTxt, extruderGrammMeterTxt, extruderOrderedKgTxt;

	private DatePicker extruderEndDate;

	private ComboBox<String> extruderCommodityCmb;
	private final ObservableList<CommodityName> extruderCommodityData = FXCollections.observableArrayList();
	private CommodityNameDataBase commodityNameDataBase = new CommodityNameDataBase();

	private ComboBox<String> extruderFlatPlateBagCmb;

	private ComboBox<String> extruderNameCmb;
	private final ObservableList<Machine> extruderNameData = FXCollections.observableArrayList();
	private MachineDataBase machineDataBase = new MachineDataBase();

	private final ObservableList<Client> dataClient = FXCollections.observableArrayList();
	private ClientDataBase clientDB = new ClientDataBase();
	private String clientId, clientNameTable;
	private Button saveButton;

	public NewJobController(TableView<Client> clientPopupTableView, TextField extruderClientName,
			TextField extruderIdentificationTxt, TextField extruderActualSizeTxt, TextField extruderWidthTxt,
			TextField extruderLengthTxt, TextField extruderThicknessTxt, TextField extruderGrammMeterTxt,
			TextField extruderOrderedKgTxt, DatePicker extruderEndDate, ComboBox<String> extruderCommodityCmb,
			ComboBox<String> extruderFlatPlateBagCmb, ComboBox<String> extruderNameCmb, Button saveButton) {
		this.clientPopupTableView = clientPopupTableView;
		this.extruderClientName = extruderClientName;
		this.extruderIdentificationTxt = extruderIdentificationTxt;
		this.extruderActualSizeTxt = extruderActualSizeTxt;
		this.extruderWidthTxt = extruderWidthTxt;
		this.extruderLengthTxt = extruderLengthTxt;
		this.extruderThicknessTxt = extruderThicknessTxt;
		this.extruderGrammMeterTxt = extruderGrammMeterTxt;
		this.extruderOrderedKgTxt = extruderOrderedKgTxt;
		this.extruderEndDate = extruderEndDate;
		this.extruderCommodityCmb = extruderCommodityCmb;
		this.extruderFlatPlateBagCmb = extruderFlatPlateBagCmb;
		this.extruderNameCmb = extruderNameCmb;
		this.saveButton = saveButton;
		setNewJobController();
	}

	@SuppressWarnings("unchecked")
	private void setNewJobController() {
		clearTable();
		clientPopupTableView.setItems(dataClient);
		setTable();
		clientPopupTable();
		clientPopupTableView.getColumns().addAll(clientName, clientPostcode, clientCity, clientStreet);
		buttonSetOnAction();
		comboBoxSetItems();
	}

	private void clearTable() {
		this.clientPopupTableView.getItems().clear();
		this.clientPopupTableView.getColumns().clear();

	}

	private void comboBoxSetItems() {
		extruderNameData.addAll(machineDataBase.getAllMachine());
		for (int i = 0; i < extruderNameData.size(); i++) {
			extruderNameCmb.getItems().addAll(extruderNameData.get(i).getMachineName());
		}

		extruderCommodityData.addAll(commodityNameDataBase.getAllCommodityName());
		for (int i = 0; i < extruderCommodityData.size(); i++) {
			extruderCommodityCmb.getItems().addAll(extruderCommodityData.get(i).getCommodityName());
		}

		extruderFlatPlateBagCmb.getItems().addAll("2", "1");
	}

	private void buttonSetOnAction() {
		saveButton.setOnAction((event) -> {
			System.out.println("ID: " + clientId + " Név: " + extruderClientName.getText() + " : " + isCheckClientName()
					+ " id: " + dataClient.size());
		});
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
				dataClient.clear();
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

	private boolean isCheckClientName() {
		if (extruderClientName.getText().equals(clientNameTable)) {
			return true;
		} else {
			return false;
		}

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
					clientNameTable = newValue.getClientName();
					clientPopupTableView.setVisible(false);
				}
			}
		});
	}

	private ObservableList<Client> popupDataClient(String s) {
		dataClient.addAll(clientDB.searchAllClient(s));
		return dataClient;
	}
}
