/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.object;

import java.sql.Timestamp;

/**
 *
 * @author Yoldark34 (yoldark@gmail.com)
 */
public class ReturnAmount {

	private int id = -1;
	private int idSubscription = -1;
	private float amount = -1;
	private Timestamp returnDate;

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
	 * getIdSubscription
	 *
	 * @return
	 */
	public int getIdSubscription() {
		return idSubscription;
	}

	/**
	 * setIdSubscription
	 *
	 * @param idSubscription
	 */
	public void setIdSubscription(int idSubscription) {
		this.idSubscription = idSubscription;
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
	 * getReturnDate
	 *
	 * @return
	 */
	public Timestamp getReturnDate() {
		return returnDate;
	}

	/**
	 * setReturnDate
	 *
	 * @param returnDate
	 */
	public void setReturnDate(Timestamp returnDate) {
		this.returnDate = returnDate;
	}

}
