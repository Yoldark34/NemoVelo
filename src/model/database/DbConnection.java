/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import java.sql.*;

/**
 *
 * @author Yoldark34 <yoldark@gmail.com>
 */
public class DbConnection {

	public static void main(String[] args) {
		executeQuery("Select * from bike");
	}

	public static ResultSet executeQuery(String select) {
		/* Connexion à la base de données */
		String url = "jdbc:mysql://localhost:3306/nemovelo";
		String utilisateur = "root";
		String motDePasse = "";
		Connection connection = null;
		ResultSet resultat = null;
		try {
			connection = (Connection) DriverManager.getConnection(url, utilisateur, motDePasse);

			Statement statement = connection.createStatement();
			resultat = statement.executeQuery(select);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ignore) {
				}
			}
		}

		return resultat;
	}

	public static boolean hasColumn(ResultSet rs, String columnName) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		int columns = rsmd.getColumnCount();
		for (int x = 1; x <= columns; x++) {
			if (columnName.equals(rsmd.getColumnName(x))) {
				return true;
			}
		}
		return false;
	}
}
