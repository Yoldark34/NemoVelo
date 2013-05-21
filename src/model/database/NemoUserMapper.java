/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import model.object.NemoUser;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Yoldark34 <yoldark@gmail.com>
 */
public class NemoUserMapper extends AbstractMapper {

	public ArrayList<NemoUser> getAllNemoUsers() throws SQLException, ClassNotFoundException {
		DbConnection adapter = DbConnection.getDbConnection();
		adapter.executeSelectQuery("Select * from " + DataBaseElements.NEMOUSER);
		return (ArrayList<NemoUser>) adapter.getModelsFromRequest(this);
	}

	@Override
	public Object populateModel(ResultSet row) throws SQLException {
		NemoUser obj = new NemoUser();
		if (this.hasColumn(DataBaseElements.NEMOUSER_ID, row)) {
			obj.setId(row.getInt(DataBaseElements.NEMOUSER_ID));
		}
		if (this.hasColumn(DataBaseElements.NEMOUSER_LASTNAME, row)) {
			obj.setLastName(row.getString(DataBaseElements.NEMOUSER_LASTNAME));
		}
		if (this.hasColumn(DataBaseElements.NEMOUSER_FIRSTNAME, row)) {
			obj.setFirstName(row.getString(DataBaseElements.NEMOUSER_FIRSTNAME));
		}
		if (this.hasColumn(DataBaseElements.NEMOUSER_EMAIL, row)) {
			obj.setEmail(row.getString(DataBaseElements.NEMOUSER_EMAIL));
		}
		if (this.hasColumn(DataBaseElements.NEMOUSER_CRYPTEDPASSWORD, row)) {
			obj.setCryptedPassword(row.getString(DataBaseElements.NEMOUSER_CRYPTEDPASSWORD));
		}
		if (this.hasColumn(DataBaseElements.NEMOUSER_BIRTHDATE, row)) {
			obj.setBirthDate(row.getDate(DataBaseElements.NEMOUSER_BIRTHDATE));
		}
		if (this.hasColumn(DataBaseElements.NEMOUSER_CREATEDATE, row)) {
			obj.setCreateDate(row.getDate(DataBaseElements.NEMOUSER_CREATEDATE));
		}

		return obj;
	}
}
