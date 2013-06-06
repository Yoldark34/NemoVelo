/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import model.object.BikeUsage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Yoldark34 <yoldark@gmail.com>
 */
public class BikeUsageMapper extends AbstractMapper {

	public ArrayList<BikeUsage> getAllBikeUsages() throws SQLException, ClassNotFoundException {
		DbConnection adapter = DbConnection.getDbConnection();
		adapter.executeSelectQuery("Select * from " + DataBaseElements.BIKEUSAGE);
		return (ArrayList<BikeUsage>) adapter.getModelsFromRequest(this);
	}

	public int save(BikeUsage bikeUsage) {
		int nbRows = 0;
		String query;
		if (bikeUsage.getId() != -1) {
			query = "UPDATE `" + DataBaseElements.BIKEUSAGE + "` SET ";
			//query += "`"+DataBaseElements.BIKEUSAGE_ID+"` = '"+bikeUsage.getId()+"',";Can't be updated because used in where
			query += "`" + DataBaseElements.BIKEUSAGE_IDNEMOUSER + "` = '" + bikeUsage.getIdNemoUser() + "',";
			query += "`" + DataBaseElements.BIKEUSAGE_IDBIKEUSAGETYPE + "` = '" + bikeUsage.getIdBikeUsageType() + "',";
			query += "`" + DataBaseElements.BIKEUSAGE_IDBIKE + "` = '" + bikeUsage.getIdBike() + "',";
			query += "`" + DataBaseElements.BIKEUSAGE_IDENDSTORAGE + "` = '" + bikeUsage.getIdEndStorage() + "',";
			if (bikeUsage.getStartDate() == null) {
				query += "`" + DataBaseElements.BIKEUSAGE_STARTDATE + "` = " + bikeUsage.getStartDate() + ",";
			} else {
				query += "`" + DataBaseElements.BIKEUSAGE_STARTDATE + "` = '" + bikeUsage.getStartDate() + "',";
			}
			if (bikeUsage.getEndDate() == null) {
				query += "`" + DataBaseElements.BIKEUSAGE_ENDDATE + "` = " + bikeUsage.getEndDate() + ",";
			} else {
				query += "`" + DataBaseElements.BIKEUSAGE_ENDDATE + "` = '" + bikeUsage.getEndDate() + "',";
			}
			query += "`" + DataBaseElements.BIKEUSAGE_COMMENTS + "` = '" + bikeUsage.getComments() + "' ";

			query += "WHERE `" + DataBaseElements.BIKEUSAGE_ID + "` = '" + bikeUsage.getId() + "';";
		} else {
			query = "INSERT INTO " + DataBaseElements.BIKEUSAGE + " (";
			//query +=  "`" + DataBaseElements.BIKEUSAGE_ID + "`,";
			query += "`" + DataBaseElements.BIKEUSAGE_IDNEMOUSER + "`,";
			query += "`" + DataBaseElements.BIKEUSAGE_IDBIKEUSAGETYPE + " `,";
			query += "`" + DataBaseElements.BIKEUSAGE_IDBIKE + "`,";
			query += "`" + DataBaseElements.BIKEUSAGE_IDENDSTORAGE + "`,";
			query += "`" + DataBaseElements.BIKEUSAGE_STARTDATE + "`,";
			query += "`" + DataBaseElements.BIKEUSAGE_ENDDATE + "`,";
			query += "`" + DataBaseElements.BIKEUSAGE_COMMENTS + "` ";
			query += ") VALUES (";
			//query += "'" + bikeUsage.getId() + "',";
			query += "'" + bikeUsage.getIdNemoUser() + "',";
			query += "'" + bikeUsage.getIdBikeUsageType() + "',";
			query += "'" + bikeUsage.getIdBike() + "',";
			query += "'" + bikeUsage.getIdEndStorage() + "',";
			if (bikeUsage.getStartDate() == null) {
				query += bikeUsage.getStartDate() + ",";
			} else {
				query += "'" + bikeUsage.getStartDate() + "',";
			}
			if (bikeUsage.getEndDate() == null) {
				query += bikeUsage.getEndDate() + ",";
			} else {
				query += "'" + bikeUsage.getEndDate() + "',";
			}
			query += "'" + bikeUsage.getComments() + "' ";

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
		BikeUsage obj = new BikeUsage();
		if (this.hasColumn(DataBaseElements.BIKEUSAGE_ID, row)) {
			obj.setId(row.getInt(DataBaseElements.BIKEUSAGE_ID));
		}
		if (this.hasColumn(DataBaseElements.BIKEUSAGE_IDNEMOUSER, row)) {
			obj.setIdNemoUser(row.getInt(DataBaseElements.BIKEUSAGE_IDNEMOUSER));
		}
		if (this.hasColumn(DataBaseElements.BIKEUSAGE_IDBIKEUSAGETYPE, row)) {
			obj.setIdBikeUsageType(row.getInt(DataBaseElements.BIKEUSAGE_IDBIKEUSAGETYPE));
		}
		if (this.hasColumn(DataBaseElements.BIKEUSAGE_IDBIKE, row)) {
			obj.setIdBike(row.getInt(DataBaseElements.BIKEUSAGE_IDBIKE));
		}
		if (this.hasColumn(DataBaseElements.BIKEUSAGE_IDENDSTORAGE, row)) {
			obj.setIdEndStorage(row.getInt(DataBaseElements.BIKEUSAGE_IDENDSTORAGE));
		}
		if (this.hasColumn(DataBaseElements.BIKEUSAGE_STARTDATE, row)) {
			obj.setStartDate(row.getDate(DataBaseElements.BIKEUSAGE_STARTDATE));
		}
		if (this.hasColumn(DataBaseElements.BIKEUSAGE_ENDDATE, row)) {
			obj.setEndDate(row.getDate(DataBaseElements.BIKEUSAGE_ENDDATE));
		}
		if (this.hasColumn(DataBaseElements.BIKEUSAGE_COMMENTS, row)) {
			obj.setComments(row.getString(DataBaseElements.BIKEUSAGE_COMMENTS));
		}

		return obj;
	}
}
