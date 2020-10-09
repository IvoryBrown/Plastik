package application.client.pojo;

import javafx.beans.property.SimpleStringProperty;

public class Client {

	private final SimpleStringProperty clientId;
	private final SimpleStringProperty clientCompany;
	private final SimpleStringProperty clientCounty;
	private final SimpleStringProperty clientZipCode;
	private final SimpleStringProperty clientCity;
	private final SimpleStringProperty clientAddress;
	private final SimpleStringProperty clientSCounty;
	private final SimpleStringProperty clientSZipCode;
	private final SimpleStringProperty clientSCity;
	private final SimpleStringProperty clientSAddress;
	private final SimpleStringProperty clientName;
	private final SimpleStringProperty clientPhone;
	private final SimpleStringProperty clientEmail;
	private final SimpleStringProperty clientComment;

	// All client
	public Client(Integer clientId, String clientCompany, String clientCounty, String clientZipCode, String clientCity,
			String clientAddress, String clientSCounty, String clientSZipCode, String clientSCity,
			String clientSAddress, String clientName, String clientPhone, String clientEmail, String clientComment) {
		this.clientId = new SimpleStringProperty(String.valueOf(clientId));
		this.clientCompany = new SimpleStringProperty(clientCompany);
		this.clientCounty = new SimpleStringProperty(clientCounty);
		this.clientZipCode = new SimpleStringProperty(clientZipCode);
		this.clientCity = new SimpleStringProperty(clientCity);
		this.clientAddress = new SimpleStringProperty(clientAddress);
		this.clientSCounty = new SimpleStringProperty(clientSCounty);
		this.clientSZipCode = new SimpleStringProperty(clientSZipCode);
		this.clientSCity = new SimpleStringProperty(clientSCity);
		this.clientSAddress = new SimpleStringProperty(clientSAddress);
		this.clientName = new SimpleStringProperty(clientName);
		this.clientPhone = new SimpleStringProperty(clientPhone);
		this.clientEmail = new SimpleStringProperty(clientEmail);
		this.clientComment = new SimpleStringProperty(clientComment);
	}

	// New Client
	public Client(String clientCompany, String clientCounty, String clientZipCode, String clientCity,
			String clientAddress, String clientSCounty, String clientSZipCode, String clientSCity,
			String clientSAddress, String clientName, String clientPhone, String clientEmail, String clientComment) {
		this.clientId = new SimpleStringProperty("");
		this.clientCompany = new SimpleStringProperty(clientCompany);
		this.clientCounty = new SimpleStringProperty(clientCounty);
		this.clientZipCode = new SimpleStringProperty(clientZipCode);
		this.clientCity = new SimpleStringProperty(clientCity);
		this.clientAddress = new SimpleStringProperty(clientAddress);
		this.clientSCounty = new SimpleStringProperty(clientSCounty);
		this.clientSZipCode = new SimpleStringProperty(clientSZipCode);
		this.clientSCity = new SimpleStringProperty(clientSCity);
		this.clientSAddress = new SimpleStringProperty(clientSAddress);
		this.clientName = new SimpleStringProperty(clientName);
		this.clientPhone = new SimpleStringProperty(clientPhone);
		this.clientEmail = new SimpleStringProperty(clientEmail);
		this.clientComment = new SimpleStringProperty(clientComment);
	}

	public String getClientId() {
		return this.clientId.get();
	}

	public void setClientId(String cClientId) {
		this.clientId.set(cClientId);
	}

	public String getClientCompany() {
		return this.clientCompany.get();
	}

	public void setClientCompany(String cClientCompany) {
		this.clientCompany.set(cClientCompany);
	}

	public String getClientCounty() {
		return this.clientCounty.get();
	}

	public void setClientCounty(String clientCounty) {
		this.clientCounty.set(clientCounty);
	}

	public String getClientZipCode() {
		return this.clientZipCode.get();
	}

	public void setClientZipCode(String clientZipCode) {
		this.clientZipCode.set(clientZipCode);
	}

	public String getClientCity() {
		return this.clientCity.get();
	}

	public void setClientCity(String clientCity) {
		this.clientCity.set(clientCity);
	}

	public String getClientAddress() {
		return this.clientAddress.get();
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress.set(clientAddress);
	}

	public String getClientSCounty() {
		return this.clientSCounty.get();
	}

	public void setClientSCounty(String clientSCounty) {
		this.clientSCounty.set(clientSCounty);
	}

	public String getClientSZipCode() {
		return this.clientSZipCode.get();
	}

	public void setClientSZipCode(String clientSZipCode) {
		this.clientSZipCode.set(clientSZipCode);
	}

	public String getClientSCity() {
		return this.clientSCity.get();
	}

	public void setClientSCity(String clientSCity) {
		this.clientSCity.set(clientSCity);
	}

	public String getClientSAddress() {
		return this.clientSAddress.get();
	}

	public void setClientSAddress(String clientSAddress) {
		this.clientSAddress.set(clientSAddress);
	}

	public String getClientName() {
		return this.clientName.get();
	}

	public void setClientName(String clientName) {
		this.clientName.set(clientName);
	}

	public String getClientPhone() {
		return this.clientPhone.get();
	}

	public void setClientPhone(String clientPhone) {
		this.clientPhone.set(clientPhone);
	}

	public String getClientEmail() {
		return this.clientEmail.get();
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail.set(clientEmail);
	}

	public String getClientComment() {
		return this.clientComment.get();
	}

	public void setClientComment(String clientComment) {
		this.clientComment.set(clientComment);
	}
}
