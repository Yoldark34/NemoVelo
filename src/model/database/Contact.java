/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

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
		if (streetName.length() <= 128) {
			this.streetName = streetName;
		} else {
			System.out.println("The size of the street name can't have a length > 128");
		}
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		if (zipCode.length() <= 5) {
			this.zipCode = zipCode;
		} else {
			System.out.println("The size of the zip code can't have a length > 5");
		}
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		if (city.length() <= 128) {
			this.city = city;
		} else {
			System.out.println("The size of the city can't have a length > 128");
		}
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		if (country.length() <= 128) {
			this.country = country;
		} else {
			System.out.println("The size of the country can't have a length > 128");
		}
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
