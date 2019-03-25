package com.main.leextruder;

public class LeExtruder {

	private String nnKg;

	public String getNnKg() {
		nnKg = NNKgRandom.generateNNkg();
		return nnKg;
	}

	public void setNnKg(String nnKg) {
		this.nnKg = nnKg;
	}
}
