/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import model.object.Payment;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;


/**
 *
 * @author Yoldark34 <yoldark@gmail.com>
 */
public class PaymentMapper extends AbstractMapper {

	/**
	 * get all payments from the database
	 *
	 * @return ArrayList<Payment>
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Payment> getAllPayments() throws SQLException, ClassNotFoundException {
		DbConnection adapter = DbConnection.getDbConnection();
		adapter.executeSelectQuery("Select * from " + DataBaseElements.PAYMENT);
		return (ArrayList<Payment>) adapter.getModelsFromRequest(this);
	}

	/**
	 * Insert payment if id == -1 or update payment instead
	 *
	 * @param payment
	 * @return int number of rows
	 */
	public int save(Payment payment) {
		int nbRows = 0;
		int validated = 0;
		if (payment.isValidated()) {
			validated = 1;
		}
		String query;
		if (payment.getId() != -1) {
			query = "UPDATE `" + DataBaseElements.PAYMENT + "` SET ";
			//query += "`"+DataBaseElements.PAYMENT_ID+"` = '"+payment.getId()+"',";Can't be updated because used in where

			if (payment.getIdSubscription() == -1) {
				query += "`" + DataBaseElements.PAYMENT_IDSUBSCRIPTION + "` = NULL,";
			} else {
				query += "`" + DataBaseElements.PAYMENT_IDSUBSCRIPTION + "` = '" + payment.getIdSubscription() + "',";
			}
			if (payment.getAmount() != -1) {
				query += "`" + DataBaseElements.PAYMENT_AMOUNT + "` = '" + payment.getAmount() + "',";
			} else {
				query += "NULL,";
			}
			if (payment.getPaymentDate() == null) {
				query += "`" + DataBaseElements.PAYMENT_PAYMENTDATE + "` = " + payment.getPaymentDate() + ",";
			} else {
				query += "`" + DataBaseElements.PAYMENT_PAYMENTDATE + "` = '" + payment.getPaymentDate() + "',";
			}
			query += "`" + DataBaseElements.PAYMENT_VALIDATED + "` = '" + validated + "' ";

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
			if (payment.getIdSubscription() == -1) {
				query += "NULL,";
			} else {
				query += "'" + payment.getIdSubscription() + "',";
			}
			if (payment.getAmount() != -1) {
				query += "'" + payment.getAmount() + "',";
			} else {
				query += "NULL,";
			}
			if (payment.getPaymentDate() == null) {
				query += payment.getPaymentDate() + ",";
			} else {
				query += "'" + payment.getPaymentDate() + "',";
			}
			query += "'" + validated + "' ";

			query += ")";
		}

		try {
			DbConnection adapter = DbConnection.getDbConnection();
			nbRows = adapter.executeUpdateQuery(query);
		} catch (Exception e) {
		}
		return nbRows;
	}

	/**
	 * do a payment for a nemouser id
	 *
	 * @param anonymousUserId
	 * @param totalAmount
	 * @param today
	 * @param idSubscription
	 * @return true or false
	 */
	public boolean payAmountForNemoUser(int anonymousUserId, float totalAmount, Timestamp today, int idSubscription) {
		Payment payment = new Payment();
		payment.setAmount(totalAmount);
		payment.setPaymentDate(today);
		payment.setValidated(false);
		payment.setIdSubscription(idSubscription);

		int nb = this.save(payment);
		if (nb > 0) {
			return true;
		}

		return false;
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
			obj.setPaymentDate(row.getTimestamp(DataBaseElements.PAYMENT_PAYMENTDATE));
		}
		if (this.hasColumn(DataBaseElements.PAYMENT_VALIDATED, row)) {
			obj.setValidated(row.getBoolean(DataBaseElements.PAYMENT_VALIDATED));
		}

		return obj;
	}

	@Override
	Object getEmptyModel() {
		return new Payment();
	}
}
