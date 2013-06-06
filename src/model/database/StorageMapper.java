/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import model.object.Storage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


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
		String query = "";
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

		return obj;
	}
}
