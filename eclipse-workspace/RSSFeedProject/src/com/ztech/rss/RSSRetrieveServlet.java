package com.ztech.rss;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.*;

/**
 * Servlet implementation class RSSRetrieveServlet
 */
@WebServlet("/RSSRetrieveServlet")
public class RSSRetrieveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RSSRetrieveServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String stringParsed = "";
		PrintWriter out = response.getWriter();
		URL url = null;
		InputStream is = null;
		RequestDispatcher rd;
		String stringRetrieved;
		BufferedReader bufferedReader;
		String input = request.getParameter("xyz");
		if (input.equals("Technology"))
			url = new URL("https://news.google.com/news/rss/headlines/section/topic/TECHNOLOGY?ned=in&hl=en-IN&gl=IN");
		else if (input.equals("Business"))
			url = new URL("https://news.google.com/news/rss/headlines/section/topic/BUSINESS?ned=in&hl=en-IN&gl=IN");
		else if (input.equals("Sports"))
			url = new URL("https://news.google.com/news/rss/headlines/section/topic/SPORTS?ned=in&hl=en-IN&gl=IN");
		else if (input.equals("Science"))
			url = new URL("https://news.google.com/news/rss/headlines/section/topic/SCIENCE?ned=in&hl=en-IN&gl=IN");
		else if (input.equals("World"))
			url = new URL(
					"https://news.google.com/news/rss/headlines/section/topic/WORLD.en_in/World?ned=in&hl=en-IN&gl=IN");
		else
			url = new URL(input);
		is = url.openStream();
		bufferedReader = new BufferedReader(new InputStreamReader(is));

		while ((stringRetrieved = bufferedReader.readLine()) != null) {
			// System.out.println(stringRetrieved);
			stringParsed += stringRetrieved;
		}
		try {

			JSONObject xmlJSONObj = XML.toJSONObject(stringParsed);
			JSONObject object1 = (JSONObject) xmlJSONObj.get("rss");
			JSONObject object2 = (JSONObject) object1.get("channel");
			JSONArray array = (JSONArray) object2.get("item");
			request.setAttribute("array", array);
			rd = request.getRequestDispatcher("jsp/rssfeeds.jsp");
			rd.forward(request, response);
		} catch (JSONException je) {
			System.out.println("No possible url");
		}

	}

}
