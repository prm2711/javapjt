package com.zilker.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

import java.sql.PreparedStatement;

import com.zilker.constant.Constants;
import com.zilker.dto.MatchWithName;
import com.zilker.utilities.ConnectionSetup;

public class FindPlayerMatches {
	private Logger logger = Logger.getLogger(FindPlayerMatches.class.getName());

	public ArrayList<MatchWithName> retrieveMatch(int pid) {
		Connection connection = null;
		ConnectionSetup conn = new ConnectionSetup();
		connection = conn.getConnection();
		ArrayList<MatchWithName> matches = new ArrayList<MatchWithName>();
		Statement statement = null;
		ResultSet result = null;
		Integer winner = 0, loser = 0, tourid = 0, play1id = 0, play2id = 0;
		String status = null, score = null;
		PreparedStatement prep = null;
		FindPlayerName findPlayer = new FindPlayerName();
		FindTournamentName findTour = new FindTournamentName();
		try {

			// Execute a query
			statement = connection.createStatement();

			prep = connection.prepareStatement(Constants.FINDMATCH);
			prep.setInt(1, pid);
			prep.setInt(2, pid);
			result = prep.executeQuery();
			if (result == null) {
				logger.info("No record found.");
				return null;
			}
			while (result.next()) {
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
			conn.closePreparedStatement(prep);
			conn.closeStatement(statement);
			conn.closeConnection(connection);

		}
		return matches;
	}

	
	
	public ArrayList<MatchWithName> retrieveTournament(int pid, int tournamentid) {
		Connection connection = null;
		ConnectionSetup conn = new ConnectionSetup();
		connection = conn.getConnection();
		ArrayList<MatchWithName> matches = new ArrayList<MatchWithName>();
		Statement statement = null;
		ResultSet result = null;
		Integer winner = 0, loser = 0, tourid = 0, play1id = 0, play2id = 0;
		String status = null, score = null;
		FindPlayerName findPlayer = new FindPlayerName();
		FindTournamentName findTour = new FindTournamentName();
		PreparedStatement prep = null;
		try {

			// Execute a query
			statement = connection.createStatement();

			prep = connection.prepareStatement(Constants.FINDPLAYERTOURNAMENT);
			prep.setInt(1, pid);
			prep.setInt(2, pid);
			prep.setInt(3, tournamentid);
			result = prep.executeQuery();
			if (result == null) {
				logger.info("No record found.");
				return null;
			}
			while (result.next()) {
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
			conn.closePreparedStatement(prep);
			conn.closeStatement(statement);
			conn.closeConnection(connection);

		}
		return matches;
	}

	public ArrayList<MatchWithName> retrieveResult(int p1id, int p2id) {
		Connection connection = null;
		ConnectionSetup conn = new ConnectionSetup();
		ArrayList<MatchWithName> matches = new ArrayList<MatchWithName>();
		connection = conn.getConnection();
		PreparedStatement prep = null;
		Statement statement = null;
		ResultSet result = null;
		FindPlayerName findPlayer = new FindPlayerName();
		FindTournamentName findTour = new FindTournamentName();
		Integer winner = 0, loser = 0, tourid = 0, play1id = 0, play2id = 0;
		String status = null, score = null;
		try {

			// Execute a query
			statement = connection.createStatement();

			prep = connection.prepareStatement(Constants.FINDRESULT);
			prep.setInt(1, p1id);
			prep.setInt(2, p2id);
			prep.setInt(3, p2id);
			prep.setInt(4, p1id);
			result = prep.executeQuery();
			if (result == null) {
				logger.info("No record found.");
				return null;
			}
			while (result.next()) {
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
			conn.closePreparedStatement(prep);
			conn.closeStatement(statement);

			conn.closeConnection(connection);

		}
		return matches;
	}
}
