/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import java.sql.Date;

/**
 *
 * @author Yoldark34 (yoldark@gmail.com)
 */
public class Subscription {

	private int id;
	private int idPrice;
	private int idNemoUser;
	private float amount;
	private Date startDate;
	private Date endDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPrice() {
		return idPrice;
	}

	public void setIdPrice(int idPrice) {
		this.idPrice = idPrice;
	}

	public int getIdNemoUser() {
		return idNemoUser;
	}

	public void setIdNemoUser(int idNemoUser) {
		this.idNemoUser = idNemoUser;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
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
}
