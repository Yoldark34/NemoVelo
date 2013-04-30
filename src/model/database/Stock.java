/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

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
		if (code.length() <= 128) {
			this.code = code;
		} else {
			System.out.println("The size of the code can't have a length > 128");
		}
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
			System.out.println("The size of the description can't have a length > 512");
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
