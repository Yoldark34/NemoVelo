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
import model.object.ReturnAmount;


/**
 *
 * @author Yoldark34 <yoldark@gmail.com>
 */
public class ReturnAmountMapper extends AbstractMapper {

	public ArrayList<Payment> getAllPayments() throws SQLException, ClassNotFoundException {
		DbConnection adapter = DbConnection.getDbConnection();
		adapter.executeSelectQuery("Select * from " + DataBaseElements.PAYMENT);
		return (ArrayList<Payment>) adapter.getModelsFromRequest(this);
	}

	public int save(ReturnAmount returnAmount) {
		int nbRows = 0;
		String query;

		if (returnAmount.getId() != -1) {
			query = "UPDATE `" + DataBaseElements.PAYMENT + "` SET ";
			//query += "`"+DataBaseElements.PAYMENT_ID+"` = '"+payment.getId()+"',";Can't be updated because used in where

			if (returnAmount.getIdSubscription() == -1) {
				query += "`" + DataBaseElements.PAYMENT_IDSUBSCRIPTION + "` = NULL,";
			} else {
				query += "`" + DataBaseElements.PAYMENT_IDSUBSCRIPTION + "` = '" + returnAmount.getIdSubscription() + "',";
			}
			
			query += "`" + DataBaseElements.PAYMENT_AMOUNT + "` = '" + returnAmount.getAmount() + "',";
			if (returnAmount.getReturnDate() == null) {
				query += "`" + DataBaseElements.PAYMENT_PAYMENTDATE + "` = " + returnAmount.getReturnDate() + ",";
			} else {
				query += "`" + DataBaseElements.PAYMENT_PAYMENTDATE + "` = '" + returnAmount.getReturnDate() + "'";
			}

			query += " WHERE `" + DataBaseElements.PAYMENT_ID + "` = '" + returnAmount.getId() + "';";
		} else {
			query = "INSERT INTO " + DataBaseElements.PAYMENT + " (";
			//query +=  "`" + DataBaseElements.PAYMENT_ID + "`,";
			query += "`" + DataBaseElements.PAYMENT_IDSUBSCRIPTION + "`,";
			query += "`" + DataBaseElements.PAYMENT_AMOUNT + "`,";
			query += "`" + DataBaseElements.PAYMENT_PAYMENTDATE + "` ";

			query += ") VALUES (";
			//query += "'" + payment.getId() + "',";
			if (returnAmount.getIdSubscription() == -1) {
				query += "NULL,";
			} else {
				query += "'" + returnAmount.getIdSubscription() + "',";
			}
			
			query += "'" + returnAmount.getAmount() + "',";
			if (returnAmount.getReturnDate() == null) {
				query += returnAmount.getReturnDate() + ",";
			} else {
				query += "'" + returnAmount.getReturnDate() + "'";
			}

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
			obj.setPaymentDate(row.getTimestamp(DataBaseElements.PAYMENT_PAYMENTDATE));
		}

		return obj;
	}

	@Override
	Object getEmptyModel() {
		return new ReturnAmount();
	}
}
