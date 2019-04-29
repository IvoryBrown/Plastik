package com.manufacture.extruder.controller;

import java.util.Date;

import com.kliens.message.main.MessageMain;
import com.kliens.message.pojo.Kliens;
import com.manufacture.extruder.name.ExtruderName;
import com.manufacture.extruder.pojo.Extruder;
import com.manufacture.extruder.table.database.TableDataBase;
import com.setting.file.DBFileWriter;

import javafx.application.Platform;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Control;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.util.Callback;

public class TableController {
	private TableView<Extruder> extruderTableView;
	private TableColumn<Extruder, Date> extruderEndDate;
	private TableColumn<Extruder, String> extruderClientName, extruderIdentification, extruderCommodity,
			extruderActualSize, extruderOrderedKg, extruderActualKg, extruderComment;
	private TableColumn<Extruder, Integer> extruderFlatPlateBag, extruderWidth, extruderLength;
	private TableColumn<Extruder, Double> extruderThickness;
	private TableColumn<Extruder, Boolean> colActive;
	private ToggleButton extruderNameBtn1, extruderNameBtn2, extruderNameBtn3, extruderNameBtn4, extruderNameBtn5,
			extruderNameBtn6, extruderNameBtn7, extruderNameBtn8, extruderNameBtn9, extruderNameBtn10,
			extruderNameBtn11, extruderNameBtn12, extruderNameBtn13, extruderNameBtn14;
	private ToggleGroup group = new ToggleGroup();
	private HBox hBox;
	private final ObservableList<Extruder> dataExtruder = FXCollections.observableArrayList();

	private TableDataBase tableDataBase = new TableDataBase();
	int sum ;

	public TableController(TableView<Extruder> extruderTableView, HBox hBox) {
		this.extruderTableView = extruderTableView;
		this.hBox = hBox;
		clearTable();
		extruderTable();
		setColumn();
		setToggleButton();
		buttonOnAction();
		startTask();
	}

	private void startTask() {
		// Create a Runnable
		Runnable task = new Runnable() {
			public void run() {
				runTask();
				
			}
		};

		// Run the task in a background thread
		Thread backgroundThread = new Thread(task);
		// Terminate the running thread if the application exits
		backgroundThread.setDaemon(true);
		// Start the thread
		backgroundThread.start();
	}

	private void runTask() {

		try {

			while (true) {

				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						updateDataTable();
						Kliens.message();
						checkKlientName();
						sum++;
						System.out.println(sum);
					}
				});

				 Thread.sleep(300000); 
			
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private void checkKlientName() {
		if (DBFileWriter.outputKliensName().equals("kliens_1")) {
			if (Kliens.message().get(0).getKliens1()) {
				if (Kliens.isSet()) {
					Kliens.setFalse();
					new MessageMain().start();
					return;
				}
			}
		}
		if (DBFileWriter.outputKliensName().equals("kliens_2")) {
			if (Kliens.message().get(0).getKliens2()) {
				if (Kliens.isSet()) {
					Kliens.setFalse();
					new MessageMain().start();
					return;
				}
			}
		}
		if (DBFileWriter.outputKliensName().equals("kliens_3")) {
			if (Kliens.message().get(0).getKliens3()) {
				if (Kliens.isSet()) {
					Kliens.setFalse();
					new MessageMain().start();
					return;
				}
			}
		}
		if (DBFileWriter.outputKliensName().equals("kliens_4")) {
			if (Kliens.message().get(0).getKliens4()) {
				if (Kliens.isSet()) {
					Kliens.setFalse();
					new MessageMain().start();
					return;
				}
			}
		}
		if (DBFileWriter.outputKliensName().equals("kliens_5")) {
			if (Kliens.message().get(0).getKliens5()) {
				if (Kliens.isSet()) {
					Kliens.setFalse();
					new MessageMain().start();
					return;
				}
			}
		}
		if (DBFileWriter.outputKliensName().equals("kliens_6")) {
			if (Kliens.message().get(0).getKliens6()) {
				if (Kliens.isSet()) {
					Kliens.setFalse();
					new MessageMain().start();
					return;
				}
			}
		}
		if (DBFileWriter.outputKliensName().equals("kliens_7")) {
			if (Kliens.message().get(0).getKliens7()) {
				if (Kliens.isSet()) {
					Kliens.setFalse();
					new MessageMain().start();
					return;
				}
			}
		}
		if (DBFileWriter.outputKliensName().equals("kliens_8")) {
			if (Kliens.message().get(0).getKliens8()) {
				if (Kliens.isSet()) {
					Kliens.setFalse();
					new MessageMain().start();
					return;
				}
			}
		}
		if (DBFileWriter.outputKliensName().equals("kliens_9")) {
			if (Kliens.message().get(0).getKliens9()) {
				if (Kliens.isSet()) {
					Kliens.setFalse();
					new MessageMain().start();
					return;
				}
			}
		}
		if (DBFileWriter.outputKliensName().equals("kliens_10")) {
			if (Kliens.message().get(0).getKliens10()) {
				if (Kliens.isSet()) {
					Kliens.setFalse();
					new MessageMain().start();
					return;
				}
			}
		}

	}

	private void setToggleButton() {
		extruderNameBtn1 = new ToggleButton();
		extruderNameBtn2 = new ToggleButton();
		extruderNameBtn3 = new ToggleButton();
		extruderNameBtn4 = new ToggleButton();
		extruderNameBtn5 = new ToggleButton();
		extruderNameBtn6 = new ToggleButton();
		extruderNameBtn7 = new ToggleButton();
		extruderNameBtn8 = new ToggleButton();
		extruderNameBtn9 = new ToggleButton();
		extruderNameBtn10 = new ToggleButton();
		extruderNameBtn11 = new ToggleButton();
		extruderNameBtn12 = new ToggleButton();
		extruderNameBtn13 = new ToggleButton();
		extruderNameBtn14 = new ToggleButton();
		new ExtruderName(extruderNameBtn1, extruderNameBtn2, extruderNameBtn3, extruderNameBtn4, extruderNameBtn5,
				extruderNameBtn6, extruderNameBtn7, extruderNameBtn8, extruderNameBtn9, extruderNameBtn10,
				extruderNameBtn11, extruderNameBtn12, extruderNameBtn13, extruderNameBtn14);
		extruderNameBtn1.setToggleGroup(group);
		extruderNameBtn2.setToggleGroup(group);
		extruderNameBtn3.setToggleGroup(group);
		extruderNameBtn4.setToggleGroup(group);
		extruderNameBtn5.setToggleGroup(group);
		extruderNameBtn6.setToggleGroup(group);
		extruderNameBtn7.setToggleGroup(group);
		extruderNameBtn8.setToggleGroup(group);
		extruderNameBtn9.setToggleGroup(group);
		extruderNameBtn10.setToggleGroup(group);
		extruderNameBtn11.setToggleGroup(group);
		extruderNameBtn12.setToggleGroup(group);
		extruderNameBtn13.setToggleGroup(group);
		extruderNameBtn14.setToggleGroup(group);
		hBox.getChildren().addAll(extruderNameBtn1, extruderNameBtn2, extruderNameBtn3, extruderNameBtn4,
				extruderNameBtn5, extruderNameBtn6, extruderNameBtn7, extruderNameBtn8, extruderNameBtn9,
				extruderNameBtn10, extruderNameBtn11, extruderNameBtn12, extruderNameBtn13, extruderNameBtn14);

	}

	private void clearTable() {
		extruderTableView.getItems().clear();
		extruderTableView.getColumns().clear();

	}

	@SuppressWarnings("unchecked")
	private void setColumn() {
		extruderTableView.getColumns().addAll(extruderComment, extruderIdentification, extruderActualSize,
				extruderWidth, extruderLength, extruderThickness, extruderFlatPlateBag, extruderOrderedKg,
				extruderActualKg, extruderEndDate, extruderClientName, extruderCommodity, colActive);
	}

	private void extruderTable() {

		colActive = new TableColumn<>("");
		colActive.setSortable(false);
		colActive.setMinWidth(150);
		colActive.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<Extruder, Boolean>, ObservableValue<Boolean>>() {
					@Override
					public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Extruder, Boolean> p) {
						return new SimpleBooleanProperty(p.getValue() != null);
					}
				});

		colActive.setCellFactory(new Callback<TableColumn<Extruder, Boolean>, TableCell<Extruder, Boolean>>() {
			@Override
			public TableCell<Extruder, Boolean> call(TableColumn<Extruder, Boolean> p) {
				return new CalculationButtonCell(extruderTableView);
			}
		});

		extruderClientName = new TableColumn<>("Megrendelő");
		extruderClientName.setMinWidth(150);
		extruderClientName.setCellValueFactory(new PropertyValueFactory<Extruder, String>("extruderClientName"));

		extruderIdentification = new TableColumn<>("Azonosító");
		extruderIdentification.setMinWidth(120);
		extruderIdentification
				.setCellValueFactory(new PropertyValueFactory<Extruder, String>("extruderIdentification"));
		extruderIdentification.setCellFactory(TextFieldTableCell.forTableColumn());
		extruderIdentification.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Extruder, String>>() {
			@Override
			public void handle(TableColumn.CellEditEvent<Extruder, String> d) {
				extruderTableView.refresh();
			}
		});

		extruderEndDate = new TableColumn<>("Határidő");
		extruderEndDate.setMinWidth(100);
		extruderEndDate.setCellValueFactory(new PropertyValueFactory<Extruder, Date>("extruderEndDate"));

		extruderCommodity = new TableColumn<>("Alapanyag");
		extruderCommodity.setMinWidth(120);
		extruderCommodity.setCellValueFactory(new PropertyValueFactory<Extruder, String>("extruderCommodity"));

		extruderActualSize = new TableColumn<>("Aktuális méret");
		extruderActualSize.setMinWidth(190);
		extruderActualSize.setCellValueFactory(new PropertyValueFactory<Extruder, String>("extruderActualSize"));

		extruderWidth = new TableColumn<>("Szélesség");
		extruderWidth.setMinWidth(80);
		extruderWidth.setCellValueFactory(new PropertyValueFactory<Extruder, Integer>("extruderWidth"));

		extruderLength = new TableColumn<>("Hosszuság");
		extruderLength.setMinWidth(100);
		extruderLength.setCellValueFactory(new PropertyValueFactory<Extruder, Integer>("extruderLength"));

		extruderThickness = new TableColumn<>("Vastagság");
		extruderThickness.setMinWidth(90);
		extruderThickness.setCellValueFactory(new PropertyValueFactory<Extruder, Double>("extruderThickness"));

		extruderFlatPlateBag = new TableColumn<>("Zsák2/Síklap1");
		extruderFlatPlateBag.setMinWidth(120);
		extruderFlatPlateBag.setCellValueFactory(new PropertyValueFactory<Extruder, Integer>("extruderFlatPlateBag"));

		extruderOrderedKg = new TableColumn<>("Megrendelt/kg");
		extruderOrderedKg.setMinWidth(150);
		extruderOrderedKg.setCellValueFactory(new PropertyValueFactory<Extruder, String>("extruderOrderedKg"));

		extruderActualKg = new TableColumn<>("Lefújva/kg");
		extruderActualKg.setMinWidth(100);
		extruderActualKg.setCellValueFactory(new PropertyValueFactory<Extruder, String>("extruderActualKg"));

		extruderComment = new TableColumn<>("Megjegyzés");
		extruderComment.setMinWidth(260);
		extruderComment.setCellValueFactory(new PropertyValueFactory<Extruder, String>("extruderComment"));
		extruderComment.setCellFactory(new Callback<TableColumn<Extruder, String>, TableCell<Extruder, String>>() {

			@Override
			public TableCell<Extruder, String> call(TableColumn<Extruder, String> param) {
				TableCell<Extruder, String> cell = new TableCell<>();
				Text text = new Text();
				cell.setGraphic(text);
				cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
				text.wrappingWidthProperty().bind(cell.widthProperty());
				text.textProperty().bind(cell.itemProperty());
				text.setStyle("-fx-fill: red; -fx-font-weight: bold;");
				return cell;
			}

		});

		extruderTableView.setRowFactory(ts -> new TableRow<Extruder>() {
			@Override
			public void updateItem(Extruder item, boolean empty) {
				super.updateItem(item, empty);

				if (item == null) {
					setStyle("");
				} else {
					setStyle("");
					double s = Double.parseDouble(item.getExtruderActualKg());
					double g = Double.parseDouble(item.getExtruderOrderedKg());
					double j = g-s;
					if (s >= g) {
						setStyle("-fx-text-background-color: #00FF00;");
					}
					else if(j<=100) {
						setStyle("-fx-text-background-color: #FFD700;");
						
					} else {
						setStyle("-fx-text-background-color: whitesmoke;");

					}

				}
			}
		});
	}

	private ObservableList<Extruder> extruderData(String extruderName) {
		dataExtruder.clear();
		dataExtruder.addAll(tableDataBase.getAllExtruder(extruderName, "", true));
		return dataExtruder;

	}

	private void updateDataTable() {

		if (extruderNameBtn1.isSelected()) {
			extruderTableView.setItems(extruderData(extruderNameBtn1.getText()));
		}
		if (extruderNameBtn2.isSelected()) {
			extruderTableView.setItems(extruderData(extruderNameBtn2.getText()));
		}
		if (extruderNameBtn3.isSelected()) {
			extruderTableView.setItems(extruderData(extruderNameBtn3.getText()));
		}
		if (extruderNameBtn4.isSelected()) {
			extruderTableView.setItems(extruderData(extruderNameBtn4.getText()));
		}
		if (extruderNameBtn5.isSelected()) {
			extruderTableView.setItems(extruderData(extruderNameBtn5.getText()));
		}
		if (extruderNameBtn6.isSelected()) {
			extruderTableView.setItems(extruderData(extruderNameBtn6.getText()));
		}
		if (extruderNameBtn7.isSelected()) {
			extruderTableView.setItems(extruderData(extruderNameBtn7.getText()));
		}
		if (extruderNameBtn8.isSelected()) {
			extruderTableView.setItems(extruderData(extruderNameBtn8.getText()));
		}
		if (extruderNameBtn9.isSelected()) {
			extruderTableView.setItems(extruderData(extruderNameBtn9.getText()));
		}
		if (extruderNameBtn10.isSelected()) {
			extruderTableView.setItems(extruderData(extruderNameBtn10.getText()));
		}
		if (extruderNameBtn11.isSelected()) {
			extruderTableView.setItems(extruderData(extruderNameBtn11.getText()));
		}
		if (extruderNameBtn12.isSelected()) {
			extruderTableView.setItems(extruderData(extruderNameBtn12.getText()));
		}
		if (extruderNameBtn13.isSelected()) {
			extruderTableView.setItems(extruderData(extruderNameBtn13.getText()));
		}
		if (extruderNameBtn14.isSelected()) {
			extruderTableView.setItems(extruderData(extruderNameBtn14.getText()));
		}

	}

	private void buttonOnAction() {
		extruderNameBtn1.setOnAction((event) -> {
			extruderTableView.setItems(extruderData(extruderNameBtn1.getText()));
		});
		extruderNameBtn2.setOnAction((event) -> {
			extruderTableView.setItems(extruderData(extruderNameBtn2.getText()));
		});
		extruderNameBtn3.setOnAction((event) -> {
			extruderTableView.setItems(extruderData(extruderNameBtn3.getText()));
		});
		extruderNameBtn4.setOnAction((event) -> {
			extruderTableView.setItems(extruderData(extruderNameBtn4.getText()));
		});
		extruderNameBtn5.setOnAction((event) -> {
			extruderTableView.setItems(extruderData(extruderNameBtn5.getText()));
		});
		extruderNameBtn6.setOnAction((event) -> {
			extruderTableView.setItems(extruderData(extruderNameBtn6.getText()));
		});
		extruderNameBtn7.setOnAction((event) -> {
			extruderTableView.setItems(extruderData(extruderNameBtn7.getText()));
		});
		extruderNameBtn8.setOnAction((event) -> {
			extruderTableView.setItems(extruderData(extruderNameBtn8.getText()));
		});
		extruderNameBtn9.setOnAction((event) -> {
			extruderTableView.setItems(extruderData(extruderNameBtn9.getText()));
		});
		extruderNameBtn10.setOnAction((event) -> {
			extruderTableView.setItems(extruderData(extruderNameBtn10.getText()));
		});
		extruderNameBtn11.setOnAction((event) -> {
			extruderTableView.setItems(extruderData(extruderNameBtn11.getText()));
		});
		extruderNameBtn12.setOnAction((event) -> {
			extruderTableView.setItems(extruderData(extruderNameBtn12.getText()));
		});
		extruderNameBtn13.setOnAction((event) -> {
			extruderTableView.setItems(extruderData(extruderNameBtn13.getText()));
		});
		extruderNameBtn14.setOnAction((event) -> {
			extruderTableView.setItems(extruderData(extruderNameBtn14.getText()));
		});
	}
}
