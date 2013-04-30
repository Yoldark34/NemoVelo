/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

/**
 *
 * @author Yoldark34 (yoldark@gmail.com)
 */
public class Terminal {

	private int id;
	private int idStock;
	private String ip;

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

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		if (ip.length() <= 20) {
			this.ip = ip;
		} else {
			System.out.println("The size of the ip can't have a length > 20");
		}
	}
}
