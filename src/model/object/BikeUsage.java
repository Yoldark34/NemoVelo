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

	/**
	 * get the number of bike usages
	 *
	 * @return int
	 */
	public int getNumberOfBikeUsages() {
		return numberOfBikeUsages;
	}

	/**
	 * set number of bike usages
	 *
	 * @param numberOfBikeUsages
	 */
	public void setNumberOfBikeUsages(int numberOfBikeUsages) {
		this.numberOfBikeUsages = numberOfBikeUsages;
	}

	/**
	 * get id
	 *
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * set id
	 *
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * getIdNemoUser
	 *
	 * @return
	 */
	public int getIdNemoUser() {
		return idNemoUser;
	}

	/**
	 * setIdNemoUser
	 *
	 * @param idNemoUser
	 */
	public void setIdNemoUser(int idNemoUser) {
		this.idNemoUser = idNemoUser;
	}

	/**
	 * getIdBikeUsageType
	 *
	 * @return
	 */
	public int getIdBikeUsageType() {
		return idBikeUsageType;
	}

	/**
	 * setIdBikeUsageType
	 *
	 * @param idBikeUsageType
	 */
	public void setIdBikeUsageType(int idBikeUsageType) {
		this.idBikeUsageType = idBikeUsageType;
	}

	/**
	 * getIdBike
	 *
	 * @return
	 */
	public int getIdBike() {
		return idBike;
	}

	/**
	 * setIdBike
	 *
	 * @param idBike
	 */
	public void setIdBike(int idBike) {
		this.idBike = idBike;
	}

	/**
	 * getIdEndStorage
	 *
	 * @return
	 */
	public int getIdEndStorage() {
		return idEndStorage;
	}

	/**
	 * setIdEndStorage
	 *
	 * @param idEndStorage
	 */
	public void setIdEndStorage(int idEndStorage) {
		this.idEndStorage = idEndStorage;
	}

	/**
	 * getStartDate
	 *
	 * @return
	 */
	public Timestamp getStartDate() {
		return startDate;
	}

	/**
	 * setStartDate
	 *
	 * @param startDate
	 */
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	/**
	 * getEndDate
	 *
	 * @return
	 */
	public Timestamp getEndDate() {
		return endDate;
	}

	/**
	 * setEndDate
	 *
	 * @param endDate
	 */
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	/**
	 * getComments
	 *
	 * @return
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * setComments
	 *
	 * @param comments
	 */
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
