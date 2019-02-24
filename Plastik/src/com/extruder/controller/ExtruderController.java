package com.extruder.controller;

import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import com.client.pojo.Client;
import com.commoditycalculation.controller.NumberCheck;
import com.commoditycalculation.controller.TextFieldIsEmpty;
import com.commoditycalculation.pojo.CommodityCalculation;
import com.extruder.newjob.controller.NewJobController;
import com.extruder.pojo.Extruder;
import com.extruder.table.controller.TableController;
import com.menu.calculations.CalculationsController;
import com.setting.label.MessageLabel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

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
	//Calculation
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
	private Double sum;
	private Double number1, number2, number3, number4, number5, number6, number7, number8;
	private TextFieldIsEmpty textFieldIsEmpty = new TextFieldIsEmpty();
	private MessageLabel message = new MessageLabel();
	private NumberCheck numberCheck = new NumberCheck();

	private void jobsPane() {
		extruderNewJobsPane.setVisible(true);
		extruderActualJobsPane.setVisible(false);
	}

	@FXML
	private void extruderNewJobBtn() {
		jobsPane();
		new NewJobController(clientPopupTableView, extruderClientNameTxt, extruderIdentificationTxt,
				extruderActualSizeTxt, extruderWidthTxt, extruderLengthTxt, extruderThicknessTxt, extruderGrammMeterTxt,
				extruderOrderedKgTxt, extruderOrderedDbTxt, extruderEndDate, extruderCommodityCmb,
				extruderFlatPlateBagCmb, extruderNameCmb, saveButton, extruderComment, messageLbl);
	}

	private void extruderTable() {
		new TableController(extruderNewJobsPane, extruderActualJobsPane, extruderTableView, messageLbl, hBox,
				extruderFilteringBtn, extruderFilteringTxt, statusCbox);
	}
	
	//Calculation
	
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
		quantityTxt.setEditable(false);
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
	
	private void setcommodityName() {
		quantityTxt.setEditable(true);
		commodityName1Txt.setEditable(true);
		commodityName2Txt.setEditable(true);
		commodityName3Txt.setEditable(true);
		commodityName4Txt.setEditable(true);
		commodityName5Txt.setEditable(true);
		commodityName6Txt.setEditable(true);
		commodityName7Txt.setEditable(true);
		commodityName8Txt.setEditable(true);
		commodityPercentage1Txt.setEditable(true);
		commodityPercentage2Txt.setEditable(true);
		commodityPercentage3Txt.setEditable(true);
		commodityPercentage4Txt.setEditable(true);
		commodityPercentage5Txt.setEditable(true);
		commodityPercentage6Txt.setEditable(true);
		commodityPercentage7Txt.setEditable(true);
		commodityPercentage8Txt.setEditable(true);
		commodityPercentage1Txt.clear();
		commodityPercentage2Txt.clear();
		commodityPercentage3Txt.clear();
		commodityPercentage4Txt.clear();
		commodityPercentage5Txt.clear();
		commodityPercentage6Txt.clear();
		commodityPercentage7Txt.clear();
		commodityPercentage8Txt.clear();
		commodityPercentage1Txt.setStyle(null);
		commodityPercentage2Txt.setStyle(null);
		commodityPercentage3Txt.setStyle(null);
		commodityPercentage4Txt.setStyle(null);
		commodityPercentage5Txt.setStyle(null);
		commodityPercentage6Txt.setStyle(null);
		commodityPercentage7Txt.setStyle(null);
		commodityPercentage8Txt.setStyle(null);
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

@FXML
	private void commodityCalculationBtn() {
		commodityCalculationPane.setVisible(true);

	}

	
	private void deleteBtn() {
		quantityTxt.clear();
		commodityName1Txt.clear();
		commodityName2Txt.clear();
		commodityName3Txt.clear();
		commodityName4Txt.clear();
		commodityName5Txt.clear();
		commodityName6Txt.clear();
		commodityName7Txt.clear();
		commodityName8Txt.clear();
		setcommodityName();
		percentagePane.setVisible(false);
		messageLbl.setText("");
		calculationKgPane.setVisible(false);
	}

	
	private void saveBtn() {

	}

	
	private void backCommodity() {
		setcommodityName();
		percentagePane.setVisible(false);
		messageLbl.setText("");
		calculationKgPane.setVisible(false);
	}

	
	private void nextCommodity() {
		if (textFieldIsEmpty.isEmptyText(quantityTxt)) {
			if (textFieldIsEmpty.isEmptyText(commodityName1Txt)) {
				getcommodityName();
				percentagePane.setVisible(true);
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
						calculationKgPane.setVisible(true);
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
	
	private void clearCalculation() {
		quantityTxt.setEditable(true);
		commodityName1Txt.setEditable(true);
		commodityName2Txt.setEditable(true);
		commodityName3Txt.setEditable(true);
		commodityName4Txt.setEditable(true);
		commodityName5Txt.setEditable(true);
		commodityName6Txt.setEditable(true);
		commodityName7Txt.setEditable(true);
		commodityName8Txt.setEditable(true);
		commodityPercentage1Txt.setEditable(true);
		commodityPercentage2Txt.setEditable(true);
		commodityPercentage3Txt.setEditable(true);
		commodityPercentage4Txt.setEditable(true);
		commodityPercentage5Txt.setEditable(true);
		commodityPercentage6Txt.setEditable(true);
		commodityPercentage7Txt.setEditable(true);
		commodityPercentage8Txt.setEditable(true);
		commodityPercentage1Txt.clear();
		commodityPercentage2Txt.clear();
		commodityPercentage3Txt.clear();
		commodityPercentage4Txt.clear();
		commodityPercentage5Txt.clear();
		commodityPercentage6Txt.clear();
		commodityPercentage7Txt.clear();
		commodityPercentage8Txt.clear();
		commodityPercentage1Txt.setStyle(null);
		commodityPercentage2Txt.setStyle(null);
		commodityPercentage3Txt.setStyle(null);
		commodityPercentage4Txt.setStyle(null);
		commodityPercentage5Txt.setStyle(null);
		commodityPercentage6Txt.setStyle(null);
		commodityPercentage7Txt.setStyle(null);
		commodityPercentage8Txt.setStyle(null);
		quantityTxt.clear();
		commodityName1Txt.clear();
		commodityName2Txt.clear();
		commodityName3Txt.clear();
		commodityName4Txt.clear();
		commodityName5Txt.clear();
		commodityName6Txt.clear();
		commodityName7Txt.clear();
		commodityName8Txt.clear();
		setcommodityName();
		percentagePane.setVisible(false);
		calculationKgPane.setVisible(false);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		new CalculationsController(manufactureMenuBar);
		extruderTable();
		numberCheck.setQuantityNumber(quantityTxt, messageLbl);
	}

}
