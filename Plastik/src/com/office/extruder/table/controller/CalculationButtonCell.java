package com.office.extruder.table.controller;

import com.office.commoditycalculation.database.CalculationDataBase;
import com.office.commoditycalculation.pojo.CommodityCalculation;
import com.office.extruder.pallet.button.main.PalletButtonCellMain;
import com.office.extruder.pallet.button.pojo.PalletButtonCell;
import com.office.extruder.pallet.database.PalletDatabase;
import com.office.extruder.pallet.pojo.Pallet;
import com.office.extruder.pojo.Extruder;
import com.office.extruder.pojo.Transmission;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CalculationButtonCell extends TableCell<Extruder, Boolean> {
	private final Button commodityButton = new Button("");
	private final Button palletButton = new Button("");
	private final Button transmissionFinished = new Button("");
	private final HBox hBox = new HBox(commodityButton, palletButton, transmissionFinished);
	private CalculationDataBase db = new CalculationDataBase();
	private final ObservableList<CommodityCalculation> dataCommodity = FXCollections.observableArrayList();
	private PalletDatabase palletDatabase = new PalletDatabase();
	private final ObservableList<Pallet> dataPallet = FXCollections.observableArrayList();
	private Extruder selectedRecord;
	private GridPane grCommodity;

	public CalculationButtonCell(TableView<Extruder> tblView) {

		commodityButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				int selectdIndex = getTableRow().getIndex();
				Extruder selectedRecord = tblView.getItems().get(selectdIndex);
				dataCommodity
						.addAll(db.getAllCommodityCalculationExtruderTable(selectedRecord.getExtruderComodityId()));
				calculation();
			}

		});

		palletButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				int selectdIndex = getTableRow().getIndex();
				selectedRecord = tblView.getItems().get(selectdIndex);
				dataPallet.addAll(palletDatabase.getAllPallet(selectedRecord.getExtruderPalletId()));
				palleta();
			}

		});
		
		transmissionFinished.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				int selectdIndex = getTableRow().getIndex();
				selectedRecord = tblView.getItems().get(selectdIndex);
				Transmission.setExtruderId(selectedRecord.getExtruderId());
				
			}

		});
	}

	private void palleta() {

		if (dataPallet.size() != 0) {
			PalletButtonCell.setPalletId(Integer.valueOf(selectedRecord.getExtruderPalletId()));
			new PalletButtonCellMain().start(); 
		} else {
			setStageError();
		}

	}

	private void calculation() {
		if (dataCommodity.size() != 0) {

			Label lCommodityQuantity = new Label(dataCommodity.get(0).getCommodityQuantity() + " /kg");
			lCommodityQuantity.setStyle("-fx-text-fill: #CD5C5C; -fx-font-size: 32px;  -fx-font-weight: bold;");

			Label lCommodityName1 = new Label(dataCommodity.get(0).getCommodityName1());
			Label lCommodityName2 = new Label(dataCommodity.get(0).getCommodityName2());
			Label lCommodityName3 = new Label(dataCommodity.get(0).getCommodityName3());
			Label lCommodityName4 = new Label(dataCommodity.get(0).getCommodityName4());
			Label lCommodityName5 = new Label(dataCommodity.get(0).getCommodityName5());
			Label lCommodityName6 = new Label(dataCommodity.get(0).getCommodityName6());
			Label lCommodityName7 = new Label(dataCommodity.get(0).getCommodityName7());
			Label lCommodityName8 = new Label(dataCommodity.get(0).getCommodityName8());

			Label lCommodityPercentage1 = new Label(dataCommodity.get(0).getCommodityPercentage1() + " %");
			Label lCommodityPercentage2 = new Label(dataCommodity.get(0).getCommodityPercentage2() + " %");
			Label lCommodityPercentage3 = new Label(dataCommodity.get(0).getCommodityPercentage3() + " %");
			Label lCommodityPercentage4 = new Label(dataCommodity.get(0).getCommodityPercentage4() + " %");
			Label lCommodityPercentage5 = new Label(dataCommodity.get(0).getCommodityPercentage5() + " %");
			Label lCommodityPercentage6 = new Label(dataCommodity.get(0).getCommodityPercentage6() + " %");
			Label lCommodityPercentage7 = new Label(dataCommodity.get(0).getCommodityPercentage7() + " %");
			Label lCommodityPercentage8 = new Label(dataCommodity.get(0).getCommodityPercentage8() + " %");

			Label lCommodityPercentageKg1 = new Label(dataCommodity.get(0).getCommodityPercentageKg1() + " /Kg");
			Label lCommodityPercentageKg2 = new Label(dataCommodity.get(0).getCommodityPercentageKg2() + " /Kg");
			Label lCommodityPercentageKg3 = new Label(dataCommodity.get(0).getCommodityPercentageKg3() + " /Kg");
			Label lCommodityPercentageKg4 = new Label(dataCommodity.get(0).getCommodityPercentageKg4() + " /Kg");
			Label lCommodityPercentageKg5 = new Label(dataCommodity.get(0).getCommodityPercentageKg5() + " /Kg");
			Label lCommodityPercentageKg6 = new Label(dataCommodity.get(0).getCommodityPercentageKg6() + " /Kg");
			Label lCommodityPercentageKg7 = new Label(dataCommodity.get(0).getCommodityPercentageKg7() + " /Kg");
			Label lCommodityPercentageKg8 = new Label(dataCommodity.get(0).getCommodityPercentageKg8() + " /Kg");

			grCommodity = new GridPane();

			grCommodity.setHgap(60);
			grCommodity.setVgap(10);
			grCommodity.setMaxSize(500, 300);

			grCommodity.add(lCommodityQuantity, 1, 1, 1, 1);

			grCommodity.add(lCommodityName1, 0, 2, 1, 1);
			grCommodity.add(lCommodityName2, 0, 3, 1, 1);
			grCommodity.add(lCommodityName3, 0, 4, 1, 1);
			grCommodity.add(lCommodityName4, 0, 5, 1, 1);
			grCommodity.add(lCommodityName5, 0, 6, 1, 1);
			grCommodity.add(lCommodityName6, 0, 7, 1, 1);
			grCommodity.add(lCommodityName7, 0, 8, 1, 1);
			grCommodity.add(lCommodityName8, 0, 9, 1, 1);

			grCommodity.add(lCommodityPercentage1, 1, 2, 1, 1);
			grCommodity.add(lCommodityPercentage2, 1, 3, 1, 1);
			grCommodity.add(lCommodityPercentage3, 1, 4, 1, 1);
			grCommodity.add(lCommodityPercentage4, 1, 5, 1, 1);
			grCommodity.add(lCommodityPercentage5, 1, 6, 1, 1);
			grCommodity.add(lCommodityPercentage6, 1, 7, 1, 1);
			grCommodity.add(lCommodityPercentage7, 1, 8, 1, 1);
			grCommodity.add(lCommodityPercentage8, 1, 9, 1, 1);

			grCommodity.add(lCommodityPercentageKg1, 2, 2, 1, 1);
			grCommodity.add(lCommodityPercentageKg2, 2, 3, 1, 1);
			grCommodity.add(lCommodityPercentageKg3, 2, 4, 1, 1);
			grCommodity.add(lCommodityPercentageKg4, 2, 5, 1, 1);
			grCommodity.add(lCommodityPercentageKg5, 2, 6, 1, 1);
			grCommodity.add(lCommodityPercentageKg6, 2, 7, 1, 1);
			grCommodity.add(lCommodityPercentageKg7, 2, 8, 1, 1);
			grCommodity.add(lCommodityPercentageKg8, 2, 9, 1, 1);

			setStageCommodityGood();
		} else {
			setStageError();
		}
	}

	private void setStageError() {
		try {
			StackPane root = new StackPane();
			Label l = new Label();
			errorMessage("Adatrögzítés nem történt!", l);
			root.getChildren().add(l);
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle("Stanicli");
			stage.getIcons().add(new Image(getClass().getResourceAsStream("/com/setting/icon/foliak.png")));
			root.prefWidthProperty().bind(stage.widthProperty());
			stage.setScene(new Scene(root, 600, 400));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void setStageCommodityGood() {
		try {
			StackPane root = new StackPane();
			root.getStylesheets().add("/com/main/view/css/calculaionbutton.css");
			root.getChildren().addAll(grCommodity);
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
		hBox.setSpacing(10);
		hBox.setAlignment(Pos.CENTER);
		commodityButton.getStylesheets().add("/com/main/view/css/button.css");
		commodityButton.getStyleClass().add("calculationButton");
		palletButton.getStylesheets().add("/com/main/view/css/button.css");
		palletButton.getStyleClass().add("palletButton");
		transmissionFinished.getStylesheets().add("/com/main/view/css/button.css");
		transmissionFinished.getStyleClass().add("transmissionButton");
		commodityButton.setMinSize(40, 25);
		palletButton.setMinSize(40, 25);
		transmissionFinished.setMinSize(40, 25);
		super.updateItem(t, empty);
		if (!empty) {

			setGraphic(hBox);
		} else {
			setGraphic(null);
			setText(null);
		}
	}

}
