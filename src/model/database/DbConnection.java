/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import java.sql.*;
import java.util.Collection;

/**
 *
 * @author Yoldark34 <yoldark@gmail.com>
 */
public class DbConnection {

	private Connection connection;
	private ResultSet results;

	public static void main(String[] args) {
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

	public boolean hasColumn(String columnName) throws SQLException {
		ResultSetMetaData rsmd = this.results.getMetaData();
		int columns = rsmd.getColumnCount();
		for (int x = 1; x <= columns; x++) {
			if (columnName.equals(rsmd.getColumnName(x))) {
				return true;
			}
		}
		return false;
	}
}
