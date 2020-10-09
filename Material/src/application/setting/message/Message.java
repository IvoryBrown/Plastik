package application.setting.message;

import javafx.scene.control.Label;

public class Message {

	public static void noMessage(Label messageLbl, String message) {
		messageLbl.setStyle("-fx-text-fill: #CD5C5C;");
		messageLbl.setText(message);
	}

	public static void yesMessage(Label messageLbl, String message) {
		messageLbl.setStyle("-fx-text-fill: #7FFFD4;");
		messageLbl.setText(message);
	}

}
