/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.object;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.database.DataBaseElements;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		if (streetName.length() <= DataBaseElements.SIZEOF_CONTACT_STREETNAME) {
			this.streetName = streetName;
		} else {
			Logger.getLogger(Contact.class.getName()).log(Level.WARNING,
					String.format("The size of the street name can't have a length > %1$d", DataBaseElements.SIZEOF_CONTACT_STREETNAME));
		}
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		if (zipCode.length() <= DataBaseElements.SIZEOF_CONTACT_ZIPCODE) {
			this.zipCode = zipCode;
		} else {
			Logger.getLogger(Contact.class.getName()).log(Level.WARNING,
					String.format("The size of the zip code can't have a length > %1$d", DataBaseElements.SIZEOF_CONTACT_ZIPCODE));
		}
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		if (city.length() <= DataBaseElements.SIZEOF_CONTACT_CITY) {
			this.city = city;
		} else {
			Logger.getLogger(Contact.class.getName()).log(Level.WARNING,
					String.format("The size of the city can't have a length > %1$d", DataBaseElements.SIZEOF_CONTACT_CITY));
		}
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		if (country.length() <= DataBaseElements.SIZEOF_CONTACT_COUNTRY) {
			this.country = country;
		} else {
			Logger.getLogger(Contact.class.getName()).log(Level.WARNING,
					String.format("The size of the country can't have a length > %1$d", DataBaseElements.SIZEOF_CONTACT_COUNTRY));
		}
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
