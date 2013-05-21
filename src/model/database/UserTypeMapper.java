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
public class UserTypeMapper extends AbstractMapper {

	public ArrayList<UserType> getAllUserTypes() throws SQLException, ClassNotFoundException {
		DbConnection adapter = DbConnection.getDbConnection();
		adapter.executeSelectQuery("Select * from " + DataBaseElements.USERTYPE);
		return (ArrayList<UserType>) adapter.getModelsFromRequest(this);
	}

	@Override
	public Object populateModel(ResultSet row) throws SQLException {
		UserType obj = new UserType();
		if (this.hasColumn(DataBaseElements.USERTYPE_ID, row)) {
			obj.setId(row.getInt(DataBaseElements.USERTYPE_ID));
		}
		if (this.hasColumn(DataBaseElements.USERTYPE_IDPARENT, row)) {
			obj.setId(row.getInt(DataBaseElements.USERTYPE_IDPARENT));
		}
		if (this.hasColumn(DataBaseElements.USERTYPE_CODE, row)) {
			obj.setCode(row.getString(DataBaseElements.USERTYPE_CODE));
		}
		if (this.hasColumn(DataBaseElements.USERTYPE_NAME, row)) {
			obj.setName(row.getString(DataBaseElements.USERTYPE_NAME));
		}
		if (this.hasColumn(DataBaseElements.USERTYPE_DESCRIPTION, row)) {
			obj.setDescription(row.getString(DataBaseElements.USERTYPE_DESCRIPTION));
		}

		return obj;
	}
}
