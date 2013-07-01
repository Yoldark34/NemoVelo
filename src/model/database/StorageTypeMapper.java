/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import model.object.StorageType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Yoldark34 <yoldark@gmail.com>
 */
public class StorageTypeMapper extends AbstractMapper {

	/**
	 * Get all storages types from the database
	 *
	 * @return ArrayList<StorageType>
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<StorageType> getAllStorageTypes() throws SQLException, ClassNotFoundException {
		DbConnection adapter = DbConnection.getDbConnection();
		adapter.executeSelectQuery("Select * from " + DataBaseElements.STORAGETYPE);
		return (ArrayList<StorageType>) adapter.getModelsFromRequest(this);
	}

	/**
	 * Insert storageType if id == -1 or update storageType instead
	 *
	 * @param storageType
	 * @return int number of rows
	 */
	public int save(StorageType storageType) {
		int nbRows = 0;
		String query;
		if (storageType.getId() != -1) {
			query = "UPDATE `" + DataBaseElements.STORAGETYPE + "` SET ";
			//query += "`"+DataBaseElements.STORAGETYPE_ID+"` = '"+storageType.getId()+"',";Can't be updated because used in where
			query += "`" + DataBaseElements.STORAGETYPE_CODE + "` = '" + storageType.getCode() + "',";
			query += "`" + DataBaseElements.STORAGETYPE_NAME + "` = '" + storageType.getName() + "',";
			query += "`" + DataBaseElements.STORAGETYPE_DESCRIPTION + "` = '" + storageType.getDescription() + "' ";

			query += "WHERE `" + DataBaseElements.STORAGETYPE_ID + "` = '" + storageType.getId() + "';";
		} else {
			query = "INSERT INTO " + DataBaseElements.STORAGETYPE + " (";
			//query +=  "`" + DataBaseElements.STORAGETYPE_ID + "`,";
			query += "`" + DataBaseElements.STORAGETYPE_CODE + "`,";
			query += "`" + DataBaseElements.STORAGETYPE_NAME + "`,";
			query += "`" + DataBaseElements.STORAGETYPE_DESCRIPTION + "` ";

			query += ") VALUES (";
			//query += "'" + storageType.getId() + "',";
			query += "'" + storageType.getCode() + "',";
			query += "'" + storageType.getName() + "',";
			query += "'" + storageType.getDescription() + "' ";

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
		StorageType obj = new StorageType();
		if (this.hasColumn(DataBaseElements.STORAGETYPE_ID, row)) {
			obj.setId(row.getInt(DataBaseElements.STORAGETYPE_ID));
		}
		if (this.hasColumn(DataBaseElements.STORAGETYPE_CODE, row)) {
			obj.setCode(row.getString(DataBaseElements.STORAGETYPE_CODE));
		}
		if (this.hasColumn(DataBaseElements.STORAGETYPE_NAME, row)) {
			obj.setName(row.getString(DataBaseElements.STORAGETYPE_NAME));
		}
		if (this.hasColumn(DataBaseElements.STORAGETYPE_DESCRIPTION, row)) {
			obj.setDescription(row.getString(DataBaseElements.STORAGETYPE_DESCRIPTION));
		}

		return obj;
	}

	@Override
	Object getEmptyModel() {
		return new StorageType();
	}
}
