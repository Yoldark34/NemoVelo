/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.object;

import java.util.logging.Level;
import model.database.DataBaseElements;
import resource.log.ProjectLogger;

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

	/**
	 * getId
	 *
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * setId
	 *
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * getAmount
	 *
	 * @return
	 */
	public float getAmount() {
		return amount;
	}

	/**
	 * setAmount
	 *
	 * @param amount
	 */
	public void setAmount(float amount) {
		this.amount = amount;
	}

	/**
	 * getTypeCode
	 *
	 * @return
	 */
	public String getTypeCode() {
		return typeCode;
	}

	/**
	 * setTypeCode
	 *
	 * @param typeCode
	 */
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	/**
	 * getName
	 *
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * setName
	 *
	 * @param name
	 */
	public void setName(String name) {
		if (name.length() <= DataBaseElements.SIZEOF_PRICE_NAME) {
			this.name = name;
		} else {
			ProjectLogger.log(this, Level.WARNING,
					String.format("The size of the name can't have a length > %1$d", DataBaseElements.SIZEOF_PRICE_NAME));
		}
	}

	/**
	 * getDescription
	 *
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * setDescription
	 *
	 * @param description
	 */
	public void setDescription(String description) {
		if (description.length() <= DataBaseElements.SIZEOF_PRICE_DESCRIPTION) {
			this.description = description;
		} else {
			ProjectLogger.log(this, Level.WARNING,
					String.format("The size of the description can't have a length > %1$d", DataBaseElements.SIZEOF_PRICE_DESCRIPTION));
		}
	}

	/**
	 * getPriceDuration
	 *
	 * @return
	 */
	public int getPriceDuration() {
		return priceDuration;
	}

	/**
	 * setPriceDuration
	 *
	 * @param priceDuration
	 */
	public void setPriceDuration(int priceDuration) {
		this.priceDuration = priceDuration;
	}

	/**
	 * getPriceDurationUnit
	 *
	 * @return
	 */
	public String getPriceDurationUnit() {
		return priceDurationUnit;
	}

	/**
	 * setPriceDurationUnit
	 *
	 * @param priceDurationUnit
	 */
	public void setPriceDurationUnit(String priceDurationUnit) {
		this.priceDurationUnit = priceDurationUnit;
	}
}
