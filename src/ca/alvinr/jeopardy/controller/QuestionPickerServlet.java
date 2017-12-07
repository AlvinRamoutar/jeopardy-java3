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
import ca.alvinr.jeopardy.model.QuestionSet;

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
		
		PrintWriter pw = response.getWriter();
		pw.println("hey im alive");
		
		try {
			QuestionSet qs = QuestionSet.getInstance();
			
			request.setAttribute("category", qs.getCategoryName(category));
			request.setAttribute("worth", 200 * level);
			request.setAttribute("question", qs.getCategoryQuestion(category, level));
			request.setAttribute("a", qs.getCategorySpecificChoice(category, level, 'a'));
			request.setAttribute("b", qs.getCategorySpecificChoice(category, level, 'b'));
			request.setAttribute("c", qs.getCategorySpecificChoice(category, level, 'c'));
			request.setAttribute("d", qs.getCategorySpecificChoice(category, level, 'd'));

		} catch(Exception e) {	pw.println(e.getMessage()); } 
			
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
