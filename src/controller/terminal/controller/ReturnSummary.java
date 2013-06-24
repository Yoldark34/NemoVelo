/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.terminal.controller;

import java.util.ArrayList;

/**
 *
 * @author Valentin SEITZ
 */
public class ReturnSummary extends ArrayList<BikeReturnSummary> {

	private float guaranteePerBike;

	public float supplementAmount() {
		float supplement = 0;
		for (BikeReturnSummary bikeSummary : this) {
			supplement += bikeSummary.getAmountToPay();
		}
		return supplement;
	}

	public void setGuaranteePerBike(float guaranteePerBike) {
		this.guaranteePerBike = guaranteePerBike;
	}

	public float guaranteeAmount() {
		return guaranteePerBike * this.size();
	}
}
