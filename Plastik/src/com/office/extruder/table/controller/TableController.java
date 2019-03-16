package com.office.extruder.table.controller;

import java.util.Date;

import com.office.extruder.name.ExtruderName;
import com.office.extruder.pojo.Extruder;
import com.office.extruder.table.database.TableDataBase;
import com.project.setting.machine.database.MachineDataBase;
import com.setting.label.MessageLabel;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.StageStyle;
import javafx.util.Callback;

public class TableController {
	private AnchorPane extruderNewJobsPane, extruderActualJobsPane;
	private TableView<Extruder> extruderTableView;
	private TableColumn<Extruder, Integer> extruderId, extruderClientId, extruderFlatPlateBag, extruderWidth,
			extruderLength;
	private TableColumn<Extruder, Date> extruderAddDate, extruderEndDate;
	private TableColumn<Extruder, Double> extruderThickness, extruderGrammMeter;
	private TableColumn<Extruder, String> extruderClientName, extruderIdentification, extruderOrderedKg, extruderStatus,
			extruderCommodity, extruderActualSize, extruderName, extruderComment, extruderPriority;
	private TableColumn<Extruder, Boolean> colActive;
	private TableColumn<Extruder, String> extruderActualKg;
	private Label messageLbl;
	private final ObservableList<Extruder> dataExtruder = FXCollections.observableArrayList();
	private TableDataBase tableDataBase = new TableDataBase();
	private MessageLabel message = new MessageLabel();
	private ToggleButton extruderNameBtn1, extruderNameBtn2, extruderNameBtn3, extruderNameBtn4, extruderNameBtn5,
			extruderNameBtn6, extruderNameBtn7, extruderNameBtn8, extruderNameBtn9, extruderNameBtn10,
			extruderNameBtn11, extruderNameBtn12, extruderNameBtn13, extruderNameBtn14, extruderNameAllBtn;
	private HBox hBox;
	private Button extruderFilteringBtn;
	private TextField extruderFilteringTxt;
	private ToggleGroup group = new ToggleGroup();
	private CheckBox statusCbox;
	private HBox upDownHBox;
	Button upButton = new Button();
	Button downButton = new Button();

	public TableController(AnchorPane extruderNewJobsPane, AnchorPane extruderActualJobsPane,
			TableView<Extruder> extruderTableView, Label messageLbl, HBox hBox, Button extruderFilteringBtn,
			TextField extruderFilteringTxt, CheckBox statusCbox, HBox upDownHBox) {
		this.extruderNewJobsPane = extruderNewJobsPane;
		this.extruderActualJobsPane = extruderActualJobsPane;
		this.extruderTableView = extruderTableView;
		this.messageLbl = messageLbl;
		this.hBox = hBox;
		this.extruderFilteringBtn = extruderFilteringBtn;
		this.extruderFilteringTxt = extruderFilteringTxt;
		this.statusCbox = statusCbox;
		this.upDownHBox = upDownHBox;
		clearTable();
		extruderTable();
		setColumn();
		setToggleButton();
		buttonOnAction();
		checkBox();
		setButton();
	}

	private void checkBox() {
		statusCbox.setSelected(true);
	}

	private void buttonVisibleIsSelected() {
		upButton.setVisible(true);
		downButton.setVisible(true);

	}

	private void buttonVisible() {
		upButton.setVisible(false);
		downButton.setVisible(false);

	}

	private void setButton() {
		upButton.getStylesheets().add(getClass().getResource("/com/main/view/css/button.css").toExternalForm());
		upButton.getStyleClass().add("upButton");
		downButton.getStylesheets().add(getClass().getResource("/com/main/view/css/button.css").toExternalForm());
		downButton.getStyleClass().add("downButton");
		downButton.setPrefSize(25, 25);
		upButton.setPrefSize(25, 25);
		upDownHBox.getChildren().addAll(upButton, downButton);
		ReadOnlyIntegerProperty selectedIndex = extruderTableView.getSelectionModel().selectedIndexProperty();
		upButton.disableProperty().bind(selectedIndex.lessThanOrEqualTo(0));
		downButton.disableProperty().bind(Bindings.createBooleanBinding(() -> {
			int index = selectedIndex.get();
			return index < 0 || index + 1 >= extruderTableView.getItems().size();
		}, selectedIndex, extruderTableView.getItems()));
		upButton.setOnAction(evt -> {
			int index = extruderTableView.getSelectionModel().getSelectedIndex();
			Extruder actual = extruderTableView.getSelectionModel().getSelectedItem();
			extruderTableView.getItems().add(index - 1, extruderTableView.getItems().remove(index));
			extruderTableView.getSelectionModel().clearAndSelect(index - 1);
			tableDataBase.updateExtruderPriorit(actual.getExtruderId(),
					extruderTableView.getItems().get(index).getExtruderPriority());
			tableDataBase.updateExtruderPriorit(extruderTableView.getItems().get(index).getExtruderId(),
					actual.getExtruderPriority());
			updateDataTable();
		});
		downButton.setOnAction(evt -> {
			int index = extruderTableView.getSelectionModel().getSelectedIndex();
			Extruder actual = extruderTableView.getSelectionModel().getSelectedItem();
			extruderTableView.getItems().add(index + 1, extruderTableView.getItems().remove(index));
			extruderTableView.getSelectionModel().clearAndSelect(index + 1);
			tableDataBase.updateExtruderPriorit(actual.getExtruderId(),
					extruderTableView.getItems().get(index).getExtruderPriority());
			tableDataBase.updateExtruderPriorit(extruderTableView.getItems().get(index).getExtruderId(),
					actual.getExtruderPriority());
			updateDataTable();
		});
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
		extruderNameAllBtn = new ToggleButton();
		new ExtruderName(extruderNameAllBtn, extruderNameBtn1, extruderNameBtn2, extruderNameBtn3, extruderNameBtn4,
				extruderNameBtn5, extruderNameBtn6, extruderNameBtn7, extruderNameBtn8, extruderNameBtn9,
				extruderNameBtn10, extruderNameBtn11, extruderNameBtn12, extruderNameBtn13, extruderNameBtn14);
		extruderNameAllBtn.setToggleGroup(group);
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
		hBox.getChildren().addAll(extruderNameAllBtn, extruderNameBtn1, extruderNameBtn2, extruderNameBtn3,
				extruderNameBtn4, extruderNameBtn5, extruderNameBtn6, extruderNameBtn7, extruderNameBtn8,
				extruderNameBtn9, extruderNameBtn10, extruderNameBtn11, extruderNameBtn12, extruderNameBtn13,
				extruderNameBtn14);
		
	}

	private void clearTable() {
		extruderTableView.getItems().clear();
		extruderTableView.getColumns().clear();

	}

	@SuppressWarnings("unchecked")
	private void setColumn() {
		extruderTableView.getColumns().addAll(colActive, extruderId, extruderClientId, extruderPriority,
				extruderClientName, extruderName, extruderIdentification, extruderStatus, extruderAddDate,
				extruderEndDate, extruderCommodity, extruderActualSize, extruderWidth, extruderLength,
				extruderThickness, extruderFlatPlateBag, extruderGrammMeter, extruderOrderedKg, extruderActualKg,
				extruderComment);
		extruderTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}

	private void extruderTable() {

		colActive = new TableColumn<>("");
		colActive.setSortable(false);
		colActive.setMinWidth(100);
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

		extruderId = new TableColumn<>("ID");
		extruderId.setMinWidth(80);
		extruderId.setCellValueFactory(new PropertyValueFactory<Extruder, Integer>("extruderId"));
		extruderId.setVisible(false);

		extruderClientId = new TableColumn<>("ID");
		extruderClientId.setMinWidth(90);
		extruderClientId.setCellValueFactory(new PropertyValueFactory<Extruder, Integer>("extruderClientId"));
		extruderClientId.setVisible(false);

		extruderClientName = new TableColumn<>("Ügyfél név");
		extruderClientName.setMinWidth(120);
		extruderClientName.setCellValueFactory(new PropertyValueFactory<Extruder, String>("extruderClientName"));

		extruderName = new TableColumn<>("Extruder gép");
		extruderName.setMinWidth(120);
		extruderName.setCellValueFactory(new PropertyValueFactory<Extruder, String>("extruderName"));
		MachineDataBase machineDataBase = new MachineDataBase();
		String[] array = new String[14];
		for (int j = 0; j < machineDataBase.getAllMachine().size(); j++) {
			array[j] = machineDataBase.getAllMachine().get(j).getMachineName();
		}
		extruderName.setCellFactory(ComboBoxTableCell.forTableColumn(array));
		extruderName.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Extruder, String>>() {
			@Override
			public void handle(TableColumn.CellEditEvent<Extruder, String> d) {
				Alert alert = new Alert(Alert.AlertType.NONE, "Biztos át helyezed", ButtonType.YES, ButtonType.NO);
				alert.getDialogPane().getStylesheets().add("/com/setting/showinfo/ShowInfo.css");
				alert.initStyle(StageStyle.TRANSPARENT);
				if (alert.showAndWait().orElse(ButtonType.NO) == ButtonType.YES) {
					Extruder extruder = (Extruder) d.getTableView().getItems().get(d.getTablePosition().getRow());
					System.out.println(extruder.getExtruderStatus());
					if (extruder.getExtruderStatus().equals("Folyamatban")) {
						System.out.println("r");
						extruder.setExtruderName(d.getNewValue());
						tableDataBase.updateExtruder(extruder);
						message.goodMessage("Extruder gép sikeres frissitése", messageLbl);
					} else {
						message.errorMessage("Hiba! Lezárt termék!", messageLbl);
					}
				}
				updateDataTable();
			}
		});

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
				Alert alert = new Alert(Alert.AlertType.NONE, "Biztos megváltoztatod a státuszt?", ButtonType.YES,
						ButtonType.NO);
				alert.getDialogPane().getStylesheets().add("/com/setting/showinfo/ShowInfo.css");
				alert.initStyle(StageStyle.TRANSPARENT);
				if (alert.showAndWait().orElse(ButtonType.NO) == ButtonType.YES) {
					Extruder extruder = (Extruder) d.getTableView().getItems().get(d.getTablePosition().getRow());
					extruder.setExtruderStatus(d.getNewValue());
					extruder.setExtruderPriority(null);
					tableDataBase.updateExtruder(extruder);
					message.goodMessage("Státusz sikeres frissitése", messageLbl);
				}
				updateDataTable();
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

		extruderOrderedKg = new TableColumn<>("Megrendelt/kg");
		extruderOrderedKg.setMinWidth(100);
		extruderOrderedKg.setCellValueFactory(new PropertyValueFactory<Extruder, String>("extruderOrderedKg"));

		extruderActualKg = new TableColumn<>("Lefújva/kg");
		extruderActualKg.setMinWidth(80);
		extruderActualKg.setCellValueFactory(new PropertyValueFactory<Extruder, String>("extruderActualKg"));

		extruderPriority = new TableColumn<>("Priorítás");
		extruderPriority.setMinWidth(80);
		extruderPriority.setCellValueFactory(new PropertyValueFactory<Extruder, String>("extruderPriority"));
		extruderPriority.setCellFactory(TextFieldTableCell.forTableColumn());
		extruderPriority.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Extruder, String>>() {
			@Override
			public void handle(TableColumn.CellEditEvent<Extruder, String> d) {
				Extruder extruder = (Extruder) d.getTableView().getItems().get(d.getTablePosition().getRow());
				if (extruder.getExtruderStatus().equals("Folyamatban")) {
					if (d.getNewValue().trim().isEmpty()) {
						extruder.setExtruderPriority(null);
						tableDataBase.updateExtruder(extruder);
					} else {
						extruder.setExtruderPriority(d.getNewValue());
						tableDataBase.updateExtruder(extruder);
					}
					message.goodMessage("Priorítás sikeres frissitése", messageLbl);
				} else {
					message.errorMessage("Hiba! Lezárt termék!", messageLbl);
				}
				updateDataTable();
			}
		});

		extruderComment = new TableColumn<>("Megjegyzés");
		extruderComment.setMinWidth(960);
		extruderComment.setCellValueFactory(new PropertyValueFactory<Extruder, String>("extruderComment"));
		extruderComment.setCellFactory(TextFieldTableCell.forTableColumn());
		extruderComment.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Extruder, String>>() {
			@Override
			public void handle(TableColumn.CellEditEvent<Extruder, String> d) {
				Extruder extruder = (Extruder) d.getTableView().getItems().get(d.getTablePosition().getRow());
				if (extruder.getExtruderStatus().equals("Folyamatban")) {
					extruder.setExtruderComment(d.getNewValue());
					tableDataBase.updateExtruder(extruder);
					message.goodMessage("Megjegyzés sikeres frissitése", messageLbl);
				} else {
					message.errorMessage("Hiba! Lezárt termék!", messageLbl);
				}
				updateDataTable();
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
					if (item.getExtruderStatus().equals("Elkészült")) {
						setStyle("-fx-text-background-color: tomato;");
					} else if (s >= g) {
						setStyle("-fx-text-background-color: #00FF00;");
					} else {
						setStyle("-fx-text-background-color: whitesmoke;");

					}

				}
			}
		});

	}

	private ObservableList<Extruder> extruderData(String extruderName) {
		dataExtruder.clear();
		dataExtruder.addAll(
				tableDataBase.getAllExtruder(extruderName, extruderFilteringTxt.getText(), statusCbox.isSelected()));
		return dataExtruder;

	}

	private void dataMessageSize() {
		if (dataExtruder.size() != 0) {
			message.goodMessage("Sikeres keresés: " + dataExtruder.size() + " találat", messageLbl);
		} else {
			message.errorMessage("Sikertelen keresés: " + dataExtruder.size() + " találat", messageLbl);
		}
		if (extruderFilteringTxt.getText().trim().isEmpty()) {
			messageLbl.setText("");
		}
	}

	private void actualJobsPane() {
		extruderNewJobsPane.setVisible(false);
		extruderActualJobsPane.setVisible(true);
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
		if (extruderNameAllBtn.isSelected()) {
			extruderTableView.setItems(extruderData(""));
		}

	}

	private void buttonOnAction() {
		extruderFilteringBtn.setOnAction((event) -> {
			updateDataTable();
			dataMessageSize();
		});
		extruderFilteringTxt.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.ENTER)) {
					updateDataTable();
					dataMessageSize();
				}
			}
		});
		statusCbox.setOnAction((event) -> {
			updateDataTable();
		});
		extruderNameBtn1.setOnAction((event) -> {
			buttonVisibleIsSelected();
			actualJobsPane();
			extruderTableView.setItems(extruderData(extruderNameBtn1.getText()));
		});
		extruderNameBtn2.setOnAction((event) -> {
			buttonVisibleIsSelected();
			actualJobsPane();
			extruderTableView.setItems(extruderData(extruderNameBtn2.getText()));
		});
		extruderNameBtn3.setOnAction((event) -> {
			buttonVisibleIsSelected();
			actualJobsPane();
			extruderTableView.setItems(extruderData(extruderNameBtn3.getText()));
		});
		extruderNameBtn4.setOnAction((event) -> {
			buttonVisibleIsSelected();
			actualJobsPane();
			extruderTableView.setItems(extruderData(extruderNameBtn4.getText()));
		});
		extruderNameBtn5.setOnAction((event) -> {
			buttonVisibleIsSelected();
			actualJobsPane();
			extruderTableView.setItems(extruderData(extruderNameBtn5.getText()));
		});
		extruderNameBtn6.setOnAction((event) -> {
			buttonVisibleIsSelected();
			actualJobsPane();
			extruderTableView.setItems(extruderData(extruderNameBtn6.getText()));
		});
		extruderNameBtn7.setOnAction((event) -> {
			buttonVisibleIsSelected();
			actualJobsPane();
			extruderTableView.setItems(extruderData(extruderNameBtn7.getText()));
		});
		extruderNameBtn8.setOnAction((event) -> {
			buttonVisibleIsSelected();
			actualJobsPane();
			extruderTableView.setItems(extruderData(extruderNameBtn8.getText()));
		});
		extruderNameBtn9.setOnAction((event) -> {
			buttonVisibleIsSelected();
			actualJobsPane();
			extruderTableView.setItems(extruderData(extruderNameBtn9.getText()));
		});
		extruderNameBtn10.setOnAction((event) -> {
			buttonVisibleIsSelected();
			actualJobsPane();
			extruderTableView.setItems(extruderData(extruderNameBtn10.getText()));
		});
		extruderNameBtn11.setOnAction((event) -> {
			buttonVisibleIsSelected();
			actualJobsPane();
			extruderTableView.setItems(extruderData(extruderNameBtn11.getText()));
		});
		extruderNameBtn12.setOnAction((event) -> {
			buttonVisibleIsSelected();
			actualJobsPane();
			extruderTableView.setItems(extruderData(extruderNameBtn12.getText()));
		});
		extruderNameBtn13.setOnAction((event) -> {
			buttonVisibleIsSelected();
			actualJobsPane();
			extruderTableView.setItems(extruderData(extruderNameBtn13.getText()));
		});
		extruderNameBtn14.setOnAction((event) -> {
			buttonVisibleIsSelected();
			actualJobsPane();
			extruderTableView.setItems(extruderData(extruderNameBtn14.getText()));
		});
		extruderNameAllBtn.setOnAction((event) -> {
			buttonVisible();
			actualJobsPane();
			extruderTableView.setItems(extruderData(""));

		});
	}
}
