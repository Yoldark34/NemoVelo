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
public class RentSummary extends ArrayList<BikeRentSummmary> {

	public float supplementToPay() {
		float supplement = 0;
		for (BikeRentSummmary bikeSummary : this) {
			supplement += bikeSummary.getAmountToPay();
		}
		return supplement;
	}
}
