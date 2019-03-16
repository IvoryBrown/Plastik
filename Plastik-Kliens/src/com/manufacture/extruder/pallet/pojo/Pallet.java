package com.manufacture.extruder.pallet.pojo;

import javafx.beans.property.SimpleStringProperty;

public class Pallet {

	private final SimpleStringProperty palletId;
	private final SimpleStringProperty palletSpoolType;
	private final SimpleStringProperty palletSpoolLenght;
	private final SimpleStringProperty palletSpoolSize;
	private final SimpleStringProperty palletCoilDiameter;
	private final SimpleStringProperty palletCoilOfSpools;
	private final SimpleStringProperty palletColiLength;
	private final SimpleStringProperty palletCoilMinDiameter;
	private final SimpleStringProperty palletCoilMinOfSpools;
	private final SimpleStringProperty palletCoilMinLength;
	private final SimpleStringProperty palletSpoolComment;
	private final SimpleStringProperty palletRollsNumber;
	private final SimpleStringProperty palletPalletBCrowd;
	private final SimpleStringProperty palletPalletNCrowd;
	private final SimpleStringProperty palletPalletNNCrowd;
	private final SimpleStringProperty palletPalletType;
	private final SimpleStringProperty palletPalletLocation;
	private final SimpleStringProperty palletPalletComment;
	private final SimpleStringProperty palletPalletWrapping;
	private final SimpleStringProperty palletPalletWrappingComment;

	public Pallet() {
		this.palletId = new SimpleStringProperty("");
		this.palletSpoolType = new SimpleStringProperty("");
		this.palletSpoolLenght = new SimpleStringProperty("");
		this.palletSpoolSize = new SimpleStringProperty("");
		this.palletCoilDiameter = new SimpleStringProperty("");
		this.palletCoilOfSpools = new SimpleStringProperty("");
		this.palletColiLength = new SimpleStringProperty("");
		this.palletCoilMinDiameter = new SimpleStringProperty("");
		this.palletCoilMinOfSpools = new SimpleStringProperty("");
		this.palletCoilMinLength = new SimpleStringProperty("");
		this.palletSpoolComment = new SimpleStringProperty("");
		this.palletRollsNumber = new SimpleStringProperty("");
		this.palletPalletBCrowd = new SimpleStringProperty("");
		this.palletPalletNCrowd = new SimpleStringProperty("");
		this.palletPalletNNCrowd = new SimpleStringProperty("");
		this.palletPalletType = new SimpleStringProperty("");
		this.palletPalletLocation = new SimpleStringProperty("");
		this.palletPalletComment = new SimpleStringProperty("");
		this.palletPalletWrapping = new SimpleStringProperty("");
		this.palletPalletWrappingComment = new SimpleStringProperty("");
	}

	public Pallet(Integer palletId, String palletSpoolType, String palletSpoolLenght, String palletSpoolSize,
			String palletCoilDiameter, String palletCoilOfSpools, String palletColiLength, String palletCoilMinDiameter,
			String palletCoilMinOfSpools, String palletCoilMinLength, String palletSpoolComment,
			String palletRollsNumber, String palletPalletBCrowd, String palletPalletNCrowd, String palletPalletNNCrowd,
			String palletPalletType, String palletPalletLocation, String palletPalletComment,
			String palletPalletWrapping, String palletPalletWrappingComment) {
		this.palletId = new SimpleStringProperty(String.valueOf(palletId));
		this.palletSpoolType = new SimpleStringProperty(palletSpoolType);
		this.palletSpoolLenght = new SimpleStringProperty(palletSpoolLenght);
		this.palletSpoolSize = new SimpleStringProperty(palletSpoolSize);
		this.palletCoilDiameter = new SimpleStringProperty(palletCoilDiameter);
		this.palletCoilOfSpools = new SimpleStringProperty(palletCoilOfSpools);
		this.palletColiLength = new SimpleStringProperty(palletColiLength);
		this.palletCoilMinDiameter = new SimpleStringProperty(palletCoilMinDiameter);
		this.palletCoilMinOfSpools = new SimpleStringProperty(palletCoilMinOfSpools);
		this.palletCoilMinLength = new SimpleStringProperty(palletCoilMinLength);
		this.palletSpoolComment = new SimpleStringProperty(palletSpoolComment);
		this.palletRollsNumber = new SimpleStringProperty(palletRollsNumber);
		this.palletPalletBCrowd = new SimpleStringProperty(palletPalletBCrowd);
		this.palletPalletNCrowd = new SimpleStringProperty(palletPalletNCrowd);
		this.palletPalletNNCrowd = new SimpleStringProperty(palletPalletNNCrowd);
		this.palletPalletType = new SimpleStringProperty(palletPalletType);
		this.palletPalletLocation = new SimpleStringProperty(palletPalletLocation);
		this.palletPalletComment = new SimpleStringProperty(palletPalletComment);
		this.palletPalletWrapping = new SimpleStringProperty(palletPalletWrapping);
		this.palletPalletWrappingComment = new SimpleStringProperty(palletPalletWrappingComment);
	}

	public SimpleStringProperty getPalletIdProperty() {
		return this.palletId;
	}

	public String getPalletId() {
		return this.palletId.get();
	}

	public void setPalletId(String extruderId) {
		this.palletId.set(extruderId);
	}

	public SimpleStringProperty getPalletSpoolTypeProperty() {
		return this.palletSpoolType;
	}

	public String getPalletSpoolType() {
		return this.palletSpoolType.get();
	}

	public void setPalletSpoolType(String palletSpoolType) {
		this.palletSpoolType.set(palletSpoolType);
	}

	public SimpleStringProperty getPalletSpoolLenghtProperty() {
		return this.palletSpoolLenght;
	}

	public String getPalletSpoolLenght() {
		return this.palletSpoolLenght.get();
	}

	public void setPalletSpoolLenght(String palletSpoolLenght) {
		this.palletSpoolLenght.set(palletSpoolLenght);
	}

	public SimpleStringProperty getPalletSpoolSizeProperty() {
		return this.palletSpoolSize;
	}

	public String getPalletSpoolSize() {
		return this.palletSpoolSize.get();
	}

	public void setPalletSpoolSize(String palletSpoolSize) {
		this.palletSpoolSize.set(palletSpoolSize);
	}

	public SimpleStringProperty getPalletCoilDiameterProperty() {
		return this.palletCoilDiameter;
	}

	public String getPalletCoilDiameter() {
		return this.palletCoilDiameter.get();
	}

	public void setPalletCoilDiameter(String palletCoilDiameter) {
		this.palletCoilDiameter.set(palletCoilDiameter);
	}

	public SimpleStringProperty getPalletCoilOfSpoolsProperty() {
		return this.palletCoilOfSpools;
	}

	public String getPalletCoilOfSpools() {
		return this.palletCoilOfSpools.get();
	}

	public void setPalletCoilOfSpools(String palletCoilOfSpools) {
		this.palletCoilOfSpools.set(palletCoilOfSpools);
	}

	public SimpleStringProperty getPalletColiLengthProperty() {
		return this.palletColiLength;
	}

	public String getPalletColiLength() {
		return this.palletColiLength.get();
	}

	public void setPalletColiLength(String palletColiLength) {
		this.palletColiLength.set(palletColiLength);
	}

	public SimpleStringProperty getPalletColiMinDiameterProperty() {
		return this.palletCoilMinDiameter;
	}

	public String getPalletColiMinDiameter() {
		return this.palletCoilMinDiameter.get();
	}

	public void setPalletColiMinDiameter(String palletCoilMinDiameter) {
		this.palletCoilMinDiameter.set(palletCoilMinDiameter);
	}

	public SimpleStringProperty getPalletColiMinOfSpoolsProperty() {
		return this.palletCoilMinOfSpools;
	}

	public String getPalletColiMinOfSpools() {
		return this.palletCoilMinOfSpools.get();
	}

	public void setPalletColiMinOfSpools(String palletCoilMinOfSpools) {
		this.palletCoilMinOfSpools.set(palletCoilMinOfSpools);
	}

	public SimpleStringProperty getPalletColiMinLengthProperty() {
		return this.palletCoilMinLength;
	}

	public String getPalletColiMinLength() {
		return this.palletCoilMinLength.get();
	}

	public void setPalletColiMinLength(String palletCoilMinLength) {
		this.palletCoilMinLength.set(palletCoilMinLength);
	}

	public SimpleStringProperty getPalletSpoolCommentProperty() {
		return this.palletSpoolComment;
	}

	public String getPalletSpoolComment() {
		return this.palletSpoolComment.get();
	}

	public void setPalletSpoolComment(String palletSpoolComment) {
		this.palletSpoolComment.set(palletSpoolComment);
	}

	public SimpleStringProperty getPalletRollsNumberProperty() {
		return this.palletRollsNumber;
	}

	public String getPalletRollsNumber() {
		return this.palletRollsNumber.get();
	}

	public void setPalletRollsNumber(String palletRollsNumber) {
		this.palletRollsNumber.set(palletRollsNumber);
	}

	public SimpleStringProperty getPalletBCrowdProperty() {
		return this.palletPalletBCrowd;
	}

	public String getPalletBCrowd() {
		return this.palletPalletBCrowd.get();
	}

	public void setPalletBCrowd(String palletPalletBCrowd) {
		this.palletPalletBCrowd.set(palletPalletBCrowd);
	}

	public SimpleStringProperty getPalletNCrowdProperty() {
		return this.palletPalletNCrowd;
	}

	public String getPalletNCrowd() {
		return this.palletPalletNCrowd.get();
	}

	public void setPalletNCrowd(String palletPalletNCrowd) {
		this.palletPalletNCrowd.set(palletPalletNCrowd);
	}

	public SimpleStringProperty getPalletNNCrowdProperty() {
		return this.palletPalletNNCrowd;
	}

	public String getPalletNNCrowd() {
		return this.palletPalletNNCrowd.get();
	}

	public void setPalletNNCrowd(String palletPalletNNCrowd) {
		this.palletPalletNNCrowd.set(palletPalletNNCrowd);
	}

	public SimpleStringProperty getPalletTypeProperty() {
		return this.palletPalletType;
	}

	public String getPalletType() {
		return this.palletPalletType.get();
	}

	public void setPalletType(String palletPalletType) {
		this.palletPalletType.set(palletPalletType);
	}

	public SimpleStringProperty getPalletLocationProperty() {
		return this.palletPalletLocation;
	}

	public String getPalletLocation() {
		return this.palletPalletLocation.get();
	}

	public void setPalletLocation(String palletPalletLocation) {
		this.palletPalletLocation.set(palletPalletLocation);
	}

	public SimpleStringProperty getPalletCommentProperty() {
		return this.palletPalletComment;
	}

	public String getPalletComment() {
		return this.palletPalletComment.get();
	}

	public void setPalletComment(String palletPalletComment) {
		this.palletPalletComment.set(palletPalletComment);
	}

	public SimpleStringProperty getPalletWrappingProperty() {
		return this.palletPalletWrapping;
	}

	public String getPalletWrapping() {
		return this.palletPalletWrapping.get();
	}

	public void setPalletWrapping(String palletPalletWrapping) {
		this.palletPalletWrapping.set(palletPalletWrapping);
	}

	public SimpleStringProperty getPalletWrappingCommentProperty() {
		return this.palletPalletWrappingComment;
	}

	public String getPalletWrappingComment() {
		return this.palletPalletWrappingComment.get();
	}

	public void setPalletWrappingComment(String palletPalletWrappingComment) {
		this.palletPalletWrappingComment.set(palletPalletWrappingComment);
	}
}
