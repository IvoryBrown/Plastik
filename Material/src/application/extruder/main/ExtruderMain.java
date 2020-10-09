package application.extruder.main;

import application.extruder.controller.ExtruderController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ExtruderMain {

	// new client + controller!!!
	public void Start() {
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/extruder/view/Extruder.fxml"));
			loader.setController(new ExtruderController());// <--- Controller
			Parent root = (Parent) loader.load();
			primaryStage.setWidth(1600);
			primaryStage.setHeight(950);
			primaryStage.setTitle("Extruder");
			primaryStage.initModality(Modality.APPLICATION_MODAL);
			primaryStage.getIcons()
					.add(new Image(getClass().getResourceAsStream("/application/setting/icon/button/Foliak.png")));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
