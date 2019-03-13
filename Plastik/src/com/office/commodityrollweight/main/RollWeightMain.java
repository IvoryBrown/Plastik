package com.office.commodityrollweight.main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class RollWeightMain {
	public void start() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/com/office/commodityrollweight/view/RollWeight.fxml"));
			Stage primaryStage = new Stage();
			primaryStage.setWidth(1300);
			primaryStage.setHeight(700);
			primaryStage.setTitle("Tekercs számítások");
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/com/setting/icon/foliak.png")));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
