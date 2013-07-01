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
public class BikeUsageType {

	private int id;
	private int id_parent_bike_usage_type = -1;
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
	 * getId_parent_bike_usage_type
	 *
	 * @return
	 */
	public int getId_parent_bike_usage_type() {
		return id_parent_bike_usage_type;
	}

	/**
	 * setId_parent_bike_usage_type
	 *
	 * @param id_parent_bike_usage_type
	 */
	public void setId_parent_bike_usage_type(int id_parent_bike_usage_type) {
		this.id_parent_bike_usage_type = id_parent_bike_usage_type;
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
		if (name.length() <= DataBaseElements.SIZEOF_BIKEUSAGETYPE_NAME) {
			this.name = name;
		} else {
			ProjectLogger.log(this, Level.WARNING,
					String.format("The size of the name can't have a length > %1$d", DataBaseElements.SIZEOF_BIKEUSAGETYPE_NAME));
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
		if (description.length() <= DataBaseElements.SIZEOF_BIKEUSAGETYPE_DESCRIPTION) {
			this.description = description;
		} else {
			ProjectLogger.log(this, Level.WARNING,
					String.format("The size of the description can't have a length >%1$d", DataBaseElements.SIZEOF_BIKEUSAGETYPE_DESCRIPTION));
		}
	}
}
