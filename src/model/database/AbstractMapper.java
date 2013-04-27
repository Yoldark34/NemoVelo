/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author Yoldark34 <yoldark@gmail.com>
 */
public abstract class AbstractMapper {

	abstract Object populateModel(ResultSet row) throws SQLException;

	public boolean hasColumn(String columnName, ResultSet res) throws SQLException {
		ResultSetMetaData rsmd = res.getMetaData();
		int columns = rsmd.getColumnCount();
		for (int x = 1; x <= columns; x++) {
			if (columnName.equals(rsmd.getColumnName(x))) {
				return true;
			}
		}
		return false;
	}
}
