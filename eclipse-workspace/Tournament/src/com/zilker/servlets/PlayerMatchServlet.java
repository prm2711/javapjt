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
import com.zilker.dao.InsertData;
import com.zilker.dto.Match;
import com.zilker.dto.MatchWithName;

/**
 * Servlet implementation class PlayerMatchServlet
 */
@WebServlet("/PlayerMatchServlet")
public class PlayerMatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PlayerMatchServlet() {
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
		FindPlayerName findPlayer = new FindPlayerName();
		FindPlayerMatches findPlayerMatch = new FindPlayerMatches();
		ArrayList<MatchWithName> matchname = new ArrayList<MatchWithName>();
		int playerid;
		if (player.isEmpty()==true) {
			response.getWriter().append("Field Empty");
			rd = request.getRequestDispatcher("playermatch.jsp");
			rd.include(request, response);
		} else {

			playerid = findPlayer.retrievePlayerID(player);

			if (playerid == -1) {
				response.getWriter().append("Enter valid Player");
				rd = request.getRequestDispatcher("playermatch.jsp");
				rd.include(request, response);
			} else {
				matchname = findPlayerMatch.retrieveMatch(playerid);
				if(matchname.isEmpty()==false) {
				rd = request.getRequestDispatcher("matchesplayer.jsp");
				request.setAttribute("list", matchname);
				rd.forward(request, response);
				}
				else {
					rd = request.getRequestDispatcher("playermatch.jsp");
					response.getWriter().append("No match");
					rd.include(request, response);
				}
			}
		}
	}

}
