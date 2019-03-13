package com.office.client.pojo;

import javafx.beans.property.SimpleStringProperty;

public class Client {
	private final SimpleStringProperty clientId;
	private final SimpleStringProperty clientName;
	private final SimpleStringProperty clientPostcode;
	private final SimpleStringProperty clientCity;
	private final SimpleStringProperty clientStreet;
	private final SimpleStringProperty clientPhone;
	private final SimpleStringProperty clientMail;
	private final SimpleStringProperty clientComment;

	public Client(Integer clientId, String clientName, String clientPostcode, String clientCity, String clientStreet,
			String clientPhone, String clientMail, String clientComment) {
		this.clientId = new SimpleStringProperty(String.valueOf(clientId));
		this.clientName = new SimpleStringProperty(clientName);
		this.clientPostcode = new SimpleStringProperty(clientPostcode);
		this.clientCity = new SimpleStringProperty(clientCity);
		this.clientStreet = new SimpleStringProperty(clientStreet);
		this.clientPhone = new SimpleStringProperty(clientPhone);
		this.clientMail = new SimpleStringProperty(clientMail);
		this.clientComment = new SimpleStringProperty(clientComment);
	}

	public Client(String clientName, String clientPostcode, String clientCity, String clientStreet, String clientPhone,
			String clientMail, String clientComment) {
		this.clientId = new SimpleStringProperty(String.valueOf(""));
		this.clientName = new SimpleStringProperty(clientName);
		this.clientPostcode = new SimpleStringProperty(clientPostcode);
		this.clientCity = new SimpleStringProperty(clientCity);
		this.clientStreet = new SimpleStringProperty(clientStreet);
		this.clientPhone = new SimpleStringProperty(clientPhone);
		this.clientMail = new SimpleStringProperty(clientMail);
		this.clientComment = new SimpleStringProperty(clientComment);
	}

	public Client() {
		this.clientId = new SimpleStringProperty(String.valueOf(""));
		this.clientName = new SimpleStringProperty("");
		this.clientPostcode = new SimpleStringProperty("");
		this.clientCity = new SimpleStringProperty("");
		this.clientStreet = new SimpleStringProperty("");
		this.clientPhone = new SimpleStringProperty("");
		this.clientMail = new SimpleStringProperty("");
		this.clientComment = new SimpleStringProperty("");
	}

	public SimpleStringProperty getClientIdProperty() {
		return this.clientId;
	}

	public String getClientId() {
		return this.clientId.get();
	}

	public void setClientId(String clientId) {
		this.clientId.set(clientId);
	}

	public SimpleStringProperty getClientNameProperty() {
		return this.clientName;
	}

	public String getClientName() {
		return this.clientName.get();
	}

	public void setClientName(String clientName) {
		this.clientName.set(clientName);
	}

	public SimpleStringProperty getClientPostcodeProperty() {
		return this.clientPostcode;
	}

	public String getClientPostcode() {
		return this.clientPostcode.get();
	}

	public void setClientPostcode(String clientPostcodeTxt) {
		this.clientPostcode.set(clientPostcodeTxt);
	}

	public SimpleStringProperty getClientCityProperty() {
		return this.clientCity;
	}

	public String getClientCity() {
		return this.clientCity.get();
	}

	public void setClientCity(String clientCity) {
		this.clientCity.set(clientCity);
	}

	public SimpleStringProperty getClientStreetProperty() {
		return this.clientStreet;
	}

	public String getClientStreet() {
		return this.clientStreet.get();
	}

	public void setClientStreet(String clientStreet) {
		this.clientStreet.set(clientStreet);
	}

	public SimpleStringProperty getClientPhoneProperty() {
		return this.clientPhone;
	}

	public String getClientPhone() {
		return this.clientPhone.get();
	}

	public void setClientPhone(String clientPhone) {
		this.clientPhone.set(clientPhone);
	}

	public SimpleStringProperty getClientMailProperty() {
		return this.clientMail;
	}

	public String getClientMail() {
		return this.clientMail.get();
	}

	public void setClientMail(String clientMail) {
		this.clientMail.set(clientMail);
	}

	public SimpleStringProperty getClientCommentProperty() {
		return this.clientComment;
	}

	public String getClientComment() {
		return this.clientComment.get();
	}

	public void setClientComment(String cClientComment) {
		this.clientComment.set(cClientComment);
	}
}
