package com.zilker.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.zilker.constant.Constants;
import com.zilker.dto.Match;
import com.zilker.dto.MatchWithName;
import com.zilker.dto.Player;
import com.zilker.utilities.ConnectionSetup;

public class RetrieveData {

	private Logger logger = Logger.getLogger(RetrieveData.class.getName());

	public ArrayList<Player> retrievePlayer() {
		Connection connection = null;
		ConnectionSetup conn = new ConnectionSetup();
		connection = conn.getConnection();
		ArrayList<Player> play = new ArrayList<Player>();
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
				return null;
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
				play.add(new_player);

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
		return play;
	}

	

	public ArrayList<Player> findMostImproved() {
		Connection connection = null;
		ConnectionSetup conn = new ConnectionSetup();
		connection = conn.getConnection();
		ArrayList<Player> play = new ArrayList<Player>();
		Integer origpoints = 0, newpoints = 0, numbermatch = 0, won = 0, lost = 0, draw = 0;
		String player = null, country = null;
		Statement statement = null;
		ResultSet result = null;
		try {

			// Execute a query
			statement = connection.createStatement();
			result = statement.executeQuery(Constants.MOSTIMPROVEDPLAYER);
			if (result == null) {
				logger.info("No record found.");
				return null;
			}

			while (result.next()) {
				player = result.getString(2);
				country = result.getString(3);
				origpoints = result.getInt(4);
				newpoints = result.getInt(5);
				numbermatch = result.getInt(6);
				won = result.getInt(7);
				lost = result.getInt(8);
				draw = result.getInt(9);
				Player new_player = new Player(player, country, origpoints, newpoints, numbermatch, won, lost, draw);
				play.add(new_player);

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
		return play;
	}

	public ArrayList<MatchWithName> retrieveMatches() {
		Connection connection = null;
		ConnectionSetup conn = new ConnectionSetup();
		ArrayList<MatchWithName> matches = new ArrayList<MatchWithName>();
		FindPlayerName findPlayer = new FindPlayerName();
		FindTournamentName findTour = new FindTournamentName();
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
				return null;
			}
			while (result.next()) {
				count++;
				tourid = result.getInt(1);
				play1id = result.getInt(2);
				play2id = result.getInt(3);
				winner = result.getInt(4);
				loser = result.getInt(5);
				status = result.getString(6);
				score = result.getString(7);
				MatchWithName match = new MatchWithName();
				match.setTour(findTour.retrieveTournament(tourid));
				match.setPlay1(findPlayer.retrieveName(play1id));
				match.setPlay2(findPlayer.retrieveName(play2id));
				match.setWinner(findPlayer.retrieveName(winner));
				match.setLoser(findPlayer.retrieveName(loser));
				match.setStatus(status);
				match.setScore(score);
				matches.add(match);

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
		return matches;
	}
}
