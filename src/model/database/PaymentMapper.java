/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import model.object.Payment;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Yoldark34 <yoldark@gmail.com>
 */
public class PaymentMapper extends AbstractMapper {

	public ArrayList<Payment> getAllPayments() throws SQLException, ClassNotFoundException {
		DbConnection adapter = DbConnection.getDbConnection();
		adapter.executeSelectQuery("Select * from " + DataBaseElements.PAYMENT);
		return (ArrayList<Payment>) adapter.getModelsFromRequest(this);
	}

	public int save(Payment payment) {
		int nbRows = 0;
		String query;
		if (payment.getId() != -1) {
			query = "UPDATE `" + DataBaseElements.PAYMENT + "` SET ";
			//query += "`"+DataBaseElements.PAYMENT_ID+"` = '"+payment.getId()+"',";Can't be updated because used in where
			query += "`" + DataBaseElements.PAYMENT_IDSUBSCRIPTION + "` = '" + payment.getIdSubscription() + "',";
			query += "`" + DataBaseElements.PAYMENT_AMOUNT + "` = '" + payment.getAmount() + "',";
			if (payment.getPaymentDate() == null) {
				query += "`" + DataBaseElements.PAYMENT_PAYMENTDATE + "` = " + payment.getPaymentDate() + ",";
			} else {
				query += "`" + DataBaseElements.PAYMENT_PAYMENTDATE + "` = '" + payment.getPaymentDate() + "',";
			}
			query += "`" + DataBaseElements.PAYMENT_VALIDATED + "` = '" + payment.isValidated() + "' ";

			query += "WHERE `" + DataBaseElements.PAYMENT_ID + "` = '" + payment.getId() + "';";
		} else {
			query = "INSERT INTO " + DataBaseElements.PAYMENT + " (";
			//query +=  "`" + DataBaseElements.PAYMENT_ID + "`,";
			query += "`" + DataBaseElements.PAYMENT_IDSUBSCRIPTION + "`,";
			query += "`" + DataBaseElements.PAYMENT_AMOUNT + "`,";
			query += "`" + DataBaseElements.PAYMENT_PAYMENTDATE + "`,";
			query += "`" + DataBaseElements.PAYMENT_VALIDATED + "` ";

			query += ") VALUES (";
			//query += "'" + payment.getId() + "',";
			query += "'" + payment.getIdSubscription() + "',";
			query += "'" + payment.getAmount() + "',";
			if (payment.getPaymentDate() == null) {
				query += payment.getPaymentDate() + ",";
			} else {
				query += "'" + payment.getPaymentDate() + "',";
			}
			query += "'" + payment.isValidated() + "' ";

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
		Payment obj = new Payment();
		if (this.hasColumn(DataBaseElements.PAYMENT_ID, row)) {
			obj.setId(row.getInt(DataBaseElements.PAYMENT_ID));
		}
		if (this.hasColumn(DataBaseElements.PAYMENT_IDSUBSCRIPTION, row)) {
			obj.setIdSubscription(row.getInt(DataBaseElements.PAYMENT_IDSUBSCRIPTION));
		}
		if (this.hasColumn(DataBaseElements.PAYMENT_AMOUNT, row)) {
			obj.setAmount(row.getFloat(DataBaseElements.PAYMENT_AMOUNT));
		}
		if (this.hasColumn(DataBaseElements.PAYMENT_PAYMENTDATE, row)) {
			obj.setPaymentDate(row.getDate(DataBaseElements.PAYMENT_PAYMENTDATE));
		}
		if (this.hasColumn(DataBaseElements.PAYMENT_VALIDATED, row)) {
			obj.setValidated(row.getBoolean(DataBaseElements.PAYMENT_VALIDATED));
		}

		return obj;
	}
}
