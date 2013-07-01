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

	public static DbConnection getDbConnection() {
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

	/**
	 * execute a selecy query and store result in resultset.
	 *
	 * @param select
	 * @return true of false
	 */
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

	/**
	 * execute an update query and return the number of rows
	 *
	 * @param update
	 * @return -1 in fail 0 if no row updated and the number of row in case of
	 * success
	 */
	public int executeUpdateQuery(String update) {
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
				int nbRows = statement.executeUpdate(update);
				this.closeConnection();
				return nbRows;
			} catch (SQLException e) {
				this.connection = null;
				this.results = null;
				ProjectLogger.log(new DbConnection(), Level.WARNING,
						String.format("Erreur d'exécution de la requête '%1$s'", update), e);
			}
		}
		return -1;
	}

	/**
	 * execute the insert query
	 *
	 * @param insert
	 * @return return the new id of inserted row, -1 if fail, 0 if nothing
	 * inserted
	 */
	public int executeInsertQuery(String insert) {
		/* Connexion à la base de données */
		boolean settingsOk;
		int result;
		String url = Configuration.getParam(Configuration.CONFIGSECTION_DB, Configuration.CONFIGPARAM_DB_URL);
		String utilisateur = Configuration.getParam(Configuration.CONFIGSECTION_DB, Configuration.CONFIGPARAM_DB_USER);
		String motDePasse = Configuration.getParam(Configuration.CONFIGSECTION_DB, Configuration.CONFIGPARAM_DB_PASSWORD);

		settingsOk = (url != null && utilisateur != null && motDePasse != null);
		if (settingsOk) {
			try {
				this.connection = (Connection) DriverManager.getConnection(url, utilisateur, motDePasse);
				PreparedStatement statement = this.connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
				int nbRows = statement.executeUpdate();
				if (nbRows > 0) {
					ResultSet generatedKeys = statement.getGeneratedKeys();
					if (generatedKeys.next()) {
						result = generatedKeys.getInt(1);
					} else {
						return -1;
					}
					this.closeConnection();

					return result;
				}
			} catch (SQLException e) {
				this.connection = null;
				this.results = null;
				ProjectLogger.log(new DbConnection(), Level.WARNING,
						String.format("Erreur d'exécution de la requête '%1$s'", insert), e);
			}
		}
		return -1;
	}

	/**
	 * close the connection with the database
	 *
	 * @return
	 */
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

	/**
	 * transform resultsets in objects
	 *
	 * @param callClass the class wich implement populateModel to convert
	 * resultSet in object
	 * @return a collection of object from callclass
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public Collection<?> getModelsFromRequest(AbstractMapper callClass) throws SQLException, ClassNotFoundException {
		ArrayList<Object> myCol = new ArrayList<>();
		while (this.results.next()) {
			myCol.add(callClass.populateModel(this.results));
		}
		this.closeConnection();
		return myCol;
	}

	/**
	 * transform resultset in object
	 *
	 * @param callClass the class wich implement populateModel to convert
	 * resultSet in object
	 * @return an object from callclass
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public Object getModelFromRequest(AbstractMapper callClass) throws SQLException, ClassNotFoundException {
		Object myObj;

		if (this.results.next()) {
			myObj = callClass.populateModel(this.results);
		} else {
			return callClass.getEmptyModel();
		}
		this.closeConnection();

		return myObj;
	}
}
