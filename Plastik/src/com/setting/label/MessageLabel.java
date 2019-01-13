package com.setting.label;

import javafx.scene.control.Label;

public class MessageLabel {

	public Label errorMessage(String message, Label label) {
		label.setText(message);
		label.setStyle("-fx-text-fill: #CD5C5C; -fx-font-size: 16px;  -fx-font-weight: bold;");
		return label;

	}

	public Label goodMessage(String message, Label label) {
		label.setText(message);
		label.setStyle("-fx-text-fill: #6B8E23; -fx-font-size: 16px;  -fx-font-weight: bold;");
		return label;

	}
}
