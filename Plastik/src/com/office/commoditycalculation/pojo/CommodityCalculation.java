package com.commoditycalculation.pojo;

import javafx.beans.property.SimpleStringProperty;

public class CommodityCalculation {

	private final SimpleStringProperty commodityId;
	private final SimpleStringProperty calculationName;
	private final SimpleStringProperty commodityQuantity;
	private final SimpleStringProperty commodityName1;
	private final SimpleStringProperty commodityName2;
	private final SimpleStringProperty commodityName3;
	private final SimpleStringProperty commodityName4;
	private final SimpleStringProperty commodityName5;
	private final SimpleStringProperty commodityName6;
	private final SimpleStringProperty commodityName7;
	private final SimpleStringProperty commodityName8;
	private final SimpleStringProperty commodityPercentage1;
	private final SimpleStringProperty commodityPercentage2;
	private final SimpleStringProperty commodityPercentage3;
	private final SimpleStringProperty commodityPercentage4;
	private final SimpleStringProperty commodityPercentage5;
	private final SimpleStringProperty commodityPercentage6;
	private final SimpleStringProperty commodityPercentage7;
	private final SimpleStringProperty commodityPercentage8;
	private final SimpleStringProperty commodityPercentageKg1;
	private final SimpleStringProperty commodityPercentageKg2;
	private final SimpleStringProperty commodityPercentageKg3;
	private final SimpleStringProperty commodityPercentageKg4;
	private final SimpleStringProperty commodityPercentageKg5;
	private final SimpleStringProperty commodityPercentageKg6;
	private final SimpleStringProperty commodityPercentageKg7;
	private final SimpleStringProperty commodityPercentageKg8;

	public CommodityCalculation(Integer commodityId, String commodityQuantity, String commodityName1,
			String commodityName2, String commodityName3, String commodityName4, String commodityName5,
			String commodityName6, String commodityName7, String commodityName8, String commodityPercentage1,
			String commodityPercentage2, String commodityPercentage3, String commodityPercentage4,
			String commodityPercentage5, String commodityPercentage6, String commodityPercentage7,
			String commodityPercentage8, String commodityPercentageKg1, String commodityPercentageKg2,
			String commodityPercentageKg3, String commodityPercentageKg4, String commodityPercentageKg5,
			String commodityPercentageKg6, String commodityPercentageKg7, String commodityPercentageKg8) {
		this.commodityId = new SimpleStringProperty(String.valueOf(commodityId));
		this.calculationName = new SimpleStringProperty("");
		this.commodityQuantity = new SimpleStringProperty(commodityQuantity);
		this.commodityName1 = new SimpleStringProperty(commodityName1);
		this.commodityName2 = new SimpleStringProperty(commodityName2);
		this.commodityName3 = new SimpleStringProperty(commodityName3);
		this.commodityName4 = new SimpleStringProperty(commodityName4);
		this.commodityName5 = new SimpleStringProperty(commodityName5);
		this.commodityName6 = new SimpleStringProperty(commodityName6);
		this.commodityName7 = new SimpleStringProperty(commodityName7);
		this.commodityName8 = new SimpleStringProperty(commodityName8);
		this.commodityPercentage1 = new SimpleStringProperty(commodityPercentage1);
		this.commodityPercentage2 = new SimpleStringProperty(commodityPercentage2);
		this.commodityPercentage3 = new SimpleStringProperty(commodityPercentage3);
		this.commodityPercentage4 = new SimpleStringProperty(commodityPercentage4);
		this.commodityPercentage5 = new SimpleStringProperty(commodityPercentage5);
		this.commodityPercentage6 = new SimpleStringProperty(commodityPercentage6);
		this.commodityPercentage7 = new SimpleStringProperty(commodityPercentage7);
		this.commodityPercentage8 = new SimpleStringProperty(commodityPercentage8);
		this.commodityPercentageKg1 = new SimpleStringProperty(commodityPercentageKg1);
		this.commodityPercentageKg2 = new SimpleStringProperty(commodityPercentageKg2);
		this.commodityPercentageKg3 = new SimpleStringProperty(commodityPercentageKg3);
		this.commodityPercentageKg4 = new SimpleStringProperty(commodityPercentageKg4);
		this.commodityPercentageKg5 = new SimpleStringProperty(commodityPercentageKg5);
		this.commodityPercentageKg6 = new SimpleStringProperty(commodityPercentageKg6);
		this.commodityPercentageKg7 = new SimpleStringProperty(commodityPercentageKg7);
		this.commodityPercentageKg8 = new SimpleStringProperty(commodityPercentageKg8);
	}
	public CommodityCalculation(String calculationName, String commodityQuantity, String commodityName1,
			String commodityName2, String commodityName3, String commodityName4, String commodityName5,
			String commodityName6, String commodityName7, String commodityName8, String commodityPercentage1,
			String commodityPercentage2, String commodityPercentage3, String commodityPercentage4,
			String commodityPercentage5, String commodityPercentage6, String commodityPercentage7,
			String commodityPercentage8, String commodityPercentageKg1, String commodityPercentageKg2,
			String commodityPercentageKg3, String commodityPercentageKg4, String commodityPercentageKg5,
			String commodityPercentageKg6, String commodityPercentageKg7, String commodityPercentageKg8) {
		this.commodityId = new SimpleStringProperty("");
		this.calculationName = new SimpleStringProperty(calculationName);
		this.commodityQuantity = new SimpleStringProperty(commodityQuantity);
		this.commodityName1 = new SimpleStringProperty(commodityName1);
		this.commodityName2 = new SimpleStringProperty(commodityName2);
		this.commodityName3 = new SimpleStringProperty(commodityName3);
		this.commodityName4 = new SimpleStringProperty(commodityName4);
		this.commodityName5 = new SimpleStringProperty(commodityName5);
		this.commodityName6 = new SimpleStringProperty(commodityName6);
		this.commodityName7 = new SimpleStringProperty(commodityName7);
		this.commodityName8 = new SimpleStringProperty(commodityName8);
		this.commodityPercentage1 = new SimpleStringProperty(commodityPercentage1);
		this.commodityPercentage2 = new SimpleStringProperty(commodityPercentage2);
		this.commodityPercentage3 = new SimpleStringProperty(commodityPercentage3);
		this.commodityPercentage4 = new SimpleStringProperty(commodityPercentage4);
		this.commodityPercentage5 = new SimpleStringProperty(commodityPercentage5);
		this.commodityPercentage6 = new SimpleStringProperty(commodityPercentage6);
		this.commodityPercentage7 = new SimpleStringProperty(commodityPercentage7);
		this.commodityPercentage8 = new SimpleStringProperty(commodityPercentage8);
		this.commodityPercentageKg1 = new SimpleStringProperty(commodityPercentageKg1);
		this.commodityPercentageKg2 = new SimpleStringProperty(commodityPercentageKg2);
		this.commodityPercentageKg3 = new SimpleStringProperty(commodityPercentageKg3);
		this.commodityPercentageKg4 = new SimpleStringProperty(commodityPercentageKg4);
		this.commodityPercentageKg5 = new SimpleStringProperty(commodityPercentageKg5);
		this.commodityPercentageKg6 = new SimpleStringProperty(commodityPercentageKg6);
		this.commodityPercentageKg7 = new SimpleStringProperty(commodityPercentageKg7);
		this.commodityPercentageKg8 = new SimpleStringProperty(commodityPercentageKg8);
	}

	public CommodityCalculation(Integer commodityId, String calculationName, String commodityQuantity,
			String commodityName1, String commodityName2, String commodityName3, String commodityName4,
			String commodityName5, String commodityName6, String commodityName7, String commodityName8,
			String commodityPercentage1, String commodityPercentage2, String commodityPercentage3,
			String commodityPercentage4, String commodityPercentage5, String commodityPercentage6,
			String commodityPercentage7, String commodityPercentage8, String commodityPercentageKg1,
			String commodityPercentageKg2, String commodityPercentageKg3, String commodityPercentageKg4,
			String commodityPercentageKg5, String commodityPercentageKg6, String commodityPercentageKg7,
			String commodityPercentageKg8) {
		this.commodityId = new SimpleStringProperty(String.valueOf(commodityId));
		this.calculationName = new SimpleStringProperty(calculationName);
		this.commodityQuantity = new SimpleStringProperty(commodityQuantity);
		this.commodityName1 = new SimpleStringProperty(commodityName1);
		this.commodityName2 = new SimpleStringProperty(commodityName2);
		this.commodityName3 = new SimpleStringProperty(commodityName3);
		this.commodityName4 = new SimpleStringProperty(commodityName4);
		this.commodityName5 = new SimpleStringProperty(commodityName5);
		this.commodityName6 = new SimpleStringProperty(commodityName6);
		this.commodityName7 = new SimpleStringProperty(commodityName7);
		this.commodityName8 = new SimpleStringProperty(commodityName8);
		this.commodityPercentage1 = new SimpleStringProperty(commodityPercentage1);
		this.commodityPercentage2 = new SimpleStringProperty(commodityPercentage2);
		this.commodityPercentage3 = new SimpleStringProperty(commodityPercentage3);
		this.commodityPercentage4 = new SimpleStringProperty(commodityPercentage4);
		this.commodityPercentage5 = new SimpleStringProperty(commodityPercentage5);
		this.commodityPercentage6 = new SimpleStringProperty(commodityPercentage6);
		this.commodityPercentage7 = new SimpleStringProperty(commodityPercentage7);
		this.commodityPercentage8 = new SimpleStringProperty(commodityPercentage8);
		this.commodityPercentageKg1 = new SimpleStringProperty(commodityPercentageKg1);
		this.commodityPercentageKg2 = new SimpleStringProperty(commodityPercentageKg2);
		this.commodityPercentageKg3 = new SimpleStringProperty(commodityPercentageKg3);
		this.commodityPercentageKg4 = new SimpleStringProperty(commodityPercentageKg4);
		this.commodityPercentageKg5 = new SimpleStringProperty(commodityPercentageKg5);
		this.commodityPercentageKg6 = new SimpleStringProperty(commodityPercentageKg6);
		this.commodityPercentageKg7 = new SimpleStringProperty(commodityPercentageKg7);
		this.commodityPercentageKg8 = new SimpleStringProperty(commodityPercentageKg8);
	}

	public SimpleStringProperty getCommodityIdProperty() {
		return this.commodityId;
	}

	public String getCommodityId() {
		return this.commodityId.get();
	}

	public void setCommodityId(String commodityId) {
		this.commodityId.set(commodityId);
	}

	public SimpleStringProperty getCalculationNameProperty() {
		return this.calculationName;
	}

	public String getCalculationName() {
		return this.calculationName.get();
	}

	public void setCalculationName(String calculationName) {
		this.calculationName.set(calculationName);
	}

	public SimpleStringProperty getCommodityQuantityProperty() {
		return this.commodityQuantity;
	}

	public String getCommodityQuantity() {
		return this.commodityQuantity.get();
	}

	public void setCommodityQuantity(String commodityQuantity) {
		this.commodityQuantity.set(commodityQuantity);
	}

	public SimpleStringProperty getCommodityName1Property() {
		return this.commodityName1;
	}

	public String getCommodityName1() {
		return this.commodityName1.get();
	}

	public void setCommodityName1(String commodityName1) {
		this.commodityName1.set(commodityName1);
	}

	public SimpleStringProperty getCommodityName2Property() {
		return this.commodityName2;
	}

	public String getCommodityName2() {
		return this.commodityName2.get();
	}

	public void setCommodityName2(String commodityName2) {
		this.commodityName2.set(commodityName2);
	}

	public SimpleStringProperty getCommodityName3Property() {
		return this.commodityName3;
	}

	public String getCommodityName3() {
		return this.commodityName3.get();
	}

	public void setCommodityName3(String commodityName3) {
		this.commodityName3.set(commodityName3);
	}

	public SimpleStringProperty getCommodityName4Property() {
		return this.commodityName4;
	}

	public String getCommodityName4() {
		return this.commodityName4.get();
	}

	public void setCommodityName4(String commodityName4) {
		this.commodityName4.set(commodityName4);
	}

	public SimpleStringProperty getCommodityName5Property() {
		return this.commodityName5;
	}

	public String getCommodityName5() {
		return this.commodityName5.get();
	}

	public void setCommodityName5(String commodityName5) {
		this.commodityName5.set(commodityName5);
	}

	public SimpleStringProperty getCommodityName6Property() {
		return this.commodityName6;
	}

	public String getCommodityName6() {
		return this.commodityName6.get();
	}

	public void setCommodityName6(String commodityName6) {
		this.commodityName6.set(commodityName6);
	}

	public SimpleStringProperty getCommodityName7Property() {
		return this.commodityName7;
	}

	public String getCommodityName7() {
		return this.commodityName7.get();
	}

	public void setCommodityName7(String commodityName7) {
		this.commodityName7.set(commodityName7);
	}

	public SimpleStringProperty getCommodityName8Property() {
		return this.commodityName8;
	}

	public String getCommodityName8() {
		return this.commodityName8.get();
	}

	public void setCommodityName8(String commodityName8) {
		this.commodityName8.set(commodityName8);
	}

	public SimpleStringProperty getCommodityPercentage1Property() {
		return this.commodityPercentage1;
	}

	public String getCommodityPercentage1() {
		return this.commodityPercentage1.get();
	}

	public void setCommodityPercentage1(String commodityPercentage1) {
		this.commodityPercentage1.set(commodityPercentage1);
	}

	public SimpleStringProperty getCommodityPercentage2Property() {
		return this.commodityPercentage2;
	}

	public String getCommodityPercentage2() {
		return this.commodityPercentage2.get();
	}

	public void setCommodityPercentage2(String commodityPercentage2) {
		this.commodityPercentage2.set(commodityPercentage2);
	}

	public SimpleStringProperty getCommodityPercentage3Property() {
		return this.commodityPercentage3;
	}

	public String getCommodityPercentage3() {
		return this.commodityPercentage3.get();
	}

	public void setCommodityPercentage3(String commodityPercentage3) {
		this.commodityPercentage3.set(commodityPercentage3);
	}

	public SimpleStringProperty getCommodityPercentage4Property() {
		return this.commodityPercentage4;
	}

	public String getCommodityPercentage4() {
		return this.commodityPercentage4.get();
	}

	public void setCommodityPercentage4(String commodityPercentage4) {
		this.commodityPercentage4.set(commodityPercentage4);
	}

	public SimpleStringProperty getCommodityPercentage5Property() {
		return this.commodityPercentage5;
	}

	public String getCommodityPercentage5() {
		return this.commodityPercentage5.get();
	}

	public void setCommodityPercentage5(String commodityPercentage5) {
		this.commodityPercentage5.set(commodityPercentage5);
	}

	public SimpleStringProperty getCommodityPercentage6Property() {
		return this.commodityPercentage6;
	}

	public String getCommodityPercentage6() {
		return this.commodityPercentage6.get();
	}

	public void setCommodityPercentage6(String commodityPercentage6) {
		this.commodityPercentage6.set(commodityPercentage6);
	}

	public SimpleStringProperty getCommodityPercentage7Property() {
		return this.commodityPercentage7;
	}

	public String getCommodityPercentage7() {
		return this.commodityPercentage7.get();
	}

	public void setCommodityPercentage7(String commodityPercentage7) {
		this.commodityPercentage7.set(commodityPercentage7);
	}

	public SimpleStringProperty getCommodityPercentage8Property() {
		return this.commodityPercentage8;
	}

	public String getCommodityPercentage8() {
		return this.commodityPercentage8.get();
	}

	public void setCommodityPercentage8(String commodityPercentage8) {
		this.commodityPercentage8.set(commodityPercentage8);
	}

	public SimpleStringProperty getCommodityPercentageKg1Property() {
		return this.commodityPercentageKg1;
	}

	public String getCommodityPercentageKg1() {
		return this.commodityPercentageKg1.get();
	}

	public void setCommodityPercentageKg1(String commodityPercentageKg1) {
		this.commodityPercentageKg1.set(commodityPercentageKg1);
	}

	public SimpleStringProperty getCommodityPercentageKg2Property() {
		return this.commodityPercentageKg2;
	}

	public String getCommodityPercentageKg2() {
		return this.commodityPercentageKg2.get();
	}

	public void setCommodityPercentageKg2(String commodityPercentageKg2) {
		this.commodityPercentageKg2.set(commodityPercentageKg2);
	}

	public SimpleStringProperty getCommodityPercentageKg3Property() {
		return this.commodityPercentageKg3;
	}

	public String getCommodityPercentageKg3() {
		return this.commodityPercentageKg3.get();
	}

	public void setCommodityPercentageKg3(String commodityPercentageKg3) {
		this.commodityPercentageKg3.set(commodityPercentageKg3);
	}

	public SimpleStringProperty getCommodityPercentageKg4Property() {
		return this.commodityPercentageKg4;
	}

	public String getCommodityPercentageKg4() {
		return this.commodityPercentageKg4.get();
	}

	public void setCommodityPercentageKg4(String commodityPercentageKg4) {
		this.commodityPercentageKg4.set(commodityPercentageKg4);
	}

	public SimpleStringProperty getCommodityPercentageKg5Property() {
		return this.commodityPercentageKg5;
	}

	public String getCommodityPercentageKg5() {
		return this.commodityPercentageKg5.get();
	}

	public void setCommodityPercentageKg5(String commodityPercentageKg5) {
		this.commodityPercentageKg5.set(commodityPercentageKg5);
	}

	public SimpleStringProperty getCommodityPercentageKg6Property() {
		return this.commodityPercentageKg6;
	}

	public String getCommodityPercentageKg6() {
		return this.commodityPercentageKg6.get();
	}

	public void setCommodityPercentageKg6(String commodityPercentageKg6) {
		this.commodityPercentageKg6.set(commodityPercentageKg6);
	}

	public SimpleStringProperty getCommodityPercentageKg7Property() {
		return this.commodityPercentageKg7;
	}

	public String getCommodityPercentageKg7() {
		return this.commodityPercentageKg7.get();
	}

	public void setCommodityPercentageKg7(String commodityPercentageKg7) {
		this.commodityPercentageKg7.set(commodityPercentageKg7);
	}

	public SimpleStringProperty getCommodityPercentageKg8Property() {
		return this.commodityPercentageKg8;
	}

	public String getCommodityPercentageKg8() {
		return this.commodityPercentageKg8.get();
	}

	public void setCommodityPercentageKg8(String commodityPercentageKg8) {
		this.commodityPercentageKg8.set(commodityPercentageKg8);
	}
}
