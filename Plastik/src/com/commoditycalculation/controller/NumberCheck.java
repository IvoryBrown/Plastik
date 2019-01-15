package com.commoditycalculation.controller;

import com.setting.label.MessageLabel;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NumberCheck {
	private MessageLabel message = new MessageLabel();

	protected void setQuantityNumber(TextField textField, Label label) {
		textField.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					char ch = textField.getText().charAt(oldValue.intValue());
					if (!(ch >= '0' && ch <= '9')) {
						textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
						message.errorMessage("Nem megfelelő formátum!", label);
					}
				}
			}

		});
	}

	protected boolean isNum(TextField textField) {
		boolean ret = true;
		if (!textField.getText().trim().isEmpty()) {
			try {
				ret = false;
				Double number = Double.parseDouble(textField.getText());
				if (number <= 100 && number >= 0.5) {
					ret = true;
				}

			} catch (NumberFormatException e) {
				ret = false;
			}
		}

		return ret;
	}

}
