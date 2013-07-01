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

	/**
	 * transform resulset into object
	 *
	 * @param row
	 * @return Object
	 * @throws SQLException
	 */
	abstract Object populateModel(ResultSet row) throws SQLException;

	/**
	 * return empty model
	 *
	 * @return Object
	 */
	abstract Object getEmptyModel();

	/**
	 * check if a result set have a column by name
	 *
	 * @param columnName
	 * @param res
	 * @return boolean
	 * @throws SQLException
	 */
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
