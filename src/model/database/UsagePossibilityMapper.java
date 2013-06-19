/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import model.object.UsagePossibility;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Yoldark34 <yoldark@gmail.com>
 */
public class UsagePossibilityMapper extends AbstractMapper {

	public ArrayList<UsagePossibility> getAllUsagePossibilitys() throws SQLException, ClassNotFoundException {
		DbConnection adapter = DbConnection.getDbConnection();
		adapter.executeSelectQuery("Select * from " + DataBaseElements.USAGEPOSSIBILITY);
		return (ArrayList<UsagePossibility>) adapter.getModelsFromRequest(this);
	}

	public int save(UsagePossibility usagePossibility, boolean updateMode) {
		int nbRows = 0;
		String query = "";
		if (updateMode && usagePossibility.getIdBikeUsageType() != -1 && usagePossibility.getIdUserType() != -1 && usagePossibility.getIdStorageType() != -1) {
			if (usagePossibility.getIdRent() != -1 && usagePossibility.getIdGuarantee() != -1) {
				query = "UPDATE `" + DataBaseElements.USAGEPOSSIBILITY + "` SET ";
				if (usagePossibility.getIdRent() != -1) {
					query += "`" + DataBaseElements.USAGEPOSSIBILITY_IDRENT + "` = '" + usagePossibility.getIdRent() + "',";
				}
				if (usagePossibility.getIdGuarantee() != -1) {
					query += "`" + DataBaseElements.USAGEPOSSIBILITY_IDGUARANTEE + "` = '" + usagePossibility.getIdGuarantee() + "' ";
				}

				query += "WHERE ";
				query += "(";
				query += "`" + DataBaseElements.USAGEPOSSIBILITY_IDBIKEUSAGETYPE + "` = '" + usagePossibility.getIdBikeUsageType() + "'";
				query += " AND ";
				query += "`" + DataBaseElements.USAGEPOSSIBILITY_IDUSERTYPE + "` = '" + usagePossibility.getIdUserType() + "'";
				query += " AND ";
				query += "`" + DataBaseElements.USAGEPOSSIBILITY_IDSTORAGETYPE + "` = '" + usagePossibility.getIdStorageType() + "'";
				query += ")";
				query += ";";
			} else {
				return 0;
			}
		} else if (!updateMode && usagePossibility.getIdBikeUsageType() != -1 && usagePossibility.getIdUserType() != -1 && usagePossibility.getIdStorageType() != -1) {
			query = "INSERT INTO " + DataBaseElements.USAGEPOSSIBILITY + " (";
			query += "`" + DataBaseElements.USAGEPOSSIBILITY_IDBIKEUSAGETYPE + "`,";
			query += "`" + DataBaseElements.USAGEPOSSIBILITY_IDUSERTYPE + "`,";
			query += "`" + DataBaseElements.USAGEPOSSIBILITY_IDSTORAGETYPE + "`,";
			query += "`" + DataBaseElements.USAGEPOSSIBILITY_IDRENT + "`,";
			query += "`" + DataBaseElements.USAGEPOSSIBILITY_IDGUARANTEE + "` ";

			query += ") VALUES (";
			query += "'" + usagePossibility.getIdBikeUsageType() + "',";
			query += "'" + usagePossibility.getIdUserType() + "',";
			query += "'" + usagePossibility.getIdStorageType() + "',";
			if (usagePossibility.getIdRent() != -1) {
				query += "'" + usagePossibility.getIdRent() + "',";
			} else {
				query += "NULL,";
			}

			if (usagePossibility.getIdGuarantee() != -1) {
				query += "'" + usagePossibility.getIdGuarantee() + "' ";
			} else {
				query += "NULL,";
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

	@Override
	public Object populateModel(ResultSet row) throws SQLException {
		UsagePossibility obj = new UsagePossibility();
		if (this.hasColumn(DataBaseElements.USAGEPOSSIBILITY_IDBIKEUSAGETYPE, row)) {
			obj.setIdBikeUsageType(row.getInt(DataBaseElements.USAGEPOSSIBILITY_IDBIKEUSAGETYPE));
		}
		if (this.hasColumn(DataBaseElements.USAGEPOSSIBILITY_IDUSERTYPE, row)) {
			obj.setIdUserType(row.getInt(DataBaseElements.USAGEPOSSIBILITY_IDUSERTYPE));
		}
		if (this.hasColumn(DataBaseElements.USAGEPOSSIBILITY_IDSTORAGETYPE, row)) {
			obj.setIdStorageType(row.getInt(DataBaseElements.USAGEPOSSIBILITY_IDSTORAGETYPE));
		}
		if (this.hasColumn(DataBaseElements.USAGEPOSSIBILITY_IDRENT, row)) {
			obj.setIdRent(row.getInt(DataBaseElements.USAGEPOSSIBILITY_IDRENT));
		}
		if (this.hasColumn(DataBaseElements.USAGEPOSSIBILITY_IDGUARANTEE, row)) {
			obj.setIdGuarantee(row.getInt(DataBaseElements.USAGEPOSSIBILITY_IDGUARANTEE));
		}

		return obj;
	}

	@Override
	Object getEmptyModel() {
		return new UsagePossibility();
	}
}
