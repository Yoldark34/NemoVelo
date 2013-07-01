/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.object;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Yoldark34 (yoldark@gmail.com)
 */
public class Subscription {

	private int id = -1;
	private int idPrice;
	private int idNemoUser;
	private float amount = -1;
	private Timestamp startDate;
	private Timestamp endDate;

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
	 * getIdPrice
	 *
	 * @return
	 */
	public int getIdPrice() {
		return idPrice;
	}

	/**
	 * setIdPrice
	 *
	 * @param idPrice
	 */
	public void setIdPrice(int idPrice) {
		this.idPrice = idPrice;
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
	 * getAmount
	 *
	 * @return
	 */
	public float getAmount() {
		return amount;
	}

	/**
	 * setAmount
	 *
	 * @param amount
	 */
	public void setAmount(float amount) {
		this.amount = amount;
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
}
