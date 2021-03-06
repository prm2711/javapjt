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
import com.zilker.dto.Match;
import com.zilker.dto.MatchWithName;

/**
 * Servlet implementation class TwoPlayerMatchServlet
 */
@WebServlet("/TwoPlayerMatchServlet")
public class TwoPlayerMatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TwoPlayerMatchServlet() {
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
		String player1 = request.getParameter("player1");
		int player1id, player2id;
		String player2 = request.getParameter("player2");
		FindPlayerMatches findPlayerMatch = new FindPlayerMatches();
		FindPlayerName findPlayer = new FindPlayerName();
		ArrayList<MatchWithName> matchname = new ArrayList<MatchWithName>();
		if (player1.isEmpty() == true || player2.isEmpty() == true) {
			response.getWriter().append("Field Empty");
			rd = request.getRequestDispatcher("twoplayermatch.jsp");
			rd.include(request, response);
		} else {

			player1id = findPlayer.retrievePlayerID(player1);
			player2id = findPlayer.retrievePlayerID(player2);
			if (player1id == -1 || player2id == -1) {
				response.getWriter().append("Enter valid Player");
				rd = request.getRequestDispatcher("twoplayermatch.jsp");
				rd.include(request, response);
			} else {
				matchname = findPlayerMatch.retrieveResult(player1id, player2id);
				if (matchname.isEmpty() == false) {
					rd = request.getRequestDispatcher("matchesplayer.jsp");
					request.setAttribute("list", matchname);
					rd.forward(request, response);
				} else {
					rd = request.getRequestDispatcher("twoplayermatch.jsp");
					response.getWriter().append("No such match");
					rd.include(request, response);
				}
			}
		}

	}

}
