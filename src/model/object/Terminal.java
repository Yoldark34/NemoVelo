/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.object;

import java.util.logging.Level;
import model.database.DataBaseElements;
import resource.log.ProjectLogger;

/**
 *
 * @author Yoldark34 (yoldark@gmail.com)
 */
public class Terminal {

	private int id;
	private int idStock;
	private String ip;

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
	 * getIp
	 *
	 * @return
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * setIp
	 *
	 * @param ip
	 */
	public void setIp(String ip) {
		if (ip.length() <= DataBaseElements.SIZEOF_TERMINAL_IP) {
			this.ip = ip;
		} else {
			ProjectLogger.log(this, Level.WARNING,
					String.format("The size of the ip can't have a length > %1$d", DataBaseElements.SIZEOF_TERMINAL_IP));
		}
	}
}
