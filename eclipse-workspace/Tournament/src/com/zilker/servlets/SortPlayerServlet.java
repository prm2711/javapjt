package com.zilker.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zilker.dao.SortData;
import com.zilker.dto.Player;

/**
 * Servlet implementation class SortPlayerServlet
 */
@WebServlet("/SortPlayerServlet")
public class SortPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SortPlayerServlet() {
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
		SortData sortData=new SortData();
		ArrayList<Player> play = new ArrayList<Player>();
		RequestDispatcher rd;
		play=sortData.sortName();
		rd = request.getRequestDispatcher("retrieveplayer.jsp");
		request.setAttribute("play",play);
		rd.forward(request, response);
	}

}
