package com.office.commodityrollweight.controller;

import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import com.office.commoditycalculation.controller.NumberCheck;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RollWeightController implements Initializable {
	@FXML
	private TextField rollSpoolDiameterTxt, rollWidth, rollThicknessTxt, rollLengthTxt, rollSpoolsWeightTxt;
	@FXML
	private Label rollCalculationWeightLbl, rollCalculationSpoolsWeightLbl, rollDiameterLbl, message;
	@FXML
	private Label rollSpoolDiameterLbl, rollDiameterMesLbl;
	@FXML
	private ComboBox<Integer> rollNumberOfLayersTxt;
	private NumberCheck checkNumber = new NumberCheck();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rollNumberOfLayersTxt.getItems().addAll(setCombobox());
		rollNumberOfLayersTxt.getSelectionModel().selectFirst();
		checkNumber.setQuantityNumber(rollSpoolDiameterTxt, message);
		checkNumber.setQuantityNumber(rollWidth, message);
		checkNumber.setQuantityNumber(rollThicknessTxt, message);
		checkNumber.setQuantityNumber(rollLengthTxt, message);
		setOnTextField();
	}

	private Integer[] setCombobox() {
		final Integer CMBDEVICENAME[] = { 1, 2, };
		return CMBDEVICENAME;
	}

	private void setOnTextField() {
		rollSpoolDiameterTxt.textProperty().addListener((observable, oldValue, newValue) -> {
			rollSpoolDiameterLbl.setText(newValue);
			if (newValue.length() >= 3) {
				String s = newValue.substring(0, 3);
				rollSpoolDiameterLbl.setText(s);
				rollSpoolDiameterTxt.setText(s);
			}
		});
	}

	private Integer textFieldNumeric(String text) {
		Integer i = Integer.valueOf(text);
		return i;

	}

	private Double textFieldObule(String text) {
		Double i = Double.valueOf(text);
		return i;

	}

	@FXML
	private void upload() {
		NumberFormat formatter = new DecimalFormat("#0.00");
		NumberFormat formatter1 = new DecimalFormat("#0");
		double z = Math.pow(10, -6);
		double y = Math.pow(textFieldObule(rollSpoolDiameterTxt.getText()) / 1000, 2);
		rollCalculationWeightLbl.setText(String.valueOf(formatter.format(textFieldNumeric(rollLengthTxt.getText())
				* ((textFieldObule(rollWidth.getText()) / 1000) * rollNumberOfLayersTxt.getValue()
						* textFieldNumeric(rollThicknessTxt.getText()) * (z) * 920))));
		rollCalculationSpoolsWeightLbl.setText(String.valueOf(formatter.format(textFieldNumeric(rollLengthTxt.getText())
				* ((textFieldObule(rollWidth.getText()) / 1000) * rollNumberOfLayersTxt.getValue()
						* textFieldNumeric(rollThicknessTxt.getText()) * (z) * 920)
				+ textFieldObule(rollSpoolsWeightTxt.getText()))));
		rollDiameterLbl
				.setText(
						String.valueOf(formatter1.format(Math
								.sqrt((((textFieldNumeric(rollLengthTxt.getText()) * rollNumberOfLayersTxt.getValue())
										* (textFieldNumeric(rollThicknessTxt.getText()) * z) / 3.14) * 4 + (y)))
								* 1000)));

	}
}
