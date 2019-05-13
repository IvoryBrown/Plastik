package com.office.transmission.controller;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import com.office.extruder.pojo.Transmission;
import com.office.transmission.database.TransmissionDataBase;
import com.office.transmission.pojo.TransmissionFinished;
import com.setting.label.MessageLabel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.StageStyle;
import javafx.util.Callback;

public class TransmissionController implements Initializable {
	@FXML
	private TableView<TransmissionFinished> transmissionTableView;
	private TableColumn<TransmissionFinished, Integer> transmissionId, extruderId;
	private TableColumn<TransmissionFinished, String> transmissionExtruderIdentification, transmissionIdentification,
			transmissionExtruderName, transmissionWorkerName, transmissionClientName, transmissionExtruderActualSize,
			transmissionBKg, transmissionNKg, transmissionSpool, removeCol;
	private TableColumn<TransmissionFinished, Date> transmissionDate;
	private TransmissionDataBase transmissionExtruderDataBase = new TransmissionDataBase();
	private final ObservableList<TransmissionFinished> dataTransmission = FXCollections.observableArrayList();
	@FXML
	private Label message;

	// table up
	private ObservableList<TransmissionFinished> transmissionFinishedData() {
		dataTransmission.clear();
		dataTransmission
				.addAll(transmissionExtruderDataBase.getAllTransmision(Integer.valueOf(Transmission.getExtruderId())));
		return dataTransmission;

	}

	@SuppressWarnings("unchecked")
	private void setColumn() {
		transmissionTableView.getColumns().addAll(transmissionId, transmissionIdentification,
				transmissionExtruderIdentification, transmissionBKg, transmissionNKg, transmissionSpool,
				transmissionExtruderName, transmissionDate, transmissionWorkerName, transmissionClientName,
				transmissionExtruderActualSize, extruderId, removeCol);
	}

	private void extruderTable() {
		transmissionId = new TableColumn<>("ID");
		transmissionId.setMinWidth(50);
		transmissionId.setCellValueFactory(new PropertyValueFactory<TransmissionFinished, Integer>("transmissionId"));

		extruderId = new TableColumn<>("ExID");
		extruderId.setMinWidth(50);
		extruderId.setCellValueFactory(new PropertyValueFactory<TransmissionFinished, Integer>("extruderId"));

		transmissionIdentification = new TableColumn<>("Leadás ID");
		transmissionIdentification.setMinWidth(50);
		transmissionIdentification.setCellValueFactory(
				new PropertyValueFactory<TransmissionFinished, String>("transmissionIdentification"));

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

		removeCol = new TableColumn<TransmissionFinished, String>("Törlés");

		Callback<TableColumn<TransmissionFinished, String>, TableCell<TransmissionFinished, String>> cellFactory = new Callback<TableColumn<TransmissionFinished, String>, TableCell<TransmissionFinished, String>>() {
			@Override
			public TableCell<TransmissionFinished, String> call(final TableColumn<TransmissionFinished, String> param) {
				final TableCell<TransmissionFinished, String> cell = new TableCell<TransmissionFinished, String>() {
					final Button btn = new Button();

					@Override
					public void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						btn.getStylesheets().add("/com/main/view/css/button.css");
						btn.getStyleClass().add("deleteButton");
						btn.setMinSize(40, 25);
						if (empty) {
							setGraphic(null);
							setText(null);
						} else {
							btn.setOnAction((ActionEvent event) -> {
								Alert alert = new Alert(Alert.AlertType.NONE, "Biztos törölni szeretnéd?",
										ButtonType.YES, ButtonType.NO);
								alert.getDialogPane().getStylesheets().add("/com/setting/showinfo/ShowInfo.css");
								alert.initStyle(StageStyle.TRANSPARENT);
								if (alert.showAndWait().orElse(ButtonType.NO) == ButtonType.YES) {
									TransmissionFinished transmissionFinished = getTableView().getItems()
											.get(getIndex());
									transmissionExtruderDataBase.removeTransmissionFinished(transmissionFinished);
									transmissionFinishedData();
									new MessageLabel().goodMessage("Sikeres törlés", message);
								}
							});
							setGraphic(btn);
							setText(null);
						}
					}
				};
				return cell;
			}
		};

		removeCol.setCellFactory(cellFactory);

		// font color
		transmissionTableView.setRowFactory(ts -> new TableRow<TransmissionFinished>() {
			@Override
			public void updateItem(TransmissionFinished item, boolean empty) {
				super.updateItem(item, empty);

				if (item == null) {
					setStyle("");
				} else {
					setStyle("");

					setStyle("-fx-text-background-color: whitesmoke;");

				}
			}
		});

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		extruderTable();
		setColumn();
		transmissionFinishedData();
		transmissionTableView.setItems(dataTransmission);
	}

}
