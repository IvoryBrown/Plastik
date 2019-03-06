package com.extruder.table.controller;

import com.commoditycalculation.database.CalculationDataBase;
import com.commoditycalculation.pojo.CommodityCalculation;
import com.extruder.pojo.CalculationButton;
import com.extruder.pojo.Extruder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CalculationButtonCell extends TableCell<Extruder, Boolean> {
	final Button cellButton = new Button("?");
	private CalculationDataBase db = new CalculationDataBase();
	private final ObservableList<CommodityCalculation> dataExtruder = FXCollections.observableArrayList();
	private HBox hBox;
	private TableView<CalculationButton> subTableView;

	public CalculationButtonCell(TableView<Extruder> tblView) {
		cellButton.setMaxSize(20, 20);
		cellButton.setOnAction(new EventHandler<ActionEvent>() {

			@SuppressWarnings({ "unchecked", "rawtypes" })
			@Override
			public void handle(ActionEvent arg0) {
				int selectdIndex = getTableRow().getIndex();
				Extruder selectedRecord = tblView.getItems().get(selectdIndex);
				dataExtruder.addAll(db.getAllCommodityCalculationExtruderTable(selectedRecord.getExtruderComodityId()));
				if (dataExtruder.size() != 0) {
					Label n = new Label(dataExtruder.get(0).getCommodityQuantity() + " /kg");
					Region region1 = new Region();
					HBox.setHgrow(region1, Priority.ALWAYS);
					Region region2 = new Region();
					HBox.setHgrow(region2, Priority.ALWAYS);
					hBox = new HBox(region1, n, region2);

					System.out.println("ID"+" "+ dataExtruder.get(0).getCommodityName1()+" "+
							dataExtruder.get(0).getCommodityPercentage1()+" "+
							dataExtruder.get(0).getCommodityPercentageKg1()
							);
					ObservableList<CalculationButton> subDataList = FXCollections
							.observableArrayList(new CalculationButton("ID", dataExtruder.get(0).getCommodityName1(),
									dataExtruder.get(0).getCommodityPercentage1(),
									dataExtruder.get(0).getCommodityPercentageKg1()));

					TableColumn columnfield = new TableColumn<>(" ");
					columnfield.setMinWidth(160);
					columnfield.setMaxWidth(160);

					TableColumn columnValueName = new TableColumn<>("Alapanyag név");
					columnValueName.setCellValueFactory(
							new PropertyValueFactory<CalculationButton, String>("fieldSubRecordValueName"));

					TableColumn columnValuePercentage = new TableColumn<>("%");
					columnValuePercentage.setCellValueFactory(
							new PropertyValueFactory<CalculationButton, String>("fieldSubRecordValuePercentage"));

					TableColumn columnValuePercentageKg = new TableColumn<>("kg");
					columnValuePercentage.setCellValueFactory(
							new PropertyValueFactory<CalculationButton, String>("fieldSubRecordValuePercentageKg"));

					subTableView = new TableView<>();
					// subTableView.setStyle("-fx-text-background-color: white;");
					subTableView.setItems(subDataList);
					subTableView.getColumns().addAll(columnfield, columnValueName, columnValuePercentage,
							columnValuePercentageKg);
					setStageGood();
				} else {
					setStageError();
				}
			}

		});
	}

	private void setStageError() {
		try {
			StackPane root = new StackPane();
			Label l = new Label();
			errorMessage("Nincs alapanyag számítás hozzá rendelve", l);
			root.getChildren().add(l);
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle("Alapanyag");
			stage.getIcons().add(new Image(getClass().getResourceAsStream("/com/setting/icon/foliak.png")));
			root.prefWidthProperty().bind(stage.widthProperty());
			stage.setScene(new Scene(root, 950, 750));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void setStageGood() {
		try {
			StackPane root = new StackPane();
			root.getChildren().addAll(hBox, subTableView);
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle("Alapanyag");
			stage.getIcons().add(new Image(getClass().getResourceAsStream("/com/setting/icon/foliak.png")));
			root.prefWidthProperty().bind(stage.widthProperty());
			stage.setScene(new Scene(root, 950, 750));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private Label errorMessage(String message, Label label) {
		label.setText(message);
		label.setStyle("-fx-text-fill: #CD5C5C; -fx-font-size: 32px;  -fx-font-weight: bold;");
		return label;

	}

	@Override
	protected void updateItem(Boolean t, boolean empty) {
		super.updateItem(t, empty);
		if (!empty) {
			setGraphic(cellButton);
		} else {
			setGraphic(null);
			setText(null);
		}
	}
}
