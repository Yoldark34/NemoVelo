/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.terminal.controller;

/**
 *
 * @author Valentin SEITZ
 */
public class PayAmount {

	private int duration;
	private String durationUnit;
	private float durationPricePerUnit;
	private int bikeQuantity;
	private float guaranteePerBikeAmount;
	private float multiplier = 1;

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setDurationUnit(String durationUnit) {
		this.durationUnit = durationUnit;
	}

	public void setDurationPricePerUnit(float durationPricePerUnit) {
		this.durationPricePerUnit = durationPricePerUnit;
	}

	public void setBikeQuantity(int bikeQuantity) {
		this.bikeQuantity = bikeQuantity;
	}

	public void setGuaranteePerBikeAmount(float guaranteePerBikeAmount) {
		this.guaranteePerBikeAmount = guaranteePerBikeAmount;
	}

	public int getDuration() {
		return duration;
	}

	public String getDurationUnit() {
		return durationUnit;
	}

	public float getDurationPricePerUnit() {
		return durationPricePerUnit;
	}

	public int getBikeQuantity() {
		return bikeQuantity;
	}

	public float getRentAmount() {
		return getDurationPricePerUnit() * getBikeQuantity() * multiplier;
	}

	public float getGuaranteeAmount() {
		return guaranteePerBikeAmount * getBikeQuantity();
	}

	public float getTotalAmount() {
		return getRentAmount() + getGuaranteeAmount();
	}

	public float getMultiplier() {
		return multiplier;
	}

	public void setMultiplier(float multiplier) {
		this.multiplier = multiplier;
	}
}
