package com.commodityrollweight.controller;

import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import com.commoditycalculation.controller.NumberCheck;

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
	private ComboBox<Integer> rollNumberOfLayersTxt;
	private NumberCheck checkNumber = new NumberCheck();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rollNumberOfLayersTxt.getItems().addAll(setCombobox());
		checkNumber.setQuantityNumber(rollSpoolDiameterTxt, message);
		checkNumber.setQuantityNumber(rollWidth, message);
		checkNumber.setQuantityNumber(rollThicknessTxt, message);
		checkNumber.setQuantityNumber(rollLengthTxt, message);
		checkNumber.isDouble(rollSpoolsWeightTxt, message);

	}

	private Integer[] setCombobox() {
		final Integer CMBDEVICENAME[] = { 1, 2, };
		return CMBDEVICENAME;
	}

	@FXML
	private void upload() {
		double cseveatmero = Double.valueOf(rollSpoolDiameterTxt.getText());
		double reteg = Double.valueOf(rollNumberOfLayersTxt.getValue());
		double szelesseg = Integer.parseInt(rollWidth.getText());
		Integer vastagsag = Integer.parseInt(rollThicknessTxt.getText());
		double hossz = Integer.parseInt(rollLengthTxt.getText());
		double csevesuly = Double.valueOf(rollSpoolsWeightTxt.getText());
		System.out.println(reteg +"réteg");
		System.out.println(szelesseg +"szelesseg");
		System.out.println(vastagsag +"vastagsag");
		System.out.println(hossz +"hossz");
		double foljasuly =(hossz*(szelesseg/1000)*reteg*vastagsag*(10^(-6))*920);
		NumberFormat formatter = new DecimalFormat("#0.00");
		System.out.println(foljasuly);
	}
}
