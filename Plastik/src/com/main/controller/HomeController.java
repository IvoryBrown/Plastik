package com.main.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.office.client.controller.ClientController;
import com.office.client.controller.ClientTableController;
import com.office.client.pojo.Client;
import com.office.extruder.main.ExtruderMain;
import com.project.setting.main.MainSetting;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
	@FXML
	private TreeView<String> homeTreeView;
	@FXML
	private AnchorPane homePane, addNewClientPane, clientTablePane, confectionPane, regraPane, extruderStatictic;
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

	private final String MENU_HOME = "Kezdőlap";
	private final String MENU_CLIENT_HOME = "Ügyfelek";
	private final String MENU_CLIENT_NEW = "Új ügyfelek";
	private final String MENU_CLIENT_TABLE = "Ügyfelek tábla";
	private final String MENU_MANUFACTURER = "Gyártás";
	private final String MENU_MANUFACTURER_EXTRUDER = "Extruder";
	private final String MENU_MANUFACTURER_CONFECTION = "Konfekció gépek";
	private final String MENU_MANUFACTURER_REGRA = "Regrázó gépek";
	private final String MENU_STATISTICS_HOME = "Statisztika";
	private final String MENU_STATISTICS_EXTRUDER = "Extruder ";
	private final String MENU_STATISTICS_EXTRUDER_DEVICE = "Gép";
	private final String MENU_STATISTICS_EXTRUDER_WORKERS = "Dolgozó";
	private final String MENU_STATISTICS_CONFECTION = "Konfekció";
	private final String MENU_SETTING = "Beállítások";

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setMenuTree();
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

		TreeItem<String> nodeItemC2 = new TreeItem<String>(MENU_MANUFACTURER_CONFECTION);
		TreeItem<String> nodeItemC3 = new TreeItem<String>(MENU_MANUFACTURER_REGRA);
		nodeItemC.getChildren().addAll(nodeItemC1, nodeItemC2, nodeItemC3);

		TreeItem<String> nodeItemD = new TreeItem<String>(MENU_STATISTICS_HOME);
		nodeItemD.setExpanded(false);
		TreeItem<String> nodeItemD1 = new TreeItem<String>(MENU_STATISTICS_EXTRUDER);
		TreeItem<String> nodeItemD2 = new TreeItem<String>(MENU_STATISTICS_CONFECTION);
		nodeItemD.getChildren().addAll(nodeItemD1, nodeItemD2);

		TreeItem<String> nodeItemD1A = new TreeItem<String>(MENU_STATISTICS_EXTRUDER_DEVICE);
		TreeItem<String> nodeItemD1B = new TreeItem<String>(MENU_STATISTICS_EXTRUDER_WORKERS);
		nodeItemD1.getChildren().addAll(nodeItemD1A, nodeItemD1B);

		TreeItem<String> nodeItemE = new TreeItem<String>(MENU_SETTING, settingNode);

		treeItemRoot1.getChildren().addAll(nodeItemA, nodeItemB, nodeItemC, nodeItemD, nodeItemE);
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
						confectionPane.setVisible(false);
						regraPane.setVisible(false);
						extruderStatictic.setVisible(false);
						break;

					case MENU_CLIENT_NEW:
						homePane.setVisible(false);
						addNewClientPane.setVisible(true);
						clientTablePane.setVisible(false);
						confectionPane.setVisible(false);
						regraPane.setVisible(false);
						extruderStatictic.setVisible(false);
						clientTextClear();
						break;

					case MENU_CLIENT_TABLE:
						homePane.setVisible(false);
						addNewClientPane.setVisible(false);
						clientTablePane.setVisible(true);
						confectionPane.setVisible(false);
						regraPane.setVisible(false);
						extruderStatictic.setVisible(false);
						clientController();
						break;
					case MENU_MANUFACTURER_EXTRUDER:
						homePane.setVisible(false);
						addNewClientPane.setVisible(false);
						clientTablePane.setVisible(false);
						confectionPane.setVisible(false);
						regraPane.setVisible(false);
						extruderStatictic.setVisible(false);
						ExtruderMain actual = new ExtruderMain();
						actual.start();
						break;
					case MENU_MANUFACTURER_CONFECTION:
						homePane.setVisible(false);
						addNewClientPane.setVisible(false);
						clientTablePane.setVisible(false);
						confectionPane.setVisible(true);
						regraPane.setVisible(false);
						extruderStatictic.setVisible(false);
						break;
					case MENU_MANUFACTURER_REGRA:
						homePane.setVisible(false);
						addNewClientPane.setVisible(false);
						clientTablePane.setVisible(false);
						confectionPane.setVisible(false);
						regraPane.setVisible(true);
						extruderStatictic.setVisible(false);
						break;
					case MENU_STATISTICS_EXTRUDER_DEVICE:
						homePane.setVisible(false);
						addNewClientPane.setVisible(false);
						clientTablePane.setVisible(false);
						confectionPane.setVisible(false);
						regraPane.setVisible(false);
						extruderStatictic.setVisible(true);
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
