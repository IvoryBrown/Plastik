package com.manufacture.extruder.pallet.button.main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PalletButtonCellMain {
	public void start() {

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/com/manufacture/extruder/pallet/button/view/PalletButtonCell.fxml"));
			Stage primaryStage = new Stage();
			primaryStage.initModality(Modality.APPLICATION_MODAL);
			primaryStage.setWidth(1200);
			primaryStage.setHeight(700);
			primaryStage.setTitle("Csomagolás");
			primaryStage.setAlwaysOnTop(true);
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/com/setting/icon/foliak.png")));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setAlwaysOnTop(true);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
