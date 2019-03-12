package com.menu.calculations;

import com.commoditycalculation.main.CommodityCalculationMain;
import com.commodityrollweight.main.RollWeightMain;

import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class CalculationsController {
	private MenuButton manufactureMenuBar;
	private MenuItem m1, m2, m3;
	private CommodityCalculationMain commodityCalculationMain = new CommodityCalculationMain();
	private RollWeightMain rollWeightMain = new RollWeightMain();

	public CalculationsController(MenuButton manufactureMenuBar) {
		this.manufactureMenuBar = manufactureMenuBar;
		menuButton();
	}

	private void menuButton() {
		m1 = new MenuItem("Alapanyag számítás");
		m2 = new MenuItem("Tekercs számítások");
		m3 = new MenuItem("menu item 3");
		manufactureMenuBar.getItems().addAll(m1, m2, m3);
		m1.setOnAction(a -> {
			commodityCalculationMain.start();
		});
		m2.setOnAction(a -> {
			rollWeightMain.start();
		});

	}
}
