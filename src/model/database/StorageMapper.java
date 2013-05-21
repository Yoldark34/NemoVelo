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
public class StorageMapper extends AbstractMapper {

	public ArrayList<Storage> getAllStorages() throws SQLException, ClassNotFoundException {
		DbConnection adapter = DbConnection.getDbConnection();
		adapter.executeSelectQuery("Select * from " + DataBaseElements.STORAGE);
		return (ArrayList<Storage>) adapter.getModelsFromRequest(this);
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
