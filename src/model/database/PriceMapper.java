/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import model.object.Price;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


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
		String query = "";
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
			query += "`" + DataBaseElements.PRICE_TYPECODE + " `,";
			query += "`" + DataBaseElements.PRICE_NAME + "`,";
			query += "`" + DataBaseElements.PRICE_DESCRIPTION + " `,";
			query += "`" + DataBaseElements.PRICE_DURATION + "`,";
			query += "`" + DataBaseElements.PRICE_DURATIONUNIT + " ` ";
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
}
