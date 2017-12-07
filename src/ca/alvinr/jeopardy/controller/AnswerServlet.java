package ca.alvinr.jeopardy.controller;

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

import ca.alvinr.jeopardy.model.QuestionSet;

/**
 * Servlet implementation class AnswerServlet
 */
@WebServlet("/AnswerServlet")
public class AnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AnswerServlet() {
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

		@SuppressWarnings("unchecked")
		ArrayList<String> questionsTackled = (ArrayList<String>) session.getAttribute("questionsTackled");

		if (request.getParameter("skip") != null) {
			response.sendRedirect("Jeopardy.jsp");
			questionsTackled.add(session.getAttribute("chosenQuestionID").toString());
			session.setAttribute("questionsTackled", questionsTackled);
			return;
		}

		if (request.getParameter("chosenAnswer") != null) {
			String chosenAnswer = request.getParameter("chosenAnswer");
			request.setAttribute("chosenAnswer", chosenAnswer);

			try {
				QuestionSet qs = QuestionSet.getInstance();

				String rightAnswer = qs.getCategoryQuestionAnswer(
						Integer.parseInt(session.getAttribute("chosenQuestionID").toString().substring(1, 2)),
						Integer.parseInt(session.getAttribute("chosenQuestionID").toString().substring(5, 6)));

				if (!chosenAnswer.equals(rightAnswer)) {
					request.setAttribute("incorrectAnswer", chosenAnswer);
				} else {
					session.setAttribute("score", Integer.parseInt(session.getAttribute("score").toString())
							+ (200 * Integer.parseInt(session.getAttribute("level").toString())));
				}
				request.setAttribute("correctAnswer", rightAnswer);
				request.setAttribute("isAnswered", true);
			} catch (Exception e) {
				response.sendRedirect("http://example.com/EXCEPTION:" + e.getMessage());
				return;
			}

			questionsTackled.add(session.getAttribute("chosenQuestionID").toString());
			session.setAttribute("questionsTackled", questionsTackled);

			RequestDispatcher rd = request.getRequestDispatcher("Answer.jsp");
			rd.forward(request, response);
		}

		response.sendRedirect("Jeopardy.jsp");
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
