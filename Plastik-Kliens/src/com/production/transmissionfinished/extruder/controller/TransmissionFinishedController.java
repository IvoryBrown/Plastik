package com.production.transmissionfinished.extruder.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.production.transmissionfinished.extruder.pojo.Transmission;

import javafx.fxml.Initializable;

public class TransmissionFinishedController implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println(Transmission.getExtruderId());
		System.out.println(Transmission.getExtruderActualSize());
		System.out.println(Transmission.getExtruderClientName());
		System.out.println(Transmission.getExtruderIdentification());
		System.out.println(Transmission.getExtruderName());

	}

}
