package com.office.extruder.statistic.controller;

import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

import com.office.extruder.name.ExtruderName;
import com.office.extruder.statistic.database.StatisticDataBase;
import com.production.transmission.extruder.pojo.TransmissionExtruder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class SatisticController implements Initializable {

	@FXML
	private LineChart<String, Double> lineChartGood, lineChartError;
	private ExtruderName extruderName = new ExtruderName();
	private final ObservableList<TransmissionExtruder> dataStatistic = FXCollections.observableArrayList();
	private StatisticDataBase atatisticDataBase = new StatisticDataBase();

	@FXML
	private void save() {
		clearLineChart(lineChartGood);
		clearLineChart(lineChartError);
		int s = 0;
		int j = 3;
		for (int i = 0; i < 13; i++) {
			s++;
		
			lineChartGood.getData().add(createChartSeriesGood(i));

			lineChartError.getData().add(createChartSeriesGood(i));
		}

	}

	private void clearLineChart(LineChart<String, Double> clear) {
		clear.getData().clear();

	}

	private ObservableList<TransmissionExtruder> extruderData() {
		dataStatistic.clear();
		dataStatistic.addAll(atatisticDataBase.getAllClient());
		return dataStatistic;

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		lineChartGood.setTitle("Késztermék");
		lineChartError.setTitle("Hulladék");

	}

	private XYChart.Series<String, Double> createChartSeriesGood(Integer i) {
		extruderData();
		XYChart.Series<String, Double> series = null;
		series = new XYChart.Series<String, Double>();
		series.getData().add(new XYChart.Data<String, Double>("JANUÁR",2.0));
		series.getData().add(new XYChart.Data<String, Double>("FEBRUÁR",8.0));
		series.getData().add(new XYChart.Data<String, Double>("MÁRCIUS",212.0));
		series.getData().add(new XYChart.Data<String, Double>("ÁPRILIS",4.0));
		series.getData().add(new XYChart.Data<String, Double>("MÁJUS",8.0));
		series.getData().add(new XYChart.Data<String, Double>("JÚNIUS",90.0));
		series.getData().add(new XYChart.Data<String, Double>("AUGUSZTUS",22.0));
		series.getData().add(new XYChart.Data<String, Double>("SZEPTEMBER",64.0));
		series.getData().add(new XYChart.Data<String, Double>("OKTÓBER",12.0));
		series.getData().add(new XYChart.Data<String, Double>("NOVEMBER",67.0));
		series.getData().add(new XYChart.Data<String, Double>("DECEMBER",2.0));
		series.setName(extruderName.extruderName1(i));
		return series;
	}

}
