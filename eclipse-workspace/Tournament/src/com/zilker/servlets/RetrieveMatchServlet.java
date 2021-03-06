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
import com.zilker.dto.Match;
import com.zilker.dto.MatchWithName;
import com.zilker.dto.Player;

/**
 * Servlet implementation class RetrieveMatchServlet
 */
@WebServlet("/RetrieveMatchServlet")
public class RetrieveMatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveMatchServlet() {
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
		
		RetrieveData retrieveData=new RetrieveData();
		ArrayList<MatchWithName> matchname = new ArrayList<MatchWithName>();
		RequestDispatcher rd;
		matchname=retrieveData.retrieveMatches();
		rd = request.getRequestDispatcher("retrievematch.jsp");
		request.setAttribute("list",matchname);
		rd.forward(request, response);
	}

}
