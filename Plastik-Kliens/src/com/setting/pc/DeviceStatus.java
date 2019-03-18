package com.setting.pc;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DeviceStatus {

	public static void restartPc() {
		try {
			Runtime r = Runtime.getRuntime();
			r.exec("shutdown -r -t 0");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void shutdownPc() {
		try {
			Runtime r = Runtime.getRuntime();
			r.exec("shutdown -s -t 0");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void exitProgram() {
		Stage primaryStage = new Stage();
		PasswordField textField = new PasswordField();
		textField.setPrefSize(100, 30);
		HBox hbox = new HBox(textField);
		Scene scene = new Scene(hbox, 100, 30);
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.show();
		textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.ENTER)) {
					if (textField.getText().equals("123admin123")) {
						System.exit(0);
						Platform.exit();
					} else {
						primaryStage.close();
					}
				}
			}
		});
	}
}
