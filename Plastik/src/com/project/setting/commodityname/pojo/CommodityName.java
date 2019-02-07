package com.project.setting.commodityname.pojo;

import javafx.beans.property.SimpleStringProperty;

public class CommodityName {

	private final SimpleStringProperty commodityNameId;
	private final SimpleStringProperty commodityName;

	public CommodityName() {
		this.commodityNameId = new SimpleStringProperty(String.valueOf(""));
		this.commodityName = new SimpleStringProperty("");
	}

	public CommodityName(Integer commodityNameId, String commodityName) {
		this.commodityNameId = new SimpleStringProperty(String.valueOf(commodityNameId));
		this.commodityName = new SimpleStringProperty(commodityName);
	}

	public CommodityName(String commodityName) {
		this.commodityNameId = new SimpleStringProperty(String.valueOf(""));
		this.commodityName = new SimpleStringProperty(commodityName);
	}

	public SimpleStringProperty getCommodityNameIdProperty() {
		return this.commodityNameId;
	}

	public String getCommodityNameId() {
		return this.commodityNameId.get();
	}

	public void setCommodityNameId(String commodityNameId) {
		this.commodityNameId.set(commodityNameId);
	}

	public SimpleStringProperty getCommodityNameProperty() {
		return this.commodityName;
	}

	public String getCommodityName() {
		return this.commodityName.get();
	}

	public void setCommodityName(String commodityName) {
		this.commodityName.set(commodityName);
	}

}
