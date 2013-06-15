/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import model.object.Price;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import resource.log.ProjectLogger;


/**
 *
 * @author Yoldark34 <yoldark@gmail.com>
 */
public class PriceMapper extends AbstractMapper {

	public ArrayList<Price> getAllNemoUsers() throws SQLException, ClassNotFoundException {
		DbConnection adapter = DbConnection.getDbConnection();
		adapter.executeSelectQuery("Select * from " + DataBaseElements.PRICE);
		return (ArrayList<Price>) adapter.getModelsFromRequest(this);
	}

	public int save(Price price) {
		int nbRows = 0;
		String query;
		if (price.getId() != -1) {
			query = "UPDATE `" + DataBaseElements.PRICE + "` SET ";
			//query += "`"+DataBaseElements.PRICE_ID+"` = '"+price.getId()+"',";Can't be updated because used in where
			query += "`" + DataBaseElements.PRICE_AMOUNT + "` = '" + price.getAmount() + "',";
			query += "`" + DataBaseElements.PRICE_TYPECODE + "` = '" + price.getTypeCode() + "',";
			query += "`" + DataBaseElements.PRICE_NAME + "` = '" + price.getName() + "',";
			query += "`" + DataBaseElements.PRICE_DESCRIPTION + "` = '" + price.getDescription() + "',";
			query += "`" + DataBaseElements.PRICE_DURATION + "` = '" + price.getPriceDuration() + "',";
			query += "`" + DataBaseElements.PRICE_DURATIONUNIT + "` = '" + price.getPriceDurationUnit() + "' ";

			query += "WHERE `" + DataBaseElements.PRICE_ID + "` = '" + price.getId() + "';";
		} else {
			query = "INSERT INTO " + DataBaseElements.PRICE + " (";
			//query +=  "`" + DataBaseElements.PRICE_ID + "`,";
			query += "`" + DataBaseElements.PRICE_AMOUNT + "`,";
			query += "`" + DataBaseElements.PRICE_TYPECODE + "`,";
			query += "`" + DataBaseElements.PRICE_NAME + "`,";
			query += "`" + DataBaseElements.PRICE_DESCRIPTION + "`,";
			query += "`" + DataBaseElements.PRICE_DURATION + "`,";
			query += "`" + DataBaseElements.PRICE_DURATIONUNIT + "` ";
			query += ") VALUES (";
			//query += "'" + price.getId() + "',";
			query += "'" + price.getAmount() + "',";
			query += "'" + price.getTypeCode() + "',";
			query += "'" + price.getName() + "',";
			query += "'" + price.getDescription() + "',";
			query += "'" + price.getPriceDuration() + "',";
			query += "'" + price.getPriceDurationUnit() + "' ";

			query += ")";
		}

		try {
			DbConnection adapter = DbConnection.getDbConnection();
			nbRows = adapter.executeUpdateQuery(query);
		} catch (Exception e) {
		}
		return nbRows;
	}

	public ArrayList<Price> getUniquePriceDurationUnitForRent() {
		String query;
		ArrayList<Price> results = new ArrayList<>();

		query = "SELECT ";
		query += "DISTINCT(";
		query += DataBaseElements.ALIAS_PRICE + "." + DataBaseElements.PRICE_DURATIONUNIT;
		query += ")";
		query += " FROM ";
		query += DataBaseElements.PRICE + " " + DataBaseElements.ALIAS_PRICE;
		query += " WHERE ";
		query += DataBaseElements.ALIAS_PRICE + "." + DataBaseElements.PRICE_TYPECODE + " = '" + DataBaseElements.PriceTypeCode.RENT + "'";

		try {
			DbConnection adapter = DbConnection.getDbConnection();
			adapter.executeSelectQuery(query);
			results = (ArrayList<Price>) adapter.getModelsFromRequest(this);
		} catch (SQLException | ClassNotFoundException ex) {
			ProjectLogger.log(this, Level.SEVERE, "Erreur d'exécution de la requête de la fonction getUniquePriceDurationUnitForRent", ex);
		}

		return results;
	}

	public ArrayList<Price> getPriceDurationForRent(String durationUnit) {
		String query;
		ArrayList<Price> results = new ArrayList<>();

		query = "SELECT ";
		query += DataBaseElements.ALIAS_PRICE + "." + DataBaseElements.PRICE_DURATION;
		query += " FROM ";
		query += DataBaseElements.PRICE + " " + DataBaseElements.ALIAS_PRICE;
		query += " WHERE ";
		query += DataBaseElements.ALIAS_PRICE + "." + DataBaseElements.PRICE_TYPECODE + " = '" + DataBaseElements.PriceTypeCode.RENT + "'";
		query += " AND ";
		query += DataBaseElements.ALIAS_PRICE + "." + DataBaseElements.PRICE_DURATIONUNIT + " = '" + durationUnit + "'";

		try {
			DbConnection adapter = DbConnection.getDbConnection();
			adapter.executeSelectQuery(query);
			results = (ArrayList<Price>) adapter.getModelsFromRequest(this);
		} catch (SQLException | ClassNotFoundException ex) {
			ProjectLogger.log(this, Level.SEVERE, "Erreur d'exécution de la requête de la fonction getPriceDurationForRent", ex);
		}

		return results;
	}

	public float getPriceAmountForUnitAndDuration(int duration, String durationUnit) {
		String query;
		Price result = new Price();

		query = "SELECT ";
		query += DataBaseElements.ALIAS_PRICE + "." + DataBaseElements.PRICE_AMOUNT;
		query += " FROM ";
		query += DataBaseElements.PRICE + " " + DataBaseElements.ALIAS_PRICE;
		query += " WHERE ";
		query += DataBaseElements.ALIAS_PRICE + "." + DataBaseElements.PRICE_TYPECODE + " = '" + DataBaseElements.PriceTypeCode.RENT + "'";
		query += " AND ";
		query += DataBaseElements.ALIAS_PRICE + "." + DataBaseElements.PRICE_DURATIONUNIT + " = '" + durationUnit + "'";
		query += " AND ";
		query += DataBaseElements.ALIAS_PRICE + "." + DataBaseElements.PRICE_DURATION + " = '" + duration + "'";

		try {
			DbConnection adapter = DbConnection.getDbConnection();
			adapter.executeSelectQuery(query);
			result = (Price) adapter.getModelFromRequest(this);
		} catch (SQLException | ClassNotFoundException ex) {
			ProjectLogger.log(this, Level.SEVERE, "Erreur d'exécution de la requête de la fonction getPriceAmountForUnitAndDuration", ex);
		}

		return result.getAmount();
	}

	public Price getFirstGuarantee() {
		String query;
		Price result = null;

		query = "SELECT ";
		query += DataBaseElements.ALIAS_PRICE + "." + DataBaseElements.PRICE_AMOUNT;
		query += " FROM ";
		query += DataBaseElements.PRICE + " " + DataBaseElements.ALIAS_PRICE;
		query += " WHERE ";
		query += DataBaseElements.ALIAS_PRICE + "." + DataBaseElements.PRICE_TYPECODE + " = '" + DataBaseElements.PriceTypeCode.GUARANTEE + "'";

		try {
			DbConnection adapter = DbConnection.getDbConnection();
			adapter.executeSelectQuery(query);
			result = (Price) adapter.getModelFromRequest(this);
		} catch (SQLException | ClassNotFoundException ex) {
			ProjectLogger.log(this, Level.SEVERE, "Erreur d'exécution de la requête de la fonction getFirstGuarantee", ex);
		}

		return result;
	}

	public int getPriceId(String durationUnit, int duration) {
		String query;
		Price result = new Price();

		query = "SELECT ";
		query += DataBaseElements.ALIAS_PRICE + "." + DataBaseElements.PRICE_ID;
		query += " FROM ";
		query += DataBaseElements.PRICE + " " + DataBaseElements.ALIAS_PRICE;
		query += " WHERE ";
		query += DataBaseElements.ALIAS_PRICE + "." + DataBaseElements.PRICE_DURATION + " = '" + duration + "'";
		query += " AND ";
		query += DataBaseElements.ALIAS_PRICE + "." + DataBaseElements.PRICE_DURATIONUNIT + " = '" + durationUnit + "'";

		try {
			DbConnection adapter = DbConnection.getDbConnection();
			adapter.executeSelectQuery(query);
			result = (Price) adapter.getModelFromRequest(this);
		} catch (SQLException | ClassNotFoundException ex) {
			ProjectLogger.log(this, Level.SEVERE, "Erreur d'exécution de la requête de la fonction getPriceId", ex);
		}

		return result.getId();
	}

	public Price GetPriceFromId(int idPrice) {
		String query;
		Price result = new Price();

		query = "SELECT ";
		query += "*";
		query += " FROM ";
		query += DataBaseElements.PRICE + " " + DataBaseElements.ALIAS_PRICE;
		query += " WHERE ";
		query += DataBaseElements.ALIAS_PRICE + "." + DataBaseElements.PRICE_ID + " = '" + idPrice + "'";

		try {
			DbConnection adapter = DbConnection.getDbConnection();
			adapter.executeSelectQuery(query);
			result = (Price) adapter.getModelFromRequest(this);
		} catch (SQLException | ClassNotFoundException ex) {
			ProjectLogger.log(this, Level.SEVERE, "Erreur d'exécution de la requête de la fonction getPriceId", ex);
		}

		return result;
	}

	@Override
	public Object populateModel(ResultSet row) throws SQLException {
		Price obj = new Price();

		if (this.hasColumn(DataBaseElements.PRICE_ID, row)) {
			obj.setId(row.getInt(DataBaseElements.PRICE_ID));
		}
		if (this.hasColumn(DataBaseElements.PRICE_AMOUNT, row)) {
			obj.setAmount(row.getFloat(DataBaseElements.PRICE_AMOUNT));
		}
		if (this.hasColumn(DataBaseElements.PRICE_TYPECODE, row)) {
			obj.setTypeCode(row.getString(DataBaseElements.PRICE_TYPECODE));
		}
		if (this.hasColumn(DataBaseElements.PRICE_NAME, row)) {
			obj.setName(row.getString(DataBaseElements.PRICE_NAME));
		}
		if (this.hasColumn(DataBaseElements.PRICE_DESCRIPTION, row)) {
			obj.setDescription(row.getString(DataBaseElements.PRICE_DESCRIPTION));
		}
		if (this.hasColumn(DataBaseElements.PRICE_DURATION, row)) {
			obj.setPriceDuration(row.getInt(DataBaseElements.PRICE_DURATION));
		}
		if (this.hasColumn(DataBaseElements.PRICE_DURATIONUNIT, row)) {
			obj.setPriceDurationUnit(row.getString(DataBaseElements.PRICE_DURATIONUNIT));
		}

		return obj;
	}

	@Override
	Object getEmptyModel() {
		return new Price();
	}
}
