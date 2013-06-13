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
	private float amount;
	private Timestamp paymentDate;
	private boolean validated;
	private int idNemoUser;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdSubscription() {
		return idSubscription;
	}

	public void setIdSubscription(int idSubscription) {
		this.idSubscription = idSubscription;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Timestamp getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Timestamp paymentDate) {
		this.paymentDate = paymentDate;
	}

	public boolean isValidated() {
		return validated;
	}

	public void setValidated(boolean validated) {
		this.validated = validated;
	}

	public int getIdNemoUser() {
		return idNemoUser;
	}

	public void setIdNemoUser(int idNemoUser) {
		this.idNemoUser = idNemoUser;
	}
}
