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

	public NemoUser() {
	}

	public NemoUser(int id, String lastName, String firstName, String email, String cryptedPassword, Timestamp birthDate, Timestamp createDate) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.cryptedPassword = cryptedPassword;
		this.birthDate = birthDate;
		this.createDate = createDate;
	}

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
		if (lastName.length() <= DataBaseElements.SIZEOF_NEMOUSER_LASTNAME) {
			this.lastName = lastName;
		} else {
			ProjectLogger.log(this, Level.WARNING,
					String.format("The size of the last name can't have a length > %1$d", DataBaseElements.SIZEOF_NEMOUSER_LASTNAME));
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName.length() <= DataBaseElements.SIZEOF_NEMOUSER_FIRSTNAME) {
			this.firstName = firstName;
		} else {
			ProjectLogger.log(this, Level.WARNING,
					String.format("The size of the first name can't have a length > %1$d", DataBaseElements.SIZEOF_NEMOUSER_FIRSTNAME));
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email.length() <= DataBaseElements.SIZEOF_NEMOUSER_EMAIL) {
			this.email = email;
		} else {
			ProjectLogger.log(this, Level.WARNING,
					String.format("The size of the email can't have a length > %1$d", DataBaseElements.SIZEOF_NEMOUSER_EMAIL));
		}
	}

	public String getCryptedPassword() {
		return cryptedPassword;
	}

	public void setCryptedPassword(String cryptedPassword) {
		if (cryptedPassword.length() <= DataBaseElements.SIZEOF_NEMOUSER_CRYPTEDPASSWORD) {
			this.cryptedPassword = cryptedPassword;
		} else {
			ProjectLogger.log(this, Level.WARNING,
					String.format("The size of the crypted password can't have a length > %1$d", DataBaseElements.SIZEOF_NEMOUSER_CRYPTEDPASSWORD));
		}
	}

	public Timestamp getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Timestamp birthDate) {
		this.birthDate = birthDate;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
}
