package com.project.setting.worker.controller;

import com.project.setting.worker.database.WorkersDataBase;
import com.project.setting.worker.pojo.Workers;
import com.setting.label.MessageLabel;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class WorkersController {
	private WorkersDataBase workersDataBase = new WorkersDataBase();
	private TextField workersName, workersNumber, workersFilteringTxt;
	private Label messageLbl;
	private Button workersFilteringBtn, workersSave;
	private TableView<Workers> workersTableView;
	private TableColumn<Workers, Integer> workersIdColumn;
	private TableColumn<Workers, String> workersNameColumn, workersPasswordColumn, workersStatusColumn;
	private final ObservableList<Workers> dataWorkers = FXCollections.observableArrayList();
	private MessageLabel message = new MessageLabel();

	public WorkersController(TextField workersName, TextField workersNumber, Label messageLbl,
			TableView<Workers> workersTableView, TextField workersFilteringTxt, Button workersFilteringBtn,
			Button workersSave) {
		this.workersName = workersName;
		this.workersNumber = workersNumber;
		this.messageLbl = messageLbl;
		this.workersFilteringBtn = workersFilteringBtn;
		this.workersFilteringTxt = workersFilteringTxt;
		this.workersTableView = workersTableView;
		this.workersSave = workersSave;
		this.clearData();
		this.workersTabel();
		this.btnEventhWorkers();
	}

	private boolean checkTextField() {
		if (workersName.getText().trim().isEmpty()) {
			workersName.setStyle(" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;");
		} else {
			workersName.setStyle(null);
		}
		if (workersNumber.getText().trim().isEmpty()) {
			workersNumber.setStyle(" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;");
		} else {
			workersNumber.setStyle(null);
		}
		if (workersName.getText().trim().isEmpty() || workersNumber.getText().trim().isEmpty()) {
			return false;
		} else {
			return true;
		}

	}

	private void clearData() {
		workersTableView.getItems().clear();
		workersTableView.getColumns().clear();
	}

	private void saveWorkers() {
		if (checkTextField()) {
			workersDataBase.addWorker(new Workers(workersName.getText(), workersNumber.getText(), "Aktív"));
			clearTextField();
			errorDataWorkers();
			new MessageLabel().goodMessage("Sikeres mentés", messageLbl);
		} else {
			new MessageLabel().errorMessage("Sikertelen mentés", messageLbl);
		}

	}

	private void clearTextField() {
		workersName.clear();
		workersNumber.clear();
	}

	private void btnEventhWorkers() {
		workersFilteringTxt.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.ENTER)) {
					searchClient();
				}
			}
		});
		workersFilteringBtn.setOnAction((event) -> {
			searchClient();
		});
		workersSave.setOnAction((event) -> {
			saveWorkers();
		});

	}

	private void searchClient() {
		dataWorkers.clear();
		dataWorkers.addAll(workersDataBase.searchAllWorkers(workersFilteringTxt.getText()));
		if (dataWorkers.size() != 0) {
			message.goodMessage("Sikeres keresés: " + dataWorkers.size() + " találat", messageLbl);
		} else {
			message.errorMessage("Sikertelen keresés: " + dataWorkers.size() + " találat", messageLbl);
		}
		if (workersFilteringTxt.getText().trim().isEmpty()) {
			messageLbl.setText("");
		}
	}

	@SuppressWarnings("unchecked")
	private void workersTabel() {
		workersIdColumn = new TableColumn<>("ID");
		workersIdColumn.setMinWidth(50);
		workersIdColumn.setCellValueFactory(new PropertyValueFactory<Workers, Integer>("workersId"));

		workersNameColumn = new TableColumn<>("Név");
		workersNameColumn.setMinWidth(250);
		workersNameColumn.setCellValueFactory(new PropertyValueFactory<Workers, String>("workersName"));

		workersPasswordColumn = new TableColumn<>("Azonosító");
		workersPasswordColumn.setMinWidth(150);
		workersPasswordColumn.setCellValueFactory(new PropertyValueFactory<Workers, String>("workersPassword"));

		workersStatusColumn = new TableColumn<>("Státusz");
		workersStatusColumn.setMinWidth(150);
		workersStatusColumn.setCellValueFactory(i -> {
			final String value = i.getValue().getWorkersStatus();
			return Bindings.createObjectBinding(() -> value);
		});
		workersStatusColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		workersStatusColumn.setCellFactory(ComboBoxTableCell.forTableColumn("Aktív","Inaktív"));

		workersTableView.setItems(dataWorkers);
		workersTableView.getColumns().addAll(workersIdColumn, workersNameColumn, workersPasswordColumn,
				workersStatusColumn);
		dataWorkers.addAll(workersDataBase.searchAllWorkers(workersFilteringTxt.getText()));
	}

	private ObservableList<Workers> errorDataWorkers() {
		dataWorkers.clear();
		dataWorkers.addAll(workersDataBase.searchAllWorkers(workersFilteringTxt.getText()));
		return dataWorkers;

	}
}
