package com.office.kliens.message.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.office.kliens.message.database.MessageDataBase;
import com.office.kliens.message.pojo.Message;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MessageController implements Initializable {
	@FXML
	private ListView<Message> listView;
	@FXML
	private TextArea messageArea;
	@FXML
	private TextField addTextLimiterTxt;

	private MessageDataBase messageDataBase = new MessageDataBase();
	private final ObservableList<Message> messageList = FXCollections.observableArrayList();

	@FXML
	private void saveButton() {
		if (!addTextLimiterTxt.getText().trim().isEmpty()) {
			messageDataBase.addMessage(new Message(addTextLimiterTxt.getText()));
			addTextLimiterTxt.clear();
			extruderData();
			setListView();
		}
	}

	@FXML
	private void rightButton() {
		int index = listView.getSelectionModel().getSelectedIndex();
		if (index >= 0) {
			Message message = listView.getItems().get(index);
			messageArea.appendText(" " + message.getMessage() + " ");
		}
	}

	@FXML
	private void deleteButton() {
		int index = listView.getSelectionModel().getSelectedIndex();
		if (index >= 0) {
			Message message = listView.getItems().get(index);
			listView.getItems().remove(message);
			messageDataBase.removeMessage(message);
		}
	}
	@FXML
	private void deleteAreaButton() {
		messageArea.clear();
	}

	@FXML
	private void sendMessageButton() {
		
	}

	private void addTextLimiter() {
		addTextLimiterTxt.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(final ObservableValue<? extends String> ov, final String oldValue,
					final String newValue) {
				if (addTextLimiterTxt.getText().length() > 69) {
					String s = addTextLimiterTxt.getText().substring(0, 69);
					addTextLimiterTxt.setText(s);
				}
			}
		});
	}

	private ObservableList<Message> extruderData() {
		messageList.clear();
		messageList.addAll(messageDataBase.getAllMessage());
		return messageList;

	}

	private void setListView() {
		listView.getItems().clear();
		listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		listView.getItems().addAll(extruderData());
		listView.setCellFactory(param -> new ListCell<Message>() {
			@Override
			protected void updateItem(Message item, boolean empty) {
				super.updateItem(item, empty);

				if (empty || item == null || item.getMessage() == null) {
					setText(null);
				} else {
					setText(item.getMessage());
				}
			}
		});
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		addTextLimiter();
		setListView();

	}

}
