package com.project.setting.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.project.setting.database.controller.DataBaseController;
import com.project.setting.worker.controller.WorkersController;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class MainController implements Initializable {
	@FXML
	private TreeView<String> settingTreeView;
	@FXML
	private StackPane menuPane;
	@FXML
	private AnchorPane dataBasePane, workersProgramerPane, workersUserPane;
	@FXML
	private TextField urlTxt, userNameTxt, passwordTxt;
	@FXML
	private Button saveBtn;
	@FXML
	private Label messageLbl;
	DataBaseController dataBaseController = new DataBaseController();
	
	@FXML
	private TextField workersName, workersNumber;
	@FXML
	private Button workersNumberGeneral,workersSave;
	WorkersController workersController = new WorkersController();

	private final String MENU_DATABASE = "Adatbázis";
	private final String MENU_WORKERS = "Dolgozok";
	private final String MENU_WORKERS_PROGRAMER = "Hozzáférés";
	private final String MENU_WORKERS_USER = "Dolgozok adatai";

	@SuppressWarnings("unchecked")
	private void setMenuTree() {
		Node dbNode = new ImageView(new Image(getClass().getResourceAsStream("/com/setting/icon/tree/DataBase.png")));
		Node workersNode = new ImageView(
				new Image(getClass().getResourceAsStream("/com/setting/icon/tree/Workers.png")));
		TreeItem<String> treeItemRoot1 = new TreeItem<String>("Menü");
		settingTreeView = new TreeView<>(treeItemRoot1);
		settingTreeView.setShowRoot(false);

		TreeItem<String> nodeItemA = new TreeItem<String>(MENU_DATABASE, dbNode);

		TreeItem<String> nodeItemB = new TreeItem<String>(MENU_WORKERS, workersNode);
		nodeItemB.setExpanded(false);
		TreeItem<String> nodeItemB1 = new TreeItem<String>(MENU_WORKERS_PROGRAMER);
		TreeItem<String> nodeItemB2 = new TreeItem<String>(MENU_WORKERS_USER);
		nodeItemB.getChildren().addAll(nodeItemB1, nodeItemB2);

		treeItemRoot1.getChildren().addAll(nodeItemA, nodeItemB);
		menuPane.getChildren().add(settingTreeView);
		mouseAction();
	}

	private void mouseAction() {
		settingTreeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
			public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
				@SuppressWarnings("unchecked")
				TreeItem<String> selectedItem = (TreeItem<String>) newValue;
				String selectedMenu;
				selectedMenu = selectedItem.getValue();
				if (null != selectedMenu) {
					switch (selectedMenu) {
					case MENU_DATABASE:
						dataBasePane.setVisible(true);
						workersProgramerPane.setVisible(false);
						workersUserPane.setVisible(false);
						dataBaseController.setTexField(urlTxt, userNameTxt, passwordTxt, messageLbl);
						break;
					case MENU_WORKERS_USER:
						dataBasePane.setVisible(false);
						workersProgramerPane.setVisible(false);
						workersUserPane.setVisible(true);
						break;
					}
				}
			}
		});

	}

	@FXML
	private void saveBtn() {
		dataBaseController.setDBtextField();
	}
	@FXML
	private void workersSave() {
		workersController.setTextField(workersName, workersNumber);
	}

	@FXML
	private void workersNumberGeneral() {


	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setMenuTree();
	}

}
