/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import model.object.Stock;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Yoldark34 <yoldark@gmail.com>
 */
public class StockMapper extends AbstractMapper {

	public ArrayList<Stock> getAllStocks() throws SQLException, ClassNotFoundException {
		DbConnection adapter = DbConnection.getDbConnection();
		adapter.executeSelectQuery("Select * from " + DataBaseElements.STOCK);
		return (ArrayList<Stock>) adapter.getModelsFromRequest(this);
	}

	public int save(Stock stock) {
		int nbRows = 0;
		String query = "";
		if (stock.getId() != -1) {
			query = "UPDATE `" + DataBaseElements.STOCK + "` SET ";
			//query += "`"+DataBaseElements.STOCK_ID+"` = '"+stock.getId()+"',";Can't be updated because used in where
			query += "`" + DataBaseElements.STOCK_CODE + "` = '" + stock.getCode() + "',";
			query += "`" + DataBaseElements.STOCK_NAME + "` = '" + stock.getName() + "',";
			query += "`" + DataBaseElements.STOCK_DESCRIPTION + "` = '" + stock.getDescription() + "',";
			query += "`" + DataBaseElements.STOCK_LATITUDE + "` = '" + stock.getLatitude() + "',";
			query += "`" + DataBaseElements.STOCK_LONGITUDE + "` = '" + stock.getLongitude() + "' ";

			query += "WHERE `" + DataBaseElements.STOCK_ID + "` = '" + stock.getId() + "';";
		} else {
			query = "INSERT INTO " + DataBaseElements.STOCK + " (";
			//query +=  "`" + DataBaseElements.STOCK_ID + "`,";
			query += "`" + DataBaseElements.STOCK_CODE + "`,";
			query += "`" + DataBaseElements.STOCK_NAME + "`,";
			query += "`" + DataBaseElements.STOCK_DESCRIPTION + "`,";
			query += "`" + DataBaseElements.STOCK_LATITUDE + "`,";
			query += "`" + DataBaseElements.STOCK_LONGITUDE + "` ";

			query += ") VALUES (";
			//query += "'" + stock.getId() + "',";
			query += "'" + stock.getCode() + "',";
			query += "'" + stock.getName() + "',";
			query += "'" + stock.getDescription() + "',";
			query += "'" + stock.getLatitude() + "',";
			query += "'" + stock.getLongitude() + "' ";

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
		Stock obj = new Stock();
		if (this.hasColumn(DataBaseElements.STOCK_ID, row)) {
			obj.setId(row.getInt(DataBaseElements.STOCK_ID));
		}
		if (this.hasColumn(DataBaseElements.STOCK_CODE, row)) {
			obj.setCode(row.getString(DataBaseElements.STOCK_CODE));
		}
		if (this.hasColumn(DataBaseElements.STOCK_NAME, row)) {
			obj.setName(row.getString(DataBaseElements.STOCK_NAME));
		}
		if (this.hasColumn(DataBaseElements.STOCK_DESCRIPTION, row)) {
			obj.setDescription(row.getString(DataBaseElements.STOCK_DESCRIPTION));
		}
		if (this.hasColumn(DataBaseElements.STOCK_LATITUDE, row)) {
			obj.setLatitude(row.getFloat(DataBaseElements.STOCK_LATITUDE));
		}
		if (this.hasColumn(DataBaseElements.STOCK_LONGITUDE, row)) {
			obj.setLongitude(row.getFloat(DataBaseElements.STOCK_LONGITUDE));
		}

		return obj;
	}
}
