package com.menu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class ManufactureController {
	private MenuButton manufactureMenuBar;

	public ManufactureController(MenuButton manufactureMenuBar) {
		this.manufactureMenuBar = manufactureMenuBar;
		MenuItem m1 = new MenuItem("menu item 1");
		MenuItem m2 = new MenuItem("menu item 2");
		MenuItem m3 = new MenuItem("menu item 3");
		manufactureMenuBar.getItems().addAll(m1, m2, m3);
		m1.setOnAction(a->{ //lambda expression
			System.out.println("SDsd");
	     });
	}
}
