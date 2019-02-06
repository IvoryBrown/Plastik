package com.extruder.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.extruder.name.ExtruderName;
import com.menu.calculations.CalculationsController;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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
	private TableView<String> extruderTableView;
	@FXML
	private TextField test;

	private void setTable() {
		test.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable,
		            String oldValue, String newValue) {

		        System.out.println(" Text Changed to  " + newValue + ")\n" + oldValue +"\n");
		    }
		});
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		new CalculationsController(manufactureMenuBar);
		new ExtruderName(extruderNameBtn1, extruderNameBtn2, extruderNameBtn3, extruderNameBtn4, extruderNameBtn5,
				extruderNameBtn6, extruderNameBtn7, extruderNameBtn8, extruderNameBtn9, extruderNameBtn10,
				extruderNameBtn11, extruderNameBtn12, extruderNameBtn13, extruderNameBtn14);
		setTable();
	}

}
