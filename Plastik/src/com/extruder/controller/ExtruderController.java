package com.extruder.controller;

import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import com.client.database.ClientDataBase;
import com.client.pojo.Client;
import com.commoditycalculation.controller.NumberCheck;
import com.commoditycalculation.controller.TextFieldIsEmpty;
import com.commoditycalculation.database.CalculationDataBase;
import com.commoditycalculation.pojo.CommodityCalculation;
import com.extruder.newjob.database.NewJobDataBase;
import com.extruder.pojo.Extruder;
import com.extruder.table.controller.TableController;
import com.menu.calculations.CalculationsController;
import com.project.setting.commodityname.database.CommodityNameDataBase;
import com.project.setting.commodityname.pojo.CommodityName;
import com.project.setting.machine.database.MachineDataBase;
import com.project.setting.machine.pojo.Machine;
import com.setting.identification.ClientIdentficationGenerator;
import com.setting.identification.DeviceIdentificationGenereator;
import com.setting.label.MessageLabel;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.util.StringConverter;

public class ExtruderController implements Initializable {
	@FXML
	private MenuButton manufactureMenuBar;
	@FXML
	private Label messageLbl;
	@FXML
	private Button extruderNewJobBtn, saveButton, extruderFilteringBtn;
	@FXML
	private AnchorPane extruderNewJobsPane, extruderActualJobsPane, commodityCalculationPane;
	@FXML
	private TableView<Extruder> extruderTableView;
	@FXML
	private TableView<Client> clientPopupTableView;
	private TableColumn<Client, String> clientName, clientPostcode, clientCity, clientStreet;
	@FXML
	private TextField extruderClientNameTxt, extruderIdentificationTxt, extruderActualSizeTxt, extruderWidthTxt,
			extruderLengthTxt, extruderThicknessTxt, extruderGrammMeterTxt, extruderOrderedKgTxt, extruderOrderedDbTxt,
			extruderFilteringTxt;
	@FXML
	private TextArea extruderComment;
	@FXML
	private DatePicker extruderEndDate;
	@FXML
	private ComboBox<String> extruderCommodityCmb;
	@FXML
	private ComboBox<String> extruderFlatPlateBagCmb;
	@FXML
	private ComboBox<String> extruderNameCmb;
	@FXML
	private HBox hBox;
	@FXML
	private CheckBox statusCbox;
	private final ObservableList<CommodityName> extruderCommodityData = FXCollections.observableArrayList();
	private CommodityNameDataBase commodityNameDataBase = new CommodityNameDataBase();
	private final ObservableList<Machine> extruderNameData = FXCollections.observableArrayList();
	private MachineDataBase machineDataBase = new MachineDataBase();
	private final ObservableList<Client> dataClient = FXCollections.observableArrayList();
	private ClientDataBase clientDB = new ClientDataBase();
	private NewJobDataBase jobDB = new NewJobDataBase();
	private String clientId, clientNameTable;
	// Calculation
	@FXML
	AnchorPane percentagePane, calculationPane, calculationKgPane;
	@FXML
	private TextField quantityTxt;
	@FXML
	private TextField commodityName1Txt, commodityName2Txt, commodityName3Txt, commodityName4Txt, commodityName5Txt,
			commodityName6Txt, commodityName7Txt, commodityName8Txt;
	@FXML
	private TextField commodityPercentage1Txt, commodityPercentage2Txt, commodityPercentage3Txt,
			commodityPercentage4Txt, commodityPercentage5Txt, commodityPercentage6Txt, commodityPercentage7Txt,
			commodityPercentage8Txt;
	@FXML
	private TextField commodityPercentageKg1Txt, commodityPercentageKg2Txt, commodityPercentageKg3Txt,
			commodityPercentageKg4Txt, commodityPercentageKg5Txt, commodityPercentageKg6Txt, commodityPercentageKg7Txt,
			commodityPercentageKg8Txt;
	@FXML
	private ComboBox<CommodityCalculation> calculationNameCmb;
	private CalculationDataBase calculationDataBase = new CalculationDataBase();
	private final ObservableList<CommodityCalculation> dataCommodityCalculation = FXCollections.observableArrayList();
	private Double sum;
	private Double number1, number2, number3, number4, number5, number6, number7, number8;
	private TextFieldIsEmpty textFieldIsEmpty = new TextFieldIsEmpty();
	private MessageLabel message = new MessageLabel();
	private NumberCheck numberCheck = new NumberCheck();
	// packing
	@FXML
	private AnchorPane packingPane;

	private void jobsPane() {
		extruderNewJobsPane.setVisible(true);
		extruderActualJobsPane.setVisible(false);

	}

	@FXML
	private void extruderNewJobBtn() {
		jobsPane();
	}

	@FXML
	private void commodityCalculationBtn() {
		commodityCalculationPane.setVisible(true);
		packingPane.setVisible(false);

	}

	@FXML
	private void packingBtn() {
		commodityCalculationPane.setVisible(false);
		packingPane.setVisible(true);

	}

	private void extruderTable() {
		new TableController(extruderNewJobsPane, extruderActualJobsPane, extruderTableView, messageLbl, hBox,
				extruderFilteringBtn, extruderFilteringTxt, statusCbox);
	}

	// Calculation

	private boolean setText() {
		commodityPercentage2Txt.setStyle(null);
		commodityPercentage3Txt.setStyle(null);
		commodityPercentage4Txt.setStyle(null);
		commodityPercentage5Txt.setStyle(null);
		commodityPercentage6Txt.setStyle(null);
		commodityPercentage7Txt.setStyle(null);
		commodityPercentage8Txt.setStyle(null);
		if (!commodityName2Txt.getText().trim().isEmpty()) {
			if (commodityPercentage2Txt.getText().trim().isEmpty()) {
				commodityPercentage2Txt.setStyle(" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;");
				return false;
			}
		}
		if (!commodityName3Txt.getText().trim().isEmpty()) {
			if (commodityPercentage3Txt.getText().trim().isEmpty()) {
				commodityPercentage3Txt.setStyle(" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;");
				return false;
			}
		}
		if (!commodityName4Txt.getText().trim().isEmpty()) {
			if (commodityPercentage4Txt.getText().trim().isEmpty()) {
				commodityPercentage4Txt.setStyle(" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;");
				return false;
			}
		}
		if (!commodityName5Txt.getText().trim().isEmpty()) {
			if (commodityPercentage5Txt.getText().trim().isEmpty()) {
				commodityPercentage5Txt.setStyle(" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;");
				return false;
			}
		}
		if (!commodityName6Txt.getText().trim().isEmpty()) {
			if (commodityPercentage6Txt.getText().trim().isEmpty()) {
				commodityPercentage6Txt.setStyle(" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;");
				return false;
			}
		}
		if (!commodityName7Txt.getText().trim().isEmpty()) {
			if (commodityPercentage7Txt.getText().trim().isEmpty()) {
				commodityPercentage7Txt.setStyle(" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;");
				return false;
			}
		}
		if (!commodityName8Txt.getText().trim().isEmpty()) {
			if (commodityPercentage8Txt.getText().trim().isEmpty()) {
				commodityPercentage8Txt.setStyle(" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;");
				return false;
			}
		}
		return true;

	}

	private void getcommodityName() {
		quantityTxt.setEditable(true);
		commodityName1Txt.setEditable(false);
		commodityName2Txt.setEditable(false);
		commodityName3Txt.setEditable(false);
		commodityName4Txt.setEditable(false);
		commodityName5Txt.setEditable(false);
		commodityName6Txt.setEditable(false);
		commodityName7Txt.setEditable(false);
		commodityName8Txt.setEditable(false);
		if (commodityName2Txt.getText().trim().isEmpty()) {
			commodityPercentage2Txt.setEditable(false);
		}
		if (commodityName3Txt.getText().trim().isEmpty()) {
			commodityPercentage3Txt.setEditable(false);
		}
		if (commodityName4Txt.getText().trim().isEmpty()) {
			commodityPercentage4Txt.setEditable(false);
		}
		if (commodityName5Txt.getText().trim().isEmpty()) {
			commodityPercentage5Txt.setEditable(false);
		}
		if (commodityName6Txt.getText().trim().isEmpty()) {
			commodityPercentage6Txt.setEditable(false);
		}
		if (commodityName7Txt.getText().trim().isEmpty()) {
			commodityPercentage7Txt.setEditable(false);
		}
		if (commodityName8Txt.getText().trim().isEmpty()) {
			commodityPercentage8Txt.setEditable(false);
		}
	}

	private boolean isSum() {
		boolean ret = false;
		sum = 0.0;

		if (!commodityPercentage1Txt.getText().trim().isEmpty()) {
			number1 = Double.valueOf(commodityPercentage1Txt.getText());
			sum += number1;
		}
		if (!commodityPercentage2Txt.getText().trim().isEmpty()) {
			number2 = Double.valueOf(commodityPercentage2Txt.getText());
			sum += number2;
		}
		if (!commodityPercentage3Txt.getText().trim().isEmpty()) {
			number3 = Double.valueOf(commodityPercentage3Txt.getText());
			sum += number3;
		}
		if (!commodityPercentage4Txt.getText().trim().isEmpty()) {
			number4 = Double.valueOf(commodityPercentage4Txt.getText());
			sum += number4;
		}
		if (!commodityPercentage5Txt.getText().trim().isEmpty()) {
			number5 = Double.valueOf(commodityPercentage5Txt.getText());
			sum += number5;
		}
		if (!commodityPercentage6Txt.getText().trim().isEmpty()) {
			number6 = Double.valueOf(commodityPercentage6Txt.getText());
			sum += number6;
		}
		if (!commodityPercentage7Txt.getText().trim().isEmpty()) {
			number7 = Double.valueOf(commodityPercentage7Txt.getText());
			sum += number7;
		}
		if (!commodityPercentage8Txt.getText().trim().isEmpty()) {
			number8 = Double.valueOf(commodityPercentage8Txt.getText());
			sum += number8;
		}
		if (sum == 100) {
			ret = true;
		}
		return ret;
	}

	private void calculationKg() {
		commodityPercentage1Txt.setEditable(false);
		commodityPercentage2Txt.setEditable(false);
		commodityPercentage3Txt.setEditable(false);
		commodityPercentage4Txt.setEditable(false);
		commodityPercentage5Txt.setEditable(false);
		commodityPercentage6Txt.setEditable(false);
		commodityPercentage7Txt.setEditable(false);
		commodityPercentage8Txt.setEditable(false);
		NumberFormat formatter = new DecimalFormat("#0.00");

		if (!commodityPercentage1Txt.getText().trim().isEmpty()) {
			this.commodityPercentageKg1Txt.setText(String.valueOf(formatter.format(calculationSetText(this.number1))));
		}
		if (!commodityPercentage2Txt.getText().trim().isEmpty()) {
			this.commodityPercentageKg2Txt.setText(String.valueOf(formatter.format(calculationSetText(this.number2))));
		}
		if (!commodityPercentage3Txt.getText().trim().isEmpty()) {
			this.commodityPercentageKg3Txt.setText(String.valueOf(formatter.format(calculationSetText(this.number3))));
		}
		if (!commodityPercentage4Txt.getText().trim().isEmpty()) {
			this.commodityPercentageKg4Txt.setText(String.valueOf(formatter.format(calculationSetText(this.number4))));
		}
		if (!commodityPercentage5Txt.getText().trim().isEmpty()) {
			this.commodityPercentageKg5Txt.setText(String.valueOf(formatter.format(calculationSetText(this.number5))));
		}
		if (!commodityPercentage6Txt.getText().trim().isEmpty()) {
			this.commodityPercentageKg6Txt.setText(String.valueOf(formatter.format(calculationSetText(this.number6))));
		}
		if (!commodityPercentage7Txt.getText().trim().isEmpty()) {
			this.commodityPercentageKg7Txt.setText(String.valueOf(formatter.format(calculationSetText(this.number7))));
		}
		if (!commodityPercentage8Txt.getText().trim().isEmpty()) {
			this.commodityPercentageKg8Txt.setText(String.valueOf(formatter.format(calculationSetText(this.number8))));
		}

	}

	private double calculationSetText(Double n) {
		double eredmeny = 0;
		double egySzazalek = Double.valueOf(quantityTxt.getText()) / 100;
		eredmeny = egySzazalek * n;
		return eredmeny;

	}

	private void nextCommodity() {
		if (textFieldIsEmpty.isEmptyText(quantityTxt)) {
			if (textFieldIsEmpty.isEmptyText(commodityName1Txt)) {
				getcommodityName();
				messageLbl.setText("");
			} else {
				message.errorMessage("Egy alapanyag kitöltése kötelező!", messageLbl);
			}

		} else {
			message.errorMessage("Mennyiség kitöltése kötelező!", messageLbl);
		}
	}

	private void calculationCommodity() {
		if (textFieldIsEmpty.isEmptyText(commodityPercentage1Txt)) {
			if (setText()) {
				if (numberCheck.isNum(commodityPercentage1Txt) && numberCheck.isNum(commodityPercentage2Txt)
						&& numberCheck.isNum(commodityPercentage3Txt) && numberCheck.isNum(commodityPercentage4Txt)
						&& numberCheck.isNum(commodityPercentage5Txt) && numberCheck.isNum(commodityPercentage6Txt)
						&& numberCheck.isNum(commodityPercentage7Txt) && numberCheck.isNum(commodityPercentage8Txt)) {
					if (isSum()) {
						calculationKg();
						message.goodMessage("Sikeres kalkuláció", messageLbl);
					} else {

						message.errorMessage(
								"Számold újra! Az alapanyagok mennyisége 100% legyen! (Ezen számítás: " + sum + "%-os)",
								messageLbl);
					}
				} else {
					message.errorMessage("Csak szám lehet és min.: 0.5 max.: 100", messageLbl);
				}
			} else {
				message.errorMessage("Nincs minden mező kitöltve!", messageLbl);
			}

		} else {
			message.errorMessage("Nincs minden mező kitöltve!", messageLbl);
		}
	}

	private void clearcommodityPercentageKgTxt() {
		commodityPercentageKg1Txt.clear();
		commodityPercentageKg2Txt.clear();
		commodityPercentageKg3Txt.clear();
		commodityPercentageKg4Txt.clear();
		commodityPercentageKg5Txt.clear();
		commodityPercentageKg6Txt.clear();
		commodityPercentageKg7Txt.clear();
		commodityPercentageKg8Txt.clear();
	}

	private void clearcommodityAllTxt() {
		commodityName1Txt.clear();
		commodityName2Txt.clear();
		commodityName3Txt.clear();
		commodityName4Txt.clear();
		commodityName5Txt.clear();
		commodityName6Txt.clear();
		commodityName7Txt.clear();
		commodityName8Txt.clear();
		commodityPercentage1Txt.clear();
		commodityPercentage2Txt.clear();
		commodityPercentage3Txt.clear();
		commodityPercentage4Txt.clear();
		commodityPercentage5Txt.clear();
		commodityPercentage6Txt.clear();
		commodityPercentage7Txt.clear();
		commodityPercentage8Txt.clear();
		commodityPercentageKg1Txt.clear();
		commodityPercentageKg2Txt.clear();
		commodityPercentageKg3Txt.clear();
		commodityPercentageKg4Txt.clear();
		commodityPercentageKg5Txt.clear();
		commodityPercentageKg6Txt.clear();
		commodityPercentageKg7Txt.clear();
		commodityPercentageKg8Txt.clear();
	}

	private void converterCombobox() {
		numberCheck.setQuantityNumber(quantityTxt, messageLbl);
		StringConverter<CommodityCalculation> converter = new StringConverter<CommodityCalculation>() {
			@Override
			public String toString(CommodityCalculation bank) {
				return bank.getCalculationName();
			}

			@Override
			public CommodityCalculation fromString(String id) {
				return dataCommodityCalculation.stream().filter(item -> item.getCommodityIdProperty().get().equals(id))
						.collect(Collectors.toList()).get(0);
			}
		};
		calculationNameCmb.setConverter(converter);
		calculationNameCmb.getSelectionModel().selectedItemProperty().addListener((o, ol, nw) -> {
			commodityName1Txt.setText(calculationNameCmb.getValue().getCommodityName1Property().get());
			commodityName2Txt.setText(calculationNameCmb.getValue().getCommodityName2Property().get());
			commodityName3Txt.setText(calculationNameCmb.getValue().getCommodityName3Property().get());
			commodityName4Txt.setText(calculationNameCmb.getValue().getCommodityName4Property().get());
			commodityName5Txt.setText(calculationNameCmb.getValue().getCommodityName5Property().get());
			commodityName6Txt.setText(calculationNameCmb.getValue().getCommodityName6Property().get());
			commodityName7Txt.setText(calculationNameCmb.getValue().getCommodityName7Property().get());
			commodityName8Txt.setText(calculationNameCmb.getValue().getCommodityName8Property().get());
			commodityPercentage1Txt.setText(calculationNameCmb.getValue().getCommodityPercentage1Property().get());
			commodityPercentage2Txt.setText(calculationNameCmb.getValue().getCommodityPercentage2Property().get());
			commodityPercentage3Txt.setText(calculationNameCmb.getValue().getCommodityPercentage3Property().get());
			commodityPercentage4Txt.setText(calculationNameCmb.getValue().getCommodityPercentage4Property().get());
			commodityPercentage5Txt.setText(calculationNameCmb.getValue().getCommodityPercentage5Property().get());
			commodityPercentage6Txt.setText(calculationNameCmb.getValue().getCommodityPercentage6Property().get());
			commodityPercentage7Txt.setText(calculationNameCmb.getValue().getCommodityPercentage7Property().get());
			commodityPercentage8Txt.setText(calculationNameCmb.getValue().getCommodityPercentage8Property().get());
			clearcommodityPercentageKgTxt();
			nextCommodity();
			calculationCommodity();
		});

		extruderOrderedKgTxt.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				quantityTxt.setText(newValue);
			}
		});
		calculationNameCmb.setVisible(false);
		quantityTxt.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.trim().isEmpty()) {
					calculationNameCmb.setVisible(true);
				} else {
					calculationNameCmb.setVisible(false);
				}
			}
		});
		calculationNameCmb.focusedProperty().addListener((observable, oldValue, newValue) -> {
			calculationNameCmb.getItems().clear();
			dataCommodityCalculation.addAll(calculationDataBase.getAllCommodityCalculation());
			calculationNameCmb.setItems(dataCommodityCalculation);
		});
	}

	// new job

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
		extruderClientNameTxt.clear();
		extruderIdentificationTxt.clear();
		extruderActualSizeTxt.clear();
		extruderWidthTxt.clear();
		extruderLengthTxt.clear();
		extruderThicknessTxt.clear();
		extruderOrderedKgTxt.clear();
		extruderOrderedDbTxt.clear();
		extruderGrammMeterTxt.clear();
		extruderComment.clear();
		extruderEndDate.setValue(null);
		extruderCommodityCmb.setValue(null);
		extruderFlatPlateBagCmb.setValue(null);
		extruderNameCmb.setValue(null);
	}

	private boolean checkTextField() {
		if (extruderClientNameTxt.getText().trim().isEmpty()) {
			extruderClientNameTxt.setStyle(" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;");
		} else {
			extruderClientNameTxt.setStyle(null);
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
		if (extruderThicknessTxt.getText().trim().isEmpty() || extruderThicknessTxt.getText().equals("0.0")) {
			extruderThicknessTxt.setStyle(" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;");
		} else {
			extruderThicknessTxt.setStyle(null);
		}
		if (extruderOrderedKgTxt.getText().trim().isEmpty() || extruderOrderedKgTxt.getText().equals("0.0")) {
			extruderOrderedKgTxt.setStyle(" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;");
		} else {
			extruderOrderedKgTxt.setStyle(null);
		}
		if (extruderGrammMeterTxt.getText().trim().isEmpty() || extruderGrammMeterTxt.getText().equals("0.0")) {
			extruderGrammMeterTxt.setStyle(" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;");
		} else {
			extruderGrammMeterTxt.setStyle(null);
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

		if (extruderClientNameTxt.getText().trim().isEmpty() || extruderIdentificationTxt.getText().trim().isEmpty()
				|| extruderActualSizeTxt.getText().trim().isEmpty() || extruderWidthTxt.getText().trim().isEmpty()
				|| extruderLengthTxt.getText().trim().isEmpty() || extruderThicknessTxt.getText().trim().isEmpty()
				|| extruderOrderedKgTxt.getText().trim().isEmpty() || extruderEndDate.getValue() == null
				|| extruderCommodityCmb.getValue() == null || extruderFlatPlateBagCmb.getValue() == null
				|| extruderNameCmb.getValue() == null || extruderThicknessTxt.getText().equals("0.0")
				|| extruderGrammMeterTxt.getText().equals("0.0") || extruderOrderedKgTxt.getText().equals("0.0")) {
			return false;
		} else {
			return true;
		}
	}

	private void saveDataBase() {
		if (checkTextField()) {
			if (isCheckClientName()) {
				if (!commodityName1Txt.getText().trim().isEmpty()) {
					String s = DeviceIdentificationGenereator.random();
					jobDB.addCommodityCalculation(new CommodityCalculation(Integer.parseInt(s), quantityTxt.getText(),
							commodityName1Txt.getText(), commodityName2Txt.getText(), commodityName3Txt.getText(),
							commodityName4Txt.getText(), commodityName5Txt.getText(), commodityName6Txt.getText(),
							commodityName7Txt.getText(), commodityName8Txt.getText(), commodityPercentage1Txt.getText(),
							commodityPercentage2Txt.getText(), commodityPercentage3Txt.getText(),
							commodityPercentage4Txt.getText(), commodityPercentage5Txt.getText(),
							commodityPercentage6Txt.getText(), commodityPercentage7Txt.getText(),
							commodityPercentage8Txt.getText(), commodityPercentageKg1Txt.getText(),
							commodityPercentageKg2Txt.getText(), commodityPercentageKg3Txt.getText(),
							commodityPercentageKg4Txt.getText(), commodityPercentageKg5Txt.getText(),
							commodityPercentageKg6Txt.getText(), commodityPercentageKg7Txt.getText(),
							commodityPercentageKg8Txt.getText()));
					jobDB.addNewJob(new Extruder(clientId, extruderIdentificationTxt.getText(), "Folyamatban",
							LocalDate.now().toString(), extruderEndDate.getValue().toString(),
							extruderCommodityCmb.getValue(), extruderActualSizeTxt.getText(),
							extruderWidthTxt.getText(), extruderLengthTxt.getText(), extruderThicknessTxt.getText(),
							extruderFlatPlateBagCmb.getValue(), extruderGrammMeterTxt.getText(),
							extruderOrderedKgTxt.getText(), extruderNameCmb.getValue(), extruderComment.getText(), s));
				} else {
					jobDB.addNewJob(new Extruder(clientId, extruderIdentificationTxt.getText(), "Folyamatban",
							LocalDate.now().toString(), extruderEndDate.getValue().toString(),
							extruderCommodityCmb.getValue(), extruderActualSizeTxt.getText(),
							extruderWidthTxt.getText(), extruderLengthTxt.getText(), extruderThicknessTxt.getText(),
							extruderFlatPlateBagCmb.getValue(), extruderGrammMeterTxt.getText(),
							extruderOrderedKgTxt.getText(), extruderNameCmb.getValue(), extruderComment.getText(),
							null));
				}
				clearcommodityAllTxt();
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
		extruderClientNameTxt.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!extruderClientNameTxt.getText().trim().isEmpty()) {
					clientPopupTableView.setVisible(true);
					popupDataClient(newValue);
				} else {
					clientPopupTableView.setVisible(false);
				}
			}
		});

		extruderClientNameTxt.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue,
					Boolean newPropertyValue) {
				dataClient.clear();
				if (!newPropertyValue) {
					if (!extruderClientNameTxt.getText().trim().isEmpty()) {
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
				int one = newValue.indexOf("*");
				Integer j = extruderActualSizeTxt.getText().indexOf("*",
						extruderActualSizeTxt.getText().indexOf("*") + 1);
				extruderThicknessTxt.setText(extruderActualSizeTxt.getText().substring(s + 1));
				int adb = 0;
				for (int i = 0; i < extruderActualSizeTxt.getText().length(); i++) {
					if (extruderActualSizeTxt.getText().charAt(i) == '*') {
						adb++;
					}
				}
				if (adb == 1) {
					extruderLengthTxt.setText("0");
					extruderWidthTxt.setText(extruderActualSizeTxt.getText().substring(0, one));
				}
				if (adb == 2) {
					extruderWidthTxt.setText(extruderActualSizeTxt.getText().substring(0, one));
					extruderLengthTxt.setText(extruderActualSizeTxt.getText().substring(one + 1, s));
				}
				if (adb == 3) {
					extruderLengthTxt.setText("0");
					Integer w = Integer.parseInt(extruderActualSizeTxt.getText().substring(0, one));
					Integer q = Integer.parseInt(extruderActualSizeTxt.getText().substring(j + 1, s));
					Integer e = w + (q * 2);
					extruderWidthTxt.setText(String.valueOf(e));
				}
				if (adb == 4) {
					Integer w = Integer.parseInt(extruderActualSizeTxt.getText().substring(0, one));
					Integer l = extruderActualSizeTxt.getText().lastIndexOf("*",
							extruderActualSizeTxt.getText().lastIndexOf("*") - 1);
					Integer m = Integer.parseInt(extruderActualSizeTxt.getText().substring(j + 1, l));
					extruderWidthTxt.setText(String.valueOf(w + (2 * m)));
					extruderLengthTxt.setText(extruderActualSizeTxt.getText().substring(l + 1, s));
				}
			}
		});

		extruderFlatPlateBagCmb.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				int w = extruderActualSizeTxt.getText().lastIndexOf("*");
				if (extruderThicknessTxt.getText().equals(extruderActualSizeTxt.getText().substring(w + 1))) {
					extruderThicknessTxt.setStyle(null);
				} else {
					new MessageLabel().errorMessage("Üresek a mezők", messageLbl);
				}
				if (!extruderWidthTxt.getText().trim().isEmpty() && !extruderThicknessTxt.getText().trim().isEmpty()) {
					NumberFormat formatter = new DecimalFormat("##.##");
					Integer sWidth = Integer.parseInt(extruderWidthTxt.getText());
					double sThickness = Double.valueOf(extruderThicknessTxt.getText());
					if (extruderFlatPlateBagCmb.getValue() != null) {
						Integer sFlatPlateBag = Integer.parseInt(extruderFlatPlateBagCmb.getValue());
						double sum = sWidth * sThickness * sFlatPlateBag * 0.92;
						String f = String.valueOf(formatter.format(sum));
						double sGrammMeterTxt = Double.parseDouble(f.replace(",", "."));
						extruderGrammMeterTxt.setText(String.valueOf(sGrammMeterTxt));

					}

				} else {
					new MessageLabel().errorMessage("Üresek a mezők", messageLbl);
				}

			}
		});

		extruderOrderedDbTxt.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.trim().isEmpty()) {
					NumberFormat formatter = new DecimalFormat("##.##");
					Integer sWidth = Integer.parseInt(extruderWidthTxt.getText());
					Integer sLength = Integer.parseInt(extruderLengthTxt.getText());
					double sThickness = Double.parseDouble(extruderThicknessTxt.getText());
					Integer sFlatPlateBag = Integer.parseInt(extruderFlatPlateBagCmb.getValue());
					double s = sWidth * sLength * sThickness * sFlatPlateBag * 0.92 / 1000000;
					Integer g = Integer.parseInt(extruderOrderedDbTxt.getText());
					String f = String.valueOf(formatter.format(s * g));
					double sGrammMeterTxt = Double.parseDouble(f.replace(",", "."));
					extruderOrderedKgTxt.setText(String.valueOf(sGrammMeterTxt));
				} else {
					extruderOrderedKgTxt.clear();
				}
			}
		});
	}

	private boolean isCheckClientName() {
		if (extruderClientNameTxt.getText().equals(clientNameTable)) {
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
					extruderClientNameTxt.setText(newValue.getClientName());
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		new CalculationsController(manufactureMenuBar);
		extruderTable();
		converterCombobox();
		setNewJobController();
	}

}
