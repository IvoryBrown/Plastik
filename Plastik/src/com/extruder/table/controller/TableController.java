package com.extruder.table.controller;

import java.util.Date;

import com.client.pojo.Client;
import com.extruder.pojo.Extruder;
import com.extruder.table.database.TableDataBase;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableController {
	private TableView<Extruder> extruderTableView;
	private TableColumn<Extruder, Integer> extruderId, extruderClientId, extruderFlatPlateBag, extruderWidth,
			extruderLength;
	private TableColumn<Extruder, Date> extruderAddDate, extruderEndDate;
	private TableColumn<Extruder, Double> extruderThickness, extruderGrammMeter, extruderOrderedKg, extruderActualKg;
	private TableColumn<Extruder, String> extruderIdentification, extruderStatus, extruderCommodity, extruderActualSize,
			extruderName, extruderComment;
	private Label messageLbl;
	private final ObservableList<Extruder> dataExtruder = FXCollections.observableArrayList();
	private TableDataBase tableDataBase = new TableDataBase();

	public TableController(TableView<Extruder> extruderTableView, Label messageLbl) {
		this.extruderTableView = extruderTableView;
		this.messageLbl = messageLbl;
		clearTable();
		extruderTable();
		setColumn();
	}

	private void clearTable() {
		extruderTableView.getItems().clear();
		extruderTableView.getColumns().clear();
		extruderTableView.setItems(errorDataClient());
	}

	@SuppressWarnings("unchecked")
	private void setColumn() {
		extruderTableView.getColumns().addAll(extruderId, extruderClientId,extruderName, extruderIdentification, extruderStatus,
				extruderAddDate, extruderEndDate, extruderCommodity, extruderActualSize, extruderWidth, extruderLength,
				extruderThickness, extruderFlatPlateBag, extruderGrammMeter, extruderOrderedKg, extruderActualKg,
				extruderComment);

	}

	private void extruderTable() {
		extruderId = new TableColumn<>("ID");
		extruderId.setMinWidth(80);
		extruderId.setCellValueFactory(new PropertyValueFactory<Extruder, Integer>("extruderId"));

		extruderClientId = new TableColumn<>("ID");
		extruderClientId.setMinWidth(80);
		extruderClientId.setCellValueFactory(new PropertyValueFactory<Extruder, Integer>("extruderClientId"));

		extruderName = new TableColumn<>("Extruder gép");
		extruderName.setMinWidth(80);
		extruderName.setCellValueFactory(new PropertyValueFactory<Extruder, String>("extruderName"));

		extruderIdentification = new TableColumn<>("Azonosító");
		extruderIdentification.setMinWidth(80);
		extruderIdentification
				.setCellValueFactory(new PropertyValueFactory<Extruder, String>("extruderIdentification"));

		extruderStatus = new TableColumn<>("Státusz");
		extruderStatus.setMinWidth(80);
		extruderStatus.setCellValueFactory(new PropertyValueFactory<Extruder, String>("extruderStatus"));

		extruderAddDate = new TableColumn<>("Rögzítés");
		extruderAddDate.setMinWidth(80);
		extruderAddDate.setCellValueFactory(new PropertyValueFactory<Extruder, Date>("extruderAddDate"));

		extruderEndDate = new TableColumn<>("Határidő");
		extruderEndDate.setMinWidth(80);
		extruderEndDate.setCellValueFactory(new PropertyValueFactory<Extruder, Date>("extruderEndDate"));

		extruderCommodity = new TableColumn<>("Alapanyag");
		extruderCommodity.setMinWidth(80);
		extruderCommodity.setCellValueFactory(new PropertyValueFactory<Extruder, String>("extruderCommodity"));

		extruderActualSize = new TableColumn<>("Aktuális méret");
		extruderActualSize.setMinWidth(80);
		extruderActualSize.setCellValueFactory(new PropertyValueFactory<Extruder, String>("extruderActualSize"));

		extruderWidth = new TableColumn<>("Szélesség");
		extruderWidth.setMinWidth(80);
		extruderWidth.setCellValueFactory(new PropertyValueFactory<Extruder, Integer>("extruderWidth"));

		extruderLength = new TableColumn<>("Hosszuság");
		extruderLength.setMinWidth(80);
		extruderLength.setCellValueFactory(new PropertyValueFactory<Extruder, Integer>("extruderLength"));

		extruderThickness = new TableColumn<>("Vastagság");
		extruderThickness.setMinWidth(80);
		extruderThickness.setCellValueFactory(new PropertyValueFactory<Extruder, Double>("extruderThickness"));

		extruderFlatPlateBag = new TableColumn<>("Zsák 2 / Síklap 1");
		extruderFlatPlateBag.setMinWidth(80);
		extruderFlatPlateBag.setCellValueFactory(new PropertyValueFactory<Extruder, Integer>("extruderFlatPlateBag"));

		extruderGrammMeter = new TableColumn<>("g/m");
		extruderGrammMeter.setMinWidth(80);
		extruderGrammMeter.setCellValueFactory(new PropertyValueFactory<Extruder, Double>("extruderGrammMeter"));

		extruderOrderedKg = new TableColumn<>("Megrendelt kg");
		extruderOrderedKg.setMinWidth(80);
		extruderOrderedKg.setCellValueFactory(new PropertyValueFactory<Extruder, Double>("extruderOrderedKg"));

		extruderActualKg = new TableColumn<>("Legyártott kg");
		extruderActualKg.setMinWidth(80);
		extruderActualKg.setCellValueFactory(new PropertyValueFactory<Extruder, Double>("extruderActualKg"));

		extruderComment = new TableColumn<>("Megjegyzés");
		extruderComment.setMinWidth(80);
		extruderComment.setCellValueFactory(new PropertyValueFactory<Extruder, String>("extruderComment"));

	}
	
	private ObservableList<Extruder> errorDataClient() {
		dataExtruder.clear();
		dataExtruder.addAll(tableDataBase.getAllExtruder(""));
		return dataExtruder;

	}
}
