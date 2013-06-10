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
	private int durationPricePerUnit;
	private int globalReduce;

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getDurationUnit() {
		return durationUnit;
	}

	public void setDurationUnit(String durationUnit) {
		this.durationUnit = durationUnit;
	}

	public int getDurationPricePerUnit() {
		return durationPricePerUnit;
	}

	public void setDurationPricePerUnit(int durationPricePerUnit) {
		this.durationPricePerUnit = durationPricePerUnit;
	}

	public int getGlobalReduce() {
		return globalReduce;
	}

	public void setGlobalReduce(int globalReduce) {
		this.globalReduce = globalReduce;
	}

	public int getFinalPrice() {
		return getDuration() * getDurationPricePerUnit() - getGlobalReduce();
	}
}
