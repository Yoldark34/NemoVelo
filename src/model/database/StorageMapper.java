/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import model.object.Storage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import resource.log.ProjectLogger;


/**
 *
 * @author Yoldark34 <yoldark@gmail.com>
 */
public class StorageMapper extends AbstractMapper {

	public ArrayList<Storage> getAllStorages() throws SQLException, ClassNotFoundException {
		DbConnection adapter = DbConnection.getDbConnection();
		adapter.executeSelectQuery("Select * from " + DataBaseElements.STORAGE);
		return (ArrayList<Storage>) adapter.getModelsFromRequest(this);
	}

	public int save(Storage storage) {
		int nbRows = 0;
		String query;
		if (storage.getId() != -1) {
			query = "UPDATE `" + DataBaseElements.STORAGE + "` SET ";
			//query += "`" + DataBaseElements.STORAGE_ID +"` = '"+storage.getId() + "',";Can't be updated because used in where
			query += "`" + DataBaseElements.STORAGE_IDSTOCK + "` = '" + storage.getIdStock() + "',";
			query += "`" + DataBaseElements.STORAGE_IDSTORAGETYPE + "` = '" + storage.getIdStorageType() + "' ";

			query += "WHERE `" + DataBaseElements.STORAGE_ID + "` = '" + storage.getId() + "';";
		} else {
			query = "INSERT INTO " + DataBaseElements.STORAGE + " (";
			//query +=  "`" + DataBaseElements.STORAGE_ID + "`,";
			query += "`" + DataBaseElements.STORAGE_IDSTOCK + "`,";
			query += "`" + DataBaseElements.STORAGE_IDSTORAGETYPE + "` ";

			query += ") VALUES (";
			//query += "'" + storage.getId() + "',";
			query += "'" + storage.getIdStock() + "',";
			query += "'" + storage.getIdStorageType() + "' ";

			query += ")";
		}

		try {
			DbConnection adapter = DbConnection.getDbConnection();
			nbRows = adapter.executeUpdateQuery(query);
		} catch (Exception e) {
		}
		return nbRows;
	}

	public int getAvailableStoragesForTerminal(int terminalId) {
		String query;
		Storage result = new Storage();

		query = "SELECT ";
		query += "count( * ) AS 'numberOfStorages'";
		query += " FROM ";
		query += DataBaseElements.TERMINAL + " " + DataBaseElements.ALIAS_TERMINAL + ", ";
		query += DataBaseElements.STOCK + " " + DataBaseElements.ALIAS_STOCK + ", ";
		query += DataBaseElements.BIKEUSAGE + " " + DataBaseElements.ALIAS_BIKEUSAGE + ", ";
		query += DataBaseElements.BIKEUSAGETYPE + " " + DataBaseElements.ALIAS_BIKEUSAGETYPE + ", ";
		query += DataBaseElements.STORAGE + " " + DataBaseElements.ALIAS_STORAGE;
		query += " WHERE ";
		query += DataBaseElements.ALIAS_STOCK + "." + DataBaseElements.STOCK_ID + " = " + DataBaseElements.ALIAS_TERMINAL + "." + DataBaseElements.TERMINAL_IDSTOCK;
		query += " AND ";
		query += DataBaseElements.ALIAS_STORAGE + "." + DataBaseElements.STORAGE_IDSTOCK + " = " + DataBaseElements.ALIAS_STOCK + "." + DataBaseElements.STOCK_ID;
		query += " AND ";
		query += DataBaseElements.ALIAS_TERMINAL + "." + DataBaseElements.TERMINAL_ID + " = " + terminalId;
		query += " AND ";
		query += DataBaseElements.ALIAS_BIKEUSAGE + "." + DataBaseElements.BIKEUSAGE_IDENDSTORAGE + " = " + DataBaseElements.ALIAS_STORAGE + "." + DataBaseElements.STORAGE_ID;
		query += " AND ";
		query += DataBaseElements.ALIAS_BIKEUSAGE + "." + DataBaseElements.BIKEUSAGE_ENDDATE + " is NULL";
		query += " AND ";
		query += DataBaseElements.ALIAS_BIKEUSAGETYPE + "." + DataBaseElements.BIKEUSAGETYPE_ID + " = " + DataBaseElements.ALIAS_BIKEUSAGE + "." + DataBaseElements.BIKEUSAGE_IDBIKEUSAGETYPE;
		query += " AND ";
		query += DataBaseElements.ALIAS_BIKEUSAGETYPE + "." + DataBaseElements.BIKEUSAGETYPE_NAME + " = '" + DataBaseElements.BikeUsageType.RENTING + "'";

		try {
			DbConnection adapter = DbConnection.getDbConnection();
			adapter.executeSelectQuery(query);
			result = (Storage) adapter.getModelFromRequest(this);
		} catch (SQLException | ClassNotFoundException ex) {
			ProjectLogger.log(this, Level.SEVERE, "Erreur d'exécution de la requête de la fonction getAvailableBikesForThisTerminal", ex);
		}

		return result.getNumberOfStorages();
	}

	@Override
	public Object populateModel(ResultSet row) throws SQLException {
		Storage obj = new Storage();
		if (this.hasColumn(DataBaseElements.STORAGE_ID, row)) {
			obj.setId(row.getInt(DataBaseElements.STORAGE_ID));
		}
		if (this.hasColumn(DataBaseElements.STORAGE_IDSTOCK, row)) {
			obj.setIdStock(row.getInt(DataBaseElements.STORAGE_IDSTOCK));
		}
		if (this.hasColumn(DataBaseElements.STORAGE_IDSTORAGETYPE, row)) {
			obj.setIdStorageType(row.getInt(DataBaseElements.STORAGE_IDSTORAGETYPE));
		}
		if (this.hasColumn("numberOfStorages", row)) {
			obj.setNumberOfStorages(row.getInt("numberOfStorages"));
		}

		return obj;
	}

	@Override
	Object getEmptyModel() {
		return new Storage();
	}
}
