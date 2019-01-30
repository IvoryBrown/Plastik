package com.project.setting.machine.controller;

import com.project.setting.machine.database.MachineDataBase;
import com.project.setting.machine.pojo.Machine;
import com.setting.label.MessageLabel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class MachineController {
	private Label messageLbl;
	private TableView<Machine> machineTableView;
	private TableColumn<Machine, String> machineNAmeColumn;
	private MachineDataBase machineDataBase = new MachineDataBase();
	private final ObservableList<Machine> dataMachine = FXCollections.observableArrayList();

	public MachineController(TableView<Machine> machineTableView, Label messageLbl) {
		this.machineTableView = machineTableView;
		this.messageLbl = messageLbl;
		clearData();
		setTable();
	}

	private void clearData() {
		machineTableView.getItems().clear();
		machineTableView.getColumns().clear();
		dataMachine.clear();
	}

	@SuppressWarnings("unchecked")
	private void setTable() {
		machineNAmeColumn = new TableColumn<Machine, String>("Név");
		machineNAmeColumn.setMinWidth(198);
		machineNAmeColumn.setCellValueFactory(new PropertyValueFactory<Machine, String>("machineName"));
		machineNAmeColumn.setCellFactory(TextFieldTableCell.forTableColumn());

		machineNAmeColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Machine, String>>() {
			@Override
			public void handle(TableColumn.CellEditEvent<Machine, String> d) {
				Machine actualClient = (Machine) d.getTableView().getItems().get(d.getTablePosition().getRow());
				if (!d.getNewValue().trim().isEmpty()) {
					actualClient.setMachineName(d.getNewValue());
					machineDataBase.updateMachine(actualClient);
					new MessageLabel().goodMessage("Sikeres mentés!", messageLbl);
				} else {
					errorDataClient();
					new MessageLabel().errorMessage("Sikertelen mentés!", messageLbl);
				}

			}
		});

		machineTableView.setItems(dataMachine);
		machineTableView.getColumns().addAll(machineNAmeColumn);
		dataMachine.addAll(machineDataBase.getAllMachine());
	}
	
	private ObservableList<Machine> errorDataClient() {
		dataMachine.clear();
		dataMachine.addAll(machineDataBase.getAllMachine());
		return dataMachine;

	}
}
