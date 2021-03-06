/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.object.ReturnAmount;


/**
 *
 * @author Yoldark34 <yoldark@gmail.com>
 */
public class ReturnAmountMapper extends AbstractMapper {

	/**
	 * get all return amount from a database
	 *
	 * @return ArrayList<ReturnAmount>
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<ReturnAmount> getAllReturnAmount() throws SQLException, ClassNotFoundException {
		DbConnection adapter = DbConnection.getDbConnection();
		adapter.executeSelectQuery("Select * from " + DataBaseElements.RETURNAMOUNT);
		return (ArrayList<ReturnAmount>) adapter.getModelsFromRequest(this);
	}

	/**
	 * Insert returnAmount if id == -1 or update returnAmount instead
	 *
	 * @param returnAmount
	 * @return int number of rows
	 */
	public int save(ReturnAmount returnAmount) {
		int nbRows = 0;
		String query;
		int idResult = -1;

		if (returnAmount.getId() != -1) {
			query = "UPDATE `" + DataBaseElements.RETURNAMOUNT + "` SET ";
			//query += "`"+DataBaseElements.RETURNAMOUNT_ID+"` = '"+returnAmount.getId()+"',";Can't be updated because used in where

			if (returnAmount.getIdSubscription() == -1) {
				query += "`" + DataBaseElements.RETURNAMOUNT_IDSUBSCRIPTION + "` = NULL,";
			} else {
				query += "`" + DataBaseElements.RETURNAMOUNT_IDSUBSCRIPTION + "` = '" + returnAmount.getIdSubscription() + "',";
			}
			if (returnAmount.getAmount() != -1) {
				query += "`" + DataBaseElements.RETURNAMOUNT_AMOUNT + "` = '" + returnAmount.getAmount() + "',";
			} else {
				query += "NULL,";
			}
			if (returnAmount.getReturnDate() == null) {
				query += "`" + DataBaseElements.RETURNAMOUNT_RETURNDATE + "` = " + returnAmount.getReturnDate() + ",";
			} else {
				query += "`" + DataBaseElements.RETURNAMOUNT_RETURNDATE + "` = '" + returnAmount.getReturnDate() + "'";
			}

			query += " WHERE `" + DataBaseElements.RETURNAMOUNT_ID + "` = '" + returnAmount.getId() + "';";

			try {
				DbConnection adapter = DbConnection.getDbConnection();
				nbRows = adapter.executeUpdateQuery(query);
			} catch (Exception e) {
			}
			return nbRows;
		} else {
			query = "INSERT INTO " + DataBaseElements.RETURNAMOUNT + " (";
			//query +=  "`" + DataBaseElements.RETURNAMOUNT_ID + "`,";
			query += "`" + DataBaseElements.RETURNAMOUNT_IDSUBSCRIPTION + "`,";
			query += "`" + DataBaseElements.RETURNAMOUNT_AMOUNT + "`,";
			query += "`" + DataBaseElements.RETURNAMOUNT_RETURNDATE + "` ";

			query += ") VALUES (";
			//query += "'" + returnAmount.getId() + "',";
			if (returnAmount.getIdSubscription() == -1) {
				query += "NULL,";
			} else {
				query += "'" + returnAmount.getIdSubscription() + "',";
			}
			if (returnAmount.getAmount() != -1) {
				query += "'" + returnAmount.getAmount() + "',";
			} else {
				query += "NULL,";
			}
			if (returnAmount.getReturnDate() == null) {
				query += returnAmount.getReturnDate() + ",";
			} else {
				query += "'" + returnAmount.getReturnDate() + "'";
			}

			query += ")";

			try {
				DbConnection adapter = DbConnection.getDbConnection();
				idResult = adapter.executeInsertQuery(query);
			} catch (Exception e) {
			}
			return idResult;
		}

		
	}

	@Override
	public Object populateModel(ResultSet row) throws SQLException {
		ReturnAmount obj = new ReturnAmount();
		if (this.hasColumn(DataBaseElements.RETURNAMOUNT_ID, row)) {
			obj.setId(row.getInt(DataBaseElements.RETURNAMOUNT_ID));
		}
		if (this.hasColumn(DataBaseElements.RETURNAMOUNT_IDSUBSCRIPTION, row)) {
			obj.setIdSubscription(row.getInt(DataBaseElements.RETURNAMOUNT_IDSUBSCRIPTION));
		}
		if (this.hasColumn(DataBaseElements.RETURNAMOUNT_AMOUNT, row)) {
			obj.setAmount(row.getFloat(DataBaseElements.RETURNAMOUNT_AMOUNT));
		}
		if (this.hasColumn(DataBaseElements.RETURNAMOUNT_RETURNDATE, row)) {
			obj.setReturnDate(row.getTimestamp(DataBaseElements.RETURNAMOUNT_RETURNDATE));
		}

		return obj;
	}

	@Override
	Object getEmptyModel() {
		return new ReturnAmount();
	}

	/**
	 * delete a return amount
	 *
	 * @param idReturnAmountToDelete
	 * @return boolean
	 */
	public boolean deleteReturnAmountById(ArrayList<Integer> idReturnAmountToDelete) {
		if (idReturnAmountToDelete.size() <= 0) {
			return true;
		}
		String query;
		int nbRows = 0;

		query = "DELETE";
		query += " FROM ";
		query += DataBaseElements.RETURNAMOUNT;
		query += " WHERE ";
		query += DataBaseElements.RETURNAMOUNT_ID;
		query += " IN ";
		query += " ( ";
		int size = idReturnAmountToDelete.size() - 1;
		for (Integer idReturnAmount : idReturnAmountToDelete) {
			query += "'" + idReturnAmount + "'";
			if (size != 0) {
				query += ", ";
			}
			size--;
		}
		query += " ) ";

		try {
			DbConnection adapter = DbConnection.getDbConnection();
			nbRows = adapter.executeUpdateQuery(query);
		} catch (Exception e) {
		}

		if (nbRows <= 0) {
			return false;
		}
		return true;
	}
}
