package com.help.main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class HelpMain {
	public void start() {

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/com/help/view/Help.fxml"));
			Stage primaryStage = new Stage();
			primaryStage.setWidth(1300);
			primaryStage.setHeight(700);
			primaryStage.setTitle("Súgó");
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/com/setting/icon/foliak.png")));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
