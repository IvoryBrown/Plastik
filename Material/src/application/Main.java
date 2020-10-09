package application;

import application.setting.check.CheckExit;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setWidth(1600);
			primaryStage.setHeight(950);
			primaryStage.setMinWidth(1300);
			primaryStage.setMinHeight(500);
	
			primaryStage.setOnCloseRequest(evt -> {
				evt.consume();
				CheckExit.exitWindow(primaryStage);
			});
			primaryStage.setTitle("Material");
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/application/setting/icon/button/Foliak.png")));
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	



	public static void main(String[] args) {
		launch(args);
	}
}
