package application.client.main;

import application.client.controller.NewClientController;
import application.client.controller.UpdateClientController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NewUpdateClient {

	// new client + controller!!!
	public void StartNewClient() {
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/client/view/NewUpdateClient.fxml"));
			loader.setController(new NewClientController());// <--- Controller
			Parent root = (Parent) loader.load();
			primaryStage.setWidth(1300);
			primaryStage.setHeight(700);
			primaryStage.setTitle("Új Ügyfelek");
			primaryStage.initModality(Modality.APPLICATION_MODAL);
			primaryStage.setResizable(false);
			primaryStage.getIcons()
					.add(new Image(getClass().getResourceAsStream("/application/setting/icon/button/Foliak.png")));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// update client + controller!!!
	public void StartUpdateClient() {
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/client/view/NewUpdateClient.fxml"));
			loader.setController(new UpdateClientController());// <--- Controller
			Parent root = (Parent) loader.load();
			primaryStage.setWidth(1300);
			primaryStage.setHeight(700);
			primaryStage.setTitle("Ügyfelek módosítás");
			primaryStage.initModality(Modality.APPLICATION_MODAL);
			primaryStage.setResizable(false);
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
