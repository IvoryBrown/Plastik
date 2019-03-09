package com.extruder.table.controller;

import com.commoditycalculation.database.CalculationDataBase;
import com.commoditycalculation.pojo.CommodityCalculation;
import com.extruder.pojo.Extruder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CalculationButtonCell extends TableCell<Extruder, Boolean> {
	final Button cellButton = new Button("?");
	private CalculationDataBase db = new CalculationDataBase();
	private final ObservableList<CommodityCalculation> dataExtruder = FXCollections.observableArrayList();

	private GridPane gr;

	public CalculationButtonCell(TableView<Extruder> tblView) {

		cellButton.setMaxSize(20, 20);
		cellButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				int selectdIndex = getTableRow().getIndex();
				Extruder selectedRecord = tblView.getItems().get(selectdIndex);
				dataExtruder.addAll(db.getAllCommodityCalculationExtruderTable(selectedRecord.getExtruderComodityId()));
				if (dataExtruder.size() != 0) {

					Label lCommodityQuantity = new Label(dataExtruder.get(0).getCommodityQuantity() + " /kg");
					lCommodityQuantity.setStyle("-fx-text-fill: #CD5C5C; -fx-font-size: 32px;  -fx-font-weight: bold;");

					Label lCommodityName1 = new Label(dataExtruder.get(0).getCommodityName1());
					Label lCommodityName2 = new Label(dataExtruder.get(0).getCommodityName2());
					Label lCommodityName3 = new Label(dataExtruder.get(0).getCommodityName3());
					Label lCommodityName4 = new Label(dataExtruder.get(0).getCommodityName4());
					Label lCommodityName5 = new Label(dataExtruder.get(0).getCommodityName5());
					Label lCommodityName6 = new Label(dataExtruder.get(0).getCommodityName6());
					Label lCommodityName7 = new Label(dataExtruder.get(0).getCommodityName7());
					Label lCommodityName8 = new Label(dataExtruder.get(0).getCommodityName8());

					Label lCommodityPercentage1 = new Label(dataExtruder.get(0).getCommodityPercentage1() + " %");
					Label lCommodityPercentage2 = new Label(dataExtruder.get(0).getCommodityPercentage2() + " %");
					Label lCommodityPercentage3 = new Label(dataExtruder.get(0).getCommodityPercentage3() + " %");
					Label lCommodityPercentage4 = new Label(dataExtruder.get(0).getCommodityPercentage4() + " %");
					Label lCommodityPercentage5 = new Label(dataExtruder.get(0).getCommodityPercentage5() + " %");
					Label lCommodityPercentage6 = new Label(dataExtruder.get(0).getCommodityPercentage6() + " %");
					Label lCommodityPercentage7 = new Label(dataExtruder.get(0).getCommodityPercentage7() + " %");
					Label lCommodityPercentage8 = new Label(dataExtruder.get(0).getCommodityPercentage8() + " %");

					Label lCommodityPercentageKg1 = new Label(dataExtruder.get(0).getCommodityPercentageKg1() + " /Kg");
					Label lCommodityPercentageKg2 = new Label(dataExtruder.get(0).getCommodityPercentageKg2() + " /Kg");
					Label lCommodityPercentageKg3 = new Label(dataExtruder.get(0).getCommodityPercentageKg3() + " /Kg");
					Label lCommodityPercentageKg4 = new Label(dataExtruder.get(0).getCommodityPercentageKg4() + " /Kg");
					Label lCommodityPercentageKg5 = new Label(dataExtruder.get(0).getCommodityPercentageKg5() + " /Kg");
					Label lCommodityPercentageKg6 = new Label(dataExtruder.get(0).getCommodityPercentageKg6() + " /Kg");
					Label lCommodityPercentageKg7 = new Label(dataExtruder.get(0).getCommodityPercentageKg7() + " /Kg");
					Label lCommodityPercentageKg8 = new Label(dataExtruder.get(0).getCommodityPercentageKg8() + " /Kg");

					gr = new GridPane();

					gr.setHgap(60);
					gr.setVgap(10);
					gr.setMaxSize(500, 300);

					gr.add(lCommodityQuantity, 1, 1, 1, 1);

					gr.add(lCommodityName1, 0, 2, 1, 1);
					gr.add(lCommodityName2, 0, 3, 1, 1);
					gr.add(lCommodityName3, 0, 4, 1, 1);
					gr.add(lCommodityName4, 0, 5, 1, 1);
					gr.add(lCommodityName5, 0, 6, 1, 1);
					gr.add(lCommodityName6, 0, 7, 1, 1);
					gr.add(lCommodityName7, 0, 8, 1, 1);
					gr.add(lCommodityName8, 0, 9, 1, 1);

					gr.add(lCommodityPercentage1, 1, 2, 1, 1);
					gr.add(lCommodityPercentage2, 1, 3, 1, 1);
					gr.add(lCommodityPercentage3, 1, 4, 1, 1);
					gr.add(lCommodityPercentage4, 1, 5, 1, 1);
					gr.add(lCommodityPercentage5, 1, 6, 1, 1);
					gr.add(lCommodityPercentage6, 1, 7, 1, 1);
					gr.add(lCommodityPercentage7, 1, 8, 1, 1);
					gr.add(lCommodityPercentage8, 1, 9, 1, 1);

					gr.add(lCommodityPercentageKg1, 2, 2, 1, 1);
					gr.add(lCommodityPercentageKg2, 2, 3, 1, 1);
					gr.add(lCommodityPercentageKg3, 2, 4, 1, 1);
					gr.add(lCommodityPercentageKg4, 2, 5, 1, 1);
					gr.add(lCommodityPercentageKg5, 2, 6, 1, 1);
					gr.add(lCommodityPercentageKg6, 2, 7, 1, 1);
					gr.add(lCommodityPercentageKg7, 2, 8, 1, 1);
					gr.add(lCommodityPercentageKg8, 2, 9, 1, 1);

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
			stage.setScene(new Scene(root, 600, 400));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void setStageGood() {
		try {
			StackPane root = new StackPane();
			root.getStylesheets().add("/com/main/view/css/calculaionbutton.css");
			root.getChildren().addAll(gr);
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle("Alapanyag");
			stage.getIcons().add(new Image(getClass().getResourceAsStream("/com/setting/icon/foliak.png")));
			root.prefWidthProperty().bind(stage.widthProperty());
			stage.setScene(new Scene(root, 600, 400));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private Label errorMessage(String message, Label label) {
		label.setText(message);
		label.setStyle("-fx-text-fill: #CD5C5C; -fx-font-size: 25px;  -fx-font-weight: bold;");
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
