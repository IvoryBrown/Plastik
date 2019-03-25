package com.main.extruder;

public class Extruder {
	private String extruderIdentification;
	private String extruderStatus;
	private String extruderAddDate;
	private String extruderEndDate;
	private String extruderCommodity;
	private String extruderActualSize;
	private String extruderWidth;
	private String extruderLength;
	private String extruderThickness;
	private String extruderFlatPlateBag;
	private String extruderGrammMeter;
	private String extruderOrderedKg;
	private String extruderName;
	private String extruderComment;
	private String extruderPriority;

	public String getExtruderIdentification() {
		extruderIdentification = IdentificationGenereator.generateIdentification();
		return extruderIdentification;
	}

	public void setExtruderIdentification(String extruderIdentification) {
		this.extruderIdentification = extruderIdentification;
	}

	public String getExtruderStatus() {
		this.extruderStatus = StatusRandom.generateStatus();
		return extruderStatus;
	}

	public void setExtruderStatus(String extruderStatus) {
		this.extruderStatus = extruderStatus;
	}

	public String getExtruderAddDate() {
		extruderAddDate = DateRandom.date();
		return extruderAddDate;
	}

	public void setExtruderAddDate(String extruderAddDate) {
		this.extruderAddDate = extruderAddDate;
	}

	public String getExtruderEndDate() {
		extruderEndDate = DateRandom.date();
		return extruderEndDate;
	}

	public void setExtruderEndDate(String extruderEndDate) {
		this.extruderEndDate = extruderEndDate;
	}

	public String getExtruderCommodity() {
		extruderCommodity = CommodityRandom.generateCommodity();
		return extruderCommodity;
	}

	public void setExtruderCommodity(String extruderCommodity) {
		this.extruderCommodity = extruderCommodity;
	}

	public String getExtruderActualSize() {
		extruderActualSize = ActualSizeRandom.generateActualSize();
		return extruderActualSize;
	}

	public void setExtruderActualSize(String extruderActualSize) {
		this.extruderActualSize = extruderActualSize;
	}

	public String getExtruderWidth() {
		extruderWidth = WidthRandom.generateWidth();
		return extruderWidth;
	}

	public void setExtruderWidth(String extruderWidth) {
		this.extruderWidth = extruderWidth;
	}

	public String getExtruderLength() {
		extruderLength = LengthRandom.generateLength();
		return extruderLength;
	}

	public void setExtruderLength(String extruderLength) {
		this.extruderLength = extruderLength;
	}

	public String getExtruderThickness() {
		extruderThickness = ThicknessRandom.generateThickness();
		return extruderThickness;
	}

	public void setExtruderThickness(String extruderThickness) {
		this.extruderThickness = extruderThickness;
	}

	public String getExtruderFlatPlateBag() {
		extruderFlatPlateBag = FlatPlateBagRandom.generateFlatPlateBag();
		return extruderFlatPlateBag;
	}

	public void setExtruderFlatPlateBag(String extruderFlatPlateBag) {
		this.extruderFlatPlateBag = extruderFlatPlateBag;
	}

	public String getExtruderGrammMeter() {
		extruderGrammMeter = GrammMeterRandom.generateGrammMeter();
		return extruderGrammMeter;
	}

	public void setExtruderGrammMeter(String extruderGrammMeter) {
		this.extruderGrammMeter = extruderGrammMeter;
	}

	public String getExtruderOrderedKg() {
		extruderOrderedKg = OrderedKgRandom.generateOrderedKg();
		return extruderOrderedKg;
	}

	public void setExtruderOrderedKg(String extruderOrderedKg) {
		this.extruderOrderedKg = extruderOrderedKg;
	}

	public String getExtruderName() {
		extruderName = NameRandom.generateName();
		return extruderName;
	}

	public void setExtruderName(String extruderName) {
		this.extruderName = extruderName;
	}

	public String getExtruderComment() {
		extruderComment = CommentRandom.generateComment();
		return extruderComment;
	}

	public void setExtruderComment(String extruderComment) {
		this.extruderComment = extruderComment;
	}

	public String getExtruderPriority() {
		extruderPriority = PriorityRandom.generatePriority();
		return extruderPriority;
	}

	public void setExtruderPriority(String extruderPriority) {
		this.extruderPriority = extruderPriority;
	}
}
