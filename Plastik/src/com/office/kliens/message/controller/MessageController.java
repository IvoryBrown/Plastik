package com.office.kliens.message.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

public class MessageController implements Initializable {
	@FXML
	private ListView<String> listView;
	@FXML
	private TextArea messageArea;

	@FXML
	private void selectButton() {
		listView.getSelectionModel().clearSelection();
	}

	public void monthChanged(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		String oldText = oldValue == null ? "null" : oldValue.toString();
		String newText = newValue == null ? "null" : newValue.toString();

		messageArea.appendText("Itemchanged: old = " + oldText + ", new = " + newText + " ");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		listView.getItems().add("Item 1");
		listView.getItems().add("Item 2");
		listView.getItems().add("Item 3");
		listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> ov, final String oldvalue, final String newvalue) {
				monthChanged(ov, oldvalue, newvalue);
			}
		});
		
	}

}
