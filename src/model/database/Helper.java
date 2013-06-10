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
public class Helper {

	public static Date getSqlDateNow() {
		java.sql.Date sqlToday = new Date(java.util.Calendar.getInstance().getTime().getTime());

		return sqlToday;
	}
}
