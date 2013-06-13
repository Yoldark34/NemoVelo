/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import controller.terminal.controller.TerminalController;
import model.object.BikeUsage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import resource.log.ProjectLogger;


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
			query += "`" + DataBaseElements.BIKEUSAGE_IDBIKEUSAGETYPE + "`,";
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

	public boolean bookAvailableBikesForTerminal(int terminalId, int numberOfBikes) {
		String query;
		ArrayList<BikeUsage> result = null;
		BikeUsage bu = null;

		query = "SELECT ";
		query += "*";
		query += " FROM ";
		query += DataBaseElements.TERMINAL + " " + DataBaseElements.ALIAS_TERMINAL + ", ";
		query += DataBaseElements.STOCK + " " + DataBaseElements.ALIAS_STOCK + ", ";
		query += DataBaseElements.STORAGE + " " + DataBaseElements.ALIAS_STORAGE + ", ";
		query += DataBaseElements.BIKEUSAGETYPE + " " + DataBaseElements.ALIAS_BIKEUSAGETYPE + ", ";
		query += DataBaseElements.BIKEUSAGE + " " + DataBaseElements.ALIAS_BIKEUSAGE + " ";
		query += " WHERE ";
		query += DataBaseElements.ALIAS_STOCK + "." + DataBaseElements.STOCK_ID + " = " + DataBaseElements.ALIAS_STORAGE + "." + DataBaseElements.STORAGE_IDSTOCK;
		query += " AND ";
		query += DataBaseElements.ALIAS_STORAGE + "." + DataBaseElements.STORAGE_ID + " = " + DataBaseElements.ALIAS_BIKEUSAGE + "." + DataBaseElements.BIKEUSAGE_IDENDSTORAGE;
		query += " AND ";
		query += DataBaseElements.ALIAS_BIKEUSAGETYPE + "." + DataBaseElements.BIKEUSAGETYPE_ID + " = " + DataBaseElements.ALIAS_BIKEUSAGE + "." + DataBaseElements.BIKEUSAGE_IDBIKEUSAGETYPE;
		query += " AND ";
		query += DataBaseElements.ALIAS_BIKEUSAGETYPE + "." + DataBaseElements.BIKEUSAGETYPE_NAME + " = '" + DataBaseElements.BikeUsageType.STOCKING + "'";
		query += " AND ";
		query += DataBaseElements.ALIAS_TERMINAL + "." + DataBaseElements.TERMINAL_ID + " = " + terminalId;

		try {
			DbConnection adapter = DbConnection.getDbConnection();
			adapter.executeSelectQuery(query);
			result = (ArrayList<BikeUsage>) adapter.getModelsFromRequest(this);
		} catch (SQLException | ClassNotFoundException ex) {
			ProjectLogger.log(this, Level.SEVERE, "Erreur d'exécution de la requête de la fonction bookFirstAvailableBikeForTerminal", ex);
		}

		if (!result.isEmpty()) {
			java.sql.Timestamp sqlToday = Helper.getSqlDateNow();
			NemoUserMapper num = new NemoUserMapper();

			for (int i = 0; i < numberOfBikes; i++) {
				bu = result.get(i);
				bu.setEndDate(sqlToday);
				//TODO ask user to login before or create anonymous user
				//bu.setIdNemoUser();
				this.save(bu);

				bu.setId(-1);
				bu.setIdNemoUser(-1);

				BikeUsageTypeMapper btm = new BikeUsageTypeMapper();
				try {
					bu.setIdBikeUsageType(btm.getBikeUsagesType(DataBaseElements.BikeUsageType.BOOKING).getId());
					bu.setIdNemoUser(num.createAnonymousUser());
					TerminalController.setAnonymousUserId(bu.getIdNemoUser());
					bu.setStartDate(sqlToday);
					bu.setEndDate(null);

					this.save(bu);
				} catch (SQLException | ClassNotFoundException ex) {
					ProjectLogger.log(this, Level.SEVERE, "Erreur d'exécution de la requête de la fonction bookFirstAvailableBikeForTerminal", ex);
				}

				return true;
			}
		}

		return false;
	}

	public boolean rentBookedBikesForNemoUser(int anonymousUserId, Timestamp today) {
		String query;
		ArrayList<BikeUsage> result = null;
		BikeUsage bu;
		boolean error = false;
		int nbRow;

		query = "SELECT ";
		query += DataBaseElements.BikeUsageColSet.FULL;
		query += " FROM ";
		query += DataBaseElements.BIKEUSAGETYPE + " " + DataBaseElements.ALIAS_BIKEUSAGETYPE + ", ";
		query += DataBaseElements.BIKEUSAGE + " " + DataBaseElements.ALIAS_BIKEUSAGE + " ";
		query += " WHERE ";
		query += DataBaseElements.ALIAS_BIKEUSAGETYPE + "." + DataBaseElements.BIKEUSAGETYPE_ID + " = " + DataBaseElements.ALIAS_BIKEUSAGE + "." + DataBaseElements.BIKEUSAGE_IDBIKEUSAGETYPE;
		query += " AND ";
		query += DataBaseElements.ALIAS_BIKEUSAGETYPE + "." + DataBaseElements.BIKEUSAGETYPE_NAME + " = '" + DataBaseElements.BikeUsageType.BOOKING + "'";
		query += " AND ";
		query += DataBaseElements.ALIAS_BIKEUSAGE + "." + DataBaseElements.BIKEUSAGE_IDNEMOUSER + " = " + anonymousUserId;

		try {
			DbConnection adapter = DbConnection.getDbConnection();
			adapter.executeSelectQuery(query);
			result = (ArrayList<BikeUsage>) adapter.getModelsFromRequest(this);
		} catch (SQLException | ClassNotFoundException ex) {
			ProjectLogger.log(this, Level.SEVERE, "Erreur d'exécution de la requête de la fonction bookFirstAvailableBikeForTerminal", ex);
		}

		if (!result.isEmpty()) {
			for (int i = 0; i < result.size(); i++) {
				bu = result.get(i);
				bu.setEndDate(today);
				//TODO ask user to login before or create anonymous user
				//bu.setIdNemoUser();
				nbRow = this.save(bu);
				if (nbRow <= 0) {
					error = true;
				}

				bu.setId(-1);

				BikeUsageTypeMapper btm = new BikeUsageTypeMapper();
				try {
					bu.setIdBikeUsageType(btm.getBikeUsagesType(DataBaseElements.BikeUsageType.RENTING).getId());
					bu.setStartDate(today);
					bu.setEndDate(null);

					nbRow = this.save(bu);
					if (nbRow <= 0) {
						error = true;
					}
				} catch (SQLException | ClassNotFoundException ex) {
					ProjectLogger.log(this, Level.SEVERE, "Erreur d'exécution de la requête de la fonction bookFirstAvailableBikeForTerminal", ex);
				}

				return !error;
			}
		}
		return false;
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
			obj.setStartDate(row.getTimestamp(DataBaseElements.BIKEUSAGE_STARTDATE));
		}
		if (this.hasColumn(DataBaseElements.BIKEUSAGE_ENDDATE, row)) {
			obj.setEndDate(row.getTimestamp(DataBaseElements.BIKEUSAGE_ENDDATE));
		}
		if (this.hasColumn(DataBaseElements.BIKEUSAGE_COMMENTS, row)) {
			obj.setComments(row.getString(DataBaseElements.BIKEUSAGE_COMMENTS));
		}

		return obj;
	}

	@Override
	Object getEmptyModel() {
		return new BikeUsage();
	}
}
