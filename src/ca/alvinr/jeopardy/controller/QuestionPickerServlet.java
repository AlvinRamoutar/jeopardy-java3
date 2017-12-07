package ca.alvinr.jeopardy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(-1);
		
		String cq = request.getParameter("chosenQuestion");
		session.setAttribute("chosenQuestionID", cq);

		int category;
		int level;
		category = Integer.parseInt(cq.substring(1, 2));
		level = Integer.parseInt(cq.substring(5, 6));
		
		try {
			QuestionSet qs = QuestionSet.getInstance();
			
			session.setAttribute("category", qs.getCategoryName(category));
			session.setAttribute("level", level);
			session.setAttribute("worth", 200 * level);
			session.setAttribute("question", qs.getCategoryQuestion(category, level));
			session.setAttribute("a", qs.getCategorySpecificChoice(category, level, 'a'));
			session.setAttribute("b", qs.getCategorySpecificChoice(category, level, 'b'));
			session.setAttribute("c", qs.getCategorySpecificChoice(category, level, 'c'));
			session.setAttribute("d", qs.getCategorySpecificChoice(category, level, 'd'));

		} catch(Exception e) {} 
			
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
