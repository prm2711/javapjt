package com.zilker.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import com.zilker.constant.Constants;
import com.zilker.display.DisplayPlayer;
import com.zilker.dto.Match;
import com.zilker.dto.Player;
import com.zilker.utilities.ConnectionSetup;

public class RetrieveData {

	private Logger logger = Logger.getLogger(RetrieveData.class.getName());

	public void retrievePlayer() {
		Connection connection = null;
		ConnectionSetup conn = new ConnectionSetup();
		DisplayPlayer player1 = new DisplayPlayer();
		connection = conn.getConnection();

		Statement statement = null;
		ResultSet result = null;
		Integer origpoints = 0, newpoints = 0, numbermatch = 0, won = 0, lost = 0, draw = 0;
		String player = null, country = null;
		try {

			// Execute a query
			statement = connection.createStatement();

			result = statement.executeQuery(Constants.RET);
			if (result == null) {
				logger.info("No record found.");
				return;
			}
			while (result.next()) {
				player = result.getString(1);
				country = result.getString(2);
				origpoints = result.getInt(3);
				newpoints = result.getInt(4);
				numbermatch = result.getInt(5);
				won = result.getInt(6);
				lost = result.getInt(7);
				draw = result.getInt(8);
				Player new_player = new Player(player, country, origpoints, newpoints, numbermatch, won, lost, draw);
				player1.display(new_player);

			}

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} finally {
			// finally block used to close resources
			conn.closeResult(result);
			conn.closeStatement(statement);

			conn.closeConnection(connection);

		}

	}

	public void retrieveMatch() {
		Connection connection = null;
		ConnectionSetup conn = new ConnectionSetup();
		DisplayPlayer player = new DisplayPlayer();
		connection = conn.getConnection();

		Statement statement = null;
		ResultSet result = null;
		Integer play1id = 0, play2id = 0, winner = 0, loser = 0, tourid = 0;
		int count = 1;
		String status = null, score = null;
		try {

			// Execute a query
			statement = connection.createStatement();
			result = statement.executeQuery(Constants.RETMATCH);
			if (result == null) {
				logger.info("No record found.");
				return;
			}
			while (result.next()) {
				logger.info("Match " + count);
				count++;
				tourid = result.getInt(1);
				play1id = result.getInt(2);
				play2id = result.getInt(3);
				winner = result.getInt(4);
				loser = result.getInt(5);
				status = result.getString(6);
				score = result.getString(7);
				Match match = new Match();
				match.setTourId(tourid);
				match.setPlay1Id(play1id);
				match.setPlay2Id(play2id);
				match.setWinner(winner);
				match.setLoser(loser);
				match.setStatus(status);
				match.setScore(score);
				player.disp(match);

			}

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} finally {
			// finally block used to close resources
			conn.closeResult(result);
			conn.closeStatement(statement);

			conn.closeConnection(connection);

		}

	}

	public void findMostImproved() {
		Connection connection = null;
		ConnectionSetup conn = new ConnectionSetup();
		connection = conn.getConnection();

		Statement statement = null;
		ResultSet result = null;
		String player = null;
		int difference = 0;
		try {

			// Execute a query
			statement = connection.createStatement();
			result = statement.executeQuery(Constants.MOSTIMPROVEDPLAYER);
			if (result == null) {
				logger.info("No record found.");
				return;
			}
			logger.info("Most Improved Player: ");
			while (result.next()) {
				player = result.getString(1);
				difference = result.getInt(2);
				logger.info(player + " with improvement of  " + difference);
			}

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} finally {
			// finally block used to close resources
			conn.closeResult(result);
			conn.closeStatement(statement);

			conn.closeConnection(connection);

		}

	}

}
