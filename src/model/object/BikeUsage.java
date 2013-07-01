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
public class BikeUsage {

	private int id = -1;
	private int idNemoUser;
	private int idBikeUsageType;
	private int idBike;
	private int idEndStorage;
	private Timestamp startDate;
	private Timestamp endDate;
	private String comments;
	private int numberOfBikeUsages;

	public int getNumberOfBikeUsages() {
		return numberOfBikeUsages;
	}

	public void setNumberOfBikeUsages(int numberOfBikeUsages) {
		this.numberOfBikeUsages = numberOfBikeUsages;
	}

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

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		if (comments != null) {
			if (comments.length() <= DataBaseElements.SIZEOF_BIKEUSAGE_COMMENTS) {
				this.comments = comments;
			} else {
				ProjectLogger.log(this, Level.WARNING,
						String.format("The size of the comments can't have a length > %1$d", DataBaseElements.SIZEOF_BIKEUSAGE_COMMENTS));
			}
		} else {
			this.comments = comments;
		}
	}
}
