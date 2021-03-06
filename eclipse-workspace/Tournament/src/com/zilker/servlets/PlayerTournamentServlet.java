package com.zilker.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zilker.dao.FindPlayerMatches;
import com.zilker.dao.FindPlayerName;
import com.zilker.dao.FindTournamentName;
import com.zilker.dto.Match;
import com.zilker.dto.MatchWithName;

/**
 * Servlet implementation class PlayerTournamentServlet
 */
@WebServlet("/PlayerTournamentServlet")
public class PlayerTournamentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PlayerTournamentServlet() {
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
		String player = request.getParameter("player");
		int playerid, tourid;
		String tour = request.getParameter("tour");
		FindPlayerName findPlayer = new FindPlayerName();
		FindPlayerMatches findPlayerMatch = new FindPlayerMatches();
		FindTournamentName findTour = new FindTournamentName();
		ArrayList<MatchWithName> matches = new ArrayList<MatchWithName>();
		if (player.isEmpty() == true || tour.isEmpty() == true) {
			response.getWriter().append("Field Empty");
			rd = request.getRequestDispatcher("playertour.jsp");
			rd.include(request, response);
		} else {

			playerid = findPlayer.retrievePlayerID(player);
			tourid = findTour.retrieveTournamentID(tour);
			if (playerid == -1) {
				response.getWriter().append("Enter valid Player");
				rd = request.getRequestDispatcher("playertour.jsp");
				rd.include(request, response);
			} else if (tourid == -1) {
				response.getWriter().append("Enter valid Tournament");
				rd = request.getRequestDispatcher("playertour.jsp");
				rd.include(request, response);
			} else {
				matches = findPlayerMatch.retrieveTournament(playerid, tourid);
				if (matches.isEmpty() == false) {
					rd = request.getRequestDispatcher("matchesplayer.jsp");
					request.setAttribute("list", matches);
					rd.forward(request, response);
				} else {
					rd = request.getRequestDispatcher("playertour.jsp");
					response.getWriter().append("No match in the tournament");
					rd.include(request, response);
				}
			}
		}

	}

}
