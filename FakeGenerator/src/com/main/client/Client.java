package com.main.client;

public class Client {
	private String lastName;
	private String firstName;
	private String fullName;
	private Integer clientPostcode;
	private String clientCity;
	private String clientStreet;
	private String clientMobil;
	private String clientemail;

	public Client() {

	}

	public String getLastName() {
		this.lastName = NameGenerator.generateName();
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		this.firstName = NameGenerator.generateName();
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFullName() {
		this.fullName = firstName + " " + lastName;
		return fullName;
	}

	public Integer getClientPostcode() {
		this.clientPostcode = Integer.valueOf(PostCodeGenerator.randomPostCode());
		return clientPostcode;
	}

	public void setClientPostcode(Integer clientPostcode) {
		this.clientPostcode = clientPostcode;
	}

	public String getClientCity() {
		this.clientCity = CityGenerator.generateCity();
		return clientCity;
	}

	public void setClientCity(String clientCity) {
		this.clientCity = clientCity;
	}

	public String getClientStreet() {
		this.clientStreet = StreetGenerator.generateStreet();
		return clientStreet;
	}

	public void setClientStreet(String clientStreet) {
		this.clientStreet = clientStreet;
	}

	public String getClientMobil() {
		this.clientMobil = MobilGenerator.generateMobil();
		return clientMobil;
	}

	public void setClientMobil(String clientMobil) {
		this.clientMobil = clientMobil;
	}

	public String getClientemail() {
		this.clientemail = EmailGenerator.generateEmail();
		return clientemail;
	}

	public void setClientemail(String clientemail) {
		this.clientemail = clientemail;
	}
}
