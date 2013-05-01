/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yoldark34 (yoldark@gmail.com)
 */
public class Stock {

	private int id;
	private String code;
	private String name;
	private String description;
	private float latitude;
	private float longitude;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		if (code.length() <= DataBaseElements.SIZEOF_STOCK_CODE) {
			this.code = code;
		} else {
			Logger.getLogger(Stock.class.getName()).log(Level.WARNING,
					String.format("The size of the code can't have a length > %1$d", DataBaseElements.SIZEOF_STOCK_CODE));
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name.length() <= DataBaseElements.SIZEOF_STOCK_NAME) {
			this.name = name;
		} else {
			Logger.getLogger(Stock.class.getName()).log(Level.WARNING,
					String.format("The size of the name can't have a length > %1$d", DataBaseElements.SIZEOF_STOCK_NAME));
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if (description.length() <= DataBaseElements.SIZEOF_STOCK_DESCRIPTION) {
			this.description = description;
		} else {
			Logger.getLogger(Stock.class.getName()).log(Level.WARNING,
					String.format("The size of the description can't have a length > %1$d", DataBaseElements.SIZEOF_STOCK_DESCRIPTION));
		}
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
}
