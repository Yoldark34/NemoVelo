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
public class NemoUserTypeMapper extends AbstractMapper {

	public ArrayList<NemoUserType> getAllNemoUserTypes() throws SQLException, ClassNotFoundException {
		DbConnection adapter = DbConnection.getDbConnection();
		adapter.executeSelectQuery("Select * from " + DataBaseElements.NEMOUSERTYPE);
		return (ArrayList<NemoUserType>) adapter.getModelsFromRequest(this);
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
}
