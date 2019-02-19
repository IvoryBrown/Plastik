package com.extruder.newjob.controller;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;

import com.client.database.ClientDataBase;
import com.client.pojo.Client;
import com.commoditycalculation.controller.NumberCheck;
import com.extruder.pojo.Extruder;
import com.project.setting.commodityname.database.CommodityNameDataBase;
import com.project.setting.commodityname.pojo.CommodityName;
import com.project.setting.machine.database.MachineDataBase;
import com.project.setting.machine.pojo.Machine;
import com.setting.identification.ClientIdentficationGenerator;
import com.setting.label.MessageLabel;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class NewJobController {
	private TableView<Client> clientPopupTableView;
	private TableColumn<Client, String> clientName, clientPostcode, clientCity, clientStreet;
	private TextField extruderClientName, extruderIdentificationTxt, extruderActualSizeTxt, extruderWidthTxt,
			extruderLengthTxt, extruderThicknessTxt, extruderGrammMeterTxt, extruderOrderedKgTxt;
	private TextArea extruderComment;
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
	private NewJobDataBase jobDB = new NewJobDataBase();
	private String clientId, clientNameTable;
	private Button saveButton;
	private Label messageLbl;
	private NumberCheck numberCheck = new NumberCheck();

	public NewJobController(TableView<Client> clientPopupTableView, TextField extruderClientName,
			TextField extruderIdentificationTxt, TextField extruderActualSizeTxt, TextField extruderWidthTxt,
			TextField extruderLengthTxt, TextField extruderThicknessTxt, TextField extruderGrammMeterTxt,
			TextField extruderOrderedKgTxt, DatePicker extruderEndDate, ComboBox<String> extruderCommodityCmb,
			ComboBox<String> extruderFlatPlateBagCmb, ComboBox<String> extruderNameCmb, Button saveButton,
			TextArea extruderComment, Label messageLbl) {
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
		this.extruderComment = extruderComment;
		this.messageLbl = messageLbl;
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
		setDayCellFactory();
		clearTextField();

	}

	private void setDayCellFactory() {
		extruderEndDate.setDayCellFactory(picker -> new DateCell() {
			public void updateItem(LocalDate date, boolean empty) {
				super.updateItem(date, empty);
				LocalDate today = LocalDate.now();
				setDisable(empty || date.compareTo(today) < 0);
			}
		});
	}

	private void clearTable() {
		this.clientPopupTableView.getItems().clear();
		this.clientPopupTableView.getColumns().clear();

	}

	private void comboBoxSetItems() {
		extruderNameCmb.getItems().clear();
		extruderCommodityCmb.getItems().clear();
		extruderFlatPlateBagCmb.getItems().clear();
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

	private void clearTextField() {
		extruderClientName.clear();
		extruderIdentificationTxt.clear();
		extruderActualSizeTxt.clear();
		extruderWidthTxt.clear();
		extruderLengthTxt.clear();
		extruderThicknessTxt.clear();
		extruderOrderedKgTxt.clear();
		extruderGrammMeterTxt.clear();
		extruderComment.clear();
		extruderEndDate.setValue(null);
		extruderCommodityCmb.setValue(null);
		extruderFlatPlateBagCmb.setValue(null);
		extruderNameCmb.setValue(null);
	}

	private boolean checkTextField() {
		if (extruderClientName.getText().trim().isEmpty()) {
			extruderClientName.setStyle(" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;");
		} else {
			extruderClientName.setStyle(null);
		}
		if (extruderIdentificationTxt.getText().trim().isEmpty()) {
			extruderIdentificationTxt.setStyle(" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;");
		} else {
			extruderIdentificationTxt.setStyle(null);
		}
		if (extruderActualSizeTxt.getText().trim().isEmpty()) {
			extruderActualSizeTxt.setStyle(" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;");
		} else {
			extruderActualSizeTxt.setStyle(null);
		}
		if (extruderWidthTxt.getText().trim().isEmpty()) {
			extruderWidthTxt.setStyle(" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;");
		} else {
			extruderWidthTxt.setStyle(null);
		}
		if (extruderLengthTxt.getText().trim().isEmpty()) {
			extruderLengthTxt.setStyle(" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;");
		} else {
			extruderLengthTxt.setStyle(null);
		}
		if (extruderThicknessTxt.getText().trim().isEmpty()) {
			extruderThicknessTxt.setStyle(" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;");
		} else {
			extruderThicknessTxt.setStyle(null);
		}
		if (extruderOrderedKgTxt.getText().trim().isEmpty()) {
			extruderOrderedKgTxt.setStyle(" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;");
		} else {
			extruderOrderedKgTxt.setStyle(null);
		}
		if (extruderEndDate.getValue() == null) {
			extruderEndDate.setStyle(" -fx-border-color: #CD5C5C; -fx-focus-color: #CD5C5C;");
		} else {
			extruderEndDate.setStyle(null);
		}
		if (extruderCommodityCmb.getValue() == null) {
			extruderCommodityCmb.setStyle(" -fx-border-color: #CD5C5C; -fx-focus-color: #CD5C5C;");
		} else {
			extruderCommodityCmb.setStyle(null);
		}
		if (extruderFlatPlateBagCmb.getValue() == null) {
			extruderFlatPlateBagCmb.setStyle(" -fx-border-color: #CD5C5C; -fx-focus-color: #CD5C5C;");
		} else {
			extruderFlatPlateBagCmb.setStyle(null);
		}
		if (extruderNameCmb.getValue() == null) {
			extruderNameCmb.setStyle(" -fx-border-color: #CD5C5C; -fx-focus-color: #CD5C5C;");
		} else {
			extruderNameCmb.setStyle(null);
		}

		if (extruderClientName.getText().trim().isEmpty() || extruderIdentificationTxt.getText().trim().isEmpty()
				|| extruderActualSizeTxt.getText().trim().isEmpty() || extruderWidthTxt.getText().trim().isEmpty()
				|| extruderLengthTxt.getText().trim().isEmpty() || extruderThicknessTxt.getText().trim().isEmpty()
				|| extruderOrderedKgTxt.getText().trim().isEmpty() || extruderEndDate.getValue() == null
				|| extruderCommodityCmb.getValue() == null || extruderFlatPlateBagCmb.getValue() == null
				|| extruderNameCmb.getValue() == null) {
			return false;
		} else {
			return true;
		}
	}

	private void saveDataBase() {
		if (checkTextField()) {
			if (isCheckClientName()) {
				System.out.println(clientId);
				jobDB.addNewJob(new Extruder(clientId, extruderIdentificationTxt.getText(), "Folyamatban",
						LocalDate.now().toString(), extruderEndDate.getValue().toString(),
						extruderCommodityCmb.getValue(), extruderActualSizeTxt.getText(), extruderWidthTxt.getText(),
						extruderLengthTxt.getText(), extruderThicknessTxt.getText(), extruderFlatPlateBagCmb.getValue(),
						extruderGrammMeterTxt.getText(), extruderOrderedKgTxt.getText(), extruderOrderedKgTxt.getText(),
						extruderNameCmb.getValue(), extruderComment.getText()));
				clearTextField();
				new MessageLabel().goodMessage("Sikeres mentés", messageLbl);
			} else {
				new MessageLabel().errorMessage("Sikertelen mentés, nincs kiválasztva ügyfél", messageLbl);
			}

		} else {
			new MessageLabel().errorMessage("Sikertelen mentés", messageLbl);
		}

	}

	private void buttonSetOnAction() {
		LocalDate date = LocalDate.now();
		saveButton.setOnAction((event) -> {
			if (extruderIdentificationTxt.getText().trim().isEmpty()) {
				extruderIdentificationTxt.setText(date.getYear() + ClientIdentficationGenerator.random());
			}
			saveDataBase();
		});
	}

	private void setTable() {
		numberCheck.setQuantityNumber(extruderWidthTxt, messageLbl);
		numberCheck.setQuantityNumber(extruderLengthTxt, messageLbl);
		numberCheck.isDouble(extruderGrammMeterTxt, messageLbl);
		numberCheck.isDouble(extruderThicknessTxt, messageLbl);
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

		extruderActualSizeTxt.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				extruderActualSizeTxt.setText(extruderActualSizeTxt.getText().replace(",", "."));
				int s = extruderActualSizeTxt.getText().lastIndexOf("*");
				extruderThicknessTxt.setText(extruderActualSizeTxt.getText().substring(s + 1));
			}
		});

		extruderFlatPlateBagCmb.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (extruderWidthTxt.getText().trim().isEmpty()) {
					extruderWidthTxt.setStyle(" -fx-border-color: #CD5C5C; -fx-focus-color: #CD5C5C;");
				} else {
					extruderWidthTxt.setStyle(null);
				}
				int w = extruderActualSizeTxt.getText().lastIndexOf("*");
				if (extruderThicknessTxt.getText().equals(extruderActualSizeTxt.getText().substring(w + 1))) {
					extruderThicknessTxt.setStyle(null);
				} else {
					new MessageLabel().errorMessage("Üresek a mezők", messageLbl);
					extruderThicknessTxt.setStyle(" -fx-border-color: #CD5C5C; -fx-focus-color: #CD5C5C;");
				}
				if (!extruderWidthTxt.getText().trim().isEmpty() && !extruderThicknessTxt.getText().trim().isEmpty()) {
					NumberFormat formatter = new DecimalFormat("##.##");
					Integer sWidth = Integer.parseInt(extruderWidthTxt.getText());
					Integer sLenght = Integer.parseInt(extruderLengthTxt.getText());
					double sThickness = Double.valueOf(extruderThicknessTxt.getText());
					Integer sFlatPlateBag = Integer.parseInt(newValue);
					double sum = sWidth * sThickness * sFlatPlateBag * 0.92;
					String f = String.valueOf(formatter.format(sum));
					double sGrammMeterTxt = Double.parseDouble(f.replace(",", "."));
					extruderGrammMeterTxt.setText(String.valueOf(sGrammMeterTxt));
					if (!extruderLengthTxt.getText().trim().isEmpty()) {
						double d = sWidth * sLenght * sThickness * sFlatPlateBag * 0.92 / 1000000;
						extruderOrderedKgTxt.setText(String.valueOf(d));
					}
				} else {
					new MessageLabel().errorMessage("Üresek a mezők", messageLbl);
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
