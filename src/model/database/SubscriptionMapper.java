/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import model.object.Subscription;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import resource.log.ProjectLogger;


/**
 *
 * @author Yoldark34 <yoldark@gmail.com>
 */
public class SubscriptionMapper extends AbstractMapper {

	public ArrayList<Subscription> getAllSubscriptions() throws SQLException, ClassNotFoundException {
		DbConnection adapter = DbConnection.getDbConnection();
		adapter.executeSelectQuery("Select * from " + DataBaseElements.SUBSCRIPTION);
		return (ArrayList<Subscription>) adapter.getModelsFromRequest(this);
	}

	public int save(Subscription subscription) {
		int nbRows = 0;
		int idResult = -1;
		String query;
		if (subscription.getId() != -1) {
			query = "UPDATE `" + DataBaseElements.SUBSCRIPTION + "` SET ";
			//query += "`"+DataBaseElements.SUBSCRIPTION_ID+"` = '"+subscription.getId()+"',";Can't be updated because used in where
			query += "`" + DataBaseElements.SUBSCRIPTION_IDPRICE + "` = '" + subscription.getIdPrice() + "',";
			query += "`" + DataBaseElements.SUBSCRIPTION_IDNEMOUSER + "` = '" + subscription.getIdNemoUser() + "',";
			query += "`" + DataBaseElements.SUBSCRIPTION_AMOUNT + "` = '" + subscription.getAmount() + "',";
			if (subscription.getStartDate() == null) {
				query += "`" + DataBaseElements.SUBSCRIPTION_STARTDATE + "` = " + subscription.getStartDate() + ",";
			} else {
				query += "`" + DataBaseElements.SUBSCRIPTION_STARTDATE + "` = '" + subscription.getStartDate() + "',";
			}
			if (subscription.getEndDate() == null) {
				query += "`" + DataBaseElements.SUBSCRIPTION_ENDDATE + "` = " + subscription.getEndDate() + " ";
			} else {
				query += "`" + DataBaseElements.SUBSCRIPTION_ENDDATE + "` = '" + subscription.getEndDate() + "' ";
			}

			query += "WHERE `" + DataBaseElements.SUBSCRIPTION_ID + "` = '" + subscription.getId() + "';";
			try {
				DbConnection adapter = DbConnection.getDbConnection();
				nbRows = adapter.executeUpdateQuery(query);
			} catch (Exception e) {
			}
			return nbRows;
		} else {
			query = "INSERT INTO " + DataBaseElements.SUBSCRIPTION + " (";
			//query +=  "`" + DataBaseElements.SUBSCRIPTION_ID + "`,";
			query += "`" + DataBaseElements.SUBSCRIPTION_IDPRICE + "`,";
			query += "`" + DataBaseElements.SUBSCRIPTION_IDNEMOUSER + "`,";
			query += "`" + DataBaseElements.SUBSCRIPTION_AMOUNT + "`,";
			query += "`" + DataBaseElements.SUBSCRIPTION_STARTDATE + "`,";
			query += "`" + DataBaseElements.SUBSCRIPTION_ENDDATE + "` ";

			query += ") VALUES (";
			//query += "'" + subscription.getId() + "',";
			query += "'" + subscription.getIdPrice() + "',";
			query += "'" + subscription.getIdNemoUser() + "',";
			query += "'" + subscription.getAmount() + "',";
			if (subscription.getStartDate() == null) {
				query += subscription.getStartDate() + ",";
			} else {
				query += "'" + subscription.getStartDate() + "',";
			}
			if (subscription.getEndDate() == null) {
				query += subscription.getEndDate() + " ";
			} else {
				query += "'" + subscription.getEndDate() + "' ";
			}

			query += ")";

			try {
				DbConnection adapter = DbConnection.getDbConnection();
				idResult = adapter.executeInsertQuery(query);
			} catch (Exception e) {
			}
			return idResult;
		}
	}

	public ArrayList<Subscription> getSubscriptionsFromNemoUser(int idNemoUser) {
		String query;
		ArrayList<Subscription> results = new ArrayList<>();

		query = "SELECT ";
		query += "*";
		query += " FROM ";
		query += DataBaseElements.SUBSCRIPTION + " " + DataBaseElements.ALIAS_SUBSCRIPTION;
		query += " WHERE ";
		query += DataBaseElements.ALIAS_SUBSCRIPTION + "." + DataBaseElements.SUBSCRIPTION_IDNEMOUSER + " = '" + idNemoUser + "'";

		try {
			DbConnection adapter = DbConnection.getDbConnection();
			adapter.executeSelectQuery(query);
			results = (ArrayList<Subscription>) adapter.getModelsFromRequest(this);
		} catch (SQLException | ClassNotFoundException ex) {
			ProjectLogger.log(this, Level.SEVERE, "Erreur d'exécution de la requête de la fonction getUniquePriceDurationUnitForRent", ex);
		}

		return results;
	}

	@Override
	public Object populateModel(ResultSet row) throws SQLException {
		Subscription obj = new Subscription();
		if (this.hasColumn(DataBaseElements.SUBSCRIPTION_ID, row)) {
			obj.setId(row.getInt(DataBaseElements.SUBSCRIPTION_ID));
		}
		if (this.hasColumn(DataBaseElements.SUBSCRIPTION_IDPRICE, row)) {
			obj.setIdPrice(row.getInt(DataBaseElements.SUBSCRIPTION_IDPRICE));
		}
		if (this.hasColumn(DataBaseElements.SUBSCRIPTION_IDNEMOUSER, row)) {
			obj.setIdNemoUser(row.getInt(DataBaseElements.SUBSCRIPTION_IDNEMOUSER));
		}
		if (this.hasColumn(DataBaseElements.SUBSCRIPTION_AMOUNT, row)) {
			obj.setAmount(row.getFloat(DataBaseElements.SUBSCRIPTION_AMOUNT));
		}
		if (this.hasColumn(DataBaseElements.SUBSCRIPTION_STARTDATE, row)) {
			obj.setStartDate(row.getTimestamp(DataBaseElements.SUBSCRIPTION_STARTDATE));
		}
		if (this.hasColumn(DataBaseElements.SUBSCRIPTION_ENDDATE, row)) {
			obj.setEndDate(row.getTimestamp(DataBaseElements.SUBSCRIPTION_ENDDATE));
		}

		return obj;
	}

	@Override
	Object getEmptyModel() {
		return new Subscription();
	}
}
