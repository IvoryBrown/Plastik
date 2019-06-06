package com.production.transmissionfinished.extruder.controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

import com.fazecast.jSerialComm.SerialPort;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.production.transmissionfinished.extruder.database.TransmissionExtruderDataBase;
import com.production.transmissionfinished.extruder.pojo.Transmission;
import com.production.transmissionfinished.extruder.pojo.TransmissionExtruder;
import com.production.transmissionfinished.extruder.pojo.TransmissionFinished;
import com.project.setting.worker.database.WorkersDataBase;
import com.project.setting.worker.pojo.Workers;
import com.setting.label.MessageLabel;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Scale;
import javafx.stage.StageStyle;
import javafx.util.Callback;

public class TransmissionFinishedController implements Initializable {
	@FXML
	private TableView<TransmissionFinished> transmissionFinishedTableView;
	private TableColumn<TransmissionFinished, Integer> transmissionId, extruderId;
	private TableColumn<TransmissionFinished, String> transmissionExtruderIdentification, transmissionIdentification,
			transmissionExtruderName, transmissionWorkerName, transmissionClientName, transmissionExtruderActualSize,
			transmissionBKg, transmissionNKg, transmissionSpool, removeCol;
	private TableColumn<TransmissionFinished, Date> transmissionDate;
	@FXML
	private Label orderKgLbl, actualKgLbl, messageLbl;
	@FXML
	private TextField workerNameTxt, transmissionActualKgTxt, maxKgPrintTxt, minKgPrintTxt, printSpoolTxt;
	@FXML
	private TextArea transmissionTxt;
	@FXML
	private Button saveDataBase, printButton;
	@FXML
	private AnchorPane printPane;
	@FXML
	private ImageView imageView, imageView1;
	@FXML
	private Label printClientNameLbl, printIdentificationLbl, printActualSizeLbl, printOrderKgLbl, printExtruderNameLbl,
			printBKgLbl, printNnKgLbl, printSpoolLbl, printWorkerNameLbl, printDateLbl;

	private TransmissionExtruderDataBase transmissionExtruderDataBase = new TransmissionExtruderDataBase();
	private final ObservableList<TransmissionFinished> dataTransmission = FXCollections.observableArrayList();

	private final ObservableList<Workers> dataWorkers = FXCollections.observableArrayList();
	private WorkersDataBase workersDB = new WorkersDataBase();

	private final ObservableList<TransmissionExtruder> dataBrutto = FXCollections.observableArrayList();

	private String bruttoKg = null;

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
				transmissionExtruderActualSize, extruderId, removeCol);
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

		removeCol = new TableColumn<TransmissionFinished, String>("Törlés");

		Callback<TableColumn<TransmissionFinished, String>, TableCell<TransmissionFinished, String>> cellFactory = new Callback<TableColumn<TransmissionFinished, String>, TableCell<TransmissionFinished, String>>() {
			@Override
			public TableCell<TransmissionFinished, String> call(final TableColumn<TransmissionFinished, String> param) {
				final TableCell<TransmissionFinished, String> cell = new TableCell<TransmissionFinished, String>() {
					private final Button btn = new Button();

					@Override
					public void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						btn.getStylesheets().add("/com/main/view/css/button.css");
						btn.getStyleClass().add("deleteButton");
						btn.setMinSize(40, 25);
						if (empty) {
							setGraphic(null);
							setText(null);
						} else {
							btn.setOnAction((ActionEvent event) -> {
								Alert alert = new Alert(Alert.AlertType.NONE, "Biztos töröltetni szeretnéd?",
										ButtonType.YES, ButtonType.NO);
								alert.getDialogPane().getStylesheets().add("/com/setting/showinfo/ShowInfo.css");
								alert.initStyle(StageStyle.TRANSPARENT);
								if (alert.showAndWait().orElse(ButtonType.NO) == ButtonType.YES) {
									TransmissionFinished transmissionFinished = getTableView().getItems()
											.get(getIndex());
									transmissionExtruderDataBase.removeTransmissionFinished(transmissionFinished);
									transmissionFinishedData();

								}
							});
							setGraphic(btn);
							setText(null);
						}
					}
				};
				return cell;
			}
		};
		removeCol.setCellFactory(cellFactory);

		transmissionFinishedTableView.setRowFactory(ts -> new TableRow<TransmissionFinished>() {
			@Override
			public void updateItem(TransmissionFinished item, boolean empty) {
				super.updateItem(item, empty);

				if (item == null) {
					setStyle("");
				} else {
					setStyle("");
					if (item.getExtruderDelete()) {
						setStyle("-fx-text-background-color: red;");
					} else {
						setStyle("-fx-text-background-color: whitesmoke;");

					}

				}
			}
		});

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

	// area feltoltes
	private void transmissionTxt() {
		transmissionTxt.appendText("Ügyfél:            " + Transmission.getExtruderClientName() + "\n");
		transmissionTxt.appendText("Termék azonosító:       " + Transmission.getExtruderIdentification() + "\n");
		transmissionTxt.appendText("Termék:             " + Transmission.getExtruderActualSize() + "\n");
		transmissionTxt.appendText("Gyártó gép:         " + Transmission.getExtruderName() + "\n");
		transmissionTxt.appendText("Megrendelt kg:         " + Transmission.getExtruderorderKg() + "\n");

	}

	private void setData() {
		transmissionTxt();
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
		String g = sb.substring(0, sb.indexOf("kg"));
		return g;
	}

	// adatbázis mentés
	@FXML
	private void saveDataBase() {
		if (checkTextField()) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String transmissionDate = dateFormat.format(date);
			double n_kg = Double.valueOf(transmissionActualKgTxt.getText()) - 2;
			// double kerekites
			double n_kg1 = Math.round(n_kg * 1e2) / 1e2;
			String identification = Transmission.getExtruderIdentification() + "/L"
					+ String.valueOf(transmissionIdentification());
			transmissionTxt
					.appendText("Brutto kg:         " + Double.valueOf(transmissionActualKgTxt.getText()) + "\n");
			transmissionTxt.appendText("Netto kg:         " + n_kg1 + "\n");
			transmissionExtruderDataBase.addTransmission(new TransmissionFinished(
					Transmission.getExtruderIdentification(), identification, Transmission.getExtruderName(),
					transmissionDate, workersData().get(0).getWorkersName(), Transmission.getExtruderClientName(),
					Transmission.getExtruderActualSize(), Double.valueOf(transmissionActualKgTxt.getText()), n_kg1, "1",
					Integer.valueOf(Transmission.getExtruderId())));
			// 0 fell kell venni !!!!!!!!!!!!!!!!!!!!!!!!!
			// táblázat update
			transmissionFinishedData();
			allExtruderKg();
			clearDataText();
		}

	}

	private void clearDataText() {
		workerNameTxt.setEditable(true);
		saveDataBase.setDisable(true);
		transmissionTxt.clear();
		workerNameTxt.clear();
		transmissionActualKgTxt.clear();
		transmissionTxt();
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

	// print number check
	private boolean checkPrintNumber() {
		if (maxKgPrintTxt.getText().trim().isEmpty()) {
			maxKgPrintTxt.setStyle(" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;");
		} else {
			maxKgPrintTxt.setStyle(null);
		}
		if (minKgPrintTxt.getText().trim().isEmpty()) {
			minKgPrintTxt.setStyle(" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;");
		} else {
			minKgPrintTxt.setStyle(null);
		}
		if (printSpoolTxt.getText().trim().isEmpty()) {
			printSpoolTxt.setStyle(" -fx-text-box-border: #CD5C5C; -fx-focus-color: #CD5C5C;");
		} else {
			printSpoolTxt.setStyle(null);
		}
		if (maxKgPrintTxt.getText().trim().isEmpty() || minKgPrintTxt.getText().trim().isEmpty()
				|| printSpoolTxt.getText().trim().isEmpty()) {

			return false;
		} else {

			return true;
		}

	}

	// print number formatum check
	private void checkNumberFormat() {
		setQuantityNumber(printSpoolTxt, messageLbl);
		setQuantityNumber(minKgPrintTxt, messageLbl);
		setQuantityNumber(maxKgPrintTxt, messageLbl);
	}

	// Print button
	@FXML
	private void printButton() {

		print(printPane);

	}

	// print Pane
	private void print(Node node) {
		// set print Label and Pane visible
		if (checkPrintNumber()) {
			setPrintLabel();
			if (dataBrutto.size() == Integer.valueOf(printSpoolTxt.getText())) {

				printPane.setVisible(true);
				Printer printer = Printer.getDefaultPrinter();
				PageLayout pageLayout = printer.createPageLayout(Paper.A4, PageOrientation.PORTRAIT,
						Printer.MarginType.HARDWARE_MINIMUM);
				PrinterJob job = PrinterJob.createPrinterJob();
				double scaleX = pageLayout.getPrintableWidth() / node.getBoundsInParent().getWidth();
				double scaleY = pageLayout.getPrintableHeight() / node.getBoundsInParent().getHeight();
				Scale scale = new Scale(scaleX, scaleY);
				node.getTransforms().add(scale);

				if (job != null) {
					// QR code general
					qRCodeWriter();
					boolean success = job.printPage(pageLayout, node);
					if (success) {
						job.endJob();
					}
				}
				node.getTransforms().remove(scale);
				printPane.setVisible(false);
				clearPrintLabel();
				new MessageLabel().goodMessage("Sikeres nyomtatás", messageLbl);
			} else {
				new MessageLabel().errorMessage("Cséve szám nem egyezik mega darab számmal!!", messageLbl);
			}
		} else {
			new MessageLabel().errorMessage("Nem lehet üres a mező", messageLbl);
		}
	}

	// print page set label A/4
	private void setPrintLabel() {
		printClientNameLbl.setText(Transmission.getExtruderClientName());
		printIdentificationLbl.setText(Transmission.getExtruderIdentification());
		printActualSizeLbl.setText(Transmission.getExtruderActualSize());
		printOrderKgLbl.setText(Transmission.getExtruderorderKg() + " kg");
		printExtruderNameLbl.setText(Transmission.getExtruderName());
		printBKgData();
		bruttoKg = printLabelBKg();
		printBKgLbl.setText(bruttoKg + " kg");
		printNnKgLbl.setText(converterBKgToNkg() + " kg");
		printSpoolLbl.setText(printSpoolTxt.getText() + " db");
		printWorkerNameLbl.setText(
				transmissionFinishedData().get(transmissionFinishedData().size() - 1).getTransmissionWorkerName());
		printDateLbl.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
	}

	// print brutto list
	private ObservableList<TransmissionExtruder> printBKgData() {
		dataBrutto.clear();
		dataBrutto.addAll(transmissionExtruderDataBase.getTransmisionLabelNKg(Transmission.getExtruderId(),
				minKgPrintTxt.getText(), maxKgPrintTxt.getText()));
		return dataBrutto;

	}

	// label brutto kg szam.
	private String printLabelBKg() {
		String f = null;
		double sum = 0;
		for (int i = 0; i < dataBrutto.size(); i++) {
			double g = Double.valueOf(dataBrutto.get(i).getTransmissionBKg());
			sum += g;
		}
		double n_kg1 = Math.round(sum * 1e2) / 1e2;
		f = String.valueOf(n_kg1);
		return f;
	}

	// brutto netto sum
	private String converterBKgToNkg() {
		double bKg = Double.valueOf(bruttoKg);
		double nKg = bKg - 18;

		return String.valueOf(nKg);
	}

	// clear label text
	private void clearPrintLabel() {
		printClientNameLbl.setText("");
		printIdentificationLbl.setText("");
		printActualSizeLbl.setText("");
		printOrderKgLbl.setText("");
		printExtruderNameLbl.setText("");
		printBKgLbl.setText("");
	}

	// QR code generator
	private void qRCodeWriter() {

		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		String myWeb = "GI-PLAST Kft. -- > Megrendelő: " + printClientNameLbl.getText() + "; Azonosító: "
				+ printIdentificationLbl.getText() + "; Termék adatok: " + printActualSizeLbl.getText()
				+ "; Rendelt mennyiség: " + printOrderKgLbl.getText() + " kg; Gép azonosító: "
				+ printExtruderNameLbl.getText() + "; " + "Bruttó súly: " + printBKgLbl.getText() + " kg; Nettó súly: "
				+ printNnKgLbl.getText() + " kg; Cséveszám: " + printSpoolLbl.getText() + " db; Átadó neve: "
				+ printWorkerNameLbl.getText() + "; " + printDateLbl.getText();
		int width = 300;
		int height = 300;

		BufferedImage bufferedImage = null;
		try {
			BitMatrix byteMatrix = qrCodeWriter.encode(myWeb, BarcodeFormat.QR_CODE, width, height);
			bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			bufferedImage.createGraphics();

			Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
			graphics.setColor(Color.WHITE);
			graphics.fillRect(0, 0, width, height);
			graphics.setColor(Color.BLACK);

			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					if (byteMatrix.get(i, j)) {
						graphics.fillRect(i, j, 1, 1);
					}
				}
			}

		} catch (WriterException ex) {
		}
		imageView1.setImage(SwingFXUtils.toFXImage(bufferedImage, null));
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		extruderTable();
		setColumn();
		transmissionFinishedData();
		transmissionFinishedTableView.setItems(dataTransmission);
		allExtruderKg();
		setData();
		checkNumberFormat();
		Image image = new Image("/xxxx/logo.jpg");
		imageView.setImage(image);

	}

}
