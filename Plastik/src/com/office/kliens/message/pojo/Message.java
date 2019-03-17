package com.office.kliens.message.pojo;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class Message {
	private final SimpleStringProperty messageId;
	private final SimpleStringProperty message;
	private final SimpleBooleanProperty kliens1;
	private final SimpleBooleanProperty kliens2;
	private final SimpleBooleanProperty kliens3;
	private final SimpleBooleanProperty kliens4;
	private final SimpleBooleanProperty kliens5;
	private final SimpleBooleanProperty kliens6;
	private final SimpleBooleanProperty kliens7;
	private final SimpleBooleanProperty kliens8;
	private final SimpleBooleanProperty kliens9;
	private final SimpleBooleanProperty kliens10;

	public Message() {
		this.messageId = new SimpleStringProperty("");
		this.message = new SimpleStringProperty("");
		this.kliens1 = new SimpleBooleanProperty();
		this.kliens2 = new SimpleBooleanProperty();
		this.kliens3 = new SimpleBooleanProperty();
		this.kliens4 = new SimpleBooleanProperty();
		this.kliens5 = new SimpleBooleanProperty();
		this.kliens6 = new SimpleBooleanProperty();
		this.kliens7 = new SimpleBooleanProperty();
		this.kliens8 = new SimpleBooleanProperty();
		this.kliens9 = new SimpleBooleanProperty();
		this.kliens10 = new SimpleBooleanProperty();
	}

	public Message(Integer messageId, String message, boolean kliens1, boolean kliens2, boolean kliens3,
			boolean kliens4, boolean kliens5, boolean kliens6, boolean kliens7, boolean kliens8, boolean kliens9,
			boolean kliens10) {
		this.messageId = new SimpleStringProperty(String.valueOf(messageId));
		this.message = new SimpleStringProperty(message);
		this.kliens1 = new SimpleBooleanProperty(kliens1);
		this.kliens2 = new SimpleBooleanProperty(kliens2);
		this.kliens3 = new SimpleBooleanProperty(kliens3);
		this.kliens4 = new SimpleBooleanProperty(kliens4);
		this.kliens5 = new SimpleBooleanProperty(kliens5);
		this.kliens6 = new SimpleBooleanProperty(kliens6);
		this.kliens7 = new SimpleBooleanProperty(kliens7);
		this.kliens8 = new SimpleBooleanProperty(kliens8);
		this.kliens9 = new SimpleBooleanProperty(kliens9);
		this.kliens10 = new SimpleBooleanProperty(kliens10);
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

	public SimpleBooleanProperty getKliens1Property() {
		return this.kliens1;
	}

	public Boolean getKliens1() {
		return this.kliens1.get();
	}

	public void setKliens1(Boolean kliens1) {
		this.kliens1.set(kliens1);
	}

	public SimpleBooleanProperty getKliens2Property() {
		return this.kliens2;
	}

	public Boolean getKliens2() {
		return this.kliens2.get();
	}

	public void setKliens2(Boolean kliens2) {
		this.kliens2.set(kliens2);
	}

	public SimpleBooleanProperty getKliens3Property() {
		return this.kliens3;
	}

	public Boolean getKliens3() {
		return this.kliens3.get();
	}

	public void setKliens3(Boolean kliens3) {
		this.kliens3.set(kliens3);
	}

	public SimpleBooleanProperty getKliens4Property() {
		return this.kliens4;
	}

	public Boolean getKliens4() {
		return this.kliens4.get();
	}

	public void setKliens4(Boolean kliens4) {
		this.kliens4.set(kliens4);
	}

	public SimpleBooleanProperty getKliens5Property() {
		return this.kliens5;
	}

	public Boolean getKliens5() {
		return this.kliens5.get();
	}

	public void setKliens5(Boolean kliens5) {
		this.kliens5.set(kliens5);
	}

	public SimpleBooleanProperty getKliens6Property() {
		return this.kliens6;
	}

	public Boolean getKliens6() {
		return this.kliens6.get();
	}

	public void setKliens6(Boolean kliens6) {
		this.kliens6.set(kliens6);
	}

	public SimpleBooleanProperty getKliens7Property() {
		return this.kliens7;
	}

	public Boolean getKliens7() {
		return this.kliens7.get();
	}

	public void setKliens7(Boolean kliens7) {
		this.kliens7.set(kliens7);
	}

	public SimpleBooleanProperty getKliens8Property() {
		return this.kliens8;
	}

	public Boolean getKliens8() {
		return this.kliens8.get();
	}

	public void setKliens8(Boolean kliens8) {
		this.kliens8.set(kliens8);
	}

	public SimpleBooleanProperty getKliens9Property() {
		return this.kliens9;
	}

	public Boolean getKliens9() {
		return this.kliens9.get();
	}

	public void setKliens9(Boolean kliens9) {
		this.kliens9.set(kliens9);
	}

	public SimpleBooleanProperty getKliens10Property() {
		return this.kliens10;
	}

	public Boolean getKliens10() {
		return this.kliens10.get();
	}

	public void setKliens10(Boolean kliens10) {
		this.kliens10.set(kliens10);
	}
}
