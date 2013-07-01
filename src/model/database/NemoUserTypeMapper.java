/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import model.object.NemoUserType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Yoldark34 <yoldark@gmail.com>
 */
public class NemoUserTypeMapper extends AbstractMapper {

	/**
	 * get all nemo user from the database
	 *
	 * @return ArrayList<NemoUserType>
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<NemoUserType> getAllNemoUserTypes() throws SQLException, ClassNotFoundException {
		DbConnection adapter = DbConnection.getDbConnection();
		adapter.executeSelectQuery("Select * from " + DataBaseElements.NEMOUSERTYPE);
		return (ArrayList<NemoUserType>) adapter.getModelsFromRequest(this);
	}

	/**
	 * save a new nemo user type or insert it
	 *
	 * @param nemoUserType the nemo user type to insert or update
	 * @param updateMode if it is from update or insert
	 * @param updateIdUser if change id user or not
	 * @return nbRows
	 */
	public int save(NemoUserType nemoUserType, boolean updateMode, boolean updateIdUser) {
		int nbRows = 0;
		String query = "";
		if (updateMode && nemoUserType.getIdUser() != -1 && nemoUserType.getIdUserType() != -1) {
			query = "UPDATE `" + DataBaseElements.NEMOUSERTYPE + "` SET ";
			query += "`" + DataBaseElements.NEMOUSERTYPE_IDUSER + "` = '" + nemoUserType.getIdUser()+ "',";
			query += "`" + DataBaseElements.NEMOUSERTYPE_IDUSERTYPE + "` = '" + nemoUserType.getIdUserType()+ "'";

			if (updateIdUser) {
				query += "WHERE `" + DataBaseElements.NEMOUSERTYPE_IDUSER + "` = '" + nemoUserType.getIdUser() + "';";
			} else {
				query += "WHERE `" + DataBaseElements.NEMOUSERTYPE_IDUSERTYPE + "` = '" + nemoUserType.getIdUserType() + "';";
			}
		} else if (!updateMode && nemoUserType.getIdUser() != -1 && nemoUserType.getIdUserType() != -1) {
			query = "INSERT INTO " + DataBaseElements.NEMOUSERTYPE + " (";
			query += "`" + DataBaseElements.NEMOUSERTYPE_IDUSER + "`,";
			query += "`" + DataBaseElements.NEMOUSERTYPE_IDUSERTYPE + "` ";
			query += ") VALUES (";
			query += "'" + nemoUserType.getIdUser() + "',";
			query += "'" + nemoUserType.getIdUserType() + "' ";

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
		NemoUserType obj = new NemoUserType();
		if (this.hasColumn(DataBaseElements.NEMOUSERTYPE_IDUSER, row)) {
			obj.setIdUser(row.getInt(DataBaseElements.NEMOUSERTYPE_IDUSER));
		}
		if (this.hasColumn(DataBaseElements.NEMOUSERTYPE_IDUSERTYPE, row)) {
			obj.setIdUserType(row.getInt(DataBaseElements.NEMOUSERTYPE_IDUSERTYPE));
		}

		return obj;
	}

	@Override
	Object getEmptyModel() {
		return new NemoUserType();
	}
}
