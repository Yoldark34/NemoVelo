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

	public int save(Contact contact) {
		int nbRows = 0;
		String query;
		if (contact.getId() != -1) {
			query = "UPDATE `" + DataBaseElements.CONTACT + "` SET ";
			//query += "`"+DataBaseElements.CONTACT_ID+"` = '"+contact.getId()+"',";Can't be updated because used in where
			query += "`" + DataBaseElements.CONTACT_STREETNUMBER + "` = '" + contact.getStreetNumber() + "',";
			query += "`" + DataBaseElements.CONTACT_STREETNAME + "` = '" + contact.getStreetName() + "',";
			query += "`" + DataBaseElements.CONTACT_ZIPCODE + "` = '" + contact.getZipCode() + "',";
			query += "`" + DataBaseElements.CONTACT_CITY + "` = '" + contact.getCity() + "',";
			query += "`" + DataBaseElements.CONTACT_COUNTRY + "` = '" + contact.getCountry() + "',";
			query += "`" + DataBaseElements.CONTACT_PHONENUMBER + "` = '" + contact.getPhoneNumber() + "' ";

			query += "WHERE `" + DataBaseElements.CONTACT_ID + "` = '" + contact.getId() + "';";
		} else {
			query = "INSERT INTO " + DataBaseElements.CONTACT + " (";
			//query +=  "`" + DataBaseElements.CONTACT_ID + "`,";
			query += "`" + DataBaseElements.CONTACT_STREETNUMBER + "`,";
			query += "`" + DataBaseElements.CONTACT_STREETNAME + "`,";
			query += "`" + DataBaseElements.CONTACT_ZIPCODE + "`,";
			query += "`" + DataBaseElements.CONTACT_CITY + "`,";
			query += "`" + DataBaseElements.CONTACT_COUNTRY + "`,";
			query += "`" + DataBaseElements.CONTACT_PHONENUMBER + "` ";
			query += ") VALUES (";
			//query += "'" + contact.getId() + "',";
			query += "'" + contact.getStreetNumber() + "',";
			query += "'" + contact.getStreetName() + "',";
			query += "'" + contact.getZipCode() + "',";
			query += "'" + contact.getCity() + "',";
			query += "'" + contact.getCountry() + "',";
			query += "'" + contact.getPhoneNumber() + "' ";

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

	@Override
	Object getEmptyModel() {
		return new Contact();
	}
}
