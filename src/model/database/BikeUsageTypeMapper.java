/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import model.object.BikeUsageType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import resource.log.ProjectLogger;


/**
 *
 * @author Yoldark34 <yoldark@gmail.com>
 */
public class BikeUsageTypeMapper extends AbstractMapper {

	public ArrayList<BikeUsageType> getAllBikeUsagesType() throws SQLException, ClassNotFoundException {
		DbConnection adapter = DbConnection.getDbConnection();
		adapter.executeSelectQuery("Select * from " + DataBaseElements.BIKEUSAGETYPE);
		return (ArrayList<BikeUsageType>) adapter.getModelsFromRequest(this);
	}

	public BikeUsageType getBikeUsagesType(String bikeUsageType) throws SQLException, ClassNotFoundException {
		String query;
		BikeUsageType result = null;

		query = "SELECT ";
		query += "*";
		query += " FROM ";
		query += DataBaseElements.BIKEUSAGETYPE + " " + DataBaseElements.ALIAS_BIKEUSAGETYPE + " ";
		query += " WHERE ";
		query += DataBaseElements.ALIAS_BIKEUSAGETYPE + "." + DataBaseElements.BIKEUSAGETYPE_NAME + " = '" + bikeUsageType + "'";

		try {
			DbConnection adapter = DbConnection.getDbConnection();
			adapter.executeSelectQuery(query);
			result = (BikeUsageType) adapter.getModelFromRequest(this);
		} catch (SQLException | ClassNotFoundException ex) {
			ProjectLogger.log(this, Level.SEVERE, "Erreur d'exécution de la requête de la fonction bookFirstAvailableBikeForTerminal", ex);
		}

		return result;
	}

	public int save(BikeUsageType bikeUsageType) {
		int nbRows = 0;
		String query;
		if (bikeUsageType.getId() != -1) {
			query = "UPDATE `" + DataBaseElements.BIKEUSAGETYPE + "` SET ";
			//query += "`"+DataBaseElements.BIKEUSAGETYPE_ID+"` = '"+bikeUsageType.getId()+"',";Can't be updated because used in where
			if (bikeUsageType.getId_parent_bike_usage_type() == -1) {
				query += "`" + DataBaseElements.BIKEUSAGETYPE_IDPARENT + "` = NULL,";
			} else {
				query += "`" + DataBaseElements.BIKEUSAGETYPE_IDPARENT + "` = '" + bikeUsageType.getId_parent_bike_usage_type() + "',";
			}
			
			query += "`" + DataBaseElements.BIKEUSAGETYPE_NAME + "` = '" + bikeUsageType.getName() + "',";
			query += "`" + DataBaseElements.BIKEUSAGETYPE_DESCRIPTION + "` = '" + bikeUsageType.getDescription() + "' ";

			query += "WHERE `" + DataBaseElements.BIKEUSAGETYPE_ID + "` = '" + bikeUsageType.getId() + "';";
		} else {
			query = "INSERT INTO " + DataBaseElements.BIKEUSAGETYPE + " (";
			//query +=  "`" + DataBaseElements.BIKEUSAGETYPE_ID + "`,";
			query += "`" + DataBaseElements.BIKEUSAGETYPE_IDPARENT + "`,";
			query += "`" + DataBaseElements.BIKEUSAGETYPE_NAME + "`,";
			query += "`" + DataBaseElements.BIKEUSAGETYPE_DESCRIPTION + "` ";
			query += ") VALUES (";
			//query += "'" + bikeUsageType.getId() + "',";
			if (bikeUsageType.getId_parent_bike_usage_type() == -1) {
				query += "NULL,";
			} else {
				query += "'" + bikeUsageType.getId_parent_bike_usage_type() + "',";
			}
			
			query += "'" + bikeUsageType.getName() + "',";
			query += "'" + bikeUsageType.getDescription() + "' ";

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
		BikeUsageType obj = new BikeUsageType();
		if (this.hasColumn(DataBaseElements.BIKEUSAGETYPE_ID, row)) {
			obj.setId(row.getInt(DataBaseElements.BIKEUSAGETYPE_ID));
		}
		if (this.hasColumn(DataBaseElements.BIKEUSAGETYPE_IDPARENT, row)) {
			obj.setId_parent_bike_usage_type(row.getInt(DataBaseElements.BIKEUSAGETYPE_IDPARENT));
		}
		if (this.hasColumn(DataBaseElements.BIKEUSAGETYPE_NAME, row)) {
			obj.setName(row.getString(DataBaseElements.BIKEUSAGETYPE_NAME));
		}
		if (this.hasColumn(DataBaseElements.BIKEUSAGETYPE_DESCRIPTION, row)) {
			obj.setDescription(row.getString(DataBaseElements.BIKEUSAGETYPE_DESCRIPTION));
		}

		return obj;
	}

	@Override
	Object getEmptyModel() {
		return new BikeUsageType();
	}
}
