package application.client.main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ClientMain {
	 

	public void Start() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/client/view/Client.fxml"));
			Stage primaryStage = new Stage();
			primaryStage.setWidth(1300);
			primaryStage.setHeight(700);
			primaryStage.setTitle("Ügyfelek");
			primaryStage.initModality(Modality.APPLICATION_MODAL);
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/application/setting/icon/button/Foliak.png")));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
