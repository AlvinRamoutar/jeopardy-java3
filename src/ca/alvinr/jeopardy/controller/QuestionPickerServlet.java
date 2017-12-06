package ca.alvinr.jeopardy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import ca.alvinr.jeopardy.JeopardyException;
import ca.alvinr.jeopardy.model.JSONHandler;

/**
 * Servlet implementation class QuestionPickedServlet
 */
@WebServlet("/QuestionPickerServlet")
public class QuestionPickerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QuestionPickerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cq = request.getParameter("chosenQuestion");

		int category;
		int level;
		category = Integer.parseInt(cq.substring(1, 2));
		level = Integer.parseInt(cq.substring(5, 6));
		
		/*
		try {
			
			JSONHandler jH = new JSONHandler("WebContent/data.json");
			JSONObject qJSON = jH.getJSON();
			
			request.setAttribute("category", qJSON.getJSONObject("c" + category).get("name"));
			request.setAttribute("worth", 200 * level);
			request.setAttribute("question", qJSON.getJSONObject("c" + category).getJSONObject("lv" + level).get("question"));
			request.setAttribute("a", qJSON.getJSONObject("c" + category).getJSONObject("lv" + level).get("a"));
			request.setAttribute("b", qJSON.getJSONObject("c" + category).getJSONObject("lv" + level).get("b"));
			request.setAttribute("c", qJSON.getJSONObject("c" + category).getJSONObject("lv" + level).get("c"));
			request.setAttribute("d", qJSON.getJSONObject("c" + category).getJSONObject("lv" + level).get("d"));

			//PrintWriter pw = response.getWriter();
			//pw.print("Category: " + category + ", Level: " + level);
			 
		} catch(JeopardyException je) {
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
			
		RequestDispatcher rd = request.getRequestDispatcher("Answer.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
