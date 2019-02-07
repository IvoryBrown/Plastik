package com.project.setting.commodityname.controller;

import com.project.setting.commodityname.database.CommodityNameDataBase;
import com.project.setting.commodityname.pojo.CommodityName;
import com.setting.label.MessageLabel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class CommodityNameController {
	private TextField commodityNameTxt;
	private Button commodityNameBtn;
	private Label messageLbl;
	private TableView<CommodityName> commodityNameTableView;
	private TableColumn<CommodityName, String> commodityName;
	private CommodityNameDataBase commodityNameDataBase = new CommodityNameDataBase();
	private final ObservableList<CommodityName> dataCommodityName = FXCollections.observableArrayList();

	public CommodityNameController(TextField commodityNameTxt, Button commodityNameBtn, Label messageLbl,
			TableView<CommodityName> commodityNameTableView) {
		this.commodityNameTxt = commodityNameTxt;
		this.commodityNameBtn = commodityNameBtn;
		this.messageLbl = messageLbl;
		this.commodityNameTableView = commodityNameTableView;
		setOnAction();
		clearData();
		setTabel();
	}
	
	private void clearData() {
		commodityNameTableView.getItems().clear();
		commodityNameTableView.getColumns().clear();

	}

	private boolean checkTexfield() {
		if (commodityNameTxt.getText().trim().isEmpty()) {
			commodityNameTxt.setStyle(" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;");

		} else {
			commodityNameTxt.setStyle(null);
		}
		if (commodityNameTxt.getText().trim().isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	private void setOnAction() {
		commodityNameBtn.setOnAction((event) -> {
			addCommodityName();
		});

		commodityNameTxt.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.ENTER)) {
					addCommodityName();
				}
			}
		});

	}

	private void addCommodityName() {
		if (checkTexfield()) {
			commodityNameDataBase.addCommodityName(new CommodityName(commodityNameTxt.getText()));
			commodityNameTxt.clear();
			errorDataCommodityName();
			new MessageLabel().goodMessage("Sikeres mentés", messageLbl);
		} else {
			new MessageLabel().errorMessage("Sikertelen mentés", messageLbl);
		}

	}

	@SuppressWarnings("unchecked")
	private void setTabel() {

		commodityName = new TableColumn<>("Név");
		commodityName.setMinWidth(290);
		commodityName.setCellValueFactory(new PropertyValueFactory<CommodityName, String>("commodityName"));
		commodityName.setCellFactory(TextFieldTableCell.forTableColumn());
		commodityName.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<CommodityName, String>>() {
			@Override
			public void handle(TableColumn.CellEditEvent<CommodityName, String> d) {
				CommodityName actualClient = (CommodityName) d.getTableView().getItems()
						.get(d.getTablePosition().getRow());
				if (!d.getNewValue().trim().isEmpty()) {
					actualClient.setCommodityName(d.getNewValue());
					new MessageLabel().goodMessage("Név sikeres frissitése", messageLbl);
					commodityNameDataBase.updateCommodityName(actualClient);
				} else {
					errorDataCommodityName();
					new MessageLabel().errorMessage("Üres a mező", messageLbl);
				}

			}
		});

		commodityNameTableView.setItems(dataCommodityName);
		commodityNameTableView.getColumns().addAll(commodityName);
		dataCommodityName.addAll(commodityNameDataBase.getAllCommodityName());
	}

	private ObservableList<CommodityName> errorDataCommodityName() {
		dataCommodityName.clear();
		dataCommodityName.addAll(commodityNameDataBase.getAllCommodityName());
		return dataCommodityName;

	}
}
