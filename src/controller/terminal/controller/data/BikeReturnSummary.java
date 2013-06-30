/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.terminal.controller.data;

/**
 *
 * @author Valentin SEITZ
 */
public class BikeReturnSummary {

	private int serialNumber;
	private int initialDuration;
	private String initialDurationUnit;
	private float initialAmount;
	private int finalDuration;
	private String finalDurationUnit;
	private float finalAmount;

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public int getInitialDuration() {
		return initialDuration;
	}

	public void setInitialDuration(int initialDuration) {
		this.initialDuration = initialDuration;
	}

	public String getInitialDurationUnit() {
		return initialDurationUnit;
	}

	public void setDurationUnit(String durationUnit) {
		this.finalDurationUnit = durationUnit;
		this.initialDurationUnit = durationUnit;
	}

	public float getInitialAmount() {
		return initialAmount;
	}

	public void setInitialAmount(float initialAmount) {
		this.initialAmount = initialAmount;
	}

	public int getFinalDuration() {
		return finalDuration;
	}

	public void setFinalDuration(int finalDuration) {
		this.finalDuration = finalDuration;
	}

	public String getFinalDurationUnit() {
		return finalDurationUnit;
	}

	public float getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(float finalAmount) {
		this.finalAmount = finalAmount;
	}

	public float getAmountToPay() {
		return Math.max(0, getFinalAmount() - getInitialAmount());
	}
}
