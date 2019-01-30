package com.main;
	
import com.setting.file.FolderWriter;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


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
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/com/setting/icon/foliak.png")));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
