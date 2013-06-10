/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import java.sql.Timestamp;

/**
 *
 * @author Yoldark34 (yoldark@gmail.com)
 */
public class Helper {

	public static Timestamp getSqlDateNow() {
		Timestamp timestamp = new java.sql.Timestamp(java.util.Calendar.getInstance().getTime().getTime());
		//java.sql.Date sqlToday = new Date();

		return timestamp;
	}
}
