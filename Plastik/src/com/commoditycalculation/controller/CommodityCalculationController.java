package com.commoditycalculation.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.setting.label.MessageLabel;

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
	private Button backCommodity, nextCommodity, calculationCommodity;
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
	private NumberCheck numberCheck = new NumberCheck();
	private TextFieldIsEmpty textFieldIsEmpty = new TextFieldIsEmpty();
	Integer sum;

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
		quantityTxt.setDisable(true);
		commodityName1Txt.setDisable(true);
		commodityName2Txt.setDisable(true);
		commodityName3Txt.setDisable(true);
		commodityName4Txt.setDisable(true);
		commodityName5Txt.setDisable(true);
		commodityName6Txt.setDisable(true);
		commodityName7Txt.setDisable(true);
		commodityName8Txt.setDisable(true);
		if (commodityName2Txt.getText().trim().isEmpty()) {
			commodityPercentage2Txt.setDisable(true);
		}
		if (commodityName3Txt.getText().trim().isEmpty()) {
			commodityPercentage3Txt.setDisable(true);
		}
		if (commodityName4Txt.getText().trim().isEmpty()) {
			commodityPercentage4Txt.setDisable(true);
		}
		if (commodityName5Txt.getText().trim().isEmpty()) {
			commodityPercentage5Txt.setDisable(true);
		}
		if (commodityName6Txt.getText().trim().isEmpty()) {
			commodityPercentage6Txt.setDisable(true);
		}
		if (commodityName7Txt.getText().trim().isEmpty()) {
			commodityPercentage7Txt.setDisable(true);
		}
		if (commodityName8Txt.getText().trim().isEmpty()) {
			commodityPercentage8Txt.setDisable(true);
		}
	}

	private void setcommodityName() {
		quantityTxt.setDisable(false);
		commodityName1Txt.setDisable(false);
		commodityName2Txt.setDisable(false);
		commodityName3Txt.setDisable(false);
		commodityName4Txt.setDisable(false);
		commodityName5Txt.setDisable(false);
		commodityName6Txt.setDisable(false);
		commodityName7Txt.setDisable(false);
		commodityName8Txt.setDisable(false);
		commodityPercentage2Txt.setDisable(false);
		commodityPercentage3Txt.setDisable(false);
		commodityPercentage4Txt.setDisable(false);
		commodityPercentage5Txt.setDisable(false);
		commodityPercentage6Txt.setDisable(false);
		commodityPercentage7Txt.setDisable(false);
		commodityPercentage8Txt.setDisable(false);
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
		sum = 0;

		if (!commodityPercentage1Txt.getText().trim().isEmpty()) {
			Integer number = Integer.valueOf(commodityPercentage1Txt.getText());
			sum += number;
		}
		if (!commodityPercentage2Txt.getText().trim().isEmpty()) {
			Integer number = Integer.valueOf(commodityPercentage2Txt.getText());
			sum += number;
		}
		if (!commodityPercentage3Txt.getText().trim().isEmpty()) {
			Integer number = Integer.valueOf(commodityPercentage3Txt.getText());
			sum += number;
		}
		if (!commodityPercentage4Txt.getText().trim().isEmpty()) {
			Integer number = Integer.valueOf(commodityPercentage4Txt.getText());
			sum += number;
		}
		if (!commodityPercentage5Txt.getText().trim().isEmpty()) {
			Integer number = Integer.valueOf(commodityPercentage5Txt.getText());
			sum += number;
		}
		if (!commodityPercentage6Txt.getText().trim().isEmpty()) {
			Integer number = Integer.valueOf(commodityPercentage6Txt.getText());
			sum += number;
		}
		if (!commodityPercentage7Txt.getText().trim().isEmpty()) {
			Integer number = Integer.valueOf(commodityPercentage7Txt.getText());
			sum += number;
		}
		if (!commodityPercentage8Txt.getText().trim().isEmpty()) {
			Integer number = Integer.valueOf(commodityPercentage8Txt.getText());
			sum += number;
		}
		System.out.println(sum);
		if (sum == 100) {
			ret = true;
		}
		return ret;
	}

	@FXML
	private void nextCommodity() {
		if (textFieldIsEmpty.isEmptyText(quantityTxt)) {
			if (textFieldIsEmpty.isEmptyText(commodityName1Txt)) {
				getcommodityName();
				percentagePane.setVisible(true);
				backCommodity.setVisible(true);
				nextCommodity.setVisible(false);
				calculationCommodity.setVisible(true);
				commodityMessageLabel.setText("");
			} else {
				message.errorMessage("Egy alapanyag kitöltése kötelező!", commodityMessageLabel);
			}

		} else {
			message.errorMessage("Mennyiség kitöltése kötelező!", commodityMessageLabel);
		}
	}

	@FXML
	private void calculationCommodity() {
		if (textFieldIsEmpty.isEmptyText(commodityPercentage1Txt)) {
			if (setText()) {
				if (numberCheck.isNum(commodityPercentage1Txt) && numberCheck.isNum(commodityPercentage2Txt)
						&& numberCheck.isNum(commodityPercentage3Txt) && numberCheck.isNum(commodityPercentage4Txt)
						&& numberCheck.isNum(commodityPercentage5Txt) && numberCheck.isNum(commodityPercentage6Txt)
						&& numberCheck.isNum(commodityPercentage7Txt) && numberCheck.isNum(commodityPercentage8Txt)) {
					if (isSum()) {

						message.goodMessage("!!Üres a mező", commodityMessageLabel);
					} else {

						message.errorMessage("Számold újra! Az alapanyagok mennyisége 100% legyen! (Ezen számítás: "+sum+"%-os)", commodityMessageLabel);
					}
				} else {
					message.errorMessage("Csak szám lehet és min.: 0.5 max.: 100", commodityMessageLabel);
				}
			} else {
				message.errorMessage("Nincs minden mező kitöltve!", commodityMessageLabel);
			}

		} else {
			message.errorMessage("Nincs minden mező kitöltve!", commodityMessageLabel);
		}

	}

	@FXML
	private void backCommodity() {
		setcommodityName();
		percentagePane.setVisible(false);
		backCommodity.setVisible(false);
		calculationCommodity.setVisible(false);
		nextCommodity.setVisible(true);
		commodityMessageLabel.setText("");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		numberCheck.setQuantityNumber(quantityTxt, commodityMessageLabel);

	}

}
