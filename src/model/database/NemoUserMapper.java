/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import java.sql.Date;
import model.object.NemoUser;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import model.object.NemoUserType;
import resource.log.ProjectLogger;


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

	public int save(NemoUser nemoUser) {
		int nbRows = 0;
		String query;
		if (nemoUser.getId() != -1) {
			query = "UPDATE `" + DataBaseElements.NEMOUSER + "` SET ";
			//query += "`"+DataBaseElements.NEMOUSER_ID+"` = '"+nemoUser.getId()+"',";Can't be updated because used in where
			query += "`" + DataBaseElements.NEMOUSER_LASTNAME + "` = '" + nemoUser.getLastName() + "',";
			query += "`" + DataBaseElements.NEMOUSER_FIRSTNAME + "` = '" + nemoUser.getFirstName() + "',";
			query += "`" + DataBaseElements.NEMOUSER_EMAIL + "` = '" + nemoUser.getEmail() + "',";
			query += "`" + DataBaseElements.NEMOUSER_CRYPTEDPASSWORD + "` = '" + nemoUser.getCryptedPassword() + "',";
			if (nemoUser.getBirthDate() == null) {
				query += "`" + DataBaseElements.BIKEUSAGE_STARTDATE + "` = " + nemoUser.getBirthDate() + ",";
			} else {
				query += "`" + DataBaseElements.BIKEUSAGE_STARTDATE + "` = '" + nemoUser.getBirthDate() + "',";
			}
			if (nemoUser.getCreateDate() == null) {
				query += "`" + DataBaseElements.BIKEUSAGE_ENDDATE + "` = " + nemoUser.getCreateDate() + " ";
			} else {
				query += "`" + DataBaseElements.BIKEUSAGE_ENDDATE + "` = '" + nemoUser.getCreateDate() + "' ";
			}

			query += "WHERE `" + DataBaseElements.NEMOUSER_ID + "` = '" + nemoUser.getId() + "';";
		} else {
			query = "INSERT INTO " + DataBaseElements.NEMOUSER + " (";
			//query +=  "`" + DataBaseElements.NEMOUSER_ID + "`,";
			query += "`" + DataBaseElements.NEMOUSER_LASTNAME + "`,";
			query += "`" + DataBaseElements.NEMOUSER_FIRSTNAME + "`,";
			query += "`" + DataBaseElements.NEMOUSER_EMAIL + "`,";
			query += "`" + DataBaseElements.NEMOUSER_CRYPTEDPASSWORD + "`,";
			query += "`" + DataBaseElements.NEMOUSER_BIRTHDATE + "`,";
			query += "`" + DataBaseElements.NEMOUSER_CREATEDATE + "` ";
			query += ") VALUES (";
			//query += "'" + nemoUser.getId() + "',";
			query += "'" + nemoUser.getLastName() + "',";
			query += "'" + nemoUser.getFirstName() + "',";
			query += "'" + nemoUser.getEmail() + "',";
			query += "'" + nemoUser.getCryptedPassword() + "',";
			if (nemoUser.getBirthDate() == null) {
				query += nemoUser.getBirthDate() + ",";
			} else {
				query += "'" + nemoUser.getBirthDate() + "',";
			}
			if (nemoUser.getCreateDate() == null) {
				query += nemoUser.getCreateDate() + " ";
			} else {
				query += "'" + nemoUser.getCreateDate() + "' ";
			}

			query += ")";
		}

		try {
			DbConnection adapter = DbConnection.getDbConnection();
			nbRows = adapter.executeUpdateQuery(query);
		} catch (Exception e) {
		}
		return nbRows;
	}

	public int getLastUser() {
		String query;
		NemoUser result = new NemoUser();

		query = "SELECT ";
		query += " MAX( ";
		query += DataBaseElements.ALIAS_NEMOUSER + "." + DataBaseElements.NEMOUSER_ID;
		query += " ) as " + DataBaseElements.NEMOUSER_ID;
		query += " FROM ";
		query += DataBaseElements.NEMOUSER + " " + DataBaseElements.ALIAS_NEMOUSER;
		

		try {
			DbConnection adapter = DbConnection.getDbConnection();
			adapter.executeSelectQuery(query);
			result = (NemoUser) adapter.getModelFromRequest(this);
		} catch (SQLException | ClassNotFoundException ex) {
			ProjectLogger.log(this, Level.SEVERE, "Erreur d'exécution de la requête de la fonction getAvailableBikesForThisTerminal", ex);
		}

		return result.getId();
	}

	public int createAnonymousUser() {
		Date sqlToday = Helper.getSqlDateNow();
		NemoUser user = new NemoUser(-1, "Anonymous", "Anonymous", "Anonymous@Anonymous.fr", "Anonymous", sqlToday, sqlToday);
		this.save(user);

		user.setId(this.getLastUser());

		NemoUserTypeMapper nutm = new NemoUserTypeMapper();
		UserTypeMapper utm = new UserTypeMapper();
		NemoUserType nut = new NemoUserType();

		nut.setIdUser(user.getId());
		nut.setIdUserType(utm.getIdUserType(DataBaseElements.UserType.ANONYMOUS));

		nutm.save(nut, false, false);

		return user.getId();
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
