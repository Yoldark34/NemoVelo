/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import model.object.Contact;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Yoldark34 <yoldark@gmail.com>
 */
public class ContactMapper extends AbstractMapper {

	public ArrayList<Contact> getAllContacts() throws SQLException, ClassNotFoundException {
		DbConnection adapter = DbConnection.getDbConnection();
		adapter.executeSelectQuery("Select * from " + DataBaseElements.CONTACT);
		return (ArrayList<Contact>) adapter.getModelsFromRequest(this);
	}

	@Override
	public Object populateModel(ResultSet row) throws SQLException {
		Contact obj = new Contact();
		if (this.hasColumn(DataBaseElements.CONTACT_ID, row)) {
			obj.setId(row.getInt(DataBaseElements.CONTACT_ID));
		}
		if (this.hasColumn(DataBaseElements.CONTACT_STREETNUMBER, row)) {
			obj.setStreetNumber(row.getInt(DataBaseElements.CONTACT_STREETNUMBER));
		}
		if (this.hasColumn(DataBaseElements.CONTACT_STREETNAME, row)) {
			obj.setStreetName(row.getString(DataBaseElements.CONTACT_STREETNAME));
		}
		if (this.hasColumn(DataBaseElements.CONTACT_ZIPCODE, row)) {
			obj.setZipCode(row.getString(DataBaseElements.CONTACT_ZIPCODE));
		}
		if (this.hasColumn(DataBaseElements.CONTACT_CITY, row)) {
			obj.setCity(row.getString(DataBaseElements.CONTACT_CITY));
		}
		if (this.hasColumn(DataBaseElements.CONTACT_COUNTRY, row)) {
			obj.setCountry(row.getString(DataBaseElements.CONTACT_COUNTRY));
		}
		if (this.hasColumn(DataBaseElements.CONTACT_PHONENUMBER, row)) {
			obj.setPhoneNumber(row.getString(DataBaseElements.CONTACT_PHONENUMBER));
		}

		return obj;
	}
}
