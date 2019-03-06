package com.extruder.pojo;

import com.commoditycalculation.pojo.CommodityCalculation;

import javafx.beans.property.SimpleStringProperty;

public class Extruder {

	private final SimpleStringProperty extruderId;
	private final SimpleStringProperty extruderClientId;
	private final SimpleStringProperty extruderClientName;
	private final SimpleStringProperty extruderIdentification;
	private final SimpleStringProperty extruderStatus;
	private final SimpleStringProperty extruderAddDate;
	private final SimpleStringProperty extruderEndDate;
	private final SimpleStringProperty extruderCommodity;
	private final SimpleStringProperty extruderActualSize;
	private final SimpleStringProperty extruderWidth;
	private final SimpleStringProperty extruderLength;
	private final SimpleStringProperty extruderThickness;
	private final SimpleStringProperty extruderFlatPlateBag;
	private final SimpleStringProperty extruderGrammMeter;
	private final SimpleStringProperty extruderOrderedKg;
	private final SimpleStringProperty extruderName;
	private final SimpleStringProperty extruderComment;
	private final SimpleStringProperty extruderPriority;
	private final SimpleStringProperty extruderComodityId;

	public Extruder() {
		this.extruderId = new SimpleStringProperty(String.valueOf(""));
		this.extruderClientId = new SimpleStringProperty(String.valueOf(""));
		this.extruderClientName = new SimpleStringProperty("");
		this.extruderIdentification = new SimpleStringProperty("");
		this.extruderStatus = new SimpleStringProperty("");
		this.extruderAddDate = new SimpleStringProperty("");
		this.extruderEndDate = new SimpleStringProperty("");
		this.extruderCommodity = new SimpleStringProperty("");
		this.extruderActualSize = new SimpleStringProperty("");
		this.extruderWidth = new SimpleStringProperty("");
		this.extruderLength = new SimpleStringProperty("");
		this.extruderThickness = new SimpleStringProperty("");
		this.extruderFlatPlateBag = new SimpleStringProperty("");
		this.extruderGrammMeter = new SimpleStringProperty("");
		this.extruderOrderedKg = new SimpleStringProperty("");
		this.extruderName = new SimpleStringProperty("");
		this.extruderComment = new SimpleStringProperty("");
		this.extruderPriority = new SimpleStringProperty("");
		this.extruderComodityId = new SimpleStringProperty("");
	}

	public Extruder(String extruderClientId, String extruderIdentification, String extruderStatus,
			String extruderAddDate, String extruderEndDate, String extruderCommodity, String extruderActualSize,
			String extruderWidth, String extruderLength, String extruderThickness, String extruderFlatPlateBag,
			String extruderGrammMeter, String extruderOrderedKg, String extruderName, String extruderComment,
			String extruderComodityId) {
		this.extruderId = new SimpleStringProperty(String.valueOf(""));
		this.extruderClientId = new SimpleStringProperty(String.valueOf(extruderClientId));
		this.extruderClientName = new SimpleStringProperty("");
		this.extruderIdentification = new SimpleStringProperty(extruderIdentification);
		this.extruderStatus = new SimpleStringProperty(extruderStatus);
		this.extruderAddDate = new SimpleStringProperty(extruderAddDate);
		this.extruderEndDate = new SimpleStringProperty(extruderEndDate);
		this.extruderCommodity = new SimpleStringProperty(extruderCommodity);
		this.extruderActualSize = new SimpleStringProperty(extruderActualSize);
		this.extruderWidth = new SimpleStringProperty(extruderWidth);
		this.extruderLength = new SimpleStringProperty(extruderLength);
		this.extruderThickness = new SimpleStringProperty(extruderThickness);
		this.extruderFlatPlateBag = new SimpleStringProperty(extruderFlatPlateBag);
		this.extruderGrammMeter = new SimpleStringProperty(extruderGrammMeter);
		this.extruderOrderedKg = new SimpleStringProperty(extruderOrderedKg);
		this.extruderName = new SimpleStringProperty(extruderName);
		this.extruderComment = new SimpleStringProperty(extruderComment);
		this.extruderPriority = new SimpleStringProperty("");
		this.extruderComodityId = new SimpleStringProperty(extruderComodityId);
	}

	public Extruder(Integer extruderId, Integer extruderClientId, String extruderClientName,
			String extruderIdentification, String extruderStatus, String extruderAddDate, String extruderEndDate,
			String extruderCommodity, String extruderActualSize, String extruderWidth, String extruderLength,
			String extruderThickness, String extruderFlatPlateBag, String extruderGrammMeter, String extruderOrderedKg,
			String extruderName, String extruderComment, String extruderPriority, Integer extruderComodityId) {
		this.extruderId = new SimpleStringProperty(String.valueOf(extruderId));
		this.extruderClientId = new SimpleStringProperty(String.valueOf(extruderClientId));
		this.extruderClientName = new SimpleStringProperty(String.valueOf(extruderClientName));
		this.extruderIdentification = new SimpleStringProperty(extruderIdentification);
		this.extruderStatus = new SimpleStringProperty(extruderStatus);
		this.extruderAddDate = new SimpleStringProperty(extruderAddDate);
		this.extruderEndDate = new SimpleStringProperty(extruderEndDate);
		this.extruderCommodity = new SimpleStringProperty(extruderCommodity);
		this.extruderActualSize = new SimpleStringProperty(extruderActualSize);
		this.extruderWidth = new SimpleStringProperty(extruderWidth);
		this.extruderLength = new SimpleStringProperty(extruderLength);
		this.extruderThickness = new SimpleStringProperty(extruderThickness);
		this.extruderFlatPlateBag = new SimpleStringProperty(extruderFlatPlateBag);
		this.extruderGrammMeter = new SimpleStringProperty(extruderGrammMeter);
		this.extruderOrderedKg = new SimpleStringProperty(extruderOrderedKg);
		this.extruderName = new SimpleStringProperty(extruderName);
		this.extruderComment = new SimpleStringProperty(extruderComment);
		this.extruderPriority = new SimpleStringProperty(extruderPriority);
		this.extruderComodityId = new SimpleStringProperty(String.valueOf(extruderComodityId));
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

	public SimpleStringProperty getExtruderClientIdProperty() {
		return this.extruderClientId;
	}

	public String getExtruderClientId() {
		return this.extruderClientId.get();
	}

	public void setExtruderClientId(String extruderClientId) {
		this.extruderClientId.set(extruderClientId);
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

	public SimpleStringProperty getExtruderStatusProperty() {
		return this.extruderStatus;
	}

	public String getExtruderStatus() {
		return this.extruderStatus.get();
	}

	public void setExtruderStatus(String extruderStatus) {
		this.extruderStatus.set(extruderStatus);
	}

	public SimpleStringProperty getExtruderAddDateProperty() {
		return this.extruderAddDate;
	}

	public String getExtruderAddDate() {
		return this.extruderAddDate.get();
	}

	public void setExtruderAddDate(String extruderAddDate) {
		this.extruderAddDate.set(extruderAddDate);
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

	public SimpleStringProperty getExtruderGrammMeterProperty() {
		return this.extruderGrammMeter;
	}

	public String getExtruderGrammMeter() {
		return this.extruderGrammMeter.get();
	}

	public void setExtruderGrammMeter(String extruderGrammMeter) {
		this.extruderGrammMeter.set(extruderGrammMeter);
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

	public SimpleStringProperty getExtruderNameProperty() {
		return this.extruderName;
	}

	public String getExtruderName() {
		return this.extruderName.get();
	}

	public void setExtruderName(String extruderName) {
		this.extruderName.set(extruderName);
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

	public SimpleStringProperty getExtruderPriorityProperty() {
		return this.extruderPriority;
	}

	public String getExtruderPriority() {
		return this.extruderPriority.get();
	}

	public void setExtruderPriority(String extruderPriority) {
		this.extruderPriority.set(extruderPriority);
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
}
