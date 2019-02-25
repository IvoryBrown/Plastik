package com.extruder.controller;

import javafx.scene.control.TextField;

public class ComodityPojo {
	private static TextField quantityTxt;

	private static TextField commodityName1Txt, commodityName2Txt, commodityName3Txt, commodityName4Txt, commodityName5Txt,
			commodityName6Txt, commodityName7Txt, commodityName8Txt;
	
	private static TextField commodityPercentage1Txt, commodityPercentage2Txt, commodityPercentage3Txt,
			commodityPercentage4Txt, commodityPercentage5Txt, commodityPercentage6Txt, commodityPercentage7Txt,
			commodityPercentage8Txt;
	
	private static TextField commodityPercentageKg1Txt, commodityPercentageKg2Txt, commodityPercentageKg3Txt,
			commodityPercentageKg4Txt, commodityPercentageKg5Txt, commodityPercentageKg6Txt, commodityPercentageKg7Txt,
			commodityPercentageKg8Txt;

	public static void comodityPojoSet(TextField quantityTxt, TextField commodityName1Txt, TextField commodityName2Txt,
			TextField commodityName3Txt, TextField commodityName4Txt, TextField commodityName5Txt,
			TextField commodityName6Txt, TextField commodityName7Txt, TextField commodityName8Txt,
			TextField commodityPercentage1Txt, TextField commodityPercentage2Txt, TextField commodityPercentage3Txt,
			TextField commodityPercentage4Txt, TextField commodityPercentage5Txt, TextField commodityPercentage6Txt,
			TextField commodityPercentage7Txt, TextField commodityPercentage8Txt, TextField commodityPercentageKg1Txt,
			TextField commodityPercentageKg2Txt, TextField commodityPercentageKg3Txt,
			TextField commodityPercentageKg4Txt, TextField commodityPercentageKg5Txt,
			TextField commodityPercentageKg6Txt, TextField commodityPercentageKg7Txt,
			TextField commodityPercentageKg8Txt) {
		ComodityPojo.quantityTxt = quantityTxt;
		ComodityPojo.commodityName1Txt = commodityName1Txt;
		ComodityPojo.commodityName2Txt = commodityName2Txt;
		ComodityPojo.commodityName3Txt = commodityName3Txt;
		ComodityPojo.commodityName4Txt = commodityName4Txt;
		ComodityPojo.commodityName5Txt = commodityName5Txt;
		ComodityPojo.commodityName6Txt = commodityName6Txt;
		ComodityPojo.commodityName7Txt = commodityName7Txt;
		ComodityPojo.commodityName8Txt = commodityName8Txt;
		ComodityPojo.commodityPercentage1Txt = commodityPercentage1Txt;
		ComodityPojo.commodityPercentage2Txt = commodityPercentage2Txt;
		ComodityPojo.commodityPercentage3Txt = commodityPercentage3Txt;
		ComodityPojo.commodityPercentage4Txt = commodityPercentage4Txt;
		ComodityPojo.commodityPercentage5Txt = commodityPercentage5Txt;
		ComodityPojo.commodityPercentage6Txt = commodityPercentage6Txt;
		ComodityPojo.commodityPercentage7Txt = commodityPercentage7Txt;
		ComodityPojo.commodityPercentage8Txt = commodityPercentage8Txt;
		ComodityPojo.commodityPercentageKg1Txt = commodityPercentageKg1Txt;
		ComodityPojo.commodityPercentageKg2Txt = commodityPercentageKg2Txt;
		ComodityPojo.commodityPercentageKg3Txt = commodityPercentageKg3Txt;
		ComodityPojo.commodityPercentageKg4Txt = commodityPercentageKg4Txt;
		ComodityPojo.commodityPercentageKg5Txt = commodityPercentageKg5Txt;
		ComodityPojo.commodityPercentageKg6Txt = commodityPercentageKg6Txt;
		ComodityPojo.commodityPercentageKg7Txt = commodityPercentageKg7Txt;
		ComodityPojo.commodityPercentageKg8Txt = commodityPercentageKg8Txt;
	}
	
	public static void clearComodityPojo() {
		commodityName1Txt.clear();
		commodityName2Txt.clear();
		commodityName3Txt.clear();
		commodityName4Txt.clear();
		commodityName5Txt.clear();
		commodityName6Txt.clear();
		commodityName7Txt.clear();
		commodityName8Txt.clear();
		commodityPercentageKg1Txt.clear();
		commodityPercentageKg2Txt.clear();
		commodityPercentageKg3Txt.clear();
		commodityPercentageKg4Txt.clear();
		commodityPercentageKg5Txt.clear();
		commodityPercentageKg6Txt.clear();
		commodityPercentageKg7Txt.clear();
		commodityPercentageKg8Txt.clear();
		commodityPercentage1Txt.clear();
		commodityPercentage2Txt.clear();
		commodityPercentage3Txt.clear();
		commodityPercentage4Txt.clear();
		commodityPercentage5Txt.clear();
		commodityPercentage6Txt.clear();
		commodityPercentage7Txt.clear();
		commodityPercentage8Txt.clear();
		quantityTxt.clear();
	}

	
}
