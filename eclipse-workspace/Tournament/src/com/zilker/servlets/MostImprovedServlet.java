package com.zilker.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zilker.dao.RetrieveData;
import com.zilker.dto.Player;

/**
 * Servlet implementation class MostImprovedServlet
 */
@WebServlet("/MostImprovedServlet")
public class MostImprovedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostImprovedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RetrieveData retrieveImproved=new RetrieveData();
		ArrayList<Player> player = new ArrayList<Player>();
		RequestDispatcher rd;
		player=retrieveImproved.findMostImproved();
		rd = request.getRequestDispatcher("mostimproved.jsp");
		request.setAttribute("player",player);
		rd.forward(request, response);
	}

}
