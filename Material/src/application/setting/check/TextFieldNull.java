package application.setting.check;

import javafx.scene.control.TextField;

public class TextFieldNull {

	public static boolean checkTextField(TextField clientCompanyTxt, TextField clientCountyTxt, TextField clientZipCodeTxt,
			TextField clientCityTxt, TextField clientAddressTxt) {
		if (clientCompanyTxt.getText().trim().isEmpty()) {
			clientCompanyTxt.setStyle(
					" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;  -fx-prompt-text-fill: #CD5C5C;");
			clientCompanyTxt.setPromptText("Kötelezően kitöltendő");
		} else {
			clientCompanyTxt.setStyle(null);
			clientCompanyTxt.setPromptText("");
		}

		if (clientCountyTxt.getText().trim().isEmpty()) {
			clientCountyTxt.setStyle(
					" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;  -fx-prompt-text-fill: #CD5C5C;");
			clientCountyTxt.setPromptText("Kötelezően kitöltendő");
		} else {
			clientCountyTxt.setStyle(null);
			clientCountyTxt.setPromptText("");
		}

		if (clientZipCodeTxt.getText().trim().isEmpty()) {
			clientZipCodeTxt.setStyle(
					" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;  -fx-prompt-text-fill: #CD5C5C;");
			clientZipCodeTxt.setPromptText("Kötelezően kitöltendő");
		} else {
			clientZipCodeTxt.setStyle(null);
			clientZipCodeTxt.setPromptText("");
		}

		if (clientCityTxt.getText().trim().isEmpty()) {
			clientCityTxt.setStyle(
					" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;  -fx-prompt-text-fill: #CD5C5C;");
			clientCityTxt.setPromptText("Kötelezően kitöltendő");
		} else {
			clientCityTxt.setStyle(null);
			clientCityTxt.setPromptText("");
		}

		if (clientAddressTxt.getText().trim().isEmpty()) {
			clientAddressTxt.setStyle(
					" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;  -fx-prompt-text-fill: #CD5C5C;");
			clientAddressTxt.setPromptText("Kötelezően kitöltendő");
		} else {
			clientAddressTxt.setStyle(null);
			clientAddressTxt.setPromptText("");
		}
		if (clientCompanyTxt.getText().trim().isEmpty() || clientCountyTxt.getText().trim().isEmpty()
				|| clientZipCodeTxt.getText().trim().isEmpty() || clientCityTxt.getText().trim().isEmpty()
				|| clientAddressTxt.getText().trim().isEmpty()) {
			return false;
		} else {
			return true;
		}

	}
}
