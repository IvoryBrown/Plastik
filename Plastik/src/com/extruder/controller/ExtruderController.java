package com.extruder.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.client.pojo.Client;
import com.extruder.name.ExtruderName;
import com.extruder.newjob.controller.NewJobController;
import com.menu.calculations.CalculationsController;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ExtruderController implements Initializable {
	@FXML
	private MenuButton manufactureMenuBar;
	@FXML
	private Label messageLbl;
	@FXML
	private Button extruderNameBtn1, extruderNameBtn2, extruderNameBtn3, extruderNameBtn4, extruderNameBtn5,
			extruderNameBtn6, extruderNameBtn7, extruderNameBtn8, extruderNameBtn9, extruderNameBtn10,
			extruderNameBtn11, extruderNameBtn12, extruderNameBtn13, extruderNameBtn14;
	@FXML
	private Button extruderNewJobBtn,saveButton;
	@FXML
	private AnchorPane extruderNewJobsPane, extruderActualJobsPane;
	@FXML
	private TableView<String> extruderTableView;
	@FXML
	private TableView<Client> clientPopupTableView;
	@FXML
	private TextField extruderClientName;

	private void jobsPane() {
		extruderNewJobsPane.setVisible(true);
		extruderActualJobsPane.setVisible(false);
	}

	private void actualJobsPane() {
		extruderNewJobsPane.setVisible(false);
		extruderActualJobsPane.setVisible(true);
	}

	@FXML
	private void extruderNewJobBtn() {
		jobsPane();
		new NewJobController(clientPopupTableView, extruderClientName,saveButton);
	}

	@FXML
	private void extruderNameBtn1() {
		actualJobsPane();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		new CalculationsController(manufactureMenuBar);
		new ExtruderName(extruderNameBtn1, extruderNameBtn2, extruderNameBtn3, extruderNameBtn4, extruderNameBtn5,
				extruderNameBtn6, extruderNameBtn7, extruderNameBtn8, extruderNameBtn9, extruderNameBtn10,
				extruderNameBtn11, extruderNameBtn12, extruderNameBtn13, extruderNameBtn14);
	}

}
