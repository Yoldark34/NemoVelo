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
public class StorageType {

	private int id;
	private String code;
	private String name;
	private String description;

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
	 * getCode
	 *
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * setCode
	 *
	 * @param code
	 */
	public void setCode(String code) {
		if (code.length() <= DataBaseElements.SIZEOF_STORAGETYPE_CODE) {
			this.code = code;
		} else {
			ProjectLogger.log(this, Level.WARNING,
					String.format("The size of the code can't have a length > %1$d", DataBaseElements.SIZEOF_STORAGETYPE_CODE));
		}
	}

	/**
	 * getName
	 *
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * setName
	 *
	 * @param name
	 */
	public void setName(String name) {
		if (name.length() <= DataBaseElements.SIZEOF_STORAGETYPE_NAME) {
			this.name = name;
		} else {
			ProjectLogger.log(this, Level.WARNING,
					String.format("The size of the name can't have a length > %1$d", DataBaseElements.SIZEOF_STORAGETYPE_NAME));
		}
	}

	/**
	 * getDescription
	 *
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * setDescription
	 *
	 * @param description
	 */
	public void setDescription(String description) {
		if (description.length() <= DataBaseElements.SIZEOF_STORAGETYPE_DESCRIPTION) {
			this.description = description;
		} else {
			ProjectLogger.log(this, Level.WARNING,
					String.format("The size of the description can't have a length > %1$d", DataBaseElements.SIZEOF_STORAGETYPE_DESCRIPTION));
		}
	}
}
