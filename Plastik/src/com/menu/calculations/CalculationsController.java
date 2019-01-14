package com.menu.calculations;

import com.commoditycalculation.main.CommodityCalculationMain;

import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class CalculationsController {
	private MenuButton manufactureMenuBar;
	private MenuItem m1, m2, m3;
	CommodityCalculationMain commodityCalculationMain = new CommodityCalculationMain();

	public CalculationsController(MenuButton manufactureMenuBar) {
		this.manufactureMenuBar = manufactureMenuBar;
		menuButton();
	}

	private void menuButton() {
		 m1 = new MenuItem("Alapanyag számítás");
		 m2 = new MenuItem("menu item 2");
		 m3 = new MenuItem("menu item 3");
		manufactureMenuBar.getItems().addAll(m1, m2, m3);
		m1.setOnAction(a -> { 
			commodityCalculationMain.start();
		});

	}
}
