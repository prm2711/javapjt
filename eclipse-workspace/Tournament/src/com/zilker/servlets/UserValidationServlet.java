package com.zilker.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zilker.dao.RetrieveData;
import com.zilker.dao.UserValidation;
import com.zilker.dto.Player;
import com.zilker.utilities.AdminValidation;

/**
 * Servlet implementation class UserValidationServlet
 */
@WebServlet("/UserValidationServlet")
public class UserValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserValidationServlet() {
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
		String user = request.getParameter("username");
		String password = request.getParameter("password");
		UserValidation userValidate = new UserValidation();
		RetrieveData retrieveData = new RetrieveData();
		ArrayList<Player> play = new ArrayList<Player>();
		RequestDispatcher rd;
		HttpSession session = request.getSession();
		boolean check;

		check = userValidate.userValidate(user, password);
		play = retrieveData.retrievePlayer();
		if (check == true && user.equals("admin")) {
			session.setAttribute("name", "admin");
			session.setAttribute("username", "admin");
			rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		} else if (check == true) {
			session.setAttribute("name", "user");
			session.setAttribute("username", user);
			rd = request.getRequestDispatcher("userhome.jsp");
			request.setAttribute("list", play);
			rd.forward(request, response);
		} else {
			response.getWriter().append("<h1>Invalid</h1>");
			rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}
	}

}
