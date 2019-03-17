package com.office.kliens.messagetemplate.pojo;

import javafx.beans.property.SimpleStringProperty;

public class MessageTemplate {
	private final SimpleStringProperty messageId;
	private final SimpleStringProperty message;

	public MessageTemplate() {
		this.messageId = new SimpleStringProperty("");
		this.message = new SimpleStringProperty("");
	}

	public MessageTemplate(String message) {
		this.messageId = new SimpleStringProperty("");
		this.message = new SimpleStringProperty(message);
	}

	public MessageTemplate(Integer messageId, String message) {
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
