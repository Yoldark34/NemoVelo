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
public class StorageTypeMapper extends AbstractMapper {

	public ArrayList<StorageType> getAllStorageTypes() throws SQLException, ClassNotFoundException {
		DbConnection adapter = DbConnection.getDbConnection();
		adapter.executeSelectQuery("Select * from " + DataBaseElements.STORAGETYPE);
		return (ArrayList<StorageType>) adapter.getModelsFromRequest(this);
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
}
