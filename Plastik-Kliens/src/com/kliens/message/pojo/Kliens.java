package com.kliens.message.pojo;

import com.kliens.message.database.MessageDataBase;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Kliens {
	public static boolean set = true;

	public static boolean isSet() {

		return set;
	}

	public static void setFalse() {
		boolean get = false;
		Kliens.set = get;
	}

	public static void setTrue() {
		boolean get = true;
		Kliens.set = get;
	}

	public static ObservableList<Message> message() {
		ObservableList<Message> dataMessage = FXCollections.observableArrayList();
		dataMessage.clear();
		dataMessage.addAll(new MessageDataBase().getAllMessage());
		return dataMessage;

	}
}
