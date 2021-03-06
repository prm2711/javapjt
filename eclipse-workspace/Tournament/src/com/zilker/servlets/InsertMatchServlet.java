package com.zilker.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zilker.dao.FindCountry;
import com.zilker.dao.FindPlayerName;
import com.zilker.dao.FindTournamentName;
import com.zilker.dao.InsertData;
import com.zilker.dto.Match;

/**
 * Servlet implementation class InsertMatchServlet
 */
@WebServlet("/InsertMatchServlet")
public class InsertMatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertMatchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		RequestDispatcher rd;
		String tourname = request.getParameter("tourname");
		String player1 = request.getParameter("player1");
		String player2 = request.getParameter("player2");
		String winner = request.getParameter("winner");
		String loser = request.getParameter("loser");
		String status = request.getParameter("status");
		String score = request.getParameter("score");
		String country1, country2;
		Match match = new Match();
		InsertData insertData = new InsertData();
		FindTournamentName findTour = new FindTournamentName();
		FindPlayerName findPlayer = new FindPlayerName();
		FindCountry findCountry = new FindCountry();
		int tour, play1, play2, win, lose;
		tour = findTour.retrieveTournamentID(tourname);
		play1 = findPlayer.retrievePlayerID(player1);
		play2 = findPlayer.retrievePlayerID(player2);
		win = findPlayer.retrievePlayerID(winner);
		lose = findPlayer.retrievePlayerID(loser);
		country1 = findCountry.retrieveCountry(play1);
		country2 = findCountry.retrieveCountry(play2);
		if (tour == -1) {
			response.getWriter().append("Enter valid Tournament");
			rd = request.getRequestDispatcher("insertmatch.jsp");
			rd.include(request, response);
		} else if (play1 == -1 || play2 == -1 || win == -1 || lose == -1) {
			response.getWriter().append("Enter valid Player");
			rd = request.getRequestDispatcher("insertmatch.jsp");
			rd.include(request, response);
		} else if (status.equals("Complete") == false && status.equals("Suspended") == false) {
			response.getWriter().append("Enter valid Status");
			rd = request.getRequestDispatcher("insertmatch.jsp");
			rd.include(request, response);
		} else if (findCountry.compareCountry(country1, country2) == false) {
			response.getWriter().append("Both players are from same country");
			rd = request.getRequestDispatcher("insertmatch.jsp");
			rd.include(request, response);
		} else {
			match.setTourId(tour);
			match.setPlay1Id(play1);
			match.setPlay2Id(play2);
			match.setWinner(win);
			match.setLoser(lose);
			match.setStatus(status);
			match.setScore(score);
			insertData.insertMatch(match);
			response.getWriter().append("Data inserted Successfully");
			rd = request.getRequestDispatcher("home.jsp");
			rd.include(request, response);
		}
	}

}
