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

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdStock() {
		return idStock;
	}

	public void setIdStock(int idStock) {
		this.idStock = idStock;
	}

	public int getIdStorageType() {
		return idStorageType;
	}

	public void setIdStorageType(int idStorageType) {
		this.idStorageType = idStorageType;
	}

	public int getNumberOfStorages() {
		return numberOfStorages;
	}

	public void setNumberOfStorages(int numberOfStorages) {
		this.numberOfStorages = numberOfStorages;
	}
}
