package com.zilker.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import java.sql.PreparedStatement;

import com.zilker.constant.Constants;
import com.zilker.display.DisplayPlayer;
import com.zilker.dto.Match;
import com.zilker.utilities.ConnectionSetup;

public class FindPlayerMatches {
	private Logger logger = Logger.getLogger(FindPlayerMatches.class.getName());

	public void retrieveMatch(int pid) {
		Connection connection = null;
		ConnectionSetup conn = new ConnectionSetup();
		DisplayPlayer player = new DisplayPlayer();
		connection = conn.getConnection();

		Statement statement = null;
		ResultSet result = null;
		Integer winner = 0, loser = 0, tourid = 0, play1id = 0, play2id = 0;
		String status = null, score = null;
		PreparedStatement prep = null;
		try {

			// Execute a query
			statement = connection.createStatement();

			prep = connection.prepareStatement(Constants.FINDMATCH);
			prep.setInt(1, pid);
			prep.setInt(2, pid);
			result = prep.executeQuery();
			if (result == null) {
				logger.info("No record found.");
				return;
			}
			while (result.next()) {
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
			conn.closePreparedStatement(prep);
			conn.closeStatement(statement);
			conn.closeConnection(connection);

		}

	}

	public void retrieveTournament(int pid, int tournamentid) {
		Connection connection = null;
		ConnectionSetup conn = new ConnectionSetup();
		DisplayPlayer player = new DisplayPlayer();
		connection = conn.getConnection();

		Statement statement = null;
		ResultSet result = null;
		Integer winner = 0, loser = 0, tourid = 0, play1id = 0, play2id = 0;
		String status = null, score = null;
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
				return;
			}
			while (result.next()) {
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
			conn.closePreparedStatement(prep);
			conn.closeStatement(statement);
			conn.closeConnection(connection);

		}

	}

	public void retrieveResult(int p1id, int p2id) {
		Connection connection = null;
		ConnectionSetup conn = new ConnectionSetup();
		DisplayPlayer player = new DisplayPlayer();
		connection = conn.getConnection();
		PreparedStatement prep = null;
		Statement statement = null;
		ResultSet result = null;
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
				return;
			}
			while (result.next()) {
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
			conn.closePreparedStatement(prep);
			conn.closeStatement(statement);

			conn.closeConnection(connection);

		}

	}
}
