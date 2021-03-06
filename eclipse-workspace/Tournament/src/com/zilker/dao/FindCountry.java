package com.zilker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import com.zilker.constant.Constants;
import com.zilker.utilities.ConnectionSetup;

public class FindCountry {
	private Logger logger = Logger.getLogger(FindPlayerName.class.getName());

	public String retrieveCountry(int playerid) {
		Connection connection = null;
		ConnectionSetup conn = new ConnectionSetup();

		connection = conn.getConnection();
		PreparedStatement prep = null;
		Statement statement = null;
		ResultSet result = null;
		String country = null;
		try {

			// Execute a query
			statement = connection.createStatement();

			prep = connection.prepareStatement(Constants.RETRIEVECOUNTRY);
			prep.setInt(1, playerid);
			result = prep.executeQuery();
			if (result == null) {
				logger.info("No record found.");
				return null;
			}
			while (result.next()) {

				country = result.getString(1);

			}

		} catch (SQLException se) {
			logger.info("SQL Exception");
		} finally {
			// finally block used to close resources
			conn.closeResult(result);
			conn.closePreparedStatement(prep);
			conn.closeStatement(statement);
			conn.closeConnection(connection);

		}
		return country;
	}

	public boolean compareCountry(String country1, String country2) {
		// TODO Auto-generated method stub
		if (country1.equals(country2))
			return false;
		else
			return true;
	}

}
