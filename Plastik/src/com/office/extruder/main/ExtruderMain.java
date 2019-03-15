package com.office.extruder.main;

import com.office.extruder.controller.ExtruderController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ExtruderMain {

	public void start() {
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/office/extruder/view/Actual.fxml"));
			loader.setController(new ExtruderController());
			Parent root = (Parent) loader.load();
			primaryStage.setWidth(1300);
			primaryStage.setHeight(700);
			primaryStage.setTitle("Aktuális");
			primaryStage.setOnCloseRequest(evt -> {
				evt.consume();
				shutdown(primaryStage);
			});
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/com/setting/icon/foliak.png")));
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void shutdown(Stage mainWindow) {
		Alert alert = new Alert(Alert.AlertType.NONE, "Biztos ki akarsz lépni?", ButtonType.YES, ButtonType.NO);
		alert.getDialogPane().getStylesheets().add("/com/setting/showinfo/ShowInfo.css");
		alert.initStyle(StageStyle.TRANSPARENT);
		if (alert.showAndWait().orElse(ButtonType.NO) == ButtonType.YES) {
			mainWindow.close();
		}
	}
}
