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
public class BikeUsageMapper extends AbstractMapper {

	public ArrayList<BikeUsage> getAllBikeUsages() throws SQLException, ClassNotFoundException {
		DbConnection adapter = DbConnection.getDbConnection();
		adapter.executeSelectQuery("Select * from " + DataBaseElements.BIKEUSAGE);
		return (ArrayList<BikeUsage>) adapter.getModelsFromRequest(this);
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
