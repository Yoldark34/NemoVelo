/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import model.object.Terminal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Yoldark34 <yoldark@gmail.com>
 */
public class TerminalMapper extends AbstractMapper {

	public ArrayList<Terminal> getAllTerminals() throws SQLException, ClassNotFoundException {
		DbConnection adapter = DbConnection.getDbConnection();
		adapter.executeSelectQuery("Select * from " + DataBaseElements.TERMINAL);
		return (ArrayList<Terminal>) adapter.getModelsFromRequest(this);
	}

	public int save(Terminal terminal) {
		int nbRows = 0;
		String query = "";
		if (terminal.getId() != -1) {
			query = "UPDATE `" + DataBaseElements.TERMINAL + "` SET ";
			//query += "`"+DataBaseElements.TERMINAL_ID+"` = '"+terminal.getId()+"',";Can't be updated because used in where
			query += "`" + DataBaseElements.TERMINAL_IDSTOCK + "` = '" + terminal.getIdStock() + "',";
			query += "`" + DataBaseElements.TERMINAL_IP + "` = '" + terminal.getIp() + "' ";

			query += "WHERE `" + DataBaseElements.TERMINAL_ID + "` = '" + terminal.getId() + "';";
		} else {
			query = "INSERT INTO " + DataBaseElements.TERMINAL + " (";
			//query +=  "`" + DataBaseElements.TERMINAL_ID + "`,";
			query += "`" + DataBaseElements.TERMINAL_IDSTOCK + "`,";
			query += "`" + DataBaseElements.TERMINAL_IP + "` ";

			query += ") VALUES (";
			//query += "'" + terminal.getId() + "',";
			query += "'" + terminal.getIdStock() + "',";
			query += "'" + terminal.getIp() + "' ";

			query += ")";
		}

		try {
			DbConnection adapter = DbConnection.getDbConnection();
			nbRows = adapter.executeUpdateQuery(query);
		} catch (Exception e) {
		}
		return nbRows;
	}

	@Override
	public Object populateModel(ResultSet row) throws SQLException {
		Terminal obj = new Terminal();
		if (this.hasColumn(DataBaseElements.TERMINAL_ID, row)) {
			obj.setId(row.getInt(DataBaseElements.TERMINAL_ID));
		}
		if (this.hasColumn(DataBaseElements.TERMINAL_IDSTOCK, row)) {
			obj.setIdStock(row.getInt(DataBaseElements.TERMINAL_IDSTOCK));
		}
		if (this.hasColumn(DataBaseElements.TERMINAL_IP, row)) {
			obj.setIp(row.getString(DataBaseElements.TERMINAL_IP));
		}

		return obj;
	}
}
