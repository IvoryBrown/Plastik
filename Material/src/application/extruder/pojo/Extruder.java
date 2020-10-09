package application.extruder.pojo;

import javafx.beans.property.SimpleStringProperty;

public class Extruder {

	private final SimpleStringProperty extruderId;
	private final SimpleStringProperty extruderClientId;
	private final SimpleStringProperty extruderClientName;
	private final SimpleStringProperty extruderIdentification;
	private final SimpleStringProperty extruderProduct;
	private final SimpleStringProperty extruderProductType;
	private final SimpleStringProperty extruderProductGramm;
	private final SimpleStringProperty extruderStatus;
	private final SimpleStringProperty extruderAddDate;
	private final SimpleStringProperty extruderEndDate;
	private final SimpleStringProperty extruderOrderedKg;
	private final SimpleStringProperty extruderActualKg;
	private final SimpleStringProperty extruderName;
	private final SimpleStringProperty extruderComment;
	private final SimpleStringProperty extruderPriority;

	public Extruder() {
		this.extruderId = new SimpleStringProperty(String.valueOf(""));
		this.extruderClientId = new SimpleStringProperty(String.valueOf(""));
		this.extruderClientName = new SimpleStringProperty("");
		this.extruderIdentification = new SimpleStringProperty("");
		this.extruderStatus = new SimpleStringProperty("");
		this.extruderAddDate = new SimpleStringProperty("");
		this.extruderEndDate = new SimpleStringProperty("");
		this.extruderOrderedKg = new SimpleStringProperty("");
		this.extruderActualKg = new SimpleStringProperty("");
		this.extruderName = new SimpleStringProperty("");
		this.extruderComment = new SimpleStringProperty("");
		this.extruderPriority = new SimpleStringProperty("");
	}

	public SimpleStringProperty getExtruderIdProperty() {
		return this.extruderId;
	}

	public String getExtruderId() {
		return this.extruderId.get();
	}

	public void setExtruderId(String extruderId) {
		this.extruderId.set(extruderId);
	}

	public SimpleStringProperty getExtruderClientIdProperty() {
		return this.extruderClientId;
	}

	public String getExtruderClientId() {
		return this.extruderClientId.get();
	}

	public void setExtruderClientId(String extruderClientId) {
		this.extruderClientId.set(extruderClientId);
	}

	public SimpleStringProperty getExtruderClientNameProperty() {
		return this.extruderClientName;
	}

	public String getExtruderClientName() {
		return this.extruderClientName.get();
	}

	public void setExtruderClientName(String extruderClientName) {
		this.extruderClientName.set(extruderClientName);
	}

	public SimpleStringProperty getExtruderIdentificationProperty() {
		return this.extruderIdentification;
	}

	public String getExtruderIdentification() {
		return this.extruderIdentification.get();
	}

	public void setExtruderIdentification(String extruderIdentification) {
		this.extruderIdentification.set(extruderIdentification);
	}

	public SimpleStringProperty getExtruderStatusProperty() {
		return this.extruderStatus;
	}

	public String getExtruderStatus() {
		return this.extruderStatus.get();
	}

	public void setExtruderStatus(String extruderStatus) {
		this.extruderStatus.set(extruderStatus);
	}

	public SimpleStringProperty getExtruderAddDateProperty() {
		return this.extruderAddDate;
	}

	public String getExtruderAddDate() {
		return this.extruderAddDate.get();
	}

	public void setExtruderAddDate(String extruderAddDate) {
		this.extruderAddDate.set(extruderAddDate);
	}

	public SimpleStringProperty getExtruderEndDateProperty() {
		return this.extruderEndDate;
	}

	public String getExtruderEndDate() {
		return this.extruderEndDate.get();
	}

	public void setExtruderEndDate(String extruderEndDate) {
		this.extruderEndDate.set(extruderEndDate);
	}

	public SimpleStringProperty getExtruderOrderedKgProperty() {
		return this.extruderOrderedKg;
	}

	public String getExtruderOrderedKg() {
		return this.extruderOrderedKg.get();
	}

	public void setExtruderOrderedKg(String extruderOrderedKg) {
		this.extruderOrderedKg.set(extruderOrderedKg);
	}

	public SimpleStringProperty getExtruderActualKgProperty() {// todo
		return this.extruderActualKg;
	}

//public String getExtruderActualKg() {
//
//	String f = null;
//	double sum = 0;
//	ObservableList<TransmissionExtruder> dataExtruder = FXCollections.observableArrayList();
//	dataExtruder.addAll(new TransmissionExtruderDataBase().getAllClient(Integer.parseInt(extruderId.get())));
//	if (dataExtruder.size() != 0) {
//		for (int i = 0; i < dataExtruder.size(); i++) {
//			double g = Double.valueOf(dataExtruder.get(i).getTransmissionNKg());
//			sum += g;
//		}
//	}
//	double n_kg1 = Math.round(sum * 1e2) / 1e2;
//	f = String.valueOf(n_kg1);
//	return f;
//}

	public void setExtruderActualKg(String extruderActualKg) {
		this.extruderActualKg.set(extruderActualKg);
	}

	public SimpleStringProperty getExtruderNameProperty() {
		return this.extruderName;
	}

	public String getExtruderName() {
		return this.extruderName.get();
	}

	public void setExtruderName(String extruderName) {
		this.extruderName.set(extruderName);
	}

	public SimpleStringProperty getExtruderCommentProperty() {
		return this.extruderComment;
	}

	public String getExtruderComment() {
		return this.extruderComment.get();
	}

	public void setExtruderComment(String extruderComment) {
		this.extruderComment.set(extruderComment);
	}

	public SimpleStringProperty getExtruderPriorityProperty() {
		return this.extruderPriority;
	}

	public String getExtruderPriority() {
		return this.extruderPriority.get();
	}

	public void setExtruderPriority(String extruderPriority) {
		this.extruderPriority.set(extruderPriority);
	}
}
