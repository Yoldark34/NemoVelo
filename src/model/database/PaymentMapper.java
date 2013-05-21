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
public class PaymentMapper extends AbstractMapper {

	public ArrayList<Payment> getAllPayments() throws SQLException, ClassNotFoundException {
		DbConnection adapter = DbConnection.getDbConnection();
		adapter.executeSelectQuery("Select * from " + DataBaseElements.PAYMENT);
		return (ArrayList<Payment>) adapter.getModelsFromRequest(this);
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
