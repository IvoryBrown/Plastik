package com.office.commoditycalculation.controller;

import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

import com.setting.label.MessageLabel;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.util.StringConverter;

public class NumberCheck {
	private MessageLabel message = new MessageLabel();

	public void setQuantityNumber(TextField textField, Label label) {
		
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

	public boolean isNum(TextField textField) {
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

	public void isDouble(TextField textField,Label messageLbl) {
		Pattern validEditingState = Pattern.compile("-?(([1-9][0-9]*)|0)?(\\.[0-9]*)?");

		UnaryOperator<TextFormatter.Change> filter = c -> {
			String text = c.getControlNewText();
			if (validEditingState.matcher(text).matches()) {
				messageLbl.setText("");
				textField.setStyle(null);
				return c;
			} else {
				textField.setStyle(" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;");
				new MessageLabel().errorMessage("Nem megfelelő formátum", messageLbl);
				return null;
			}
		};

		StringConverter<Double> converter = new StringConverter<Double>() {

			@Override
			public Double fromString(String s) {
				if (s.isEmpty() || "-".equals(s) || ".".equals(s) || "-.".equals(s)) {
					return 0.0;
				} else {
					return Double.valueOf(s);
				}
			}

			@Override
			public String toString(Double d) {
				return d.toString();
			}
		};

		TextFormatter<Double> textFormatter = new TextFormatter<>(converter, 0.0, filter);
		textField.setTextFormatter(textFormatter);

	}
}
