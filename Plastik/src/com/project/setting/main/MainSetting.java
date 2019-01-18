package com.project.setting.main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainSetting {

	public void start() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/com/project/setting/view/Main.fxml"));
			Stage primaryStage = new Stage();
			primaryStage.setWidth(1300);
			primaryStage.setHeight(700);
			primaryStage.setTitle("Stanicli");
			primaryStage.initModality(Modality.APPLICATION_MODAL);
			primaryStage.setOnCloseRequest(evt -> {
				evt.consume();
				shutdown(primaryStage);
			});
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/com/setting/icon/foliak.png")));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
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
