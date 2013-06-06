/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import model.object.UserType;
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

	public int save(UserType userType) {
		int nbRows = 0;
		String query;
		if (userType.getId() != -1) {
			query = "UPDATE `" + DataBaseElements.USERTYPE + "` SET ";
			//query += "`"+DataBaseElements.USERTYPE_ID+"` = '"+userType.getId()+"',";Can't be updated because used in where
			query += "`" + DataBaseElements.USERTYPE_IDPARENTUSERTYPE + "` = '" + userType.getIdParentUserType() + "',";
			query += "`" + DataBaseElements.USERTYPE_CODE + "` = '" + userType.getCode() + "',";
			query += "`" + DataBaseElements.USERTYPE_NAME + "` = '" + userType.getName() + "',";
			query += "`" + DataBaseElements.USERTYPE_DESCRIPTION + "` = '" + userType.getDescription() + "' ";

			query += "WHERE `" + DataBaseElements.USERTYPE_ID + "` = '" + userType.getId() + "';";
		} else {
			query = "INSERT INTO " + DataBaseElements.USERTYPE + " (";
			//query +=  "`" + DataBaseElements.USERTYPE_ID + "`,";
			query += "`" + DataBaseElements.USERTYPE_IDPARENTUSERTYPE + "`,";
			query += "`" + DataBaseElements.USERTYPE_CODE + "`,";
			query += "`" + DataBaseElements.USERTYPE_NAME + "`,";
			query += "`" + DataBaseElements.USERTYPE_DESCRIPTION + "` ";

			query += ") VALUES (";
			//query += "'" + userType.getId() + "',";
			query += "'" + userType.getIdParentUserType() + "',";
			query += "'" + userType.getCode() + "',";
			query += "'" + userType.getName() + "',";
			query += "'" + userType.getDescription() + "' ";

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
		UserType obj = new UserType();
		if (this.hasColumn(DataBaseElements.USERTYPE_ID, row)) {
			obj.setId(row.getInt(DataBaseElements.USERTYPE_ID));
		}
		if (this.hasColumn(DataBaseElements.USERTYPE_IDPARENTUSERTYPE, row)) {
			obj.setId(row.getInt(DataBaseElements.USERTYPE_IDPARENTUSERTYPE));
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
