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
		if (code.length() <= DataBaseElements.SIZEOF_USERTYPE_CODE) {
			this.code = code;
		} else {
			ProjectLogger.log(this, Level.WARNING,
					String.format("The size of the code can't have a length > %1$d", DataBaseElements.SIZEOF_USERTYPE_CODE));
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name.length() <= DataBaseElements.SIZEOF_USERTYPE_NAME) {
			this.name = name;
		} else {
			ProjectLogger.log(this, Level.WARNING,
					String.format("The size of the name can't have a length > %1$s", DataBaseElements.SIZEOF_USERTYPE_NAME));
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
