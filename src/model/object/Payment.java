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
public class Payment {

	private int id = -1;
	private int idSubscription = -1;
	private float amount = -1;
	private Timestamp paymentDate;
	private boolean validated;

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
	 * getPaymentDate
	 *
	 * @return
	 */
	public Timestamp getPaymentDate() {
		return paymentDate;
	}

	/**
	 * setPaymentDate
	 *
	 * @param paymentDate
	 */
	public void setPaymentDate(Timestamp paymentDate) {
		this.paymentDate = paymentDate;
	}

	/**
	 * isValidated
	 *
	 * @return
	 */
	public boolean isValidated() {
		return validated;
	}

	/**
	 * setValidated
	 *
	 * @param validated
	 */
	public void setValidated(boolean validated) {
		this.validated = validated;
	}

}
