package com.extruder.table.controller;

import java.util.Date;

import com.extruder.pojo.Extruder;
import com.extruder.table.database.TableDataBase;
import com.setting.label.MessageLabel;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.StageStyle;

public class TableController {
	private AnchorPane extruderNewJobsPane, extruderActualJobsPane;
	private TableView<Extruder> extruderTableView;
	private TableColumn<Extruder, Integer> extruderId, extruderClientId, extruderFlatPlateBag, extruderWidth,
			extruderLength;
	private TableColumn<Extruder, Date> extruderAddDate, extruderEndDate;
	private TableColumn<Extruder, Double> extruderThickness, extruderGrammMeter, extruderOrderedKg, extruderActualKg;
	private TableColumn<Extruder, String> extruderClientName, extruderIdentification, extruderStatus, extruderCommodity,
			extruderActualSize, extruderName, extruderComment;
	private Button extruderNameBtn1, extruderNameBtn2, extruderNameBtn3, extruderNameBtn4, extruderNameBtn5,
			extruderNameBtn6, extruderNameBtn7, extruderNameBtn8, extruderNameBtn9, extruderNameBtn10,
			extruderNameBtn11, extruderNameBtn12, extruderNameBtn13, extruderNameBtn14, extruderNameAllBtn;
	private Label messageLbl;
	private final ObservableList<Extruder> dataExtruder = FXCollections.observableArrayList();
	private TableDataBase tableDataBase = new TableDataBase();
	private MessageLabel message = new MessageLabel();

	public TableController(AnchorPane extruderNewJobsPane, AnchorPane extruderActualJobsPane,
			TableView<Extruder> extruderTableView, Label messageLbl, Button extruderNameBtn1, Button extruderNameBtn2,
			Button extruderNameBtn3, Button extruderNameBtn4, Button extruderNameBtn5, Button extruderNameBtn6,
			Button extruderNameBtn7, Button extruderNameBtn8, Button extruderNameBtn9, Button extruderNameBtn10,
			Button extruderNameBtn11, Button extruderNameBtn12, Button extruderNameBtn13, Button extruderNameBtn14,
			Button extruderNameAllBtn) {
		this.extruderNewJobsPane = extruderNewJobsPane;
		this.extruderActualJobsPane = extruderActualJobsPane;
		this.extruderTableView = extruderTableView;
		this.messageLbl = messageLbl;
		this.extruderNameBtn1 = extruderNameBtn1;
		this.extruderNameBtn2 = extruderNameBtn2;
		this.extruderNameBtn3 = extruderNameBtn3;
		this.extruderNameBtn4 = extruderNameBtn4;
		this.extruderNameBtn5 = extruderNameBtn5;
		this.extruderNameBtn6 = extruderNameBtn6;
		this.extruderNameBtn7 = extruderNameBtn7;
		this.extruderNameBtn8 = extruderNameBtn8;
		this.extruderNameBtn9 = extruderNameBtn9;
		this.extruderNameBtn10 = extruderNameBtn10;
		this.extruderNameBtn11 = extruderNameBtn11;
		this.extruderNameBtn12 = extruderNameBtn12;
		this.extruderNameBtn13 = extruderNameBtn13;
		this.extruderNameBtn14 = extruderNameBtn14;
		this.extruderNameAllBtn = extruderNameAllBtn;
		clearTable();
		extruderTable();
		setColumn();
		buttonOnAction();
	}

	private void clearTable() {
		extruderTableView.getItems().clear();
		extruderTableView.getColumns().clear();

	}

	@SuppressWarnings("unchecked")
	private void setColumn() {
		extruderTableView.getColumns().addAll(extruderId, extruderClientId, extruderClientName, extruderName,
				extruderIdentification, extruderStatus, extruderAddDate, extruderEndDate, extruderCommodity,
				extruderActualSize, extruderWidth, extruderLength, extruderThickness, extruderFlatPlateBag,
				extruderGrammMeter, extruderOrderedKg, extruderActualKg, extruderComment);

	}

	private void extruderTable() {
		extruderId = new TableColumn<>("ID");
		extruderId.setMinWidth(80);
		extruderId.setCellValueFactory(new PropertyValueFactory<Extruder, Integer>("extruderId"));

		extruderClientId = new TableColumn<>("ID");
		extruderClientId.setMinWidth(90);
		extruderClientId.setCellValueFactory(new PropertyValueFactory<Extruder, Integer>("extruderClientId"));

		extruderClientName = new TableColumn<>("Ügyfél név");
		extruderClientName.setMinWidth(120);
		extruderClientName.setCellValueFactory(new PropertyValueFactory<Extruder, String>("extruderClientName"));

		extruderName = new TableColumn<>("Extruder gép");
		extruderName.setMinWidth(120);
		extruderName.setCellValueFactory(new PropertyValueFactory<Extruder, String>("extruderName"));

		extruderIdentification = new TableColumn<>("Azonosító");
		extruderIdentification.setMinWidth(120);
		extruderIdentification
				.setCellValueFactory(new PropertyValueFactory<Extruder, String>("extruderIdentification"));

		extruderStatus = new TableColumn<>("Státusz");
		extruderStatus.setMinWidth(100);
		extruderStatus.setCellValueFactory(i -> {
			final String value = i.getValue().getExtruderStatus();
			return Bindings.createObjectBinding(() -> value);
		});
		extruderStatus.setCellFactory(ComboBoxTableCell.forTableColumn("Elkészült"));
		extruderStatus.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Extruder, String>>() {
			@Override
			public void handle(TableColumn.CellEditEvent<Extruder, String> d) {
				Alert alert = new Alert(Alert.AlertType.NONE, "Biztos ki akarsz lépni?", ButtonType.YES, ButtonType.NO);
				alert.getDialogPane().getStylesheets().add("/com/setting/showinfo/ShowInfo.css");
				alert.initStyle(StageStyle.TRANSPARENT);
				if (alert.showAndWait().orElse(ButtonType.NO) == ButtonType.YES) {
					Extruder extruder = (Extruder) d.getTableView().getItems().get(d.getTablePosition().getRow());
					extruder.setExtruderStatus(d.getNewValue());
					tableDataBase.updateExtruder(extruder);
					message.goodMessage("Státusz sikeres frissitése", messageLbl);
				}
			}
		});

		extruderAddDate = new TableColumn<>("Rögzítés");
		extruderAddDate.setMinWidth(80);
		extruderAddDate.setCellValueFactory(new PropertyValueFactory<Extruder, Date>("extruderAddDate"));

		extruderEndDate = new TableColumn<>("Határidő");
		extruderEndDate.setMinWidth(80);
		extruderEndDate.setCellValueFactory(new PropertyValueFactory<Extruder, Date>("extruderEndDate"));

		extruderCommodity = new TableColumn<>("Alapanyag");
		extruderCommodity.setMinWidth(120);
		extruderCommodity.setCellValueFactory(new PropertyValueFactory<Extruder, String>("extruderCommodity"));

		extruderActualSize = new TableColumn<>("Aktuális méret");
		extruderActualSize.setMinWidth(170);
		extruderActualSize.setCellValueFactory(new PropertyValueFactory<Extruder, String>("extruderActualSize"));

		extruderWidth = new TableColumn<>("Szélesség");
		extruderWidth.setMinWidth(80);
		extruderWidth.setCellValueFactory(new PropertyValueFactory<Extruder, Integer>("extruderWidth"));

		extruderLength = new TableColumn<>("Hosszuság");
		extruderLength.setMinWidth(80);
		extruderLength.setCellValueFactory(new PropertyValueFactory<Extruder, Integer>("extruderLength"));

		extruderThickness = new TableColumn<>("Vastagság");
		extruderThickness.setMinWidth(70);
		extruderThickness.setCellValueFactory(new PropertyValueFactory<Extruder, Double>("extruderThickness"));

		extruderFlatPlateBag = new TableColumn<>("Zsák2/Síklap1");
		extruderFlatPlateBag.setMinWidth(80);
		extruderFlatPlateBag.setCellValueFactory(new PropertyValueFactory<Extruder, Integer>("extruderFlatPlateBag"));

		extruderGrammMeter = new TableColumn<>("g/m");
		extruderGrammMeter.setMinWidth(80);
		extruderGrammMeter.setCellValueFactory(new PropertyValueFactory<Extruder, Double>("extruderGrammMeter"));

		extruderOrderedKg = new TableColumn<>("Megrendelt kg");
		extruderOrderedKg.setMinWidth(100);
		extruderOrderedKg.setCellValueFactory(new PropertyValueFactory<Extruder, Double>("extruderOrderedKg"));

		extruderActualKg = new TableColumn<>("kg");
		extruderActualKg.setMinWidth(80);

		extruderComment = new TableColumn<>("Megjegyzés");
		extruderComment.setMinWidth(360);
		extruderComment.setCellValueFactory(new PropertyValueFactory<Extruder, String>("extruderComment"));

	}

	private ObservableList<Extruder> errorDataClient(String name) {
		dataExtruder.clear();
		dataExtruder.addAll(tableDataBase.getAllExtruder(name));
		return dataExtruder;

	}

	private void actualJobsPane() {
		extruderNewJobsPane.setVisible(false);
		extruderActualJobsPane.setVisible(true);
	}

	private void buttonOnAction() {
		extruderNameBtn1.setOnAction((event) -> {
			actualJobsPane();
			extruderTableView.setItems(errorDataClient(extruderNameBtn1.getText()));
		});
		extruderNameBtn2.setOnAction((event) -> {
			actualJobsPane();
			extruderTableView.setItems(errorDataClient(extruderNameBtn2.getText()));
		});
		extruderNameBtn3.setOnAction((event) -> {
			actualJobsPane();
			extruderTableView.setItems(errorDataClient(extruderNameBtn3.getText()));
		});
		extruderNameBtn4.setOnAction((event) -> {
			actualJobsPane();
			extruderTableView.setItems(errorDataClient(extruderNameBtn4.getText()));
		});
		extruderNameBtn5.setOnAction((event) -> {
			actualJobsPane();
			extruderTableView.setItems(errorDataClient(extruderNameBtn5.getText()));
		});
		extruderNameBtn6.setOnAction((event) -> {
			actualJobsPane();
			extruderTableView.setItems(errorDataClient(extruderNameBtn6.getText()));
		});
		extruderNameBtn7.setOnAction((event) -> {
			actualJobsPane();
			extruderTableView.setItems(errorDataClient(extruderNameBtn7.getText()));
		});
		extruderNameBtn8.setOnAction((event) -> {
			actualJobsPane();
			extruderTableView.setItems(errorDataClient(extruderNameBtn8.getText()));
		});
		extruderNameBtn9.setOnAction((event) -> {
			actualJobsPane();
			extruderTableView.setItems(errorDataClient(extruderNameBtn9.getText()));
		});
		extruderNameBtn10.setOnAction((event) -> {
			actualJobsPane();
			extruderTableView.setItems(errorDataClient(extruderNameBtn10.getText()));
		});
		extruderNameBtn11.setOnAction((event) -> {
			actualJobsPane();
			extruderTableView.setItems(errorDataClient(extruderNameBtn11.getText()));
		});
		extruderNameBtn12.setOnAction((event) -> {
			actualJobsPane();
			extruderTableView.setItems(errorDataClient(extruderNameBtn12.getText()));
		});
		extruderNameBtn13.setOnAction((event) -> {
			actualJobsPane();
			extruderTableView.setItems(errorDataClient(extruderNameBtn13.getText()));
		});
		extruderNameBtn14.setOnAction((event) -> {
			actualJobsPane();
			extruderTableView.setItems(errorDataClient(extruderNameBtn14.getText()));
		});
		extruderNameAllBtn.setOnAction((event) -> {
			actualJobsPane();
			extruderTableView.setItems(errorDataClient(""));
		});
	}
}
