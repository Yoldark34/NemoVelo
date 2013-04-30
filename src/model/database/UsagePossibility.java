/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

/**
 *
 * @author Yoldark34 (yoldark@gmail.com)
 */
public class UsagePossibility {

	private int idBikeUsageType;
	private int idUserType;
	private int idStorageType;
	private int idRent;
	private int idGuarantee;

	public int getIdBikeUsageType() {
		return idBikeUsageType;
	}

	public void setIdBikeUsageType(int idBikeUsageType) {
		this.idBikeUsageType = idBikeUsageType;
	}

	public int getIdUserType() {
		return idUserType;
	}

	public void setIdUserType(int idUserType) {
		this.idUserType = idUserType;
	}

	public int getIdStorageType() {
		return idStorageType;
	}

	public void setIdStorageType(int idStorageType) {
		this.idStorageType = idStorageType;
	}

	public int getIdRent() {
		return idRent;
	}

	public void setIdRent(int idRent) {
		this.idRent = idRent;
	}

	public int getIdGuarantee() {
		return idGuarantee;
	}

	public void setIdGuarantee(int idGuarantee) {
		this.idGuarantee = idGuarantee;
	}
}
