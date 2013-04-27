/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Yoldark34 <yoldark@gmail.com>
 */
public class DbConnection {

	private Connection connection;
	private ResultSet results;

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		/*BikeMapper bm = new BikeMapper();
		 ArrayList<Bike> test = bm.getAllBikes();If you want to test*/
	}

	public DbConnection() {
		this.connection = null;
		this.results = null;
	}

	public ResultSet getResults() {
		return results;
	}

	public boolean executeQuery(String select) {
		/* Connexion à la base de données */
		String url = "jdbc:mysql://localhost:3306/nemovelo";
		String utilisateur = "root";
		String motDePasse = "";
		
		
		try {
			this.connection = (Connection) DriverManager.getConnection(url, utilisateur, motDePasse);
			Statement statement = this.connection.createStatement();
			this.results = statement.executeQuery(select);
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean closeConnection() {
		if (this.connection != null) {
			try {
				this.connection.close();
				this.connection = null;
				return true;
			} catch (SQLException ignore) {
			}
		}
		return false;
	}



	public Collection<?> getModelsFromRequest(AbstractMapper callClass) throws SQLException, ClassNotFoundException {
		ArrayList<Object> myCol = new ArrayList<>();
		while (this.results.next()) {
			myCol.add(callClass.populateModel(this.results));
		}
		return myCol;
	}
}
