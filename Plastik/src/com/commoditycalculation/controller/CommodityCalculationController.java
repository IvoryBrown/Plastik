package com.commoditycalculation.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.setting.label.MessageLabel;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CommodityCalculationController implements Initializable {
	@FXML
	AnchorPane percentagePane;
	@FXML
	private Label commodityMessageLabel;
	@FXML
	private Button backCommodity, nextCommodity;
	@FXML
	private TextField quantityTxt;
	@FXML
	private TextField commodityName1Txt, commodityName2Txt, commodityName3Txt, commodityName4Txt, commodityName5Txt,
			commodityName6Txt, commodityName7Txt, commodityName8Txt;
	@FXML
	private TextField commodityPercentage1Txt, commodityPercentage2Txt, commodityPercentage3Txt,
			commodityPercentage4Txt, commodityPercentage5Txt, commodityPercentage6Txt, commodityPercentage7Txt,
			commodityPercentage8Txt;
	private MessageLabel message = new MessageLabel();

	private boolean setQuantity() {
		if (quantityTxt.getText().trim().isEmpty()) {
			quantityTxt.setStyle(" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;");
		} else {
			quantityTxt.setStyle(null);
		}
		if (quantityTxt.getText().trim().isEmpty()) {
			return false;
		} else {
			return true;
		}

	}

	private boolean setCommodity() {
		if (commodityName1Txt.getText().trim().isEmpty()) {
			commodityName1Txt.setStyle(" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;");
		} else {
			commodityName1Txt.setStyle(null);
		}
		if (commodityName1Txt.getText().trim().isEmpty()) {
			return false;
		} else {
			return true;
		}

	}

	private void setQuantityNumber() {
		quantityTxt.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					char ch = quantityTxt.getText().charAt(oldValue.intValue());
					if (!(ch >= '0' && ch <= '9')) {
						quantityTxt.setText(quantityTxt.getText().substring(0, quantityTxt.getText().length() - 1));
						message.errorMessage("Nem megfelelő formátum!", commodityMessageLabel);
					}
				}
			}

		});
	}

	@FXML
	private void nextCommodity() {
		if (setQuantity()) {
			if (setCommodity()) {
				percentagePane.setVisible(true);
				backCommodity.setVisible(true);
				message.goodMessage("!!Üres a mező", commodityMessageLabel);
			} else {
				message.errorMessage("Egy alapanyag kitöltése kötelező!", commodityMessageLabel);
			}

		} else {
			message.errorMessage("Mennyiség kitöltése kötelező!", commodityMessageLabel);
		}
	}

	@FXML
	private void backCommodity() {
		// TODO Automatikusan előállított metóduscsonk

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setQuantityNumber();

	}

}
