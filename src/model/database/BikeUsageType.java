/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

/**
 *
 * @author Yoldark34 (yoldark@gmail.com)
 */
public class BikeUsageType {

	private int id;
	private int id_parent_bike_usage_type;
	private String name;
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_parent_bike_usage_type() {
		return id_parent_bike_usage_type;
	}

	public void setId_parent_bike_usage_type(int id_parent_bike_usage_type) {
		this.id_parent_bike_usage_type = id_parent_bike_usage_type;
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
		if (description.length() <= 20) {
			this.description = description;
		} else {
			System.out.println("The size of the description can't have a length > 20");
		}
	}
}
