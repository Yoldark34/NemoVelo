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
public class SubscriptionMapper extends AbstractMapper {

	public ArrayList<Subscription> getAllSubscriptions() throws SQLException, ClassNotFoundException {
		DbConnection adapter = DbConnection.getDbConnection();
		adapter.executeSelectQuery("Select * from " + DataBaseElements.SUBSCRIPTION);
		return (ArrayList<Subscription>) adapter.getModelsFromRequest(this);
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
			obj.setStartDate(row.getDate(DataBaseElements.SUBSCRIPTION_STARTDATE));
		}
		if (this.hasColumn(DataBaseElements.SUBSCRIPTION_ENDDATE, row)) {
			obj.setEndDate(row.getDate(DataBaseElements.SUBSCRIPTION_ENDDATE));
		}

		return obj;
	}
}
