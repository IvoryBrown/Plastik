package com.production.transmissionfinished.extruder.controller;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import com.production.transmissionfinished.extruder.database.TransmissionExtruderDataBase;
import com.production.transmissionfinished.extruder.pojo.Transmission;
import com.production.transmissionfinished.extruder.pojo.TransmissionFinished;
import com.project.setting.worker.database.WorkersDataBase;
import com.project.setting.worker.pojo.Workers;
import com.setting.label.MessageLabel;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class TransmissionFinishedController implements Initializable {
	@FXML
	private TableView<TransmissionFinished> transmissionFinishedTableView;
	private TableColumn<TransmissionFinished, Integer> transmissionId, extruderId;
	private TableColumn<TransmissionFinished, String> transmissionExtruderIdentification, transmissionExtruderName,
			transmissionWorkerName, transmissionClientName, transmissionExtruderActualSize, transmissionBKg,
			transmissionNKg, transmissionSpool;
	private TableColumn<TransmissionFinished, Date> transmissionDate;
	@FXML
	private Label orderKgLbl, actualKgLbl, workerNameLbl, messageLbl;
	@FXML
	private TextField workerNameTxt;
	@FXML
	private TextArea transmissionTxt;

	private TransmissionExtruderDataBase transmissionExtruderDataBase = new TransmissionExtruderDataBase();
	private final ObservableList<TransmissionFinished> dataTransmission = FXCollections.observableArrayList();

	private final ObservableList<Workers> dataWorkers = FXCollections.observableArrayList();
	private WorkersDataBase workersDB = new WorkersDataBase();

	private ObservableList<TransmissionFinished> transmissionFinishedData() {
		dataTransmission.clear();
		dataTransmission
				.addAll(transmissionExtruderDataBase.getAllTransmision(Integer.valueOf(Transmission.getExtruderId())));
		return dataTransmission;

	}

	private ObservableList<Workers> workersData() {
		dataWorkers.clear();
		dataWorkers.addAll(workersDB.searchAllWorkers(workerNameTxt.getText()));
		return dataWorkers;

	}

	private void clearTable() {
		transmissionFinishedTableView.getItems().clear();
		transmissionFinishedTableView.getColumns().clear();

	}

	@SuppressWarnings("unchecked")
	private void setColumn() {
		transmissionFinishedTableView.getColumns().addAll(transmissionId, transmissionExtruderIdentification,
				transmissionBKg, transmissionNKg, transmissionSpool, transmissionExtruderName, transmissionDate,
				transmissionWorkerName, transmissionClientName, transmissionExtruderActualSize, extruderId);
	}

	private void extruderTable() {
		transmissionId = new TableColumn<>("ID");
		transmissionId.setMinWidth(50);
		transmissionId.setCellValueFactory(new PropertyValueFactory<TransmissionFinished, Integer>("transmissionId"));

		extruderId = new TableColumn<>("ExID");
		extruderId.setMinWidth(50);
		extruderId.setCellValueFactory(new PropertyValueFactory<TransmissionFinished, Integer>("extruderId"));

		transmissionExtruderIdentification = new TableColumn<>("Azonosító");
		transmissionExtruderIdentification.setMinWidth(50);
		transmissionExtruderIdentification.setCellValueFactory(
				new PropertyValueFactory<TransmissionFinished, String>("transmissionExtruderIdentification"));

		transmissionExtruderName = new TableColumn<>("Gyártó gép");
		transmissionExtruderName.setMinWidth(50);
		transmissionExtruderName.setCellValueFactory(
				new PropertyValueFactory<TransmissionFinished, String>("transmissionExtruderName"));

		transmissionDate = new TableColumn<>("Gyártás dátum");
		transmissionDate.setMinWidth(50);
		transmissionDate.setCellValueFactory(new PropertyValueFactory<TransmissionFinished, Date>("transmissionDate"));

		transmissionWorkerName = new TableColumn<>("Átadó neve");
		transmissionWorkerName.setMinWidth(50);
		transmissionWorkerName
				.setCellValueFactory(new PropertyValueFactory<TransmissionFinished, String>("transmissionWorkerName"));

		transmissionClientName = new TableColumn<>("Megrendelő");
		transmissionClientName.setMinWidth(50);
		transmissionClientName
				.setCellValueFactory(new PropertyValueFactory<TransmissionFinished, String>("transmissionClientName"));

		transmissionExtruderActualSize = new TableColumn<>("Termék");
		transmissionExtruderActualSize.setMinWidth(50);
		transmissionExtruderActualSize.setCellValueFactory(
				new PropertyValueFactory<TransmissionFinished, String>("transmissionExtruderActualSize"));

		transmissionBKg = new TableColumn<>("Bruttó tömeg");
		transmissionBKg.setMinWidth(50);
		transmissionBKg.setCellValueFactory(new PropertyValueFactory<TransmissionFinished, String>("transmissionBKg"));

		transmissionNKg = new TableColumn<>("Nettó tömeg");
		transmissionNKg.setMinWidth(50);
		transmissionNKg.setCellValueFactory(new PropertyValueFactory<TransmissionFinished, String>("transmissionNKg"));

		transmissionSpool = new TableColumn<>("Cséve szám");
		transmissionSpool.setMinWidth(50);
		transmissionSpool
				.setCellValueFactory(new PropertyValueFactory<TransmissionFinished, String>("transmissionSpool"));
	}

	public void setQuantityNumber(TextField textField, Label label) {

		textField.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					char ch = textField.getText().charAt(oldValue.intValue());
					if (!(ch >= '0' && ch <= '9')) {
						textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
						new MessageLabel().errorMessage("Nem megfelelő formátum!", label);
					}
				}
			}

		});
	}

	private void setData() {
		workerNameLbl.setText("Dolgozó kód:");
		setQuantityNumber(workerNameTxt, messageLbl);
		workerNameTxt.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(final ObservableValue<? extends String> ov, final String oldValue,
					final String newValue) {
				if (workerNameTxt.getText().length() >= 7) {
					workerNameTxt.setText(workerNameTxt.getText().substring(0, 7));
					workersData();
					if (workersData().size() != 0) {
						if (workersData().get(0).getWorkersStatus().equals("Aktív")) {
							transmissionTxt.appendText("Dolgozó: " + workersData().get(0).getWorkersName() + "\n");
							workerNameTxt.setEditable(false);
							messageLbl.setText("");
						} else {
							new MessageLabel().errorMessage("Nem aktív a dolgozó", messageLbl);
						}
					} else {
						new MessageLabel().errorMessage("Nincs ilyen dolgozó", messageLbl);
					}
				}
			}
		});

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		extruderTable();
		setColumn();
		transmissionFinishedData();
		transmissionFinishedTableView.setItems(dataTransmission);
		orderKgLbl.setText(" / " + Transmission.getExtruderorderKg() + "kg");
		actualKgLbl.setText("->" + Transmission.getExtruderActualKg() + "kg");
		setData();
	}

}
