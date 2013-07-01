/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.object;

/**
 *
 * @author Yoldark34 (yoldark@gmail.com)
 */
public class Storage {

	private int id;
	private int idStock;
	private int idStorageType;
	private int numberOfStorages;
	private boolean available;

	/**
	 * isAvailable
	 *
	 * @return
	 */
	public boolean isAvailable() {
		return available;
	}

	/**
	 * setAvailable
	 *
	 * @param available
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}

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
	 * getIdStock
	 *
	 * @return
	 */
	public int getIdStock() {
		return idStock;
	}

	/**
	 * setIdStock
	 *
	 * @param idStock
	 */
	public void setIdStock(int idStock) {
		this.idStock = idStock;
	}

	/**
	 * getIdStorageType
	 *
	 * @return
	 */
	public int getIdStorageType() {
		return idStorageType;
	}

	/**
	 * setIdStorageType
	 *
	 * @param idStorageType
	 */
	public void setIdStorageType(int idStorageType) {
		this.idStorageType = idStorageType;
	}

	/**
	 * getNumberOfStorages
	 *
	 * @return
	 */
	public int getNumberOfStorages() {
		return numberOfStorages;
	}

	/**
	 * setNumberOfStorages
	 *
	 * @param numberOfStorages
	 */
	public void setNumberOfStorages(int numberOfStorages) {
		this.numberOfStorages = numberOfStorages;
	}
}
