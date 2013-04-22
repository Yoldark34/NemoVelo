/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Yoldark34 <yoldark@gmail.com>
 */
public class BikeMapper {

	public Collection<Bike> getAllBikes() throws SQLException {
		DbConnection adapter = new DbConnection();
		adapter.executeQuery("Select * from " + DataBaseElementNames.BIKE);
		return this.populateModels(adapter);
	}

	private Collection<Bike> populateModels(DbConnection adapter) throws SQLException {
		Collection<Bike> bikes = new ArrayList<>();
		while (adapter.getResults().next()) {
			Bike bike = new Bike();
			if (adapter.hasColumn(DataBaseElementNames.BIKE_ID)) {
				bike.setId(adapter.getResults().getInt(DataBaseElementNames.BIKE_ID));
			}
			bikes.add(bike);
		}
		return bikes;
	}
}
