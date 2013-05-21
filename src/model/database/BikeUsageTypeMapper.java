/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import model.object.BikeUsageType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Yoldark34 <yoldark@gmail.com>
 */
public class BikeUsageTypeMapper extends AbstractMapper {

	public ArrayList<BikeUsageType> getAllBikeUsages() throws SQLException, ClassNotFoundException {
		DbConnection adapter = DbConnection.getDbConnection();
		adapter.executeSelectQuery("Select * from " + DataBaseElements.BIKEUSAGETYPE);
		return (ArrayList<BikeUsageType>) adapter.getModelsFromRequest(this);
	}

	@Override
	public Object populateModel(ResultSet row) throws SQLException {
		BikeUsageType obj = new BikeUsageType();
		if (this.hasColumn(DataBaseElements.BIKEUSAGETYPE_ID, row)) {
			obj.setId(row.getInt(DataBaseElements.BIKEUSAGETYPE_ID));
		}
		if (this.hasColumn(DataBaseElements.BIKEUSAGETYPE_IDPARENT, row)) {
			obj.setId_parent_bike_usage_type(row.getInt(DataBaseElements.BIKEUSAGETYPE_IDPARENT));
		}
		if (this.hasColumn(DataBaseElements.BIKEUSAGETYPE_NAME, row)) {
			obj.setName(row.getString(DataBaseElements.BIKEUSAGETYPE_NAME));
		}
		if (this.hasColumn(DataBaseElements.BIKEUSAGETYPE_DESCRIPTION, row)) {
			obj.setDescription(row.getString(DataBaseElements.BIKEUSAGETYPE_DESCRIPTION));
		}

		return obj;
	}
}
