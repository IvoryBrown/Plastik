package com.manufacture.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class HomeController implements Initializable {

	@FXML
	private void exitProgram() {
		 Runtime runtime = Runtime.getRuntime();
		    try {
				Process proc = runtime.exec("shutdown -s -t 0");
			} catch (IOException e) {
				e.printStackTrace();
			}
		    System.exit(0);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Automatikusan előállított metóduscsonk

	}

}
