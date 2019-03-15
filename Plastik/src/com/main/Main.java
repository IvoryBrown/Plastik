package com.main;
	
import com.setting.file.FolderWriter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		new FolderWriter();
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/com/main/view/Home.fxml"));
			primaryStage.setWidth(1300);
			primaryStage.setHeight(700);
			primaryStage.setMinWidth(1200);
			primaryStage.setMinHeight(600);
			primaryStage.setTitle("Stanicli");
			primaryStage.setOnCloseRequest(evt -> {
				evt.consume();
				shutdown(primaryStage);
			});
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/com/setting/icon/foliak.png")));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
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
	
	public static void main(String[] args) {
		launch(args);
	}
}
