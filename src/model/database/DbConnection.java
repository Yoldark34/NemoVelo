/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import resource.config.Configuration;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import resource.log.ProjectLogger;

/**
 *
 * @author Yoldark34 <yoldark@gmail.com>
 */
public class DbConnection {

	private static DbConnection dbConnect;

	private Connection connection;
	private ResultSet results;

	public static final DbConnection getDbConnection() {
		if (dbConnect == null) {
			dbConnect = new DbConnection();
		}
		return dbConnect;
	}

	private DbConnection() {
		this.connection = null;
		this.results = null;
	}

	public ResultSet getResults() {
		return results;
	}

	public boolean executeSelectQuery(String select) {
		/* Connexion à la base de données */
		boolean resultat;
		String url = Configuration.getParam(Configuration.CONFIGSECTION_DB, Configuration.CONFIGPARAM_DB_URL);
		String utilisateur = Configuration.getParam(Configuration.CONFIGSECTION_DB, Configuration.CONFIGPARAM_DB_USER);
		String motDePasse = Configuration.getParam(Configuration.CONFIGSECTION_DB, Configuration.CONFIGPARAM_DB_PASSWORD);

		resultat = (url != null && utilisateur != null && motDePasse != null);
		if (resultat) {
			try {
				this.connection = (Connection) DriverManager.getConnection(url, utilisateur, motDePasse);
				Statement statement = this.connection.createStatement();
				this.results = statement.executeQuery(select);
				resultat = true;
			} catch (SQLException e) {
				this.connection = null;
				this.results = null;
				ProjectLogger.log(new DbConnection(), Level.WARNING,
						String.format("Erreur d'exécution de la requête '%1$s'", select), e);
			}
		}
		return resultat;
	}

	public boolean closeConnection() {
		if (this.connection != null) {
			try {
				this.connection.close();
				this.connection = null;
				return true;
			} catch (SQLException e) {
			}
		}
		return false;
	}

	public Collection<?> getModelsFromRequest(AbstractMapper callClass) throws SQLException, ClassNotFoundException {
		ArrayList<Object> myCol = new ArrayList<Object>();
		while (this.results.next()) {
			myCol.add(callClass.populateModel(this.results));
		}
		this.closeConnection();
		return myCol;
	}
}
