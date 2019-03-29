package com.office.extruder.statistic.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.office.extruder.name.ExtruderName;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class SatisticController implements Initializable {

	@FXML
	private LineChart<String, Number> lineChartGood,lineChartError;
	private ExtruderName extruderName = new ExtruderName();

	@FXML
	private void save() {
		createChartSeriesExtruder1().getData().clear();
		lineChartGood.getData().clear();
		lineChartGood.getData().add(createChartSeriesExtruder1());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		lineChartGood.setTitle("Késztermék");
		lineChartError.setTitle("Hulladék");
		
	}

	private XYChart.Series<String, Number> createChartSeriesExtruder1() {

		XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
		series.getData().add(new XYChart.Data<String, Number>("sd", 130));
		series.getData().add(new XYChart.Data<String, Number>("sd1", 212));
		series.getData().add(new XYChart.Data<String, Number>("sdw",234));
		series.getData().add(new XYChart.Data<String, Number>("sde", 978));
		series.getData().add(new XYChart.Data<String, Number>("sdr", 32));
		series.setName(extruderName.extruderName());
	
		return series;
	}

}
