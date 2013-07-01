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

	/**
	 * get all storages from the database
	 *
	 * @return ArrayList<Storage>
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Storage> getAllStorages() throws SQLException, ClassNotFoundException {
		DbConnection adapter = DbConnection.getDbConnection();
		adapter.executeSelectQuery("Select * from " + DataBaseElements.STORAGE);
		return (ArrayList<Storage>) adapter.getModelsFromRequest(this);
	}

	/**
	 * Insert storage if id == -1 or update storage instead
	 *
	 * @param storage
	 * @return int number of rows
	 */
	public int save(Storage storage) {
		int nbRows = 0;
		String query;

		int available = 0;
		if (storage.isAvailable()) {
			available = 1;
		}

		if (storage.getId() != -1) {
			query = "UPDATE `" + DataBaseElements.STORAGE + "` SET ";
			//query += "`" + DataBaseElements.STORAGE_ID +"` = '"+storage.getId() + "',";Can't be updated because used in where
			query += "`" + DataBaseElements.STORAGE_IDSTOCK + "` = '" + storage.getIdStock() + "',";
			query += "`" + DataBaseElements.STORAGE_IDSTORAGETYPE + "` = '" + storage.getIdStorageType() + "',";
			query += "`" + DataBaseElements.STORAGE_AVAILABLE + "` = '" + available + "' ";

			query += "WHERE `" + DataBaseElements.STORAGE_ID + "` = '" + storage.getId() + "';";
		} else {
			query = "INSERT INTO " + DataBaseElements.STORAGE + " (";
			//query +=  "`" + DataBaseElements.STORAGE_ID + "`,";
			query += "`" + DataBaseElements.STORAGE_IDSTOCK + "`,";
			query += "`" + DataBaseElements.STORAGE_IDSTORAGETYPE + "`,";
			query += "`" + DataBaseElements.STORAGE_AVAILABLE + "` ";

			query += ") VALUES (";
			//query += "'" + storage.getId() + "',";
			query += "'" + storage.getIdStock() + "',";
			query += "'" + storage.getIdStorageType() + "',";
			query += "'" + available + "' ";

			query += ")";
		}

		try {
			DbConnection adapter = DbConnection.getDbConnection();
			nbRows = adapter.executeUpdateQuery(query);
		} catch (Exception e) {
		}
		return nbRows;
	}

	/**
	 * get all available storages for a terminal
	 *
	 * @param terminalId
	 * @return int
	 */
	public int getAvailableStoragesForTerminal(int terminalId) {
		String query;
		Storage result = new Storage();

		query = "SELECT ";
		query += "count( * ) AS 'numberOfStorages'";
		query += " FROM ";
		query += DataBaseElements.TERMINAL + " " + DataBaseElements.ALIAS_TERMINAL + ", ";
		query += DataBaseElements.STORAGE + " " + DataBaseElements.ALIAS_STORAGE;
		query += " WHERE ";
		query += DataBaseElements.ALIAS_STORAGE + "." + DataBaseElements.STORAGE_IDSTOCK + " = " + DataBaseElements.ALIAS_TERMINAL + "." + DataBaseElements.TERMINAL_IDSTOCK;
		query += " AND ";
		query += DataBaseElements.ALIAS_TERMINAL + "." + DataBaseElements.TERMINAL_ID + " = " + terminalId;
		query += " AND ";
		query += DataBaseElements.ALIAS_STORAGE + "." + DataBaseElements.STORAGE_AVAILABLE + " = " + 1;

		try {
			DbConnection adapter = DbConnection.getDbConnection();
			adapter.executeSelectQuery(query);
			result = (Storage) adapter.getModelFromRequest(this);
		} catch (SQLException | ClassNotFoundException ex) {
			ProjectLogger.log(this, Level.SEVERE, "Erreur d'exécution de la requête de la fonction getAvailableBikesForThisTerminal", ex);
		}

		return result.getNumberOfStorages();
	}

	/**
	 * get first available storage for a terminal (for the return process)
	 *
	 * @param terminalId
	 * @return int
	 */
	public int getFirstAvailableStorageForTerminal(int terminalId) {
		String query;
		Storage result = null;

		query = "SELECT ";
		query += " MIN( ";
		query += DataBaseElements.StorageColSet.MIN;
		query += " ) as ";
		query += DataBaseElements.STORAGE_ID;
		query += " FROM ";
		query += DataBaseElements.TERMINAL + " " + DataBaseElements.ALIAS_TERMINAL + ", ";
		query += DataBaseElements.STORAGE + " " + DataBaseElements.ALIAS_STORAGE;
		query += " WHERE ";
		query += DataBaseElements.ALIAS_STORAGE + "." + DataBaseElements.STORAGE_IDSTOCK + " = " + DataBaseElements.ALIAS_TERMINAL + "." + DataBaseElements.TERMINAL_IDSTOCK;
		query += " AND ";
		query += DataBaseElements.ALIAS_TERMINAL + "." + DataBaseElements.TERMINAL_ID + " = " + terminalId;
		query += " AND ";
		query += DataBaseElements.ALIAS_STORAGE + "." + DataBaseElements.STORAGE_AVAILABLE + " = " + 1;

		try {
			DbConnection adapter = DbConnection.getDbConnection();
			adapter.executeSelectQuery(query);
			result = (Storage) adapter.getModelFromRequest(this);
		} catch (SQLException | ClassNotFoundException ex) {
			ProjectLogger.log(this, Level.SEVERE, "Erreur d'exécution de la requête de la fonction getAvailableBikesForThisTerminal", ex);
		}

		return result.getId();
	}

	/**
	 * set the storage not available
	 *
	 * @param idStorage
	 * @return boolean
	 */
	public boolean setStorageUsed(int idStorage) {
		String query;
		int nbRows;

		query = "UPDATE `" + DataBaseElements.STORAGE + "` SET ";
		query += "`" + DataBaseElements.STORAGE_AVAILABLE + "` = '" + 0 + "' ";

		query += "WHERE `" + DataBaseElements.STORAGE_ID + "` = '" + idStorage + "';";

		try {
			DbConnection adapter = DbConnection.getDbConnection();
			nbRows = adapter.executeUpdateQuery(query);
			if (nbRows > 0) {
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}

	/**
	 * set storage available
	 *
	 * @param idStorage
	 * @return boolean
	 */
	public boolean setStorageAvailable(int idStorage) {
		String query;
		int nbRows;

		query = "UPDATE `" + DataBaseElements.STORAGE + "` SET ";
		query += "`" + DataBaseElements.STORAGE_AVAILABLE + "` = '" + 1 + "' ";

		query += "WHERE `" + DataBaseElements.STORAGE_ID + "` = '" + idStorage + "';";

		try {
			DbConnection adapter = DbConnection.getDbConnection();
			nbRows = adapter.executeUpdateQuery(query);
			if (nbRows > 0) {
				return true;
			}
		} catch (Exception e) {
		}
		return false;
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
		if (this.hasColumn(DataBaseElements.STORAGE_AVAILABLE, row)) {
			obj.setAvailable(row.getBoolean(DataBaseElements.STORAGE_AVAILABLE));
		}

		return obj;
	}

	@Override
	Object getEmptyModel() {
		return new Storage();
	}
}
