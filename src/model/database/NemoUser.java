/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import java.sql.Date;

/**
 *
 * @author Yoldark34 (yoldark@gmail.com)
 */
public class NemoUser {

	private int id;
	private String lastName;
	private String firstName;
	private String email;
	private String cryptedPassword;
	private Date birthDate;
	private Date createDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName.length() <= 128) {
			this.lastName = lastName;
		} else {
			System.out.println("The size of the last name can't have a length > 128");
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName.length() <= 128) {
			this.firstName = firstName;
		} else {
			System.out.println("The size of the first name can't have a length > 128");
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email.length() <= 60) {
			this.email = email;
		} else {
			System.out.println("The size of the email can't have a length > 60");
		}
	}

	public String getCryptedPassword() {
		return cryptedPassword;
	}

	public void setCryptedPassword(String cryptedPassword) {
		if (cryptedPassword.length() <= 40) {
			this.cryptedPassword = cryptedPassword;
		} else {
			System.out.println("The size of the crypted password can't have a length > 40");
		}
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
