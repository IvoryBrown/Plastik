package com.commoditycalculation.controller;

import javafx.scene.control.TextField;

public class TextFieldIsEmpty {
	
	
	public boolean isEmptyText(TextField textField) {
		if (textField.getText().trim().isEmpty()) {
			textField.setStyle(" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;");
		} else {
			textField.setStyle(null);
		}
		if (textField.getText().trim().isEmpty()) {
			return false;
		} else {
			return true;
		}

	}

}
