package com.main.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.client.controller.ClientController;
import com.client.controller.ClientTableController;
import com.client.pojo.Client;
import com.menu.calculations.CalculationsController;
import com.project.setting.main.MainSetting;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class HomeController implements Initializable {
	public static HomeController ctrl;
	private TreeView<String> homeTreeView;
	@FXML
	private AnchorPane homePane, addNewClientPane, clientTablePane, extruderPane, confectionPane, regraPane;
	@FXML
	private StackPane menuPane;
	@FXML
	private Label addNewClientMessageLabel, clientTableMessageLabel;
	@FXML
	private TextField clientNameTxt, clientPostcodeTxt, clientCityTxt, clientStreetTxt, clientPhoneTxt, clientMailTxt,
			clientFilteringTxt;
	@FXML
	private TextArea clientCommentTxt;
	@FXML
	private TableView<Client> clientTableView;
	@FXML
	private Button clientFilteringBtn;
	@FXML
	private MenuButton manufactureMenuBar;

	private final String MENU_HOME = "Kezdőlap";
	private final String MENU_CLIENT_HOME = "Ügyfelek";
	private final String MENU_CLIENT_NEW = "Új ügyfelek";
	private final String MENU_CLIENT_TABLE = "Ügyfelek tábla";
	private final String MENU_MANUFACTURER = "Gyártás";
	private final String MENU_MANUFACTURER_EXTRUDER = "Extruder";
	private final String MENU_MANUFACTURER_EXTRUDER1 = "Extruder1";
	private final String MENU_MANUFACTURER_EXTRUDER2 = "Extruder2";
	private final String MENU_MANUFACTURER_EXTRUDER3 = "Extruder3";
	private final String MENU_MANUFACTURER_EXTRUDER4 = "Extruder4";
	private final String MENU_MANUFACTURER_EXTRUDER5 = "Extruder5";
	private final String MENU_MANUFACTURER_EXTRUDER6 = "Extruder6";
	private final String MENU_MANUFACTURER_EXTRUDER7 = "Extruder7";
	private final String MENU_MANUFACTURER_EXTRUDER8 = "Extruder8";
	private final String MENU_MANUFACTURER_EXTRUDER9 = "Extruder9";
	private final String MENU_MANUFACTURER_EXTRUDER10 = "Extruder10";
	private final String MENU_MANUFACTURER_CONFECTION = "Konfekció gépek";
	private final String MENU_MANUFACTURER_REGRA = "Regrázó gépek";
	private final String MENU_SETTING = "Beállítások";

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ctrl = this;
		setMenuTree();
		// new CalculationsController(manufactureMenuBar);
	}

	@SuppressWarnings("unchecked")
	private void setMenuTree() {
		Node settingNode = new ImageView(
				new Image(getClass().getResourceAsStream("/com/setting/icon/tree/Setting.png")));
		Node clientNode = new ImageView(new Image(getClass().getResourceAsStream("/com/setting/icon/tree/Client.png")));
		Node homeNode = new ImageView(new Image(getClass().getResourceAsStream("/com/setting/icon/tree/Home.png")));
		Node manufactoreNode = new ImageView(
				new Image(getClass().getResourceAsStream("/com/setting/icon/tree/Manufactura.png")));
		TreeItem<String> treeItemRoot1 = new TreeItem<String>("Menü");
		homeTreeView = new TreeView<>(treeItemRoot1);
		homeTreeView.setShowRoot(false);

		TreeItem<String> nodeItemA = new TreeItem<String>(MENU_HOME, homeNode);

		TreeItem<String> nodeItemB = new TreeItem<String>(MENU_CLIENT_HOME, clientNode);
		nodeItemB.setExpanded(false);
		TreeItem<String> nodeItemB1 = new TreeItem<String>(MENU_CLIENT_NEW);
		TreeItem<String> nodeItemB2 = new TreeItem<String>(MENU_CLIENT_TABLE);
		nodeItemB.getChildren().addAll(nodeItemB1, nodeItemB2);

		TreeItem<String> nodeItemC = new TreeItem<String>(MENU_MANUFACTURER, manufactoreNode);
		nodeItemC.setExpanded(false);
		TreeItem<String> nodeItemC1 = new TreeItem<String>(MENU_MANUFACTURER_EXTRUDER);
		nodeItemC1.setExpanded(false);
		TreeItem<String> nodeItemC1A = new TreeItem<String>(MENU_MANUFACTURER_EXTRUDER1);
		TreeItem<String> nodeItemC1B = new TreeItem<String>(MENU_MANUFACTURER_EXTRUDER2);
		TreeItem<String> nodeItemC1C = new TreeItem<String>(MENU_MANUFACTURER_EXTRUDER3);
		TreeItem<String> nodeItemC1D = new TreeItem<String>(MENU_MANUFACTURER_EXTRUDER4);
		TreeItem<String> nodeItemC1E = new TreeItem<String>(MENU_MANUFACTURER_EXTRUDER5);
		TreeItem<String> nodeItemC1F = new TreeItem<String>(MENU_MANUFACTURER_EXTRUDER6);
		TreeItem<String> nodeItemC1G = new TreeItem<String>(MENU_MANUFACTURER_EXTRUDER7);
		TreeItem<String> nodeItemC1H = new TreeItem<String>(MENU_MANUFACTURER_EXTRUDER8);
		TreeItem<String> nodeItemC1I = new TreeItem<String>(MENU_MANUFACTURER_EXTRUDER9);
		TreeItem<String> nodeItemC1J = new TreeItem<String>(MENU_MANUFACTURER_EXTRUDER10);
		nodeItemC1.getChildren().addAll(nodeItemC1A, nodeItemC1B, nodeItemC1C, nodeItemC1D, nodeItemC1E, nodeItemC1F,
				nodeItemC1G, nodeItemC1H, nodeItemC1I, nodeItemC1J);

		TreeItem<String> nodeItemC2 = new TreeItem<String>(MENU_MANUFACTURER_CONFECTION);
		TreeItem<String> nodeItemC3 = new TreeItem<String>(MENU_MANUFACTURER_REGRA);
		nodeItemC.getChildren().addAll(nodeItemC1, nodeItemC2, nodeItemC3);

		TreeItem<String> nodeItemD = new TreeItem<String>(MENU_SETTING, settingNode);

		treeItemRoot1.getChildren().addAll(nodeItemA, nodeItemB, nodeItemC, nodeItemD);
		menuPane.getChildren().add(homeTreeView);

		mouseAction();
	}

	private void mouseAction() {
		homeTreeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
			public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
				@SuppressWarnings("unchecked")
				TreeItem<String> selectedItem = (TreeItem<String>) newValue;
				String selectedMenu;
				selectedMenu = selectedItem.getValue();
				if (null != selectedMenu) {
					switch (selectedMenu) {
					case MENU_HOME:
						homePane.setVisible(true);
						addNewClientPane.setVisible(false);
						clientTablePane.setVisible(false);
						extruderPane.setVisible(false);
						confectionPane.setVisible(false);
						regraPane.setVisible(false);
						break;

					case MENU_CLIENT_NEW:
						homePane.setVisible(false);
						addNewClientPane.setVisible(true);
						clientTablePane.setVisible(false);
						extruderPane.setVisible(false);
						confectionPane.setVisible(false);
						regraPane.setVisible(false);
						clientTextClear();
						break;

					case MENU_CLIENT_TABLE:
						homePane.setVisible(false);
						addNewClientPane.setVisible(false);
						clientTablePane.setVisible(true);
						extruderPane.setVisible(false);
						confectionPane.setVisible(false);
						regraPane.setVisible(false);
						clientController();
						break;
					case MENU_MANUFACTURER_EXTRUDER:
						homePane.setVisible(false);
						addNewClientPane.setVisible(false);
						clientTablePane.setVisible(false);
						extruderPane.setVisible(true);
						confectionPane.setVisible(false);
						regraPane.setVisible(false);
						break;
					case MENU_MANUFACTURER_CONFECTION:
						homePane.setVisible(false);
						addNewClientPane.setVisible(false);
						clientTablePane.setVisible(false);
						extruderPane.setVisible(false);
						confectionPane.setVisible(true);
						regraPane.setVisible(false);
						break;
					case MENU_MANUFACTURER_REGRA:
						homePane.setVisible(false);
						addNewClientPane.setVisible(false);
						clientTablePane.setVisible(false);
						extruderPane.setVisible(false);
						confectionPane.setVisible(false);
						regraPane.setVisible(true);
						break;
					case MENU_SETTING:
						MainSetting main = new MainSetting();
						main.start();
						break;
					}
				}
			}
		});

	}

	@FXML
	private void addClient() {
		new ClientController(addNewClientMessageLabel, clientNameTxt, clientPostcodeTxt, clientCityTxt, clientStreetTxt,
				clientPhoneTxt, clientMailTxt, clientCommentTxt);
	}

	private void clientTextClear() {
		clientNameTxt.setStyle(null);
		clientPostcodeTxt.setStyle(null);
		clientCityTxt.setStyle(null);
		clientStreetTxt.setStyle(null);
		addNewClientMessageLabel.setText("");
	}

	private void clientController() {
		new ClientTableController(clientTableView, clientTableMessageLabel, clientFilteringTxt, clientFilteringBtn);
		clientTableMessageLabel.setText("");
		clientFilteringTxt.clear();
	}
}
