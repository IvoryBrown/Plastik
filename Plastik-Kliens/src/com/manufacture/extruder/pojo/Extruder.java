package com.manufacture.extruder.pojo;

import com.production.transmission.extruder.database.TransmissionExtruderDataBase;
import com.production.transmission.extruder.pojo.TransmissionExtruder;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Extruder {

	private final SimpleStringProperty extruderId;
	private final SimpleStringProperty extruderClientName;
	private final SimpleStringProperty extruderIdentification;
	private final SimpleStringProperty extruderEndDate;
	private final SimpleStringProperty extruderCommodity;
	private final SimpleStringProperty extruderActualSize;
	private final SimpleStringProperty extruderWidth;
	private final SimpleStringProperty extruderLength;
	private final SimpleStringProperty extruderThickness;
	private final SimpleStringProperty extruderFlatPlateBag;
	private final SimpleStringProperty extruderOrderedKg;
	private final SimpleStringProperty extruderActualKg;
	private final SimpleStringProperty extruderComment;
	private final SimpleStringProperty extruderComodityId;
	private final SimpleStringProperty extruderPalletId;

	public Extruder(Integer extruderId, String extruderClientName, String extruderIdentification,
			String extruderEndDate, String extruderCommodity, String extruderActualSize, String extruderWidth,
			String extruderLength, String extruderThickness, String extruderFlatPlateBag, String extruderOrderedKg,
			String extruderComment, Integer extruderComodityId, Integer extruderPalletId) {
		this.extruderId = new SimpleStringProperty(String.valueOf(extruderId));
		this.extruderClientName = new SimpleStringProperty(String.valueOf(extruderClientName));
		this.extruderIdentification = new SimpleStringProperty(extruderIdentification);
		this.extruderEndDate = new SimpleStringProperty(extruderEndDate);
		this.extruderCommodity = new SimpleStringProperty(extruderCommodity);
		this.extruderActualSize = new SimpleStringProperty(extruderActualSize);
		this.extruderWidth = new SimpleStringProperty(extruderWidth);
		this.extruderLength = new SimpleStringProperty(extruderLength);
		this.extruderThickness = new SimpleStringProperty(extruderThickness);
		this.extruderFlatPlateBag = new SimpleStringProperty(extruderFlatPlateBag);
		this.extruderOrderedKg = new SimpleStringProperty(extruderOrderedKg);
		this.extruderActualKg = new SimpleStringProperty("");
		this.extruderComment = new SimpleStringProperty(extruderComment);
		this.extruderComodityId = new SimpleStringProperty(String.valueOf(extruderComodityId));
		this.extruderPalletId = new SimpleStringProperty(String.valueOf(extruderPalletId));
	}

	public SimpleStringProperty getExtruderIdProperty() {
		return this.extruderId;
	}

	public String getExtruderId() {
		return this.extruderId.get();
	}

	public void setExtruderId(String extruderId) {
		this.extruderId.set(extruderId);
	}

	public SimpleStringProperty getExtruderClientNameProperty() {
		return this.extruderClientName;
	}

	public String getExtruderClientName() {
		return this.extruderClientName.get();
	}

	public void setExtruderClientName(String extruderClientName) {
		this.extruderClientName.set(extruderClientName);
	}

	public SimpleStringProperty getExtruderIdentificationProperty() {
		return this.extruderIdentification;
	}

	public String getExtruderIdentification() {
		return this.extruderIdentification.get();
	}

	public void setExtruderIdentification(String extruderIdentification) {
		this.extruderIdentification.set(extruderIdentification);
	}

	public SimpleStringProperty getExtruderEndDateProperty() {
		return this.extruderEndDate;
	}

	public String getExtruderEndDate() {
		return this.extruderEndDate.get();
	}

	public void setExtruderEndDate(String extruderEndDate) {
		this.extruderEndDate.set(extruderEndDate);
	}

	public SimpleStringProperty getExtruderCommodityProperty() {
		return this.extruderCommodity;
	}

	public String getExtruderCommodity() {
		return this.extruderCommodity.get();
	}

	public void setExtruderCommodity(String extruderCommodity) {
		this.extruderCommodity.set(extruderCommodity);
	}

	public SimpleStringProperty getExtruderActualSizeProperty() {
		return this.extruderActualSize;
	}

	public String getExtruderActualSize() {
		return this.extruderActualSize.get();
	}

	public void setExtruderActualSize(String extruderActualSize) {
		this.extruderActualSize.set(extruderActualSize);
	}

	public SimpleStringProperty getExtruderWidthProperty() {
		return this.extruderWidth;
	}

	public String getExtruderWidth() {
		return this.extruderWidth.get();
	}

	public void setExtruderWidth(String extruderWidth) {
		this.extruderWidth.set(extruderWidth);
	}

	public SimpleStringProperty getExtruderLengthProperty() {
		return this.extruderLength;
	}

	public String getExtruderLength() {
		return this.extruderLength.get();
	}

	public void setExtruderLength(String extruderLength) {
		this.extruderLength.set(extruderLength);
	}

	public SimpleStringProperty getExtruderThicknessProperty() {
		return this.extruderThickness;
	}

	public String getExtruderThickness() {
		return this.extruderThickness.get();
	}

	public void setExtruderThickness(String extruderThickness) {
		this.extruderThickness.set(extruderThickness);
	}

	public SimpleStringProperty getExtruderFlatPlateBagProperty() {
		return this.extruderFlatPlateBag;
	}

	public String getExtruderFlatPlateBag() {
		return this.extruderFlatPlateBag.get();
	}

	public void setExtruderFlatPlateBag(String extruderFlatPlateBag) {
		this.extruderFlatPlateBag.set(extruderFlatPlateBag);
	}

	public SimpleStringProperty getExtruderOrderedKgProperty() {
		return this.extruderOrderedKg;
	}

	public String getExtruderOrderedKg() {
		return this.extruderOrderedKg.get();
	}

	public void setExtruderOrderedKg(String extruderOrderedKg) {
		this.extruderOrderedKg.set(extruderOrderedKg);
	}

	public SimpleStringProperty getExtruderActualKgProperty() {// todo
		return this.extruderActualKg;
	}

	public String getExtruderActualKg() {
		String f = null;
		double sum = 0;
		ObservableList<TransmissionExtruder> dataExtruder = FXCollections.observableArrayList();
		dataExtruder.addAll(new TransmissionExtruderDataBase().getAllClient(Integer.parseInt(extruderId.get())));
		if (dataExtruder.size() != 0) {
			for (int i = 0; i < dataExtruder.size(); i++) {
				double g = Double.valueOf(dataExtruder.get(i).getTransmissionNKg());
				sum += g;
			}
		}
		f = String.valueOf(sum);
		return f;
	}

	public void setExtruderActualKg(String extruderActualKg) {
		this.extruderActualKg.set(extruderActualKg);
	}

	public SimpleStringProperty getExtruderCommentProperty() {
		return this.extruderComment;
	}

	public String getExtruderComment() {
		return this.extruderComment.get();
	}

	public void setExtruderComment(String extruderComment) {
		this.extruderComment.set(extruderComment);
	}

	public SimpleStringProperty getExtruderComodityIdProperty() {
		return this.extruderComodityId;
	}

	public String getExtruderComodityId() {
		return this.extruderComodityId.get();
	}

	public void setExtruderComodityId(String extruderComodityId) {
		this.extruderComodityId.set(extruderComodityId);
	}

	public SimpleStringProperty getExtruderPalletIdProperty() {
		return this.extruderPalletId;
	}

	public String getExtruderPalletId() {
		return this.extruderPalletId.get();
	}

	public void setExtruderPalletId(String extruderPalletId) {
		this.extruderPalletId.set(extruderPalletId);
	}

}
