package com.office.extruder.pallet.button.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.office.extruder.pallet.button.pojo.PalletButtonCell;
import com.office.extruder.pallet.database.PalletDatabase;
import com.office.extruder.pallet.pojo.Pallet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PalletButtonCellController implements Initializable{
	private final ObservableList<Pallet> dataPallet = FXCollections.observableArrayList();
	private PalletDatabase palletDatabase = new PalletDatabase();

	@FXML
	private TextField spoolTypeTxt, spoolLenghtTxt, spoolSizeTxt, coilDiameterTxt, coilOfSpoolsTxt, coliLengthTxt,
			coilMinDiameter, coilMinOfSpoolsTxt, coilMinLengthTxt;
	@FXML
	private TextArea spoolCommentTxt;
	// palletProperty
	@FXML
	private TextField rollsNumberTxt, palettBCrowdTxt, palettNCrowdTxt, palettNNCrowdTxt;
	@FXML
	private TextArea palletTypeTxt, palletLocationTxt, palletCommentTxt;
	// palletWrapping
	@FXML
	private TextArea palletWrappingTxt, palletWrappingCommentTxt;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		dataPallet.addAll(palletDatabase.getAllPallet(String.valueOf(PalletButtonCell.getPalletId())));
		spoolTypeTxt.setText(dataPallet.get(0).getPalletSpoolType());
		spoolLenghtTxt.setText(dataPallet.get(0).getPalletSpoolLenght());
		spoolSizeTxt.setText(dataPallet.get(0).getPalletSpoolSize());
		coilDiameterTxt.setText(dataPallet.get(0).getPalletCoilDiameter());
		coilOfSpoolsTxt.setText(dataPallet.get(0).getPalletCoilOfSpools());
		coliLengthTxt.setText(dataPallet.get(0).getPalletColiLength());
		coilMinDiameter.setText(dataPallet.get(0).getPalletColiMinDiameter());
		coilMinOfSpoolsTxt.setText(dataPallet.get(0).getPalletColiMinOfSpools());
		coilMinLengthTxt.setText(dataPallet.get(0).getPalletColiMinLength());
		spoolCommentTxt.setText(dataPallet.get(0).getPalletSpoolComment());
		rollsNumberTxt.setText(dataPallet.get(0).getPalletRollsNumber());
		palettBCrowdTxt.setText(dataPallet.get(0).getPalletBCrowd());
		palettNCrowdTxt.setText(dataPallet.get(0).getPalletNCrowd());
		palettNNCrowdTxt.setText(dataPallet.get(0).getPalletNNCrowd());
		palletTypeTxt.setText(dataPallet.get(0).getPalletType());
		palletLocationTxt.setText(dataPallet.get(0).getPalletLocation());
		palletCommentTxt.setText(dataPallet.get(0).getPalletComment());
		palletWrappingTxt.setText(dataPallet.get(0).getPalletWrapping());
		palletWrappingCommentTxt.setText(dataPallet.get(0).getPalletWrappingComment());
	}
}
