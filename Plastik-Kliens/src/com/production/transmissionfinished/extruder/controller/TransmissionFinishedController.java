package com.production.transmissionfinished.extruder.controller;

import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import com.fazecast.jSerialComm.SerialPort;
import com.kliens.message.pojo.Kliens;
import com.production.transmissionfinished.extruder.database.TransmissionExtruderDataBase;
import com.production.transmissionfinished.extruder.pojo.Transmission;
import com.production.transmissionfinished.extruder.pojo.TransmissionFinished;
import com.project.setting.worker.database.WorkersDataBase;
import com.project.setting.worker.pojo.Workers;
import com.setting.label.MessageLabel;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class TransmissionFinishedController implements Initializable {
	@FXML
	private TableView<TransmissionFinished> transmissionFinishedTableView;
	private TableColumn<TransmissionFinished, Integer> transmissionId, extruderId;
	private TableColumn<TransmissionFinished, String> transmissionExtruderIdentification, transmissionIdentification,
			transmissionExtruderName, transmissionWorkerName, transmissionClientName, transmissionExtruderActualSize,
			transmissionBKg, transmissionNKg, transmissionSpool;
	private TableColumn<TransmissionFinished, Date> transmissionDate;
	@FXML
	private Label orderKgLbl, actualKgLbl, messageLbl;
	@FXML
	private TextField workerNameTxt, transmissionActualKgTxt;
	@FXML
	private TextArea transmissionTxt;
	@FXML
	private Button saveDataBase;

	private TransmissionExtruderDataBase transmissionExtruderDataBase = new TransmissionExtruderDataBase();
	private final ObservableList<TransmissionFinished> dataTransmission = FXCollections.observableArrayList();

	private final ObservableList<Workers> dataWorkers = FXCollections.observableArrayList();
	private WorkersDataBase workersDB = new WorkersDataBase();

	// Táblázat fel.
	private ObservableList<TransmissionFinished> transmissionFinishedData() {
		dataTransmission.clear();
		dataTransmission
				.addAll(transmissionExtruderDataBase.getAllTransmision(Integer.valueOf(Transmission.getExtruderId())));
		return dataTransmission;

	}

	// dolgozó ellen.
	private ObservableList<Workers> workersData() {
		dataWorkers.clear();
		dataWorkers.addAll(workersDB.searchAllWorkers(workerNameTxt.getText()));
		return dataWorkers;

	}

	@SuppressWarnings("unchecked")
	private void setColumn() {
		transmissionFinishedTableView.getColumns().addAll(transmissionId, transmissionIdentification,
				transmissionExtruderIdentification, transmissionBKg, transmissionNKg, transmissionSpool,
				transmissionExtruderName, transmissionDate, transmissionWorkerName, transmissionClientName,
				transmissionExtruderActualSize, extruderId);
	}

	private void extruderTable() {
		transmissionId = new TableColumn<>("ID");
		transmissionId.setMinWidth(50);
		transmissionId.setCellValueFactory(new PropertyValueFactory<TransmissionFinished, Integer>("transmissionId"));

		extruderId = new TableColumn<>("ExID");
		extruderId.setMinWidth(50);
		extruderId.setCellValueFactory(new PropertyValueFactory<TransmissionFinished, Integer>("extruderId"));

		transmissionIdentification = new TableColumn<>("Leadás ID");
		transmissionIdentification.setMinWidth(50);
		transmissionIdentification.setCellValueFactory(
				new PropertyValueFactory<TransmissionFinished, String>("transmissionIdentification"));

		transmissionExtruderIdentification = new TableColumn<>("Azonosító");
		transmissionExtruderIdentification.setMinWidth(50);
		transmissionExtruderIdentification.setCellValueFactory(
				new PropertyValueFactory<TransmissionFinished, String>("transmissionExtruderIdentification"));

		transmissionExtruderName = new TableColumn<>("Gyártó gép");
		transmissionExtruderName.setMinWidth(50);
		transmissionExtruderName.setCellValueFactory(
				new PropertyValueFactory<TransmissionFinished, String>("transmissionExtruderName"));

		transmissionDate = new TableColumn<>("Gyártás dátum");
		transmissionDate.setMinWidth(50);
		transmissionDate.setCellValueFactory(new PropertyValueFactory<TransmissionFinished, Date>("transmissionDate"));

		transmissionWorkerName = new TableColumn<>("Átadó neve");
		transmissionWorkerName.setMinWidth(50);
		transmissionWorkerName
				.setCellValueFactory(new PropertyValueFactory<TransmissionFinished, String>("transmissionWorkerName"));

		transmissionClientName = new TableColumn<>("Megrendelő");
		transmissionClientName.setMinWidth(50);
		transmissionClientName
				.setCellValueFactory(new PropertyValueFactory<TransmissionFinished, String>("transmissionClientName"));

		transmissionExtruderActualSize = new TableColumn<>("Termék");
		transmissionExtruderActualSize.setMinWidth(50);
		transmissionExtruderActualSize.setCellValueFactory(
				new PropertyValueFactory<TransmissionFinished, String>("transmissionExtruderActualSize"));

		transmissionBKg = new TableColumn<>("Bruttó tömeg");
		transmissionBKg.setMinWidth(50);
		transmissionBKg.setCellValueFactory(new PropertyValueFactory<TransmissionFinished, String>("transmissionBKg"));

		transmissionNKg = new TableColumn<>("Nettó tömeg");
		transmissionNKg.setMinWidth(50);
		transmissionNKg.setCellValueFactory(new PropertyValueFactory<TransmissionFinished, String>("transmissionNKg"));

		transmissionSpool = new TableColumn<>("Cséve szám");
		transmissionSpool.setMinWidth(50);
		transmissionSpool
				.setCellValueFactory(new PropertyValueFactory<TransmissionFinished, String>("transmissionSpool"));
	}

	public void setQuantityNumber(TextField textField, Label label) {

		textField.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					char ch = textField.getText().charAt(oldValue.intValue());
					if (!(ch >= '0' && ch <= '9')) {
						textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
						new MessageLabel().errorMessage("Nem megfelelő formátum!", label);
					}
				}
			}

		});
	}

	private void setData() {
		transmissionTxt.appendText("Ügyfél:            " + Transmission.getExtruderClientName() + "\n");
		transmissionTxt.appendText("Termék azonosító:       " + Transmission.getExtruderIdentification() + "\n");
		transmissionTxt.appendText("Termék:             " + Transmission.getExtruderActualSize() + "\n");
		transmissionTxt.appendText("Gyártó gép:         " + Transmission.getExtruderName() + "\n");
		transmissionTxt.appendText("Megrendelt kg:         " + Transmission.getExtruderorderKg() + "\n");
		setQuantityNumber(workerNameTxt, messageLbl);
		workerNameTxt.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(final ObservableValue<? extends String> ov, final String oldValue,
					final String newValue) {
				if (workerNameTxt.getText().length() >= 7) {
					workerNameTxt.setText(workerNameTxt.getText().substring(0, 7));
					workersData();
					if (workersData().size() != 0) {
						if (workersData().get(0).getWorkersStatus().equals("Aktív")) {
							transmissionTxt
									.appendText("Dolgozó:        " + workersData().get(0).getWorkersName() + "\n");
							workerNameTxt.setEditable(false);
							new MessageLabel().goodMessage("Nyomj egy Print gombot a mérlegen!!", messageLbl);
							// Mérleg adoptálás!!!
							startTask();

						} else {
							new MessageLabel().errorMessage("Nem aktív a dolgozó", messageLbl);
						}
					} else {
						new MessageLabel().errorMessage("Nincs ilyen dolgozó", messageLbl);
					}
				}
			}
		});
	}

	private void startTask() {
		// Create a Runnable
		Runnable task = new Runnable() {
			public void run() {
				runTask();
			}
		};
		// Run the task in a background thread
		Thread backgroundThread = new Thread(task);
		// Terminate the running thread if the application exits
		backgroundThread.setDaemon(true);
		// Start the thread
		backgroundThread.start();
	}

	private void runTask() {
		try {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					// Mérleg
					transmissionActualKgTxt.setText(actualKgRs232().toString());
					saveDataBase.setDisable(false);
					messageLbl.setText("");
					transmissionTxt.appendText("Mérleg súly:         " + transmissionActualKgTxt.getText() + "\n");
				}
			});
			Thread.sleep(3L * 1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	// RS232 Port
	private String actualKgRs232() {
		// Port Number setting!!!!!!!!!!
		SerialPort comPort = SerialPort.getCommPort("COM5");
		comPort.openPort();
		comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
		InputStream in = comPort.getInputStream();
		final StringBuilder sb = new StringBuilder();
		try {
			for (int j = 0; j < 10; ++j) {
				sb.append((char) in.read());
				in.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		comPort.closePort();
		String g =sb.substring(0, sb.indexOf("kg"));
		return g;
	}

	// adatbázis mentés
	@FXML
	private void saveDataBase() {
		if (checkTextField()) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String transmissionDate = dateFormat.format(date);
			double n_kg = Double.valueOf(transmissionActualKgTxt.getText()) - 18;
			String identification = Transmission.getExtruderIdentification() + "/L"
					+ String.valueOf(transmissionIdentification());
			transmissionTxt
					.appendText("Brutto kg:         " + Double.valueOf(transmissionActualKgTxt.getText()) + "\n");
			transmissionTxt.appendText("Netto kg:         " + n_kg + "\n");
			transmissionExtruderDataBase.addTransmission(new TransmissionFinished(
					Transmission.getExtruderIdentification(), identification, Transmission.getExtruderName(),
					transmissionDate, workersData().get(0).getWorkersName(), Transmission.getExtruderClientName(),
					Transmission.getExtruderActualSize(), Double.valueOf(transmissionActualKgTxt.getText()), n_kg, "1",
					Integer.valueOf(Transmission.getExtruderId())));

			// táblázat update
			transmissionFinishedData();
			allExtruderKg();
		}

	}

	private boolean checkTextField() {
		if (workerNameTxt.getText().trim().isEmpty() || transmissionActualKgTxt.getText().trim().isEmpty()) {
			return false;
		} else {
			return true;
		}

	}

	// Össz kg static pojo
	private void allExtruderKg() {
		orderKgLbl.setText(" / " + Transmission.getExtruderorderKg() + "kg");
		actualKgLbl.setText("->" + Transmission.getFinishedActualKg() + "kg");

	}

	// leadás anozosito
	private Integer transmissionIdentification() {
		if (transmissionFinishedData().size() != 0) {
			Integer g = Integer
					.valueOf(transmissionFinishedData().get(transmissionFinishedData().size() - 1).getTransmissionId());
			return g + 1;

		} else {
			return 1;
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		extruderTable();
		setColumn();
		transmissionFinishedData();
		transmissionFinishedTableView.setItems(dataTransmission);
		allExtruderKg();
		setData();
	}

}
