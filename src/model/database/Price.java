/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

/**
 *
 * @author Yoldark34 (yoldark@gmail.com)
 */
public class Price {

	private int id;
	private float amount;
	private String typeCode;
	private String name;
	private String description;
	private int priceDuration;
	private String priceDurationUnit;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name.length() <= 128) {
			this.name = name;
		} else {
			System.out.println("The size of the name can't have a length > 128");
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if (description.length() <= 512) {
			this.description = description;
		} else {
			System.out.println("The size of the description can't have a length > 128");
		}
	}

	public int getPriceDuration() {
		return priceDuration;
	}

	public void setPriceDuration(int priceDuration) {
		this.priceDuration = priceDuration;
	}

	public String getPriceDurationUnit() {
		return priceDurationUnit;
	}

	public void setPriceDurationUnit(String priceDurationUnit) {
		this.priceDurationUnit = priceDurationUnit;
	}
}
