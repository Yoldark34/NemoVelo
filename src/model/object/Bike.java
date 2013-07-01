/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.object;

/**
 *
 * @author Yoldark34 <yoldark@gmail.com>
 */
public class Bike {

	private int id = -1;
	private int numberOfBikes = -1;

	/**
	 * get bike id
	 *
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * set bike id
	 *
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * get number of bikes
	 *
	 * @return int
	 */
	public int getNumberOfBikes() {
		return numberOfBikes;
	}

	/**
	 * set number of bikes
	 *
	 * @param numberOfBikes
	 */
	public void setNumberOfBikes(int numberOfBikes) {
		this.numberOfBikes = numberOfBikes;
	}
}
