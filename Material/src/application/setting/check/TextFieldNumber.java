package application.setting.check;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class TextFieldNumber {
	
	//Textfield Number

	public static void checkNumberTextField(TextField text) {

		// force the field to be numeric only
		text.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					text.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});
	}
}
