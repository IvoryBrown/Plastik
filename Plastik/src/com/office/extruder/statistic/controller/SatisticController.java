package com.office.extruder.statistic.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.office.extruder.statistic.database.StatisticDataBase;
import com.project.setting.machine.database.MachineDataBase;
import com.project.setting.machine.pojo.Machine;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class SatisticController implements Initializable {

	@FXML
	private LineChart<String, Double> lineChartGood, lineChartError;
	private StatisticDataBase atatisticDataBase = new StatisticDataBase();
	private ObservableList<Machine> dataExtruderName = FXCollections.observableArrayList();
	private MachineDataBase machineDataBase = new MachineDataBase();

	@FXML
	private void save() {
		clearLineChart(lineChartGood);
		clearLineChart(lineChartError);
		extruderName();
		extruderNameAlies();

	}

	private void clearLineChart(LineChart<String, Double> clear) {
		clear.getData().clear();

	}

	// database where
	private Double extruderData(String name, String startDate, String endDate) {
		return atatisticDataBase.data(name, startDate, endDate);

	}

	// extruder name list
	private ObservableList<Machine> extruderName() {
		dataExtruderName.clear();
		dataExtruderName.addAll(machineDataBase.getAllMachine());
		return dataExtruderName;

	}

	private void extruderNameAlies() {
		String formattedString = String.valueOf(LocalDate.now().getYear());
		for (int i = 0; i < dataExtruderName.size(); i++) {
			lineChartGood.getData().add(createChartSeriesGood(
					extruderData(dataExtruderName.get(i).getMachineName(), formattedString + "-01-01",
							formattedString + "-02-01"),
					extruderData(dataExtruderName.get(i).getMachineName(), formattedString + "-02-01",
							formattedString + "-03-01"),
					extruderData(dataExtruderName.get(i).getMachineName(), formattedString + "-03-01",
							formattedString + "-04-01"),
					extruderData(dataExtruderName.get(i).getMachineName(), formattedString + "-04-01",
							formattedString + "-05-01"),
					extruderData(dataExtruderName.get(i).getMachineName(), formattedString + "-05-01",
							formattedString + "-06-01"),
					extruderData(dataExtruderName.get(i).getMachineName(), formattedString + "-06-01",
							formattedString + "-07-01"),
					extruderData(dataExtruderName.get(i).getMachineName(), formattedString + "-07-01",
							formattedString + "-08-01"),
					extruderData(dataExtruderName.get(i).getMachineName(), formattedString + "-08-01",
							formattedString + "-09-01"),
					extruderData(dataExtruderName.get(i).getMachineName(), formattedString + "-09-01",
							formattedString + "-10-01"),
					extruderData(dataExtruderName.get(i).getMachineName(), formattedString + "-10-01",
							formattedString + "-11-01"),
					extruderData(dataExtruderName.get(i).getMachineName(), formattedString + "-11-01",
							formattedString + "-12-01"),
					extruderData(dataExtruderName.get(i).getMachineName(), formattedString + "-12-01",
							String.valueOf(LocalDate.now().getYear() + 1) + "-01-01"),
					dataExtruderName.get(i).getMachineName()));
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		lineChartGood.setTitle("Késztermék");
		lineChartError.setTitle("Hulladék");
		lineChartGood.getData().add(createChartSeriesGood(1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, ""));
	}

	private XYChart.Series<String, Double> createChartSeriesGood(Double jan, Double feb, Double mar, Double aprl,
			Double maj, Double jun, Double jul, Double aug, Double sept, Double okt, Double nov, Double dec,
			String extruderName) {
		XYChart.Series<String, Double> series = null;

		series = new XYChart.Series<String, Double>();
		series.getData().add(new XYChart.Data<String, Double>("JANUÁR", jan));
		series.getData().add(new XYChart.Data<String, Double>("FEBRUÁR", feb));
		series.getData().add(new XYChart.Data<String, Double>("MÁRCIUS", mar));
		series.getData().add(new XYChart.Data<String, Double>("ÁPRILIS", aprl));
		series.getData().add(new XYChart.Data<String, Double>("MÁJUS", maj));
		series.getData().add(new XYChart.Data<String, Double>("JÚNIUS", jun));
		series.getData().add(new XYChart.Data<String, Double>("Július", jul));
		series.getData().add(new XYChart.Data<String, Double>("AUGUSZTUS", aug));
		series.getData().add(new XYChart.Data<String, Double>("SZEPTEMBER", sept));
		series.getData().add(new XYChart.Data<String, Double>("OKTÓBER", okt));
		series.getData().add(new XYChart.Data<String, Double>("NOVEMBER", nov));
		series.getData().add(new XYChart.Data<String, Double>("DECEMBER", dec));
		series.setName(extruderName);
	
		return series;
	}

}
