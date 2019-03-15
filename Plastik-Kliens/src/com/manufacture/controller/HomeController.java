package com.manufacture.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.manufacture.extruder.controller.TableController;
import com.manufacture.extruder.pojo.Extruder;
import com.setting.label.MessageLabel;
import com.setting.pc.DeviceStatus;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class HomeController implements Initializable {
	private TreeView<String> homeTreeView;
	@FXML
	private StackPane menuPane;
	@FXML
	private AnchorPane extruderPane;
	@FXML
	private Label messageLbl;
	@FXML
	private Button exitProgram, restartProgram;
	@FXML
	private TableView<Extruder> extruderTableView;
	@FXML
	private HBox hBox;

	MessageLabel label = new MessageLabel();

	private final String MENU_MANUFACTURER_EXTRUDER = "Extruder";
	private final String MENU_EXIT = "Kilépés";

	@FXML
	private void exitProgram() {
		label.goodMessage("Biztos le szeretné állítani a számitogépet? I / N", messageLbl);
		exitProgram.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.I)) {
					DeviceStatus.shutdownPc();
				} else {
					messageLbl.setText("");
				}
			}
		});
	}

	@FXML
	private void restartProgram() {
		label.goodMessage("Biztos újra szeretné indítani a számitogépet? I / N", messageLbl);
		restartProgram.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.I)) {
					DeviceStatus.restartPc();
				} else {
					messageLbl.setText("");
				}
			}
		});

	}

	@SuppressWarnings("unchecked")
	private void setMenuTree() {
		TreeItem<String> treeItemRoot1 = new TreeItem<String>("Menü");
		homeTreeView = new TreeView<>(treeItemRoot1);
		homeTreeView.setShowRoot(false);

		TreeItem<String> nodeItemA = new TreeItem<String>(MENU_MANUFACTURER_EXTRUDER);
		TreeItem<String> nodeItemC = new TreeItem<String>(MENU_EXIT);
		treeItemRoot1.getChildren().addAll(nodeItemA, nodeItemC);
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

					case MENU_MANUFACTURER_EXTRUDER:
						extruderPane.setVisible(true);
						new TableController(extruderTableView, hBox);
						break;

					case MENU_EXIT:
						DeviceStatus.exitProgram();
						break;

					}
				}
			}
		});

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setMenuTree();
	}

}
