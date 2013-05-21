/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

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
