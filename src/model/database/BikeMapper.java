/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import model.object.Bike;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Yoldark34 <yoldark@gmail.com>
 */
public class BikeMapper extends AbstractMapper {

	public ArrayList<Bike> getAllBikes() throws SQLException, ClassNotFoundException {
		DbConnection adapter = DbConnection.getDbConnection();
		adapter.executeSelectQuery("Select * from " + DataBaseElements.BIKE);
		return (ArrayList<Bike>) adapter.getModelsFromRequest(this);
	}

	public int save(Bike bike) {
		int nbRows = 0;
		String query = "";
		if (bike.getId() != -1) {
			//Update do not exist for now because Bike have only one field.
		} else {
			query = "INSERT INTO " + DataBaseElements.BIKE + " (";
			//query += "`" + DataBaseElements.BIKE_ID + "`, `";
			query += ") VALUES (";
			//query += "'" + bike.getId() + "'";//Autoincrement
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
		Bike obj = new Bike();
		if (this.hasColumn(DataBaseElements.BIKE_ID, row)) {
			obj.setId(row.getInt(DataBaseElements.BIKE_ID));
		 }
		return obj;
	}
}
