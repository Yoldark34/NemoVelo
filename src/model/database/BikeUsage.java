/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yoldark34 (yoldark@gmail.com)
 */
public class BikeUsage {

	private int id;
	private int idNemoUser;
	private int idBikeUsageType;
	private int idBike;
	private int idEndStorage;
	private Date startDate;
	private Date endDate;
	private String comments;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdNemoUser() {
		return idNemoUser;
	}

	public void setIdNemoUser(int idNemoUser) {
		this.idNemoUser = idNemoUser;
	}

	public int getIdBikeUsageType() {
		return idBikeUsageType;
	}

	public void setIdBikeUsageType(int idBikeUsageType) {
		this.idBikeUsageType = idBikeUsageType;
	}

	public int getIdBike() {
		return idBike;
	}

	public void setIdBike(int idBike) {
		this.idBike = idBike;
	}

	public int getIdEndStorage() {
		return idEndStorage;
	}

	public void setIdEndStorage(int idEndStorage) {
		this.idEndStorage = idEndStorage;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		if (comments.length() <= DataBaseElements.SIZEOF_BIKEUSAGE_COMMENTS) {
			this.comments = comments;
		} else {
			Logger.getLogger(BikeUsage.class.getName()).log(Level.WARNING,
					String.format("The size of the comments can't have a length > %1$d", DataBaseElements.SIZEOF_BIKEUSAGE_COMMENTS));
		}
	}
}
