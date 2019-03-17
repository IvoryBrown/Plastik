package com.office.kliens.message.pojo;

import javafx.beans.property.SimpleStringProperty;

public class Message {
	private final SimpleStringProperty messageId;
	private final SimpleStringProperty message;

	public Message() {
		this.messageId = new SimpleStringProperty("");
		this.message = new SimpleStringProperty("");
	}

	public Message(String message) {
		this.messageId = new SimpleStringProperty("");
		this.message = new SimpleStringProperty(message);
	}

	public Message(Integer messageId, String message) {
		this.messageId = new SimpleStringProperty(String.valueOf(messageId));
		this.message = new SimpleStringProperty(message);
	}

	public SimpleStringProperty getMessageIdProperty() {
		return this.messageId;
	}

	public String getMessageId() {
		return this.messageId.get();
	}

	public void setMessageId(String messageId) {
		this.messageId.set(messageId);
	}

	public SimpleStringProperty getMessageProperty() {
		return this.message;
	}

	public String getMessage() {
		return this.message.get();
	}

	public void setMessage(String message) {
		this.message.set(message);
	}
}
