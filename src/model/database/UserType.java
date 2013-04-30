/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

/**
 *
 * @author Yoldark34 (yoldark@gmail.com)
 */
public class UserType {

	private int id;
	private int idParentUserType;
	private String code;
	private String name;
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdParentUserType() {
		return idParentUserType;
	}

	public void setIdParentUserType(int idParentUserType) {
		this.idParentUserType = idParentUserType;
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
		if (name.length() <= 20) {
			this.name = name;
		} else {
			System.out.println("The size of the name can't have a length > 20");
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
