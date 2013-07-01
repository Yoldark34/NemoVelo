/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.object;

import java.sql.Timestamp;
import java.util.logging.Level;
import model.database.DataBaseElements;
import resource.log.ProjectLogger;

/**
 *
 * @author Yoldark34 (yoldark@gmail.com)
 */
public class NemoUser {

	private int id = -1;
	private String lastName;
	private String firstName;
	private String email;
	private String cryptedPassword;
	private Timestamp birthDate;
	private Timestamp createDate;

	/**
	 * constructor
	 */
	public NemoUser() {
	}

	/**
	 * constructor
	 *
	 * @param id
	 * @param lastName
	 * @param firstName
	 * @param email
	 * @param cryptedPassword
	 * @param birthDate
	 * @param createDate
	 */
	public NemoUser(int id, String lastName, String firstName, String email, String cryptedPassword, Timestamp birthDate, Timestamp createDate) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.cryptedPassword = cryptedPassword;
		this.birthDate = birthDate;
		this.createDate = createDate;
	}

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
	 * getLastName
	 *
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * setLastName
	 *
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		if (lastName.length() <= DataBaseElements.SIZEOF_NEMOUSER_LASTNAME) {
			this.lastName = lastName;
		} else {
			ProjectLogger.log(this, Level.WARNING,
					String.format("The size of the last name can't have a length > %1$d", DataBaseElements.SIZEOF_NEMOUSER_LASTNAME));
		}
	}

	/**
	 * getFirstName
	 *
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * setFirstName
	 *
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		if (firstName.length() <= DataBaseElements.SIZEOF_NEMOUSER_FIRSTNAME) {
			this.firstName = firstName;
		} else {
			ProjectLogger.log(this, Level.WARNING,
					String.format("The size of the first name can't have a length > %1$d", DataBaseElements.SIZEOF_NEMOUSER_FIRSTNAME));
		}
	}

	/**
	 * getEmail
	 *
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * setEmail
	 *
	 * @param email
	 */
	public void setEmail(String email) {
		if (email.length() <= DataBaseElements.SIZEOF_NEMOUSER_EMAIL) {
			this.email = email;
		} else {
			ProjectLogger.log(this, Level.WARNING,
					String.format("The size of the email can't have a length > %1$d", DataBaseElements.SIZEOF_NEMOUSER_EMAIL));
		}
	}

	/**
	 * getCryptedPassword
	 *
	 * @return
	 */
	public String getCryptedPassword() {
		return cryptedPassword;
	}

	/**
	 * setCryptedPassword
	 *
	 * @param cryptedPassword
	 */
	public void setCryptedPassword(String cryptedPassword) {
		if (cryptedPassword.length() <= DataBaseElements.SIZEOF_NEMOUSER_CRYPTEDPASSWORD) {
			this.cryptedPassword = cryptedPassword;
		} else {
			ProjectLogger.log(this, Level.WARNING,
					String.format("The size of the crypted password can't have a length > %1$d", DataBaseElements.SIZEOF_NEMOUSER_CRYPTEDPASSWORD));
		}
	}

	/**
	 * getBirthDate
	 *
	 * @return
	 */
	public Timestamp getBirthDate() {
		return birthDate;
	}

	/**
	 * setBirthDate
	 *
	 * @param birthDate
	 */
	public void setBirthDate(Timestamp birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * getCreateDate
	 *
	 * @return
	 */
	public Timestamp getCreateDate() {
		return createDate;
	}

	/**
	 * setCreateDate
	 *
	 * @param createDate
	 */
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
}
