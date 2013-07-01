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
public class Contact {

	private int id;
	private int streetNumber;
	private String streetName;
	private String zipCode;
	private String city;
	private String country;
	private String phoneNumber;

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
	 * getStreetNumber
	 *
	 * @return
	 */
	public int getStreetNumber() {
		return streetNumber;
	}

	/**
	 * setStreetNumber
	 *
	 * @param streetNumber
	 */
	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	/**
	 * getStreetName
	 *
	 * @return
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * setStreetName
	 *
	 * @param streetName
	 */
	public void setStreetName(String streetName) {
		if (streetName.length() <= DataBaseElements.SIZEOF_CONTACT_STREETNAME) {
			this.streetName = streetName;
		} else {
			ProjectLogger.log(this, Level.WARNING,
					String.format("The size of the street name can't have a length > %1$d", DataBaseElements.SIZEOF_CONTACT_STREETNAME));
		}
	}

	/**
	 * getZipCode
	 *
	 * @return
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * setZipCode
	 *
	 * @param zipCode
	 */
	public void setZipCode(String zipCode) {
		if (zipCode.length() <= DataBaseElements.SIZEOF_CONTACT_ZIPCODE) {
			this.zipCode = zipCode;
		} else {
			ProjectLogger.log(this, Level.WARNING,
					String.format("The size of the zip code can't have a length > %1$d", DataBaseElements.SIZEOF_CONTACT_ZIPCODE));
		}
	}

	/**
	 * getCity
	 *
	 * @return
	 */
	public String getCity() {
		return city;
	}

	/**
	 * setCity
	 *
	 * @param city
	 */
	public void setCity(String city) {
		if (city.length() <= DataBaseElements.SIZEOF_CONTACT_CITY) {
			this.city = city;
		} else {
			ProjectLogger.log(this, Level.WARNING,
					String.format("The size of the city can't have a length > %1$d", DataBaseElements.SIZEOF_CONTACT_CITY));
		}
	}

	/**
	 * getCountry
	 *
	 * @return
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * setCountry
	 *
	 * @param country
	 */
	public void setCountry(String country) {
		if (country.length() <= DataBaseElements.SIZEOF_CONTACT_COUNTRY) {
			this.country = country;
		} else {
			ProjectLogger.log(this, Level.WARNING,
					String.format("The size of the country can't have a length > %1$d", DataBaseElements.SIZEOF_CONTACT_COUNTRY));
		}
	}

	/**
	 * getPhoneNumber
	 *
	 * @return
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * setPhoneNumber
	 *
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
