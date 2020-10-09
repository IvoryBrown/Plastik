package application.setting.popup;

import javafx.scene.control.Tooltip;

//message button, textfield
public class TooltipMessage extends Tooltip {

	
	public TooltipMessage(String message) {
	
		this.setText(message);
		this.setStyle("-fx-font: normal bold 18 Langdon; "
			    + "-fx-background-color: #1b9891; "
			    + "-fx-text-fill: white;");

	}


}
