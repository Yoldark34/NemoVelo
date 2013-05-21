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
public class StockMapper extends AbstractMapper {

	public ArrayList<Stock> getAllStocks() throws SQLException, ClassNotFoundException {
		DbConnection adapter = DbConnection.getDbConnection();
		adapter.executeSelectQuery("Select * from " + DataBaseElements.STOCK);
		return (ArrayList<Stock>) adapter.getModelsFromRequest(this);
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
