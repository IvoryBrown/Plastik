package com.manufacture.main;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class Main {

	public void start() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/com/manufacture/view/Home.fxml"));
			Stage primaryStage = new Stage();
			primaryStage.setWidth(1300);
			primaryStage.setHeight(700);
//			primaryStage.initStyle(StageStyle.TRANSPARENT);
			primaryStage.setMaximized(true);
			primaryStage.setTitle("Stanicli");
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/com/setting/icon/foliak.png")));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
//			blockExitProgram(primaryStage);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void blockExitProgram(Stage primaryStage) {
		// ALT+F4
		Platform.setImplicitExit(false);
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				event.consume();
			}
		});
		//
		primaryStage.setAlwaysOnTop(true);
		primaryStage.iconifiedProperty().addListener(new ChangeListener<Boolean>() {
		    @Override
		    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		        if(newValue)
		        	primaryStage.setIconified(false);
		    }
		});
	}
}
