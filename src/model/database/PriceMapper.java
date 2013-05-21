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
public class PriceMapper extends AbstractMapper {

	public ArrayList<Price> getAllNemoUsers() throws SQLException, ClassNotFoundException {
		DbConnection adapter = DbConnection.getDbConnection();
		adapter.executeSelectQuery("Select * from " + DataBaseElements.PRICE);
		return (ArrayList<Price>) adapter.getModelsFromRequest(this);
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
