package com.office.kliens.message.main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MessageMain {

	public void start() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/com/office/kliens/message/view/Message.fxml"));
			Stage primaryStage = new Stage();
			primaryStage.setWidth(1000);
			primaryStage.setHeight(700);
			primaryStage.setTitle("Stanicli");
			primaryStage.setResizable(false);
			primaryStage.initModality(Modality.APPLICATION_MODAL);
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/com/setting/icon/foliak.png")));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
